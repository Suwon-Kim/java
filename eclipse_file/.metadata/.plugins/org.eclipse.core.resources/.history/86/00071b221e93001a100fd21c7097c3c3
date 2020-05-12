package kr.ac.green;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame3 extends JFrame {
	private JLabel moneyLabel;
	private JTextField moneyTextField;
	private JLabel rateLabel;
	private JTextField rateTextField;
	private JButton button;
	private JTextField blankField;
	
	public MyFrame3() {
		init();
		display();
		showFrame();
	}
	public void init() {
		moneyLabel = new JLabel("원금을 입력하시오");
		moneyTextField = new JTextField(10);
		rateLabel = new JLabel("이자율을 입력하시오");
		rateTextField = new JTextField(10);
		button = new JButton("변환");
		blankField = new JTextField(30);
		//blankField.setEditable(false);
	}
	public void display() {
		JPanel pnlNorth = new JPanel();
		pnlNorth.add(moneyLabel);
		pnlNorth.add(moneyTextField);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(blankField);
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.add(rateLabel);
		pnlCenter.add(rateTextField);
		pnlCenter.add(button);
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	public void showFrame() {
		setTitle("이자 계산기");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame3();
	}
}
