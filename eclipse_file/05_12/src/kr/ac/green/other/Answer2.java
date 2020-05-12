
package kr.ac.green.other;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
/*
 *  1 mile == 1.6km
 */
public class Answer2 extends JFrame implements ActionListener {

	private JLabel lblInput;
	private JTextField tfInput;
	
	private JButton btnCalc;
	
	private JTextField tfResult;
	
	public Answer2() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
		lblInput = new JLabel("거리를 마일단위로 입력하시오");
		tfInput = new JTextField(5);
		btnCalc = new JButton("변환");
		tfResult = new JTextField(15);
		tfResult.setEditable(false);
		tfResult.setBackground(Color.PINK);
		tfResult.setBorder(new LineBorder(Color.BLACK, 2));
	}

	private void setDisplay() {
		JPanel pnlNorth = new JPanel();
		pnlNorth.add(lblInput);
		pnlNorth.add(tfInput);
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.add(btnCalc);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(tfResult);
		
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	
	public void addListeners() {
		btnCalc.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		String msg = "";
		try {
			double mile = Double.parseDouble(tfInput.getText());
			double km = mile * 1.6;
			msg = km + "km";
		} catch (NumberFormatException e) {
			msg = "숫자만 입력 가능합니다.";
			
			/*
			 * 사용가능 아이콘 플레그
			 * JOptionPane.ERROR_MESSAGE
			 * JOptionPane.WARNING_MESSAGE
			 * JOptionPane.INFORMATION_MESSAGE
			 * JOptionPane.QUESTION_MESSAGE
			 * JOptionPane.PLANIN_MESSAGE
			 */
			
			JOptionPane.showMessageDialog(
					this, 	//부모창
					msg,  	// 메세지
					"장난?",	// 타이틀
					JOptionPane.ERROR_MESSAGE	// 아이콘 
			);
		}
		tfResult.setText(msg);
		
	}
	public JTextField getText() {
		return tfResult;
	}

	private void showFrame() {
		setTitle("마일을 킬로미터로 변환");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 창크기 고정
		setResizable(false);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new Answer2();
	}
}