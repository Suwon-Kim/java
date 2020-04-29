/*	
	Generics
	
	Collection	
		1. 객체만 사용
		2. 가변길이
		3. 순서가 없다
*/
import java.util.*;
class CollectionEx1 {
	public static void main(String[] args)	{		
		Collection<String> c = new HashSet<String>();
		
		// 원소 갯수구하기
		System.out.println(c.size());

		// 원소추가
		c.add("a");
		c.add("b");

		System.out.println(c.size());

		// 원소 삭제
		c.remove("a");

		System.out.println(c.size());

		c.add("a");
		c.add("c");
		c.add("d");
		c.add("e");
		c.add("f");

		System.out.println(c.size());

		System.out.println(c.contains("x"));
		
		// 모두 삭제
		// c.clear();

		System.out.println(c);

		// Collection -> array
		// Object[] arr = c.toArray();
		String[] arr = c.toArray(new String[0]);
		System.out.println(Arrays.toString(arr));
	}
}
