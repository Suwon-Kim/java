class Father {
	public void sayHello() {
		System.out.println("æ»≥Á~");
	}
}
class Son extends Father {
	@Override
	public void sayHello() {
		System.out.println("æ»≥Á«œΩ ¥œ±Ó~");
	}
}

class Poly3 {
	public static void main(String[] args) {
		Son s = new Son();
		s.sayHello();

		Father f = s;
		f.sayHello();
	}
}
