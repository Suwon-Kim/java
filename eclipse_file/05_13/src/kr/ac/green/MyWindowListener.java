package kr.ac.green;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

public class MyWindowListener extends WindowAdapter {
	public static final int NORMAL = 0;
	
	private MyFrame owner;
	
	public MyWindowListener(MyFrame owner) {
		this.owner = owner;
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		owner.closeWindow();
	}
}
