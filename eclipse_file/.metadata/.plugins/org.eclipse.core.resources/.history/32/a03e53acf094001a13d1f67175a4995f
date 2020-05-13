package kr.ac.green.other;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	private void init() {
		lblNum = new JLabel("0", JLabel.CENTER);
		lblNum.setFont(new Font(Font.DIALOG, Font.BOLD, 60));
		
		btnPlus = new JButton("Plus");
	}

	private void setDisplay() {
		add(lblNum, BorderLayout.CENTER);
		add(btnPlus, BorderLayout.SOUTH);
	}

	private void addListeners() {
		btnPlus.addActionListener(new MyActionListener());
	}

	private class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int num = Integer.parseInt(lblNum.getText());
			num++;
			lblNum.setText(String.valueOf(num));
		}
	}
	
	private void showFrame() {
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








