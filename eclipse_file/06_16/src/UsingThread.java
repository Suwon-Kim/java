import javax.swing.JOptionPane;
//�����带 �и� �س����� �ٸ����� �ϸ鼭 �ٸ����� �� �� �ִ�.
public class UsingThread {
	public static void main(String[] args) {
		ThreadEx th1 = new ThreadEx();
		th1.start();
		
		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ��� ");
		
		System.out.println("�Է��Ͻ� ���� " + input + "�Դϴ�.");
		//�ڹ� ���α׷��� ���α׷��� ������ ������ 
		//�ݽ����� ������� ������ �Ǵµ� �ݽ����� �������� ���� 
		//������ ����  �ݽ����� ���� �����Ѵ�
		//��� �� ������ �� ������� �� ���α׷��� ����ȴ� . 
		//main�������  ��������  th1 ������� ���� ������� �ʾұ� ������ 
		//th1 �����尡 ������ �ݽ����� ���� ����� -- > real ����
		//�����󿡴� �����尡 �ϳ� �� �����Ѵ�.
		//���伺�� ��������. ��� ��ٸ��µ��� ����ڴ� �� �ٸ� ���𰡸� �� �� �ִ�.
		
	}
}