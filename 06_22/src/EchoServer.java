import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
//TCP 방식 프로그램 실행은 항상 서버 부터 해야한다. (서버가 있어야 뭔가를 요청 할 수 있기 때문에)
//같이 이해야한다 클라이언트와 서버 머리가 아플 수 있다..
public class EchoServer {
	//ServerSocket Socket 나오면 TCP 방식의 통신이다.
	public static void main(String[] args) {
		try {
			System.out.println("서버");
			//PORT 번호 : 10001 // 포트 : 프로세서를 식별해주는 논리적 식별자
			//10000 이하의 포트번호는 사용안하는게 좋다 공부를 할때는 
			//ServerSocket 클라이언트의 접속을 대기하는 클래스 클라이언트는 10001으로 접속해야함
			//서버는 기다리는쪽이므로 포트만 결정해주면 된다.
			ServerSocket server = new ServerSocket(10001);
			System.out.println("접속을 기다립니다.");	//뭔가 하고 싶으면 Socket한테 하면 됨
			Socket sock = server.accept();	//접속 대기상태 (서버에 접근한 Client를 기다림)
			//클라이언트가 접속하면 not runnable이 풀림
			//여기의 Socket sock은 접속한 클라이언트라고 생각하면 되고 
			//accept() 사용자의 접근을 실제로 기다리는 기능이 accept()
			//누군가가 접근을 할 때 까지 실행 불가 상태로 빠져버린다. 누군가가 접속 할 때 까지
			//accpet()에서 멈춤
			//이제 에코 클라이언트를 가서 코드를 보자 
			InetAddress inetaddr = sock.getInetAddress();
			//나한테 접속한 Client의 IP를 얻을 수 있다 
			System.out.println(
					inetaddr.getHostAddress() + 
					"로 부터 접속하였습니다."
			);
			//Server에서 일어나는게 Client에서도 일어난다.
			//sock에서 쓴다 sock에서 읽는다.. 
			//클라이언트한테 쓰게하기 위한 스트림
			OutputStream out = sock.getOutputStream();	//소켓에 쓰는놈  (byte연산)
			InputStream in = sock.getInputStream();
			PrintWriter pw = new PrintWriter(	// char(연산) 전화기에 대고 말한다.
			//소켓의 캐릭터 단위로 줄단위로 쓰는놈 
			//PrintWriter 줄단위로 쓰는놈 
				new OutputStreamWriter(out)
			//OutputStreamWriter char -- > byte로  쓰는놈 (바꿔주는 역할)  
			//어디에 쓰는지를 결정하는게 out  나머지는 필터 
			);
			BufferedReader br = new BufferedReader(		
			//소켓으로부터 읽어오는 스트림 (말한것을 듣는다)
				new InputStreamReader(in)	//byte -- > char로 읽어주는놈
			);
			//not runnable 상태로 빠짐  읽을게 없으니깐 
			String line = null;
			while ( (line = br.readLine()) != null) {
				System.out.println(
						"클라이언트로 부터 전송받은 문자열 : " + 
						line
				);
				pw.println(line);
				pw.flush();
			}
			pw.close();
			br.close();
			sock.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}

/*
 	OSI7 Layers 내려갈 수록 헤더가 하나하나씩 추가된다.
 	각 단계끼리만 통신한다. (국제표준) 우리가 다 알 필요는 없고 
 	7,6,5만 우리가 관련한다. 
 	TCP : 전화기랑 비슷하다 (전화를 걸면 내가 받아야 전화가 된다) -- > 동기화가 이루어진 통신
 	내가 전화를 받으면 통신이 일어남 우리가 집중해야하는거 TCP만 보고 간다.
 	인터넷과 웹의 차이 --> 인터넷은 네트워크 망의 이름, 웹은 인터넷 기반으로 한 서비스
 	UDP : 편지쓰는거 읽었는지 안읽었는지 확인 할 수 없다 
 	빠르다.토렌트 같은거 , P2P 
 */

