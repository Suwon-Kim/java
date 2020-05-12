package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame3 extends JFrame {
	private JLabel lblMoney;	//원금을 입력하세요
	private JTextField tfMoney;	// 이자를 입력하세요
	private JLabel lblRate;		// 원금입력칸
	private JTextField tfRate;	// 이자입력칸
	private JButton btnCalc;	// 버튼
	private JTextField tfResult;	// 결과값 담는 필드
	
	private MyFrame3() {
		init();
		setDisplay();
		showFrame();
	}
	
	private void init() {
		lblMoney = new JLabel("원금을 입력하시오", JLabel.LEFT);
		lblRate = new JLabel("이자율을 입력하시오", JLabel.LEFT);
		
		tfMoney = new JTextField(5);
		tfRate = new JTextField(5);
		
		btnCalc = new JButton("변환");
		
		tfResult = new JTextField(15);
		tfResult.setEditable(false);
		tfResult.setBackground(Color.WHITE);
	}
	private void setDisplay() {
		JPanel pnlLeft = new JPanel(new GridLayout(2,1));
		JPanel pnlMoneyInfo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlMoneyInfo.add(lblMoney); //라벨
		JPanel pnlRateInfo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlRateInfo.add(lblRate);	//라벨
		
		pnlLeft.add(pnlMoneyInfo);
		pnlLeft.add(pnlRateInfo);
		
		JPanel pnlRight = new JPanel(new GridLayout(2, 1));
		JPanel pnlMoney = new JPanel();
		pnlMoney.add(tfMoney);
		JPanel pnlRate = new JPanel();
		pnlRate.add(tfRate);
		pnlRight.add(pnlMoney);
		pnlRight.add(pnlRate);
		
		JPanel pnlSouth = new JPanel(new BorderLayout());
		JPanel pnlBtn = new JPanel();
		pnlBtn.add(btnCalc);
		JPanel pnlResult = new JPanel();
		pnlResult.add(tfResult);
		
		pnlSouth.add(pnlBtn, BorderLayout.NORTH);
		pnlSouth.add(pnlResult, BorderLayout.CENTER);
		
		add(pnlLeft, BorderLayout.WEST);
		add(pnlRight, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
		
	}
	
	private void showFrame() {
		setTitle("이자 계산기");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame3();
	}
}