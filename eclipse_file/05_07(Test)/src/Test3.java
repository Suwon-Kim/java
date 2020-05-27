import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

public class Test3 extends JFrame {
	private JLabel lblLeft;
	private JLabel lblRight;
	private JLabel lblStatus;
	
	private JSplitPane sp;
	
	public Test3() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
		lblLeft = new JLabel();
		lblLeft.setOpaque(true);
		lblLeft.setBackground(Color.BLUE);
		
		
		lblRight = new JLabel();
		lblRight.setOpaque(true);
		lblRight.setBackground(Color.RED);
		
		
		lblStatus = new JLabel("staus : start");
		
		sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		sp.setContinuousLayout(true);
		
		sp.setContinuousLayout(true);
		
		sp.setResizeWeight(0.5);
		
		sp.setDividerSize(20);
		
		sp.setOneTouchExpandable(true);
		
		
	}
	private void setDisplay() {
		sp.setLeftComponent(lblLeft);
		sp.setRightComponent(lblRight);
		
		add(sp,BorderLayout.CENTER);
		add(lblStatus, BorderLayout.SOUTH);
	}
	private void addListeners() {
		MouseListener listener = new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent me) {
			}
			@Override
			public void mouseEntered(MouseEvent me) {
				lblLeft.setText("IN");
				lblLeft.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
			}
			@Override
			public void mouseExited(MouseEvent me) {
				lblLeft.setText("");
			}
			@Override
			public void mousePressed(MouseEvent me) {
				lblLeft.setBackground(Color.GREEN);
			}
			@Override
			public void mouseReleased(MouseEvent me) {
				lblLeft.setBackground(Color.WHITE);
			}
		};
		lblLeft.addMouseListener(listener);
		lblRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent ae) {
				int btn = ae.getButton();
				if(btn == MouseEvent.BUTTON1) {
					lblRight.setText("Button1");
				} else if(btn == MouseEvent.BUTTON2) {
					lblRight.setText("Button2");
				} else {
					lblRight.setText("Button3");
				}
			}
		});
		
	}
	private void showFrame() {
		setTitle("MouseEvent Ex");
		setSize(600,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Test3();
	}
} 