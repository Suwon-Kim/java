//�����尡 3�� ������ 
public class CreateThread {
	public static void main(String[] args) {
		ThreadEx1_1 t1 = new ThreadEx1_1();
		
		Runnable r = new ThreadEx1_2();
		Thread t2 = new Thread(r);
		
		t1.start();
		//t1�ȿ� ���� start()�� �����ض� t1�� ��ü�� �ƴϰ� �����尡 ���� ��Ű�°���
		//���� ��Ų���� �������� t1�� ���� ��Ų���� �ƴϰ� 
		//t1�� ���ض�� ���� ���״µ� �� ��Ų���� ��ü�� �������.
		t2.start();
		
		System.out.println(Thread.currentThread().getName());
		//���� �����带 �����ϴ³��� �̸��� �����
		//���� �۾����� �����带 �̾ƿ��³� --- > Thread.currentThread()
	}
}