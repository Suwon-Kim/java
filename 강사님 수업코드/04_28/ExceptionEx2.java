class ExceptionEx2 {

	public static int stringToInt(String strNum) {
		/*
			변환이 불가능 한 경우 0을 리턴한다.
		*/
		int num = 0;
		try {
			// 실행을 보장하지 않음
			num = Integer.parseInt(strNum);
		} catch(NumberFormatException e) {
			// 실행을 보장하지 않음
			System.out.println(strNum + "는 int로 변환이 불가능합니다.");
			// e.printStackTrace();		// 디버깅용
			// 메세지가 존재하지 않는 예외도 있음.
			String msg = e.getMessage();
			System.out.println(msg);
		}
		return num;
	}
	public static void main(String[] args)	{
		int result = stringToInt("123");
		System.out.println(result);
		result = stringToInt("abc");
		System.out.println(result);
	}
}
