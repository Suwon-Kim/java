

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.JobAttributes;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//문제 푼 결과창
class TestResult extends JDialog {

	private JPanel pnlTab;
	private JTabbedPane tab;
	private SolveQuestion owner;
	private Vector<Problem> vec;
	private WrongAnswerPanel[] wap;
	private Vector<Problem> myVec;
	private JButton btnBack;
	private JButton btnNext;
	private JButton btnExit;

	public TestResult(SolveQuestion owner) {
		this.owner = owner;
		this.vec = owner.getVec();
		this.myVec = owner.myChoiceVec();

		init();
		createTap();
		setDisplay();
		addActionListener();
		shwoFrmae();
	}

	private void createTap() {
		tab = new JTabbedPane();
		tab.setTabPlacement(JTabbedPane.LEFT);
		wap = new WrongAnswerPanel[vec.size()];

		for (int idx = 0; idx < vec.size(); idx++) {
			wap[idx] = new WrongAnswerPanel(myVec.get(idx), vec.get(idx).getResult(), (idx + 1));
			tab.addTab(String.valueOf(idx + 1), wap[idx]);
			tab.setUI(new MyMainTabbedPaneUI());
		}
		pnlTab.setBackground(new Color(0x42984d));
		pnlTab.add(tab);
	}

	private void init() {
		pnlTab = new JPanel();
		btnBack = new JButton(new ImageIcon("before.png"));
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnNext = new JButton(new ImageIcon("next.png"));
		btnNext.setContentAreaFilled(false);
		btnNext.setBorderPainted(false);
		btnExit = new JButton("결과 저장");
		btnExit.setUI(new ButtonStyle());
		btnExit.setFont(new Font("바탕",Font.BOLD,15));
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);

	}

	private void setDisplay() {
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnBack);
		pnlSouth.add(btnNext);
		pnlSouth.add(btnExit);
		pnlSouth.setBackground(new Color(0xf0c022));
		add(pnlTab, BorderLayout.WEST);
		add(pnlSouth, BorderLayout.SOUTH);
	}

	// 버튼(뒤로,다음,종료) Listener
	private void addActionListener() {
		// Tab 인덱스 받아서 넘김
		btnBack.addActionListener((ae) -> {
			if (!(tab.getSelectedIndex() == 0)) {
				tab.setSelectedIndex(tab.getSelectedIndex() - 1);
			} else {
				JOptionPane.showMessageDialog(null, "첫 페이지 입니다.", "에러", JOptionPane.YES_OPTION);
			}
		});

		btnNext.addActionListener((ae) -> {
			if (!(tab.getSelectedIndex() + 1 == vec.size())) {
				tab.setSelectedIndex(tab.getSelectedIndex() + 1);
			} else {
				JOptionPane.showMessageDialog(null, "마지막 페이지 입니다", "에러", JOptionPane.YES_OPTION);
			}
		});

		btnExit.addActionListener((ae) -> {
			int num = JOptionPane.showConfirmDialog(this, "기록을 저장하고 종료하시겠습니까?", "저장", JOptionPane.YES_NO_OPTION);
			if (num == JOptionPane.YES_OPTION) {
				wrongAnswerSave();
			}
			dispose();
		});
	}

	protected String dataTime() {
		SimpleDateFormat asd = new SimpleDateFormat("yyyy-MM-dd(a hh:mm:ss)");
		Date today = new Date();
		String str = asd.format(today);
		return str;

	}

	private void wrongAnswerSave() {
		boolean flag = true;
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		File f = new File("wrongfile\\" + SolveQuestion.subName);
		int fileNum = 0;
		String time = dataTime();
		while (flag) {
			if (!f.exists()) {
				try {
					fos = new FileOutputStream(f);
					dos = new DataOutputStream(fos);
					for (int idx = 0; idx < wap.length; idx++) {
						dos.writeInt(wap[idx].getNUM());
						dos.writeUTF(wap[idx].getLblQuestionTilte1().getText());
						dos.writeUTF(wap[idx].getTaQuestion1().getText());
						if(wap[idx].imgDir() != null) {
							dos.writeUTF(wap[idx].imgDir());
						} else {
							dos.writeUTF("");
						}
					
						dos.writeUTF(wap[idx].getRbAnswer1().getText());
						dos.writeUTF(wap[idx].getRbAnswer2().getText());
						dos.writeUTF(wap[idx].getRbAnswer3().getText());
						dos.writeUTF(wap[idx].getRbAnswer4().getText());
						dos.writeUTF(wap[idx].getRbAnswer5().getText());
						dos.writeUTF(wap[idx].getResult());
						if(wap[idx].getMyChoiceText() != null){
							dos.writeUTF(wap[idx].getMyChoiceText());
						} else {
							dos.writeUTF("");
						}
					}
					dos.flush();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					MyUtils.closeAll(dos, fos);
				}
				flag = false;
			} else {
				String name = SolveQuestion.subName.substring(0, SolveQuestion.subName.lastIndexOf(".dat"));
				fileNum++;
				f = new File("wrongfile\\" + name + "(" + (fileNum) + ")" + ".dat");
			}
		}
	}

	private void shwoFrmae() {
		setTitle("결과 보기");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
