class ArrayEx1 {
	public static void main(String[] args) {
			int[] arr = {1, 5, 7, 9, 3};
			
			for(int i=0; i<arr.length; i++) {
				System.out.println(arr[i]);
			}		
			
			// JDK1.5
			for(int n : arr) {
				System.out.println(n);
			}
	}
}
