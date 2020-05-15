package kr.ac.green;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MyFrame2 extends JFrame {

	public MyFrame2() {
		
		this.addWindowListener(new MyWindowListener2());
		
		setTitle("MyFrame2");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private class MyWindowListener2 extends WindowAdapter {
	
		@Override
		public void windowClosing(WindowEvent we) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new MyFrame2();
	}
}
