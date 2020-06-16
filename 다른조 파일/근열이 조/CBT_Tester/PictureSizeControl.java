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
	
	private JTextField tfWidth;	//���� �Է�â
	private JTextField tfHeight; 	//���� �Է�â
	private JLabel lblWidth;	// ���� :
	private JLabel lblHeigth;	// ���� :
	private int width;		//int������ �����ϱ� ���� �������
	private int heigth;		//int������ �����ϱ� ���� �������
	private JButton btnOk;		//���� ��ư
	private JButton btnCancel;	//��� ��ư
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
		lblWidth = new JLabel("���� : ");
		lblHeigth = new JLabel("���� : ");
		btnOk = new JButton("����");
		btnCancel = new JButton("�ݱ�");
	}

	
	private void setDisplay() {
		JPanel pnlNorth = new JPanel(new GridLayout(0,2));
			pnlNorth.add(lblWidth);
			pnlNorth.add(tfWidth);
			pnlNorth.add(lblHeigth);
			pnlNorth.add(tfHeight);
		pnlNorth.setBorder(new EmptyBorder(20,20,10,20));
		pnlNorth.setBorder(new TitledBorder("����ũ�⼳��"));
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
				JOptionPane.showMessageDialog(this, "������ �� �� �����ϴ�.");
			}
			
			width = Integer.parseInt(Wsize);		//String ���� ������ int�� ����
			heigth = Integer.parseInt(Hsize);	//String ���� ������ int�� ����
			
		
		} catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "���ڸ� �Է����ּ���.");
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
				JOptionPane.showMessageDialog(this, "���� �ʰ� (0~800���̷� �Է����ּ���.) ");
			} else if (tfWidth.getText().trim().length() != 0 || (tfHeight.getText().trim().length()) != 0 ){
				JOptionPane.showMessageDialog(this, "������ �� �� �����ϴ�.");
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
