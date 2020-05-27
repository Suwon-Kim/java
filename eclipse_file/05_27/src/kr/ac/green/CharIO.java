package kr.ac.green;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * byte : 일반적인 파일
 * char : 읽고 쓰는 데이터가 순수한 텍스트 데이터이며, 
 * 			영어가 아닌 언어를 쓰는경우
 */
//한글이 안깨진다 ^^
public class CharIO {
	public static void writeToFile() {
		FileWriter fw = null;		
		try {
			fw = new FileWriter("data.txt");
			fw.write("하이~");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(fw);
		}
		
	}
	public static void readFromFile() {
		FileReader fr = null;
		
		try {
			fr = new FileReader("data.txt");
			int data = -1; // char (int라고 되어 있지만 char이다)
			while( (data = fr.read()) != -1 ) {
				System.out.print(data);
//				System.out.print((char)data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(fr);
		}
	}
	public static void main(String[] args) {
		writeToFile();
		readFromFile();
	}
}
