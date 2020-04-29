/*
	추상클래스
		1. 멤버변수
		2. 일반메서드
		3. 생성자
		4. 추상메서드 => 객체생성 불가능함 => 하위클래스가 존재해야함
*/
abstract class Animal {
	// 소리낸다 : 추상메서드
	/*
		어떤일을 해야하는지는 정의 할 수 있으나
		어떻게 해야하는지를 정의 할 수 없는경우
		(하위 개념에서 정의가 가능한 경우)
	*/
	public Animal() {
		
	}


	public abstract void sound();

	public String toString() {
		return "Animal";

	}
}
/*
	추상클래스를 상속받는 클래스는 반드시
	부모클래스의 추상메서드를 오버라이드해야한다.
*/
class Dog extends Animal {
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}
// Dog과Cat의 sound는 다르게 구현된다. -> Animal에서 정의(how) 불가능함.
class Cat extends Animal {
	@Override
	public void sound() {
		System.out.println("야옹~");
	}
}
class AbstractClassEx1 {
	public static void main(String[] args) {
				
	}
}
