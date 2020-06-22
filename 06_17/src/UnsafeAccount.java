
public class UnsafeAccount {
	private int balance;
	public int getBalance() {
		return balance;
	}
	//val = 5000;
	public void deposit(int val) {
		balance += val;
	}
	public void withdraw(int val) {	//임계 영역 
		// Critical section 공유자원 내부에서 2개의 쓰레드가 동시에 존재할 수 있는
		// 공간을 임계영역이라고 한다. 이런게 생기면 
		// 동기화가 깨질 위험성이 생긴다 그래서 위험하다.
		// - 값이 왜 들어오는가 ? ? 
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			balance -= val;
			//빼기 전에 잠든다 그러고 또 다른 쓰레드가 다시 들어온다 그러다가 다시
			//잠든다. 제일 처음에 잠든놈이 깨어나면서 val값을 뺀다. 
			//어떤특정한 공간에 2개의 쓰레드가 진입하는거에 문제가 있다. 
			//동시에 못 들어오게 막는다. 화장실 관련 생각해보자 
			//좌변기를 쓰는 사람 위에 또 사람이 앉는거 ! 해결하는 방법 문을 만든다
			//특정한 쓰레드가 들어오면 다른 쓰레드가 못들어오게 문을 잠그고 들어갔다가
			//다른 쓰레드가 문이 있어서 못 들어오고 기다린다.(쓰레드가 일이 끝날때까지)
			//하나씩 하나씩 처리 하는 이런 방식을 MUTEX 방식이라 한다 (상호배제)
			//임계영역상에서 동기화를 사전 차단 하기 위해서 MUTEXT 방식을 사용한다.
			//언어 차원에서 
		}
		if(balance >= val) {
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				
			}
			balance -= val;
		}
		System.out.println(
				"name :" + Thread.currentThread().getName() +
				", balance " + this.getBalance()
		);
	}
}
