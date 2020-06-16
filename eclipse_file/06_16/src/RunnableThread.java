//runnable 실제로 쓰레드가 아니고 쓰레드가 어떤일을 해야하는지를 나타내는놈
//쓰레드가 하는일을 나타내는 인터페이스임 쓰레드가 아님
public class RunnableThread implements Runnable {
	//run()를 오버라이딩 하여 재정의
	@Override
	public void run() {
		System.out.println("Runnable 인터페이스를 구현");
	}
}
