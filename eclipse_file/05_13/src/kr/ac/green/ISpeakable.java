package kr.ac.green;

/*
 * 람다식지원을 위해 JDK1.8부터 사용
 * 람다식의 대상 -> FunctionalInterface만 사용가능
 */
@FunctionalInterface // 추상메소드 한개인지 아닌지를 검사
public interface ISpeakable {
	void speak();	
}
