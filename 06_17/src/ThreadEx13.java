
public class ThreadEx13 {
	static long startTime = 0;
	public static void main(String[] args) {
		ThreadEx13_1 th1 = new ThreadEx13_1();
		ThreadEx13_2 th2 = new ThreadEx13_2();
		
		th1.start();
		th2.start();
		
		
//		startTime = System.currentTimeMillis();	//현재 시간 
		
		try {
			System.out.print("main1");
			th1.join();	// 2개가 동시에 발생하는게 아님 여기서 한번 걸림
			//main이 조인을 만나면 th1의 할일을 끝낸다.
		} catch (InterruptedException e) { }
		
		try {
			System.out.print("main2");
			th2.join();//<--메인꺼
			////main이 조인을 만나면 th2의 할일을 끝낸다.
		} catch (InterruptedException e) { }
		//Not Runnable로 가는놈이 있으면 (InterruptedException e 발생)
//		System.out.println("소요시간:" + 
//			(System.currentTimeMillis() - ThreadEx13.startTime)
//		);
		System.out.println("main3");
	}	// main
}
