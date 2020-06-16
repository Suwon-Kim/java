//얘는 쓰레드 쓴거임
public class UsingThreadProcess {
	static long startTime = 0;
	
	public static void main(String[] args) {
		ThreadEx1 th1 = new ThreadEx1();
		
		startTime = System.currentTimeMillis();
		th1.start();
		for(int i = 0; i < 300; i++) {
			System.out.println("-");
		}
		
		System.out.println(
				"소요시간1: " + 
				(System.currentTimeMillis() - UsingThreadProcess.startTime)
		);
	}
}
