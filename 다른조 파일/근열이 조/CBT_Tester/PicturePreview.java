import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class PicturePreview extends JDialog{
	private Create owner;
	private JLabel lblPicture;
	private JTextField tfImageDir; // 사진 경로
	private JMenuBar mBar;	//메뉴바
	private JMenu mFile;	//메뉴파일
	private JMenuItem miSizeChange;	//메뉴아이템
	private Image img;	 
	public PicturePreview(Create owner, JTextField tfImageDir){
		super(owner, "미리보기", true);
		this.owner =owner;
		this.tfImageDir = tfImageDir;
		init();
		defaultPicture();
		setDisplay();	
		addListeners();
		showFrame();
	}

	private void init() {

	
		mBar = new JMenuBar();
		mFile = new JMenu("메뉴");
		miSizeChange = new JMenuItem("사진 크기 설정");

		setJMenuBar(mBar);
		
	}

	private void setDisplay() {	

		mFile.add(miSizeChange);
		mBar.add(mFile);
		add(lblPicture, BorderLayout.CENTER);
		
	}
	
	private void defaultPicture(){
		String imagePath = tfImageDir.getText();	//경로의 문장을 imagePath에 가져온다.
			img = Toolkit.getDefaultToolkit().getImage(imagePath);
			Image imgsize = img.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
			lblPicture = new JLabel(new ImageIcon(imgsize));
	}
	
	protected void changePicture(Image controlImg){
		lblPicture.setIcon(new ImageIcon(controlImg));	
	}
	
	private void addListeners() {
		miSizeChange.addActionListener((ae)-> {
			new PictureSizeControl(this, img);
		});
	}

	private void showFrame() {
		
		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(owner);
		setVisible(true);
	}

}