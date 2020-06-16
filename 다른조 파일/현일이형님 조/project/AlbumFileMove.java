import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

public class AlbumFileMove extends JDialog {
	private AlbumSmallPicture albumSmallPicture;
	private AlbumMain albumMain;
	private JButton btnFileImport;
	
	private JPanel emptyPnl1;
	private JPanel pnlCheckBox;
	private ArrayList<AlbumFile> albumFileList;
	private ArrayList<JCheckBox> cbCheckBoxList;
	private ArrayList<AlbumGroup> albumGroupList;

	private File[] importFiles;

	private JTextField tfFilePath;
	private JTextField tfHashtag;
	private JTextArea taExplanation;
	private JButton btnGroupAdd;
	private JButton btnApply;

	public AlbumFileMove(AlbumSmallPicture albumSmallPicture) {
		super(albumSmallPicture, "����ø - ���� �̵�", true);
		albumMain = albumSmallPicture.getAlbumMain();
		this.albumSmallPicture = albumSmallPicture;
		this.albumFileList = albumMain.getAlbumFileList();
		this.albumGroupList = albumMain.getAlbumGroupList();
		cbCheckBoxList = new ArrayList<JCheckBox>();
		init();
		addListener();
		showFrame();
	}
		
	private void init() {
		JPanel pnlMain = new JPanel(new BorderLayout());
		
		emptyPnl1 = new JPanel();
		JPanel emptyPnl2 = new JPanel();
		JPanel emptyPnl3 = new JPanel();
		// �̸� ��Ʈ
		JPanel pnlFilePart = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		JLabel lblFile = new JLabel("����",JLabel.RIGHT);
		lblFile.setPreferredSize(new Dimension(55,18));
		JPanel pnlLblFIle = new JPanel();
		pnlLblFIle.add(lblFile);
		tfFilePath = new JTextField(37);
		tfFilePath.setEnabled(false);	
		tfFilePath.setPreferredSize(AlbumUtil.BUTTON_SIZE);
		JPanel pnlTfilePath = new JPanel(new FlowLayout());
		pnlTfilePath.add(tfFilePath);
		pnlFilePart.add(pnlLblFIle);
		pnlFilePart.add(pnlTfilePath);
		btnFileImport = new JButton();
		moveFileListCheck();
//		btnFileImport.setEnabled(false);
		Image photoAddImg = AlbumUtil.imgSizeChange(AlbumUtil.PHOTO_PLUS_ICON, 30, 30);
		btnFileImport.setIcon(new ImageIcon(photoAddImg));
		JPanel pnlBtnFIleImport =  new JPanel();
		pnlBtnFIleImport.add(btnFileImport);
		pnlFilePart.add(pnlBtnFIleImport);
		pnlBtnFIleImport.setPreferredSize(new Dimension(66,48));
		//�׷� ��Ʈ
		JPanel pnlGroupPart = new JPanel(new BorderLayout());
		JLabel lblGroup = new JLabel("�׷�",JLabel.CENTER);
		
		emptyPnl1.setPreferredSize(new Dimension(66,48));
		lblGroup.setPreferredSize(new Dimension(60,18));
		pnlGroupPart.add(lblGroup,BorderLayout.WEST);
		pnlGroupPart.setBorder(new EmptyBorder(0,9,20,0));
		pnlCheckBox = new JPanel(new GridLayout(0,3));

		for(AlbumGroup groupInfo :albumGroupList){
			String groupName = groupInfo.getName();
			JCheckBox cbGroupName= new JCheckBox(groupName);
			pnlCheckBox.add(cbGroupName);
			cbCheckBoxList.add(cbGroupName);
			for(String filePath : groupInfo.getPictureInGroup()){
				for(String str : albumSmallPicture.cbSelectedToList() ){
					if(albumSmallPicture.cbSelectedToList().size()==1){
					if(str.equals(filePath)){
						cbGroupName.setSelected(true);
					}
					}
				}
			}
		}
		JScrollPane scroll = new JScrollPane(pnlCheckBox);
		scroll.scrollRectToVisible(new Rectangle(100,20));
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		scroll.updateUI();
		pnlGroupPart.add(scroll);
		
		btnGroupAdd = new JButton();
		Image groupAddImg = AlbumUtil.imgSizeChange(AlbumUtil.PLUS_FORDER_ICON, 30, 30);
		btnGroupAdd.setIcon(new ImageIcon(groupAddImg));
		emptyPnl1.add(btnGroupAdd);
		pnlGroupPart.add(emptyPnl1,BorderLayout.EAST);

		//�ؽ� ��Ʈ
		JPanel pnlHashtag = new JPanel(new FlowLayout(FlowLayout.LEFT,6,0));
		JLabel lblHashtag = new JLabel("�ؽ� �±�");
		emptyPnl2.setPreferredSize(new Dimension(66,48));
		lblHashtag.setPreferredSize(new Dimension(55,18));
		tfHashtag = new JTextField(37);
		tfHashtag.setEditable(false);
		JPanel pnlTfHashTag = new JPanel();
		pnlTfHashTag.add(tfHashtag);
		pnlHashtag.add(lblHashtag);
		pnlHashtag.add(pnlTfHashTag);
		pnlHashtag.add(emptyPnl2);
		
		
		// ���� �κ�
		JPanel pnlExplanationPart = new JPanel(new FlowLayout(FlowLayout.LEFT,6,0));
		JLabel lblExplanation = new JLabel("���� ����");
		lblExplanation.setPreferredSize(new Dimension(55,18));
		taExplanation = new JTextArea(5,37);
		taExplanation.setLineWrap(true);
		taExplanation.setWrapStyleWord(true);
		JPanel pnlTaExplanation  = new JPanel();
		pnlTaExplanation.add(taExplanation);
		emptyPnl3.setPreferredSize(new Dimension(66,48));
		pnlExplanationPart.add(lblExplanation,BorderLayout.WEST);
		pnlExplanationPart.add(new JScrollPane(taExplanation),BorderLayout.CENTER);	
		pnlExplanationPart.add(emptyPnl3,BorderLayout.EAST);
		
		if(albumSmallPicture.cbSelectedToList().size()==1){
			for(AlbumFile fileInfo :albumFileList ){
				if(albumSmallPicture.cbSelectedToList().get(0).toString().equals(fileInfo.getFilePath())){
					tfHashtag.setText(fileInfo.getHashtag());
					taExplanation.setText(fileInfo.getExplanation());
				}
			}
		}
		
		
		// ��ư �κ�
		
		JPanel pnlBtnApply =new JPanel();
		btnApply = new JButton("����");

		pnlBtnApply.add(btnApply);
		
		JPanel pnlNorth = new JPanel();
		JPanel pnlCenter = new JPanel(new GridLayout(2,0));
		JPanel pnlSouth = new JPanel(new GridLayout(0,1));
		
		pnlNorth.add(pnlFilePart);
		pnlCenter.add(pnlGroupPart);
		pnlCenter.add(pnlExplanationPart);
		pnlSouth.add(pnlHashtag);
		pnlSouth.add(pnlBtnApply);
		
		pnlMain.add(pnlNorth, BorderLayout.NORTH);
		pnlMain.add(pnlCenter, BorderLayout.CENTER);
		pnlMain.add(pnlSouth , BorderLayout.SOUTH);
		add(pnlMain);
	}
	private void moveFileListCheck(){
		if(albumSmallPicture.cbSelectedToList().size()==0){
			JOptionPane.showMessageDialog(albumSmallPicture, "������ �������ּ���","���"
					,JOptionPane.WARNING_MESSAGE);
			dispose();
		}else if(albumSmallPicture.cbSelectedToList().size()==1){
			tfFilePath.setText(albumSmallPicture.cbSelectedToList().get(0));
		}else{ 
			tfFilePath.setText("������  ������ ���� �Ǿ� �ֽ��ϴ�");
			JOptionPane.showMessageDialog(albumSmallPicture, "������ ��� ������ ������ ���� �˴ϴ�.", "�˸�", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void groupPartRePaint(){
		pnlCheckBox.removeAll();
		for(AlbumGroup groupInfo :albumGroupList){
			String groupName = groupInfo.getName();
			JCheckBox cbGroupName= new JCheckBox(groupName);
			pnlCheckBox.add(cbGroupName);
			cbCheckBoxList.add(cbGroupName);
		}
		pnlCheckBox.updateUI();
	}

	private void addListener() {
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				dispose();
			}

		});
		
		btnApply.addActionListener(new ActionListener() {
			/*
			 * �ߺ� ���� �޼ҵ�
			 * ���� ���̾Ʒα׿� �ִ� ��� ������ ���� �Ѵ�
			 * �ߺ��� ������ ���� �ϴ� �޼ҵ� ȣ�� ��
			 * �ҷ� ������ �ϴ� ���ϰ� ��� �ִ� ������ �� �ؼ� ���� ������ ��� ���� �Ѵ�.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> moveseletedFilePahtArrayList;
				moveseletedFilePahtArrayList = albumSmallPicture.cbSelectedToList();

				for(String fileName : moveseletedFilePahtArrayList){
					for(AlbumGroup groupInfo :albumGroupList){
						groupInfo.getPictureInGroup().remove(fileName);
						albumFileList.remove(new AlbumFile(fileName));
					}
				}
				
				for (String fileName : moveseletedFilePahtArrayList) {
					String filePath = fileName;
					String hashtag = tfHashtag.getText().trim();
					String explanation = taExplanation.getText();
					AlbumFile albumFile = new AlbumFile(filePath ,hashtag , explanation);
					albumFileList.add(albumFile);
				}
				ArrayList<String> cbCheckedGroupList = CbGroupChecker();
				
				for(String checkedGroupName : cbCheckedGroupList){
					for(AlbumGroup groupInfo : albumGroupList){
						if(groupInfo.getName().equals(checkedGroupName)){
							for(String fileName : moveseletedFilePahtArrayList){
								groupInfo.getPictureInGroup().add(fileName);
							}
						}
					}
				}
				albumMain.pnlRePaint();
				albumSmallPicture.pnlRePaint();
				dispose();
			}
		});
		btnGroupAdd.addActionListener(alGroupAdd());
		btnFileImport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
			}
		});
	}
	private ActionListener alGroupAdd(){
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AlbumGroupCreateDialog(AlbumFileMove.this);
			}
		};
	}
	
	// �߰��� ���� �迭���� �ߺ��� ������ ���� ���� ����Ʈ ��ȯ
	private ArrayList<File> importFileSameDeleteList() {
		ArrayList<File> deleteFileNames = new ArrayList<File>();
		ArrayList<File> importFileArrayList = new ArrayList<File>();
		int sameFileCount = 0;
		
		for (File fileName : importFiles) {
			importFileArrayList.add(fileName);
		}
		
		for(File fileName :importFileArrayList){
			for(AlbumFile fileInfo : albumFileList){
				if(fileInfo.getFilePath().equals(fileName.getPath())){
					deleteFileNames.add(fileName);
					sameFileCount++;
				}
			}
		}
		for(File deleteFile :deleteFileNames){
			importFileArrayList.remove(deleteFile);
		}
		if(sameFileCount!=0){
			JOptionPane.showMessageDialog(AlbumFileMove.this, "�ߺ����� " + sameFileCount + "�� ���� �Ǿ����ϴ�", "�˸�", JOptionPane.YES_OPTION);
		}
		return importFileArrayList;
	}
	
	// üũ����Ʈ�� �ִ� ������ ��Ʈ�� ����Ʈ�� ��ȯ�Ѵ�.
	private ArrayList<String> CbGroupChecker() {
		ArrayList<String> cbCheckedGroupList = new ArrayList<String>();
		for (JCheckBox groupCb : cbCheckBoxList) {
			if (groupCb.isSelected()) {
				cbCheckedGroupList.add(groupCb.getText());
			}
		}
		return cbCheckedGroupList;
	}
	public AlbumMain getAlbumMain() {
		return albumMain;
	}

	public void setAlbumMain(AlbumMain albumMain) {
		this.albumMain = albumMain;
	}

	private void showFrame() {
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}

}
