package kr.ac.green;
/*
 * interface ( ~ 1.7)
 * -> 상수 (static final)
 * -> 추상메소드 (abstract)
 * 
 * interface(1.8 ~)
 * -> static 메소드
 * -> default 메소드
 */
@FunctionalInterface // void todo()가 없으면 오류 
public interface IA {
	void todo();
	
	static void print() {
		System.out.println("Hello");
	}
	// 기본 동작
	default void methodA() {
		System.out.println("A");
	}
	default void methodB() {
		System.out.println("A");
	}
}
interface IC {
	default void methodA() {
		System.out.println("IC8");
	}
}
class B implements IA, IC {
	@Override
	public void todo() {
		
	}
	@Override //무조건 오버라이드 해야됨 IA,IC 둘다 들고 이썽서
	public void methodA() {
		//IA.super.methodA();
		//IC.super.methodA();
	}
	
}

class Another {
	public void doit() {
		B b = new B();
		b.methodA();
	}
}
