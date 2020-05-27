package kr.ac.green;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 	stream 	- 1. byte
 * 					a. 	I : InputStream
 * 					b.	O : OutputStream
 * 			- 2. char
 * 					a. 	I : Reader
 * 					b.  O : Writer
 */
public class IOEx1 {
	// ���Ͽ� ����(byte)
	public static void utilJDK6() {
		// ~JDK1.6
		FileOutputStream fos = null;		
		try {
			// appendable -> true �̾� ����
//			fos = new FileOutputStream("c:\\study\\a.txt", true);
			fos = new FileOutputStream("c:\\study\\a.txt", true);
			//true�϶��� ��� appendable �̾�⸦ �Ѵ�. 
			//���� �� 3�� �����ϸ� hello�� 3�� �̾ ��µ�
			//�⺻���� false�̴�.
			// byte < char < int
			fos.write('h');
			fos.write('e');
			fos.write('l');
			fos.write('l');
			fos.write('o');			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();				
			} catch (Exception e) {}	//�ܺ��ڿ��� ����ϸ� �ݵ�� �ڿ������� �������
		}
	}
	// ���Ͽ� �б� (byte)
	public static void afterJDK7() {
		// JDK1.7~ (AutoCloseable)				
		try( FileInputStream fis = new FileInputStream("c:\\study\\a.txt") ) {
			int data = -1;
			while((data = fis.read()) != -1) {
				System.out.println((char)data);
			}
//			boolean flag = true;
//			while(flag) {
//				data = fos.read();
//				// E.O.F -- > End of file�� ������  ������ ���̻� ���ٴ°��� (-1)�� ������
//				if(data == -1) {
//					flag = false;
//				} else {
//					System.out.println((char)data);
//				}
//			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public static void main(String[] args) {
		// utilJDK6();
		afterJDK7();
	}
}