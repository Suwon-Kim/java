class ArrEx3 {
	public static void main(String[] args)	{
		Object[] arr = new Object[3];
		arr[0] = "abc";
		arr[1] = new int[] {1,2,3};
		arr[2] = new int[][] { {1,2,3}, {4,5,6} };

		String str = (String)arr[0];
		System.out.println(str);

		int[] arr1 = (int[])arr[1];
		for(int n : arr1) {
			System.out.println(n);
		}

		int[][] arr2 = (int[][])arr[2];
		for(int[] temp : arr2) {
			for(int n : temp) {
				System.out.println(n);
			}
		}
	}
}
