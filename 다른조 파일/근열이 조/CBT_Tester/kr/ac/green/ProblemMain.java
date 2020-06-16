

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

//���� Ǫ�� ���α׷� ����
public class ProblemMain extends JFrame {
	public static final String DIR_NAME = "wrongfile";

	private String[] filesName;
	private JComboBox<String> cmbCategory;
	private JButton btnStart;
	private JButton btnMyload;
	private Vector<Problem>[] vec;
	private Problem pro;
	private JLabel lblImg;
	private Vector<Problem>[] wrongVec;
	private Map<File,Vector<Problem>> myMap;
	private String[] wrongNames;

	public ProblemMain() {
		setFileReader();
		init();
		setDisplay();
		addListeners();
		showFrame();
	}

	// ���� ���� �о���� �޼���(�д� ��� : Problem(������))
	private void setFileReader() {
		
		
		
		File dir = new File("Problem");
		String fileA = dir.getAbsolutePath() + "\\..\\..\\..\\..\\problem";
		File qw = new File(fileA);
		

		
		File[] files = qw.listFiles(); // ��ο� �ִ� ���� �迭�� �������
		filesName = new String[files.length];
		for (int idx = 0; idx < files.length; idx++) {
			filesName[idx] = files[idx].getName();
		}

		FileInputStream fis = null;
		DataInputStream dis = null;

		vec = new Vector[filesName.length]; // vec���� �ʱ�ȭ
		for (int idx = 0; idx < vec.length; idx++) {
			try {
				vec[idx] = new Vector<Problem>();
				fis = new FileInputStream(qw + "\\" + filesName[idx]); // ����
																		// �Է°��
				dis = new DataInputStream(fis);
				while (dis.available() > 0) {
					int subjectNum = dis.readInt();
					String questionTitle1 = dis.readUTF();
					String questionTitle2 = dis.readUTF();
					String imageDir = dis.readUTF();
					String answer1 = dis.readUTF();
					String answer2 = dis.readUTF();
					String answer3 = dis.readUTF();
					String answer4 = dis.readUTF();
					String answer5 = dis.readUTF();
					String result = dis.readUTF();
					vec[idx].add(new Problem(subjectNum, questionTitle1, questionTitle2, imageDir, answer1, answer2,
							answer3, answer4, answer5, result));
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				MyUtils.closeAll(dis, fis);
			}
		}
	}

	// Component ����
	private void init() {
		try {
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) { }
		
		cmbCategory = new JComboBox<String>(filesName);
		btnStart = new JButton("���� Ǯ��");
		btnStart.setUI(new ButtonStyle());
		btnMyload = new JButton("��Ϻ���");
		btnMyload.setUI(new ButtonStyle());
		lblImg = new JLabel(new ImageIcon("mainCon.gif"));	
		
	}

	private void setDisplay() {

		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(Color.WHITE);
		pnlNorth.setBorder(new EmptyBorder(20, 20, 0, 20));
		JLabel lblCmb = new JLabel("�������� ����", JLabel.CENTER);
		lblCmb.setForeground(new Color(0x2dce98));
		lblCmb.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		pnlNorth.add(lblCmb);

		JPanel pnlCenter = new JPanel(new BorderLayout());
		pnlCenter.setBackground(Color.WHITE);
		pnlCenter.setBorder(new EmptyBorder(0, 20, 20, 20));
		pnlCenter.add(cmbCategory, BorderLayout.NORTH);
		pnlCenter.add(lblImg, BorderLayout.CENTER);

		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(Color.WHITE);
		pnlSouth.setBorder(new EmptyBorder(20, 20, 20, 20));
		pnlSouth.add(btnStart);
		pnlSouth.add(btnMyload);

		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);

	}

	private void addListeners() {

		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SolveQuestion(vec[cmbCategory.getSelectedIndex()], (String) cmbCategory.getSelectedItem());
			}
		});

		btnMyload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileReader();
				new MyLoad(myMap);
			}
		});
	}
	private void fileReader() {
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		File dirFile = new File(DIR_NAME);
		File[] f = dirFile.listFiles();
		wrongNames = new String[f.length];
		for(int i=0; i<f.length; i++){
			wrongNames[i] = f[i].getName();
		}
		wrongVec = new Vector[f.length];
		myMap = new HashMap<>();

		for (int idx = 0; idx < wrongVec.length; idx++) {
			File File = new File(DIR_NAME + "\\" + wrongNames[idx]);
			wrongVec[idx] = new Vector<Problem>();
			try {
				fis = new FileInputStream(File);
				dis = new DataInputStream(fis);
				int count = 1;
				while (dis.available() > 0) {
					int subjectNum = dis.readInt();
					String questionTitle1 = dis.readUTF();
					String questionTitle2 = dis.readUTF();
					String imageDir = dis.readUTF();
					String answer1 = dis.readUTF();
					String answer2 = dis.readUTF();
					String answer3 = dis.readUTF();
					String answer4 = dis.readUTF();
					String answer5 = dis.readUTF();
					String result = dis.readUTF();
					String myText = dis.readUTF();
					wrongVec[idx].add(new Problem(subjectNum, questionTitle1, questionTitle2, imageDir, answer1,
							answer2, answer3, answer4, answer5, result, myText));
				}
				
				// ���߿� ��¥�� �ʿ��ؼ� Map�� ����ؼ�
				// ������ �Ѱ��ݴϴ�
				// ���� ������ ��¥�� ���߿� JLabel�� ���� ����
				myMap.put(File, wrongVec[idx]);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				MyUtils.closeAll(dis, fis);
			}
		}
	}

	private void showFrame() {

		setTitle("problemMain");
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public static void main(String args[]) {
		new ProblemMain();
	}
}