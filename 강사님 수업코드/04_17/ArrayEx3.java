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
	// �������� ���� : variable length arguments
	// VALARG
	/*
		1. �޼���� 1���� ����� �� �ִ�.

		2. �Ϲ��Ķ���Ϳ� �Բ� �� �� �ִ�.
			-> �Ϲ� �Ķ���ʹ� ������ �� ����.
			-> �������� ���ڴ� �������� �����ؾ��Ѵ�.
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
