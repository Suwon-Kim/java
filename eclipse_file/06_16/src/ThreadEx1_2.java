//�����带 ������ ��� 2���� implement(Runnalble)�� extends(Thread) 
public class ThreadEx1_2 implements Runnable {
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("t2 : " + Thread.currentThread().getName());
		}
	}
	//Thread.currentThread().getName() --> �����带 ��ӹ��� �ʾұ� ������ 
	//getName() �޼ҵ尡 ���� 
	// Thread Ŭ���� ���� ���� �����带 �޾ƿ��µ� ���� �̸��� ������ �� �ϴ³�
}
