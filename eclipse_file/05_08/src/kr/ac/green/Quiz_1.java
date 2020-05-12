package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Quiz_1 extends JFrame {
	private JLabel lblHello;
	
	private AbstractBorder abKind;
	private AbstractBorder abTopping;
	private AbstractBorder abSize;
	
	private JCheckBox[] cbKind;
	
	private JRadioButton[] rbTopping;
	
	private JCheckBox[] cbSize;
	
	private JButton btnOrder; 
	private JButton btnCancel;
	private JPanel pnlMenu;
	private JPanel pnlTopping;
	private JPanel pnlSize;
	
	private final static Dimension size = new Dimension(89, 130);
	public Quiz_1() {
		init();
		display();
		showFrame();
	}
	private void init() {
		lblHello = new JLabel("�ڹ����ڿ� ���Ű��� ȯ���մϴ�.");
		
		
		AbstractBorder border = new LineBorder(Color.BLACK, 1);
		abKind = new TitledBorder(border, "����");
		
		pnlMenu = new JPanel(new GridLayout(0, 1));
		pnlMenu.setBorder(abKind);
		pnlMenu.setPreferredSize(size);
		String[] menu = {"�޺�", "��������", "�Ұ��"};
		
		JCheckBox[] cbKind = new JCheckBox[menu.length];
		for(int i = 0; i < cbKind.length; i++) {
			cbKind[i] = new JCheckBox(menu[i]);
			pnlMenu.add(cbKind[i]);
		}
		
		abTopping = new TitledBorder(border, "����");
		
		pnlTopping = new JPanel(new GridLayout(0, 1));
		pnlTopping.setBorder(abKind);
		String[] topping = {"�Ǹ�", "ġ��", "����δ�", "������"};
		
		JRadioButton[] rbTopping = new JRadioButton[topping.length];
		ButtonGroup group = new ButtonGroup();
		for(int i = 0; i < rbTopping.length; i++) {
			rbTopping[i] = new JRadioButton(topping[i]);
			pnlTopping.add(rbTopping[i]);
			group.add(rbTopping[i]);
		}
		
		abSize = new TitledBorder(border, "ũ��");
		
		pnlSize = new JPanel(new GridLayout(0, 1));
		pnlSize.setBorder(abKind);
		pnlSize.setPreferredSize(size);
		String[] size = {"small", "medium", "large"};
		
		JCheckBox[] cbSize = new JCheckBox[size.length];
		for(int i = 0; i < size.length; i++) {
			cbSize[i] = new JCheckBox(size[i]);
			pnlSize.add(cbSize[i]);
		}
	}
	private void display() {
		JPanel pnlNorth = new JPanel();
		pnlNorth.add(lblHello);
		
		
		JPanel pnlCenter = new JPanel();
		
		pnlCenter.add(pnlMenu);
		pnlCenter.add(pnlTopping);
		pnlCenter.add(pnlSize);
		
		JPanel pnlKind = new JPanel(new GridLayout(0,1));
		
		pnlKind.setBorder(abKind);
		JPanel pnlTopping = new JPanel(new GridLayout(0,1));
		JPanel pnlSize = new JPanel(new GridLayout(0, 1));
		
		
		JPanel pnlSouth = new JPanel();
		btnOrder = new JButton("�ֹ�");
		btnCancel = new JButton("���");
		pnlSouth.add(btnOrder);
		pnlSouth.add(btnCancel);
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	
	private void showFrame() {
		setTitle("�����ֹ�");
		pack();
		setLocation(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		System.out.println(pnlTopping.getSize());
	}
		
	
	public static void main(String[] args) {
		new Quiz_1();
	}
}