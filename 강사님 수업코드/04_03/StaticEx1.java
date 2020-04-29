/*
	static
		- 객체와 아무 관련이 없다.(메서드, 변수)
		- 메모리에 시작과 동시에 올라간다.(부정확함...여튼 이렇게 알고있어라~)
		- 시작과 동시에 바로 사용할 수 있다.
		- 어떤 클래스에 존재해도 아무런 문제가 없다.(ex: main)
		- 객체지향 개념으로 설명 할 수 없다.
		- 전역변수, 함수의 표현 도구로 사용된다.
*/



class Stone {
	static void think() {
	}
}
class StaticEx1 {
	static int other = 100;
	int num = 3;

	static void todo() {
		System.out.println("todo");
	}

	public static void main(String[] args) {
		System.out.println(other);
		todo();
	}
}
