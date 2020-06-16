import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Create extends JFrame {
	public static final int TEXT_SIZE = 27;
	private String TemporaryFileName;
	private JComboBox<String> box;
	private int TemporarySaveCount;
	private CreateProblem owner;
	private JLabel lblNo; // 문제 번호
	private JTextField tfTitle; // 문제제목
	private JTextArea taField; // 문제가 들어갈 공간
	private JTextField tfImageDir; // 사진 경로
	private JButton btnImageCancel; // 사진 경로 취소
	private JButton btnPreview; // 사진 미리 보는 버튼
	private JButton btnAddPicture; // 사진 첨부 버튼
	private Answer answers; // 답을 체크하는 Answer클래스
	private JButton btnTotalProblem;// 문제 전체보기 버튼
	private JButton btnRegister; // 문제 등록 버튼
	private JButton btnTemporarySave;
	private Vector<Problem>[] vec;
	private JFileChooser chooser; // 사진첨부

	public Create(CreateProblem owner) {
//		super(owner, "Create", true);

		this.owner = owner;
		init();
		setDisplay();
		addListeners();
		setProblemNum();
		showFrame();

	}

	private void init() {

		lblNo = new JLabel();
		lblNo.setFont(new Font("Maplestory",Font.BOLD,20));
		lblNo.setBorder(new EmptyBorder(7, 0, 0, 0));
		lblNo.setForeground(new Color(0xf0c022));
		tfTitle = new JTextField(24);
		taField = new JTextArea(5, 35);
		taField.setBorder(new TitledBorder(new LineBorder(Color.gray,2),"내용"));
		taField.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
		tfImageDir = new JTextField(16);
		tfImageDir.setEnabled(false);
		btnImageCancel = new JButton(new ImageIcon("Cancel.png"));
		btnImageCancel.setMargin(new Insets(0, 2, -1, 2));
		btnPreview = new JButton("사진 미리보기");
		btnAddPicture = new JButton("사진 첨부");
		btnTotalProblem = new JButton("문제 전체 보기");
		btnRegister = new JButton("문제 파일저장");
		btnRegister.setVisible(false);
		btnTemporarySave = new JButton("문제저장");
		answers = new Answer();
		vec = owner.getVec();
		box = owner.getCmbCategory();
		box.setPreferredSize(new Dimension(200, 30));
		lblNo.setText(String.valueOf(vec[box.getSelectedIndex()].size() + 1));
		chooser = new JFileChooser();
		setButtonColor(btnRegister);
		setButtonColor(btnTemporarySave);
		setButtonColor(btnPreview);
		setButtonColor(btnTotalProblem);
		setButtonColor(btnAddPicture);
	}
	
	public static void setButtonColor(JButton btn){
		btn.setUI(new StyledButtonUI());		
	}
	private JPanel setPanelCenter() {
		JPanel pnlCenter = new JPanel(new BorderLayout());
		JPanel pnlInNorth = new JPanel(new GridLayout(0, 1));
		JPanel pnlNo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JLabel lbL = new JLabel("문제번호");
		lbL.setFont(new Font("Maplestory",Font.BOLD,17));
		lbL.setBorder(new EmptyBorder(7, 0, 0, 0));
		pnlNo.add(lbL);
		pnlNo.add(lblNo);
		pnlInNorth.add(pnlNo);
		JPanel pnlTitle = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlTitle.add(tfTitle);
		pnlInNorth.add(pnlTitle);
		pnlCenter.add(pnlInNorth, BorderLayout.NORTH);

		JPanel pnlText = new JPanel();
		pnlText.add(new JScrollPane(taField));
		pnlCenter.add(pnlText, BorderLayout.CENTER);

		JPanel pnlInSouth = new JPanel(new GridLayout(0, 1));
		JPanel pnlInSouthNorth = new JPanel();
		pnlInSouthNorth.add(tfImageDir);
		pnlInSouthNorth.add(btnImageCancel);

		JPanel pnlInSouthSouth = new JPanel();
		pnlInSouthSouth.add(btnPreview);
		pnlInSouthSouth.add(btnAddPicture);

		pnlInSouth.add(pnlInSouthNorth);
		pnlInSouth.add(pnlInSouthSouth);

		pnlCenter.setBackground(new Color(0x42984d));
		pnlNo.setBackground(new Color(0x42984d));
		pnlTitle.setBackground(new Color(0x42984d));
		pnlText.setBackground(new Color(0x42984d));
		pnlInSouthNorth.setBackground(new Color(0x42984d));
		pnlInSouthSouth.setBackground(new Color(0x42984d));
		
		pnlCenter.add(pnlInSouth, BorderLayout.SOUTH);
		return pnlCenter;
	}

	private JPanel setPanelSouth() {
		JPanel pnlSouth = new JPanel(new BorderLayout());
		
		JPanel pnlInCenter = answers;
		pnlSouth.add(pnlInCenter, BorderLayout.CENTER);

		JPanel pnlInSouth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlInSouth.add(btnTotalProblem);
		pnlInSouth.add(btnTemporarySave);
		pnlInSouth.add(btnRegister);
		
		pnlSouth.setBackground(new Color(0x42984d));
		pnlInSouth.setBackground(new Color(0x42984d));
	
		pnlSouth.add(pnlInSouth, BorderLayout.SOUTH);
		return pnlSouth;
	}

	private void setDisplay() {

		add(setPanelCenter(), BorderLayout.CENTER);
		add(setPanelSouth(), BorderLayout.SOUTH);
	}

	private void addListeners() {
		Vector<Problem> problem = vec[box.getSelectedIndex()];
		btnTemporarySave.addActionListener((ae) -> {
			int result = checkDialog("임시저장을 하시겠습니까?");
			StringTokenizer st = new StringTokenizer(taField.getText(), "\n");
			boolean checkNull;
			boolean checkoverlap;
			if (JOptionPane.YES_OPTION == result) {
				JTextField[] tf = answers.getTf();
				checkNull = checkNullProblem(tf);
				if (checkNull == true) {
					checkoverlap = overlapDelete(tf);
					if (checkoverlap == true) {
						problem.add(new Problem(problem.size(), tfTitle.getText(), taField.getText(),
								tfImageDir.getText(), tf[0].getText(), tf[1].getText(), tf[2].getText(),
								tf[3].getText(), tf[4].getText(), selectedAnswer(tf)));
						setNullProblem(tf);
						lblNo.setText(String.valueOf(vec[box.getSelectedIndex()].size() + 1));
						TemporarySaveCount++;
						tfImageDir.setText("");
						btnRegister.setVisible(true);
						
					}
				}
			}

		});

		btnRegister.addActionListener((ae) -> {
			RegisterProblem();
			
		});

		btnAddPicture.addActionListener((ae) -> {
			selectSrc();
		});

		btnImageCancel.addActionListener((ae) -> {
			tfImageDir.setText("");
		});

		btnPreview.addActionListener((ae) -> {
			boolean flag = checkExtension();
			if (flag == true) {
				new PicturePreview(this, tfImageDir);
			}
		});

		btnTotalProblem.addActionListener((ae) -> {
			boolean flag = true;
			int i = box.getSelectedIndex();
			if (vec[i].size() == 0) {
				noticeNull("문제가없습니다");
				flag = false;
			}
			if (flag) {
				setVisible(false);
				new ProblemTotalPage(this, vec[box.getSelectedIndex()]);			
			}
		});
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(TemporarySaveCount != 0){
					int result = JOptionPane.showConfirmDialog(null, "파일이 저장안됬습니다\n 저장하시겠습니가?", "알림", JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.YES_OPTION){
						RegisterProblem();
					}else{
						dispose();
					}
				}
				owner.setVisible(true);		
			}
		});
	}

	private boolean checkExtension() {
		boolean flag = true;
		int idx = tfImageDir.getText().lastIndexOf(".");
		try {
			String imgdir = tfImageDir.getText().substring(idx);
			if (tfImageDir.getText().equals("")) {
				flag = false;
				JOptionPane.showMessageDialog(this, "사진 파일을 선택해주세요.");
			}

		} catch (StringIndexOutOfBoundsException e) {
			noticeNull("이미지가 없습니다");
			flag = false;
		}
		return flag;
	}

	private void selectSrc() {
		// 열기의 탐색기 실행
		int result = chooser.showOpenDialog(this);

		// 파일 선택하고 확인을 눌렀을때 : APPROVE_OPTION
		// 취소를 눌렀을때 : CANCEL_OPTION
		if (result == JFileChooser.APPROVE_OPTION) {		
			File srcFile = chooser.getSelectedFile();
			if (!srcFile.getName().contains(".jpg") && !srcFile.getName().contains(".png")&& !srcFile.getName().contains(".JPG") && !srcFile.getName().contains(".PNG")) {	
				noticeNull("확장자명이 올바르지 않습니다(png,jpg)");
			}else{
				tfImageDir.setText(srcFile.getPath());
			}
			
		}
	}

	protected void setLblProblemNum(int num) {
		lblNo.setText("" + num);
	}

	private int checkDialog(String str) {
		int result = JOptionPane.showConfirmDialog(this, str, "알림", JOptionPane.YES_NO_OPTION);
		return result;
	}

	private void noticeNull(String str) {
		JOptionPane.showMessageDialog(this, str);
	}

	public void RegisterProblem() {
		int result = checkDialog(TemporarySaveCount + "개의 파일을 등록하시겠습니까?");

		if (TemporarySaveCount != 0) {
			if (JOptionPane.YES_OPTION == result) {
				writeProblem();
				TemporarySaveCount = 0;
				btnRegister.setVisible(false);
			}
		} else {
			noticeNull("저장된 문제가 없습니다 ");
		}

	}

	public void writeProblem() {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			int num = box.getSelectedIndex();
			fos = new FileOutputStream("problem\\" + box.getItemAt(num) + ".dat");
			dos = new DataOutputStream(fos);
			for (int idx = 0; idx < vec[num].size(); idx++) {
				dos.writeInt(vec[num].get(idx).getSubjectNum());
				dos.writeUTF(vec[num].get(idx).getQuestionTitle1());
				dos.writeUTF(vec[num].get(idx).getQuestionTitle2());
				dos.writeUTF(vec[num].get(idx).getImageDir());
				dos.writeUTF(vec[num].get(idx).getAnswer1());
				dos.writeUTF(vec[num].get(idx).getAnswer2());
				dos.writeUTF(vec[num].get(idx).getAnswer3());
				dos.writeUTF(vec[num].get(idx).getAnswer4());
				dos.writeUTF(vec[num].get(idx).getAnswer5());
				dos.writeUTF(vec[num].get(idx).getResult());
			}
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(dos, fos);
		}

	}

	private void setProblemNum() {
		box.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				for (int i = 0; i < vec.length; i++) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						Object sre = e.getItem();
						if (sre.equals(box.getItemAt(i))) {
							TemporaryFileName = box.getItemAt(i + 1);
							lblNo.setText(String.valueOf(vec[box.getSelectedIndex()].size() + 1));

						}
					}
				}
			}
		});

	}

	private boolean checkNullProblem(JTextField[] tf) {
		boolean flag = true;

		if (tfTitle.getText().equals("")) {
			noticeNull("문제제목을 입력하세요");
			flag = false;
		} else if (taField.getText().equals("")) {
			noticeNull("문제를 입력하세요");
			flag = false;
		} else if (selectedAnswer(tf) == null) {
			noticeNull("답을 정해주세요");
			flag = false;
		}

		for (int i = 0; i < WrongAnswerPanel.MAX_NUMBER; i++) {
			if (flag && tf[i].getText().equals("")) {
				noticeNull((i + 1) + "번보기를 입력하세요");
				flag = false;
			}
		}
		return flag;
	}

	private boolean overlapDelete(JTextField[] tf) {
		boolean flag = true;
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < WrongAnswerPanel.MAX_NUMBER; i++) {
			set.add(tf[i].getText());
		}
		if (set.size() != 5) {
			noticeNull("보기의 중복을 제거하세요");
			flag = false;
		}
		return flag;
	}

	private void setNullProblem(JTextField[] tf) {
		JRadioButton[] rbtn = answers.getRbtn();
		tfTitle.setText("");
		taField.setText("");
		for (int i = 0; i <= 4; i++) {
			tf[i].setText("");
			rbtn[i].setSelected(false);
		}

	}

	private String selectedAnswer(JTextField[] tf) {
		JRadioButton[] rbtn = answers.getRbtn();
		for (int idx = 0; idx < rbtn.length; idx++) {
			if (rbtn[idx].isSelected()) {
				String str = tf[idx].getText();
				return str;
			}
		}
		return null;
	}

	private void showFrame() {
		setTitle("목차:"+box.getItemAt(box.getSelectedIndex()));
		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

}
