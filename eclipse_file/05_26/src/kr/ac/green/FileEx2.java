package kr.ac.green;

import java.io.File;
import java.io.IOException;

public class FileEx2 {
	
		// �����ϸ� ��������� �ٽ� �����ǰ� ��������� �����ǰ�
	public static void main(String[] args) {
		// ������ �����ϱ� ���ؼ��� �ش� ��ΰ� ���������� �����ؾ� �Ѵ�.
		// �� ��ǻ�Ϳ��� f ������ ����. (������ ����) �ڵ�󿡸� �ִ�.
		// exists : ��ũ ���� ���� ���� Ȯ�� 
		// true : �������� ����
		// false : ������ ����
		
		File dir = new File("c:\\study"); // << ��� ���� ���丮��
		
		if(!dir.exists()) {
			//��λ���  (��ũ ���� ������ ��Ƹ��� �ʴ´�)
			dir.mkdir();
		}
		File f = new File(dir, "a.txt");
		
		if(f.exists()) {
			//����
			f.delete(); 
			//��� ����
			dir.delete();
		} else {
			try {
				// ������ ���� ���� (��ũ ���� ������ ��ƸԴ´�)
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		};
		
	}
}
