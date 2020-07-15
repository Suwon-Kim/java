import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.SynchronousQueue;

public class ChatThread extends Thread {
	private Socket sock;
	private Vector<User> allUserList;
	private Vector<User> waitUserList;
	private Vector<ChatRoom> allChatRoomList;
	private User user;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Hashtable<User, ObjectOutputStream> ht;
	private SendData sd;
	private String id;
	private ChatRoom chroom;
	private String title;
	private Vector<ChatRoomInfo> allChatRoomInfo;
	private Vector<ChatRoomInfo> vec;
	private int count;
	private boolean stopFlag;

	public ChatThread(Socket sock, Vector<User> allUserList, Vector<User> waitUserList,
			Vector<ChatRoom> allChatRoomList, Hashtable<User, ObjectOutputStream> ht) {
		this.sock = sock;
		this.allUserList = allUserList;
		this.waitUserList = waitUserList;
		this.allChatRoomList = allChatRoomList;
		this.ht = ht;

		try {
			oos = new ObjectOutputStream(sock.getOutputStream());
			ois = new ObjectInputStream(sock.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run() {

		try {

			Object obj = null;
			while ((obj = ois.readObject()) != null) {
				sd = (SendData) obj;
				int code = sd.getCode();
				System.out.println("�����ڵ� " + code);

				switch (code) {

				// ����
				case 100:
					// ���� �ߺ� Ȯ��
					int state = ServerProtocol.ENTRANCE_SUCCESS;
					id = String.valueOf(sd.getObj()[0]); // ������ ����
					for (int i = 0; i < allUserList.size(); i++) {
						if (id.equals(allUserList.get(i).getId())) {

							state = ServerProtocol.ENTRANCE_FAIL;
							sd = new SendData(code);
							oos.writeObject(sd);
							oos.flush();
							oos.reset();
							return;
						}
					}
					// ���� ����
					if (state == ServerProtocol.ENTRANCE_SUCCESS) {
						user = new User(id, "����");

						allUserList.add(user);
						waitUserList.add(user);

						allChatRoomInfo = new Vector<ChatRoomInfo>();
						if (allChatRoomList.size() > 0) {
							for (int i = 0; i < allChatRoomList.size(); i++) {
								allChatRoomInfo.add(allChatRoomList.get(i).getRoomInfo());
							}
						}

						WaitingRoom wr = new WaitingRoom(allUserList, waitUserList, allChatRoomInfo);

						ht.put(user, oos);
						// sd = new
						// SendData(ServerProtocol.ENTRANCE_SUCCESS,user.getId());
						sd = new SendData(ServerProtocol.ENTRANCE_SUCCESS, wr);
						oos.writeObject(sd);
						oos.flush();
						oos.reset();

						if (waitUserList.size() > 1) {
							updateWaitList(waitUserList, allChatRoomList, oos);
							broadcast(1000);
						} else if (waitUserList.size() == 1) {
							broadcast(1000);
						}
					}
					break;
				// �� �����
				case 110:
					obj = ht.get(user);
					ObjectOutputStream oos1 = (ObjectOutputStream) obj;
					ChatRoomInfo ri = (ChatRoomInfo) sd.getObj()[0];
					int flag = 0;

					for (int i = 0; i < allChatRoomList.size(); i++) {
						if (ri.getTitle().equals(allChatRoomList.get(i).getRoomInfo().getTitle())) {
							sd = new SendData(1011);
							oos1.writeObject(sd);
							oos1.flush();
							oos1.reset();
							flag = 1;
							break;
						}
					}

					// ä�ù� ����
					if (flag == 0) {
						chroom = new ChatRoom(ri);
						title = ri.getTitle();
						waitUserList.remove(user);
						user.setChatLocation(title.trim());
						// chatRoomInfo�� �� ���̵� �־���
						for (int i = 0; i < allUserList.size(); i++) {
							if (allUserList.get(i).equals(user)) {
								allUserList.get(i).setChatLocation(title);
							}
						}
						chroom.getRoomInfo().getChatRoomUserList().add(id.trim());
						/////////////////////////////////////

						allChatRoomList.add(chroom);

						sd = new SendData(1010, ri);
						try {
							oos1.writeObject(sd);
							oos1.flush();
							oos1.reset();
						} catch (Exception e) {
							e.printStackTrace();
						}

						if (waitUserList.size() >= 1) {
							updateWaitList(waitUserList, allChatRoomList, oos1);
						}
					}

					break;

				// ä�ù� �����ϱ�
				case 120:
					// ChatRoomInfo , chatRoomUserList:Vector<User>
					title = String.valueOf(sd.getObj()[0]);
					ObjectOutputStream oos2 = (ObjectOutputStream) ht.get(user);
					// boolean flag1 = false;
					int size = 0;
					Vector<String> chatuserlist = null;
					for (int i = 0; i < allChatRoomList.size(); i++) {

						size = allChatRoomList.get(i).getRoomInfo().getChatRoomUserList().size();

						if (allChatRoomList.get(i).getRoomInfo().getTitle().equals(title)) {
							// �ִ��ο�
							if (allChatRoomList.get(i).getRoomInfo().getMaxPeople() == size) {
								sd = new SendData(1021, allChatRoomList.get(i).getRoomInfo());
								try {
									oos2.writeObject(sd);
									oos2.flush();
									oos2.reset();
									break;
								} catch (Exception e) {
									e.printStackTrace();
									System.out.println("MultiChatThread  -sendmsg-");
								}

							} else {
								int state1 = 0;

								for (String u : allChatRoomList.get(i).getKickout_User()) {
									if (u.equals(user.getId())) {
										System.out.println("������� ������ !!");
										state1 = 1;
										sd = new SendData(1022);
										try {
											oos2.writeObject(sd);
											oos2.flush();
											oos2.reset();
										} catch (Exception e) {
											e.printStackTrace();
											System.out.println("MultiChatThread  -sendmsg-");
										}
										break;
									}
								}

								if (state1 == 0) {
									waitUserList.remove(user);
									user.setChatLocation(title.trim());
									// chatRoomInfo�� �� ���̵� �־���
									for (int j = 0; j < allUserList.size(); j++) {
										if (allUserList.get(j).equals(user)) {
											allUserList.get(j).setChatLocation(title.trim());
										}
									}
									allChatRoomList.get(i).getRoomInfo().getChatRoomUserList().add(id.trim());
									chatuserlist = allChatRoomList.get(i).getRoomInfo().getChatRoomUserList();
									// �� ���� ok
									sd = new SendData(2200, allChatRoomList.get(i).getRoomInfo());
									try {
										oos2.writeObject(sd);
										oos2.flush();
										oos2.reset();
									} catch (Exception e) {
										e.printStackTrace();
										System.out.println("MultiChatThread  -sendmsg-");
									}
									// flag1 = true;
									if (waitUserList.size() >= 1) {
										updateWaitList(waitUserList, allChatRoomList, oos2);
									}
									if (size >= 1) {
										updateChatList(code, size, chatuserlist, oos2, title);
									}
								}

							}
						}

					}

					break;

				// �ʴ�â ���� ��������Ʈ ȣ��
				case 77:
					ObjectOutputStream oos7 = (ObjectOutputStream) ht.get(user);

					String title2 = (String) sd.getObj()[0];
					System.out.println("77�ڵ� Ÿ��Ʋ" + title2);
					sd = new SendData(777, waitUserList, title2);
					try {
						oos7.writeObject(sd);
						oos7.flush();
						oos7.reset();
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("MultiChatThread  -sendmsg-");
					}

					break;
				// ���� ����
				case 130:
					ObjectOutputStream oosChange = (ObjectOutputStream) ht.get(user);
					String titlee = (String) sd.getObj()[0];
					String changeTitle = (String) sd.getObj()[1];
					int changemaxPeople = (int) sd.getObj()[2];
					int num = 0;
					boolean st = true;
					for (int i = 0; i < allChatRoomList.size(); i++) {
						// ä�ù� �ߺ�
						if (allChatRoomList.get(i).getRoomInfo().getTitle().equals(changeTitle)) {
							System.out.println("ä�ù� �̸� �ߺ�");
							sd = new SendData(1033);

							try {
								oosChange.writeObject(sd);
								oosChange.flush();
								oosChange.reset();
							} catch (IOException e) {
								e.printStackTrace();
							}
							st = false;
							break;
						} else if (allChatRoomList.get(i).getRoomInfo().getTitle().equals(titlee)) {
							num = i;
							if (allChatRoomList.get(i).getRoomInfo().getChatRoomUserList().size() > changemaxPeople) {
								System.out.println("���� ä�ù� �ο����� max�ο��� �����ϴ�");
								sd = new SendData(1031);
								try {
									oosChange.writeObject(sd);
									oosChange.flush();
									oosChange.reset();
									st = false;
									break;
								} catch (IOException e) {
									e.printStackTrace();
								}
								st = false;
								break;
							}
						}
					}
					// for�� ��
					if (st == true) {
						for (int i = 0; i < allUserList.size(); i++) {
							if (allUserList.get(i).getChatLocation().equals(titlee)) {
								allUserList.get(i).setChatLocation(changeTitle);
							}
						}
						allChatRoomList.get(num).getRoomInfo().setTitle(changeTitle);
						allChatRoomList.get(num).getRoomInfo().setMaxPeople(changemaxPeople);

						roomupdate(130, changeTitle, changemaxPeople);
						if (waitUserList.size() >= 1) {
							updateWaitList(allChatRoomList);
						}
					}

					break;
				// ���� ����
				case 140:
					ObjectOutputStream bjoos = (ObjectOutputStream) ht.get(user);

					System.out.println("<<<<<<140�� �������� >>>>>>>>");
					String host = (String) sd.getObj()[0];
					String title = (String) sd.getObj()[1];
					System.out.println("���� ȣ��Ʈ" + host);
					for (int i = 0; i < allChatRoomList.size(); i++) {

						if (allChatRoomList.get(i).getRoomInfo().getTitle().equals(title)) {
							allChatRoomList.get(i).getRoomInfo().setChatRoom_host(host);
							allChatRoomList.get(i).getRoomInfo().getChatRoomUserList().remove(host);
							allChatRoomList.get(i).getRoomInfo().getChatRoomUserList().add(0, host);
							roomKingupdate(code, host, allChatRoomList.get(i).getRoomInfo().getChatRoomUserList(),
									bjoos, title);
							if (waitUserList.size() >= 1) {
								updateWaitList(waitUserList, allChatRoomList, bjoos);
							}
						}
					}

					break;
				// ���� ������
				case 141:
					ObjectOutputStream exitbjoos = (ObjectOutputStream) ht.get(user);

					System.out.println("<<<<<<141�� �������� >>>>>>>>");
					String host1 = (String) sd.getObj()[0];
					String title1 = (String) sd.getObj()[1];
					System.out.println("���� ȣ��Ʈ" + host1);
					
					Vector<String> cuserlist = null;
					boolean find = false;

					for (int i = 0; i < allChatRoomList.size(); i++) {

						if (allChatRoomList.get(i).getRoomInfo().getTitle().equals(title1)) {
							// ��������Ʈ�ȿ� �ٲܻ���̸���������
						 
							//////////////////////////
							for (String u : allChatRoomList.get(i).getRoomInfo().getChatRoomUserList()) {
								if (u.equals(host1)) {
									allChatRoomList.get(i).getRoomInfo().setChatRoom_host(host1);// ȣ��Ʈ�ٲ��ְ�
									allChatRoomList.get(i).getRoomInfo().getChatRoomUserList().remove(host1); // ȣ��Ʈ��
																												// �ε���0��°��
																												// �Ű���
									allChatRoomList.get(i).getRoomInfo().getChatRoomUserList().add(0, host1);
									waitUserList.add(user); // ��ġ ����
									user.setChatLocation("����");
									for (int j = 0; j < allUserList.size(); j++) {
										if (allUserList.get(j).equals(user)) {
											allUserList.get(j).setChatLocation("����");

										}
									}
									allChatRoomList.get(i).getRoomInfo().getChatRoomUserList().remove(id);
									cuserlist = allChatRoomList.get(i).getRoomInfo().getChatRoomUserList();

									Vector<ChatRoomInfo> roominfolist = new Vector<ChatRoomInfo>();

									for (int k = 0; k < allChatRoomList.size(); k++) {
										roominfolist.add(allChatRoomList.get(k).getRoomInfo());
									}
									sd = new SendData(2400, waitUserList, roominfolist);
									exitbjoos.writeObject(sd);
									exitbjoos.flush();
									exitbjoos.reset();

									// ������Ʈ
									roomKingupdate(141, host1, cuserlist, exitbjoos, title1);
									if (waitUserList.size() >= 1) {
										updateWaitList(waitUserList, allChatRoomList, exitbjoos);
									}
									find = true;
									break;
								} else {

								}
							}

						} // if �� ������
					}
					// ä�ù�ȿ� ������ ã�� �� ������
					if (find == false) {
						sd = new SendData(2032);
						try {
							exitbjoos.writeObject(sd);
							exitbjoos.flush();
							exitbjoos.reset();
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("MultiChatThread  -sendmsg-");
						}
					}
					System.out.println("??????????edkjfkdls;fjsdkafjs;lkdf");

					break;

				// ��ȭ�� ������
				case 180:
					title = String.valueOf(sd.getObj()[0]);
					ObjectOutputStream oos = (ObjectOutputStream) ht.get(user);
					int size1 = 0;
					Vector<String> chatuserlist1 = null;

					for (int i = 0; i < allChatRoomList.size(); i++) {

						if (allChatRoomList.get(i).getRoomInfo().getTitle().equals(title)) {
							waitUserList.add(user); // ��ġ ����
							user.setChatLocation("����");
							// chatRoomInfo�� �� ���̵� �־���
							for (int j = 0; j < allUserList.size(); j++) {
								if (allUserList.get(j).equals(user)) {
									allUserList.get(j).setChatLocation("����");

								}
							}
							allChatRoomList.get(i).getRoomInfo().getChatRoomUserList().remove(id);
							chatuserlist1 = allChatRoomList.get(i).getRoomInfo().getChatRoomUserList();

							size1 = allChatRoomList.get(i).getRoomInfo().getChatRoomUserList().size();
							if (size1 == 0) {
								allChatRoomList.remove(allChatRoomList.get(i));
							}

						}

					}
					Vector<ChatRoomInfo> roominfolist = new Vector<ChatRoomInfo>();
					for (int i = 0; i < allChatRoomList.size(); i++) {
						roominfolist.add(allChatRoomList.get(i).getRoomInfo());
					}
					sd = new SendData(2400, waitUserList, roominfolist);
					oos.writeObject(sd);
					oos.flush();
					oos.reset();

					if (size1 >= 1) {
						System.out.println("������ ê����Ʈ");
						updateChatList(code, size1, chatuserlist1, oos, title);
					}

					if (waitUserList.size() >= 1) {
						System.out.println("������ waitUserlist");
						updateWaitList(waitUserList, allChatRoomList, oos);
					}

					break;
				// ���� /////////////////////////////////////////////////
				case 160:
					System.out.println("����");
					String kickoutUser = (String) sd.getObj()[0];
					System.out.println(kickoutUser);
					String roomti = (String) sd.getObj()[1];
					Vector<String> userlist = null;
					ObjectOutputStream koos = null;
					Set<User> userKey = ht.keySet();

					for (ChatRoom cr : allChatRoomList) {
						if (cr.getRoomInfo().getTitle().equals(roomti)) {
							cr.getKickout_User().add(kickoutUser);
							cr.getRoomInfo().getChatRoomUserList().remove(kickoutUser);
							userlist = cr.getRoomInfo().getChatRoomUserList();
							System.out.println("���� ä�ù� ��������Ʈ" + userlist);
							waitUserList.add(new User(kickoutUser, "����")); // ��ġ
																			// ����
							for (User user : allUserList) {
								if (user.getId().equals(kickoutUser)) {
									user.setChatLocation("����");
								}
							} // ��ü�������� ���Ƿιٲ���
						}
					}
					Vector<ChatRoomInfo> roomin = new Vector<ChatRoomInfo>();
					for (int k = 0; k < allChatRoomList.size(); k++) {
						roomin.add(allChatRoomList.get(k).getRoomInfo());
					}
					String km = "ä�ù濡�� ���� ���ϼ̽��ϴ�";
					sd = new SendData(2401, km, waitUserList, roomin, kickoutUser);
					for (User t : userKey) {
						if (t.getId().equals(kickoutUser)) {
							koos = ht.get(t);
							try {
								koos.writeObject(sd);
								koos.flush();
								koos.reset();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
					// update
					roomKingupdate(160, kickoutUser, userlist, koos, roomti);
					if (waitUserList.size() >= 1) {
						updateWaitList(waitUserList, allChatRoomList, koos);
					}

					break;

				// �����ʴ� // ++++++++++++++++++++
				case 170:
					// Ŭ���̾�Ʈ���� ���� ���� ���� ����Ʈ ��û
					// updateWaitUserList(waitUserList);
					String userName = (String) sd.getObj()[0];
					String RoomTitle = (String) sd.getObj()[1];
					// String SendUser = (String) sd.getObj()[2];

					for (User user : waitUserList) {
						if (user.getId().equals(userName)) {
							InviteSendData(new SendData(1070, id, RoomTitle), user);
						}
					}
					 
					break;// ++++++++++++++++++++

				// �ʴ� ����
				case 171:
					// ChatRoomInfo , chatRoomUserList:Vector<User>
					String title5 = String.valueOf(sd.getObj()[0]); // ������
					String name = String.valueOf(sd.getObj()[1]); // �޴� ���
					String SendUser = String.valueOf(sd.getObj()[2]); // �����»��
					for (int k = 0; k < waitUserList.size(); k++) {

						if (waitUserList.get(k).getId().equals(name)) {  
							//�޴� ����� ���ǿ� ������?? 
							
							ObjectOutputStream oos5 = (ObjectOutputStream) ht.get(user);
							// boolean flag1 = false;
							int size5 = 0;
							Vector<String> chatuserlist5 = null;
							for (int i = 0; i < allChatRoomList.size(); i++) {

								size = allChatRoomList.get(i).getRoomInfo().getChatRoomUserList().size();

								if (allChatRoomList.get(i).getRoomInfo().getTitle().equals(title5)) {
									// �ִ��ο�
									if (allChatRoomList.get(i).getRoomInfo().getMaxPeople() == size) {
										sd = new SendData(1021, allChatRoomList.get(i).getRoomInfo());
										try {
											oos5.writeObject(sd);
											oos5.flush();
											oos5.reset();
											break;
										} catch (Exception e) {
											e.printStackTrace();
											System.out.println("MultiChatThread  -sendmsg-");
										}

									} else {
										waitUserList.remove(user);
										user.setChatLocation(title5.trim());
										// chatRoomInfo�� �� ���̵� �־���
										for (int j = 0; j < allUserList.size(); j++) {
											if (allUserList.get(j).equals(user)) {
												allUserList.get(j).setChatLocation(title5);
											}
										}
										
										allChatRoomList.get(i).getRoomInfo().getChatRoomUserList().add(id);

										chatuserlist5 = allChatRoomList.get(i).getRoomInfo().getChatRoomUserList();
										// �� ���� ok
										sd = new SendData(2200, allChatRoomList.get(i).getRoomInfo());
										try {
											oos5.writeObject(sd);
											oos5.flush();
											oos5.reset();
										} catch (Exception e) {
											e.printStackTrace();
											System.out.println("MultiChatThread  -sendmsg-");
										}
										// flag1 = true;
										if (waitUserList.size() >= 1) {
											updateWaitList(waitUserList, allChatRoomList, oos5);
										}
										if (size >= 1) {
											updateChatList(code, size5, chatuserlist5, oos5, title5);
										}
									}
								}

							}
						}

					} // for�� ��

					break; // ++++++++++++++++++++
				// �ʴ� �ź� // ++++++++++++++++++++
				case 172:
					String SendUser2 = (String) sd.getObj()[0];
					ObjectOutputStream oos10 = null;
					for (User user : allUserList) {
						if (user.getId().equals(SendUser2)) {
							oos10 = ht.get(user);
						}
					}
					System.out.println("���� �ʴ� ���� ����");
					try {
						sd = new SendData(1071);
						oos10.writeObject(sd);
						oos10.flush();
						oos10.reset();
					} catch (IOException e) {
						e.printStackTrace();
					}

					break; // ++++++++++++++++++++
				// ��ȭ�� �޼��� ������
				case 200:
					String ms = id + ": " + (String) sd.getObj()[0];
					chatbroadcast(2000, ms, user);
					break;
				// ���� �޽��� ������
				case 201:
					id = user.getId();
					String msg = id + ": " + (String) sd.getObj()[0];
					broadcast(2001, msg);
					break;

				// �ӼӸ� ������
				case 202:
					String wisperMsg = (String) sd.getObj()[0];
					if (wisperMsg.indexOf("/to ") == 0) {
						sendMsg(wisperMsg);
					}
					break;

				// btnSearch ��ư ������ ��
				case 210:
					boolean flag2 = false;
					count = 0;
					ObjectOutputStream oos3 = (ObjectOutputStream) ht.get(user);
					String searchTitle = (String) sd.getObj()[0]; // �˻� Ű����
					vec = new Vector<ChatRoomInfo>();
					for (int i = 0; i < allChatRoomList.size(); i++) {
						if (allChatRoomList.get(i).getRoomInfo().getTitle().contains(searchTitle.trim())) {
							// ���� �˻��� ������ �ִ����� �˻��� �ִٸ� ������ �κ���
							flag2 = true;
							vec.add(allChatRoomList.get(i).getRoomInfo());
						}
					}
					// �˻��� ����� ������
					if (flag2 == true) {
						sd = new SendData(2010, vec, count);// 0
						try {
							oos3.writeObject(sd);
							oos3.flush();
							oos3.reset();
						} catch (Exception e) {
							e.printStackTrace();
						}

					} else { // �˻� ����� ������
						sd = new SendData(2011);
						try {
							oos3.writeObject(sd);
							oos3.flush();
							oos3.reset();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}

					break;

				// �� �ʱ�ȭ
				case 212:

					ObjectOutputStream oos12 = (ObjectOutputStream) ht.get(user);
					Vector<ChatRoomInfo> roominfo = new Vector<ChatRoomInfo>();
					for (int i = 0; i < allChatRoomList.size(); i++) {
						roominfo.add(allChatRoomList.get(i).getRoomInfo());
					}

					sd = new SendData(2012, roominfo);
					try {
						oos12.writeObject(sd);
						oos12.flush();
						oos12.reset();
					} catch (Exception e) {
						e.printStackTrace();
					}

					break;

				// ���� ������
				case 220:
					stopFlag = true;
					allUserList.remove(user);
					waitUserList.remove(user);
					ht.remove(user);

					if (waitUserList.size() >= 1) {
						updateWaitUserList(waitUserList);
						broadcast(2700);
					}
					break;
				}
				if (code == 220) {
					break;
				}
			}
		} catch (SocketException e) {
			System.out.println(e);

			System.out.println("�������̤�");
			if (stopFlag == false) {
				ht.remove(user);
				if (user.getChatLocation().equals("����")) {
					allUserList.remove(user);
					waitUserList.remove(user);
					if (waitUserList.size() >= 1) {
						updateWaitUserList(waitUserList);
						broadcast(2700);
					}

				} else {
					// ä�ù� ���� ��������
					System.out.println("ä�ù濡 �־�?????");
					Vector<String> chatuserlist = null;

					for(ChatRoom chatRoom : allChatRoomList) {
						String userId = chatRoom.searchUser(user.getId());
						System.out.println(userId);
						if(userId != null) {
							// ���� �Ϸ�
							allUserList.remove(user);
							chatRoom.removeUser(userId);
							System.out.println("���� �Ǿ�??");
							
							chatuserlist = chatRoom.getRoomInfo().getChatRoomUserList();
							int size1 = chatuserlist.size();
							System.out.println("�����ǰ� �� �� "+chatuserlist);
							
							if (size1 == 0) {
								allChatRoomList.remove(chatRoom);
							}
							
							if (size1 >= 1) {
								if(chatRoom.getRoomInfo().getChatRoom_host().equals(userId)){
									System.out.println("���� �� ��� ��������");
									chatRoom.getRoomInfo().setChatRoom_host(chatuserlist.get(0));
									roomKingupdate(2300,chatuserlist.get(0),chatuserlist,oos,
											chatRoom.getRoomInfo().getTitle());
								}else{
									System.out.println("�Ϲ������� ���"+ chatuserlist);
									updateChatList(180, size1,chatuserlist, oos , title);
								}
							
							}
							
							
							System.out.println(allChatRoomList);
							if (waitUserList.size() >= 1) {
								System.out.println("������ waitUserlist");
								updateWaitList(waitUserList, allChatRoomList, oos);
							}
							
							
						}
						
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			System.out.println("��������");
			try {
				sock.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	// �ʴ� �޽��� // ++++++++++++++++++++
	public void InviteSendData(SendData sd, User user) {
		ObjectOutputStream oos = null;
		for (User users : ht.keySet()) {
			if (users.getId().equals(user.getId())) {
				oos = ht.get(users);
			}
		}
		try {
			System.out.println("���� = �ʴ� �޽��� �޴� ���� �̸�" + user.getId());
			oos.writeObject(sd);
			oos.flush();
			oos.reset();
			System.out.println("���� = �ʴ� �޽��� ����");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// ++++++++++++++++++++

	// �ӼӸ�
	public void sendMsg(String msg) {
		int code = ServerProtocol.RECEIVE_WISPER_MESSAGE_CHATROOM_SUCCSS; // 2002
		int start = msg.indexOf(" ") + 1; // 4
		int end = msg.indexOf(" ", start); // 7

		if (end != -1) {
			String to = msg.substring(start, end); // String to = "���μ�"
			String msg2 = msg.substring(end + 1); // String msg2 = "�ȳ�~"
			Object obj = null;
			Set<User> userKey = ht.keySet(); // keySet()�� Ű���� ����
			Vector<User> key = new Vector<User>(userKey);
			for (User u : key) {
				if (to.equals(user.getId())) {
					obj = ht.get(user);
					ObjectOutputStream oos = (ObjectOutputStream) obj;
					sd = new SendData(ServerProtocol.RECEIVE_WISPER_MESSAGE_CHATROOM_FAIL_MYSELF); // ����
																									// ����
					// ���� ������ �������� ����
					try {
						oos.writeObject(sd);
						oos.flush();
						oos.reset();
						return;
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else if (u.getId().equals(to)) {
					obj = ht.get(u); // obj�� ���μ� Hashtable�� �����ͼ� �ִ´�.
					ObjectOutputStream oos = (ObjectOutputStream) obj; // ���μ�
																		// ObjectOutputStream��
																		// ������

					String str = "[" + user.getId() + "] ���� �ӼӸ� : >>>> " + msg2;

					SendData sendMsg = new SendData(ServerProtocol.RECEIVE_WISPER_MESSAGE_CHATROOM_SUCCSS, str);
					try {
						oos.writeObject(sendMsg);
						oos.flush();
						oos.reset();
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("MultiChatThread  -sendmsg-");
					}
					try {
						System.out.println("�� ���̵� " + user.getId());
						msg2 = "[" + to + "]�Կ��� �ӼӸ�  >>>> :" + msg2;
						ht.get(user)
								.writeObject(new SendData(ServerProtocol.RECEIVE_WISPER_MESSAGE_CHATROOM_SUCCSS, msg2));
						ht.get(user).flush();
						ht.get(user).reset();
						return;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			obj = ht.get(user);
			ObjectOutputStream oos = (ObjectOutputStream) obj;
			SendData sd = new SendData(ServerProtocol.RECEIVE_WISPER_MESSAGE_FAIL_NOT_FOUND); // ����
																								// ����
			try {
				oos.writeObject(sd);
				oos.flush();
				oos.reset();
				return;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("���� ����?");
			}

		}

	}

	// �Ӹ� ��
	// �ڵ� + �ܼ� �˸� �޽���
	public void broadcast(int code) {
		Collection<ObjectOutputStream> collection = ht.values();
		Iterator<ObjectOutputStream> iter = collection.iterator();
		while (iter.hasNext()) {
			oos = iter.next();
			try {
				sd = new SendData(code, id);
				oos.writeObject(sd);
				oos.flush();
				oos.reset();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// �ڵ� + ä�ó���
	public void broadcast(int code, String msg) {
		Collection<ObjectOutputStream> collection = ht.values();
		Iterator<ObjectOutputStream> iter = collection.iterator();
		while (iter.hasNext()) {
			oos = iter.next();
			try {
				sd = new SendData(code, msg);
				oos.writeObject(sd);
				oos.flush();
				oos.reset();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// ä�ù� �޼��� ������

	public void chatbroadcast(int code, String msg, User user) {
		Set<User> userKey = ht.keySet(); // keySet()�� Ű���� ����
		sd = new SendData(2000, msg);
		for (User temp : userKey) {
			if (temp.getChatLocation().equals(user.getChatLocation())) {
				ObjectOutputStream oos = ht.get(temp);

				try {
					oos.writeObject(sd);
					oos.flush();
					oos.reset();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	// ���� ��������Ʈ ����
	public void updateWaitUserList(Vector<User> waitUserList) {
		Collection<ObjectOutputStream> collection = ht.values();
		Iterator<ObjectOutputStream> iter = collection.iterator();

		while (iter.hasNext()) {
			oos = iter.next();
			try {
				sd = new SendData(3000, waitUserList);
				oos.writeObject(sd);
				oos.flush();
				oos.reset();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// ���� ��������Ʈ ���� , ����� ���� , ���� �޼���
	public void updateWaitingList(Vector<User> waitUserList, Vector<ChatRoom> allchatRoomList) {

		Set<User> userKey = ht.keySet(); // keySet()�� Ű���� ����
		Vector<User> key = new Vector<User>(userKey);

		Vector<ChatRoomInfo> romminfo = new Vector<ChatRoomInfo>();
		for (int i = 0; i < allchatRoomList.size(); i++) {
			romminfo.add(allchatRoomList.get(i).getRoomInfo());
		}

		String msg = id + "���� �����ϼ̽��ϴ� ";
		Object obj = null;
		for (User u : key) {
			if (u.getChatLocation().equals("����")) {
				obj = ht.get(u);
				ObjectOutputStream oos = (ObjectOutputStream) obj;
				try {
					System.out.println("<<updateuserlist>>");
					System.out.println("alluser" + allUserList);
					System.out.println("waituser" + waitUserList);
					System.out.println("roomInfolist" + romminfo);
					sd = new SendData(2400, msg, waitUserList, romminfo);
					oos.writeObject(sd);
					oos.flush();
					oos.reset();
				} catch (IOException e) {
					e.printStackTrace();

				}
			}
		}
	}

	private void updateChatList(int code, int size, Vector<String> chatuserlist, ObjectOutputStream oos2,
			String title) {
		Set<User> userKey = ht.keySet(); // keySet()�� Ű���� ����
		String msg = null;

		System.out.println("�ڵ��ȣ " + code);
		System.out.println(ht);
		if (code == 180) {
			msg = user.getId() + "���� ���� �ϼ̽��ϴ� ! ";
		} else {
			msg = user.getId() + "���� ���� �ϼ̽��ϴ� ! ";
		}
		System.out.println("ê ��������Ʈ" + chatuserlist);
		sd = new SendData(2500, msg, chatuserlist);
		for (User temp : userKey) {
			if (temp.getChatLocation().equals(title)) {
				ObjectOutputStream oos = ht.get(temp);
				if (oos != oos2) {
					try {
						System.out.println("����� ������Ʈ ê����Ʈ ->���� �ѷ����� " + temp.getId());
						oos.writeObject(sd);
						oos.flush();
						oos.reset();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				/*
				 * try { oos.writeObject(sd); oos.flush(); oos.reset(); } catch
				 * (IOException e) { e.printStackTrace(); }
				 */

			}
		}
	}

	// ���� �Ӹ� , ����
	private void roomKingupdate(int code, String user, Vector<String> chatuserlist, ObjectOutputStream oos2,
			String title) {
		System.out.println("roomKingupdate       "+ chatuserlist);
		Set<User> userKey = ht.keySet(); // keySet()�� Ű���� ����
		String msg = null;
		if (code == 160) {
			msg = user + "���� ������ϼ̽��ϴ� ";

		} else {
			msg = "������" + chatuserlist.get(0) + "������ ���� �Ǿ����ϴ�  ";

		}
		System.out.println("�ڵ��ȣ " + code);
		System.out.println("ê ��������Ʈ" + chatuserlist);
		sd = new SendData(2300, msg, chatuserlist);
		for (User temp : userKey) {
			if (temp.getChatLocation().equals(title)) {

				ObjectOutputStream oos = ht.get(temp);

				try {
					System.out.println("����� ������Ʈ ê����Ʈ ->���� �ѷ����� " + temp.getId());

					oos.writeObject(sd);
					oos.flush();
					oos.reset();

				} catch (IOException e) {
					e.printStackTrace();
				}
 

			}
		}
	}

	// ä�ù� ���� update
	// ���� �Ӹ�
	private void roomupdate(int code, String title, int max) {

		Set<User> userKey = ht.keySet(); // keySet()�� Ű���� ����
		System.out.println("�ڵ��ȣ " + code);
		sd = new SendData(1030, title, max);
		for (User temp : userKey) {
			if (temp.getChatLocation().equals(title)) {

				ObjectOutputStream oos = ht.get(temp);

				try {
					System.out.println("����� ������Ʈ ê����Ʈ ->���� �ѷ����� " + temp.getId());
					oos.writeObject(sd);
					oos.flush();
					oos.reset();
				} catch (IOException e) {
					e.printStackTrace();
				}

				/*
				 * try { oos.writeObject(sd); oos.flush(); oos.reset(); } catch
				 * (IOException e) { e.printStackTrace(); }
				 */

			}
		}
	}

	// ���� ��������Ʈ ���� , ����� ����
	public void updateWaitList(Vector<User> waitUserList, Vector<ChatRoom> allchatRoomList, ObjectOutputStream myoos) {

		Set<User> userKey = ht.keySet(); // keySet()�� Ű���� ����
		Vector<User> key = new Vector<User>(userKey);

		Vector<ChatRoomInfo> romminfo = new Vector<ChatRoomInfo>();
		for (int i = 0; i < allchatRoomList.size(); i++) {
			romminfo.add(allchatRoomList.get(i).getRoomInfo());
		}
		Object obj = null;
		for (User u : key) {
			if (u.getChatLocation().equals("����")) {
				System.out.println("���� ������Ʈ");
				obj = ht.get(u);
				ObjectOutputStream oos = (ObjectOutputStream) obj;
				try {

					sd = new SendData(3001, waitUserList, romminfo);
					oos.writeObject(sd);
					oos.flush();
					oos.reset();
				} catch (IOException e) {
					e.printStackTrace();

				}
			}
		}
	}

	// ä�ù� ������ ����
	public void updateWaitList(Vector<ChatRoom> allchatRoomList) {

		Set<User> userKey = ht.keySet(); // keySet()�� Ű���� ����
		Vector<User> key = new Vector<User>(userKey);

		Vector<ChatRoomInfo> romminfo = new Vector<ChatRoomInfo>();
		for (int i = 0; i < allchatRoomList.size(); i++) {
			romminfo.add(allchatRoomList.get(i).getRoomInfo());
		}
		Object obj = null;
		for (User u : key) {
			if (u.getChatLocation().equals("����")) {
				System.out.println("���� ������Ʈ");
				obj = ht.get(u);
				ObjectOutputStream oos = (ObjectOutputStream) obj;
				try {

					sd = new SendData(3002, romminfo);
					oos.writeObject(sd);
					oos.flush();
					oos.reset();
				} catch (IOException e) {
					e.printStackTrace();

				}
			}
		}
	}
}
