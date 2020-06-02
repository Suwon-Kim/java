package kr.ac.green;


import java.awt.*;
import javax.swing.*;

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
	private JLabel lblID;
	private JTextField tfId;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblInput;
	private JTextField tfInput;
	private JLabel lblRate;
	private JTextField tfRate;
	private JLabel lblSex;
	private JLabel lblIntro;
	private JTextField tfIntro;
	private JButton btnJoin;
	private JButton btnCancel;
	
	private JLabel lblMoneyInfo;
	private JLabel lblRateInfo;
	
	private JTextField tfMoney;
	
	
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
		lblID = new JLabel("아이디", JLabel.LEFT);
		lblRate = new JLabel("이름", JLabel.LEFT);
		lblName = new JLabel("비밀번호", JLabel.LEFT);
		lblInput = new JLabel("재입력", JLabel.LEFT);
		lblSex = new JLabel("성별", JLabel.LEFT);
		lblIntro = new JLabel("자기소개", JLabel.LEFT);

		tfId = new JTextField(10);
		tfRate = new JTextField(10);
		tfName = new JTextField(10);
		tfInput = new JTextField(10);
		tfIntro = new JTextField(40);

		btnJoin = new JButton("가입");
		btnCancel = new JButton("취소");

	}

	private void setDisplay() {
		JPanel pnlLeft = new JPanel(new GridLayout(6, 1));
		JPanel pnlMoneyInfo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlMoneyInfo.add(lblID);
		JPanel pnlRateInfo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlRateInfo.add(lblRate);
		JPanel pnlNumberInfo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlNumberInfo.add(lblName);
		JPanel pnlInputInfo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlInputInfo.add(lblInput);
		JPanel pnlSexInfo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlSexInfo.add(lblSex);
		JPanel pnlIntroInfo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlIntroInfo.add(lblIntro);

		pnlLeft.add(pnlMoneyInfo);
		pnlLeft.add(pnlRateInfo);
		pnlLeft.add(pnlNumberInfo);
		pnlLeft.add(pnlInputInfo);
		pnlLeft.add(pnlSexInfo);
		pnlLeft.add(pnlIntroInfo);

		JPanel pnlRight = new JPanel(new GridLayout(6, 1));
		JPanel pnlMoney = new JPanel();
		pnlMoney.add(tfId);
		JPanel pnlRate = new JPanel();
		pnlRate.add(tfRate);
		JPanel pnlNumber = new JPanel();
		pnlNumber.add(tfName);
		JPanel pnlInput = new JPanel();
		pnlInput.add(tfInput);
		JPanel pnlIntro = new JPanel();
		pnlIntro.add(tfIntro);

		pnlRight.add(pnlMoney);
		pnlRight.add(pnlRate);
		pnlRight.add(pnlNumber);
		pnlRight.add(pnlInput);
		// pnlRight.add(pnlSex);
		// pnlRight.add(pnlIntro);
		ButtonGroup group = new ButtonGroup();
		JRadioButton a1 = new JRadioButton("남자");
		JRadioButton a2 = new JRadioButton("여자");
		
		group.add(a1);
		group.add(a2);
		
		pnlSexInfo.add(a1);
		pnlSexInfo.add(a2);
		
	

		JPanel pnlSouth = new JPanel(new GridLayout(0, 2));

		JPanel pnlBtn = new JPanel();
		pnlBtn.add(btnJoin);
		JPanel pnlBtn2 = new JPanel();
		pnlBtn2.add(btnCancel);

		pnlSouth.add(pnlBtn, BorderLayout.NORTH);
		pnlSouth.add(pnlBtn2, BorderLayout.NORTH);

		add(pnlLeft, BorderLayout.WEST);
		add(pnlRight, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}


	private void showFrame() {
		setTitle("회원가입");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Answer3();
	}
}
