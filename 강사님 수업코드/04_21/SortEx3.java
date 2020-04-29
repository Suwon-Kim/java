import java.util.Arrays;
class Human implements Comparable<Human>{
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
	@Override
	public String toString() {
		return name + "(" + age + ")";
	}

	@Override
	public int compareTo(Human other) {
		// 비교 기준을 정한다.
		// 2. name
		// return name.compareTo(other.getName()) * -1;
		// 1. age
		
		int otherAge = other.getAge();
		
		//return (age - otherAge) * -1;
		
		// 나이로 오름차순, 단 같은 나이인 경우 이름으로 내림차순
		if(age > otherAge) {
			return 1;
		} else if(age < otherAge) {
			return -1;
		} else {
			return name.compareTo(other.getName()) * -1;
		}
		
	}
}
/*
	java.lang -> 프로그래밍 기초 클래스(API)들이 존재하는 패키지

	a.compareTo(b)

	a < b : 음수
	a == b : 0
	a > b : 양수
*/
class SortEx3 {
	public static void main(String[] args)	{
		Human[] arr = {
			new Human("아이유", 20),
			new Human("승미", 42),
			new Human("에일리", 20),
			new Human("승민", 27),
			new Human("윤아", 20),
			new Human("노승민", 34)
		};
		
		Arrays.sort(arr);	

		System.out.println(Arrays.toString(arr));
	}
}
