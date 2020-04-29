class SuperMan {
	public SuperMan(int n) {
	}
}
class SubMan extends SuperMan {
	public SubMan() {
		super(3);
	}
}
class Ex4 {
	public static void main(String[] args) {
		new SubMan();
	}
}
