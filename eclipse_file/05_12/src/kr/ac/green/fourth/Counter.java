package kr.ac.green.fourth;

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
public class Counter extends JFrame implements IPressable  {
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
		btnPlus.addActionListener(new MyActionListener3(this));
	}
	public void showFrame() {
		setTitle("Counter");
		setSize(300, 400);
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void buttonPressed() {
		String strNum = lblNum.getText();
		int num = Integer.parseInt(strNum);
		num++;
		strNum = String.valueOf(num);
		lblNum.setText(strNum);
	}
	public JLabel getLblNum() {
		return lblNum;
	}
	public static void main(String[] args) {
			new Counter();
	}
} 
