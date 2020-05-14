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
	
	//라디오박스, 체크박스 사용할때 쓴다.
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
		
		//그룹을 표현하기 위해 존재 (눈에 안보임) 라디오 버튼은
		//여러개 중에 하나만을 표현하기 때문에
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnRed);
		group.add(rbtnGreen);
		group.add(rbtnBlue);
		
		lblColor = new JLabel();
		//레이블은 바로 색깔을 가질 수 없어서 투명으로 만들어줘야함
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
//		//어차피 아이템리스너고, 어차피 스테이트체인지고 어차피 아이템 이벤트임
		//ie를 파라미터로 잡아넣습니다.
		
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
						"종료하시겠습니까?",
						"응답하라",
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
//						"이름을 입력해주세요",
//						"입력",
//						JOptionPane.QUESTION_MESSAGE
//					);
//				} while(name == null || name.trim().length() == 0);
//				setTitle(name + "님 환영합니다.");
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
