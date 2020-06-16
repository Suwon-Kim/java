import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class AlbumSmallPicture extends JFrame {

	private AlbumMain albumMain;
	private String groupName;
	private AlbumCreateSmallPIcturePnl albumCreateSmallPIcturePnl;
	private JPanel pnlCenter;
	private JButton btnSelect;
	private JButton btnAllPictureSelect;
	private JButton btnPictureGroupMove;
	private JButton btnPictureRemove;
	private boolean selectActivationFlag = false;
	private ArrayList<AlbumFile> albumFileList;
	private ArrayList<AlbumGroup> albumGroupList;
	private ArrayList<AlbumCreateSmallPIcturePnl> albumCreateSmallPIcturePnlList;
	private JPanel total;
	private JScrollPane scroll;

	public AlbumSmallPicture(AlbumMain albumMain, String groupName) {
		this.albumFileList = albumMain.getAlbumFileList();
		this.albumGroupList = albumMain.getAlbumGroupList();
		this.albumMain = albumMain;
		this.groupName = groupName;
		init();
		addListener();
		showFrame();
	}


	private void init() {

		JPanel pnlNorth = createNorthPnl();
		add(pnlNorth, BorderLayout.NORTH);
		albumCreateSmallPIcturePnlList = new ArrayList<AlbumCreateSmallPIcturePnl>();
		pnlCenter = new JPanel();
		// 작은 그림들이 있는 패널을 만든다.
		pnlCenterAdd();
	}

	private void pnlCenterAdd() {
		albumCreateSmallPIcturePnlList = new ArrayList<AlbumCreateSmallPIcturePnl>();
		pnlCenter = new JPanel();
		// 작은 그림들이 있는 패널을 만든다.
		int smallPictureCount = 0;
		total = new JPanel(new GridLayout(0, 6));
		if (groupName.equals("전체")) {
			for (AlbumFile file : albumFileList) {
				albumCreateSmallPIcturePnl = new AlbumCreateSmallPIcturePnl(albumMain, this, groupName);
				albumCreateSmallPIcturePnlList.add(albumCreateSmallPIcturePnl);
				total.add(albumCreateSmallPIcturePnl.smallPictureAll(file.getFilePath()));
				smallPictureCount++;
			}
		} else {
			for (AlbumGroup groupList : albumGroupList) {
				if (groupList.getName().equals(groupName)) {
					for (String filepath : groupList.getPictureInGroup()) {
						albumCreateSmallPIcturePnl = new AlbumCreateSmallPIcturePnl(albumMain, this, groupName);
						albumCreateSmallPIcturePnlList.add(albumCreateSmallPIcturePnl);
						total.add(albumCreateSmallPIcturePnl.smallPictureInGroup(filepath));
						smallPictureCount++;
					}
				}
			}
		}
		btnActivation(false);
		pnlCenter.add(total);
		add(pnlCenter);
		if (smallPictureCount == 0) {
			int reusult = JOptionPane.showConfirmDialog(AlbumSmallPicture.this, "사진이 하나도 없습니다", "알림",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
			if (reusult == JOptionPane.OK_OPTION) {
				setVisible(false);
				albumMain.setVisible(true);
			}
		}
		TitledBorder innerBorder = new TitledBorder(
				new LineBorder(Color.BLUE,1),
				groupName
			);
		innerBorder.setTitleFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		
		scroll = new JScrollPane(pnlCenter);
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		scroll.setBorder(innerBorder);
		add(scroll, BorderLayout.CENTER);
	}

	protected void pnlRePaint() {
		remove(pnlCenter);
		remove(scroll);
		pnlCenterAdd();
		validate();
		
	}

	private void btnActivation(boolean flag) {
		btnAllPictureSelect.setEnabled(flag);
		btnPictureGroupMove.setEnabled(flag);
		btnPictureRemove.setEnabled(flag);
		selectActivationFlag =flag;
	}

	private void addListener() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				dispose();
			}
		});
		btnSelect.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(!selectActivationFlag){
					for (AlbumCreateSmallPIcturePnl pnl : albumCreateSmallPIcturePnlList) {
						pnl.cbActivation(selectActivationFlag);
					}
					btnActivation(true);
				}else{
					for (AlbumCreateSmallPIcturePnl pnl : albumCreateSmallPIcturePnlList) {
						pnl.cbActivation(selectActivationFlag);
					}
					btnActivation(false);
				}
			}
		});
		btnPictureRemove.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				ArrayList<String> deleteFileList = new ArrayList<String>();
				for (String filePath : cbSelectedToList()) {
					albumFileList.remove(new AlbumFile(filePath));
				}
				
				for (String filePath : cbSelectedToList()) {
					for (AlbumGroup groupInfo : albumGroupList) {
						groupInfo.getPictureInGroup().remove(filePath);
					}
				}
				selectActivationFlag = false;
				btnActivation(false);
				pnlRePaint();
				albumMain.pnlRePaint();
				
			}
		});
		btnAllPictureSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (AlbumCreateSmallPIcturePnl pnl : albumCreateSmallPIcturePnlList) {
					pnl.getCbSelect().setSelected(true);
				}
			}
		});
		btnPictureGroupMove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new AlbumFileMove(AlbumSmallPicture.this);
			}
		});
	}

	public ArrayList<String> cbSelectedToList() {
		ArrayList<String> selectedStringList = new ArrayList<String>();
		for (AlbumCreateSmallPIcturePnl pnl : albumCreateSmallPIcturePnlList) {
			if (pnl.getCbSelect().isSelected()) {
				selectedStringList.add(pnl.getFileName());
			}
		}
		return selectedStringList;
	}

	private void showFrame() {
		setTitle("사진첩");
		setSize(AlbumUtil.SCREEN_WIDTH, AlbumUtil.SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}

	private JPanel createNorthPnl() {
		JPanel pnlTotal = new JPanel(new BorderLayout());
		JPanel pnlEast = new JPanel(new FlowLayout());

		btnSelect = new JButton("선택");
		btnSelect.setPreferredSize(new Dimension(80, 26));
		btnAllPictureSelect = new JButton("전체  선택");
		btnPictureGroupMove = new JButton("그룹 이동");
		btnPictureRemove = new JButton("사진 삭체");

		btnAllPictureSelect.setEnabled(false);
		btnPictureGroupMove.setEnabled(false);
		btnPictureRemove.setEnabled(false);

		pnlEast.add(btnSelect);
		pnlEast.add(btnAllPictureSelect);
		pnlEast.add(btnPictureGroupMove);
		pnlEast.add(btnPictureRemove);

		pnlTotal.add(pnlEast, BorderLayout.EAST);

		return pnlTotal;
	}

	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public AlbumMain getAlbumMain() {
		return albumMain;
	}

	public void setAlbumMain(AlbumMain albumMain) {
		this.albumMain = albumMain;
	}
}
