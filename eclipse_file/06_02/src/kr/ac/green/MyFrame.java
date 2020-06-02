package kr.ac.green;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	private Properties prop;
	
	public MyFrame() {
		load();
		
		//설정 파일에는 String밖에 올 수 없다. (숫자 사용 하려면 parseInt 해줘야함)
		setTitle(prop.getProperty("title"));
		int width = Integer.parseInt(prop.getProperty("width"));
		int height = Integer.parseInt(prop.getProperty("height"));
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	private void load() {
		prop = new Properties();
		
		//FileInputStream은 바이트 단위로 읽기 때문에 한글이 안되는데.. 
		//Properties()가 한글이 되도록 처리를 해주기 때문에 한글이 나온다.
		//만약에 한글이 쓰고 싶다면 FileInputStream이 아닌 FileReader를 사용해서 읽고
		//쓸때 FileWriter를 사용해서 쓴다.
		try ( FileInputStream fis = new FileInputStream("myFrame.properties") ) {
			prop.load(fis);
			//prop안에 만들어놓은 load()이다.그래서 load(fis) 해서 
			//myFrame.properties 파일을 읽어서 prop에 저장한다.
			
			//	Set<?> keys = prop.keySet();	//keySet은 어디에 있던 메소드인데 -- > Map에 있다.
			//	for(Object key : keys) {
			//		System.out.println(key.toString());
			//	}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
