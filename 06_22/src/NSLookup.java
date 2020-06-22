import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class NSLookup {
	public static void main(String[] args) {
		String domain = JOptionPane.showInputDialog(
			"도메인을 입력하시오"
		); 
		
		InetAddress inetaddr[] = null;
		try {
			inetaddr = InetAddress.getAllByName(domain);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < inetaddr.length; i++) {
			System.out.println(inetaddr[i].getHostName());
			System.out.println(inetaddr[i].getHostAddress());
			System.out.println(inetaddr[i].toString());
			System.out.println("-------------------------");
		}
	}
}

//InetAddress는  IP 정보를 표현하는 객체
		//IP --> 특정한 네트워크망이 있다면 컴퓨터가 통신하고 싶은 또 다른 디바이스를 찾아 가야하는데
		//네트워크에 물려있는 장비들이 대게 많다. 연결하고 싶은 대상을 무엇으로 구분하는가 ? 
		//IP로 구분한다 동일한 네트워크망 상에 존재하는 디바이스들의 식별자 (IP)
		//프로세서와 프로세서가 통신을 함 (기계와 기계가 통신 하는게 아니다)
		//프로세서를 식별해주는 논리적 식별자를 PORT
		//IP주소를 쳐도 네이버에 접근이 가능한대 왜 도메인 주소를 쳐서 네이버에 접근할까???? 
		//도메인을 가지고 DNS(domain name server)로 간다
		//사용자가 IP를 알고 있으면 무슨 문제가 생길까??? 브라우저 IP가 바뀌면 알 방법이 없다..사용자들이
		//사용자가 IP를 가지고 접근하게 하지 말고 DNS에 등록을 해놓고 key:naver.com
		//value:111.111.111.111	//value가 바뀌면 value만 수정하면된다.
		//Server 응답(Response) -- > 응답하는쪽
		//Client 요청(Request ) -- > 요청하는쪽
		//Protocol -- > 중국집에 갔는데 치킨 달라하면 주나? 안준다... 중국집에서는 
		//시킬수 있는 메뉴가 정해져있다 니가 요청해주는걸 전부 해주지 않는다...
		//통신규약이란 서버와 클라이언트끼리 서로 약속되어있는 규정 우리가 요청할 때 맞게끔 요청 해야
		//서버에서도 응답을 해준다.사전에 약속이 되어 있어야한다 --> 