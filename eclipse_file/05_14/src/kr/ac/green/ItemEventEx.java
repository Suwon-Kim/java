package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ItemEventEx extends JFrame {
	
	//�����ڽ�, üũ�ڽ� ����Ҷ� ����.
	private JRadioButton rbtnRed;
	private JRadioButton rbtnGreen;
	private JRadioButton rbtnBlue;
	
	private JLabel lblColor;
	
	private String name;
	
	public ItemEventEx() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	private void init() {
		rbtnRed = new JRadioButton("Red", true);
		rbtnGreen = new JRadioButton("Green");
		rbtnBlue = new JRadioButton("Blue");
		
		//�׷��� ǥ���ϱ� ���� ���� (���� �Ⱥ���) ���� ��ư��
		//������ �߿� �ϳ����� ǥ���ϱ� ������
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnRed);
		group.add(rbtnGreen);
		group.add(rbtnBlue);
		
		lblColor = new JLabel();
		//���̺��� �ٷ� ������ ���� �� ��� �������� ����������
		lblColor.setOpaque(true);
		lblColor.setBackground(Color.RED);
		lblColor.setBorder(new TitledBorder(
				new LineBorder(Color.GRAY, 1),
				"Color Display"
		));
		
	}
	private void setDisplay() {
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(rbtnRed);
		pnlSouth.add(rbtnGreen);
		pnlSouth.add(rbtnBlue);
		
		add(lblColor, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	private void addListeners() {
		
		/*
		ActionListener listener = (ae) -> {
			JRadioButton btn = (JRadioButton)ae.getSource();
			System.out.println(btn.getText());
			
		};
		
		rbtnRed.addActionListener(listener);
		rbtnBlue.addActionListener(listener);
		*/
		
//		ItemListener listener = new ItemListener() {
//			@Override
//			public void itemStateChanged(ItemEvent ie) {
//				
//				if(ie.getStateChange() == ItemEvent.SELECTED) {
//					Object src = ie.getSource();
//					Color color = Color.BLUE;
//					if(src == rbtnRed) {
//						color = Color.RED;
//					} else if (src == rbtnGreen) {
//						color = Color.GREEN;
//					} 
//					lblColor.setBackground(color);
//				} 
//			}
//		};
//		//������ �����۸����ʰ�, ������ ������Ʈü������ ������ ������ �̺�Ʈ��
		//ie�� �Ķ���ͷ� ��Ƴֽ��ϴ�.
		
		ItemListener listener = (ie) -> {
			if(ie.getStateChange() == ItemEvent.SELECTED) {
				Object src = ie.getSource();
				Color color = Color.BLUE;
				if(src == rbtnRed) {
					color = Color.RED;
				} else if (src == rbtnGreen) {
					color = Color.GREEN;
				} 
				lblColor.setBackground(color);
			} 
		};
			
		
		
		rbtnRed.addItemListener(listener);
		rbtnGreen.addItemListener(listener);
		rbtnBlue.addItemListener(listener);
		
		/*
		rbtnRed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("RED");
			}
		});
		*/
		//rbtnBlue.addActionListener((ae) -> System.out.println("BLUE"));
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				int result = JOptionPane.showConfirmDialog(
						ItemEventEx.this,
						"�����Ͻðڽ��ϱ�?",
						"�����϶�",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE
				);
				if(result == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
			
//			@Override
//			public void windowOpened(WindowEvent we) {
//				do {
//				name = JOptionPane.showInputDialog(
//						ItemEventEx.this,
//						"�̸��� �Է����ּ���",
//						"�Է�",
//						JOptionPane.QUESTION_MESSAGE
//					);
//				} while(name == null || name.trim().length() == 0);
//				setTitle(name + "�� ȯ���մϴ�.");
//			}	
		});
	}
	private void showFrame() {
		
		setSize(400, 300);
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ItemEventEx();
	}
}