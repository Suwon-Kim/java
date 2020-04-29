class Parent {
	public void todo() { System.out.println("Parent"); }
	public void call() { todo(); }
}
class Child extends Parent {
	@Override
	public void todo() { System.out.println("Child"); }
	@Override
	public void call() { super.call(); }
}
class Ex6 {
	public static void main(String[] args) {
		Child c = new Child();
		c.call();
	}
}
