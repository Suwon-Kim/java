
public class RunnableThreadTest {
	public static void main(String[] args) {
		//Thread �����ڿ� RunnableThread �ν��Ͻ��� �Ķ���ͷ� ����
		Thread t = new Thread(new RunnableThread()); //���� ������� �ƴϴ�
		t.start();
		System.out.println("end of main");
		//main�ϰ� t���� ������ �� ��
		
	}
}
