import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class CreateProblem extends JFrame {
	private File dir;
	private File[] files;
	private JButton btnCreate;
	private JComboBox<String> cmbCategory;
	private Vector<String> filesName;
	private JLabel lblPicture;
	private Vector<Problem>[] vec;
	private JButton btnAddContents;
	private JButton btnRemoveContents;
	private String TemporaryFileName;
	private JPanel pnlNorthMain;
	private StringTokenizer st;

	public CreateProblem() {
		init();
		setProblemNum();
		setDisplay();
		addListeners();
		showFrame();
		load();
	}

	public StringTokenizer getSt() {
		return st;
	}

	public File getDir() {
		return dir;
	}

	public Vector<Problem>[] getVec() {
		return vec;
	}

	private void init() {

		fileNameArr();
		btnRemoveContents = new JButton("목차삭제");
		btnAddContents = new JButton("목차 추가");

		btnCreate = new JButton("문제만들기");
		btnCreate.setPreferredSize(new Dimension(180, 30));
		lblPicture = new JLabel(new ImageIcon("rionMain.gif"));
		cmbCategory = new JComboBox<>(filesName);
		cmbCategory.setBorder(new TitledBorder("목차선택"));
		cmbCategory.setBackground(new Color(0xf0c022));// 노란색
		Create.setButtonColor(btnCreate);
		Create.setButtonColor(btnAddContents);
		Create.setButtonColor(btnRemoveContents);
	}

	private void setDisplay() {
		pnlNorthMain = new JPanel(new BorderLayout());

		JPanel pnlMain = new JPanel(new BorderLayout());
		pnlNorthMain.add(lblPicture, BorderLayout.CENTER);
		pnlNorthMain.add(cmbCategory, BorderLayout.NORTH);
		pnlMain.add(pnlNorthMain, BorderLayout.NORTH);
		JPanel pnlCenter = new JPanel();

		pnlCenter.add(btnAddContents);
		pnlCenter.add(btnRemoveContents);

		pnlMain.add(pnlCenter, BorderLayout.CENTER);

		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnCreate);
		pnlNorthMain.setBackground(new Color(0x42984d));
		pnlCenter.setBackground(new Color(0x42984d));
		pnlSouth.setBackground(new Color(0x42984d));
		pnlMain.add(pnlSouth, BorderLayout.SOUTH);
		add(pnlMain);
	}

	private void resetCategory() {
		fileNameArr();
		cmbCategory.removeAllItems();
		for (int idx = 0; idx < filesName.size(); idx++) {
			cmbCategory.addItem(filesName.get(idx));
		}
		
		load();
	}

	private void addListeners() {

		btnCreate.addActionListener((ae) -> {
			if (filesName.size() != 0) {
				load();
				setVisible(false);
				new Create(this);
			} else {
				JOptionPane.showMessageDialog(this, "목차를 생성해 주세요.");
			}
		});

		btnAddContents.addActionListener((ae) -> {
		
			boolean flag = true;
			String filename = JOptionPane.showInputDialog(this, "목차명을 입력하세요 : ", "목차 생성", JOptionPane.PLAIN_MESSAGE);
			File f = new File("problem\\" + filename + ".dat");
			if (f.exists()) {
				flag = false;
			}
			if (flag && filename != null) {
				load();
				createFile(filename);			
				resetCategory();
				revalidate();
				cmbCategory.setSelectedItem(filename);
			}
		});

		btnRemoveContents.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int idx = cmbCategory.getSelectedIndex();
				if (filesName.size() != 1) {
					if (TemporaryFileName == null) {
						String str = getFileName();
						cmbCategory.removeItemAt(0);
						filesName.remove(0);
						int end = str.indexOf(".");
						String result = getFileName().substring(0, end);
						removeFile(result);
					} else if (idx == -1) {
						filesName.remove(0);
						removeFile(TemporaryFileName);
						cmbCategory.removeItemAt(0);
					} else {
						removeFile(TemporaryFileName);
						cmbCategory.removeItemAt(idx);
						filesName.remove(idx);
					}
					revalidate();
					resetCategory();
				} else {
					new WarningFrame("파일이 1개는 있어야함!");
				}
			}
		});
	}

	protected void load() {

		FileInputStream fis = null;
		DataInputStream dis = null;

		vec = new Vector[filesName.size()];
		for (int idx = 0; idx < vec.length; idx++) {
			try {
				vec[idx] = new Vector<Problem>();
				fis = new FileInputStream(files[idx]);
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

	private void fileNameArr() {

		dir = new File("problem");
		files = dir.listFiles();
		filesName = new Vector<>();
		for (int idx = 0; idx < files.length; idx++) {
			String fileName = files[idx].getName();
			fileName = fileName.substring(0, fileName.indexOf("."));
			filesName.add(fileName);
		}
	}

	public JComboBox<String> getCmbCategory() {
		return cmbCategory;
	}

	public String getFileName() {
		files = dir.listFiles();
		String fileName = files[0].getName();
		return fileName;
	}

	private JLabel imageSizeControl(String fileName) {
		Image img = Toolkit.getDefaultToolkit().getImage(fileName);
		img = img.getScaledInstance(300, 300, Image.SCALE_AREA_AVERAGING);
		JLabel lblImg = new JLabel(new ImageIcon(img));
		return lblImg;
	}

	private void setProblemNum() {
		cmbCategory.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {

				for (int i = 0; i < vec.length; i++) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						Object sre = e.getItem();
						if (sre.equals(cmbCategory.getItemAt(i))) {
							TemporaryFileName = cmbCategory.getItemAt(i);
							revalidate();
						}
					}
				}
			}
		});
	}

	private void removeFile(String filename) {
		File f = new File(("problem\\" + filename + ".dat"));
		f.delete();
		JOptionPane.showMessageDialog(this, filename + " 삭제 되었습니다");
	}

	private void createFile(String filename) {
		FileWriter fw = null;

		try {
			if (!filename.trim().equals("")) {
				fw = new FileWriter("problem\\" + filename + ".dat");
				JOptionPane.showMessageDialog(this, filename + " 추가 되었습니다");
			} else {
				new WarningFrame("공백 안됩니다!!!");
			}
		} catch (IOException e) {
			new WarningFrame("특수문자 안됩니다 !!!");
		} finally {
			try {
				MyUtils.closeAll(fw);
			} catch (Exception e) {
				System.out.println("CreateProblem - createFile");
			}
		}
	}

	private void showFrame() {
		setTitle("CreateProblem");
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String args[]) {
		new CreateProblem();
	}
}
