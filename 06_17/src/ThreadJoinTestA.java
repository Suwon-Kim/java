
public class ThreadJoinTestA {
	public static void main(String[] args) {
		//스레드 생성
		Thread t = new Thread() {
			public void run() {
				try {
					Thread.sleep(2000);
					System.out.println("MyThread 종료");
					Thread.sleep(3000);
				} catch (Exception e) { }
			}
		};
			t.start();
			System.out.println("main() 종료");
	}
}
