//얘는 쓰레드 안쓰거임
public class NormalProcess {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < 300; i++) {
			System.out.println("-");
		}
		System.out.print(
				"소요시간1:" + (System.currentTimeMillis() - startTime)
		);
		for(int i = 0; i < 300; i++) {
			System.out.println("|");
		}
		System.out.print(
				"소요시간2:" + (System.currentTimeMillis() - startTime)
		);
	}
	//쓰레드 안쓴거 쓰레드 쓴거 비교해보면 계속 무한대로 수행해보면 
	//쓰레드 쓴쪽이 더 많은 시간을 잡아먹게됨 이게 왜 그래 되는지 알아보자 (칠판)
	
	//(a b) < -- nomal  (a)(b) < -- thread
	//thread를 쓴 게 더 비싼 작업이다. 
	//1. 왜 thread가 더 오래 걸리는가 ? 
	//2. 결론 
	
	/*
	 * 사진 참고 
	 * 1. nomal -- > a만 계속 실행하고 a가 끝나면 b가 수행하면 되는 형태인데
	 * 콜스택이 한개 있다. 
	 * 
	 *    thread -- > 1,2,3 하고 나서 작업에 대한 저장이 필요하고 (4,5)를 가기 위해서
	 *    읽기 작업이 필요하다 문맥교환을 할 때 저장이 필요하고 읽기가 필요하다 .
	 *    //콜스택이 어려개 있다. 
	 *    //Context Switching 
	 *    
	 * 2. 응답성 자체가 확실히 틀리다. 멀티 작업이 가능하다 (비용이 약간 들긴 들지만) 
	 * 	  
	 */
}
