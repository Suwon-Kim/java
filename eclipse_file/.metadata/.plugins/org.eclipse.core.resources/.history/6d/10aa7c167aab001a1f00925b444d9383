import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MyMemo2 extends JDialog{
	public static final Dimension LBL_SIZE = new Dimension(50, 22);
	
	private MyCalendar owner;
	private Calendar cal;
	
	private JLabel lblManual;	//사용법 레이블
	private JLabel lblDate;		//작성일 레이블
	private JLabel lblTitle;	//제목 레이블
	private JLabel lblTag;		//태그 레이블
	private JLabel lblPw;		//PW 레이블
	private JLabel lblToday;	//작성일(yyyy.MM.dd) 레이블
	
	private JLabel[] lblFileList;	//파일목록리스트레이블
	
	private JTextField tfTitle;		//제목 텍스트필드
	private JTextField tfTag;		//태그 텍스트필드
	private JPasswordField pfPw;	//pw 패스워드필드
	
	private JButton btnReset;		//reset(+모양) 버튼
	private JButton btnSave;		//저장 버튼
	private JButton btnRemove;		//삭제 버튼
	private JButton btnCancel;		//취소 버튼
	
	private JTextArea taContent;	//내용
	
	private Properties prop = new Properties();
	private TreeSet<String> fileListSet = new TreeSet<String>();
	//작성일 키값에 존재하는 파일제목 여러개를 StringTokenizer를 사용해 ", " 구분자로 찢어 담아놓은 변수.
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	
	private File file = new File("allFileInfo.properties");
	private String tmpFile;
	
	private TreeSet<String> files = new TreeSet<String>();
	
	//MyCalendar에서 작성일(cal)을 받아온다.
	public MyMemo2(Calendar cal, MyCalendar owner) {
		this.cal = cal;
		this.owner = owner;
		
		init();
		setDisplay();
		addListeners();
		showDlg();
	}
	public MyMemo2(Calendar cal, MyCalendar owner, TreeSet<String> files) {
		this(cal, owner);
		this.files = files;
	}
	private void init() {
		lblManual = new JLabel("파일을 클릭하면 내용을 불러올 수 있습니다~");
		//lblManual.setPreferredSize(LBL_SIZE);
		lblDate = new JLabel("작성일 : ", JLabel.LEFT);
		lblDate.setPreferredSize(LBL_SIZE);
		lblTitle = new JLabel("제    목 : ", JLabel.LEFT);
		lblTitle.setPreferredSize(LBL_SIZE);
		lblTag = new JLabel("태    그 : ", JLabel.LEFT);
		lblTag.setPreferredSize(LBL_SIZE);
		lblPw = new JLabel("   PW   : ", JLabel.LEFT);
		lblPw.setPreferredSize(LBL_SIZE);
		lblToday = new JLabel(sdf.format(cal.getTime()));
		
		tfTitle = new JTextField(15);
		tfTag = new JTextField(20);
		pfPw = new JPasswordField(10);
		
		taContent = new JTextArea(20, 20);
		taContent.setLineWrap(true);
		
		
		btnReset = new JButton("+");
		btnReset.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
		btnReset.setToolTipText("새 메모를 생성합니다.");
		btnSave = new JButton("저장");
		btnRemove = new JButton("삭제");
		btnCancel = new JButton("취소");
		
		
		// 파일목록리스트가 존재하면 -> pnlCenter의 BorderLayout.NORTH에 붙인다.
		
		String date = lblToday.getText();

		readFileList(file, date);
		// "allFileInfo.properties" 파일에서 date라는 키 값의 value를 읽기위함.
		
		lblFileList = new JLabel[fileListSet.size()];
		//작성일 키값에 존재하는 파일제목 개수만큼 레이블 생성.
		
		Iterator<String> it = fileListSet.iterator();
		
		int idx = 0;
		while(it.hasNext()) {
			lblFileList[idx] = new JLabel(it.next());
			//fileListSet에서 값을 하나 읽어와 레이블 텍스트로 지정하며 생성.
			idx++;
		}
	}
	private void setDisplay() {
		JPanel pnlMain = new JPanel(new BorderLayout());
		pnlMain.setBorder(new EmptyBorder(20,20,20,20));
		
		JPanel pnlNorth = new JPanel();
		JPanel pnlLbl = new JPanel(new GridLayout(0, 1));
		//pnlLbl : 작성일, 제목, 태그, pw 레이블들이 붙는다.
		pnlLbl.add(lblDate);
		pnlLbl.add(lblTitle);
		pnlLbl.add(lblTag);
		pnlLbl.add(lblPw);

		
		JPanel pnlTf = new JPanel(new GridLayout(0, 1));
		//pnlTf : 작성일(yyyy.MM.dd)레이블, 제목텍스트필드, 태그텍스트필드, pw패스워드필드가 붙는다.
		pnlTf.add(lblToday);
		pnlTf.add(tfTitle);
		pnlTf.add(tfTag);
		pnlTf.add(pfPw);
		
		JPanel pnlBtn = new JPanel();
		//pnlBtn : +모양 버튼이 붙는다.
		pnlBtn.add(btnReset);
		
		pnlNorth.add(pnlLbl);
		pnlNorth.add(pnlTf);
		pnlNorth.add(pnlBtn);
		
		JPanel pnlCenter = new JPanel(new BorderLayout());
		
		JPanel pnlFileList = new JPanel(new GridLayout(0, 1));
		for(int idx=0; idx<lblFileList.length; idx++) {
			JPanel pnlLine = new JPanel();
			JLabel lblImage = new JLabel();
			lblImage.setIcon(new ImageIcon("file.png"));
			pnlLine.add(lblImage);
			pnlLine.add(lblFileList[idx]);
			pnlFileList.add(pnlLine);
		}
		
		
		pnlCenter.add(pnlFileList, BorderLayout.NORTH);
		
		JScrollPane scroll = new JScrollPane(taContent);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pnlCenter.add(scroll, BorderLayout.CENTER);
		//pnlCenter : 파일목록리스트, taContent가 붙는다.
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnSave);
		pnlSouth.add(btnRemove);
		pnlSouth.add(btnCancel);
		
//		add(pnlNorth, BorderLayout.NORTH);
//		add(pnlCenter, BorderLayout.CENTER);
//		add(pnlSouth, BorderLayout.SOUTH);
		pnlMain.add(pnlNorth, BorderLayout.NORTH);
		pnlMain.add(pnlCenter, BorderLayout.CENTER);
		pnlMain.add(pnlSouth, BorderLayout.SOUTH);
		
		add(pnlMain, BorderLayout.CENTER);
	}
	
	
	/*
	 * 	작성일에 작성한 파일 제목 리스트를 받아오는 메서드.
	 *  ex) date(2020.06.05)에 작성한 파일 제목들을 받아온다.
	 * 	file : 읽을 파일
	 * 	date : 키 값
	 * 
	 * */
	private void readFileList(File file, String date) {
		FileReader fr = null;
		
		if(file.exists()) {
			//file(allFileInfo.properties)이 존재할 때만 수행한다.
			try {
				fr = new FileReader(file);
				prop.load(fr);
				
				String key = date;
				//작성일(yyyy.MM.dd)이 키 값이 된다.
				
				String value = prop.getProperty(key);
				
				try {
					StringTokenizer st = new StringTokenizer(value, "/");
					
					while(st.hasMoreTokens()) {
						fileListSet.add(st.nextToken());
					}
				}catch(NullPointerException e) {
					
				}
				
			}catch(IOException e) {
				JOptionPane.showMessageDialog(this, "파일 읽기 중 에러 발생!");
			}finally {
				try {
					fr.close();
				}catch(Exception e) {}
			}
		}
		
	}
	private void addListeners() {
		ActionListener aListener = (ae) -> {
			Object o = ae.getSource();
			if(o == btnSave) {
				String date = lblToday.getText();
				save(file);
				//owner.hasFile(date, files);
				owner.hasFile();
			} else if(o == btnRemove) {
				String date = lblToday.getText();
				remove(file);
				//owner.hasFile(date, files);
				owner.hasFile();
			} else if(o == btnCancel) {
				dispose();
			} else if(o == btnReset) {
				reset();
			}
		};
		
		MouseListener mListener = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				JLabel lbl = (JLabel)me.getSource();
				String fileName = lbl.getText();
				readFile(file, fileName);
			}
		};
		
		btnSave.addActionListener(aListener);
		btnRemove.addActionListener(aListener);
		btnCancel.addActionListener(aListener);
		btnReset.addActionListener(aListener);
		
		for(int idx=0; idx<lblFileList.length; idx++) {
			lblFileList[idx].addMouseListener(mListener);
		}
	}
	
	/*
	 * 	선택한 레이블의 파일을 읽어온다.
	 * 	file : 읽어 올 파일(allFileInfo.properties)
	 * 	fileName : 파일제목
	 * */
	private void readFile(File file, String fileName) {
		FileReader fr = null;
		
		try {
			fr = new FileReader(file);
			prop.load(fr);
			
			String date = lblToday.getText();
			
			tfTitle.setText(prop.getProperty(date + "/" + fileName + "/title"));
			tfTag.setText(prop.getProperty(date + "/" + fileName + "/tag"));
			taContent.setText(prop.getProperty(date + "/" + fileName + "/content"));
		}catch(IOException e) {
			JOptionPane.showMessageDialog(this, "파일 읽기 중 에러 발생!");
		}finally {
			try {
				fr.close();
			}catch(Exception e) {}
		}
	}
	
	/*
	 * 	선택한 레이블의 파일을 삭제한다. pw가 일치할 때만 삭제가 가능하다.
	 * 	file : 대상파일
	 * */
	private void remove(File file) {
		FileReader fr = null;
		
		String date = lblToday.getText();
		String fileName = tfTitle.getText();	//삭제 할 파일제목
		String filePw = null;	//삭제 할 파일의 pw
		String userPw = String.valueOf(pfPw.getPassword());	//사용자가 입력한 pw
		
		try {
			fr = new FileReader(file);
			prop.load(fr);
			
			filePw = prop.getProperty(date + "/" + fileName + "/pw");
			
			if(userPw.length() == 0) {
				//사용자가 pw를 입력하지 않았다면
				JOptionPane.showMessageDialog(this, "PW를 입력해주세요");
			} else {
				if(filePw.equals(userPw)) {
					//파일pw와 사용자가 입력한 pw가 일치해야만 해당 파일정보를 삭제한다.
					//fileName(파일제목)을 삭제해야 하는 상황.
					prop.remove(date + "/" + fileName + "/date");
					prop.remove(date + "/" + fileName + "/title");
					prop.remove(date + "/" + fileName + "/tag");
					prop.remove(date + "/" + fileName + "/pw");
					prop.remove(date + "/" + fileName + "/content");
					
					String fileList = prop.getProperty(date);
					
					fileListSet.remove(fileName);
					
					Iterator<String> it = fileListSet.iterator();
					StringBuffer list = new StringBuffer();
					while(it.hasNext()) {
						list.append(it.next() + "/");
					}
					
					if(fileListSet.size() != 0) {
						prop.setProperty(date, String.valueOf(list));
					} else {
						prop.remove(date);
					}
					
					prop.store(new FileWriter(file), "All File Information");
					
					JOptionPane.showMessageDialog(this, "삭제 성공!");
					files.remove(fileName);
					
					dispose();
					new MyMemo2(cal, owner, files);
					
				} else {
					//파일pw와 사용자가 입력한 pw가 다르다.
					JOptionPane.showMessageDialog(this, "pw가 일치하지 않습니다. 삭제 실패!");
				}
			}
		}catch(IOException e) {
			
		}finally {
			try {
				fr.close();
			}catch(Exception e) {}
		}
	}
	
	//현재 메모장에 써져 있는 텍스트를 모두 reset 시킨다.
	private void reset() {
		tfTitle.setText("");
		tfTag.setText("");
		pfPw.setText("");
		taContent.setText("");
	}
	
	
	/*
	 * 	매모장에 있는 내용을 파일에 저장하는 메서드
	 * 	file : 저장할 파일
	 * */
	private void save(File file) {
		String date = lblToday.getText();		//작성일
		String title = tfTitle.getText();		//사용자가 입력한 제목
		String tag = tfTag.getText();			//사용자가 입력한 태그
		String pw = String.valueOf(pfPw.getPassword());	//사용자가 입력한 pw
		String content = taContent.getText();
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(file);
			
			if(prop.getProperty(date) == null) {
				//해당 작성일 파일이 존재하지 않으면
				tmpFile = title;
			} else {
				//해당 작성일 파일이 존재하면 date의 키값을 뽑아와 파일제목을 이어붙인다.
				tmpFile = prop.getProperty(date) + "/" + title;
			}
			prop.setProperty(date, tmpFile);
			prop.setProperty(date+"/"+title+"/date", date);
			prop.setProperty(date+"/"+title+"/title", title);
			prop.setProperty(date+"/"+title+"/tag", tag);
			prop.setProperty(date+"/"+title+"/pw", pw);
			prop.setProperty(date+"/"+title+"/content", content);
			
			prop.store(fw, "All File Information");
			
			JOptionPane.showMessageDialog(this, "저장 성공");
			files.add(title);
			
			dispose();
			new MyMemo2(cal, owner, files);
			
		}catch(IOException e) {
			JOptionPane.showMessageDialog(this, "파일 쓰기 중 에러 발생!");
		}finally {
			try {
				fw.close();
			}catch(Exception e) {
				
			}
		}
	}
	private void showDlg() {
		setTitle("메모 창");
		pack();
		setLocation(1300, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
