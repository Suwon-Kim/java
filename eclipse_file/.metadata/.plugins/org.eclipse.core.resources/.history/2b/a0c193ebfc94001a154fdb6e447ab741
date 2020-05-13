package kr.ac.green;

import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/*
 * 1. setDefaultCloseOperation() 반드시 처리할 것.
 * 2. WindowListener를 사용하지 말고 WindowAdapter를 사용할 것.
 */
public class MyFrame extends JFrame {
		
	public MyFrame() {
		
		WindowListener listener = new MyWindowListener(this);
		addWindowListener(listener);
		
		setTitle("MyFrame");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}	

	/*
	 * JOptionPane.YES_NO_OPTION		-> 예, 아니오
	 * JOptionPane.OK_CANCEL_OPTION		-> 확인, 취소
	 * JOptionPane.YES_NO_CANCEL_OPTION -> 예, 아니오, 취소
	 */
	public void closeWindow() {
		int result = JOptionPane.showConfirmDialog(
			this, 
			"종료하시겠습니까?", 
			"종료", 
			JOptionPane.YES_NO_OPTION, 
			JOptionPane.QUESTION_MESSAGE
		);
		
		if(result == JOptionPane.YES_OPTION) {
			System.exit(MyWindowListener.NORMAL);
		}
	}	
	
	public static void main(String[] args) {
		new MyFrame();
	}
}