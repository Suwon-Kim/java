package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class ItemEventEx1 extends JFrame {
	private JRadioButton rbtnMook;
	private JRadioButton rbtnZzi;
	private JRadioButton rbtnFa;
	private int randomNum;

	
	private JButton btnStart;
	
	private JTextArea tfResult;
	
	public final static int MOOK = 0;
	public final static int ZZI = 1;
	public final static int FA = 2;
	
	public ItemEventEx1() {
		init();
		setDisplay();
		showFrame();
		addListener();
	}
	private void init() {
		rbtnMook = new JRadioButton("��");
		rbtnZzi = new JRadioButton("��");
		rbtnFa = new JRadioButton("��");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnMook);
		group.add(rbtnZzi);
		group.add(rbtnFa);
		
		btnStart = new JButton("����");
		
		tfResult = new JTextArea(4,4);
	}
	
	private void setDisplay() {
		JPanel pnlMJB = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		pnlMJB.add(rbtnMook);
		pnlMJB.add(rbtnZzi);
		pnlMJB.add(rbtnFa);
		
		add(pnlMJB, BorderLayout.NORTH);
		JPanel pnlstart = new JPanel();
		pnlstart.add(btnStart);
		add(pnlstart, BorderLayout.CENTER);
		add(tfResult, BorderLayout.SOUTH);
			
	}
	private void addListener() {
//		ItemListener item_Listener = new ItemListener(){
//			@Override
//			public void itemStateChanged(ItemEvent ie) {
//						
//					Object src = ie.getSource();
//					String ment = "��� : ��";
//					
//					if(src == rbtnMook) {
//						ment = "��� : ��";
//					} else if (src == rbtnZzi) {
//						ment = "��� : ��";
//					}
//					tfResult.setText(ment);
//				}
//				
//		
//		};
//		
		ActionListener action_listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(rbtnZzi.isSelected()) {; // true
					randomNum = (int)(Math.random() * 3 + 0);
					if(randomNum == 0) {	
						tfResult.setText("��ǻ�� : ��" + "\n" + "��� : ��" + "\n" + "����� �����ϴ�." + "\n");
					} else if (randomNum == 1) {
						tfResult.setText("��ǻ�� : ��" + "\n" + "��� : ��" + "\n" + "����� �̰���ϴ�." + "\n");
					} else {
						tfResult.setText("��ǻ�� : ��" + "\n" + "��� : ��" + "\n" + "�����ϴ�." + "\n");
					}
				}
			}
		};
		
		btnStart.addActionListener(action_listener);
	}
	
	private void showFrame() {
		setTitle("MJBGame");
		setSize(300,200);
		setLocation(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ItemEventEx1();
	}
}
