package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Pizza extends JFrame {
	private final static Dimension WIDTH_HEIGHT = new Dimension(87, 129);

	public Pizza() {
		AbstractBorder border = new LineBorder(Color.BLACK, 2);
		JPanel pnlTop = new JPanel();
		JLabel lblTitle = new JLabel("�ڹ����ڿ� ���Ű��� ȯ���մϴ�"); // North Ÿ��Ʋ
		JPanel pnlCenter = new JPanel(); // ����
		JPanel pnlBottom = new JPanel(); // �ֹ�,���
		JPanel testTop = new JPanel();

		LineBorder lBorder = new LineBorder(Color.GRAY, 1);
		border = new TitledBorder(lBorder, "����");
		JPanel pnlToping = new JPanel(new GridLayout(4, 1));
		String[] Toping = { "�Ǹ�", "ġ��", "����δ�", "������" };

		JCheckBox[] chToping = new JCheckBox[Toping.length];
		pnlToping.setBorder(border);
		for (int i = 0; i < Toping.length; i++) {
			chToping[i] = new JCheckBox(Toping[i]);
			pnlToping.add(chToping[i]);
		}

		border = new TitledBorder(lBorder, "ũ��");
		JPanel pnlSize = new JPanel(new GridLayout(3, 1));
		String[] Size = { "small", "medium", "large" };
		pnlSize.setPreferredSize(WIDTH_HEIGHT);
		JCheckBox[] chSize = new JCheckBox[Size.length];
		ButtonGroup group = new ButtonGroup();
		pnlSize.setBorder(border);
		for (int i = 0; i < Size.length; i++) {
			chSize[i] = new JCheckBox(Size[i]);
			pnlSize.add(chSize[i]);
			group.add(chSize[i]);

		}

		border = new TitledBorder(lBorder, "����");
		JPanel pnlFood = new JPanel(new GridLayout(3, 1));
		pnlFood.setPreferredSize(WIDTH_HEIGHT);
		String[] Food = { "�޺�", "��������", "�Ұ��" };
		JCheckBox[] chFood = new JCheckBox[Food.length];
		pnlFood.setBorder(border);
		for (int i = 0; i < Food.length; i++) {
			chFood[i] = new JCheckBox(Food[i]);
			pnlFood.add(chFood[i]);
		}
		JButton btnOrder = new JButton("�ֹ�");
		JButton btnCancle = new JButton("���");

		pnlTop.add(lblTitle);
		pnlCenter.add(pnlFood);
		pnlCenter.add(pnlToping);
		pnlCenter.add(pnlSize);
		pnlBottom.add(btnOrder);
		pnlBottom.add(btnCancle);

		add(pnlTop, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlBottom, BorderLayout.SOUTH);

		setTitle("�����ֹ�");
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		System.out.println(pnlToping.getSize());
	}

	public static void main(String[] args) {
		new Pizza();
	}

}
