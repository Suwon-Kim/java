package kr.ac.green;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Quiz {
	//������ �����ϴ� �ڵ带 ����� �׽�Ʈ �϶�.
	//	src : ����
	//	copy : ���纻
	// ���纻 ���� �̸��� *_copy.* ��� ���δ�.
	// ex) a.txt -> a_copy.txt
	
	public static void copy(File src) {
//		FileInputStream fis = null;
//		FileOutputStream fos = null;
//		try {
//			fis = new FileInputStream(src);
//			fos = new FileOutputStream("apple_copy.jpg");	//�̰Ŵ� ������ apple_copy.jpg �̸��� ������ (������)
//			int data = -1;
//			while( (data = fis.read()) != -1) {
//				fos.write(data);
//			}
//		} catch(FileNotFoundException e) {
//			
//		} catch(IOException e) {
//			
//		} finally {
//			try {
//				fis.close();
//				fos.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	src = src.getAbsoluteFile();						// copy ���� �̸��� �󸶵��� �ٲ� �� �ִ� �̸��� �ȴ� (������)	
	String path = src.getPath();
	int idx = path.lastIndexOf(".");
	path.substring(idx); //.jpg
	String ext = path.substring(idx);
	String name = path.substring(0,idx) + "_copy";
	File copy = new File(name + ext); 
								
	FileInputStream fis = null;	 //null ���ָ� ������ �����. try�� ������ �����ϴ� ������ �ƴϴ�. 
	FileOutputStream fos = null;
	
	try {
		fis = new FileInputStream(src);
		fos = new FileOutputStream(copy);	//���Ͽ� �� ���� ������ ������ �����ϴ��� ���ϴ��� üũ�� �ؾ��Ѵ�.
		
		int data = -1;
		while( (data = fis.read()) != -1 ) {
			fos.write(data);
		}
	} catch(IOException e) {
		e.printStackTrace();
	} finally {
		try {
			fis.close();
		} catch(Exception e) {}
		try {
			fos.close();
		} catch (Exception e) {}
	}
	
	}
	// (getAbsoluteFile)�� ��θ� �޾ƿ��� �ʰ� �׳� �������  apple.jpg�� ���� ���������� apple.jpg ������ �ִ� ���� ���簡 �Ǵµ�
	// getAbsoluteFile�� ����ϸ� �����η� �޾� ���� ������ apple.jpg�� ��� �ִ��� ���� �ʾƵ� ���縦 �� �� �ִ�.
	public static void main(String[] args) {
		copy(new File("thumb.jpg"));	
		//copy(new File("a.jpg"));
		//���࿡ ī�� �Ұ� ���ٰ� �����ϸ� �� ������ �ڵ�� �ϰ� �Ǹ� ������ ��ü�� �ϳ��ϳ� �������Ѵ�.�׷��� ��õ (X)
		//���������� Ŭ���� �Ϻκп����� ��� ������ ����
		//��������� Ŭ���� ��ü���� ��� ������ ����
	}
}