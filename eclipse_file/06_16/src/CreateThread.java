//쓰레드가 3개 존재함 
public class CreateThread {
	public static void main(String[] args) {
		ThreadEx1_1 t1 = new ThreadEx1_1();
		
		Runnable r = new ThreadEx1_2();
		Thread t2 = new Thread(r);
		
		t1.start();
		//t1안에 들어가서 start()를 실행해라 t1이 주체가 아니고 쓰레드가 일을 시키는거임
		//일을 시킨놈이 쓰레드임 t1가 일을 시킨것이 아니고 
		//t1아 일해라고 누가 시켰는데 일 시킨놈의 주체가 쓰레드다.
		t2.start();
		
		System.out.println(Thread.currentThread().getName());
		//현재 쓰레드를 수행하는놈의 이름을 출력해
		//현재 작업중인 쓰레드를 뽑아오는놈 --- > Thread.currentThread()
	}
}
