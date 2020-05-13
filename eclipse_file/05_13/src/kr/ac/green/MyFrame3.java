package kr.ac.green;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame3 extends JFrame {

	public MyFrame3() {
		
		/*
		 *  Anonymous Inner Class
		 *  
		 *  1. ��ü������ �ѹ��� �� �� �ִ�.(�̸��� ����)
		 *  2. ���������� ����� �� �ִ�.(JDK1.8~)
		 *  	-> ����� ��밡���߾���.(~JDK1.7)
		 */
		this.addWindowListener(new WindowAdapter() {;
			@Override
			public void windowClosing(WindowEvent we) {
				int result = JOptionPane.showConfirmDialog(
					MyFrame3.this, 
					"�����Ͻðڽ��ϱ�?", 
					"����", 
					JOptionPane.OK_CANCEL_OPTION, 
					JOptionPane.QUESTION_MESSAGE
				);
				if(result == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		
		setTitle("MyFrame3");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}	
	public static void main(String[] args) {
		new MyFrame3();
	}
}
