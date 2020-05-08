package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComponentEx1 extends JFrame {
	private JLabel lbl;

	public ComponentEx1() {
		
		lbl = new JLabel(new ImageIcon("iu.jpg"));
		lbl.setText("�����¯");
		lbl.setHorizontalTextPosition(JLabel.CENTER);
		lbl.setVerticalTextPosition(JLabel.BOTTOM);
		
		lbl.setToolTipText("�̰Ž� �ڹ��� ��");

		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(Color.BLACK);
		JButton btnGood = new JButton(new ImageIcon("icon2.png"));
		btnGood.setRolloverIcon(new ImageIcon("icon1.png"));
		btnGood.setPressedIcon(new ImageIcon("icon3.png"));
		
		btnGood.setText("���ƿ�");
		btnGood.setHorizontalTextPosition(JButton.CENTER);
		btnGood.setVerticalTextPosition(JButton.BOTTOM);
		pnlSouth.add(btnGood);
		
		add(lbl, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
		
		pack();
		setTitle("fff");
		//setSize(500, 400); 
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
/*
		Random r = new Random();
		for (int x = 0; x <= 500; x++) {
			setLocation(r.nextInt(500), r.nextInt(500));
			setSize(500, 500);
			try {
				Thread.sleep(r.nextInt(100));
			} catch (Exception e) {
			}

		}
		*/
	}

	public static void main(String[] args) {
		new ComponentEx1();
	}
}