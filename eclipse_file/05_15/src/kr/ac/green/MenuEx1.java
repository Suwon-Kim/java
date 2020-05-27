package kr.ac.green;

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

public class MenuEx1 extends JFrame{
	private JMenuBar mBar;
	private JMenu mFile;
	private JMenuItem miFemale_singer;
	private JMenuItem miMale_singer;
	private JMenuItem miExit;
	
	private JPanel pnlSouth;
	private JLabel lblPic;
	private JMenu fmOption;
	private JRadioButtonMenuItem rbmiOptionFMA; //������ 1
	private JRadioButtonMenuItem rbmiOptionFMB; //������ 2
	
	private JMenu mOption;
	private JRadioButtonMenuItem rbmiOptionMA;	// ������ 1
	private JRadioButtonMenuItem rbmiOptionMB;	// ������ 2
	
	public MenuEx1() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
		pnlSouth = new JPanel();
		lblPic = new JLabel();
		mBar = new JMenuBar();
		mFile = new JMenu("File");
		miFemale_singer = new JMenuItem("���ڰ���");
		miMale_singer = new JMenuItem("���ڰ���");
		miExit = new JMenuItem("����");
		
		fmOption = new JMenu("���ڰ���");
		rbmiOptionFMA = new JRadioButtonMenuItem("������", true);
		rbmiOptionFMB = new JRadioButtonMenuItem("���ϸ�");
		
		ButtonGroup group1 = new ButtonGroup();
		group1.add(rbmiOptionFMA);
		group1.add(rbmiOptionFMB);
		
		mOption = new JMenu("���ڰ���");
		rbmiOptionMA = new JRadioButtonMenuItem("������",true);
		rbmiOptionMB = new JRadioButtonMenuItem("�̼���");
		
		ButtonGroup group2 = new ButtonGroup();
		group2.add(rbmiOptionMA);
		group2.add(rbmiOptionMB);
		
	}
	private void setDisplay() {
		
		fmOption.add(rbmiOptionFMA);
		fmOption.add(rbmiOptionFMB);
		
		mOption.add(rbmiOptionMA);
		mOption.add(rbmiOptionMB);
		
		mFile.add(fmOption);
		mFile.add(mOption);
		mFile.add(miExit);
		
		mBar.add(mFile);
		
		setJMenuBar(mBar);
		pnlSouth.add(lblPic);
		add(pnlSouth);
		
	}
	private void addListeners() {
		ActionListener action_listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if (cmd.equals("������")){
					lblPic.setIcon(new ImageIcon("1.jpg"));
				} else if (cmd.equals("���ϸ�")) {
					lblPic.setIcon(new ImageIcon("2.jpg"));
				} else if (cmd.equals("������")) {
					lblPic.setIcon(new ImageIcon("3.jpg"));
				} else {
					lblPic.setIcon(new ImageIcon("4.jpg"));
				}
					
			}
		
		};
		rbmiOptionFMA.addActionListener(action_listener);
		rbmiOptionFMB.addActionListener(action_listener);
		rbmiOptionMA.addActionListener(action_listener);
		rbmiOptionMB.addActionListener(action_listener);
		
	}
	
	private void showFrame() {
		setTitle("â");
		setLocationRelativeTo(null);
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MenuEx1();
	}
}