/*
	접근자 : getter
	설정자 : setter
*/
class Human {
	private int age = 40;
	private String name;
	private boolean male;

	public boolean isMale() {
		return male;
	}

	// getter
	// 멤버변수를 외부로 돌려준다.
	public int getAge() {
		// ...
		return age;
	}
	public String getName() {
		return name;
	}
	// setter
	// 멤버변수의 값을 변경한다.
	public void setAge(int newAge) {
		if(newAge < 100) {
			age = newAge;
		}
	}
	public void setName(String newName) {
		name = newName;
	}
}
class UseHuman {
	public static void main(String[] args) {
		Human h = new Human();
		//h.age = 1000;
		h.setAge(40);
		System.out.println(h.getAge());
		h.setName("홍길동");
		System.out.println(h.getName());
	}
}
