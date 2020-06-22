package ac.kr.two;

public class MyBox {
	private int contents;
	private boolean isEmpty = true;
	public synchronized int get() {
		while(isEmpty) {
			try {
				wait();
			} catch(InterruptedException e) { }
		}
		isEmpty = !isEmpty;
		notifyAll();
		System.out.println(
				Thread.currentThread().getName() + ": �Һ� " + contents
		);
		return contents;
	}
	public synchronized void put(int value) {
		while(!isEmpty) {
			try {
				wait();
			} catch( InterruptedException e) { }
		}
		contents = value;
		System.out.println(
				Thread.currentThread().getName() + ": ����" + value
		);
		isEmpty = !isEmpty;
		notifyAll();
	}
}
