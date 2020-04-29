/*
	생성자의 갯수 -> 객체 생성의 경우의 수
*/
class Human {
	private String name;
	private int age;
	public Human() {
		
	}
	// 응집력높을수록 좋은 클래스다.
	public Human(String newName) {
		setName(newName);
	}
	public Human(String newName, int newAge) {
		setName(newName);
		setAge(newAge);
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
}
class UseHuman {
	public static void main(String[] args) {
		Human h = new Human();
	}
}
