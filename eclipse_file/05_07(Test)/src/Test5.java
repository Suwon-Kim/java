import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Test5 extends JFrame {
	private JRadioButton rbtnRed;
	private JRadioButton rbtnGreen;
	private JRadioButton rbtnBlue;
	
	private JLabel lblColor;
	
	private String name;
	
	public Test5() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
		rbtnRed = new JRadioButton("Red",true);
		rbtnGreen = new JRadioButton("Green");
		rbtnBlue = new JRadioButton("Blue");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnBlue);
		group.add(rbtnGreen);
		group.add(rbtnRed);
		
		lblColor = new JLabel();
		lblColor.setOpaque(true);
		lblColor.setBackground(Color.YELLOW);
		lblColor.setBorder(new TitledBorder(new LineBorder(Color.red, 5),"Color Display"));
				

		
	}
	private void setDisplay() {
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(rbtnBlue);
		pnlSouth.add(rbtnGreen);
		pnlSouth.add(rbtnRed);
		
		add(lblColor, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	//ActionListener -- > 버튼 관련
	//MouseListener -- > 마우스 관련
	//ItemListener -- > 라디오 관련
	private void addListeners() {
		ItemListener listener = (ie) ->  {
			if(ie.getStateChange() == ItemEvent.SELECTED) {
				Object src = ie.getSource();
				Color color = Color.BLUE;
				if(src == rbtnRed) {
					color = Color.RED;
				} else if(src == rbtnGreen) {
					color = Color.GREEN;
				}
				lblColor.setBackground(color);
			}	
		};
		
		rbtnRed.addItemListener(listener);
		rbtnGreen.addItemListener(listener);
		rbtnBlue.addItemListener(listener);
	}
	private void showFrame() {
		setTitle("창");
		setSize(400,300);
		setLocation(100,0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test5();
	}
}
