import java.util.*;
class VectorEx1 {
	public static void main(String[] args)	{
		Vector<String> vec = new Vector<String>();

		vec.add("a");	// 0
		vec.add("b");	// 1
		vec.add("c");	// 2
		vec.add("a");	// 3
		vec.add("d");	// 4
		vec.add("a");	// 5
		// list
		int idx = vec.indexOf("x");
		System.out.println(idx);
		idx = vec.lastIndexOf("a");
		System.out.println(idx);

		System.out.println(vec.indexOf("a", 2));
		System.out.println(vec.lastIndexOf("a", 4));
	}
}
