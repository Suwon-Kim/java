
public class DaemonThreadTest {
	public static void main(String[] args) {
		Thread t = new Thread() {
		//������ ����
			public void run() {
				try {
					//5�ʰ� ����
					Thread.sleep(5000);
					//������ ���� �޼���
					System.out.println("MyThread ����");
					
				} catch (Exception e) {
					//����
				}
			}
		};
		//���� ������ : �ٸ� �����尡 ������ �굵 ���� ������.�ڽ��� ������ ������ �Ϲ� �����尡
		//����Ǿ� ������ ���� ������� ���� ����ȴ�. 
		//�����尡 5���� 5���� �� ����Ǿ�� ���󾲷��尡 ����ȴ�.
		//������ �÷��͵� ���� ��������
		//���� ������� ����
		//��ŸƮ �ϱ� ���� �ҷ����Ѵ�. ��׶�� �۾��� �Ҳ��� ���� ������� ��������� �Ѵ�.
		t.setDaemon(true);
		// ������ ����
		t.start();
		
		//main�޼ҵ� ���� �޼���
		System.out.println("main() ����");
	}
}
