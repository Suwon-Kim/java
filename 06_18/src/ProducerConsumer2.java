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
				wait(); //실행중인 쓰레드를 실행불가상태로 만든다.
						//쉽게 말해 run -> not runnable(lock을 풀고간다)
			
			} catch (InterruptedException e) {
			}
		}
		isEmpty = !isEmpty;
		notifyAll();
		System.out.println(Thread.currentThread().getName() + ": 소비" + contents);
		return contents;
	}

	public synchronized void put(int value) {
		while (!isEmpty) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
			contents = value;
		
		System.out.println(Thread.currentThread().getName() + ": 생산" + contents);
		isEmpty = ! isEmpty;
		notifyAll();
	}
}

//thread 18번이 없음 .. 다시 만들어야 함
//wait() : run --> not runnable (lock을 풀고 not Runnable로 감)
//notifyAll() -- > 한명만 랜덤으로 꺠우는게 아니고 모든 쓰레드를 다 깨움
//(wait)된 not Runnable이 되어 있는놈들을 다 깨움
//x.notifyAll() -- > wait 됬을때 x의 wait된 놈만 깨운다 . . . !! 중요 
//notifyAll() : not runnable -> runnable 
//현재 lock을 가지고 있다가 wait된 모든 스레드를 깨움
//notify() -- > 실행불가 상태를 그 중에 한명만 랜덤으로 깨우는 것 

//lock취득시 호출가능 (synchronized일때만 호출가능) wait()와 notifyAll()를 
/*
* synchronized(obj1) {
*		obj1.wait();
* }
* 
* synchronized(obj 2) {
*		obj2.notifyAll();
*		this.가 동일한놈만 깨운다. !!! obj1 와 obj2가 다르기 때문에 깨어나지않음
* }
*
* obj1의 wait 된놈은 꺠어 나지 않는다 중요 !!
* 
*/