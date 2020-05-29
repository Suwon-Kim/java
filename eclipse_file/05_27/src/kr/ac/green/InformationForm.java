package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class InformationForm extends JDialog {
	private JTextArea taInfo;
	private JButton btnLogout;
	private JButton btnWithdraw;
	
	private String checkId;
	private String checkPassword;
	private String checkRetry;
	private String checkName;
	private String checkNickName;
	
	//LoginForm owner = loginForm
	public InformationForm() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
		taInfo = new JTextArea(20,50);
		btnLogout = new JButton("Logout");
		btnWithdraw = new JButton("Withdraw");
		
	}
	private void setDisplay() {
		JPanel pnlCenter = new JPanel();
		pnlCenter.setBorder(new TitledBorder("Check your Information"));
		
		JPanel pnlSouth = new JPanel();
		
		pnlCenter.add(taInfo);
		
		pnlSouth.add(btnLogout);
		pnlSouth.add(btnWithdraw);
		
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);

	}
	
	private void addListeners() {
		ActionListener listeners = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Object o = ae.getSource();
				if(btnLogout.equals(ae.getSource())){
					dispose();
					System.out.println("InformationForm으로 이동");
				}
				if(btnWithdraw.equals(ae.getSource())) {
					dispose();
					System.out.println("JoinForm으로 이동");		
				}
					
			}
		};
		btnLogout.addActionListener(listeners);
		btnWithdraw.addActionListener(listeners);
	}
	private void showFrame() {
		setTitle("Information");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public void taInfo(String string) {
		
		
	}
}
