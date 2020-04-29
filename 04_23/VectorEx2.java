import java.util.*;
/*
	Vector
	ArrayList
*/
class VectorEx2 {
	public static void printIndice(Vector<String> vec, String word) {
		// 반복여부
		boolean flag = true;
		// 인덱스 담을 변수
		int idx = 0;
		while(flag) {
			idx = vec.indexOf(word, idx);
			if(idx == -1) {
				flag = false;
			} else {
				System.out.println(idx);
				idx++;
			}
		}
		/*
		for(int idx=0; (idx=vec.indexOf(word, idx)) != -1; idx++ ) {
			System.out.println(idx);
		}
		*/
	}
	public static void main(String[] args)	{
		Vector<String> list = new Vector<String>();
		list.add("apple");
		list.add("banana");
		list.add("kiwi");
		list.add("apple");
		list.add("grape");
		list.add("apple");
		list.add("mango");
		list.add("apple");
		list.add("melon");
		list.add("pitch");

		printIndice(list, "apple");
	}
}
