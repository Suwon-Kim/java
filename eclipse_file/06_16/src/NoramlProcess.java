import javax.swing.JOptionPane;

public class NoramlProcess {
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("�ƹ����̳� �Է��ϼ���.");
		
		System.out.println("�Է��Ͻ� ���� " + input + "�Դϴ�.");
		//����� API ���� 
		//������ ���涧���� �����ִ�. �Է��� ��� �� �� ���� ��ٸ��� �۾��� ����ŷ�̶� �ϰ� -> Blocked
		//Ư���� �ð����� ������ �� �� ���� ���� (sleep) -- > TIMED_WAITING
		//�Ͼ�� �Ҷ� ���� ������ ��� ������ ���ϴ� ���� ( ) -- > WAITING 
		//����ŷ  �Ǿ� �ִٰ� ����ڰ� �Է��ϸ� �� �ϳ��� ���� ����ȴ�.
		//�ϳ��� ��
		
		//Runnable -- > ��⿭ (�������� ����ϴ���� ) ���� �ӽ��� �����ϴµ� 
		// �����ϴ� ���� Run���� ����. �ڿ��� ������ �ٽ� runnable�� ����. 
		// ���� ������ ���� �ϰ� �Դµ� �� �ٽ� ������ ���� �� �� �ִ� ������ �� �� �� ���� 
		// �׷��� �����尡 ��ƴ� . 
		//Run ������ ����Ǵ� ��Ʈ 
		//Not Runnable ������ �� ���� ��Ʈ (�Է� ��ٸ�, sleep)�� 
		//Not Runnable���� �ع��� �Ǹ� (ex) -- > ����ڰ� �Է��� �ϰ� �Ǹ� 
		// Run���� ���°� �ƴϰ� Runnable�� ���� . 
		//�����尡 ���̳��� Dead�� ����. �ѹ� ������ �� �̻� �� �� ���� �ٽ� �����带 ������ ��
		//�� �׸��� �׸��� �־�� �Ѵ�. 
		//������� ������ �׸��� �����ϱ� ���ϴ�. 
		//Runnable���� ����ϰ� �ִٰ� ���￡�� �̱���� Run���� �Ѹ��� ���Ե�
		
// -------------------------------------------------------------------------//
		//�ϳ��� �� 
		
		for(int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) { }
		}
	}
}