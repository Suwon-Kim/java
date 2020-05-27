package kr.ac.green;

import java.io.File;
import java.io.IOException;

public class FileEx7 {
	public static void main(String[] args) {

		File f = new File("..\\..\\a.txt"); // ���� ��ġ�� �ִ� a.txt�̴�. (�������)
		// Package ������ �����Ѵ�.
		// �������� �����θ� �����ߴ��� ����θ� �����ߴ��� �𸥴�. 
		// getParent()�� null�� ����
		// null�� ���Դٰ� �ؼ� ��ΰ� ���°� �ƴϴ� ������ ��δ� �ִ�.
		// ����� ǥ������� ����� �տ� ��ΰ� �ִ��� ������ �𸥴�.
		// ������ġ�� �𸥴�.
		System.out.println(f.getParent());	// ��ΰ� ������ ���� �ʾƼ� null�̴�.
		System.out.println(f.getName());
		System.out.println(f.getPath());
		System.out.println("==============================================");
		
//		System.out.println(f.getAbsolutePath()); // ���ڿ��ۿ� �� �� ���� (String)
		File other = f.getAbsoluteFile();	// ���� ���·� �����޴´� (���Ͽ� ������ �ʿ��ϸ�)
		System.out.println(other.getParent());
		System.out.println(other.getName());
		System.out.println(other.getPath());
		System.out.println("==============================================");
		try{
			//�̻� ��� (��θ� �������)
			//��������� ��θ� �����ؾ� �� �� 
//			System.out.println(f.getCanonicalPath());
			File another = f.getCanonicalFile();
			System.out.println(another.getParent());
			System.out.println(another.getName());
			System.out.println(another.getPath());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}

/*
 * 	c:\other , c:\some
 * 	��� : �����, ������ ǥ���
 *  ��� ��� : ������ġ���� ����Ѵ� 
 *  ex) .(������ġ), ..(�Ѵܰ� ��) ..\some\a.txt  
 *  ex) ���� other�ε� some���� ������ c�� ���ٰ� some���� ����.
 *  ���� ��� : �������  root(���⼭�� c) ���� �����ؼ� �о���°� 
 *  ex) "C:\some\a.txt" ��� �ִ������� ��ΰ� ������ �ʴ´�.
 */

/*
 * I/O Stream		Input (read) <-�� Output(write)-> 
 * 					 
 * 1. ����(��)
 * 2. ������
 * 
 *  byte - I : InputStream
 *  	 - O : OutputStram
--------------------------------
 *  char - I : Reader
 * 		 - O : Writer
 * +
 * 
 *  FileInputStream << �����ϴ°� �̸��� InputStream���� ���� (����Ʈ ������ �б���)
 *  		   File(�����) << 1. ��� 2. Ư¡ 
 */



