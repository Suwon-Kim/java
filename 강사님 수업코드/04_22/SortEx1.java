import java.util.Arrays;
import java.util.Comparator;

/*
	java.util.Comparator<T>
	
	c.compare(a:T, b:T) : int
	
	- 오름차순
	a > b : 양수
	a < b : 음수
	a == b : 0
*/
class Human implements Comparable<Human> {
	private int age;
	private String name;
	
	// 나이로 검색
	public Human(int age) {
		setAge(age);
	}
	// 이름으로 검색
	public Human(String name) {
		setName(name);
	}

	public Human(int age, String name) {
		setAge(age);
		setName(name);
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	// natural ordering : 나이로 정렬
	@Override
	public int compareTo(Human other) {
		return age - other.getAge();
	}
	
	@Override
	public String toString() {
		return name + "(" + age + ")";
	}
}
class SortEx1 {
	public static void main(String[] args)	{
		Human[] arr = {
			new Human(20, "E"),		// 0
			new Human(23, "B"),		// 1
			new Human(22, "C"),		// 2
			new Human(21, "D"),		// 3
			new Human(24, "A")		// 4
		};

		// 부분정렬 : 0~3까지 정렬(0은 포함, 3은 포함하지 않음)
		//Arrays.sort(arr, 0, 3);

		//System.out.println(Arrays.toString(arr));

		// 전체정렬
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		/*
			binarySeach전제 조건	
				1. arr은 반드시 정렬되어야 한다.(natural odering)
					-> Human 은 Comparable 구현
				2. 일반적으로 모든 정렬이 되어 있는 상태에서만 신뢰할 수 있는 값을 돌려준다.(정렬기준이 되는 값이 중복이 없어야함)
				3. 나이로 정렬한경우 나이가 일치하는 대상만 찾을 수 있다.
		*/
		int idx = Arrays.binarySearch(arr, new Human(21));
		System.out.println(idx);
	}
}
