
public class InterruptEx2 {
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				long count = 0;
				//while(true)
				while(!isInterrupted()) {
					//interrupt�� ���������� ��� ���� ����. 
					//interrupted�� �޾Ҵ��� �ȹ޾Ҵ��� true false�� ��Ÿ���ִ� �޼ҵ�
					count++;
				}
				System.out.println(
						"interrupted -> count = " + count
				);
				System.out.println(
						"isInterrupted : " + this.isInterrupted()
						//this�� ���ͷ�Ʈ�� �޾ҽ��ϱ�? 
				);
				/*
				 * 	interrupted
				 *  ���� �����尡 ���ͷ�Ʈ�� �޾Ҿ��ٸ�, 
				 *  true�� ����. ���� �������� ���ͷ�Ʈ ������ �ʱ�ȭ (�ȹ������·�)
				 * 
				 */
				System.out.println(
						"interrupted : " + Thread.interrupted()
						 //*  ���� �����尡 ���ͷ�Ʈ�� �޾Ҿ��ٸ�, 
						 //*  true�� ����. ���� �������� ���ͷ�Ʈ ������ �ʱ�ȭ (�ȹ������·�)
				); 
				System.out.println(
						"isInterrupted : " + this.isInterrupted()
				);
			}
		};
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (Exception e) { }
		t1.interrupt();
	}
}
//not runnable�� �ƴҶ� interrupt�� ������ 
//t1.isInterrupt(); t1�� ���ͷ�Ʈ�� �޾ҽ��ϱ�?
//Thread.interrupted(); �� ������ �����ϴ� �����尡 ���ͷ�Ʈ�� �޾ҽ��ϱ� ?


