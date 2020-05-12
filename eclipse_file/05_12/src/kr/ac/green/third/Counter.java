package kr.ac.green.third;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/*
 * Button을 누루는 행위 : ActionEvent --> ActionListener (액션처리) (인터페이스임)
 * 
 * 
 */
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
		/*
		 * EventSource, EventLister 연결
		 */
		btnPlus.addActionListener(new MyActionListener2(this));
	}
	public void showFrame() {
		setTitle("Counter");
		setSize(300, 400);
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void plusNum() {
		String strNum = lblNum.getText();
		// 2. String -> int
		int num = Integer.parseInt(strNum);
		// 3. num 증가
		num++;
		// 4. int -> String
		strNum = String.valueOf(num);
		// 5. JLabel에 넣기
		lblNum.setText(strNum);
	}
	public static void main(String[] args) {
			new Counter();
	}
} 
