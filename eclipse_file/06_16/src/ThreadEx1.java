
public class ThreadEx1 extends Thread {
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.println("|");
		}
		System.out.println(
				"�ҿ�ð�2:" + 
				(System.currentTimeMillis() - UsingThreadProcess.startTime)
		);
	}
}
