package kr.ac.green;
import java.awt.*;
import javax.swing.*;


public class ComponentEx1 extends JFrame {
	private JLabel lbl;
	
	public ComponentEx1() {
		lbl = new JLabel(new ImageIcon("iu.jpg"));
		
		add(lbl, BorderLayout.CENTER);
		setTitle("ComponentEx1");
		setSize(400, 300);
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new ComponentEx1();
	}
}
