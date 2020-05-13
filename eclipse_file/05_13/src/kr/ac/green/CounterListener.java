package kr.ac.green;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CounterListener extends WindowAdapter {
	
	private Counter owner;
	
	public CounterListener(Counter owner) {
		this.owner = owner;
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		owner.closeWindow();
	}
}
