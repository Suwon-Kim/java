/*
	- 오버라이드
		What은 동일하다. How가 달라지는 경우 하위클래스에서
		메서드를 다시 정의 하는 경우
	- 규칙
		메서드 이름, 파라미터 정보, 리턴 동일
		접근제한자는 더 좁아질 수 없다.
		(private < 생략 < protected < public)

		오버로딩						오버라이딩
		1. 단일 클래스					1. 상속전제
		2. 물리적으로 다른메서드 정의	2. 물리적으로 동일한 메서드 정의
*/
class Father {
	// what : 밥을 먹는다. 
	void eat() {
		// how : 오른손 잡이다.
		System.out.println("오른손으로 냠냠");
	}
	public void todo(int n, String str, char c, long l, boolean flag, double d) {
	}
}

class Son extends Father {
	@Override
	protected void eat() {
		System.out.println("왼손으로 냠냠");
	}
	// Annotation(JDK1.5~)
	// 아래 메서드가 제대로 오버라이드 되었는지 컴파일 타임에 체크하라.
	/*
	@Override
	public void todo(int n, String str, char c, long l,  double d, boolean flag) {
	}
	*/
}
class Ex2 {
	public static void main(String[] args) {
		Son s = new Son();
		s.eat();
	}
}
