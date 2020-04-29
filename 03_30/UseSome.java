/*
	일반적인 클래스 : 생략, public
	멤버변수, 메서드 : private, 생략, protected, public
*/
class Some {
	public void printNum() {
		System.out.println(num);
	}

	private int num = 4;
}
class UseSome {
	public static void main(String[] args) {
		Some s = new Some();
		//System.out.println(s.num);
		s.printNum();
	}
}
