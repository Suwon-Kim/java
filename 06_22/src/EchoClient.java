import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
//TCP ���
public class EchoClient {
	public static void main(String[] args) {
		try {
			//127.0.0.1 ���� IP (���� ������ ������ �� ���� IP��ȣ��)
			Socket sock = new Socket("127.0.0.1", 10001);
			//OSI7 ������ �߻�ȭ ��Ų �� SOCK (����� ��ü�� sock) 
			//Socket�� �� �˾Ƽ� ���ش� (IP, PORT)
			//Socket ����� �������ΰ��� �� ���ٲ��� 
			//Socket ��ü�� ��������� ������ Ŭ���̾�Ʈ�� ������ �Ǿ��ٰ� ���� ��
			//Socket sock ������� �����ϸ� �ȴ� 
			//���� �ϰ� ������ Socket���� �ϸ� ��
			BufferedReader keyboard = 
					new BufferedReader(new InputStreamReader(System.in)
			);	//Ű���带 �д� ��Ʈ��
			OutputStream out = sock.getOutputStream();
			//sock <<-- ������ �� �� �ִ� 
			InputStream in = sock.getInputStream();
			//�������� ���� �� �ִ� 
			PrintWriter pw = new PrintWriter(
					new OutputStreamWriter(out)	//char - > byte ������ ��ȯ
			);	//������ �ٴ����� ���� �ִ³� �غ�
			BufferedReader br = new BufferedReader(	//byte -> char�� ��ȯ 
					new InputStreamReader(in)
			);// �����κ��� �ٴ����� ���� �� �ִ� ��Ʈ�� �غ� 
			String line = null;
			while( (line = keyboard.readLine()) != null) {	
				////����� �����ϸ鼭 ������ Ŭ���̾�Ʈ�� notRunnable�� ������
				//�Է��� ���� �� ���� ��ٸ���. (Ŭ���̾�Ʈ��)
				//(������) 
				if(line.equals("quit")) break;
				pw.println(line);
				pw.flush();
				String echo = br.readLine();	
			// ����� ������ �о�� (br) ������ ���� ���������� �����
				System.out.println(
					"������ ���� ���޹��� ���ڿ� : " + echo
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
