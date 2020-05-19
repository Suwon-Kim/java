import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Test6 extends JFrame {
	private JRadioButton rbtnMook;
	private JRadioButton rbtnZzi;
	private JRadioButton rbtnFa;
	
	private int randomNum;
	
	private JButton btnStart;
	
	private JTextArea tfResult;
	
	public final static int MOOK = 0;
	public final static int ZZI = 1;
	public final static int FA = 2;
	
	private Test6() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	private void init() {
		
		rbtnMook = new JRadioButton("묵");
		rbtnZzi = new JRadioButton("찌");
		rbtnFa = new JRadioButton("빠");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnMook);
		group.add(rbtnZzi);
		group.add(rbtnFa);
		
		btnStart = new JButton("시작");
		tfResult = new JTextArea(5,5);
		
	}
	private void setDisplay() {
		JPanel pnlMJB = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		pnlMJB.add(rbtnMook);
		pnlMJB.add(rbtnZzi);
		pnlMJB.add(rbtnFa);
		
		JPanel pnlStart = new JPanel();
		
		pnlStart.add(btnStart);
		
		add(pnlMJB, BorderLayout.NORTH);
		add(pnlStart, BorderLayout.CENTER);
		add(tfResult, BorderLayout.SOUTH);
	}
	private void addListeners() {
		ItemListener IListener = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ie) {
				Object src = ie.getSource();
				String ment = "당신 : 빠\n";
				if(src == rbtnMook) {
					ment = "당신 : 묵\n";
					if(randomNum == 1) {
						tfResult.append("당신이 졌습니다.");
					} else if(randomNum == 2) {
						tfResult.append("비겼습니다.");
					} else {
						tfResult.append("당신이 이겼습니다.");
					}
					
				} else if(src == rbtnZzi) {
					ment = "당신 : 찌\n";
				}
				tfResult.setText(ment);
			}
		};
		
		ActionListener aListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				randomNum = (int) (Math.random() * 3) + 1;
				if(randomNum == 1) {
					tfResult.append("컴퓨터 : 빠\n");
				} else if (randomNum == 2) {
					tfResult.append("컴퓨터 : 묵\n");
				} else {
					tfResult.append("컴퓨터 : 찌\n");
				}
			}
		};
		
		btnStart.addActionListener(aListener);
		rbtnMook.addItemListener(IListener);
		rbtnZzi.addItemListener(IListener);
		rbtnFa.addItemListener(IListener);
		
	}
	private void showFrame() {
		setTitle("MJBGame");
		setSize(300,200);
		setLocation(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test6();
	}
}
