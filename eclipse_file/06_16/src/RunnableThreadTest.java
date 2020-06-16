
public class RunnableThreadTest {
	public static void main(String[] args) {
		//Thread 생성자에 RunnableThread 인스턴스를 파라미터로 전달
		Thread t = new Thread(new RunnableThread()); //실제 쓰레드는 아니다
		t.start();
		System.out.println("end of main");
		//main하고 t와의 경쟁을 또 함
		
	}
}
