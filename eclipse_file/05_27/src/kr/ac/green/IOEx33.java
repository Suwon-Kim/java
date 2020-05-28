package kr.ac.green;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.MalformedInputException;
/*
 * Byte - Input (읽기(입력))  - InputStream
 * 		- Output(쓰기(출력))  - OutputStream 
 * 
 * Char - Input (읽기(입력))  - Reader
 * 		- Output(쓰기(출력))  - Writer
 */
public class IOEx33 {
	public static void consoleToFile(String fileName) {
		 
		InputStream is = null;
		//byte : Input(읽기(입력))
		InputStreamReader isr = null;
		//char를 읽을 때 
		BufferedReader br = null;
		//한줄씩 읽을 때 
		FileWriter fw = null;
		//파일에 쓰는놈
		PrintWriter pw = null;
		//줄단위로 쓰는놈
		try {
			is = System.in;
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			fw = new FileWriter("console.txt");
			pw = new PrintWriter(fw);
			
			String line = null;
			
			while( (line = br.readLine()) != null) {
				pw.println(line);
			}
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(pw, fw, br, isr, is);
		}
		
	}
	public static void main(String[] args) {
		consoleToFile("console.txt");
	}
}
