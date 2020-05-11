package kr.ac.green;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SizeControl extends JFrame {
	public SizeControl() {
		JButton btnA = new JButton("this is a A-Button");
		JButton btnB = new JButton("I'm B");
		
		Dimension btnSize = new Dimension(130, 28);
		
		setLayout(new FlowLayout());
		btnA.setPreferredSize(btnSize);
		btnB.setPreferredSize(btnSize);
		
		add(btnA);
		add(btnB);
		
		Dimension size = btnA.getSize();
		
		setTitle("Size Control");
		setSize(400, 150);
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new SizeControl();
	}
}
