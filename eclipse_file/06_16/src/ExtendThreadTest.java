//쓰레드를 만드는 첫 번째 방법 
public class ExtendThreadTest {
	public static void main(String[] args) {
		ExtendThread et = new ExtendThread();
		
		et.start();	//run을 호출하지 않고 start()를 해야함 (일해)
		//쓰레드의 런은 우리가 호출하는게 아님 
		System.out.println("end of main");

		//end of main이 먼저 나오는데 
		//et.start(),와 메인이 경쟁하는데 메인이 이겨서 
		//출력하면 end of main이 출력됨 
		//수백번 수만번 돌리면 바껴서 출력 될 수도 있음 
	}
}
