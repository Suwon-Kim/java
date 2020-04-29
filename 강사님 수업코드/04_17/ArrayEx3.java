class ArrayEx3 {

	public static void print(int n, int m) {
		/* .... */
	}
	public static void print(int[] arr) {
		for(int n : arr) {
			System.out.println(n);
		}
	}
	// JDK1.5~
	// 가변길이 인자 : variable length arguments
	// VALARG
	/*
		1. 메서드당 1개만 사용할 수 있다.

		2. 일반파라미터와 함께 쓸 수 있다.
			-> 일반 파라미터는 생략할 수 없다.
			-> 가변길이 인자는 마지막에 존재해야한다.
	*/
	public static void newPrint(int... nums) {
		print(nums);
	}
	public static void todo(String str, int... nums) {
		
	}
	public static void main(String[] args)	{
		todo("a");
		todo("a", 1,2,3,4,5,6,7,8);


		/*
		int[] arr = {1,2,3};
		print(arr);

		newPrint();
		newPrint(1,2,3);
		newPrint(new int[]{1,2,3,4,5});
		*/
	}
}
