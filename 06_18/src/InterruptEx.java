

class Dummy {
	public synchronized void todo() {
		try {
			System.out.println("start....");
			wait();	//not runnable 이므로 Inter 예외처리
		} catch (InterruptedException e) {
			System.out.println("Interrputed");
		}
	}
}
public class InterruptEx {
	public static void main(String[] args) {
		//final 변하지 않는값 
		final Dummy d = new Dummy();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				d.todo();
				System.out.println("I'm dead");
			}
		};
		t1.start();
		t1.interrupt();
	}
}

/*
 *	interrupt  
 *  실행대기열로 돌아온다.. 원래는 wait에 멈춰 있어야하는데 
 *  //예외가 발생하고 그걸 깨버리고 나온다.not Runnable 상태에서 
 *  Runnable 상태로 바뀐다.
 *  wait 말고도 not Runnable
 *  //상태에 있는 어떤거면 다 된다. 
 *  
 *  lock을 가진놈만 wait을 사용할 수 있다. 
 *  t1.interrupt() ---> 때문에 InterruptedException e이 존재함
 *  
 *  wait에서 멈춰있어야 하는데 예외를 발생시키면서
 *  실행할 수 있는 상태로 바꿔줌 (Runnable)상태로
 *  실행 상태로 가는게 아니고 실행가능 상태로 바꿔줌...
 *  
 *  실행할 수 없는 상태를 멈추라는말임..
 *  
 *  
 *  
*/