
public class RunningTest {
	public static void main(String[] args) {
		/*
		     �ڽ��� ������ �������� �켱���� ���� �״�� �����޴´�.
		 */
		SomeThread t1 = new SomeThread("A");
		SomeThread t2 = new SomeThread("B");
		SomeThread t3 = new SomeThread("C");
		
		// �켱������ ���� �����尡 ���õ� ���ɼ��� ����.
		t1.setPriority(Thread.MIN_PRIORITY);	//1
		t2.setPriority(Thread.NORM_PRIORITY);	//5
		t3.setPriority(Thread.MAX_PRIORITY);	//10
		// �켱������ �����ְ� �����뿡�� ���� Ȯ���� �� �� �þ��
		// �ݺ��� ���� ���� �� (������ ���￡�� ����ϴٴ°Ŵ� �ƴ�)
		//�� �Ⱦ��� �̷��� ���� ����� ������ ������
	
		t1.start();
		t2.start();
		t3.start();
	}
}
