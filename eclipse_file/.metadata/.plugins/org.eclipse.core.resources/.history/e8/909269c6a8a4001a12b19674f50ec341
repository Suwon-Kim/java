import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.text.JTextComponent;

public class LoginForm extends JFrame implements ActionListener {
	private JTextComponent tfId;
	private JTextComponent pfPw;
	
	private JButton btnLogin;
	private JButton btnJoin;
	
	private Vector<User>list;
	private boolean isUpdated;
	
	public LoginForm() {
		loadData();
		init();
		setDisplay();
		addListener();
		showFrame();
	}
	
	private void init() {
		tfId = LoginUtils.getTextComponent(LoginUtils.TEXT);
		pfPw = LoginUtils.getTextComponent(LoginUtils.PASSWORD);
		
		btnJoin = LoginUtils.getButton("Join");
		btnLogin = LoginUtils.getButton("Login");
		
	}
	//File file = new File("data");
	
	private void loadData() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(
				//public static final String DIR = "data";
				//public static final String FILE = "users.dat";
				new File(LoginUtils.DIR, LoginUtils.FILE)
			);
			br = new BufferedReader(fr);
			list = new Vector<User>();
			String line = null;
			while( (line = br.readLine()) != null) {
				String userId = line;
				String userPassword = br.readLine();
				String userName = br.readLine();
				String userNick = br.readLine();
				String userGender = br.readLine();
				list.add(new User(userId,userPassword,userName,
						userNick,userGender));
			}
		}
	}
	private void setDisplay() {
		
	}
	private void addListener() {
		
	}
	private void showFrame() {
		
	}
}
