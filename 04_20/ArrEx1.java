class ArrEx1 {
	public static void change(int[] temp) {
		temp[0] = 100;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		change(arr);
		System.out.println(arr[0]);
	}
}