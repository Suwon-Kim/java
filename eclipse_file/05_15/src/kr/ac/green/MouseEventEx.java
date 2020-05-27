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
		// �ǽð� ȭ�� ����
		sp.setContinuousLayout(true);
		// Left(HORIZONTAL_SPLIT), Top(VERTICAL_SPLIT) ����, ȭ����� ����
		sp.setResizeWeight(0.3);		
		// Divider �ʺ� ����
		sp.setDividerSize(10);
		// ����ġ....�غ���..
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
				//  ����
				if(btn == MouseEvent.BUTTON1) {
					lblRight.setText("Button1");
					if(e.getClickCount() == 2) {
						// �̺�Ʈ �ҽ� ���� ��ǥ
						setStatus(e.getX(), e.getY());
						// ȭ����� ��ǥ
						System.out.println("x :" + e.getXOnScreen());
						System.out.println("y :" + e.getYOnScreen());
						lblRight.setText("double click");
					}
				// ��
				} else if(btn == MouseEvent.BUTTON2) {
					lblRight.setText("Button2");
				// ������
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