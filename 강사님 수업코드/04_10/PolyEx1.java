class Parent {
	public void methodParent() {
		System.out.println("Parent");	
	}
}
class Child extends Parent {
	public void methodChild() {
		System.out.println("Child");
	}
}
class PolyEx1 {
	public static void main(String[] args) {
		/*
			Child
				-> methodParent() + methodChild()
			Parent
				-> methodParent()
		*/
		Child c = new Child();
		c.methodParent();
		c.methodChild();

		Parent p = c;
		p.methodParent();
		// p.methodChild();
		
		// Parent -> Child
		Child c2 = (Child)p;
		c2.methodParent();
		c2.methodChild();

		Parent parent = new Parent();
		// Parent -> Child
		// Child c3 = (Child)parent;

		PolyEx2.parentToChild(new Child());
		PolyEx2.parentToChild(new Parent());
	}
}
























