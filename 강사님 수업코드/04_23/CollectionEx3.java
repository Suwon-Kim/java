import java.util.*;
class CollectionEx3 {
	public static void main(String[] args)	{
		Collection<String> main = new ArrayList<String>();
		main.add("a");
		main.add("b");
		main.add("c");
		main.add("d");
		main.add("e");
		main.add("f");

		Collection<String> others = new ArrayList<String>();
		others.add("a");
		others.add("b");
		others.add("c");
		others.add("x");
		
		System.out.println("main - " + main);
		System.out.println("others - " + others);
		// others의 원소와 일치하는 원소 모두 삭제
		// main.removeAll(others);
		// others의 원소와 일치하지 않는 원소 모두 삭제
		// main.retainAll(others);
		// others의 모든 원소가 main에 존재하는가?
		// System.out.println(main.containsAll(others));
		// others의 모든 원소를 main에 추가
		// main.가l(others);
		System.out.println("main - " + main);
		System.out.println("others - " + others);
	}
}
