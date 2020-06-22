
public class SyncAccount {
	private int balance;
	//synchronized (상호배제) -- > Mutal Exculsion : MUTEX
	public synchronized int getBalance() {
		return balance;
	}
	//synchronized의 rock의 주체는 this 이다.
	//메소드 형태로 , 블록 형태로 2가지 형태로 존재 할 수 있다. 
	//synchronized 블록형태로 --- > 범위를 지정할 수 있다.
	//synchronized 블록을 잘못 쓰면 잡아내기 힘들다... 
	//이론상으로는 좋아보이는데 실제로는 블록보다 메소드 형태로 많이 쓴다.
	//차이점을 완벽히 이해하고 있어야한다. 블록과 메소드를 썼을 때의 차이점
	public synchronized void deposit(int val) {
		balance += val;
	}
	public synchronized void withdraw(int val) {
		//다른 쓰레드가 들어올 수 없게 문을 잠근다.
		//일이 다 끝나고 나면 문을 열어주는 방식이다.
		//자바는 rock을 가지고 태어난다. 
		//실제로는 객체의 rock을 취득한것만 안에 들어 올 수 있다
		//rock을 취득하지 않은 놈은 들어 올 수 없다
		//객체의 rock을 취득했는지 안했는지를 판별한다 .synchronized 
		//누구의 락인가 모든 객체는 락을 다 가지고 있다 . synchronized 붙어있는 메소드 안의 
		//rock의 주체는 this이다. 
		if(balance >= val) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}
			balance -= val;
		}
		System.out.println("name:" + Thread.currentThread().getName() + 
				", balance = " + this.getBalance());		
	}
	// Monitor : Rock을 검사 
	// 1. 공유자원  -- > 임계영역 
	// 2. Synchronized (상호 배제)
	//     --> 메소드 : this 객체 자신의 rock을 가지고 
	//     --> 블럭    : 지정 (rock의 주체) 지정(범위)
	
	//o/s랑, sw공학 무조건 알아야 한다.. 학교에서 배울 때 열심히 할껄..ㅠ.ㅠ
	
	//thread 하는 이유가 네트워크를 하기 위해서 ... 
}
