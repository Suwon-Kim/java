class Human {
	private String name;
	private int age;

	public Human(String name, int age) {
		setName(name);
		setAge(age);
	}

	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	// 나이와 이름이 같으면 같은 사람이다.
	@Override
	public boolean equals(Object other) {
		if(other == null || !(other instanceof Human) ) {
			return false;
		}
		// h1.equals(h2)
		Human h = (Human)other;
		// 나이비교
		boolean result1 = (age == h.getAge());
		// String의 equals 사용 -> 문자열 내용이 같으면 같다.
		boolean result2 = name.equals( h.getName() );

		return result1 && result2;
	}
}
class UseHuman {
	public static void main(String[] args) {
		Human h1 = new Human("A", 20);
		Human h2 = new Human("B", 30);
		Human h3 = new Human("C", 20);
		Human h4 = new Human("A", 20);

		System.out.println(h1.equals(h2));
		System.out.println(h1.equals(h3));
		System.out.println(h1.equals(h4));
	}
}
