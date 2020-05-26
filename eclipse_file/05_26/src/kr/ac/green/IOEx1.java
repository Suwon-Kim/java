package kr.ac.green;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 	stream 	- 1. byte
 * 					a. 	I : InputStream
 * 					b.	O : OutputStream
 * 			- 2. char
 * 					a. 	I : Reader
 * 					b.  O : Writer
 */
public class IOEx1 {
	// 파일에 쓰기(byte)
	public static void utilJDK6() {
		// ~JDK1.6
		FileOutputStream fos = null;		
		try {
			// appendable -> true 이어 쓰기
//			fos = new FileOutputStream("c:\\study\\a.txt", true);
			fos = new FileOutputStream("c:\\study\\a.txt", true);
			//true일때는 계속 appendable 이어쓰기를 한다. 
			//예를 들어서 3번 실행하면 hello가 3번 이어서 출력됨
			//기본값은 false이다.
			// byte < char < int
			fos.write('h');
			fos.write('e');
			fos.write('l');
			fos.write('l');
			fos.write('o');			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();				
			} catch (Exception e) {}	//외부자원을 사용하면 반드시 자원해제를 해줘야함
		}
	}
	// 파일에 읽기 (byte)
	public static void afterJDK7() {
		// JDK1.7~ (AutoCloseable)				
		try( FileInputStream fis = new FileInputStream("c:\\study\\a.txt") ) {
			int data = -1;
			while((data = fis.read()) != -1) {
				System.out.println((char)data);
			}
//			boolean flag = true;
//			while(flag) {
//				data = fos.read();
//				// E.O.F -- > End of file을 만나면  읽을게 더이상 없다는거임 (-1)을 리턴함
//				if(data == -1) {
//					flag = false;
//				} else {
//					System.out.println((char)data);
//				}
//			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public static void main(String[] args) {
		// utilJDK6();
		afterJDK7();
	}
}
