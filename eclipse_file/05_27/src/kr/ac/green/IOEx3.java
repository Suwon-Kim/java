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
		// �д³�
		FileWriter fw = null;
		PrintWriter pw = null;
		// ���³�
		try {
			is = System.in;
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			//���� ����
			//is ���Ͱ� �ƴ�
			//isr, br (ȥ�� �� �� ����) -- > ������  (�����ڸ� ���� �����Ѵ�)
			//pw ���� 
			//fw�� ���Ͱ� �ƴ�
			//Ű���带 ���Ϸ� �����ϴ� ���α׷����� 
			//Stream�� �����ڰ� �߿��� s 
			fw = new FileWriter(fileName);
			pw = new PrintWriter(fw);
			
			String line = null;
			
			while( !(line = br.readLine()).equals("exit")) {
				pw.println(line);
			}
			//���� ������ ���� ������ ������ �ʴ´�.
			//���۴� �ȿ� ������ ������ 
			//Collectin�̶� io�� ������ �ؾ��Ѵ�...
			pw.flush(); //�������� �ʿ���µ� write(����)
			//���۰� ���� �ʾƵ� flush�� ����ϸ� ������ ������ ����� �����ش� . (����� �������ش�) 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// �ڿ����� : ������ �������� �ݴ´�. (�������� ���³��� ���� �������Ѵ�.)
			MyUtils.closeAll(pw, fw, br, isr, is);
		}
	}
	public static void main(String[] args) {
		consoleToFile("console.txt");
	}
}
