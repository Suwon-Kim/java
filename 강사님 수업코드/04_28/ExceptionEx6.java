class ExceptionEx6 {
	public static void main(String[] args)	{
		// 예외처리 한게 아님.
		try {
			// A
			String str = null;
			System.out.println(str.length());
		} finally {
			// B
			System.out.println("bye~");
		}
		System.out.println("end of main");
	}
}
