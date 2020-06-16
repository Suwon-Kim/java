import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

//문제 패널 양식
class WrongAnswerPanel extends JPanel {
	public static final int MAX_NUMBER = 5;
	private JLabel lblPro;
	private JLabel lblSubjectNum;
	private JTextField tfQuestionTilte1;
	private JTextArea taQuestion1;
	private JLabel lblFileImage;
	private JTextField[] tfAnswer;
	private JRadioButton[] rbAnswer;
	private JPanel[] pnlAnswer;
	private Problem pro;

	public JLabel getLblPro() {
		return lblPro;
	}

	public WrongAnswerPanel(Problem pro) {

		this.pro = pro;
		init();
		setDisplay();
		stateCheck();

	}

	private Image imageSizeControl(String dir) {
		
		Image img = Toolkit.getDefaultToolkit().getImage(dir);
		Image newSizeImg = img.getScaledInstance(400, 250, Image.SCALE_AREA_AVERAGING);
		return newSizeImg;
	}

	private void init() {
		lblPro = new JLabel("No:");
		lblPro.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		lblPro.setForeground(Color.BLUE);
		lblSubjectNum = new JLabel("" + ProblemTotalPage.TabNum, JLabel.LEFT);

		tfQuestionTilte1 = new JTextField(pro.getQuestionTitle1());
		tfQuestionTilte1.setFont(new Font(Font.DIALOG, Font.BOLD, 20));

		String name = new String(pro.getQuestionTitle2());

		taQuestion1 = new JTextArea(5, 60);
		taQuestion1.setText(name);
		taQuestion1.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
		taQuestion1.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1), "문제"));

		lblFileImage = new JLabel(new ImageIcon(imageSizeControl(pro.getImageDir())));
		ButtonGroup group = new ButtonGroup();
		tfAnswer = new JTextField[MAX_NUMBER];
		rbAnswer = new JRadioButton[MAX_NUMBER];
		pnlAnswer = new JPanel[MAX_NUMBER];

		String[] str = pro.textReturn();
		for (int idx = 0; idx < MAX_NUMBER; idx++) {
			tfAnswer[idx] = new JTextField(30);
			tfAnswer[idx].setText(str[idx]);
			rbAnswer[idx] = new JRadioButton();
			group.add(rbAnswer[idx]);
		}
		findAnswer();
	}
	

	private void findAnswer() {
		for (int idx = 0; idx < MAX_NUMBER; idx++) {
			if (pro.getResult().equals(tfAnswer[idx].getText())) {
				rbAnswer[idx].setSelected(true);
			}

		}
	}

	protected Problem returnProblem() {
		String str = null;
		for (int i = 0; i < rbAnswer.length; i++) {
			if (rbAnswer[i].isSelected()) {
				str = tfAnswer[i].getText();
			}
		}
		String a = pro.getImageDir();

		Problem pro = new Problem(Integer.parseInt(lblSubjectNum.getText()), tfQuestionTilte1.getText(),
				taQuestion1.getText(), a, tfAnswer[0].getText(), tfAnswer[1].getText(), tfAnswer[2].getText(),
				tfAnswer[3].getText(), tfAnswer[4].getText(), str);

		return pro;
	}

	protected void setNewImageReset(File file) {
		lblFileImage.setIcon(new ImageIcon(imageSizeControl(file.getPath())));
	}

	protected void setNewImageReset() {
		lblFileImage.setIcon(null);
	}

	private void stateCheck() {
		DocumentListener lister = new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				lblPro.setText("*" + "No:");

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				lblPro.setText("*" + "No:");
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		};
		for (int i = 0; i < tfAnswer.length; i++) {
			Document tfa = tfAnswer[i].getDocument();
			tfa.addDocumentListener(lister);
		}
		Document ta = taQuestion1.getDocument();
		ta.addDocumentListener(lister);
		Document tft = tfQuestionTilte1.getDocument();
		tft.addDocumentListener(lister);
	}

	private void setDisplay() {

		JPanel pnlNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlNorth.add(lblPro);
		pnlNorth.add(lblSubjectNum);

		JPanel pnlCenter = new JPanel(new BorderLayout());
		JPanel pnlCenterTa = new JPanel();
		pnlCenterTa.add(taQuestion1);
		pnlCenter.add(tfQuestionTilte1, BorderLayout.NORTH);
		pnlCenter.add(pnlCenterTa, BorderLayout.CENTER);
		
		JPanel pnlInSouthRb = new JPanel(new GridLayout(0,1));
		JPanel pnlInSouthImg = new JPanel();
		JPanel pnlSouth = new JPanel(new GridLayout(1, 2));
		for (int idx = 0; idx < 5; idx++) {
			pnlAnswer[idx] = new JPanel(new FlowLayout(FlowLayout.LEFT));
			pnlAnswer[idx].add(rbAnswer[idx]);
			pnlAnswer[idx].add(tfAnswer[idx]);		
			pnlInSouthRb.add(pnlAnswer[idx]);			
		}
		pnlInSouthImg.add(lblFileImage);
		pnlSouth.add(pnlInSouthRb);
		pnlSouth.add(pnlInSouthImg);
		setLayout(new BorderLayout());
		JPanel pnlMain = new JPanel(new BorderLayout());
		pnlMain.setBorder(new EmptyBorder(10, 40, 40, 40));

		pnlMain.add(pnlNorth, BorderLayout.NORTH);
		pnlMain.add(pnlCenter, BorderLayout.CENTER);
		pnlMain.add(pnlSouth, BorderLayout.SOUTH);
		add(pnlMain, BorderLayout.CENTER);

	}

}