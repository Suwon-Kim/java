class ExceptionEx7 {
	public static void main(String[] args)	{
		/*
			try-catch-finally 는 서로 중첩이 가능하다.

		*/
		try {
			// A
		} catch(B) {
			try {
				// C
			} catch(D) {
				// E
			}
		} finally {
			try {
				// F
			} catch(G) {
				// H
			} finally {
				// I
			}
		}
	}
}
