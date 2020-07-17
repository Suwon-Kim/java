
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatRoom_GUI extends JFrame {

	private JLabel lblRoomName; // �� �̸�
	private JLabel lblRoomPeople; // �� �ο�

	private JTextArea taChatRoom; // ä�ó���

	private JComboBox<String> cbInputOption; // �ο��� �޺��ڽ�

	private JTextField tfChatRoom; // �� ä�� �Է�

	private JButton btnSetting; // ���� ��ư
//	private JButton btnSend; // ������ ��ư
	private JButton btnInvite; // �ʴ� ��ư
	private JButton btnExit; // ������ ��ư

	private JScrollPane scrollpane; // ���� ����Ʈ ��ũ��
	private JScrollPane scrollpane2; // ä�ù� 

	private JPopupMenu chatRoomUserListPopupMenu; // ���� ����Ʈ �˾��޴�
	private JMenuItem grant_Host_Menu; // �˾� ����޴� - ��������
	private JMenuItem kick_Out_Menu; // �˾� ����޴� - ������
	private JMenuItem whisper_Menu; // �˾� ����޴� - �ӼӸ�
	private JMenuItem cancel_Menu; // �˾� ����޴� - ���
 
	private JList<String> chatRoomUserList; // �� ���� ����Ʈ
	private DefaultListModel<String> chatRoomUserModel; // �� ���� ����Ʈ ��
	private Vector<String> chatuserlist; // ä�ù� ��������Ʈ
	private Socket sock; // ����
	private ObjectOutputStream oos; // ���
	private ObjectInputStream ois; // �Է�
	private String title; // ����
	private String roomName; // �� ����
	private int maxPeople; // �ִ��ο�
	private int inwon; // ���ο�
	private ChatRoomInfo roomInfo; // �� ���� Ŭ����
	private String name; // �����̸�
	private User user;
	private String host;
	private String kickoutuser;

	public ChatRoom_GUI(ChatRoomInfo roomInfo, Socket sock, ObjectOutputStream oos, ObjectInputStream ois,
			String name) {
		this.name = name;
		this.sock = sock;
		this.oos = oos;
		this.ois = ois;
		this.roomInfo = roomInfo;
		RoomChat roomChatthread = new RoomChat();
		chatuserlist = roomInfo.getChatRoomUserList();
		inwon = roomInfo.getChatRoomUserList().size();
		maxPeople = roomInfo.getMaxPeople();
		title = roomInfo.getTitle();
		host = roomInfo.getChatRoom_host();
		user = new User(name.trim(), title.trim());
		roomChatthread.start();
		init();
		setDisplay();
		addListeners();
		showFrame();
	}

	private String msg;

	class RoomChat extends Thread {

		@Override
		public void run() {
			try {
				Object obj = null;
				while ((obj = ois.readObject()) != null) {
					SendData send = (SendData) obj;
					int code = send.getCode();
					System.out.println(" ��ȭ�� �Դϴ�  " + code);
					switch (code) {
					// ä�� �Է�
					case 2000:
						msg = (String) send.getObj()[0];

						taChatRoom.append(msg + "\n");
						taChatRoom.setCaretPosition(taChatRoom.getDocument().getLength());
						break;
					// ä�ù� ������ update

					case 2002:
						String wmessage = (String) send.getObj()[0];
						taChatRoom.append(wmessage + "\n");
						taChatRoom.setCaretPosition(taChatRoom.getDocument().getLength());
						break;
					case 2003:
						JOptionPane.showMessageDialog(ChatRoom_GUI.this, "�����Դ� �ӼӸ��� �Ͻ� �� �����ϴ�!!");
						break;
					case 2006:
						JOptionPane.showMessageDialog(ChatRoom_GUI.this, "�������� �ʴ� ���̵��Դϴ�.");
						break;

					// ++++++++++++++++++++
					// ����Ʈ �޾ƿ�
					case 777:
						Vector<User> waitUserList2 = (Vector<User>) send.getObj()[0];
						System.out.println("chatroom 777 ����Ʈ" + waitUserList2);
						String title2 = (String) send.getObj()[1];
						System.out.println("�ڵ� 777" + title2);
						new Invite_GUI(sock, oos, ois, name, waitUserList2, title2);
						break;
					// ++++++++++++++++++++
					// �ʴ� ����
					case 1071:
						JOptionPane.showMessageDialog(ChatRoom_GUI.this, "������ �ʴ븦 �����ϼ̽��ϴ�.");

						break;

					// ++++++++++++++++++++
					case 1073:
						JOptionPane.showMessageDialog(ChatRoom_GUI.this, "�̹� �濡 ���̽��ϴ�.!!:) ");

						break;
					case 1030:
						JOptionPane.showMessageDialog(ChatRoom_GUI.this, "ä�ù� ������ ����Ǿ����ϴ� ! ");
						title = (String) send.getObj()[0];
						maxPeople = (int) send.getObj()[1];
						lblRoomName.setText("����: " + title);
						lblRoomPeople.setText("�����ο� (" + chatuserlist.size() + "/" + maxPeople + ")");
						break;

					case 1031:
						JOptionPane.showMessageDialog(ChatRoom_GUI.this, "���� ä�ù� �ο����� max�ο��� �����ϴ�");
						break;

					case 1032:
						JOptionPane.showMessageDialog(ChatRoom_GUI.this, "���� ä�ù�� �̸��� �����ϴ� ! ");

						break;
					case 1033:
						JOptionPane.showMessageDialog(ChatRoom_GUI.this, "ä�ù��̸��� �ߺ��Դϴ�!");
						break;

					case 2400:

						Vector<User> waitUserList = (Vector<User>) send.getObj()[0];
						Vector<ChatRoomInfo> roominfolist = (Vector<ChatRoomInfo>) send.getObj()[1];

						new WaitingRoom_GUI(sock, oos, ois, waitUserList, roominfolist, name);
						dispose();
 
						break;
					case 2401:
						String message = String.valueOf(send.getObj()[0]);
						Vector<User> waitUser = (Vector<User>) send.getObj()[1];
						Vector<ChatRoomInfo> roominfo = (Vector<ChatRoomInfo>) send.getObj()[2];
						String kickuser = String.valueOf(send.getObj()[3]);
						JOptionPane.showMessageDialog(ChatRoom_GUI.this, message);
						new WaitingRoom_GUI(sock, oos, ois, waitUser, roominfo, kickuser);
						dispose();

						/*
						 * synchronized (this) { wait(); }
						 */
						break;
					// user����������->��������Ʈ update
					case 2500:
						System.out.println("2500�� ���� ����????????? ");
						msg = (String) send.getObj()[0];
						chatuserlist = (Vector<String>) send.getObj()[1];
						System.out.println("2500 " + chatuserlist);

						taChatRoom.append(msg + "\n");
						taChatRoom.setCaretPosition(taChatRoom.getDocument().getLength());
						chatRoomUserModel.removeAllElements();
						// ���� �������� ���ߵ�
						if (chatuserlist != null) {
							for (int i = 0; i < chatuserlist.size(); i++) {
								chatRoomUserModel.addElement(chatuserlist.get(i));
							}
							lblRoomPeople.setText("�����ο� (" + chatuserlist.size() + "/" + maxPeople + ")");
						}

						break;
					// ���� ����
					case 2300:
						msg = (String) send.getObj()[0];
						chatuserlist = (Vector<String>) send.getObj()[1];
						taChatRoom.append(msg + "\n");

						chatRoomUserModel.removeAllElements();
						// ���� �������� ���ߵ�
						for (int i = 0; i < chatuserlist.size(); i++) {
							chatRoomUserModel.addElement(chatuserlist.get(i));
						}
						System.out.println(roomInfo.getMaxPeople());
						lblRoomPeople.setText("�����ο� (" + chatuserlist.size() + "/" + maxPeople + ")");

						isHost(chatuserlist.get(0));
						roomInfo.setChatRoom_host(chatuserlist.get(0));
						break;
					case 2301:
						chatuserlist = (Vector<String>) send.getObj()[0];
						new Appoint_GUI(sock, oos, ois, host, chatuserlist, title);
						break;
					case 2032:
						JOptionPane.showMessageDialog(ChatRoom_GUI.this, "ä�ù濡 ������ ã�� �� �����ϴ�");
						new Appoint_GUI(sock, oos, ois, host, chatuserlist, title);
						break;
					} // switch ��
					if (code == 2400 || code == 2401) {
						break;
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("����");
			} finally{
				
			
			}
			// 2000õ�� �������� t
		}
	}

	private void init() {
		lblRoomName = new JLabel("����: " + title);
		lblRoomName.setFont(new Font("���� ����", Font.BOLD, 15));
		lblRoomPeople = new JLabel("�����ο� (" + chatuserlist.size() + "/" + maxPeople + ")");

		taChatRoom = new JTextArea(15, 32);
		taChatRoom.setEditable(false);
		taChatRoom.setLineWrap(true);
//		taChatRoom.setForeground(Color.blue);

		cbInputOption = new JComboBox<String>();
		cbInputOption.addItem("��ȭ��");
		cbInputOption.addItem("�ӼӸ�");
		cbInputOption.setPreferredSize(new Dimension(70, 24));

		tfChatRoom = new JTextField(25);

		btnSetting = new JButton(new ImageIcon("setting.png"));
		btnSetting.setBorderPainted(false); // ��ư �ܰ��� ����
		btnSetting.setContentAreaFilled(false); // ���� ���� ä��� ����
		btnSetting.setFocusPainted(false); // ���ý� �׵θ� ����
		btnSetting.setPreferredSize(new Dimension(32, 32));
		
		btnInvite = new JButton("Invite");
		btnInvite.setUI(new Design_ButtonUI());
		btnInvite.setPreferredSize(new Dimension(66, 28));
		btnInvite.setBackground(new Color(0x3399FF));
		
		btnExit = new JButton("Exit"); 
		btnExit.setUI(new Design_ButtonUI());  
		btnExit.setPreferredSize(new Dimension(55, 28));
		btnExit.setBackground(new Color(0xFFCC00));
		chatRoomUserList = new JList(new DefaultListModel<>());
		
		scrollpane2 = new JScrollPane(taChatRoom);
		scrollpane2.setPreferredSize(new Dimension(356,258));
		

		class MyCellRender extends DefaultListCellRenderer {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (index == 0) {
					setIcon(new ImageIcon("Crown.png"));
				} else {
					setIcon(new ImageIcon("Basic.png"));
				}
				if (value.equals(name)) {
					setText(name + " < �� >");
				}

				return this;
			}

			// ����
			public int getHorizontalAlignment() {
				return LEFT;
			}
		}

		chatRoomUserList.setCellRenderer(new MyCellRender());

		chatRoomUserModel = (DefaultListModel<String>) chatRoomUserList.getModel();

		chatRoomUserModel.removeAllElements();
		for (int i = 0; i < inwon; i++) {
			chatRoomUserModel.addElement(roomInfo.getChatRoomUserList().get(i));
		}
		scrollpane = new JScrollPane(chatRoomUserList);
		scrollpane.setPreferredSize(new Dimension(130, 257));

		chatRoomUserListPopupMenu = new JPopupMenu();

		grant_Host_Menu = new JMenuItem("��������");
		kick_Out_Menu = new JMenuItem("��������");
		whisper_Menu = new JMenuItem("�ӼӸ�");
		cancel_Menu = new JMenuItem("���");

		chatRoomUserListPopupMenu.add(grant_Host_Menu);
		chatRoomUserListPopupMenu.add(kick_Out_Menu);
		chatRoomUserListPopupMenu.add(whisper_Menu);
		chatRoomUserListPopupMenu.add(cancel_Menu);

		isHost(host);

	}

	private void isHost(String select) {
		host = select;
		System.out.println("??" + select);
		if ((name.equals(select))) {
			chatRoomUserListPopupMenu.add(grant_Host_Menu);
			chatRoomUserListPopupMenu.add(kick_Out_Menu);
			chatRoomUserListPopupMenu.add(whisper_Menu);
			chatRoomUserListPopupMenu.add(cancel_Menu);

		} else {
			chatRoomUserListPopupMenu.remove(grant_Host_Menu);
			chatRoomUserListPopupMenu.remove(kick_Out_Menu);
		}
	}

	private void setDisplay() {

		JPanel pnlCenter = new JPanel(new BorderLayout());

		JPanel pnlWest = new JPanel(new BorderLayout());

		JPanel pnlWestTop = new JPanel(new GridLayout(1, 0));
		JPanel pnllblRoomName = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnllblRoomName.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		pnllblRoomName.add(lblRoomName);

		JPanel pnlbtnSetting = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pnlbtnSetting.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
		pnlbtnSetting.add(btnSetting);

		pnlWestTop.add(pnllblRoomName);
		pnlWestTop.add(pnlbtnSetting);
		pnlWestTop.setPreferredSize(new Dimension(100, 40));

		JPanel pnlWestCenter = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlWestCenter.add(scrollpane2);

		JPanel pnlWestBottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlWestBottom.setBorder(BorderFactory.createEmptyBorder(-5, 0, 6, 0));
		pnlWestBottom.add(cbInputOption);
		pnlWestBottom.add(tfChatRoom);

		pnlWest.add(pnlWestTop, BorderLayout.NORTH);
		pnlWest.add(pnlWestCenter, BorderLayout.CENTER);
		pnlWest.add(pnlWestBottom, BorderLayout.SOUTH);

		JPanel pnlEast = new JPanel(new BorderLayout());

		JPanel pnlEastTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlEastTop.add(lblRoomPeople);
		pnlEastTop.setPreferredSize(new Dimension(100, 40));
		pnlEastTop.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

		JPanel pnlEastCenter = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlEastCenter.add(scrollpane);

		JPanel pnlEastBottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlEastBottom.setBorder(BorderFactory.createEmptyBorder(-5, 0, 6, 0));
		pnlEastBottom.add(btnInvite);
		pnlEastBottom.add(btnExit);

		pnlEast.add(pnlEastTop, BorderLayout.NORTH);
		pnlEast.add(pnlEastCenter, BorderLayout.CENTER);
		pnlEast.add(pnlEastBottom, BorderLayout.SOUTH);

		pnlCenter.add(pnlWest, BorderLayout.WEST);
		pnlCenter.add(pnlEast, BorderLayout.EAST);

		add(pnlCenter, BorderLayout.CENTER);
	}

	// ��ư ������
	private void addListeners() {
		ActionListener alistener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == btnInvite) {
					// ++++++++++++++++++++
					SendData send = new SendData(77, title);
					try {
						oos.writeObject(send);
						oos.flush();
						oos.reset();
					} catch (IOException e2) {
						e2.printStackTrace();
					}

				} else if (obj == btnExit) {
					int result = JOptionPane.showConfirmDialog(ChatRoom_GUI.this, "�����ðڽ��ϱ� ?", "������",
							JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

					if (result == 0) {
						if (chatuserlist.size() > 1) {
							if (host.equals(name)) {
								new Appoint_GUI(sock, oos, ois, host, chatuserlist, title);
								return;
							}
						}

						dispose();
						SendData send = new SendData(180, title);
						try {
							oos.writeObject(send);
							oos.flush();
							oos.reset();
						} catch (IOException e2) {
							e2.printStackTrace();
						}

					} else {

					}
				} else if (obj == btnSetting) {
					if (name.equals(host)) {
						new ChatRoom_Setting_GUI(sock, oos, title);
					} else {
						JOptionPane.showMessageDialog(null, "���常 ���� �����մϴ�!!");
					}

				}
			}
		};

//		btnSend.addActionListener(alistener);
		btnInvite.addActionListener(alistener);
		btnExit.addActionListener(alistener);
		btnSetting.addActionListener(alistener);

		// X��ư ���� ������
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(ChatRoom_GUI.this, "�����ðڽ��ϱ� ?", "������",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (result == 0) {
					dispose();
					SendData send = new SendData(180, title);
					try {
						oos.writeObject(send);
						oos.flush();
						oos.reset();
					} catch (IOException e2) {
						e2.printStackTrace();
					}

				} else {

				}
			}
		});

		// ��������Ʈ ���콺 ������
		MouseListener mlistener = new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				check(e);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				check(e);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Object obj = e.getSource();
				// ���� Ŭ���� �ش� ���� �� ��������
				if (e.getClickCount() == 2 && obj == chatRoomUserList) {
					// System.out.println(chatRoomUserList.getSelectedValue());
				}
			};

		};
		chatRoomUserList.addMouseListener(mlistener);

		// ��������Ʈ �˾��޴� ������
		ActionListener menuListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if (obj == grant_Host_Menu) {
					System.out.println("��������");
					String select = chatRoomUserList.getSelectedValue();
					if (select.equals(host)) {
						JOptionPane.showMessageDialog(ChatRoom_GUI.this, "�̹� �����Դϴ� !! ");

					} else {
						int result = JOptionPane.showConfirmDialog(ChatRoom_GUI.this, select + "���� �Ӹ��Ͻðڽ��ϱ� ?", "������",
								JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						if (result == 0) {
							SendData send = new SendData(140, select, title);
							try {
								oos.writeObject(send);
								oos.flush();
								oos.reset();
								System.out.println("���� �Ӹ� ����");
							} catch (Exception me) {
								me.printStackTrace();
							}
						}
					}
					System.out.println(select);
				} else if (obj == kick_Out_Menu) {
					System.out.println("����");
					kickoutuser = chatRoomUserList.getSelectedValue();
					if (kickoutuser.equals(host)) {
						JOptionPane.showMessageDialog(ChatRoom_GUI.this, "������ �����ϽǼ� �����ϴ� ");

					} else {
						int result = JOptionPane.showConfirmDialog(ChatRoom_GUI.this, kickoutuser + "���� �����Ͻðڽ��ϱ� ?",
								"������", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						if (result == 0) {
							SendData send = new SendData(160, kickoutuser, title);
							try {
								oos.writeObject(send);
								oos.flush();
								oos.reset();
								System.out.println("���� �Ӹ� ����");
							} catch (Exception me) {
								me.printStackTrace();
							}
						}
					}

				} else if (obj == whisper_Menu) {
					System.out.println("�ӼӸ�");
					cbInputOption.setSelectedItem("�ӼӸ�");
					tfChatRoom.setText("/to " + chatRoomUserList.getSelectedValue() + " ");
					int start = tfChatRoom.getText().indexOf(" ") + 1;
					int end = tfChatRoom.getText().indexOf(" ", start);
					tfChatRoom.setSelectionStart(end + 1);
					tfChatRoom.requestFocus();
				} else if (obj == cancel_Menu) {
					System.out.println("���");
				}
			}
		};
		grant_Host_Menu.addActionListener(menuListener);
		kick_Out_Menu.addActionListener(menuListener);
		whisper_Menu.addActionListener(menuListener);
		cancel_Menu.addActionListener(menuListener);
		// ä���Է�â ����Ű�� �Է�
		tfChatRoom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					if (cbInputOption.getSelectedItem().equals("�ӼӸ�")) {
						// if(tfWaitingRoomChat.getText().equals("/to ")) {
						String msg = tfChatRoom.getText();
						SendData send = new SendData(202, msg, title);
						try {
							oos.writeObject(send);
							oos.flush();
							oos.reset();
							System.out.println("�ӼӸ� ����");
						} catch (Exception me) {
							me.printStackTrace();
						}
						int start = tfChatRoom.getText().indexOf(" ") + 1;
						int end = tfChatRoom.getText().indexOf(" ", start);

						tfChatRoom.setSelectionStart(end + 1);
						tfChatRoom.requestFocus();

					} else if (cbInputOption.getSelectedItem().equals("��ȭ��")) {
						String msg = tfChatRoom.getText();
						if (msg.trim().length() > 0) {
							SendData send = new SendData(200, msg);
							try {
								oos.writeObject(send);
								oos.flush();
								oos.reset();
								System.out.println("��ȭ�� �޼��� ����");
							} catch (Exception me) {
								me.printStackTrace();
							}
							tfChatRoom.selectAll();
							tfChatRoom.requestFocus();
							tfChatRoom.setText("");
						}
						// taWaitingRoomChat.append(msg+"\n");
						taChatRoom.setCaretPosition(taChatRoom.getDocument().getLength());
					}
				}
			}
		});

		// �޺��ڽ� ������
		ItemListener ilistener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Object obj = cbInputOption.getSelectedItem();
					if (obj.equals("����")) {
						tfChatRoom.setText("");
						System.out.println("����");
					} else if (obj.equals("�ӼӸ�")) {
						System.out.println("�ӼӸ�");
						tfChatRoom.setText("/to �ӼӸ� ����) /to ������̵� �����޼���");
						tfChatRoom.setSelectionStart(4);
						tfChatRoom.requestFocus();

					}
				}
			}
		};
		cbInputOption.addItemListener(ilistener);
	}

	// ��������Ʈ���� �˾��޴��� ���õ� ���� ����
	public void check(MouseEvent e) {
		if (e.isPopupTrigger()) { // if the event shows the menu
			chatRoomUserList.setSelectedIndex(chatRoomUserList.locationToIndex(e.getPoint()));
			chatRoomUserListPopupMenu.show(chatRoomUserList, e.getX(), e.getY());

		}
	}

	private void showFrame() {
		setIconImage(new ImageIcon("home.png").getImage());
		setTitle("Chat Room");
		pack();
		// setSize(600,450);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}

}