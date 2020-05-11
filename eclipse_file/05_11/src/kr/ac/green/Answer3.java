package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Answer3 extends JFrame {
	
	private JLabel lblMoneyInfo;
	private JLabel lblRateInfo;
	
	private JTextField tfMoney;
	private JTextField tfRate;
	
	private JButton btnCalc;
	
	private JTextField tfResult;
	
	private final static int INPUT_SIZE = 5;
	
	private final static Dimension LBL_SIZE = new Dimension(130, 18);
	
	
	public Answer3() {
		init();
		setDisplay();
		showFrame();
	}
	private void init() {
		lblMoneyInfo = new JLabel("원금을 입력하시오", JLabel.LEFT);
		lblRateInfo = new JLabel("이자율을 입력하시오", JLabel.LEFT);
		
		lblMoneyInfo.setPreferredSize(LBL_SIZE);
		lblRateInfo.setPreferredSize(LBL_SIZE);
		//pack(), setSize()
		//setSize() 창의 크기가 결정난 상태 
		//pack() 창의 사이즈가 결정난 상태가 아님 따라서 각 셀의 크기의 합으로 결정난다
		//preferredSize로 결정이 난다.
		
		tfMoney = new JTextField(INPUT_SIZE);
		tfRate = new JTextField(INPUT_SIZE);
		btnCalc = new JButton("변환");
		tfResult = new JTextField(INPUT_SIZE * 3);
		tfResult.setEditable(false);
	}
	private void setDisplay() {
		JPanel pnlMoney = new JPanel();
		pnlMoney.add(lblMoneyInfo);
		pnlMoney.add(tfMoney);
		
		JPanel pnlRate = new JPanel();
		pnlRate.add(lblRateInfo);
		pnlRate.add(tfRate);
		
		JPanel pnlBtn = new JPanel();
		pnlBtn.add(btnCalc);
		
		JPanel pnlResult = new JPanel();
		pnlResult.add(tfResult);
		pnlResult.setBorder(new EmptyBorder(0, 0, 20, 0));
		
		JPanel pnlNorth = new JPanel(new GridLayout(0, 1));
		pnlNorth.add(pnlMoney);
		pnlNorth.add(pnlRate);
		
		EmptyBorder border = new EmptyBorder(40, 30, 20, 10);	//위 왼쪽 아래 오른쪽 비율
		pnlNorth.setBorder(border);
		pnlNorth.setBackground(Color.YELLOW);
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlBtn, BorderLayout.CENTER);
		add(pnlResult, BorderLayout.SOUTH);
	}
	private void showFrame() {
		setTitle("Answer3");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
		System.out.println(lblRateInfo.getSize());
	}
	public static void main(String[] args) {
		new Answer3();
	}
	
}
