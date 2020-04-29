import java.util.*;
class Ex {
	public static void main(String[] args)	{
		// 배열 -> List
		// 추가, 삭제 하면 실행중 에러발생
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		System.out.println(list);
		
		// 새로운 List만들어서 쓰면 해결됨
		Vector<Integer> other = new Vector<Integer>(list);
		other.remove(0);
		System.out.println(other);
	}
}
