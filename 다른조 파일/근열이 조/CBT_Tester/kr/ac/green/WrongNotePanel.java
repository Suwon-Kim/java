
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

// 문제 패널 양식
class WrongNotePanel extends JPanel{
	private String myChoiceText;
	private JLabel lblQuestionTilte1;
	private JTextArea taQuestion1;
	private JLabel lblQuestionTitle2;
	private JRadioButton rbAnswer1;
	private JRadioButton rbAnswer2;
	private JRadioButton rbAnswer3;
	private JRadioButton rbAnswer4;
	private JRadioButton rbAnswer5;
	private Problem myPro;
	private String result;
	
	private Font font = new Font(Font.SANS_SERIF, Font.BOLD, 15);
	public final int NUM;

	public WrongNotePanel(Problem myPro, int num, String result) {
		this.myPro = myPro;
		NUM = num;
		this.result = result;
		init();
		setDisplay();
//		System.out.println(myPro.getImageDir());
	}
	
	private void init() {	
		lblQuestionTilte1 = new JLabel(myPro.getQuestionTitle1(), JLabel.LEFT);
		lblQuestionTilte1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		taQuestion1 = new JTextArea(myPro.getQuestionTitle2(), 4, 32);
		taQuestion1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		taQuestion1.setEditable(false);
		Image img = Toolkit.getDefaultToolkit().getImage(myPro.getImageDir());
		Image newSizeImg = img.getScaledInstance(400, 250, Image.SCALE_AREA_AVERAGING);	
		lblQuestionTitle2 = new JLabel(new ImageIcon(newSizeImg), JLabel.LEFT);	
		
		ButtonGroup group = new ButtonGroup();
		rbAnswer1 = new JRadioButton(myPro.getAnswer1());
		rbAnswer2 = new JRadioButton(myPro.getAnswer2());
		rbAnswer3 = new JRadioButton(myPro.getAnswer3());
		rbAnswer4 = new JRadioButton(myPro.getAnswer4());
		rbAnswer5 = new JRadioButton(myPro.getAnswer5());

		rbAnswer1.setFont(font);
		rbAnswer2.setFont(font);
		rbAnswer3.setFont(font);
		rbAnswer4.setFont(font);
		rbAnswer5.setFont(font);
		
		if(rbAnswer1.getText().equals(myPro.getMyText())) {
			rbAnswer1.setSelected(true);
			myChoiceText = rbAnswer1.getText();
		} else if(rbAnswer2.getText().equals(myPro.getMyText())) {
			rbAnswer2.setSelected(true);
			myChoiceText = rbAnswer2.getText();
		} else if(rbAnswer3.getText().equals(myPro.getMyText())) {
			rbAnswer3.setSelected(true);
			myChoiceText = rbAnswer3.getText();
		} else if(rbAnswer4.getText().equals(myPro.getMyText())) {
			rbAnswer4.setSelected(true);
			myChoiceText = rbAnswer4.getText();
		} else if(rbAnswer5.getText().equals(myPro.getMyText())) {
			rbAnswer5.setSelected(true);
			myChoiceText = rbAnswer5.getText();
		}
		//result를 못 가져옴
		System.out.println(result);
		if(rbAnswer1.getText().equals(result)) {
			rbAnswer1.setForeground(Color.RED);
		} else if(rbAnswer2.getText().equals(result)) {
			rbAnswer2.setForeground(Color.RED);
		} else if(rbAnswer3.getText().equals(result)) {
			rbAnswer3.setForeground(Color.RED);
		} else if(rbAnswer4.getText().equals(result)) {
			rbAnswer4.setForeground(Color.RED);
		} else {
			rbAnswer5.setForeground(Color.RED);
		}
		
		group.add(rbAnswer1);
		rbAnswer1.setBackground(Color.white);
		group.add(rbAnswer2);
		rbAnswer2.setBackground(Color.white);
		group.add(rbAnswer3);
		rbAnswer3.setBackground(Color.white);
		group.add(rbAnswer4);
		rbAnswer4.setBackground(Color.white);
		group.add(rbAnswer5);
		rbAnswer5.setBackground(Color.white);
		
	}
	//North패널 메서드(문제 번호 붙임)
	private JPanel setPanelNorth() {
		JPanel pnlNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lbl = new JLabel("No:" + (NUM + 1));
		lbl.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		pnlNorth.add(lbl);
		pnlNorth.setBackground(Color.white);
		return pnlNorth;
	}
	
	//Center패널 메서드(문제 제목, 문제내용 붙임)
	private JPanel setPanelCenter() {
		
		JPanel pnlCenterTa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlCenterTa.add(taQuestion1);
		pnlCenterTa.setBackground(Color.white);
		JPanel pnlCenter = new JPanel(new BorderLayout());
		pnlCenter.setBorder(new EmptyBorder(20,20,20,20));
		pnlCenter.add(lblQuestionTilte1, BorderLayout.NORTH);
		pnlCenter.add(pnlCenterTa, BorderLayout.CENTER);
		pnlCenter.setBackground(Color.white);
		
		return pnlCenter;
	}
	
	//South패널 메서드(선택지, 사진 붙임)
	private JPanel setPanelSouth() {
		
		JPanel pnlInSouthRb = new JPanel(new GridLayout(0,1));	// 선택지 번호
		pnlInSouthRb.setBorder(new EmptyBorder(0,0,0,40));
		pnlInSouthRb.add(rbAnswer1);
		pnlInSouthRb.add(rbAnswer2);
		pnlInSouthRb.add(rbAnswer3);
		pnlInSouthRb.add(rbAnswer4);
		pnlInSouthRb.add(rbAnswer5);
		pnlInSouthRb.setBackground(Color.white);
		JPanel pnlInSouthImg = new JPanel();	// 사진
		pnlInSouthImg.add(lblQuestionTitle2);
		
		
		JPanel pnlSouth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlSouth.add(pnlInSouthRb);
		pnlSouth.add(pnlInSouthImg);
		pnlSouth.setBackground(Color.white);
		return pnlSouth;
	}
	
	private void setDisplay() {
		
		setLayout(new BorderLayout());
		
		JPanel pnlNorth = setPanelNorth();
		JPanel pnlCenter = setPanelCenter();
		JPanel pnlSouth = setPanelSouth();

		JPanel pnlMain = new JPanel(new BorderLayout());
		pnlMain.setBorder(new EmptyBorder(10, 40, 40, 40));
		pnlMain.add(pnlNorth, BorderLayout.NORTH);
		pnlMain.add(pnlCenter, BorderLayout.CENTER);
		pnlMain.add(pnlSouth, BorderLayout.SOUTH);
		pnlMain.setBackground(Color.white);
		add(pnlMain, BorderLayout.CENTER);
	}

	public JLabel getLblQuestionTilte1() {
		return lblQuestionTilte1;
	}

	public JTextArea getTaQuestion1() {
		return taQuestion1;
	}

	public JLabel getLblQuestionTitle2() {
		return lblQuestionTitle2;
	}

	public JRadioButton getRbAnswer1() {
		return rbAnswer1;
	}

	public JRadioButton getRbAnswer2() {
		return rbAnswer2;
	}

	public JRadioButton getRbAnswer3() {
		return rbAnswer3;
	}

	public JRadioButton getRbAnswer4() {
		return rbAnswer4;
	}

	public JRadioButton getRbAnswer5() {
		return rbAnswer5;
	}

	public String getResult() {
		return result;
	}
	public int getNUM() {
		return NUM;
	}
	public String getMyChoiceText() {
		return myChoiceText;
	}
}