/*
	실행 중 오류 -> 예외(Exception)

	- 예외처리
		-> 예외가 발생하면 뭘 해야하는지 알려준다.
*/
class ExceptionEx1 {

	public static void divide(int num1, int num2) {
		try {
			// 예외발생 가능성이 있느 연산
			int result = num1 / num2;
			System.out.println(result);
		} catch(ArithmeticException e) {
			// ArithmeticException 예외가 발생하면 할 일
			System.out.println("0으로 나눌수 없습니다.");
		}		
	}

	public static void main(String[] args)	{
		divide(8, 2);
		divide(8, 0);
		System.out.println("end of main");
	}
}




















