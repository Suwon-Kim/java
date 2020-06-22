
public class Producer extends Thread {
	private MyBox box;
	public Producer(MyBox box) {
		this.box = box;
	}
	public void run() {
		for(int i = 0; i < 20; i++) {
			box.put(i);
			try {
				sleep(100);
			} catch(InterruptedException e) { }
		}
	}
}
