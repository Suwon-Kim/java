package kr.ac.green;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * byte : �Ϲ����� ����
 * char : �а� ���� �����Ͱ� ������ �ؽ�Ʈ �������̸�, 
 * 			��� �ƴ� �� ���°��
 */
//�ѱ��� �ȱ����� ^^
public class CharIO {
	public static void writeToFile() {
		FileWriter fw = null;		
		try {
			fw = new FileWriter("data.txt");
			fw.write("����~");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(fw);
		}
		
	}
	public static void readFromFile() {
		FileReader fr = null;
		
		try {
			fr = new FileReader("data.txt");
			int data = -1; // char (int��� �Ǿ� ������ char�̴�)
			while( (data = fr.read()) != -1 ) {
				System.out.print(data);
//				System.out.print((char)data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(fr);
		}
	}
	public static void main(String[] args) {
		writeToFile();
		readFromFile();
	}
}