//�����带 ����� ù ��° ��� 
public class ExtendThreadTest {
	public static void main(String[] args) {
		ExtendThread et = new ExtendThread();
		
		et.start();	//run�� ȣ������ �ʰ� start()�� �ؾ��� (����)
		//�������� ���� �츮�� ȣ���ϴ°� �ƴ� 
		System.out.println("end of main");

		//end of main�� ���� �����µ� 
		//et.start(),�� ������ �����ϴµ� ������ �̰ܼ� 
		//����ϸ� end of main�� ��µ� 
		//����� ������ ������ �ٲ��� ��� �� ���� ���� 
	}
}