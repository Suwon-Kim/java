/*
	int[][][][][][][][][][][][][][] arr = 
		new int[5][][][][][][][][][][][][][];

	{ {0,0,0}, {0,0,0} } 
*/


class ArrEx4 {
	public static void main(String[] args)	{
		// { null, null, null}
		// 원소배열의 길이가 모두 같을 필요는 없다.
		int[][] arr = new int[3][];
		arr[0] = new int[] {1,2,3};
		arr[1] = new int[] {4, 5};
		arr[2] = new int[] {7,8,9,10};
		
		// { {1,2,3}, {4, 5}, {7,8,9,10} }

		for(int[] temp : arr) {
			for(int n : temp) {
				System.out.println(n);
			}
		}
	}
}
