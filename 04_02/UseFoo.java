class Foo {
	public int num = 2;

	public void todo(int num) {
		System.out.println("this : " + this);
		System.out.println(this.num);
	}
	public void print() {
		System.out.println(this);
	}
	public String toString() {
		return  "num : " + num;
	}
	
}
class UseFoo {
	public static void main(String[] args) {
		Foo f = new Foo();
		System.out.println(f);
		f.print();
	}
}
