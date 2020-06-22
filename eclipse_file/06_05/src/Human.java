
public class Human {
	public static final boolean MALE = false;
	public static final boolean FEMALE = true;
	
	private String name;
	private int age;
	private boolean gender;
	public Human(String name, int age, boolean gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public Human() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public static boolean isMale() {
		return MALE;
	}
	public static boolean isFemale() {
		return FEMALE;
	}
	@Override
	public String toString() {
		String sex = gender ? "����" : "����";
		
		return name + "(" + age + ", " + sex + ")";
	}
		
}