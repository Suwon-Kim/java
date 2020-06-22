
public class ThreadQuiz {
	public static void main(String[] args) {
		Thread t = new Thread() {
			@Override
			public void run() {
				while (true) {}
			}
		};
		
		t.start();
		t.interrupt();
		System.out.println(Thread.interrupted());
		//지금 여기서 Thread는 main이다. main은 not runnable 상태를 
		//만난적이 없기 떄문에 당연
	}
}

/*
	Interrupt() --> not Runnable 상태를 Runnable 상태로 옮겨주는놈
	예외를 이용한다 (InterruptedException)
	Not Runnable 상태가 아닐 때 날리면 어떻게 되는가 ? -- > Not Runnable상태가 되면 바로 탈출) 
	--> 쓰레드 내부에 상태변경 -- > Not Runnable (탈출) 탈출하면 false 
	--> 상태변경 -- > isInterrepted() : true
	-- > 상태는 Runnable이나 Run상태 
	
	t.isInterruptted : 해당 쓰레드를 받았는지 안받았는지 체크
	static interrupted 
	Thread.interrupted : 현재 구문을 실행하는 구문이 interrupt를 받았는지 
	안받았는지 체크 + 쓰레드의 인터럽트 상태를 초기화 
	
	//네트워크를 위해서는 배열, Collection, I/O, Thread 를 알아야 
	//네트워크를 할 수 있다.....................
	//배열, Collection, I/O, Thread 정리해오기
*/
