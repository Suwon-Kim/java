public class NomalThreadTest {
	public static void main(String[] args) {
		/* 
		 *	��� �����尡 ���� -> ���α׷� ����  
		 */
		Thread t = new Thread() {
		// ������ ����
			public void run() {
				try {
					// 5�ʰ� ����
					Thread.sleep(5000);
					System.out.println("MyThread ����");
				} catch (Exception e) {
					
				}
			}
		};
		
		t.start();
		System.out.println("main() ����");
	}
}