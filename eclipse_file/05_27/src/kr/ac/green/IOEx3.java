package kr.ac.green;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IOEx3 {
	public static void consoleToFile(String fileName) {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		// 읽는놈
		FileWriter fw = null;
		PrintWriter pw = null;
		// 쓰는놈
		try {
			is = System.in;
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			//사진 참고
			//is 필터가 아님
			//isr, br (혼자 살 수 없다) -- > 필터임  (생성자를 보고 구분한다)
			//pw 필터 
			//fw는 필터가 아님
			//키보드를 파일로 저장하는 프로그램에서 
			//Stream은 생성자가 중요함 s 
			fw = new FileWriter(fileName);
			pw = new PrintWriter(fw);
			
			String line = null;
			
			while( !(line = br.readLine()).equals("exit")) {
				pw.println(line);
			}
			//버퍼 내용이 차지 않으면 나오지 않는다.
			//버퍼는 안에 내용이 차야지 
			//Collectin이랑 io는 무조건 해야한다...
			pw.flush(); //읽을때는 필요없는데 write(쓸때)
			//버퍼가 차지 않아도 flush를 사용하면 버퍼의 내용을 비워서 꺼내준다 . (출력을 보장해준다) 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 자원해제 : 생성된 역순으로 닫는다. (마지막에 나온놈이 먼저 닫혀야한다.)
			MyUtils.closeAll(pw, fw, br, isr, is);
		}
	}
	public static void main(String[] args) {
		consoleToFile("console.txt");
	}
}
