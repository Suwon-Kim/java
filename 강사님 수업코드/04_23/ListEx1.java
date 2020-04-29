/*
	Collection : 객체, 가변길이, 순서(x)
		1. List : 순서(o)
			- Vector
			- ArrayList
		2. Set
*/
import java.util.*;
class ListEx1 {
	public static void main(String[] args)	{
		List<String> list = new Vector<String>();

		list.add("a");		// 0
		list.add("b");		// 1
		list.add("c");		// 2
		list.add("d");		// 3
		list.add("e");		// 4		

		System.out.println(list);

		list.add(1, "f");

		System.out.println(list);

		String element = list.get(3);
		System.out.println(element);

		list.remove(1);
		System.out.println(list);
		// 조심해
		/*
		for(int i=list.size()-1; i>=0; i--) {
			if(true) {
				list.remove(i);
			}
		}
		System.out.println(list);
		*/

		list.set(2, "x");
		System.out.println(list);
	}
}
