import java.net.ServerSocket;
import java.net.Socket;

public class EchoThreadServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10001);
			System.out.println("������ ��ٸ��ϴ�.");
			while(true) {
				Socket sock = server.accept();
				EchoThread echothread = new EchoThread(sock);
				echothread.start();	
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
