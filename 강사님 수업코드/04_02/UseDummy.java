/*
	this
		1. 자신의 주소 : this, this.xxx
		2. 자신의 생성자 : this(...)
*/
class Dummy {
	private int num1;
	private int num2;

	public Dummy(int num1) {
		this.num1 = num1;
	}
	public Dummy(int num1, int num2) {
		this(num1);
		this.num2 = num2;
	}
	public String toString() {
		return num1 + " : " + num2;
	}
}
class UseDummy {
	public static void main(String[] args) {
		System.out.println(new Dummy(100, 200));
	}
}
