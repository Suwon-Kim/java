package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopupEx extends JFrame {
	private JPopupMenu pMenu;
	private JLabel lblMain;
	public PopupEx() {
		lblMain = new JLabel("Start", JLabel.CENTER);
		lblMain.setFont(new Font(Font.SERIF, Font.BOLD, 40));
		
		pMenu = new JPopupMenu();
		JMenuItem miApple = new JMenuItem("Apple");
		JMenuItem miBanana = new JMenuItem("Banana");
		JMenuItem miKiwi = new JMenuItem("Kiwi");
		
		pMenu.add(miApple);
		pMenu.addSeparator();
		pMenu.add(miBanana);
		pMenu.addSeparator();
		pMenu.add(miKiwi);
		
		add(lblMain, BorderLayout.CENTER);
		
		// 팝업메뉴 보이게 만들기 (MouseEvent)
		lblMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				showPopup(me);
			}
			@Override
			public void mouseReleased(MouseEvent me) {
				showPopup(me);
			}
		});
		
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				lblMain.setText(ae.getActionCommand());
			}
		};
		
		miApple.addActionListener(listener);
		miBanana.addActionListener(listener);
		miKiwi.addActionListener(listener);
		
		setTitle("PopupMenuEx");
		setSize(400, 300);
		setLocation(100,0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void showPopup(MouseEvent me) {
		// 버튼 + 시점 
		//팝업 신호가 맞는지
		if(me.isPopupTrigger()) {
			pMenu.show(lblMain, me.getX(), me.getY());
		}
	}
	public static void main(String[] args) {
		new PopupEx();
	}
}
