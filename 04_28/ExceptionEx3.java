class ExceptionEx3 {

	public static void makeException(int[] arr) {
		try {
			System.out.println(arr[10]);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 범위를 벗어났어요.");
		} catch(NullPointerException e) {
			System.out.println("null을 참조할 수 없습니다.");
		}
	}

	public static void main(String[] args)	{
		makeException(new int[]{1,2,3,4});
		makeException(null);
	}
}
