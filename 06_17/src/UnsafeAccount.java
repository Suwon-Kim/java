
public class UnsafeAccount {
	private int balance;
	public int getBalance() {
		return balance;
	}
	//val = 5000;
	public void deposit(int val) {
		balance += val;
	}
	public void withdraw(int val) {	//�Ӱ� ���� 
		// Critical section �����ڿ� ���ο��� 2���� �����尡 ���ÿ� ������ �� �ִ�
		// ������ �Ӱ迵���̶�� �Ѵ�. �̷��� ����� 
		// ����ȭ�� ���� ���輺�� ����� �׷��� �����ϴ�.
		// - ���� �� �����°� ? ? 
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			balance -= val;
			//���� ���� ���� �׷��� �� �ٸ� �����尡 �ٽ� ���´� �׷��ٰ� �ٽ�
			//����. ���� ó���� ������ ����鼭 val���� ����. 
			//�Ư���� ������ 2���� �����尡 �����ϴ°ſ� ������ �ִ�. 
			//���ÿ� �� ������ ���´�. ȭ��� ���� �����غ��� 
			//�º��⸦ ���� ��� ���� �� ����� �ɴ°� ! �ذ��ϴ� ��� ���� �����
			//Ư���� �����尡 ������ �ٸ� �����尡 �������� ���� ��װ� ���ٰ�
			//�ٸ� �����尡 ���� �־ �� ������ ��ٸ���.(�����尡 ���� ����������)
			//�ϳ��� �ϳ��� ó�� �ϴ� �̷� ����� MUTEX ����̶� �Ѵ� (��ȣ����)
			//�Ӱ迵���󿡼� ����ȭ�� ���� ���� �ϱ� ���ؼ� MUTEXT ����� ����Ѵ�.
			//��� �������� 
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
