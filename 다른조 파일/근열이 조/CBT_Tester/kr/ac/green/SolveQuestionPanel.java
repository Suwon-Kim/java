

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

//	����Ǫ�� �г�
class SolveQuestionPanel extends JPanel {
	
	private Font font = new Font(Font.DIALOG, Font.BOLD, 23);
	private Problem pro;
	private JLabel lblSubjectNum;
	private JLabel lblNum;
	private JTextArea taQuestion1;
	private JLabel lblQuestionTitle2;
	private JRadioButton[] rbAnswer;
	private JLabel lblQuestionTitile;
	private JPanel[] pnlAnswer;
	public static final int MAX_NUMBER = 5;
	public static final int QNUM = 1;
	
	public SolveQuestionPanel(Problem pro) {
		this.pro = pro;
		init();
		setDisplay();
	}
	
	private void init() {
		lblNum = new JLabel("����  ");
		lblNum.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
		lblSubjectNum = new JLabel(String.valueOf(pro.getSubjectNum()+1));
		lblSubjectNum.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
		lblSubjectNum.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		lblQuestionTitile = new JLabel(pro.getQuestionTitle1());	//���� ����
		lblQuestionTitile.setFont(new Font(Font.SERIF, Font.BOLD, 25));

		taQuestion1 = new JTextArea(pro.getQuestionTitle2(),5,40);	// ��������
		taQuestion1.setFont(new Font(Font.SERIF, Font.PLAIN, 23));
		taQuestion1.setBackground(null);
		taQuestion1.setBorder(new LineBorder(Color.DARK_GRAY,1));
		taQuestion1.setEditable(false);

		if(pro.getImageDir().trim().length() != 0) {
			Image img = Toolkit.getDefaultToolkit().getImage(pro.getImageDir());
			Image newSizeImg = img.getScaledInstance(400, 250, Image.SCALE_AREA_AVERAGING);	
			lblQuestionTitle2 = new JLabel(new ImageIcon(newSizeImg), JLabel.LEFT);//����
		} else {
			lblQuestionTitle2 = new JLabel("");
		}
		
		ButtonGroup group = new ButtonGroup();
		
		rbAnswer = new JRadioButton[MAX_NUMBER]; // ������5�� (���� ��ư)
		String[] rb = new String[MAX_NUMBER];
		for(int i=0; i < rb.length; i++) {
			rb[i] = (i+1)+"";
		}
		
		for(int idx = 0; idx < MAX_NUMBER; idx++) {
			
			if(rbAnswer[idx] == rbAnswer[0]) {
				rbAnswer[idx] = new JRadioButton(pro.getAnswer1());
			}else if(rbAnswer[idx] == rbAnswer[1]) {
				rbAnswer[idx] = new JRadioButton(pro.getAnswer2());
			}else if(rbAnswer[idx] == rbAnswer[2]) {
				rbAnswer[idx] = new JRadioButton(pro.getAnswer3());
			}else if(rbAnswer[idx] == rbAnswer[3]) {
				rbAnswer[idx] = new JRadioButton(pro.getAnswer4());
			}else {
				rbAnswer[idx] = new JRadioButton(pro.getAnswer5());
			}
			rbAnswer[idx].setFont(font);
			group.add(rbAnswer[idx]);
		}
	}
	// North�г�( �������� ,���� ����, ���� ����)
	private JPanel setPanelNorth() {
		
		JPanel pnlNorth = new JPanel(new BorderLayout());
		JPanel pnlNorthInLabel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlNorthInLabel.add(lblNum);
		pnlNorthInLabel.add(lblSubjectNum);
		pnlNorth.add(pnlNorthInLabel,BorderLayout.NORTH);	//���� ��ȣ
		pnlNorth.add(lblQuestionTitile, BorderLayout.CENTER);	//���� ����
		
		if(taQuestion1.getText().trim().length() != 0) {
			JPanel pnlTa = new JPanel(new FlowLayout(FlowLayout.LEFT));
			pnlTa.add(taQuestion1);	//���� ����
			pnlTa.setBorder(new EmptyBorder(20,20,0,20));
			pnlNorth.add(pnlTa, BorderLayout.CENTER);
		}
		
		return pnlNorth;
	}
	//South�г�(������1~5, ����)
	private JPanel setPanelSouth() {
		
		JPanel pnlInSouthRb = new JPanel(new GridLayout(0,1));	// ������ �г�
		pnlInSouthRb.setBorder(new EmptyBorder(0,0,0,40));
		
		JPanel pnlInSouthImg = new JPanel();	//���� �г�
		JPanel pnlSouth = new JPanel(new FlowLayout(FlowLayout.LEFT));

		for (int idx = 0; idx < MAX_NUMBER; idx++) {
			pnlAnswer = new JPanel[MAX_NUMBER];
			pnlAnswer[idx] = new JPanel(new FlowLayout(FlowLayout.LEFT));
			pnlAnswer[idx].add(rbAnswer[idx]);	
			pnlInSouthRb.add(pnlAnswer[idx]);			
		}

		pnlSouth.add(pnlInSouthRb);
		pnlSouth.add(lblQuestionTitle2);
		
		return pnlSouth;
	}
	
	private JPanel setPanelCenter() {
		
		JPanel pnlCenter = new JPanel(new BorderLayout());

		JPanel pnlCenterTa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlCenterTa.add(taQuestion1);	//���� ����
		pnlCenter.add(lblQuestionTitile, BorderLayout.NORTH);	//���� ����
		pnlCenter.add(pnlCenterTa, BorderLayout.CENTER);
		
		return pnlCenter;
	}
	//Ǭ ���� �� ������ ����
	private String getResult() {
		
		String result = null;
		for(int idx = 0; idx < MAX_NUMBER; idx++) {
			if(rbAnswer[idx].isSelected()) {
				result = rbAnswer[idx].getText();
				idx = MAX_NUMBER;
			}
		}
		return result;
	}
	// ���� Ǭ ���� ���� ���� ���� �޼���
	protected Problem myChoiceNumber() {
		
		Problem pro = new Problem(
			Integer.parseInt(lblSubjectNum.getText()),
			lblQuestionTitile.getText(),
			taQuestion1.getText(),
			this.pro.getImageDir(),
			rbAnswer[0].getText(),
			rbAnswer[1].getText(),
			rbAnswer[2].getText(),
			rbAnswer[3].getText(),
			rbAnswer[4].getText(),
			getResult()
		);
		
		return pro;
	}
	
	private void setDisplay() {
		
		JPanel pnlNorth = setPanelNorth();
		JPanel pnlCenter = setPanelCenter();
		JPanel pnlSouth= setPanelSouth();
	
		setLayout(new BorderLayout());
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
		
	}
}
