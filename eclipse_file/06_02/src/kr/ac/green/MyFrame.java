package kr.ac.green;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	private Properties prop;
	
	public MyFrame() {
		load();
		
		//���� ���Ͽ��� String�ۿ� �� �� ����. (���� ��� �Ϸ��� parseInt �������)
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
		
		//FileInputStream�� ����Ʈ ������ �б� ������ �ѱ��� �ȵǴµ�.. 
		//Properties()�� �ѱ��� �ǵ��� ó���� ���ֱ� ������ �ѱ��� ���´�.
		//���࿡ �ѱ��� ���� �ʹٸ� FileInputStream�� �ƴ� FileReader�� ����ؼ� �а�
		//���� FileWriter�� ����ؼ� ����.
		try ( FileInputStream fis = new FileInputStream("myFrame.properties") ) {
			prop.load(fis);
			//prop�ȿ� �������� load()�̴�.�׷��� load(fis) �ؼ� 
			//myFrame.properties ������ �о prop�� �����Ѵ�.
			
			//	Set<?> keys = prop.keySet();	//keySet�� ��� �ִ� �޼ҵ��ε� -- > Map�� �ִ�.
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
