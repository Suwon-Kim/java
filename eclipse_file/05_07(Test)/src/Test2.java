import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

public class Test2 extends JFrame {
	private JMenuBar mBar;
	private JMenu mFile;
	private JMenuItem miFemale_singer;
	private JMenuItem miMale_singer;
	private JMenuItem miExit;
	
	private JPanel pnlSouth;
	private JLabel lblPic;
	
	private JMenu fmOption;
	private JRadioButtonMenuItem rbmiOptionFMA;
	private JRadioButtonMenuItem rbmiOptionFMB;
	
	private JMenu mOption;
	private JRadioButtonMenuItem rbmiOptionMA;
	private JRadioButtonMenuItem rbmiOptionMB;
	
	private ImageIcon Image2;
	
	public Test2() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	public void init() {

		lblPic = new JLabel();
		mBar = new JMenuBar();
		mFile = new JMenu("File");
		miFemale_singer = new JMenuItem();
		miMale_singer = new JMenuItem();
		miExit = new JMenuItem("종료");
		
		
		fmOption = new JMenu("여자가수");
		rbmiOptionFMA = new JRadioButtonMenuItem("아이유",true);
		rbmiOptionFMB = new JRadioButtonMenuItem("에일리");
		
		mOption = new JMenu("남자예능인");
		rbmiOptionMA = new JRadioButtonMenuItem("서장훈");
		rbmiOptionMB = new JRadioButtonMenuItem("이수근",true);
		
		ButtonGroup group1 = new ButtonGroup();
		group1.add(rbmiOptionFMA);
		group1.add(rbmiOptionFMB);
		
		ButtonGroup group2 = new ButtonGroup();
		group2.add(rbmiOptionMA);
		group2.add(rbmiOptionMB);
		
	}
	public void setDisplay() {
		fmOption.add(rbmiOptionFMA);
		fmOption.add(rbmiOptionFMB);
		
		mOption.add(rbmiOptionMA);
		mOption.add(rbmiOptionMB);
		
		mFile.add(fmOption);
		mFile.add(mOption);
		mFile.add(miExit);
		
		mBar.add(mFile);
		setJMenuBar(mBar);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(lblPic);
		add(pnlSouth);
	}
	public void addListeners() {
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				String cmd = ae.getActionCommand();
				
				if(cmd.equals("아이유")) {
					lblPic.setIcon(new ImageIcon("1.jpg"));
				} else if(cmd.equals("에일리")) {
					lblPic.setIcon(new ImageIcon("2.jpg"));
				} else if (cmd.equals("서장훈")) {
					lblPic.setIcon(new ImageIcon("3.jpg"));
				} else {
					lblPic.setIcon(new ImageIcon("4.jpg"));
				}
				pack();
			}
		};
		rbmiOptionFMA.addActionListener(listener);
		rbmiOptionFMB.addActionListener(listener);
		rbmiOptionMA.addActionListener(listener);
		rbmiOptionMB.addActionListener(listener);
			
	}

	public void showFrame() {
		setTitle("창");
		setLocation(500,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test2();
	}
}
