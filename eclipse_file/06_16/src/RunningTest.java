
public class RunningTest {
	public static void main(String[] args) {
		/*
		     자신을 생성한 쓰레드의 우선순위 값을 그대로 물려받는다.
		 */
		SomeThread t1 = new SomeThread("A");
		SomeThread t2 = new SomeThread("B");
		SomeThread t3 = new SomeThread("C");
		
		// 우선순위가 높은 쓰레드가 선택될 가능성이 높다.
		t1.setPriority(Thread.MIN_PRIORITY);	//1
		t2.setPriority(Thread.NORM_PRIORITY);	//5
		t3.setPriority(Thread.MAX_PRIORITY);	//10
		// 우선순위가 높은애가 경쟁상대에서 뽑힐 확률이 좀 더 늘어난다
		// 반복을 많이 했을 때 (무조건 경쟁에서 우월하다는거는 아님)
		//잘 안쓴다 이렇게 쓰지 말라고 보여준 예제임
	
		t1.start();
		t2.start();
		t3.start();
	}
}
