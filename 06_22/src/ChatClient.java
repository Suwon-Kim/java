import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ChatClient {
	private Socket sock;
	private BufferedReader br;
	private PrintWriter pw;
	public ChatClient() {
		String ip = JOptionPane.showInputDialog("접속할 IP를 입력하세요 ");
		String id = JOptionPane.showInputDialog("사용할 ID를 입력하세요 ");
		if(ip.length() == 0 || id.length() == 0) {
			System.out.println(
				"IP와 ID를 제대로 입력하지 않아 프로그램을 종료합니다.");
			System.exit(-1);
		}
		try {
			sock = new Socket(ip, 10001);
			pw = new PrintWriter(
				new OutputStreamWriter(sock.getOutputStream()));
			br = new BufferedReader(
				new InputStreamReader(sock.getInputStream()));
			BufferedReader keyboard = new BufferedReader(
				new InputStreamReader(System.in)
			);
			pw.println(id);
			pw.flush();
			new Thread() {
				public void run() {
					try {
						String line = null;
						while( (line = br.readLine()) != null) {
							if(line.equals("/quit")) {
								throw new Exception();
							}
							System.out.println(line);
						}
					} catch (Exception e) {
						
					} finally {
						exit();
					}
				}
			}.start();
			String line = null;
			while((line = keyboard.readLine()) != null) {
				pw.println(line);
				pw.flush();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			exit();
		}
				
	}
	private void exit() {
		try {
			if(pw != null) {
				pw.close();
			}
		} catch (Exception e) { }
		try {
			if(sock != null) 
				sock.close();
			} catch (Exception e) { }
			System.out.println("클라이언트의 접속을 종료합니다.");
			System.exit(0);
		}
		public static void main(String[] args) {
			new ChatClient();
		}
	}

