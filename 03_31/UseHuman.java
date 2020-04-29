class Human {
	private String name;
	private int age;

	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setName(String newName) {
		name = newName;
	}
	public void setAge(int newAge) {
		age = newAge;
	}
	/*
		객체의 상태 정보를 문자열로 반환
		정해진 양식이나 포멧은 없음.
	*/
	public String toString() {		
		return name + "(" + age + ")";
	}
}
class UseHuman {
	public static void main(String[] args) {
		Human h1 = new Human();
		h1.setName("아이유");
		h1.setAge(28);
		System.out.println(h1);


	}
}
