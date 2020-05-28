package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

class JoinForm extends JDialog {
	private JLabel info;
	private JLabel joinId;
	private JLabel joinPassword;
	private JLabel retry;
	private JLabel name;
	private JLabel nickName;
	
	private JTextField tfId;
	private JTextField tfPassword;
	private JTextField tfRetry;
	private JTextField tfName;
	private JTextField tfNickName;
	
	private JRadioButton rbMale;
	private JRadioButton rbFemale;
	
	private JButton btnJoin;
	private JButton btnCancel;
	
	private final static int TF_SIZE = 10;
	private final static Dimension LBL_SIZE = new Dimension(60, 20);
	
	public JoinForm() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
		info = new JLabel("-Input your information",JLabel.CENTER);
		
		joinId = new JLabel("ID", JLabel.LEFT);
		joinId.setPreferredSize(LBL_SIZE);
		
		joinPassword = new JLabel("Password", JLabel.LEFT);
		joinPassword.setPreferredSize(LBL_SIZE);
		
		retry = new JLabel("Retry",JLabel.LEFT);
		retry.setPreferredSize(LBL_SIZE);
		
		name = new JLabel("Name",JLabel.LEFT);
		name.setPreferredSize(LBL_SIZE);
		
		nickName = new JLabel("NickName", JLabel.LEFT);
		nickName.setPreferredSize(LBL_SIZE);
		
		tfId = new JTextField(TF_SIZE);
		tfPassword = new JTextField(TF_SIZE);
		tfRetry = new JTextField(TF_SIZE);
		tfName = new JTextField(TF_SIZE);
		tfNickName = new JTextField(TF_SIZE);
		
		rbMale = new JRadioButton("Male");
		rbFemale = new JRadioButton("Female"); 
		
		btnJoin = new JButton("Join");
		btnCancel = new JButton("Cancel");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbMale);
		group.add(rbFemale);
		
	}
	private void setDisplay() {
		
		JPanel pnlMain = new JPanel(new BorderLayout());
		
		JPanel pnlNorth = new JPanel(new GridLayout(6,1));
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.setBorder(new TitledBorder("Gender"));
		JPanel pnlSouth = new JPanel();
		
		JPanel pnlId = new JPanel();		
		JPanel pnlPassword = new JPanel();
		JPanel pnlRetry = new JPanel();
		JPanel pnlName = new JPanel();
		JPanel pnlNickName = new JPanel();
		
		pnlMain.add(info);
		
		pnlId.add(joinId);
		pnlId.add(tfId);
		
		pnlPassword.add(joinPassword);
		pnlPassword.add(tfPassword);
		
		pnlRetry.add(retry);
		pnlRetry.add(tfRetry);
		
		pnlName.add(name);
		pnlName.add(tfName);
		
		pnlNickName.add(nickName);
		pnlNickName.add(tfNickName);
		
		pnlNorth.add(pnlId);
		pnlNorth.add(pnlPassword);
		pnlNorth.add(pnlRetry);
		pnlNorth.add(pnlName);
		pnlNorth.add(pnlNickName);
		
		pnlCenter.add(rbMale);
		pnlCenter.add(rbFemale);
		
		pnlSouth.add(btnJoin);
		pnlSouth.add(btnCancel);
		
	
		pnlMain.add(info);
		pnlMain.add(pnlNorth,BorderLayout.NORTH);
		pnlMain.add(pnlCenter, BorderLayout.CENTER);
		pnlMain.add(pnlSouth, BorderLayout.SOUTH);
		
		pnlMain.setBorder(new EmptyBorder(10,10,10,10));
		
		add(info,BorderLayout.NORTH);
		add(pnlMain, BorderLayout.CENTER);
		
	
	}
	private void addListeners() {
		
	}
	private void showFrame() {
		setTitle("Join");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		new JoinForm();
	}
}