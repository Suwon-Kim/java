import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.ByteOrder;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AlbumHashtagPicture extends JFrame {
	private JPanel pnlNorth;
	private AlbumMain albumMain;
	private String filePath;
	private ArrayList<AlbumFile> albumFileList;
	private AlbumSmallPicture albumSmallPicture;
	private String hashtag;
	private JPopupMenu pMenu ;
	private JMenuItem miAttribut;
	private JMenuItem miDelete;
	private JLabel lblPicture;

	public AlbumHashtagPicture(AlbumMain albumMain, String filePath, String hashtag) {
		this.albumMain = albumMain;
		this.filePath = filePath;
		this.albumFileList = albumMain.getAlbumFileList();
		this.hashtag = hashtag;
		init();
		addListener();
		showFrame();
	}

	private void init() {
		bitPicPnlAdd(filePath);
		smallSizePnlAdd();
	}
	

	private AlbumFile fileSearch(String filePath) {
		AlbumFile returnAlbumFile = new AlbumFile("이름 없음 ");
		for (AlbumFile fileInfo : albumMain.getAlbumFileList()) {
			if (fileInfo.getFilePath().equals(filePath)) {
				returnAlbumFile = fileInfo;
			}
		}
		return returnAlbumFile;
	}

	private void bitPicPnlAdd(String filePath) {
		pnlNorth = new JPanel(new GridLayout(0,2));
		lblPicture = new JLabel();
		Image imgPicture = AlbumUtil.imgSizeChange(filePath, 480, 480);
		lblPicture.setIcon(new ImageIcon(imgPicture));
		pnlNorth.add(lblPicture);
		pMenu = new JPopupMenu();
		miAttribut = new JMenuItem("속성");
		
		pMenu.add(miAttribut);
		
		lblPicture.addMouseListener(mlRightButton());
		miAttribut.addActionListener(alAttribute(filePath));
		
		
		JLabel lblExplanation = new JLabel("사진설명");
		JTextArea taExplanation = new JTextArea(5,30);
		JPanel pnlTaEx = new JPanel();
		pnlTaEx.add(lblExplanation);
		pnlTaEx.add(taExplanation );
		JLabel lblmg = new JLabel();
		Image bigPic = AlbumUtil.imgSizeChange(AlbumUtil.BIG_PIC, 400,340);
		lblmg.setIcon(new ImageIcon(bigPic));
		
		JLabel lblHash = new JLabel("Hashtag");
		JTextField tfHash = new JTextField(30);
		JPanel pnlHash = new JPanel();
		pnlHash.add(lblHash);
		pnlHash.add(tfHash);
		JPanel pnlPicInfo = new JPanel();
		pnlPicInfo.add(lblmg, BorderLayout.NORTH);
		pnlPicInfo.add(pnlHash, BorderLayout.CENTER);
		pnlPicInfo.add(pnlTaEx, BorderLayout.SOUTH);
		pnlNorth.add(pnlPicInfo);
		pnlPicInfo.setBorder(new EmptyBorder(0,40,40,40));
		taExplanation.setText(fileSearch(filePath).getExplanation());
		tfHash.setText(fileSearch(filePath).getHashtag());

		add(pnlNorth, BorderLayout.CENTER);
	}
	public void pnlNorthRepaint(String filePath){
		remove(pnlNorth);
		bitPicPnlAdd(filePath);
		pnlNorth.updateUI();
	}

	private void smallSizePnlAdd() {
		JPanel smallPic = new JPanel(new GridLayout(1, 0));
		
		for(AlbumFile fileInfo :albumMain.getAlbumFileList()){
			
			if(fileInfo.getHashtag().equals(hashtag)){
				AlbumCreateHashtagBigPicturePnl pnlCreate = new AlbumCreateHashtagBigPicturePnl(this,fileInfo.getFilePath());
				smallPic.add(pnlCreate.createSmallPnl());
			}
		}
		
		JScrollPane scroll = new JScrollPane(smallPic);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scroll.getHorizontalScrollBar().setUnitIncrement(16);
		add(scroll, BorderLayout.SOUTH);
	}

	private void showPopup(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getButton() == MouseEvent.BUTTON3) {
			pMenu.show(lblPicture, e.getX(), e.getY());
		}
	}


	private void addListener() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				albumMain.pnlRePaint();
				albumMain.setVisible(true);
				dispose();
			}
		});
	}

	private MouseListener mlRightButton(){
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showPopup(e);
			}
		};
	}
	
	private ActionListener alAttribute(String filePath){
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for(AlbumFile fileInfo : albumFileList){
					if(fileInfo.getFilePath().equals(filePath)){
						new AlbumAttributeDia(AlbumHashtagPicture.this, fileInfo);
					}
				}
			}
		};
	}
	
	private void showFrame() {
		setTitle("사진첩");
		setSize(AlbumUtil.SCREEN_WIDTH, AlbumUtil.SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
}
