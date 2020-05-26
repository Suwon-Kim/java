package kr.ac.green;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Quiz {
	//파일을 복사하는 코드를 만들고 테스트 하라.
	//	src : 원본
	//	copy : 복사본
	// 복사본 파일 이름은 *_copy.* 라고 붙인다.
	// ex) a.txt -> a_copy.txt
	
	public static void copy(File src) {
//		FileInputStream fis = null;
//		FileOutputStream fos = null;
//		try {
//			fis = new FileInputStream(src);
//			fos = new FileOutputStream("apple_copy.jpg");	//이거는 무조건 apple_copy.jpg 이름만 되지만 (고정적)
//			int data = -1;
//			while( (data = fis.read()) != -1) {
//				fos.write(data);
//			}
//		} catch(FileNotFoundException e) {
//			
//		} catch(IOException e) {
//			
//		} finally {
//			try {
//				fis.close();
//				fos.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	src = src.getAbsoluteFile();						// copy 앞의 이름을 얼마든지 바꿀 수 있는 이름이 된다 (유동적)	
	String path = src.getPath();
	int idx = path.lastIndexOf(".");
	path.substring(idx); //.jpg
	String ext = path.substring(idx);
	String name = path.substring(0,idx) + "_copy";
	File copy = new File(name + ext); 
								
	FileInputStream fis = null;	 //null 주면 에러가 생긴다. try가 실행을 보장하는 블록이 아니다. 
	FileOutputStream fos = null;
	
	try {
		fis = new FileInputStream(src);
		fos = new FileOutputStream(copy);	//파일에 쓸 때는 파일이 실제로 존재하는지 안하는지 체크를 해야한다.
		
		int data = -1;
		while( (data = fis.read()) != -1 ) {
			fos.write(data);
		}
	} catch(IOException e) {
		e.printStackTrace();
	} finally {
		try {
			fis.close();
		} catch(Exception e) {}
		try {
			fos.close();
		} catch (Exception e) {}
	}
	
	}
	// (getAbsoluteFile)로 경로를 받아오지 않고 그냥 써버리면  apple.jpg가 내가 넣은곳에서 apple.jpg 파일이 있는 곳에 복사가 되는데
	// getAbsoluteFile를 사용하면 절대경로로 받아 오기 때문에 apple.jpg가 어디에 있는지 알지 않아도 복사를 할 수 있다.
	public static void main(String[] args) {
		copy(new File("apple.jpg"));	
	}
}
