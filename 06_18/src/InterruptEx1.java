
class InterruptEx1 {
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					//
					System.out.println(
							"isInterrupted :" + isInterrupted()
					);
					System.out.println("sleep...");
					//1분간 잠든다... RUN->NOT RUNNABLE
					Thread.sleep(1000 * 60);
				} catch (InterruptedException e) {
					System.out.println("wake up");
					System.out.println(
							"isInterrupted :" + isInterrupted()
					);
				}
				
				for(int i = 0; i < 10; i++) {
					System.out.println(i);
				}
			}
		};
		t1.start();
		System.out.println(t1.currentThread().getName());
		//main이 t1.start()를 실행 할 수 도 있고 두개 다  실행 할 수 도 있다 .
		t1.interrupt();
		System.out.println(t1.currentThread().getName());
		//갇혀있는 쓰레드를 대기열로 돌리는 목적으로 쓰긴쓰는데 
		//미리 날려놓고 쓸려고 하는게 아님 .. interrupt()메소드를 설명하기 위해 한거!
	}
}
//isInterrupted() 인터럽트를 받았는지 안받았는지 확인하는 메소드 
//실행중인 상태에 interrupt를 날렸을 때 쓰레드 내부에 main이 interrupt()을 
//실행했는지를 알 수 있다. 한번 받고 나면 인터럽트 받았다는것을 기억을 지워버린다 
//그래서 밑에서는 false가 나온다.
//미리 날리면 바로 나온다
