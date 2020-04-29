import java.util.Arrays;
import java.util.Comparator;
/*
	원래 Human의 정렬기준이 아닌 다른 기준을 제시
*/
class HumanComparator implements Comparator<Human> {
	/*
		java.util.Comparator<T>
		
		c.compare(a:T, b:T) : int
		
		- 오름차순
		a > b : 양수
		a < b : 음수
		a == b : 0
	*/
	@Override
	public int compare(Human h1, Human h2) {
		// 이름으로 정렬
		return h1.getName().compareTo(h2.getName());
	}
}
class SortEx2 {
	/*
		? : Object
		<? extends T> : T의 하위 타입(is-a) 객체
		<? super T> : T의 상위타입(is-a) 객체
	*/
	public static void main(String[] args)	{
		Human[] arr = {
			new Human(20, "E"),		// 0
			new Human(23, "B"),		// 1
			new Human(22, "C"),		// 2
			new Human(21, "D"),		// 3
			new Human(24, "A")		// 4
		};

		HumanComparator cmp = new HumanComparator();
		// 부분정렬
		// Arrays.sort(arr,0, 3, cmp);
		Arrays.sort(arr, cmp);
		System.out.println(Arrays.toString(arr));

		int idx = Arrays.binarySearch(arr, new Human("D"), cmp);
		System.out.println(idx);
	}
}
