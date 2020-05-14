package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class MJBGame extends JFrame {
	public static final int WIN_CASE1 = -1;
	public static final int WIN_CASE2 = 2;
	
	private JRadioButton[] rbtns = {
			new JRadioButton("��"),
			new JRadioButton("��"),
			new JRadioButton("��")
	};
	
	//JRadioButton rbtn = new JRadioButton();
	
	private JButton btnStart;
	private JTextArea taResult;
	
	public MJBGame() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
		btnStart = new JButton("����");
		taResult = new JTextArea(4, 20);
		taResult.setEditable(false);
		ButtonGroup bg = new ButtonGroup();
		for(JRadioButton rbtn : rbtns) {
			bg.add(rbtn);
		}
	}
	private void setDisplay() {
		
		JPanel pnlNorth = new JPanel(new GridLayout(1,3));
		for(JRadioButton rbtn : rbtns) {
			pnlNorth.add(rbtn);
		}
		pnlNorth.setBorder(new EmptyBorder(0, 25, 0, 0));
		JPanel pnlCenter = new JPanel();
		pnlCenter.add(btnStart);
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(new JScrollPane(taResult), BorderLayout.SOUTH);
	}
	
	private void addListeners() {
		
	}
	
	private void showFrame() {
		setTitle("MJBGame");
		setSize(300, 200);
		setLocation(400, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MJBGame();
	}
	
}
