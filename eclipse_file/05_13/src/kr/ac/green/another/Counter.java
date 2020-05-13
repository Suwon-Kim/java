package kr.ac.green.another;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
		final int some = 100;
		
		// ¶÷´Ù½Ä(JDK1.8~)
		btnPlus.addActionListener((ae)->{
			System.out.println(some);
			int num = Integer.parseInt(lblNum.getText());
			num++;
			lblNum.setText(String.valueOf(num));
		});
		
//		btnPlus.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent ae) {
//				// JDK1.8~
//				System.out.println(some);
//				int num = Integer.parseInt(lblNum.getText());
//				num++;
//				lblNum.setText(String.valueOf(num));
//			}
//		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	private void showFrame() {
		setTitle("Counter");
		setSize(300, 400);
		setLocation(100, 0);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Counter();
	}
}