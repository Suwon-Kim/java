package kr.ac.green;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
	private JLabel label;
	
	public MyFrame() {
		JLabel label = new JLabel(
			"자바 피자에 오신것을 환영합니다. 피자를 고르세요",
			JLabel.CENTER	
		);
		JButton btnCombo = new JButton("콤보피자");
		JButton btnPotato = new JButton("포테이토 피자");
		JButton btnBul = new JButton("불고기 피자");
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnCombo);
		pnlSouth.add(btnPotato);
		pnlSouth.add(btnBul);
		
		add(label, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
		

		setTitle("MyFrame");
		pack();
		setLocation(100,0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
