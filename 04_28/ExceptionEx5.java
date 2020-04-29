class ExceptionEx5 {
	
	public static int[] makeArray(int length) {
		int[] arr = null;
		try {
			// 실행 보장X
			arr = new int[length];
		} catch(NullPointerException | ArrayIndexOutOfBoundsException e) {
			// 실행 보장X
			e.printStackTrace();
		} finally {
			// 실행 보장	
			// 외부자원과 관련된 연산이 주로 위치한다.
			// 예외발생 여부와 관계없이 수행된다.
			System.out.println("done");
		}
		
		return arr;
	}

	public static void main(String[] args)	{
		makeArray(3);
		makeArray(-3);
		System.out.println("end of main");
	}
}
