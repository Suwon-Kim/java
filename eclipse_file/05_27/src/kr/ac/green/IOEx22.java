package kr.ac.green;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * Byte - Input (�б�(�Է�))  - InputStream
 * 		- Output(����(���))  - OutputStream 
 * 
 * Char - Input (�б�(�Է�))  - Reader
 * 		- Output(����(���))  - Writer
 */
public class IOEx22 {
		public static void main(String[] args) {
		
		InputStream is = System.in;
		//Ű���� �Է��� ���� �� �ִ�.
		InputStreamReader isr = null;
		//byte -> char�� �б� ���ؼ��� 
		//InputStreamReader�� ����ؾ��ϱ� ������ null�� �ʱ�ȭ 
		BufferedReader br = null;
		//�̸� ���������� ����Ҹ� �������� ���� ���Ͽ� BufferedReader�� ���
		
		try {
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String line = null;
			
			while ( (line = br.readLine()) != null ) {
				System.out.println(line);
			}
			int data = -1;
			while( (data = isr.read()) != -1) {
				System.out.println((char)data); //����ġ�� �ѱ��ھ� ���� (����);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(isr);
		}
	}
}
