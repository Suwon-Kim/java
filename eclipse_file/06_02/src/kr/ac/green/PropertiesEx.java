package kr.ac.green;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesEx {
	/*
	 * Properties
	 * 1. map 계열 , Hashtable을 상속받음
	 * 2. 파일에 쓰기 읽기 기능이 있음
	 * 3. key, value - > String 
	 */
	public static void save() {
		Properties prop = new Properties(); //Properties 객체 생성
		prop.setProperty("mykey","myvalue" ); // String을 받는다.
		prop.setProperty("yourkey","yourvalue" );
		prop.setProperty("someonekey","someonevalue" );
		
		//파일에 쓰는 방법
		FileOutputStream fos = null;
		try {
			//XML은 어느 언어에서든 접근 하는 방법이 똑같다.
			//프로그래밍 할 때 많이 쓰인다 (XML)
			//Properties가 XML을 제공해준다. 
			//fos = new FileOutputStream("mydata.xml");
			fos = new FileOutputStream("mydata.properties");
			prop.store(fos,  "hello"); 	//--> text형식으로 저장하는 메소드
			// prop.storeToXML(fos, "hi~"); -- > xml형식으로 저장하는 메소드
			// 설정 파일을 만든 이유는 사용자가 프로그램을 몰라도 동작을 바꿀 수 있다.
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (Exception e) {
				
			}
		}
	}// 저장하는방법
	
	public static void load() {
		FileInputStream fis = null;
		Properties prop = new Properties(); //빈 프로퍼티 객체를 생성
		
		try {
			fis = new FileInputStream("mydata.properties");
			prop.load(fis);
			
//			fis = new FileInputStream("mydata.xml");	//xml에서 읽어온다.
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
