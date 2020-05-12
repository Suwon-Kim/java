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
		JLabel lblTitle = new JLabel("자바피자에 오신것을 환영합니다"); // North 타이틀
		JPanel pnlCenter = new JPanel(); // 토핑
		JPanel pnlBottom = new JPanel(); // 주문,취소
		JPanel testTop = new JPanel();

		LineBorder lBorder = new LineBorder(Color.GRAY, 1);
		border = new TitledBorder(lBorder, "토핑");
		JPanel pnlToping = new JPanel(new GridLayout(4, 1));
		String[] Toping = { "피망", "치즈", "페페로니", "베이컨" };

		JCheckBox[] chToping = new JCheckBox[Toping.length];
		pnlToping.setBorder(border);
		for (int i = 0; i < Toping.length; i++) {
			chToping[i] = new JCheckBox(Toping[i]);
			pnlToping.add(chToping[i]);
		}

		border = new TitledBorder(lBorder, "크기");
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

		border = new TitledBorder(lBorder, "종류");
		JPanel pnlFood = new JPanel(new GridLayout(3, 1));
		pnlFood.setPreferredSize(WIDTH_HEIGHT);
		String[] Food = { "콤보", "포테이토", "불고기" };
		JCheckBox[] chFood = new JCheckBox[Food.length];
		pnlFood.setBorder(border);
		for (int i = 0; i < Food.length; i++) {
			chFood[i] = new JCheckBox(Food[i]);
			pnlFood.add(chFood[i]);
		}
		JButton btnOrder = new JButton("주문");
		JButton btnCancle = new JButton("취소");

		pnlTop.add(lblTitle);
		pnlCenter.add(pnlFood);
		pnlCenter.add(pnlToping);
		pnlCenter.add(pnlSize);
		pnlBottom.add(btnOrder);
		pnlBottom.add(btnCancle);

		add(pnlTop, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlBottom, BorderLayout.SOUTH);

		setTitle("피자주문");
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
