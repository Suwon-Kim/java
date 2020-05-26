import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

class LottoPaper extends JFrame {
	private JLabel lblRound;
	private JLabel[] lblNums;
	
	private JPanel pnlRound;
	
	private JRadioButton rbtnAuto;
	private JRadioButton rbtnHand;
	
	public LottoPaper() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	private void init() {
		lblRound = new JLabel("회차");
		lblNums = new JLabel[45];	//배열의 길이만 45라고 선언된 상태
		for(int idx = 0; idx < lblNums.length; idx++) {
			lblNums[idx] = new JLabel(String.valueOf(idx + 1), JLabel.CENTER);
			lblNums[idx].setPreferredSize(new Dimension(20,20));
			lblNums[idx].setBorder(new LineBorder(Color.RED));
		}
		
		
		rbtnAuto = new JRadioButton("자동");
		rbtnHand = new JRadioButton("수동",false);
		
	}
	private void setDisplay() {
		JPanel pnlSouth = new JPanel();
		JPanel pnlCenter = new JPanel(new GridLayout(7,7));
		pnlCenter.setPreferredSize(new Dimension(250,300));
		
		for(int idx = 0; idx < lblNums.length; idx++) {
			pnlCenter.add(lblNums[idx]);
		}
		
		// JPanel pnlLine = new JPanel();
		JPanel[] pnlLine = new JPanel[7];
		
		JPanel pnlNorth = new JPanel();
		
		pnlNorth.add(lblRound);
		pnlSouth.add(rbtnAuto);
		pnlSouth.add(rbtnHand);
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	
	}
	private void addListeners() {
		
	}
	private void showFrame() {
		setTitle("로또 용지");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new LottoPaper();
	}
} 