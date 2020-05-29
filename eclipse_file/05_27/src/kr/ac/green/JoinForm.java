package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

class JoinForm extends JDialog {
	private JLabel info;
	private JLabel joinId;
	private JLabel joinPassword;
	private JLabel retry;
	private JLabel name;
	private JLabel nickName;
	
	private JTextField tfId;
	private JPasswordField tfPassword;
	private JPasswordField tfRetry;
	private JTextField tfName;
	private JTextField tfNickName;
	
	private JRadioButton rbMale;
	private JRadioButton rbFemale;
	
	private JButton btnJoin;
	private JButton btnCancel;
	
	public String getId() {
		return tfId.getText();
	}
	
	public String getPassword() {
		return String.valueOf(tfPassword.getPassword());
	}
	
	public String getRetry() {
		return String.valueOf(tfRetry.getPassword());
	}

	public String getName() {
		return tfName.getText();
	}

	public String getNickName() {
		return tfNickName.getText();
	}
	public String getMale() {
		return rbMale.getActionCommand();
		
	}
	public String getFemale() {
		return rbFemale.getActionCommand();
	}

	private final static int TF_SIZE = 10;
	private final static Dimension LBL_SIZE = new Dimension(60, 20);
	
	public JoinForm() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}

	private void init() {
		Members m = new Members();

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
		tfPassword = new JPasswordField(TF_SIZE);
		tfRetry = new JPasswordField(TF_SIZE);
		tfName = new JTextField(TF_SIZE);
		tfNickName = new JTextField(TF_SIZE);
		
		rbMale = new JRadioButton("Male",true);
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
		ActionListener listener = (ae) -> {
			if(btnJoin.equals(ae.getSource())) {
//				
				if(getId().length() == 0) {
					JOptionPane.showConfirmDialog(
							JoinForm.this,
							"아이디를 입력하세요!!",
							"아이디 입력 오류",
							JOptionPane.CLOSED_OPTION
					);
				} else if(getPassword().length() == 0) {
					JOptionPane.showConfirmDialog(
							JoinForm.this,
							"비밀번호를 입력하세요!!",
							"비밀번호 입력 오류",
							JOptionPane.CLOSED_OPTION
					);
				} else if(getRetry().length() == 0) {
					JOptionPane.showConfirmDialog(
							JoinForm.this,
							"비밀번호재입력을 입력하세요!!",
							"비밀번호 재입력 오류",
							JOptionPane.CLOSED_OPTION
					);
				} else if(getName().length() == 0) {
					JOptionPane.showConfirmDialog(
							JoinForm.this,
							"이름을 입력하세요!!",
							"이름 입력 오류",
							JOptionPane.CLOSED_OPTION
					);
				} else if(getNickName().length() == 0) {
					JOptionPane.showConfirmDialog(
							JoinForm.this,
							"닉네임을 입력하세요!!",
							"닉네임 입력 오류",
							JOptionPane.CLOSED_OPTION
					);
				} else { 
					String[] info = {
							getId() + "\n", 
							getPassword() + "\n",
							getName() + "\n",
							getNickName() + "\n"
					};

						FileWriter fw = null;
						try {
							fw = new FileWriter("C:\\Users\\user\\Desktop\\memberInfo.txt",true);
							for(int i = 0; i < info.length; i++) {
								fw.write(info[i]);
							}							
						} catch (IOException e){
							e.printStackTrace();
						} finally {
							MyUtils.closeAll(fw);
						}
						System.out.println();
						new LoginForm();
						dispose();
					};
					
				}
				
			if(btnCancel.equals(ae.getSource())) {
				dispose();
			}
		};
		btnJoin.addActionListener(listener);
		btnCancel.addActionListener(listener);
		
	}
	private void showFrame() {
		setTitle("Join");
		setLocationRelativeTo(null);
		setDefaultCloseOperation( DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		new JoinForm();
	}
}
