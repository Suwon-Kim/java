package kr.ac.green;

public class Some {
	private static int num = 100;
	
	public void call() {
		Other o = new Other();
		o.print();
		o.todo();
	}	
	public static class Other {
		// 1. �ܺ�Ŭ���� ��ü ������ ������� ��ü������ �����ϴ�.
		// 2. �ܺ�Ŭ������ ���� ��ҵ鸸 ���ٰ����ϴ�.
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