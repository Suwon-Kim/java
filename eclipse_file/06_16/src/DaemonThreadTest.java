
public class DaemonThreadTest {
	public static void main(String[] args) {
		Thread t = new Thread() {
		//스레드 생성
			public void run() {
				try {
					//5초간 멈춤
					Thread.sleep(5000);
					//스레드 종료 메세지
					System.out.println("MyThread 종료");
					
				} catch (Exception e) {
					//무시
				}
			}
		};
		//데몬 쓰레드 : 다른 쓰레드가 끝나면 얘도 같이 끝난다.자신을 제외한 나머지 일반 쓰레드가
		//종료되어 버리면 데몬 쓰레드는 따라 종료된다. 
		//쓰레드가 5개면 5개가 다 종료되어야 데몬쓰레드가 종료된다.
		//가비지 컬렉터도 데몬 쓰레드임
		//데몬 스레드로 설정
		//스타트 하기 전에 불러야한다. 백그라운 작업을 할꺼면 데몬 쓰레드로 만들어져야 한다.
		t.setDaemon(true);
		// 스레드 시작
		t.start();
		
		//main메소드 종료 메세지
		System.out.println("main() 종료");
	}
}
