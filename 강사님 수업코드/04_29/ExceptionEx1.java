/*
	예외처리
	1. try-catch : 예외상황을 직접처리
	2. throws : 예외처리 책임을 호출한 쪽으로 전가
*/
import java.io.*;
class ExceptionEx1 {
	public static void first() throws FileNotFoundException {
		second();
	}
	public static void second() throws FileNotFoundException {
		FileReader fr = new FileReader("a.txt");
	}
	// 이런 코드는 없다.
	public static void main(String[] args) {
		try {
			first();		
		} catch(FileNotFoundException e) {
		
		}
	}
}