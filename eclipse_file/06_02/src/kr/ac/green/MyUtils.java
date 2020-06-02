package kr.ac.green;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class MyUtils {
	//saveProp메소드를 정의하는데 파라미터로 프로퍼티, 스트링, 스트링을 매겨변수로 받는다 
	//또한 saveProp는 NullPointerException, BadFileException, IOException의
	//예외들을 던진다. 
	public static void saveProp(Properties prop, String path, String comment) throws NullPointerException, BadFileException, IOException {
		//throws는 예외를 다른곳으로 전가시킨다. 
	
		if(prop == null) {
		//prop값이 null이면 NullPointerException 예외를 생성한다.
			throw new NullPointerException("Properties 객체는 null이 될 수 없습니다.");
			//throw는 예외를 고의로 발생시키는거고 
		}
		nullCheck(path);
		//nullCheck(path)함수 호출
		checkFileExt(path);
		//checkFileExt(path)함수 호출
		
		//파일쓰기를 위한 파일아웃풋스트림의 값을 null로 초기화한다.
		FileOutputStream fos = null;
	
		try {
			fos = new FileOutputStream(path);
			//path안의 파일을 쓰기 위해 FileOutputStream을 생성해서 fos에 대입
			if(isXML(path)) {
			//path의 파일이 XML파일이면 
				prop.storeToXML(fos, comment);
				//xml형식으로 저장 
			} else {
				prop.store(fos, comment);
				//String 형식으로 저장
				}
			} finally {
				try {
					fos.close();
					//자원해제
				} catch(Exception e) { }
			}
			
		}
		//checkFileExt 메소드를 정의 파라미터로 파일의 경로를 받음
		private static void checkFileExt(String path)
			throws BadFileException {
			//BadFileException에 대한 예외를 checkFileExt메소드를 호출 하는쪽으로 
			//예외를 전가한다.
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
						"파일경로는 null이 될 수 없습니다."
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