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
			"�ڹ� ���ڿ� ���Ű��� ȯ���մϴ�. ���ڸ� ��������",
			JLabel.CENTER	
		);
		JButton btnCombo = new JButton("�޺�����");
		JButton btnPotato = new JButton("�������� ����");
		JButton btnBul = new JButton("�Ұ��� ����");
		
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