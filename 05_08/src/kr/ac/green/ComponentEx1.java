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
		lbl.setText("아이유짱!");
		
		lbl.setHorizontalTextPosition(JLabel.CENTER);
		lbl.setVerticalTextPosition(JLabel.TOP);
		
		lbl.setToolTipText("이거슨 아이유님 입니다.");
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(Color.WHITE);
		JButton btnGood = new JButton(new ImageIcon("icon2.png"));
		
		btnGood.setRolloverIcon(new ImageIcon("icon1.png"));
		
		btnGood.setPressedIcon(new ImageIcon("icon3.png"));
		
		btnGood.setText("좋아요");
		btnGood.setHorizontalTextPosition(JButton.CENTER);
		btnGood.setVerticalTextPosition(JButton.BOTTOM);
		pnlSouth.add(btnGood);
		
		
		add(lbl, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
		
		
		setTitle("ComponentEx1");
		pack();
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ComponentEx1();
	}
}
