package kr.ac.green;

public class OuterClass {
	private int num = 100;
	private InnerClass some = new InnerClass(); 
	/* - Inner Class
	 * 1. �ܺ�Ŭ���� ��ü�� ���� �� �Ŀ� ����Ŭ���� ��ü ���� ����
	 * 2. ��� ���������ڸ� �� ������ �ִ�.
	 * 3. �ܺ�Ŭ������ ����� ���� ������ �����Ӵ�.(private ����)
	 * 4. static ��Ҹ� ���� �� ����.
	 */
	
	public void print() {
		System.out.println(some.other);
		some.todo();
	}
	private class InnerClass {
		private int other = 10;
		public void print() {
			System.out.println(num);
		}
		private void todo() {
			System.out.println("aa");
		}		
	}	
	
	public static void main(String[] args) {
		OuterClass o = new OuterClass();
		o.print();
		// �̷��� ��������~
		//OuterClass.InnerClass subObj = o.new InnerClass();
	}
}





