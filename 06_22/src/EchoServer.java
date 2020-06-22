import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
//TCP ��� ���α׷� ������ �׻� ���� ���� �ؾ��Ѵ�. (������ �־�� ������ ��û �� �� �ֱ� ������)
//���� ���ؾ��Ѵ� Ŭ���̾�Ʈ�� ���� �Ӹ��� ���� �� �ִ�..
public class EchoServer {
	//ServerSocket Socket ������ TCP ����� ����̴�.
	public static void main(String[] args) {
		try {
			System.out.println("����");
			//PORT ��ȣ : 10001 // ��Ʈ : ���μ����� �ĺ����ִ� ���� �ĺ���
			//10000 ������ ��Ʈ��ȣ�� �����ϴ°� ���� ���θ� �Ҷ��� 
			//ServerSocket Ŭ���̾�Ʈ�� ������ ����ϴ� Ŭ���� Ŭ���̾�Ʈ�� 10001���� �����ؾ���
			//������ ��ٸ������̹Ƿ� ��Ʈ�� �������ָ� �ȴ�.
			ServerSocket server = new ServerSocket(10001);
			System.out.println("������ ��ٸ��ϴ�.");	//���� �ϰ� ������ Socket���� �ϸ� ��
			Socket sock = server.accept();	//���� ������ (������ ������ Client�� ��ٸ�)
			//Ŭ���̾�Ʈ�� �����ϸ� not runnable�� Ǯ��
			//������ Socket sock�� ������ Ŭ���̾�Ʈ��� �����ϸ� �ǰ� 
			//accept() ������� ������ ������ ��ٸ��� ����� accept()
			//�������� ������ �� �� ���� ���� �Ұ� ���·� ����������. �������� ���� �� �� ����
			//accpet()���� ����
			//���� ���� Ŭ���̾�Ʈ�� ���� �ڵ带 ���� 
			InetAddress inetaddr = sock.getInetAddress();
			//������ ������ Client�� IP�� ���� �� �ִ� 
			System.out.println(
					inetaddr.getHostAddress() + 
					"�� ���� �����Ͽ����ϴ�."
			);
			//Server���� �Ͼ�°� Client������ �Ͼ��.
			//sock���� ���� sock���� �д´�.. 
			//Ŭ���̾�Ʈ���� �����ϱ� ���� ��Ʈ��
			OutputStream out = sock.getOutputStream();	//���Ͽ� ���³�  (byte����)
			InputStream in = sock.getInputStream();
			PrintWriter pw = new PrintWriter(	// char(����) ��ȭ�⿡ ��� ���Ѵ�.
			//������ ĳ���� ������ �ٴ����� ���³� 
			//PrintWriter �ٴ����� ���³� 
				new OutputStreamWriter(out)
			//OutputStreamWriter char -- > byte��  ���³� (�ٲ��ִ� ����)  
			//��� �������� �����ϴ°� out  �������� ���� 
			);
			BufferedReader br = new BufferedReader(		
			//�������κ��� �о���� ��Ʈ�� (���Ѱ��� ��´�)
				new InputStreamReader(in)	//byte -- > char�� �о��ִ³�
			);
			//not runnable ���·� ����  ������ �����ϱ� 
			String line = null;
			while ( (line = br.readLine()) != null) {
				System.out.println(
						"Ŭ���̾�Ʈ�� ���� ���۹��� ���ڿ� : " + 
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
 	OSI7 Layers ������ ���� ����� �ϳ��ϳ��� �߰��ȴ�.
 	�� �ܰ賢���� ����Ѵ�. (����ǥ��) �츮�� �� �� �ʿ�� ���� 
 	7,6,5�� �츮�� �����Ѵ�. 
 	TCP : ��ȭ��� ����ϴ� (��ȭ�� �ɸ� ���� �޾ƾ� ��ȭ�� �ȴ�) -- > ����ȭ�� �̷���� ���
 	���� ��ȭ�� ������ ����� �Ͼ �츮�� �����ؾ��ϴ°� TCP�� ���� ����.
 	���ͳݰ� ���� ���� --> ���ͳ��� ��Ʈ��ũ ���� �̸�, ���� ���ͳ� ������� �� ����
 	UDP : �������°� �о����� ���о����� Ȯ�� �� �� ���� 
 	������.�䷻Ʈ ������ , P2P 
 */

