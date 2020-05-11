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
		lblMoneyInfo = new JLabel("������ �Է��Ͻÿ�", JLabel.LEFT);
		lblRateInfo = new JLabel("�������� �Է��Ͻÿ�", JLabel.LEFT);
		
		lblMoneyInfo.setPreferredSize(LBL_SIZE);
		lblRateInfo.setPreferredSize(LBL_SIZE);
		//pack(), setSize()
		//setSize() â�� ũ�Ⱑ ������ ���� 
		//pack() â�� ����� ������ ���°� �ƴ� ���� �� ���� ũ���� ������ ��������
		//preferredSize�� ������ ����.
		
		tfMoney = new JTextField(INPUT_SIZE);
		tfRate = new JTextField(INPUT_SIZE);
		btnCalc = new JButton("��ȯ");
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
		
		EmptyBorder border = new EmptyBorder(40, 30, 20, 10);	//�� ���� �Ʒ� ������ ����
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
