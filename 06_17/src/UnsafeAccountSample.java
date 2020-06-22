
public class UnsafeAccountSample {
	public static void main(String[] args) {
		final UnsafeAccount account = new UnsafeAccount();
		//
		account.deposit(5000);
		Runnable withdrawRun = new Runnable() {
			public void run() {
				for(int i = 0; i < 10; i++) {
					account.withdraw(500);
				}	//inner class 사용해서 account를 사용 할 수 있음
			}
		};
		Thread t1 = new Thread(withdrawRun); //쓰레드가 하는 일이 같다
		Thread t2 = new Thread(withdrawRun);//쓰레드가 하는 일이 같다
		t1.start();
	
		System.out.println("메인");
		t2.start();
		//2개의 쓰레드가 account를 공유하고 있다. 
		// 
		
		// t1 - > account (공유자원)
		// t2 - > account (공유자원)
		// account의 알고 있는 정보가 달라서 문제가 있음
		// 어려운말로 동기화가 깨졌다.
		// 내가 집에 100원을 두고 갔는데 나는 집에 100원 있는걸로 알고 있다 
		// 동생이 집에 와서 100원을 보고 100원을 가져갔다 동생은 집에 100원이 없는걸로
		// 알고 있다. 공유하는 집은 같은데 정보를 다르게 알고 있는것을 
		// 동기화가 깨졌다고 한다. // 동기화는 알고 있는게 같다는거임
		
		
		
		//public한 static은 만들지 마라 
	}
}
