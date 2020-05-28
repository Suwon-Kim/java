package kr.ac.green;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.MalformedInputException;
/*
 * Byte - Input (�б�(�Է�))  - InputStream
 * 		- Output(����(���))  - OutputStream 
 * 
 * Char - Input (�б�(�Է�))  - Reader
 * 		- Output(����(���))  - Writer
 */
public class IOEx33 {
	public static void consoleToFile(String fileName) {
		 
		InputStream is = null;
		//byte : Input(�б�(�Է�))
		InputStreamReader isr = null;
		//char�� ���� �� 
		BufferedReader br = null;
		//���پ� ���� �� 
		FileWriter fw = null;
		//���Ͽ� ���³�
		PrintWriter pw = null;
		//�ٴ����� ���³�
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