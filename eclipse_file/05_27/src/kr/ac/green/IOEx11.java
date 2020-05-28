package kr.ac.green;

import java.io.IOException;
import java.io.InputStream;

/*
 * Byte - Input (�б�(�Է�))  - InputStream
 * 		- Output(����(���))  - OutputStream 
 * 
 * Char - Input (�б�(�Է�))  - Reader
 * 		- Output(����(���))  - Writer
 */
public class IOEx11 {
	public static void main(String[] args) {
		InputStream is = System.in;
		//System.in(InputStream���·� �����Ǿ� ����)(Ű���� �Է��� ���� �� �ִ�)
		
		try {
			int data = -1;
			while ( (data = is.read()) != -1)  {
			//Ű����� �д� ������ data�� �����ϴµ� -1�� �ƴҶ����� �ݺ�
				System.out.println((char)data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of main");
	}
}
