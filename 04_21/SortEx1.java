/*
	Arrays
		-> 배열로 할 수 있는 연산들의 모음(static)
	정렬
		1. 오름차순
		2. 내림차순
*/
import java.util.Arrays;

class SortEx1 {
	public static void main(String[] args)	{
		int[] arr = {4, 1, 6, 9, 3, 7};

		// 굉장히 빠르다..
		Arrays.sort(arr);

		String str = Arrays.toString(arr);
		System.out.println(str);
	}
}
