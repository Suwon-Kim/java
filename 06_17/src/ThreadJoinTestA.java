
public class ThreadJoinTestA {
	public static void main(String[] args) {
		//������ ����
		Thread t = new Thread() {
			public void run() {
				try {
					Thread.sleep(2000);
					System.out.println("MyThread ����");
					Thread.sleep(3000);
				} catch (Exception e) { }
			}
		};
			t.start();
			System.out.println("main() ����");
	}
}
