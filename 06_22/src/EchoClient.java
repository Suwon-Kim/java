import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
//TCP 방식
public class EchoClient {
	public static void main(String[] args) {
		try {
			//127.0.0.1 가상 IP (내가 내한테 접근할 때 쓰는 IP번호임)
			Socket sock = new Socket("127.0.0.1", 10001);
			//OSI7 계층을 추상화 시킨 게 SOCK (통신의 주체가 sock) 
			//Socket이 다 알아서 해준다 (IP, PORT)
			//Socket 통신의 전반적인것을 다 해줄꺼임 
			//Socket 객체가 만들어진게 서버와 클라이언트가 연결이 되었다고 보면 됨
			//Socket sock 서버라고 생각하면 된다 
			//뭔가 하고 싶으면 Socket한테 하면 됨
			BufferedReader keyboard = 
					new BufferedReader(new InputStreamReader(System.in)
			);	//키보드를 읽는 스트림
			OutputStream out = sock.getOutputStream();
			//sock <<-- 서버에 쓸 수 있는 
			InputStream in = sock.getInputStream();
			//서버에서 읽을 수 있는 
			PrintWriter pw = new PrintWriter(
					new OutputStreamWriter(out)	//char - > byte 단위로 변환
			);	//서버에 줄단위로 쓸수 있는놈 준비
			BufferedReader br = new BufferedReader(	//byte -> char로 변환 
					new InputStreamReader(in)
			);// 서버로부터 줄단위로 읽을 수 있는 스트림 준비 
			String line = null;
			while( (line = keyboard.readLine()) != null) {	
				////요까지 진행하면서 서버랑 클라이언트가 notRunnable에 가있음
				//입력이 들어올 때 까지 기다린다. (클라이언트는)
				//(서버는) 
				if(line.equals("quit")) break;
				pw.println(line);
				pw.flush();
				String echo = br.readLine();	
			// 멈춘다 서버로 읽어낸놈 (br) 서버가 뭔가 보낼때까지 멈춘다
				System.out.println(
					"서버로 부터 전달받은 문자열 : " + echo
				);
			}
			pw.close();
			br.close();
			sock.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
