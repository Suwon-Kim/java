package kr.ac.green.second;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/*
 * Button을 누루는 행위 : ActionEvent --> ActionListener (액션처리) (인터페이스임)
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
		// ActionEvent 발생 시 할일 정의
		// 1. JLabel의 text(숫자)를 가져온다.
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
	
} 
