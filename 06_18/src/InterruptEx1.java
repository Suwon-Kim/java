
class InterruptEx1 {
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					//
					System.out.println(
							"isInterrupted :" + isInterrupted()
					);
					System.out.println("sleep...");
					//1�а� ����... RUN->NOT RUNNABLE
					Thread.sleep(1000 * 60);
				} catch (InterruptedException e) {
					System.out.println("wake up");
					System.out.println(
							"isInterrupted :" + isInterrupted()
					);
				}
				
				for(int i = 0; i < 10; i++) {
					System.out.println(i);
				}
			}
		};
		t1.start();
		System.out.println(t1.currentThread().getName());
		//main�� t1.start()�� ���� �� �� �� �ְ� �ΰ� ��  ���� �� �� �� �ִ� .
		t1.interrupt();
		System.out.println(t1.currentThread().getName());
		//�����ִ� �����带 ��⿭�� ������ �������� ���侲�µ� 
		//�̸� �������� ������ �ϴ°� �ƴ� .. interrupt()�޼ҵ带 �����ϱ� ���� �Ѱ�!
	}
}
//isInterrupted() ���ͷ�Ʈ�� �޾Ҵ��� �ȹ޾Ҵ��� Ȯ���ϴ� �޼ҵ� 
//�������� ���¿� interrupt�� ������ �� ������ ���ο� main�� interrupt()�� 
//�����ߴ����� �� �� �ִ�. �ѹ� �ް� ���� ���ͷ�Ʈ �޾Ҵٴ°��� ����� ���������� 
//�׷��� �ؿ����� false�� ���´�.
//�̸� ������ �ٷ� ���´�
