package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.AbstractBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class BorderTest extends JFrame {
	
	private Font font = new Font(Font.DIALOG, Font.BOLD, 25);
	
	public BorderTest() {
		JPanel pnlMain = new JPanel(new GridLayout(0, 1, 10, 10));
		JScrollPane scroll = new JScrollPane(pnlMain);
		
		// insets : ��, ��, �Ʒ�, ��
		Insets insets = new Insets(20, 20, 20, 20);
		pnlMain.setBorder(new EmptyBorder(insets));
		
		AbstractBorder border = new LineBorder(Color.BLACK, 2);
		pnlMain.add(getLabel("LineBorder", border));
		
		
		add(scroll, BorderLayout.CENTER);
		
		//���� ��ũ�ѹٸ� �����´�
		JScrollBar bar = scroll.getVerticalScrollBar();
		// ��ũ�ѹ��� �����̴� ������ �����Ѵ�.
		bar.setUnitIncrement(3);
		
		
		
		
		
		setTitle("Border Test");
		setSize(400, 300);
		//pack();
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	//AbstractBorder << border�� �θ�ü
	private JLabel getLabel(String text, AbstractBorder border) {
		JLabel lbl = new JLabel(text);
		lbl.setFont(font);
		lbl.setBorder(border);
		return lbl;
	}
	public static void main(String[] args) {
		new BorderTest();
	}
}
