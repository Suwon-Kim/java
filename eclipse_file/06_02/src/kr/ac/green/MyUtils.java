package kr.ac.green;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class MyUtils {
	//saveProp�޼ҵ带 �����ϴµ� �Ķ���ͷ� ������Ƽ, ��Ʈ��, ��Ʈ���� �Űܺ����� �޴´� 
	//���� saveProp�� NullPointerException, BadFileException, IOException��
	//���ܵ��� ������. 
	public static void saveProp(Properties prop, String path, String comment) throws NullPointerException, BadFileException, IOException {
		//throws�� ���ܸ� �ٸ������� ������Ų��. 
	
		if(prop == null) {
		//prop���� null�̸� NullPointerException ���ܸ� �����Ѵ�.
			throw new NullPointerException("Properties ��ü�� null�� �� �� �����ϴ�.");
			//throw�� ���ܸ� ���Ƿ� �߻���Ű�°Ű� 
		}
		nullCheck(path);
		//nullCheck(path)�Լ� ȣ��
		checkFileExt(path);
		//checkFileExt(path)�Լ� ȣ��
		
		//���Ͼ��⸦ ���� ���Ͼƿ�ǲ��Ʈ���� ���� null�� �ʱ�ȭ�Ѵ�.
		FileOutputStream fos = null;
	
		try {
			fos = new FileOutputStream(path);
			//path���� ������ ���� ���� FileOutputStream�� �����ؼ� fos�� ����
			if(isXML(path)) {
			//path�� ������ XML�����̸� 
				prop.storeToXML(fos, comment);
				//xml�������� ���� 
			} else {
				prop.store(fos, comment);
				//String �������� ����
				}
			} finally {
				try {
					fos.close();
					//�ڿ�����
				} catch(Exception e) { }
			}
			
		}
		//checkFileExt �޼ҵ带 ���� �Ķ���ͷ� ������ ��θ� ����
		private static void checkFileExt(String path)
			throws BadFileException {
			//BadFileException�� ���� ���ܸ� checkFileExt�޼ҵ带 ȣ�� �ϴ������� 
			//���ܸ� �����Ѵ�.
			int idx = path.lastIndexOf(".");
			if(idx < 0) {
				throw new BadFileException();
			}
		}
	
		private static boolean isXML(String path) {
			boolean isXML = false;
			
			int idx = path.lastIndexOf(".");
			String ext = path.substring(idx).toLowerCase();
			if(ext.equals(".xml")) {
				isXML = true;
			}
			return isXML;
		
		}
		private static void nullCheck(String path)
			throws NullPointerException {
			
			if(path == null) {
				throw new NullPointerException (
						"���ϰ�δ� null�� �� �� �����ϴ�."
				);
			}
		}
		public static Properties loadProp(String path)
			throws NullPointerException, IOException {
			
			nullCheck(path);
			checkFileExt(path);
			
			Properties prop = null;
			FileInputStream fis = null;
			
			try {
				fis = new FileInputStream(path);
				prop = new Properties();
				if(isXML(path)) {
					prop.loadFromXML(fis);
				} else {
					prop.load(fis);
				}
			} finally {
				try {
					fis.close();
				} catch (Exception e) { }
			}
			return prop;
		}
	
}