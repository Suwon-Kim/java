
public class ThreadEx1_1 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("t1 : " + getName());
			//getName() ������ Ŭ���� ���� getName()��
		}
	}
}
