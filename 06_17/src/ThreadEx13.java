
public class ThreadEx13 {
	static long startTime = 0;
	public static void main(String[] args) {
		ThreadEx13_1 th1 = new ThreadEx13_1();
		ThreadEx13_2 th2 = new ThreadEx13_2();
		
		th1.start();
		th2.start();
		
		
//		startTime = System.currentTimeMillis();	//���� �ð� 
		
		try {
			System.out.print("main1");
			th1.join();	// 2���� ���ÿ� �߻��ϴ°� �ƴ� ���⼭ �ѹ� �ɸ�
			//main�� ������ ������ th1�� ������ ������.
		} catch (InterruptedException e) { }
		
		try {
			System.out.print("main2");
			th2.join();//<--���β�
			////main�� ������ ������ th2�� ������ ������.
		} catch (InterruptedException e) { }
		//Not Runnable�� ���³��� ������ (InterruptedException e �߻�)
//		System.out.println("�ҿ�ð�:" + 
//			(System.currentTimeMillis() - ThreadEx13.startTime)
//		);
		System.out.println("main3");
	}	// main
}
