//import하는게 하나도 없다 -- > java.lang(가장 기본적인 import)
//java.lang은 중요한 패키지 기본 패키지
//Thread 클래스는 일반 클래스이므로 import를 안함
public class ExtendThread extends Thread {
	//쓰레드가 할일 정의 	
	public void run() {
	//run 메소드는 메인 말고 따로 실행하게 만들것을 넣음
		System.out.println("Thread 클래스를 상속");
	}
}


