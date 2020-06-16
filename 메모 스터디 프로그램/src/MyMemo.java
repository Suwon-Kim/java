import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

public class MyMemo extends JDialog{
	public static final Dimension BTN_SIZE = new Dimension(50, 30);
	public static final Dimension LBL_SIZE = new Dimension(70, 22);
	
	private JLabel lblDate;			//"작성일 : " 레이블
	private JLabel lblSelectDay;	//yyyy.MM.dd(파일 작성일)
	private JLabel lblTitle;		//"제목 : " 레이블
	private JLabel lblTag;			//"태그 : " 레이블 
	private JLabel lblPw;			//"pw : " 레이블
	
	private JButton btnReset;		//'+'버튼
	private JButton btnSave;		//'저장'버튼
	private JButton btnRemove;		//'삭제'버튼
	private JButton btnCancel;		//'취소'버튼
	
	private JTextField tfTitle;		//제목 텍스트필드
	private JTextField tfTag;		//태그 텍스트필드
	private JPasswordField pfPw;	//pw 패스워드필드
	
	private JTextArea taContent;	//내용 
	
	private StudyMemo owner;
	private Calendar date;			//메모 작성일
	private MyCalendar myCal;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	
	private JLabel[] lblTitles;		//파일제목 레이블 리스트
	
	
	/*
	 * 	date : 메모 작성일
	 *  owner : StudyMemo(JFrame)클래스의 객체 주소
	 * */
	public MyMemo(Calendar date, StudyMemo owner, MyCalendar myCal) {
		
		super(owner, "메모 창", false);
		this.owner = owner;		//StudyMemo 클래스 안의 vecFile 변수에 접근하기 위함.
		this.date = date;			//메모를 작성할 날짜를 담는다.
		this.myCal = myCal;
		
		init();
		setDisplay();
		addListeners();
		showDlg();
	}
	
	public MyMemo(String date, String title, StudyMemo owner, MyCalendar myCal) {
		this.owner = owner;
		this.myCal = myCal;
		
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(5, 7));
		int day = Integer.parseInt(date.substring(8, 10));

		this.date = Calendar.getInstance();
		this.date.set(Calendar.YEAR, year);
		this.date.set(Calendar.MONTH, month - 1);
		this.date.set(Calendar.DATE, day);
		
		init();
		setDisplay();
		addListeners();
		showDlg();
		
		Vector<FileInfo> vecFile = owner.getVecFile();
		
