package kr.ac.green;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOEx2 {
	public static void main(String[] args) {
		InputStream is = System.in;
		InputStreamReader isr = null;
		//InputStream을 (Reader)byte 읽기 -> char 읽기
		//한글이 입력 가능해짐
		BufferedReader br = null;
		//BuffedReader --> 미리 내부적으로 저장소를 만들어놔서 한줄씩 끊어서 읽어올 수 있다.
		//한글자씩 했을때는 배열로 사용했지만 여기서는 BufferedReader를 사용하였다.

		try {
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String line = null;
			while( (line = br.readLine()) != null ) {
			//readLine 한줄을 읽어와라
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
