
public class InterruptEx2 {
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				long count = 0;
				//while(true)
				while(!isInterrupted()) {
					//interrupt를 받을때까지 계속 루프 돈다. 
					//interrupted를 받았는지 안받았는지 true false로 나타내주는 메소드
					count++;
				}
				System.out.println(
						"interrupted -> count = " + count
				);
				System.out.println(
						"isInterrupted : " + this.isInterrupted()
						//this가 인터럽트를 받았습니까? 
				);
				/*
				 * 	interrupted
				 *  현재 쓰레드가 인터럽트를 받았었다면, 
				 *  true를 리턴. 현재 쓰레드의 인터럽트 정보를 초기화 (안받은상태로)
				 * 
				 */
				System.out.println(
						"interrupted : " + Thread.interrupted()
						 //*  현재 쓰레드가 인터럽트를 받았었다면, 
						 //*  true를 리턴. 현재 쓰레드의 인터럽트 정보를 초기화 (안받은상태로)
				); 
				System.out.println(
						"isInterrupted : " + this.isInterrupted()
				);
			}
		};
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (Exception e) { }
		t1.interrupt();
	}
}
//not runnable이 아닐때 interrupt를 만나면 
//t1.isInterrupt(); t1이 인터럽트를 받았습니까?
//Thread.interrupted(); 이 구문을 실행하는 쓰레드가 인터럽트를 받았습니까 ?


