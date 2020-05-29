package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JFrame {
	private JLabel id;
	private JLabel password;
	
	private JButton btnLogin;
	private JButton btnJoin;

	private JTextField tfId;
	
	private JPasswordField tfPassword;
	
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
		tfPassword = new JPasswordField(TF_SIZE);
		
		btnLogin = new JButton("Login");
	
		btnJoin = new JButton("Join");
	}
	private void setDisplay() {
		
		JPanel pnlNorth = new JPanel();
		JPanel pnlCenter = new JPanel();
		JPanel pnlSouth = new JPanel();
		
		JPanel pnlId = new JPanel();
		JPanel pnlPassword = new JPanel();
		
		pnlId.add(id);
		pnlPassword.add(password);
		
		
		pnlNorth.add(pnlId);
		pnlNorth.add(tfId);
		
		pnlCenter.add(pnlPassword);
		pnlCenter.add(tfPassword);
		
		pnlSouth.add(btnLogin);
		pnlSouth.add(btnJoin);
		
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
						if(tfId.getText().length() == 0 ) {
							JOptionPane.showConfirmDialog(
									LoginForm.this,
									"아이디를 입력하세요!!",
									"아이디 입력 오류",
									JOptionPane.CLOSED_OPTION
							);
						} 
						
						else if (tfPassword.getPassword().length == 0 ) {
							JOptionPane.showConfirmDialog(
									LoginForm.this,
									"비밀번호를 입력하세요!!",
									"비밀번호 입력 오류",
									JOptionPane.CLOSED_OPTION
							);
						} 
						File file  = new File("C:\\Users\\user\\Desktop\\memberInfo.txt");
						//정보 다 입력하고 로그인 눌렀을 때 
						FileReader fr = null;
						BufferedReader br = null;
						
						try {
							fr = new FileReader(file);
							br = new BufferedReader(fr);
							
							String line = null;
							StringBuilder builder = new StringBuilder();
							while( (line = br.readLine()) != null ) {
								System.out.println(line);
							}
						} catch (IOException e) {
							e.printStackTrace();
						} finally {
							MyUtils.closeAll(br, fr);
						}
				}
				if(btnJoin.equals(ae.getSource())) {
					new JoinForm();
					System.out.println("JoinForm으로 이동");
				}
			}
		};
		
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
