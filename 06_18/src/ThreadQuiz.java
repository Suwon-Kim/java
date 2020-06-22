
public class ThreadQuiz {
	public static void main(String[] args) {
		Thread t = new Thread() {
			@Override
			public void run() {
				while (true) {}
			}
		};
		
		t.start();
		t.interrupt();
		System.out.println(Thread.interrupted());
		//���� ���⼭ Thread�� main�̴�. main�� not runnable ���¸� 
		//�������� ���� ������ �翬
	}
}

/*
	Interrupt() --> not Runnable ���¸� Runnable ���·� �Ű��ִ³�
	���ܸ� �̿��Ѵ� (InterruptedException)
	Not Runnable ���°� �ƴ� �� ������ ��� �Ǵ°� ? -- > Not Runnable���°� �Ǹ� �ٷ� Ż��) 
	--> ������ ���ο� ���º��� -- > Not Runnable (Ż��) Ż���ϸ� false 
	--> ���º��� -- > isInterrepted() : true
	-- > ���´� Runnable�̳� Run���� 
	
	t.isInterruptted : �ش� �����带 �޾Ҵ��� �ȹ޾Ҵ��� üũ
	static interrupted 
	Thread.interrupted : ���� ������ �����ϴ� ������ interrupt�� �޾Ҵ��� 
	�ȹ޾Ҵ��� üũ + �������� ���ͷ�Ʈ ���¸� �ʱ�ȭ 
	
	//��Ʈ��ũ�� ���ؼ��� �迭, Collection, I/O, Thread �� �˾ƾ� 
	//��Ʈ��ũ�� �� �� �ִ�.....................
	//�迭, Collection, I/O, Thread �����ؿ���
*/
