/*
	인터페이스
		- 추상메서드 : 객체생성 불가능 -> 구현체(일반클래스)
		- 상수
		- 접근제한자 : public
*/
interface ISome {
	// public static final int NUM = 10;
	int NUM = 10;		// 패키지접근제한자 아님...!!!

	// public abstract void todo();
	void todo();
}
// 추상메서드 오버라이드 의무를 가짐.
class Some implements ISome {
	@Override
	public void todo() {}
}
abstract class Other implements ISome {
}
class InterfaceEx1 {
	public static void main(String[] args) {

	}
}
