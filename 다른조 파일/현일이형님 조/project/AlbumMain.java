	import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.NetworkInterface;
import java.security.acl.Group;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicBorders.FieldBorder;

public class AlbumMain extends JFrame {

	private JPanel pnlGroupTotal;
	private JPanel pnlNorth;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JButton btnGroupAdd;
	private JButton btnFileAdd;

	private JScrollPane scroll;
	private ArrayList<AlbumFile> albumFileList;
	private ArrayList<AlbumGroup> albumGroupList;

	public AlbumMain() {
		init();
		addListener();
		showFrame();
	}

	private void init() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		this.albumFileList = new ArrayList<AlbumFile>();
		this.albumGroupList = new ArrayList<AlbumGroup>();
		// North 패널 생성 및 부착
		File dir = new File(AlbumUtil.DEFALUT_ALBUME_PROPERTIES);
		if (!dir.exists()) {
			dir.mkdir();
		}
		fileLoad();
		addNorthPnl();
		addGroupPnl();
	}

	private void addListener() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				fileSave();
				System.exit(0);
			}
		});

		btnGroupAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AlbumGroupCreateDialog(AlbumMain.this);
			}
		});

		btnFileAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AlbumImportFile(AlbumMain.this);
			}
		});
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				boolean hashtagFlag = false;
				String searchStr = tfSearch.getText().trim();
				AlbumFile lastFile = new AlbumFile("aa");
				if (searchStr.length() == 0) {
					JOptionPane.showMessageDialog(AlbumMain.this, "검색 하고자 하는 해태그를 입력해주세요", "알림",
							JOptionPane.INFORMATION_MESSAGE);

				} else {
					for (AlbumFile fileInfo : getAlbumFileList()) {
						if (fileInfo.getHashtag().equals(searchStr)) {
							hashtagFlag = true;
							lastFile = fileInfo;
							// tfSearch.setText("");
						}
					}
					if (hashtagFlag) {
						new AlbumHashtagPicture(AlbumMain.this, lastFile.getFilePath(), searchStr);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(AlbumMain.this, "검색 결과가 없습니다");
					}

				}
			}

		});

	}

	private void showFrame() {
		setTitle("사진첩");
		setSize(AlbumUtil.SCREEN_WIDTH, AlbumUtil.SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}

	private void addNorthPnl() {
		// 버튼과 버튼 이미지 추가 및 텍스트필드 추가
		tfSearch = new JTextField(20);
		// 버튼과 크기를 맞추기 위해서 setPreferredSize를 해줌
		tfSearch.setPreferredSize(AlbumUtil.BUTTON_SIZE);
		btnSearch = new JButton();
		Image searchbtnImg = AlbumUtil.imgSizeChange(AlbumUtil.SEARCH_IMGPATH, 30, 30);
		btnSearch.setIcon(new ImageIcon(searchbtnImg));
		btnGroupAdd = new JButton();
		Image GroupButImg = AlbumUtil.imgSizeChange(AlbumUtil.PLUS_FORDER_ICON, 30, 30);
		btnGroupAdd.setIcon(new ImageIcon(GroupButImg));
		btnFileAdd = new JButton();
		Image FileOpenImg = AlbumUtil.imgSizeChange(AlbumUtil.FIlE_OPEN_ICON, 30, 30);
		btnFileAdd.setIcon(new ImageIcon(FileOpenImg));
		pnlNorth = new JPanel(new BorderLayout());
		JPanel pnlNorthButton = new JPanel();
		pnlNorthButton.add(tfSearch);
		pnlNorthButton.add(btnSearch);
		pnlNorthButton.add(btnGroupAdd);
		pnlNorthButton.add(btnFileAdd);
		pnlNorth.add(pnlNorthButton, BorderLayout.EAST);
		add(pnlNorth, BorderLayout.NORTH);
	}

	private void addGroupPnl() {
		pnlGroupTotal = new JPanel(new GridLayout(0, 2));
		AlbumCreateGroupPnl pnlGroup = new AlbumCreateGroupPnl(this);
		pnlGroupTotal.add(pnlGroup.CreateGroupPnlAll());
		for (AlbumGroup groupName : albumGroupList) {
			ArrayList<String> pictureList = groupName.getPictureInGroup();
			if (pictureList.size() != 0) {
				pnlGroupTotal
						.add(pnlGroup.CreateGroupPnlName(groupName.getName(), pictureList.get(pictureList.size() - 1)));
			} else {
				pnlGroupTotal.add(pnlGroup.CreateGroupPnlName(groupName.getName(), AlbumUtil.NO_IMG));
			}
		}
		scroll = new JScrollPane(pnlGroupTotal);
		scroll.getVerticalScrollBar().setUnitIncrement(20);
		add(scroll, BorderLayout.CENTER);
		validate();
		scroll.updateUI();
	}

	protected void pnlRePaint() {
		remove(pnlGroupTotal);
		remove(scroll);
		addGroupPnl();
	}

	private void fileSave() {
		File groupListPath = new File(AlbumUtil.DEFALUT_ALBUME_PROPERTIES_GROUP_DB);

		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream(groupListPath);
			dos = new DataOutputStream(fos);
			for (AlbumGroup groupName : albumGroupList) {
				if (!groupName.equals("전체")) {
					dos.writeUTF(groupName.getName());
					dos.writeUTF(AlbumUtil.fileInGroupToString(groupName.getPictureInGroup()));
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			AlbumUtil.closeAll(dos, fos);
		}
		File groupFilePathDb = new File(AlbumUtil.DEFALUT_ALBUME_PROPERTIES_FILE_DB);
		try {
			fos = new FileOutputStream(groupFilePathDb);
			dos = new DataOutputStream(fos);
			for (AlbumFile dbStr : albumFileList) {
				dos.writeUTF(dbStr.getFilePath());
				dos.writeUTF(dbStr.getHashtag());
				dos.writeUTF(dbStr.getExplanation());
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			AlbumUtil.closeAll(dos, fos);
		}
	}

	private void fileLoad() {
		File groupListFilePath = new File(AlbumUtil.DEFALUT_ALBUME_PROPERTIES_GROUP_DB);
		if (!groupListFilePath.exists()) {
			try {
				groupListFilePath.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			FileInputStream fis = null;
			DataInputStream dis = null;
			try {
				fis = new FileInputStream(groupListFilePath);
				dis = new DataInputStream(fis);
				while (dis.available() > 0) {
					String name = dis.readUTF();
					String fileListInGroup = dis.readUTF();
					ArrayList<String> fileInGroupList = new ArrayList<String>();
					if (fileListInGroup.length() != 0) {
						String[] fileList = fileListInGroup.split("\\|");
						for (String file : fileList) {
							fileInGroupList.add(file);
						}
					}
					AlbumGroup temp = new AlbumGroup(name);
					temp.setPictureInGroup(fileInGroupList);
					albumGroupList.add(temp);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				AlbumUtil.closeAll(dis, fis);
			}
		}
		File groupFilePathDb = new File(AlbumUtil.DEFALUT_ALBUME_PROPERTIES_FILE_DB);
		if (!groupFilePathDb.exists()) {
			try {
				groupFilePathDb.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			FileInputStream fis = null;
			DataInputStream dis = null;
			try {
				fis = new FileInputStream(groupFilePathDb);
				dis = new DataInputStream(fis);
				while (dis.available() > 0) {
					String filePath = dis.readUTF();
					String tag = dis.readUTF();
					String explanation = dis.readUTF();
					AlbumFile imgFileDb = new AlbumFile(filePath, tag, explanation);
					albumFileList.add(imgFileDb);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				AlbumUtil.closeAll(dis, fis);
			}
		}

		ArrayList<String> deleteFileList = new ArrayList<String>();
		for (AlbumFile fileInfo : albumFileList) {
			File file = new File(fileInfo.getFilePath());
			if (!file.exists()) {
				deleteFileList.add(file.getPath());
			}
		}
		for (String filepath : deleteFileList) {
			albumFileList.remove(new AlbumFile(filepath));
		}
		for (String filepath : deleteFileList) {
			for (AlbumGroup groupInfo : albumGroupList) {
				ArrayList<String> fileList  = groupInfo.getPictureInGroup();
				fileList.remove(filepath);
			}
		}
		
	}

	public ArrayList<AlbumFile> getAlbumFileList() {
		return albumFileList;
	}

	public void setAlbumFileList(ArrayList<AlbumFile> albumFileList) {
		albumFileList = albumFileList;
	}

	public ArrayList<AlbumGroup> getAlbumGroupList() {
		return albumGroupList;
	}

	public void setAlbumGroupList(ArrayList<AlbumGroup> albumGroupList) {
		albumGroupList = albumGroupList;
	}

	public static void main(String[] args) {
		new AlbumMain();
	}
}
