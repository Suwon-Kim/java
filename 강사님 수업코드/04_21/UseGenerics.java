interface IFoo<T> {
	void todo(T t);
}

class Some<E> implements IFoo<String> {
	public E e;

	public E getE() {
		return e;
	}
	@Override
	public void todo(String t) {
	}
}

class UseGenerics {
	public static void main(String[] args)	{
		Some<String> s1 = new Some<String>();
		s1.e = "abc";

		Some<Human> s2 = new Some<Human>();
		s2.e = new Human("abc", 20);
	}
}
