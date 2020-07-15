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
				System.out.println("서버코드 " + code);

				switch (code) {

				// 접속
				case 100:
					// 접속 중복 확인
					int state = ServerProtocol.ENTRANCE_SUCCESS;
					id = String.valueOf(sd.getObj()[0]); // 가지고 왔음
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
					// 접속 성공
					if (state == ServerProtocol.ENTRANCE_SUCCESS) {
						user = new User(id, "대기실");

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
				// 방 만들기
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

					// 채팅방 성공
					if (flag == 0) {
						chroom = new ChatRoom(ri);
						title = ri.getTitle();
						waitUserList.remove(user);
						user.setChatLocation(title.trim());
						// chatRoomInfo에 내 아이디를 넣어줌
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

				// 채팅방 입장하기
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
							// 최대인원
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
										System.out.println("강퇴당한 유저임 !!");
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
									// chatRoomInfo에 내 아이디를 넣어줌
									for (int j = 0; j < allUserList.size(); j++) {
										if (allUserList.get(j).equals(user)) {
											allUserList.get(j).setChatLocation(title.trim());
										}
									}
									allChatRoomList.get(i).getRoomInfo().getChatRoomUserList().add(id.trim());
									chatuserlist = allChatRoomList.get(i).getRoomInfo().getChatRoomUserList();
									// 방 입장 ok
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

				// 초대창 대기실 유저리스트 호출
				case 77:
					ObjectOutputStream oos7 = (ObjectOutputStream) ht.get(user);

					String title2 = (String) sd.getObj()[0];
					System.out.println("77코드 타이틀" + title2);
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
				// 방장 수정
				case 130:
					ObjectOutputStream oosChange = (ObjectOutputStream) ht.get(user);
					String titlee = (String) sd.getObj()[0];
					String changeTitle = (String) sd.getObj()[1];
					int changemaxPeople = (int) sd.getObj()[2];
					int num = 0;
					boolean st = true;
					for (int i = 0; i < allChatRoomList.size(); i++) {
						// 채팅방 중복
						if (allChatRoomList.get(i).getRoomInfo().getTitle().equals(changeTitle)) {
							System.out.println("채팅방 이름 중복");
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
								System.out.println("현재 채팅방 인원보다 max인원이 적습니다");
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
					// for문 끝
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
				// 방장 위임
				case 140:
					ObjectOutputStream bjoos = (ObjectOutputStream) ht.get(user);

					System.out.println("<<<<<<140번 방장위임 >>>>>>>>");
					String host = (String) sd.getObj()[0];
					String title = (String) sd.getObj()[1];
					System.out.println("받은 호스트" + host);
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
				// 방장 나갈때
				case 141:
					ObjectOutputStream exitbjoos = (ObjectOutputStream) ht.get(user);

					System.out.println("<<<<<<141번 방장위임 >>>>>>>>");
					String host1 = (String) sd.getObj()[0];
					String title1 = (String) sd.getObj()[1];
					System.out.println("받은 호스트" + host1);
					
					Vector<String> cuserlist = null;
					boolean find = false;

					for (int i = 0; i < allChatRoomList.size(); i++) {

						if (allChatRoomList.get(i).getRoomInfo().getTitle().equals(title1)) {
							// 유저리스트안에 바꿀사람이름이있을때
						 
							//////////////////////////
							for (String u : allChatRoomList.get(i).getRoomInfo().getChatRoomUserList()) {
								if (u.equals(host1)) {
									allChatRoomList.get(i).getRoomInfo().setChatRoom_host(host1);// 호스트바꿔주고
									allChatRoomList.get(i).getRoomInfo().getChatRoomUserList().remove(host1); // 호스트를
																												// 인덱스0번째로
																												// 옮겨줌
									allChatRoomList.get(i).getRoomInfo().getChatRoomUserList().add(0, host1);
									waitUserList.add(user); // 위치 대기실
									user.setChatLocation("대기실");
									for (int j = 0; j < allUserList.size(); j++) {
										if (allUserList.get(j).equals(user)) {
											allUserList.get(j).setChatLocation("대기실");

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

									// 업데이트
									roomKingupdate(141, host1, cuserlist, exitbjoos, title1);
									if (waitUserList.size() >= 1) {
										updateWaitList(waitUserList, allChatRoomList, exitbjoos);
									}
									find = true;
									break;
								} else {

								}
							}

						} // if 문 끝ㅎㅎ
					}
					// 채팅방안에 유저를 찾을 수 없을때
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

				// 대화방 나가기
				case 180:
					title = String.valueOf(sd.getObj()[0]);
					ObjectOutputStream oos = (ObjectOutputStream) ht.get(user);
					int size1 = 0;
					Vector<String> chatuserlist1 = null;

					for (int i = 0; i < allChatRoomList.size(); i++) {

						if (allChatRoomList.get(i).getRoomInfo().getTitle().equals(title)) {
							waitUserList.add(user); // 위치 대기실
							user.setChatLocation("대기실");
							// chatRoomInfo에 내 아이디를 넣어줌
							for (int j = 0; j < allUserList.size(); j++) {
								if (allUserList.get(j).equals(user)) {
									allUserList.get(j).setChatLocation("대기실");

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
						System.out.println("나갈때 챗리스트");
						updateChatList(code, size1, chatuserlist1, oos, title);
					}

					if (waitUserList.size() >= 1) {
						System.out.println("나갈때 waitUserlist");
						updateWaitList(waitUserList, allChatRoomList, oos);
					}

					break;
				// 강퇴 /////////////////////////////////////////////////
				case 160:
					System.out.println("강퇴");
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
							System.out.println("강퇴 채팅방 유저리스트" + userlist);
							waitUserList.add(new User(kickoutUser, "대기실")); // 위치
																			// 대기실
							for (User user : allUserList) {
								if (user.getId().equals(kickoutUser)) {
									user.setChatLocation("대기실");
								}
							} // 전체유저에서 대기실로바꿔줌
						}
					}
					Vector<ChatRoomInfo> roomin = new Vector<ChatRoomInfo>();
					for (int k = 0; k < allChatRoomList.size(); k++) {
						roomin.add(allChatRoomList.get(k).getRoomInfo());
					}
					String km = "채팅방에서 강퇴 당하셨습니다";
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

				// 유저초대 // ++++++++++++++++++++
				case 170:
					// 클라이언트에서 현재 대기실 유저 리스트 요청
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

				// 초대 입장
				case 171:
					// ChatRoomInfo , chatRoomUserList:Vector<User>
					String title5 = String.valueOf(sd.getObj()[0]); // 방제목
					String name = String.valueOf(sd.getObj()[1]); // 받는 사람
					String SendUser = String.valueOf(sd.getObj()[2]); // 보내는사람
					for (int k = 0; k < waitUserList.size(); k++) {

						if (waitUserList.get(k).getId().equals(name)) {  
							//받는 사람이 대기실에 잇으면?? 
							
							ObjectOutputStream oos5 = (ObjectOutputStream) ht.get(user);
							// boolean flag1 = false;
							int size5 = 0;
							Vector<String> chatuserlist5 = null;
							for (int i = 0; i < allChatRoomList.size(); i++) {

								size = allChatRoomList.get(i).getRoomInfo().getChatRoomUserList().size();

								if (allChatRoomList.get(i).getRoomInfo().getTitle().equals(title5)) {
									// 최대인원
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
										// chatRoomInfo에 내 아이디를 넣어줌
										for (int j = 0; j < allUserList.size(); j++) {
											if (allUserList.get(j).equals(user)) {
												allUserList.get(j).setChatLocation(title5);
											}
										}
										
										allChatRoomList.get(i).getRoomInfo().getChatRoomUserList().add(id);

										chatuserlist5 = allChatRoomList.get(i).getRoomInfo().getChatRoomUserList();
										// 방 입장 ok
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

					} // for문 끝

					break; // ++++++++++++++++++++
				// 초대 거부 // ++++++++++++++++++++
				case 172:
					String SendUser2 = (String) sd.getObj()[0];
					ObjectOutputStream oos10 = null;
					for (User user : allUserList) {
						if (user.getId().equals(SendUser2)) {
							oos10 = ht.get(user);
						}
					}
					System.out.println("서버 초대 거절 받음");
					try {
						sd = new SendData(1071);
						oos10.writeObject(sd);
						oos10.flush();
						oos10.reset();
					} catch (IOException e) {
						e.printStackTrace();
					}

					break; // ++++++++++++++++++++
				// 대화방 메세지 보내기
				case 200:
					String ms = id + ": " + (String) sd.getObj()[0];
					chatbroadcast(2000, ms, user);
					break;
				// 대기실 메시지 보내기
				case 201:
					id = user.getId();
					String msg = id + ": " + (String) sd.getObj()[0];
					broadcast(2001, msg);
					break;

				// 귓속말 보내기
				case 202:
					String wisperMsg = (String) sd.getObj()[0];
					if (wisperMsg.indexOf("/to ") == 0) {
						sendMsg(wisperMsg);
					}
					break;

				// btnSearch 버튼 눌렀을 때
				case 210:
					boolean flag2 = false;
					count = 0;
					ObjectOutputStream oos3 = (ObjectOutputStream) ht.get(user);
					String searchTitle = (String) sd.getObj()[0]; // 검색 키워드
					vec = new Vector<ChatRoomInfo>();
					for (int i = 0; i < allChatRoomList.size(); i++) {
						if (allChatRoomList.get(i).getRoomInfo().getTitle().contains(searchTitle.trim())) {
							// 내가 검색한 제목이 있는지를 검사함 있다면 실행할 부분임
							flag2 = true;
							vec.add(allChatRoomList.get(i).getRoomInfo());
						}
					}
					// 검색한 결과가 있을때
					if (flag2 == true) {
						sd = new SendData(2010, vec, count);// 0
						try {
							oos3.writeObject(sd);
							oos3.flush();
							oos3.reset();
						} catch (Exception e) {
							e.printStackTrace();
						}

					} else { // 검색 결과가 없을때
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

				// 방 초기화
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

				// 대기실 나가기
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

			System.out.println("여기이이ㅣ");
			if (stopFlag == false) {
				ht.remove(user);
				if (user.getChatLocation().equals("대기실")) {
					allUserList.remove(user);
					waitUserList.remove(user);
					if (waitUserList.size() >= 1) {
						updateWaitUserList(waitUserList);
						broadcast(2700);
					}

				} else {
					// 채팅방 에서 나갔을때
					System.out.println("채팅방에 있어?????");
					Vector<String> chatuserlist = null;

					for(ChatRoom chatRoom : allChatRoomList) {
						String userId = chatRoom.searchUser(user.getId());
						System.out.println(userId);
						if(userId != null) {
							// 삭제 완료
							allUserList.remove(user);
							chatRoom.removeUser(userId);
							System.out.println("삭제 되었??");
							
							chatuserlist = chatRoom.getRoomInfo().getChatRoomUserList();
							int size1 = chatuserlist.size();
							System.out.println("삭제되고 난 후 "+chatuserlist);
							
							if (size1 == 0) {
								allChatRoomList.remove(chatRoom);
							}
							
							if (size1 >= 1) {
								if(chatRoom.getRoomInfo().getChatRoom_host().equals(userId)){
									System.out.println("방장 일 경우 강제종료");
									chatRoom.getRoomInfo().setChatRoom_host(chatuserlist.get(0));
									roomKingupdate(2300,chatuserlist.get(0),chatuserlist,oos,
											chatRoom.getRoomInfo().getTitle());
								}else{
									System.out.println("일반유저일 경우"+ chatuserlist);
									updateChatList(180, size1,chatuserlist, oos , title);
								}
							
							}
							
							
							System.out.println(allChatRoomList);
							if (waitUserList.size() >= 1) {
								System.out.println("나갈때 waitUserlist");
								updateWaitList(waitUserList, allChatRoomList, oos);
							}
							
							
						}
						
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			System.out.println("접속종료");
			try {
				sock.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	// 초대 메시지 // ++++++++++++++++++++
	public void InviteSendData(SendData sd, User user) {
		ObjectOutputStream oos = null;
		for (User users : ht.keySet()) {
			if (users.getId().equals(user.getId())) {
				oos = ht.get(users);
			}
		}
		try {
			System.out.println("서버 = 초대 메시지 받는 유저 이름" + user.getId());
			oos.writeObject(sd);
			oos.flush();
			oos.reset();
			System.out.println("서버 = 초대 메시지 보냄");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// ++++++++++++++++++++

	// 귓속말
	public void sendMsg(String msg) {
		int code = ServerProtocol.RECEIVE_WISPER_MESSAGE_CHATROOM_SUCCSS; // 2002
		int start = msg.indexOf(" ") + 1; // 4
		int end = msg.indexOf(" ", start); // 7

		if (end != -1) {
			String to = msg.substring(start, end); // String to = "강민수"
			String msg2 = msg.substring(end + 1); // String msg2 = "안녕~"
			Object obj = null;
			Set<User> userKey = ht.keySet(); // keySet()은 키들의 집합
			Vector<User> key = new Vector<User>(userKey);
			for (User u : key) {
				if (to.equals(user.getId())) {
					obj = ht.get(user);
					ObjectOutputStream oos = (ObjectOutputStream) obj;
					sd = new SendData(ServerProtocol.RECEIVE_WISPER_MESSAGE_CHATROOM_FAIL_MYSELF); // 내가
																									// 오류
					// 내가 나한테 보낼때의 오류
					try {
						oos.writeObject(sd);
						oos.flush();
						oos.reset();
						return;
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else if (u.getId().equals(to)) {
					obj = ht.get(u); // obj에 강민수 Hashtable을 가져와서 넣는다.
					ObjectOutputStream oos = (ObjectOutputStream) obj; // 강민수
																		// ObjectOutputStream을
																		// 가져옴

					String str = "[" + user.getId() + "] 님의 귓속말 : >>>> " + msg2;

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
						System.out.println("내 아이디 " + user.getId());
						msg2 = "[" + to + "]님에게 귓속말  >>>> :" + msg2;
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
			SendData sd = new SendData(ServerProtocol.RECEIVE_WISPER_MESSAGE_FAIL_NOT_FOUND); // 없는
																								// 오류
			try {
				oos.writeObject(sd);
				oos.flush();
				oos.reset();
				return;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("오류 나냐?");
			}

		}

	}

	// 귓말 끝
	// 코드 + 단순 알림 메시지
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

	// 코드 + 채팅내용
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

	// 채팅방 메세지 날리기

	public void chatbroadcast(int code, String msg, User user) {
		Set<User> userKey = ht.keySet(); // keySet()은 키들의 집합
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

	// 대기실 유저리스트 갱신
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

	// 대기실 유저리스트 갱신 , 방생성 갱신 , 입장 메세지
	public void updateWaitingList(Vector<User> waitUserList, Vector<ChatRoom> allchatRoomList) {

		Set<User> userKey = ht.keySet(); // keySet()은 키들의 집합
		Vector<User> key = new Vector<User>(userKey);

		Vector<ChatRoomInfo> romminfo = new Vector<ChatRoomInfo>();
		for (int i = 0; i < allchatRoomList.size(); i++) {
			romminfo.add(allchatRoomList.get(i).getRoomInfo());
		}

		String msg = id + "님이 입장하셨습니다 ";
		Object obj = null;
		for (User u : key) {
			if (u.getChatLocation().equals("대기실")) {
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
		Set<User> userKey = ht.keySet(); // keySet()은 키들의 집합
		String msg = null;

		System.out.println("코드번호 " + code);
		System.out.println(ht);
		if (code == 180) {
			msg = user.getId() + "님이 퇴장 하셨습니다 ! ";
		} else {
			msg = user.getId() + "님이 입장 하셨습니다 ! ";
		}
		System.out.println("챗 유저리스트" + chatuserlist);
		sd = new SendData(2500, msg, chatuserlist);
		for (User temp : userKey) {
			if (temp.getChatLocation().equals(title)) {
				ObjectOutputStream oos = ht.get(temp);
				if (oos != oos2) {
					try {
						System.out.println("여기는 업데이트 챗리스트 ->에게 뿌려야함 " + temp.getId());
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

	// 방장 임명 , 강퇴
	private void roomKingupdate(int code, String user, Vector<String> chatuserlist, ObjectOutputStream oos2,
			String title) {
		System.out.println("roomKingupdate       "+ chatuserlist);
		Set<User> userKey = ht.keySet(); // keySet()은 키들의 집합
		String msg = null;
		if (code == 160) {
			msg = user + "님이 강퇴당하셨습니다 ";

		} else {
			msg = "방장이" + chatuserlist.get(0) + "님으로 변경 되었습니다  ";

		}
		System.out.println("코드번호 " + code);
		System.out.println("챗 유저리스트" + chatuserlist);
		sd = new SendData(2300, msg, chatuserlist);
		for (User temp : userKey) {
			if (temp.getChatLocation().equals(title)) {

				ObjectOutputStream oos = ht.get(temp);

				try {
					System.out.println("여기는 업데이트 챗리스트 ->에게 뿌려야함 " + temp.getId());

					oos.writeObject(sd);
					oos.flush();
					oos.reset();

				} catch (IOException e) {
					e.printStackTrace();
				}
 

			}
		}
	}

	// 채팅방 정보 update
	// 방장 임명
	private void roomupdate(int code, String title, int max) {

		Set<User> userKey = ht.keySet(); // keySet()은 키들의 집합
		System.out.println("코드번호 " + code);
		sd = new SendData(1030, title, max);
		for (User temp : userKey) {
			if (temp.getChatLocation().equals(title)) {

				ObjectOutputStream oos = ht.get(temp);

				try {
					System.out.println("여기는 업데이트 챗리스트 ->에게 뿌려야함 " + temp.getId());
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

	// 대기실 유저리스트 갱신 , 방생성 갱신
	public void updateWaitList(Vector<User> waitUserList, Vector<ChatRoom> allchatRoomList, ObjectOutputStream myoos) {

		Set<User> userKey = ht.keySet(); // keySet()은 키들의 집합
		Vector<User> key = new Vector<User>(userKey);

		Vector<ChatRoomInfo> romminfo = new Vector<ChatRoomInfo>();
		for (int i = 0; i < allchatRoomList.size(); i++) {
			romminfo.add(allchatRoomList.get(i).getRoomInfo());
		}
		Object obj = null;
		for (User u : key) {
			if (u.getChatLocation().equals("대기실")) {
				System.out.println("대기실 업데이트");
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

	// 채팅방 정보만 갱신
	public void updateWaitList(Vector<ChatRoom> allchatRoomList) {

		Set<User> userKey = ht.keySet(); // keySet()은 키들의 집합
		Vector<User> key = new Vector<User>(userKey);

		Vector<ChatRoomInfo> romminfo = new Vector<ChatRoomInfo>();
		for (int i = 0; i < allchatRoomList.size(); i++) {
			romminfo.add(allchatRoomList.get(i).getRoomInfo());
		}
		Object obj = null;
		for (User u : key) {
			if (u.getChatLocation().equals("대기실")) {
				System.out.println("대기실 업데이트");
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
