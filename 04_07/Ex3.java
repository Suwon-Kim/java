class Mother {
	private int age = 60;

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
class Daughter extends Mother {
	
}
class Ex3 {
	public static void main(String[] args) {
		Daughter d = new Daughter();
		d.setAge(30);
		System.out.println(d.getAge());
		
		System.out.println(new Mother().getAge());
	}
}
