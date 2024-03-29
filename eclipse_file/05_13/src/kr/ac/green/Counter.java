package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/*
 * 종료 확인 후 닫기~ : ~ 14:15
 */
public class Counter extends JFrame implements ActionListener {

	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnDefault;
	 
	private JLabel lblNum;
	
	public Counter() {
		init();
		setDisplay();
		addListener();
		showFrame();
	}
	private void init() {
		btnPlus = new JButton("Plus");
		//btnPlus.setActionCommand("더하기");
		btnMinus = new JButton("Minus");
		//btnMinus.setActionCommand("빼기");
		btnDefault = new JButton("Default");
		
		lblNum = new JLabel("0", JLabel.CENTER);
		lblNum.setFont(new Font(Font.DIALOG, Font.BOLD, 60));
	}
	private void setDisplay() {
		JPanel pnlSouth = new JPanel(new GridLayout(1, 2));
		pnlSouth.add(btnPlus);
		pnlSouth.add(btnMinus);
		
		add(btnDefault, BorderLayout.NORTH);
		add(lblNum, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	private void addListener() {
		btnPlus.addActionListener(this);
		btnMinus.addActionListener(this);
		btnDefault.addActionListener(this);
		addWindowListener(new CounterListener(this));
	}
	private void showFrame() {
		setTitle("counter");
		setSize(300, 400);
		setLocation(100, 0);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		/*
		 * 동일한 이벤트에 대해 이벤트소스를 기준으로 구분한다.
		 */
		
		//String cmd = ae.getActionCommand();
		//System.out.println(cmd);
	
		Object src = ae.getSource();
		int num = 0;
		if(src != btnDefault) {
			num = Integer.parseInt(lblNum.getText());
			if(src == btnPlus) {
				num++;
			} else {
				num--;
			}
		}
		lblNum.setText(String.valueOf(num));
	
	}
	public static void main(String[] args) {
		new Counter();	
	}
	public void closeWindow() {
		int result = JOptionPane.showConfirmDialog(
			this, 
			"종료하시겠습니까?", 
			"bye", 
			JOptionPane.OK_CANCEL_OPTION, 
			JOptionPane.INFORMATION_MESSAGE
		);
		if(result == JOptionPane.OK_OPTION){
			System.exit(0);
		}
	}
}





















