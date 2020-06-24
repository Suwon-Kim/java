import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class GUIChatClient extends JFrame implements ActionListener {
	public static final int NORMAL = 0;
	public static final int EXCEPTIONAL = -1;
	
	private JTextField input;
	private JTextArea display;
	private BufferedReader br;
	private PrintWriter pw;
	private Socket sock;
	
	public GUIChatClient() {
		super("채팅 클라이언트");
		init();
		connect();
		setDisplay();
		addListeners();
		showFrame();
	}
	private void init() {
		input = new JTextField();
		input.setBorder(new TitledBorder("Input"));
		display = new JTextArea();
		display.setEditable(false);
	}
	private void setDisplay() {
		JPanel pnlCenter = new JPanel(new BorderLayout());
		pnlCenter.add(new JScrollPane(display));
		pnlCenter.setBorder(new TitledBorder("Chat"));
		add(pnlCenter, BorderLayout.CENTER);
		add(input, BorderLayout.SOUTH);
	}
	private void addListeners() {
		input.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				pw.println("/quit");
				pw.flush();
			}
		});
	}
	private void showFrame() {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(500, 500);
		setResizable(false);
		setVisible(true);
		input.requestFocus();
	}
	private void connect() {
		String ip = null;
		do {
			ip = JOptionPane.showInputDialog(this, "아이피를 입력하시오 ");
		} while(ip == null || ip.contentEquals(""));
		String id = null;
		do {
			id = JOptionPane.showInputDialog(this, "닉네임을 입력하시오");
		} while (id == null || id.equals(""));
		
		try {
			sock = new Socket(ip, 10001);
			pw = new PrintWriter(
					new OutputStreamWriter(
						sock.getOutputStream())
					);
			br = new BufferedReader(
					new InputStreamReader(
							sock.getInputStream())
			);
			pw.println(id.trim());
			pw.flush();
			WinInputThread wit = new WinInputThread();
			wit.start();
		} catch (Exception e) {
			System.out.println("서버와 접속시 오류가 발생하였습니다.");
			System.out.println(e);
			System.exit(EXCEPTIONAL);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == input) {
			String msg = input.getText();
			pw.println(msg);
			pw.flush();
			input.selectAll();
			input.requestFocus();
		}
	}
	class WinInputThread extends Thread {
		public void run() {
			try {
				String line = null;
				while ( (line = br.readLine()) != null) {
					if(line.equals("/quit")) {
						throw new Exception();
					}
					display.append(line + "\n");
					display.setCaretPosition(
						display.getDocument().getLength()
					);
				}
			} catch (Exception e) {
				System.out.println("client thread : " + e);
				JOptionPane.showMessageDialog(
						GUIChatClient.this, "프로그램을 종료합니다."
				);
			} finally {
				try {
					if(br != null ) br.close();
				} catch (Exception e) { }
			} try {
				if(pw != null) pw.close();
			} catch (Exception e) { }
			try {
				if(sock != null) sock.close();
			} catch (Exception e) { }
			System.exit(NORMAL);
		}
	}
	public static void main(String[] args) {
		new GUIChatClient();
	}
}
