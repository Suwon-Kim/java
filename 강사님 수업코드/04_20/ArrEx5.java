class ArrEx5 {
	public static void main(String[] args)	{
		// { {0, 0}, {0, 0}, {0, 0} }
		int[][] arr = new int[3][2];
		ArrEx2.printAll(arr);
		//arr[0][2] = 100;

			
		// { {100, 1000, 1000}, {0, 0}, {0, 0} }
		arr[0] = new int[] {100, 1000, 1000};
		arr[1] = new int[] {1, 2, 3, 4, 5, 6};

		ArrEx2.printAll(arr);
	}
}






















