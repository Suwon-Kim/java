//쓰레드를 만들어내는 방법 2가지 implement(Runnalble)와 extends(Thread) 
public class ThreadEx1_2 implements Runnable {
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("t2 : " + Thread.currentThread().getName());
		}
	}
	//Thread.currentThread().getName() --> 쓰레드를 상속받지 않았기 때문에 
	//getName() 메소드가 없음 
	// Thread 클래스 안의 현재 쓰레드를 받아오는데 걔의 이름을 나오게 끔 하는놈
}
