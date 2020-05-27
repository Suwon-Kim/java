package kr.ac.green;

import java.io.IOException;
import java.io.InputStream;

public class IOEx1 {
	public static void main(String[] args) {
		/*
		 * Ű���� �Է��� �о� ����. 
		 */
		//�ѱ��� �ȵ� �̰Ŵ�
		InputStream is = System.in; 
		// Ű���带 �Է� �� �� �ִ� InputStream�� �̹� ������� ����
		// enter : \r + \n (���ڸ� 2�� ��Ƹ���)
		//97,98,99 --> a,b,c 13,10 --> enter
		try {
			int data = -1;
			// ctrl + z : -1
			while( (data = is.read()) != -1) {
				System.out.println("���� ���� : " + (char)data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of main");
	}
}
