class A {
	private int num = 100;		// 상속대상에서 제외

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
class B extends A{
	public void printNum() {
		System.out.println(getNum());
	}
}
class Ex1 {
	public static void main(String[] args) {
		B b = new B();
		b.printNum();
		b.setNum(200);
		b.printNum();
	}
}
