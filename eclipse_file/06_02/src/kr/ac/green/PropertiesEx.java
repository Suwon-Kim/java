package kr.ac.green;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesEx {
	/*
	 * Properties
	 * 1. map �迭 , Hashtable�� ��ӹ���
	 * 2. ���Ͽ� ���� �б� ����� ����
	 * 3. key, value - > String 
	 */
	public static void save() {
		Properties prop = new Properties(); //Properties ��ü ����
		prop.setProperty("mykey","myvalue" ); // String�� �޴´�.
		prop.setProperty("yourkey","yourvalue" );
		prop.setProperty("someonekey","someonevalue" );
		
		//���Ͽ� ���� ���
		FileOutputStream fos = null;
		try {
			//XML�� ��� ������ ���� �ϴ� ����� �Ȱ���.
			//���α׷��� �� �� ���� ���δ� (XML)
			//Properties�� XML�� �������ش�. 
			//fos = new FileOutputStream("mydata.xml");
			fos = new FileOutputStream("mydata.properties");
			prop.store(fos,  "hello"); 	//--> text�������� �����ϴ� �޼ҵ�
			// prop.storeToXML(fos, "hi~"); -- > xml�������� �����ϴ� �޼ҵ�
			// ���� ������ ���� ������ ����ڰ� ���α׷��� ���� ������ �ٲ� �� �ִ�.
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (Exception e) {
				
			}
		}
	}// �����ϴ¹��
	
	public static void load() {
		FileInputStream fis = null;
		Properties prop = new Properties(); //�� ������Ƽ ��ü�� ����
		
		try {
			fis = new FileInputStream("mydata.properties");
			prop.load(fis);
			
//			fis = new FileInputStream("mydata.xml");	//xml���� �о�´�.
//			prop.loadFromXML(fis);
			
			//System.out.println(prop.getProperty("mykey"));
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (Exception e) { }
		}
	}
	public static void main(String[] args) {
		save();
		//load();
	}
}
