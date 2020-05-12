package kr.ac.green.second;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/*
 * Button�� ����� ���� : ActionEvent --> ActionListener (�׼�ó��) (�������̽���)
 * 
 * 
 */
public class MyActionListener extends JFrame implements ActionListener {
	
	private Counter ui;
	
	public MyActionListener(Counter ui) {
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JLabel lblNum = ui.getLblNum();
		// ActionEvent �߻� �� ���� ����
		// 1. JLabel�� text(����)�� �����´�.
		String strNum = lblNum.getText();
		// 2. String -> int
		int num = Integer.parseInt(strNum);
		// 3. num ����
		num++;
		// 4. int -> String
		strNum = String.valueOf(num);
		// 5. JLabel�� �ֱ�
		lblNum.setText(strNum);
	}
	
} 
