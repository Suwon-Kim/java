package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginForm extends JFrame {
	private JLabel id;
	private JLabel password;
	private JButton btnLogin;
	private JButton btnJoin;
	private JTextField tfId;
	private JTextField tfPassword;
	
	private JPanel pnlId;
	private JPanel pnlPassword;
	
	public static final Dimension LBL_SIZE = new Dimension(60,20);
	private static final int TF_SIZE = 10;
	
	
	public LoginForm() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
		id = new JLabel("ID", JLabel.LEFT);
		id.setPreferredSize(LBL_SIZE);
		
		password = new JLabel("Password",JLabel.LEFT);
		password.setPreferredSize(LBL_SIZE);
		
		tfId = new JTextField(TF_SIZE);
		tfPassword = new JTextField(TF_SIZE);
		
		btnLogin = new JButton("Login");
	
		btnJoin = new JButton("Join");
	}
	private void setDisplay() {
		JPanel pnlMain = new JPanel();
		
		JPanel pnlNorth = new JPanel();
		JPanel pnlCenter = new JPanel();
		JPanel pnlSouth = new JPanel();
		
		pnlId = new JPanel();
		JPanel pnlPassword = new JPanel();
		
		pnlId.add(id);
		pnlPassword.add(password);
		
		pnlNorth.add(pnlId);
		pnlNorth.add(tfId);
		
		pnlCenter.add(pnlPassword);
		pnlCenter.add(tfPassword);
		
		pnlSouth.add(btnLogin);
		pnlSouth.add(btnJoin);
		
		pnlMain.add(pnlNorth);
		pnlMain.add(pnlCenter);
		pnlMain.add(pnlSouth);
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter,BorderLayout.CENTER);
		add(pnlSouth,BorderLayout.SOUTH);
		
	}
	private void addListeners() {
		ActionListener listeners = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Object o = ae.getSource();
				if(btnLogin.equals(ae.getSource())){
						if(tfId.getText().length() == 0) {
							JLabel lblId_Error = new JLabel("아이디를 입력해주세요");
							lblId_Error.setForeground(Color.RED);
							
							
							
						} else if (tfPassword.getText().length() == 0) {
							JOptionPane.showConfirmDialog(
									 LoginForm.this,
									"비밀번호를 입력하세요",
									"비밀번호 입력 오류",
									JOptionPane.OK_OPTION,
									JOptionPane.ERROR_MESSAGE
							); 
						} else {
							new InformationForm();
							System.out.println("InformationForm으로 이동");
						}
				}
				if(btnJoin.equals(ae.getSource())) {
					new JoinForm();
					System.out.println("JoinForm으로 이동");
				}
			}
		};
		btnLogin.addActionListener(listeners);
		btnJoin.addActionListener(listeners);
	}
	private void showFrame() {
		setTitle("Login");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		new LoginForm();
	}
}
