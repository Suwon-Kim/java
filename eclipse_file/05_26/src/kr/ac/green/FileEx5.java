package kr.ac.green;

import java.io.File;
import java.io.IOException;

public class FileEx5 {
	public static void main(String[] args) {
		
		File f = new File("c:\\study\\a.txt");
		
		try {
			f.createNewFile();
			
			System.out.println(f.getParent()); 	// ��θ� ����ϴ°� 
			System.out.println(f.getName());	// ������ ������ �̸�
			System.out.println(f.getPath());	// ��� + ���� ��ģ��
			System.out.println(f.length());		//  ũ��,���� ������ : byte
			System.out.println(f.lastModified());	// ������ �����ð� : long Ÿ���� �˾� ���� ����� ������ �����Ѵ�. 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}




