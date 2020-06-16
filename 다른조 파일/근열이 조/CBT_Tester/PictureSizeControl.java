import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.security.acl.Owner;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.tools.DocumentationTool.Location;

public class PictureSizeControl extends JDialog{
	private PicturePreview owner;	
	
	private JTextField tfWidth;	//가로 입력창
	private JTextField tfHeight; 	//세로 입력창
	private JLabel lblWidth;	// 가로 :
	private JLabel lblHeigth;	// 세로 :
	private int width;		//int값으로 변경하기 위한 멤버변수
	private int heigth;		//int값으로 변경하기 위한 멤버변수
	private JButton btnOk;		//적용 버튼
	private JButton btnCancel;	//취소 버튼
	private Image img;	
	
	public PictureSizeControl(PicturePreview owner, Image img){
		super(owner, "Size", true);
		this.owner = owner;
		this.img = img;
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
		tfWidth = new JTextField(6);
		tfHeight = new JTextField(6);
		lblWidth = new JLabel("가로 : ");
		lblHeigth = new JLabel("세로 : ");
		btnOk = new JButton("적용");
		btnCancel = new JButton("닫기");
	}

	
	private void setDisplay() {
		JPanel pnlNorth = new JPanel(new GridLayout(0,2));
			pnlNorth.add(lblWidth);
			pnlNorth.add(tfWidth);
			pnlNorth.add(lblHeigth);
			pnlNorth.add(tfHeight);
		pnlNorth.setBorder(new EmptyBorder(20,20,10,20));
		pnlNorth.setBorder(new TitledBorder("사진크기설정"));
		JPanel pnlCenter = new JPanel();
			pnlCenter.add(btnOk);
			pnlCenter.add(btnCancel);
			
			
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
	}
	private void defaultSize(){
		String Wsize = String.valueOf(tfWidth.getText());
		String Hsize = String.valueOf(tfHeight.getText());
		try{
			if(Wsize.trim().length() == 0 || Hsize.trim().length() == 0) {
				JOptionPane.showMessageDialog(this, "공백이 들어갈 수 없습니다.");
			}
			
			width = Integer.parseInt(Wsize);		//String 값을 가져와 int로 변경
			heigth = Integer.parseInt(Hsize);	//String 값을 가져와 int로 변경
			
		
		} catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "숫자만 입력해주세요.");
		} 
	}
	
	private void changeSize(Image imgsize){
		
		owner.changePicture(imgsize);
	}
	
	

	private void addListeners() {
		btnOk.addActionListener((ae)->{
			
			defaultSize();
			try{
				Image imgsize = img.getScaledInstance(width, heigth, img.SCALE_SMOOTH);	
			if(width <= 800 && heigth <= 800) {
				changeSize(imgsize);
			} else if (width > 800 || heigth > 800) {
				JOptionPane.showMessageDialog(this, "길이 초과 (0~800사이로 입력해주세요.) ");
			} else if (tfWidth.getText().trim().length() != 0 || (tfHeight.getText().trim().length()) != 0 ){
				JOptionPane.showMessageDialog(this, "공백이 들어갈 수 없습니다.");
			} 
				
			}catch (IllegalArgumentException e) {
				// TODO: handle exception
			}	 
				
			
		});
		
		btnCancel.addActionListener((ae)-> {
			dispose();
		});
	}
	

	private void showFrame() {
//		setTitle("Size");
		setSize(250,150);
		setLocation(owner.getX()+400, owner.getY()+0);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		 
		
	}
}
