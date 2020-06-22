
public class SyncAccount {
	private int balance;
	//synchronized (��ȣ����) -- > Mutal Exculsion : MUTEX
	public synchronized int getBalance() {
		return balance;
	}
	//synchronized�� rock�� ��ü�� this �̴�.
	//�޼ҵ� ���·� , ��� ���·� 2���� ���·� ���� �� �� �ִ�. 
	//synchronized ������·� --- > ������ ������ �� �ִ�.
	//synchronized ����� �߸� ���� ��Ƴ��� �����... 
	//�̷л����δ� ���ƺ��̴µ� �����δ� ��Ϻ��� �޼ҵ� ���·� ���� ����.
	//�������� �Ϻ��� �����ϰ� �־���Ѵ�. ��ϰ� �޼ҵ带 ���� ���� ������
	public synchronized void deposit(int val) {
		balance += val;
	}
	public synchronized void withdraw(int val) {
		//�ٸ� �����尡 ���� �� ���� ���� ��ٴ�.
		//���� �� ������ ���� ���� �����ִ� ����̴�.
		//�ڹٴ� rock�� ������ �¾��. 
		//�����δ� ��ü�� rock�� ����Ѱ͸� �ȿ� ��� �� �� �ִ�
		//rock�� ������� ���� ���� ��� �� �� ����
		//��ü�� rock�� ����ߴ��� ���ߴ����� �Ǻ��Ѵ� .synchronized 
		//������ ���ΰ� ��� ��ü�� ���� �� ������ �ִ� . synchronized �پ��ִ� �޼ҵ� ���� 
		//rock�� ��ü�� this�̴�. 
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
	// Monitor : Rock�� �˻� 
	// 1. �����ڿ�  -- > �Ӱ迵�� 
	// 2. Synchronized (��ȣ ����)
	//     --> �޼ҵ� : this ��ü �ڽ��� rock�� ������ 
	//     --> ��    : ���� (rock�� ��ü) ����(����)
	
	//o/s��, sw���� ������ �˾ƾ� �Ѵ�.. �б����� ��� �� ������ �Ҳ�..��.��
	
	//thread �ϴ� ������ ��Ʈ��ũ�� �ϱ� ���ؼ� ... 
}
