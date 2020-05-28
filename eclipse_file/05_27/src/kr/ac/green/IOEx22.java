package kr.ac.green;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * Byte - Input (읽기(입력))  - InputStream
 * 		- Output(쓰기(출력))  - OutputStream 
 * 
 * Char - Input (읽기(입력))  - Reader
 * 		- Output(쓰기(출력))  - Writer
 */
public class IOEx22 {
		public static void main(String[] args) {
		
		InputStream is = System.in;
		//키보드 입력을 받을 수 있다.
		InputStreamReader isr = null;
		//byte -> char로 읽기 위해서는 
		//InputStreamReader를 사용해야하기 때문에 null로 초기화 
		BufferedReader br = null;
		//미리 내부적으로 저장소를 만들어놔서 오기 위하여 BufferedReader를 사용
		
		try {
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String line = null;
			
			while ( (line = br.readLine()) != null ) {
				System.out.println(line);
			}
			int data = -1;
			while( (data = isr.read()) != -1) {
				System.out.println((char)data); //엔터치면 한글자씩 읽음 (단점);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(isr);
		}
	}
}
