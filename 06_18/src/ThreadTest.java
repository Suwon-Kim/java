
public class ThreadTest {
	public static void main(String[] args) {
		MyPrinter src = new MyPrinter();
		CallPrint print = new CallPrint(src);
		CallMaker marker = new CallMaker(src);
		
		print.start();
		marker.start();
	}
}
