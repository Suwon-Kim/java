//��� ������ �Ⱦ�����
public class NormalProcess {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < 300; i++) {
			System.out.println("-");
		}
		System.out.print(
				"�ҿ�ð�1:" + (System.currentTimeMillis() - startTime)
		);
		for(int i = 0; i < 300; i++) {
			System.out.println("|");
		}
		System.out.print(
				"�ҿ�ð�2:" + (System.currentTimeMillis() - startTime)
		);
	}
	//������ �Ⱦ��� ������ ���� ���غ��� ��� ���Ѵ�� �����غ��� 
	//������ ������ �� ���� �ð��� ��Ƹ԰Ե� �̰� �� �׷� �Ǵ��� �˾ƺ��� (ĥ��)
	
	//(a b) < -- nomal  (a)(b) < -- thread
	//thread�� �� �� �� ��� �۾��̴�. 
	//1. �� thread�� �� ���� �ɸ��°� ? 
	//2. ��� 
	
	/*
	 * ���� ���� 
	 * 1. nomal -- > a�� ��� �����ϰ� a�� ������ b�� �����ϸ� �Ǵ� �����ε�
	 * �ݽ����� �Ѱ� �ִ�. 
	 * 
	 *    thread -- > 1,2,3 �ϰ� ���� �۾��� ���� ������ �ʿ��ϰ� (4,5)�� ���� ���ؼ�
	 *    �б� �۾��� �ʿ��ϴ� ���Ʊ�ȯ�� �� �� ������ �ʿ��ϰ� �бⰡ �ʿ��ϴ� .
	 *    //�ݽ����� ����� �ִ�. 
	 *    //Context Switching 
	 *    
	 * 2. ���伺 ��ü�� Ȯ���� Ʋ����. ��Ƽ �۾��� �����ϴ� (����� �ణ ��� ������) 
	 * 	  
	 */
}
