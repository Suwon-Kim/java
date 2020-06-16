

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

class MyloadPanel extends JPanel {
	private Vector<Problem> vec;
	private JPanel pnlMain;
	private JLabel lblInfo;
	private JButton btnCheck;
	
	private JLabel lbl;
	private String str;
	
	public MyloadPanel(String str,String name, Vector<Problem> vec){
		this.vec = vec;
		this.str = str;
		init(name,str);
		setDisplay();
		addListeners();
	}
	
	private void init(String name ,String str) {

		Font font = new Font("메이플스토리", Font.PLAIN,15);
		pnlMain = new JPanel(new BorderLayout());
		btnCheck = new JButton("문제 보기");
		btnCheck.setUI(new ButtonStyle());
		btnCheck.setFont(font);
		
		lbl = new JLabel(str);
		lbl.setFont(new Font("돋움",Font.PLAIN,13));
		lblInfo = new JLabel(name);
		lblInfo.setFont(new Font("돋움",Font.PLAIN,15));
		
	}
	
	private void setDisplay() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnlbtn = new JPanel();
		pnlbtn.setBackground(new Color(0x42984d));
		pnlbtn.add(btnCheck);
		pnlMain.add(lblInfo, BorderLayout.NORTH);
		pnlMain.add(lbl, BorderLayout.SOUTH);
		pnlMain.setPreferredSize(new Dimension(200,40));
		pnlMain.setBorder(new LineBorder(new Color(0xf0c022)));
		pnlMain.setBackground(new Color(0xf0c022));
		add(pnlMain,BorderLayout.NORTH);
		add(pnlbtn, BorderLayout.EAST);
	}
	
	private void addListeners() {
		btnCheck.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new WrongAnswer(vec);
			}
		});

	}
}
