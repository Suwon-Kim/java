package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageSizeControl extends JFrame {
	private JLabel lblImg;
	
	public ImageSizeControl() {
		Image img = Toolkit.getDefaultToolkit().getImage("2.jpg");
		Image newSizeImg = img.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		lblImg = new JLabel(new ImageIcon(newSizeImg));
		
		add(lblImg, BorderLayout.CENTER);
		
		
		setTitle("Size Control");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ImageSizeControl();
	}
}
