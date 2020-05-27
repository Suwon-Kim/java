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
public class Counter extends JFrame implements ActionListener {
	private JLabel lblNum;
	private JButton btnPlus;
		
	public Counter() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	public void init() {
		lblNum = new JLabel("0", JLabel.CENTER);
		lblNum.setFont(new Font(Font.DIALOG, Font.BOLD, 60));
		
		btnPlus = new JButton("plus");
	}
	public void setDisplay() {
		add(lblNum, BorderLayout.CENTER);
		add(btnPlus, BorderLayout.SOUTH);
	}
	public void addListeners() {
		MyActionListener listener = new MyActionListener(this);
		btnPlus.addActionListener(listener);
	}
	public void showFrame() {
		setTitle("Counter");
		setSize(300, 400);
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
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
	
	public JLabel getLblNum() {
		return lblNum;
	}
	public static void main(String[] args) {
			new Counter();
	}
} 