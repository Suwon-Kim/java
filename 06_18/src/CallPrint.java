
public class CallPrint extends Thread {
	MyPrinter src;
	public CallPrint(MyPrinter src) {
		this.src = src;
	}
	public void run() {
		while(true) {
			src.printContents();
		}
	}
}
