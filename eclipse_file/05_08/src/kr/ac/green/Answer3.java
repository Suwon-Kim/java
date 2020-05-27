package kr.ac.green;

import java.awt.*;
import javax.swing.*;

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

	public Answer3() {
		init();
		setDisplay();
		showFrame();
	}

	private void init() {
		lblID = new JLabel("���̵�", JLabel.LEFT);
		lblRate = new JLabel("�̸�", JLabel.LEFT);
		lblName = new JLabel("��й�ȣ", JLabel.LEFT);
		lblInput = new JLabel("���Է�", JLabel.LEFT);
		lblSex = new JLabel("����", JLabel.LEFT);
		lblIntro = new JLabel("�ڱ�Ұ�", JLabel.LEFT);

		tfId = new JTextField(10);
		tfRate = new JTextField(10);
		tfName = new JTextField(10);
		tfInput = new JTextField(10);
		tfIntro = new JTextField(40);

		btnJoin = new JButton("����");
		btnCancel = new JButton("���");

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
		JRadioButton a1 = new JRadioButton("����");
		JRadioButton a2 = new JRadioButton("����");
		
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
		setTitle("ȸ������");
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