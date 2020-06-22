
public class ThreadJoinTestB {
	public static void main(String[] args) {
		//스레드 생성
		Thread t = new Thread() {
			public void run() {
				try {
					//2초간 멈춤
					Thread.sleep(2000);
					// 스레드 종료 메세지
					System.out.println("MyThread 종료");
					//3초간 멈춤
					Thread.sleep(3000);
				} catch (Exception e) {//InterruptedException e }
					
				}
			}
		};
		// 스레드 시작
		t.start();
		try {
			
			// join() 메소드 실행..
			// t 스레드가 종료될때까지 main 스레드가 기다림.
			t.join();
			//main 쓰레드는 여기서 멈춘다. <-- not Runable 상태로 빠짐
			//t가 종료될 때 not Runnable가 풀린다.
			//t가 뭔가 하는게 아님.. t의 뭐가 변하는게 아니고 main쓰레드가 영향
			//을 받게된다. 
			//join 쓰레드는 한 쓰레드가 끝날때까지 기다리는놈
			//우리가 이전에 받던 코드랑 좀 다르다 이전에는 t가 어떻게 됬었는데 이거는
			//아님
		} catch (InterruptedException e) {
			//실행불가 상태를 만났을 때 InterruptedException 발생
			e.printStackTrace();
		} 
		System.out.println("main() 종료");
	}
}
