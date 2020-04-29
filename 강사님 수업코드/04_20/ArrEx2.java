class ArrEx2 {
	public static void printAll(int[][] temp) {
		for(int[] subArr : temp) {
			for(int n : subArr) {
				System.out.println(n);
			}
		}
		/*
		for(int i=0; i<temp.length; i++) {
			// i : 0, 1
			for(int j=0; j<temp[i].length; j++) {
				// j : 0, 1, 2
				System.out.println(temp[i][j]);
			}
		}
		*/
	}
	public static void main(String[] args)	{
		int[][] arr = { {3,5,7}, {2,4,6} };
		printAll(arr);
	}
}
