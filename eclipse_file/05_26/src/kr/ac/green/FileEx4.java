package kr.ac.green;

import java.io.File;

public class FileEx4 {
	
	//������ �����϶��� �ǹٸ� ����� �����ش�.
	public static void whatIsThis(File f) {
		if(!f.isFile()) { // ������ �ƴϸ� �� ���丮��
			System.out.println("������ �ƴմϴ�");
		}
		if(!f.isDirectory()) {
			System.out.println("���丮�� �ƴմϴ�.");
		}
	}// f�� �������� ��������� �˾ƾ� �ɶ��� �ִ�.
	public static void main(String[] args) {
		File dir = new File("c:\\study");
		// study�� Ȯ���ڰ� ���� ������ ���� �ְ�, ������ ���� �־ �̰͸� ������ �������� ���丮���� �� �� ����.
		// �� : isFile, isDirectory << ���������� ������ ���� ���� ���������� �������� �������� false�� ������ 
		dir.mkdir(); 
		whatIsThis(dir); // ���ϵ� �ƴϰ� ���丮�� �ƴϴ�.
	}
}
