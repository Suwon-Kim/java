package kr.ac.green;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOEx2 {
	public static void main(String[] args) {
		InputStream is = System.in;
		InputStreamReader isr = null;
		//InputStream�� (Reader)byte �б� -> char �б�
		//�ѱ��� �Է� ��������
		BufferedReader br = null;
		//BuffedReader --> �̸� ���������� ����Ҹ� �������� ���پ� ��� �о�� �� �ִ�.
		//�ѱ��ھ� �������� �迭�� ��������� ���⼭�� BufferedReader�� ����Ͽ���.

		try {
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String line = null;
			while( (line = br.readLine()) != null ) {
			//readLine ������ �о�Ͷ�
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
