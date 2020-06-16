
public class SomeThread extends Thread {
	public SomeThread(String name) {
		super(name);
	}
	@Override
	public void run() {
		String name = this.getName();
		for(int i = 0; i < 10; i++) {
			System.out.println(name + "is working");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}
		}
	}
}
