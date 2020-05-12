package kr.ac.green.first;

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
public class Counter extends JFrame implements ActionListener  {
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
		btnPlus.addActionListener(this);
	}
	
	public void showFrame() {
		setTitle("Counter");
		setSize(300, 400);
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
			new Counter();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			//strNum���� 0
			String strNum = lblNum.getText();
			// strNum�� ���ڷ� ����
			int number = Integer.parseInt(strNum);
			// number�� ������Ŵ
			number++;
			// int -> String
			strNum = String.valueOf(number);
			lblNum.setText(strNum);
	}
} 
