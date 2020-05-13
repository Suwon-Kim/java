package kr.ac.green;
/*
 * interface ( ~ 1.7)
 * -> ��� (static final)
 * -> �߻�޼ҵ� (abstract)
 * 
 * interface(1.8 ~)
 * -> static �޼ҵ�
 * -> default �޼ҵ�
 */
@FunctionalInterface // void todo()�� ������ ���� 
public interface IA {
	void todo();
	
	static void print() {
		System.out.println("Hello");
	}
	// �⺻ ����
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
	@Override //������ �������̵� �ؾߵ� IA,IC �Ѵ� ��� �̽鼭
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
