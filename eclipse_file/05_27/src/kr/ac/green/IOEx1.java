package kr.ac.green;

import java.io.IOException;
import java.io.InputStream;

public class IOEx1 {
	public static void main(String[] args) {
		/*
		 * 키보드 입력을 읽어 보자. 
		 */
		//한글이 안됨 이거는
		InputStream is = System.in; 
		// 키보드를 입력 할 수 있는 InputStream이 이미 만들어져 있음
		// enter : \r + \n (글자를 2개 잡아먹음)
		//97,98,99 --> a,b,c 13,10 --> enter
		try {
			int data = -1;
			// ctrl + z : -1
			while( (data = is.read()) != -1) {
				System.out.println("읽은 내용 : " + (char)data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of main");
	}
}
