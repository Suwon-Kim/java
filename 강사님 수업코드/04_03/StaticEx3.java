class StaticEx3 {

	{
		System.out.println("non-static block");
	}

	static {
		System.out.println("static block");
	}

	public static void main(String[] args) {
		new StaticEx3();
		new StaticEx3();
		new StaticEx3();
		new StaticEx3();
	}
}
