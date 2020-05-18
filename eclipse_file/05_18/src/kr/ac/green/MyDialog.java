package kr.ac.green;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
 * JDialog
 * 1. 메뉴를 가질 수 없다.
 * 2. base container
 * 3. 기본레이아웃 : BorderLayout
 * 4. modal 설정 가능 : 부모창의 기능동작 정지
 */
public class MyDialog extends JDialog{
	private JButton btnClose;
	private MyFrame owner;
	public MyDialog(MyFrame owner) {
		// 1. 부모창, 2. 타이틀, 3. modal여부
		super(owner, "MyDialog", false);
		this.owner = owner;
		JLabel lblInput = new JLabel("입력");
		JTextField tfInput = new JTextField(15);
		JButton btnInput = new JButton("사용하기");
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.add(lblInput);
		pnlCenter.add(tfInput);
		pnlCenter.add(btnInput);
		
		btnClose = new JButton("Close");
		
		JPanel pnl = new JPanel();
		pnl.add(btnClose);
		
		add(pnlCenter, BorderLayout.CENTER);
		add(pnl, BorderLayout.SOUTH);
		
		btnClose.addActionListener((e)-> dispose());
		
		btnInput.addActionListener((e)-> {
			String words = tfInput.getText();
			if(owner.exists(words)) {
				JOptionPane.showMessageDialog(
					MyDialog.this, 
					"이미 존재하는 값입니다.", 
					"알림", 
					JOptionPane.WARNING_MESSAGE
				);
				tfInput.requestFocus();
				tfInput.selectAll();
			} else {
				owner.add(words);
				dispose();
			}
		});
		
		setSize(300, 200);
		// 부모창의 중앙에 위치
		setLocationRelativeTo(owner);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}











