package kr.ac.green;

public class OuterClass {
	private int num = 100;
	private InnerClass some = new InnerClass(); 
	/* - Inner Class
	 * 1. 외부클래스 객체가 생성 된 후에 내부클래스 객체 생성 가능
	 * 2. 모든 접근제한자를 다 가질수 있다.
	 * 3. 외부클래스의 멤버에 대해 접근이 자유롭다.(private 포함)
	 * 4. static 요소를 가질 수 없다.
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
		// 이렇게 쓰지마라~
		//OuterClass.InnerClass subObj = o.new InnerClass();
	}
}






