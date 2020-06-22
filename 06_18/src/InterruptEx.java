

class Dummy {
	public synchronized void todo() {
		try {
			System.out.println("start....");
			wait();	//not runnable �̹Ƿ� Inter ����ó��
		} catch (InterruptedException e) {
			System.out.println("Interrputed");
		}
	}
}
public class InterruptEx {
	public static void main(String[] args) {
		//final ������ �ʴ°� 
		final Dummy d = new Dummy();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				d.todo();
				System.out.println("I'm dead");
			}
		};
		t1.start();
		t1.interrupt();
	}
}

/*
 *	interrupt  
 *  �����⿭�� ���ƿ´�.. ������ wait�� ���� �־���ϴµ� 
 *  //���ܰ� �߻��ϰ� �װ� �������� ���´�.not Runnable ���¿��� 
 *  Runnable ���·� �ٲ��.
 *  wait ���� not Runnable
 *  //���¿� �ִ� ��Ÿ� �� �ȴ�. 
 *  
 *  lock�� ������ wait�� ����� �� �ִ�. 
 *  t1.interrupt() ---> ������ InterruptedException e�� ������
 *  
 *  wait���� �����־�� �ϴµ� ���ܸ� �߻���Ű�鼭
 *  ������ �� �ִ� ���·� �ٲ��� (Runnable)���·�
 *  ���� ���·� ���°� �ƴϰ� ���డ�� ���·� �ٲ���...
 *  
 *  ������ �� ���� ���¸� ���߶�¸���..
 *  
 *  
 *  
*/