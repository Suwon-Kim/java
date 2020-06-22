import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

class EchoThread extends Thread {
	private Socket sock;
	public EchoThread(Socket sock) {
		this.sock = sock;
	}
	public void run() {
		try {
			InetAddress inetaddr = sock.getInetAddress();
			System.out.println(
					inetaddr.getHostAddress() + 
					"로 부터 접속하였습니다."
			);
			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();
			PrintWriter pw = new PrintWriter(
				new OutputStreamWriter(out)	
			);
			BufferedReader br = new BufferedReader(
				new InputStreamReader(in)	
			);
			String line = null;
			while( (line = br.readLine()) != null ) {
				System.out.println(
						"클라이언트로부터 전송받은 문자열 : " + 
						line
				);
				pw.println(line);
				pw.flush();
			}
			pw.close();
			br.close();
			sock.close();
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}