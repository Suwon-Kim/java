
public class Consumer extends Thread {
	private MyBox box;
	public Consumer(MyBox c) {
		box = c;
	}
	public Consumer(ac.kr.two.MyBox c) {
		
	}
	public void run() {
		int value = 0;
		for(int i = 0; i < 10; i++) {
			box.get();
			try {
				sleep(100);
			} catch(InterruptedException e) { }
		}
	}
}
