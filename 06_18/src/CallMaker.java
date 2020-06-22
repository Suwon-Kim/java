
public class CallMaker extends Thread {
	MyPrinter src;
	public CallMaker(MyPrinter src) {
		this.src = src;
	}
	public void run() {
		while(true) {
			src.marker();
			
		}
	}
}
