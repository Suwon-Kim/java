package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

public class MouseEventEx extends JFrame {

	private JLabel lblLeft;
	private JLabel lblRight;
	private JLabel lblStatus;
	
	private JSplitPane sp;
	
	public MouseEventEx() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}	
	private void init() {
		lblLeft = new JLabel();
		lblLeft.setOpaque(true);
		lblLeft.setBackground(Color.YELLOW);
		lblLeft.setHorizontalAlignment(JLabel.CENTER);
		
		lblRight = new JLabel();
		lblRight.setOpaque(true);
		lblRight.setBackground(Color.PINK);
		
		lblStatus = new JLabel("status : start");
		
		sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		// 실시간 화면 갱신
		sp.setContinuousLayout(true);
		// Left(HORIZONTAL_SPLIT), Top(VERTICAL_SPLIT) 기준, 화면분할 비율
		sp.setResizeWeight(0.3);		
		// Divider 너비 조절
		sp.setDividerSize(10);
		// 원터치....해봐라..
		sp.setOneTouchExpandable(true);
	}
	private void setDisplay() {
		sp.setLeftComponent(lblLeft);
		sp.setRightComponent(lblRight);
		
		
		add(sp, BorderLayout.CENTER);
		add(lblStatus, BorderLayout.SOUTH);
	}
	private void addListeners() {
		MouseListener listener = new MouseListener() {
			// alt + shift + s -> v
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLeft.setText("IN");
				lblLeft.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLeft.setText("");				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblLeft.setBackground(Color.GREEN);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblLeft.setBackground(Color.YELLOW);
			}
		};
		
		lblLeft.addMouseListener(listener);
		
		lblRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int btn = e.getButton();
				//  왼쪽
				if(btn == MouseEvent.BUTTON1) {
					lblRight.setText("Button1");
					if(e.getClickCount() == 2) {
						// 이벤트 소스 상의 좌표
						setStatus(e.getX(), e.getY());
						// 화면상의 좌표
						System.out.println("x :" + e.getXOnScreen());
						System.out.println("y :" + e.getYOnScreen());
						lblRight.setText("double click");
					}
				// 휠
				} else if(btn == MouseEvent.BUTTON2) {
					lblRight.setText("Button2");
				// 오른쪽
				} else if(btn == MouseEvent.BUTTON3) {
					lblRight.setText("Button3");
				}
			}
		});

	}
	private void setStatus(int x, int y) {
		lblStatus.setText("status : " + x + ", " + y);
	}
	private void showFrame() {
		setTitle("MouseEvent Ex");
		setSize(600, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MouseEventEx();
	}
}
