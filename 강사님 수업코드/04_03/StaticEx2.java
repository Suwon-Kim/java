/*
	static 사용법
	클래스명.대상
*/
class Other {
	public static int num = 5;
}
class StaticEx2 {	
	public static int num = 100;

	public static void main(String[] args) {
		System.out.println(Other.num);
		System.out.println(StaticEx2.num);
	}
}
