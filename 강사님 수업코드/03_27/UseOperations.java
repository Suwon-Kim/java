/*
	입력값 : parameter(갯수 제한 없음)
	출력값 : return
			갯수 :	0(void)
					or 
					1(type)
*/
class Operations {
	// 파라미터로 정수1개를 받고 2를 더한 후 결과를 리턴
	// header
	int plus2(int num) {
		// body			
		int result = num + 2;
		// result를 돌려준다.
		// return은 메서드가 종료(끝)된다는 의미를 가진다.
		return result;
	}

	// 정수둘을 입력받아 그 합을 콘솔에 출력하는 메서드를 작성하시오
	void printSum(int num1, int num2) {
		int result = num1 + num2;
		System.out.println("합 :" + result);
		
	}
	
}
class UseOperations {
	public static void main(String[] args) {
		// 객체생성 -> 멤버변수, 메서드를 메모리에 올린다.
		Operations o = new Operations();
		// int plus2(int num1) { ... }
		o.plus2(100);
		int opResult = o.plus2(10);
		System.out.println(opResult);
		System.out.println(o.plus2(8));

		o.printSum(100, 20);
		o.printSum(5, 4);
		o.printSum(14, 7);

	}
}
