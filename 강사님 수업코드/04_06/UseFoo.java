class Foo {
	public int num = 2;
}
class UseFoo {
	public static void main(String[] args) {
		/*
			final이 붙은 경우 f는 다른 Foo객체를 나타낼수 없다.
		*/
		final Foo f = new Foo();
		f.num = 4;
		f = new Foo();
	}
}
