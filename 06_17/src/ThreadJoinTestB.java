
public class ThreadJoinTestB {
	public static void main(String[] args) {
		//������ ����
		Thread t = new Thread() {
			public void run() {
				try {
					//2�ʰ� ����
					Thread.sleep(2000);
					// ������ ���� �޼���
					System.out.println("MyThread ����");
					//3�ʰ� ����
					Thread.sleep(3000);
				} catch (Exception e) {//InterruptedException e }
					
				}
			}
		};
		// ������ ����
		t.start();
		try {
			
			// join() �޼ҵ� ����..
			// t �����尡 ����ɶ����� main �����尡 ��ٸ�.
			t.join();
			//main ������� ���⼭ �����. <-- not Runable ���·� ����
			//t�� ����� �� not Runnable�� Ǯ����.
			//t�� ���� �ϴ°� �ƴ�.. t�� ���� ���ϴ°� �ƴϰ� main�����尡 ����
			//�� �ްԵȴ�. 
			//join ������� �� �����尡 ���������� ��ٸ��³�
			//�츮�� ������ �޴� �ڵ�� �� �ٸ��� �������� t�� ��� ����µ� �̰Ŵ�
			//�ƴ�
		} catch (InterruptedException e) {
			//����Ұ� ���¸� ������ �� InterruptedException �߻�
			e.printStackTrace();
		} 
		System.out.println("main() ����");
	}
}
