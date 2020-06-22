import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class NSLookup {
	public static void main(String[] args) {
		String domain = JOptionPane.showInputDialog(
			"�������� �Է��Ͻÿ�"
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

//InetAddress��  IP ������ ǥ���ϴ� ��ü
		//IP --> Ư���� ��Ʈ��ũ���� �ִٸ� ��ǻ�Ͱ� ����ϰ� ���� �� �ٸ� ����̽��� ã�� �����ϴµ�
		//��Ʈ��ũ�� �����ִ� ������ ��� ����. �����ϰ� ���� ����� �������� �����ϴ°� ? 
		//IP�� �����Ѵ� ������ ��Ʈ��ũ�� �� �����ϴ� ����̽����� �ĺ��� (IP)
		//���μ����� ���μ����� ����� �� (���� ��谡 ��� �ϴ°� �ƴϴ�)
		//���μ����� �ĺ����ִ� ���� �ĺ��ڸ� PORT
		//IP�ּҸ� �ĵ� ���̹��� ������ �����Ѵ� �� ������ �ּҸ� �ļ� ���̹��� �����ұ�???? 
		//�������� ������ DNS(domain name server)�� ����
		//����ڰ� IP�� �˰� ������ ���� ������ �����??? ������ IP�� �ٲ�� �� ����� ����..����ڵ���
		//����ڰ� IP�� ������ �����ϰ� ���� ���� DNS�� ����� �س��� key:naver.com
		//value:111.111.111.111	//value�� �ٲ�� value�� �����ϸ�ȴ�.
		//Server ����(Response) -- > �����ϴ���
		//Client ��û(Request ) -- > ��û�ϴ���
		//Protocol -- > �߱����� ���µ� ġŲ �޶��ϸ� �ֳ�? ���ش�... �߱��������� 
		//��ų�� �ִ� �޴��� �������ִ� �ϰ� ��û���ִ°� ���� ������ �ʴ´�...
		//��űԾ��̶� ������ Ŭ���̾�Ʈ���� ���� ��ӵǾ��ִ� ���� �츮�� ��û�� �� �°Բ� ��û �ؾ�
		//���������� ������ ���ش�.������ ����� �Ǿ� �־���Ѵ� --> 