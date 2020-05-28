package kr.ac.green;

import java.io.IOException;
import java.io.InputStream;

/*
 * Byte - Input (읽기(입력))  - InputStream
 * 		- Output(쓰기(출력))  - OutputStream 
 * 
 * Char - Input (읽기(입력))  - Reader
 * 		- Output(쓰기(출력))  - Writer
 */
public class IOEx11 {
	public static void main(String[] args) {
		InputStream is = System.in;
		//System.in(InputStream형태로 지정되어 있음)(키보드 입력을 받을 수 있다)
		
		try {
			int data = -1;
			while ( (data = is.read()) != -1)  {
			//키보드로 읽는 내용을 data에 저장하는데 -1이 아닐때까지 반복
				System.out.println((char)data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of main");
	}
}
