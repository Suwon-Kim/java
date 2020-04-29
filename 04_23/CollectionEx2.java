import java.util.*;
class CollectionEx2 {
	public static void main(String[] args)	{
		// 순서 -> index -> 식별자
		Collection<Integer> c = new HashSet<Integer>();

		c.add(3);
		c.add(1);
		c.add(2);
		c.add(5);
		c.add(4);

		// 원소 접근이 가능한 객체를 얻는다(Iterator)
		Iterator<Integer> itr = c.iterator();

		while(itr.hasNext()) {
			int num = itr.next();
			System.out.println(num);
		}

		// JDK1.5~
		for(Integer i : c) {
			System.out.println(i);
		}
	}
}
