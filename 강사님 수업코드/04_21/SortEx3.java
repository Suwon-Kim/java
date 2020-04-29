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
		// �� ������ ���Ѵ�.
		// 2. name
		// return name.compareTo(other.getName()) * -1;
		// 1. age
		
		int otherAge = other.getAge();
		
		//return (age - otherAge) * -1;
		
		// ���̷� ��������, �� ���� ������ ��� �̸����� ��������
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
	java.lang -> ���α׷��� ���� Ŭ����(API)���� �����ϴ� ��Ű��

	a.compareTo(b)

	a < b : ����
	a == b : 0
	a > b : ���
*/
class SortEx3 {
	public static void main(String[] args)	{
		Human[] arr = {
			new Human("������", 20),
			new Human("�¹�", 42),
			new Human("���ϸ�", 20),
			new Human("�¹�", 27),
			new Human("����", 20),
			new Human("��¹�", 34)
		};
		
		Arrays.sort(arr);	

		System.out.println(Arrays.toString(arr));
	}
}
