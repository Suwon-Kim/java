package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Counter extends JFrame {
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
		JButton btn = new JButton();
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
} 