		if(vecFile != null) {
			for(FileInfo info : vecFile) {
				String targetDate = info.getDate();
				String targetTitle = info.getTitle();
				String targetTag = info.getTag();
				String targetContent = info.getContent();
				
				if(date.equals(targetDate) && title.equals(targetTitle)) {
					tfTitle.setText(targetTitle);
					tfTag.setText(targetTag);
					taContent.setText(targetContent);
				}
			}
		}
	}
	
	private void init() {
		lblDate = new JLabel("작성일 : ", JLabel.CENTER);
		lblDate.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		lblDate.setPreferredSize(LBL_SIZE);
		
		lblTitle = new JLabel("제  목 : ", JLabel.CENTER);
		lblTitle.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		lblTitle.setPreferredSize(LBL_SIZE);
		
		lblTag = new JLabel("태  그 : ", JLabel.CENTER);
		lblTag.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		lblTag.setPreferredSize(LBL_SIZE);
		
		lblPw = new JLabel(" PW : ", JLabel.CENTER);
		lblPw.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		lblPw.setPreferredSize(LBL_SIZE);
		
		lblSelectDay = new JLabel(sdf.format(date.getTime()));
		lblSelectDay.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		lblSelectDay.setPreferredSize(LBL_SIZE);
		
		btnReset = new JButton("+");
		btnReset.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		btnReset.setBackground(Color.pink);
		btnReset.setBorder(new LineBorder(Color.pink));
		btnReset.setPreferredSize(BTN_SIZE);
		btnReset.setToolTipText("내용을 초기화하고 새 메모를 작성합니다.");
		
		btnSave = new JButton("저장");
		btnSave.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		btnSave.setBackground(Color.pink);
		btnSave.setBorder(new LineBorder(Color.pink));
		btnSave.setPreferredSize(BTN_SIZE);
		
		btnRemove = new JButton("삭제");
		btnRemove.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		btnRemove.setBackground(Color.pink);
		btnRemove.setBorder(new LineBorder(Color.pink));
		btnRemove.setPreferredSize(BTN_SIZE);
		
		btnCancel = new JButton("취소");
		btnCancel.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		btnCancel.setBackground(Color.pink);
		btnCancel.setBorder(new LineBorder(Color.pink));
		btnCancel.setPreferredSize(BTN_SIZE);
		
		tfTitle = new JTextField(15);
		tfTag = new JTextField(20);
		tfTag.setToolTipText("태그를 여러 개 지정 시 ','로 띄어쓰기없이 작성해주세요");
		pfPw = new JPasswordField(10);
		
		taContent = new JTextArea(20, 20);
		taContent.setText("태그를 여러 개 사용할 때는 ','로 구분하며 띄어쓰기없이 이어쓰세요.");
		taContent.setLineWrap(true);
		
		initLabelArray();
		//lblDates, lblTitles 배열 초기화
	}
	private void setDisplay() {
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(new Color(255, 234, 234));
		
		JPanel pnlLabel = new JPanel(new GridLayout(0, 1));
		pnlLabel.setBackground(new Color(255, 234, 234));
		//"작성일", "제목", "태그", "pw" 레이블이 붙는다.
		pnlLabel.add(lblDate);
		pnlLabel.add(lblTitle);
		pnlLabel.add(lblTag);
		pnlLabel.add(lblPw);
		
		JPanel pnlTextField = new JPanel(new GridLayout(0, 1));
		pnlTextField.setBackground(new Color(255, 234, 234));
		//메모작성일, 제목텍스트필드, 태그텍스트필드, pw패스워드필드가 붙는다.
		pnlTextField.add(lblSelectDay);
		pnlTextField.add(tfTitle);
		pnlTextField.add(tfTag);
		pnlTextField.add(pfPw);
		
		JPanel pnlButton = new JPanel();
		pnlButton.setBackground(new Color(255, 234, 234));
		pnlButton.add(btnReset);
		
		pnlNorth.add(pnlLabel);
		pnlNorth.add(pnlTextField);
		pnlNorth.add(pnlButton);
		
		
		JPanel pnlCenter = new JPanel(new BorderLayout());
		pnlCenter.setBackground(new Color(255, 234, 234));
		
		JScrollPane scroll = new JScrollPane(taContent);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		pnlCenter.add(getPnlFileList(), BorderLayout.NORTH);
		pnlCenter.add(scroll, BorderLayout.CENTER);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(new Color(255, 234, 234));
		pnlSouth.add(btnSave);
		pnlSouth.add(btnRemove);
		pnlSouth.add(btnCancel);
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	
	
	private JPanel getPnlFileList() {
		JPanel pnlFileList = new JPanel(new GridLayout(0, 1));
		//메모 작성일에 존재하는 모든 파일들을 나열해 붙인다.
		pnlFileList.setBackground(new Color(255, 234, 234));
		 
		

		//파일제목 레이블들을 붙인다
		if(lblTitles != null) {
			for(int idx=0; idx<lblTitles.length; idx++) {
				JPanel pnlTitle = new JPanel();
				pnlTitle.setBackground(new Color(255, 234, 234));
				
				JLabel lblImage = new JLabel();
				lblImage.setIcon(new ImageIcon("file.png"));
				pnlTitle.add(lblImage);
				pnlTitle.add(lblTitles[idx]);
				pnlFileList.add(pnlTitle);
			}
		}
		
		
		return pnlFileList;
		
	}
	
	//JLabel 배열 lblDates, lblTitles를 초기화하는 메서드.
	private void initLabelArray() {
		int count = 0;
		
		Vector<FileInfo> vecFile = owner.getVecFile();
		
		Vector<String> vecTitle = new Vector<String>();
		
		String memoDate = lblSelectDay.getText();
		
		if(vecFile != null) {
			for(FileInfo info : vecFile) {
				String targetDate = info.getDate();
				if(targetDate.equals(memoDate)) {
					//작성일이 같은 파일이 vecFile 안에 존재하면 count값 증가.
					count++;
					
					//vecDate.add(info.getDate());
					//작성일을 vecDate에 추가
					vecTitle.add(info.getTitle());
					//파일제목을 vecTitle에 추가
				}
			}
		}
		
		if(count != 0) {
			//작성일이 같은 파일이 하나라도 존재할 때만 레이블 배열 초기화.
			lblTitles = new JLabel[count];
		}
		
		int idx = 0;
		
		idx = 0;
		Iterator<String> itTitle = vecTitle.iterator();
		while(itTitle.hasNext()) {
			String title = itTitle.next();
			lblTitles[idx] = new JLabel(title, JLabel.LEFT);
			lblTitles[idx].setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
			lblTitles[idx].setOpaque(true);
			lblTitles[idx].setBackground(new Color(255, 234, 234));
			lblTitles[idx].setForeground(Color.black);
			idx++;
		}
		
	}
	private void addListeners() {
		ActionListener aListener = (ae) -> {
			Object o = ae.getSource();
			if(o == btnSave) {
				//저장 버튼 눌렀을 시 할 일 정의
				save();
			} else if(o == btnRemove) {
				//삭제 버튼 눌렀을 시 할 일 정의
				remove();
			} else if(o == btnCancel) {
				//취소 버튼 눌렀을 시 할 일 정의
				dispose();
			} else if(o == btnReset) {
				//+ 버튼 눌렀을 시 할 일 정의
				reset();
			}
		};
		
		MouseListener mListener = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				JLabel lbl = (JLabel)me.getSource();
				
				String date = lblSelectDay.getText();
				String title = lbl.getText();
				
				setMemo(date, title);
			}
		};
		
		btnSave.addActionListener(aListener);
		btnRemove.addActionListener(aListener);
		btnReset.addActionListener(aListener);
		btnCancel.addActionListener(aListener);
		
		if(lblTitles != null) {
			for(int idx=0; idx<lblTitles.length; idx++) {
				lblTitles[idx].addMouseListener(mListener);
			}
		}
	}
	private void setMemo(String date, String title) {
		Vector<FileInfo> vecFile = owner.getVecFile();
		
		for(FileInfo file : vecFile) {
			String targetDate = file.getDate();
			String targetTitle = file.getTitle();
			
			if(date.equals(targetDate) && title.equals(targetTitle)) {
				tfTitle.setText(file.getTitle());
				tfTag.setText(file.getTag());
				taContent.setText(file.getContent());
			}
		}
	}
	//StudyMemo 클래스의 vecFile 리스트에 파일 추가
	private void save() {
		//수정 시, vecFile의 해당 작성일의 해당 제목 파일이 존재하면 그 파일의 태그, pw, 내용만 변경
		//수정 시, 제목을 수정하면 아예 vecFile에 새로운 FileInfo 객체를 추가.
		boolean saveSuccess = false;
		
		String date = lblSelectDay.getText();
		String title = tfTitle.getText();
		String tag = tfTag.getText();
		String pw = String.valueOf(pfPw.getPassword());
		String content = taContent.getText();
		
		if(title.length() == 0) {
			JOptionPane.showMessageDialog(this, "제목을 입력해주세요");
		} else if(tag.length() == 0) {
			JOptionPane.showMessageDialog(this, "태그를 입력해주세요");
		} else if(pw.length() == 0) {
			JOptionPane.showMessageDialog(this, "pw 입력해주세요");
		} else {
			Vector<FileInfo> vecFile = owner.getVecFile();
			
			if (vecFile == null) {
				owner.addFile(new FileInfo(date, title, tag, pw, content));
				JOptionPane.showMessageDialog(this, "저장 성공!");
				
				dispose();
				new MyMemo(this.date, owner, myCal);
				myCal.hasFile();
			} else {
				for (FileInfo file : vecFile) {
					String targetDate = file.getDate();
					String targetTitle = file.getTitle();

					if(date.equals(targetDate) && title.equals(targetTitle)) {
						// 작성일과 제목이 같은 파일이 존재하면 덮어쓰기
						file.setTag(tag);
						file.setPw(pw);
						file.setContent(content);

						JOptionPane.showMessageDialog(this, "덮어쓰기 성공!");
						dispose();
						new MyMemo(this.date, owner, myCal);
						myCal.hasFile();
						saveSuccess = true;
					}
				}
				if(!saveSuccess) {
					owner.addFile(new FileInfo(date, title, tag, pw, content));
					JOptionPane.showMessageDialog(this, "저장 성공!");
					
					dispose();
					new MyMemo(this.date, owner, myCal);
					myCal.hasFile();
				}
			}
		}
	}
	private void remove() {
		//삭제 시, vecFile의 FileInfo 객체의 모든 정보(제목, 태그, pw, 내용)와 
		//사용자가 입력한 정보(제목, 태그, pw, 내용)이 전부 일치해야만 삭제 가능
		String date = lblSelectDay.getText();
		String title = tfTitle.getText();
		String tag = tfTag.getText();
		String pw = String.valueOf(pfPw.getPassword());
		String content = taContent.getText();

		if (title.length() == 0) {
			JOptionPane.showMessageDialog(this, "제목을 입력해주세요");
		} else if (tag.length() == 0) {
			JOptionPane.showMessageDialog(this, "태그를 입력해주세요");
		} else {
			boolean exist = false;
			Vector<FileInfo> vecFile = owner.getVecFile();

			if (vecFile != null) {
				for (FileInfo info : vecFile) {
					String targetDate = info.getDate();
					String targetTitle = info.getTitle();
					String targetTag = info.getTag();
					String targetContent = info.getContent();

					if (date.equals(targetDate) && title.equals(targetTitle) && tag.equals(targetTag)
							&& content.equals(targetContent)) {
						// 작성일, 제목, 태그, 내용이 같아야만 삭제할 기회를 준다.
						exist = true;
					}
				}
			}
			if(exist) {
				String rePw = JOptionPane.showInputDialog(this, "삭제할 파일의 pw를 다시 한 번 입력해주세요");

				FileInfo myInfo = new FileInfo(date, title, tag, rePw, content);

				if (vecFile != null) {
					if (vecFile.contains(myInfo)) {
						// vecFile에 모든 내용이 일치하는 파일이 존재할 경우
						owner.removeFile(myInfo);
						JOptionPane.showMessageDialog(this, "삭제 성공");
						
						dispose();
						new MyMemo(this.date, owner, myCal);
						myCal.hasFile();
					} else {
						JOptionPane.showMessageDialog(this, "삭제 실패. pw가 일치하지 않습니다");
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "해당 파일이 존재하지 않습니다.");
			}
		}

	}
	//메모 창의 모든 정보 초기화
	private void reset() {
		tfTitle.setText("");
		tfTag.setText("");
		pfPw.setText("");
		taContent.setText("태그를 여러 개 사용할 때는 ','로 구분하며 띄어쓰기없이 이어쓰세요.");
	}
	private void showDlg() {
		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
}
