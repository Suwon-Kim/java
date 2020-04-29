class ExceptionEx4 {

	public static void makeException(int[] arr) {
		try {
			System.out.println(arr[10]);
		// JDK1.7~
		// 여러 예외들에 대해 동일한 작업을 수행하는 경우
		} catch(NullPointerException | ArrayIndexOutOfBoundsException e) {
			System.out.println("예외발생");
		} 
	}

	public static void main(String[] args)	{
		makeException(new int[]{1,2,3,4});
		makeException(null);
	}
}
