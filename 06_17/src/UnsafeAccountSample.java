
public class UnsafeAccountSample {
	public static void main(String[] args) {
		final UnsafeAccount account = new UnsafeAccount();
		//
		account.deposit(5000);
		Runnable withdrawRun = new Runnable() {
			public void run() {
				for(int i = 0; i < 10; i++) {
					account.withdraw(500);
				}	//inner class ����ؼ� account�� ��� �� �� ����
			}
		};
		Thread t1 = new Thread(withdrawRun); //�����尡 �ϴ� ���� ����
		Thread t2 = new Thread(withdrawRun);//�����尡 �ϴ� ���� ����
		t1.start();
	
		System.out.println("����");
		t2.start();
		//2���� �����尡 account�� �����ϰ� �ִ�. 
		// 
		
		// t1 - > account (�����ڿ�)
		// t2 - > account (�����ڿ�)
		// account�� �˰� �ִ� ������ �޶� ������ ����
		// ������ ����ȭ�� ������.
		// ���� ���� 100���� �ΰ� ���µ� ���� ���� 100�� �ִ°ɷ� �˰� �ִ� 
		// ������ ���� �ͼ� 100���� ���� 100���� �������� ������ ���� 100���� ���°ɷ�
		// �˰� �ִ�. �����ϴ� ���� ������ ������ �ٸ��� �˰� �ִ°��� 
		// ����ȭ�� �����ٰ� �Ѵ�. // ����ȭ�� �˰� �ִ°� ���ٴ°���
		
		
		
		//public�� static�� ������ ���� 
	}
}
