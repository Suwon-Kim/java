class Some {
	/*
		클래스 내부에 생성자를 정의하지 않은경우
		-> 컴파일러가 생성자를 추가해준다.(기본생성자)
	*/
	public Some(int n) {
	}
}
class UseSome {
	public static void main(String[] args) {
		/*
			객체생성 : new + 생성자호출
		*/
		Some s = new Some(9);
	}
}
