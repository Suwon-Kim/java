public class NomalThreadTest {
	public static void main(String[] args) {
		/* 
		 *	모든 스레드가 종료 -> 프로그램 종료  
		 */
		Thread t = new Thread() {
		// 스레드 생성
			public void run() {
				try {
					// 5초간 멈춤
					Thread.sleep(5000);
					System.out.println("MyThread 종료");
				} catch (Exception e) {
					
				}
			}
		};
		
		t.start();
		System.out.println("main() 종료");
	}
}