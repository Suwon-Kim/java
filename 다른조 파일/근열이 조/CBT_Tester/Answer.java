import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

//답을 선택하는 클래스

public class Answer extends JPanel {
	public static final int MAX_NUM = 5;
	
	private JRadioButton[] rbtn;
	private JTextField[] tf;
	
	public JRadioButton[] getRbtn() {
		return rbtn;
	}

	public void setRbtn(JRadioButton[] rbtn) {
		this.rbtn = rbtn;
	}

	public JTextField[] getTf() {
		return tf;
	}

	public void setTf(JTextField[] tf) {
		this.tf = tf;
	}

	public Answer(){
		init();
		setDisplay();
		addListeners();
	}
	
	private void init() {
		rbtn = new JRadioButton[MAX_NUM];
		tf = new JTextField[MAX_NUM];
		
		ButtonGroup group = new ButtonGroup();
		for(int idx = 0; idx < MAX_NUM; idx++) {
			rbtn[idx] = new JRadioButton();
			rbtn[idx].setBackground(new Color(0x42984d));
			tf[idx] = new JTextField(36);
			
			group.add(rbtn[idx]);
		}
	}

	private void setDisplay() {
		setLayout(new GridLayout(0 , 1));
		JPanel[] pnl = new JPanel[MAX_NUM];
		for(int idx = 0; idx < MAX_NUM; idx++) {
			pnl[idx] = new JPanel(new FlowLayout(FlowLayout.LEFT));
			pnl[idx].add(rbtn[idx]);
			pnl[idx].add(tf[idx]);
			pnl[idx].setBackground(new Color(0x42984d));
			add(pnl[idx]);
		}
		
	}

	private void addListeners() {
		
	}

	
}
