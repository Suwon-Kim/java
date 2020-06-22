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
		String ip = JOptionPane.showInputDialog("������ IP�� �Է��ϼ��� ");
		String id = JOptionPane.showInputDialog("����� ID�� �Է��ϼ��� ");
		if(ip.length() == 0 || id.length() == 0) {
			System.out.println(
				"IP�� ID�� ����� �Է����� �ʾ� ���α׷��� �����մϴ�.");
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
			System.out.println("Ŭ���̾�Ʈ�� ������ �����մϴ�.");
			System.exit(0);
		}
		public static void main(String[] args) {
			new ChatClient();
		}
	}

