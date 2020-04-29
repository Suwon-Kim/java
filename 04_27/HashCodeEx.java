/*
	Object
		- hashCode() : ��ü�� �ּ�(10����: System.identityHashCode()) 
		- toString() : type + "@" + Integer.toHexString(hashCode())
*/

class Some {
	
}
class HashCodeEx {
	public static void main(String[] args)	{
		Some s1 = new Some();
		Some s2 = new Some();
		/*
			s1 == s2
			System.identityHashCode(s1) == System.identityHashCode(s2)
		*/
		// Object �� hashCode�� �ּҸ� �����Ѵ�.(10����)
		System.out.println(
			// ���� �ּҰ�
			"s1 identityHashcode : " + System.identityHashCode(s1)
		);
		System.out.println(
			"s2 identityHashcode : " + System.identityHashCode(s2)
		);
		System.out.println("s1 hashCode : " + s1.hashCode());
		System.out.println("s2 hashCode : " + s2.hashCode());

		System.out.println("s1 toString : " + s1);
		System.out.println("s2 toString : " + s2);
		
		System.out.println(
			"s1 addr : " + Integer.toHexString(s1.hashCode())
		);
		System.out.println(
			// 16������ ��ȯ
			"s2 addr : " + Integer.toHexString(s2.hashCode())
		);
	}
}
