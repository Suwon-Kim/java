package kr.ac.green;

public class Some {
	private static int num = 100;
	
	public void call() {
		Other o = new Other();
		o.print();
		o.todo();
	}	
	public static class Other {
		// 1. 외부클래스 객체 생성과 관계없이 객체생성이 가능하다.
		// 2. 외부클래스의 정적 요소들만 접근가능하다.
		public void print() {
			System.out.println(num);
		}
		public static void todo() {
			
		}
	}
	
	public static void main(String[] args) {
		Some.Other o = new Some.Other();
	}
}
