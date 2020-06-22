public class ProducerConsumer2 {
	public static void main(String[] args) {
		MyBox2 c = new MyBox2();
		Producer2 p1 = new Producer2(c);
		Consumer2 c1 = new Consumer2(c);
		Consumer2 c2 = new Consumer2(c);

		p1.start();
		c1.start();
		c2.start();
	}
}

class Producer2 extends Thread {
	private MyBox2 box2;

	public Producer2(MyBox2 box2) {
		this.box2 = box2;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			box2.put(i);
			try {
				sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}

class Consumer2 extends Thread {
	private MyBox2 box2;

	public Consumer2(MyBox2 c){
		box2=c;
	}


	public void run() {
		int value = 0;
		for (int i = 0; i < 10; i++) {
			box2.get();
			try {
				sleep(100);
			} catch (InterruptedException e) {
				
			}
		}
	}
}

class MyBox2 {
	private int contents;
	private boolean isEmpty = true;

	public synchronized int get() {
		while (isEmpty) {
			try {
				wait(); //�������� �����带 ����Ұ����·� �����.
						//���� ���� run -> not runnable(lock�� Ǯ����)
			
			} catch (InterruptedException e) {
			}
		}
		isEmpty = !isEmpty;
		notifyAll();
		System.out.println(Thread.currentThread().getName() + ": �Һ�" + contents);
		return contents;
	}

	public synchronized void put(int value) {
		while (!isEmpty) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
			contents = value;
		
		System.out.println(Thread.currentThread().getName() + ": ����" + contents);
		isEmpty = ! isEmpty;
		notifyAll();
	}
}

//thread 18���� ���� .. �ٽ� ������ ��
//wait() : run --> not runnable (lock�� Ǯ�� not Runnable�� ��)
//notifyAll() -- > �Ѹ� �������� �ƿ�°� �ƴϰ� ��� �����带 �� ����
//(wait)�� not Runnable�� �Ǿ� �ִ³���� �� ����
//x.notifyAll() -- > wait ������ x�� wait�� �� ����� . . . !! �߿� 
//notifyAll() : not runnable -> runnable 
//���� lock�� ������ �ִٰ� wait�� ��� �����带 ����
//notify() -- > ����Ұ� ���¸� �� �߿� �Ѹ� �������� ����� �� 

//lock���� ȣ�Ⱑ�� (synchronized�϶��� ȣ�Ⱑ��) wait()�� notifyAll()�� 
/*
* synchronized(obj1) {
*		obj1.wait();
* }
* 
* synchronized(obj 2) {
*		obj2.notifyAll();
*		this.�� �����ѳ� �����. !!! obj1 �� obj2�� �ٸ��� ������ ���������
* }
*
* obj1�� wait �ȳ��� �ƾ� ���� �ʴ´� �߿� !!
* 
*/