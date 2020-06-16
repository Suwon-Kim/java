import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class StudyMemo extends JFrame {
	public static final Dimension BTN_SIZE = new Dimension(50, 30);

	private Date date = new Date();

	private int curYear; // 현재 년
	private int curMonth; // 현재 월

	private JLabel lblToday; // 오늘 날짜를 나타내는 레이블
	private JLabel lblSelect; // 사용자가 택한 년월 레이블

	private JPanel pnlCal;

	private JComboBox<String> cbYear; // 년 콤보박스
	private JComboBox<String> cbMonth; // 월 콤보박스

	private JButton btnCheck; // 조회 버튼
	private JButton btnSearch; // 검색 버튼
	private JButton btnLeft; // 날짜 조절 왼쪽 버튼
	private JButton btnRight; // 날짜 조절 오른쪽 버튼
	private JButton btnToday; // today 버튼

	private JTextField tfInput; // 검색 텍스트필드

	private String[] years = new String[61]; // 년 콤보박스에 나타낼 원소 리스트
	private String[] months = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	// 월 콤보박스에 나타낼 원소 리스트

	private SimpleDateFormat sdf;

	private MyCalendar myCal;
	
	private Vector<FileInfo> vecFile;

	public StudyMemo() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	public Vector<FileInfo> getVecFile() {
		return vecFile;
	}
	//vecFile에 FileInfo 객체를 추가하는 메서드
	public void addFile(FileInfo file) {
		if(vecFile == null) {
			vecFile = new Vector<FileInfo>();
		}
		vecFile.add(file);
	}
	
	//vecFile에서 FileInfo 객체를 삭제하는 메서드
	public void removeFile(FileInfo file) {
		vecFile.remove(file);
	}

	public int getCurrentYear() {
		return curYear;
	}

	public int getCurrentMonth() {
		return curMonth;
	}

	public MyCalendar getCalendar() {
		return myCal;
	}
	//파일에서 정보를 읽어들여 vecFile에 세팅한다.
	private void fileLoad() {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			File file = new File("allFileInfo.txt");
			file.createNewFile();
			
			if(file != null) {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				vecFile = new Vector<FileInfo>();
				
				String line = null;
				while((line = br.readLine()) != null) {
					String date = line;
					String title = br.readLine();
					String tag = br.readLine();
					String pw = br.readLine();
					String content = br.readLine();
					
					vecFile.add(new FileInfo(date, title, tag, pw, content));
				}
			}
		}catch(IOException e) {
			JOptionPane.showMessageDialog(this, "파일 읽기 중 에러 발생!");
		}finally {
			try {
				br.close();
			}catch(Exception e) {
				
			}
			try {
				fr.close();
			}catch(Exception e) {
				
			}
		}
	}
	//내가 가진 vecFile을 파일에 저장
	private void fileStore() {
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter("allFileInfo.txt");
			pw = new PrintWriter(fw);
			
			if(vecFile != null) {
				for(FileInfo file : vecFile) {
					pw.println(file.getDate());
					pw.println(file.getTitle());
					pw.println(file.getTag());
					pw.println(file.getPw());
					pw.println(file.getContent());
				}
			}
			pw.flush();
		}catch(IOException e) {
			JOptionPane.showMessageDialog(this, "파일 저장 중 에러 발생!");
		}finally {
			try {
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void init() {
		fileLoad();
		 Date date = new Date();
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		curYear = cal.get(Calendar.YEAR);
		curMonth = cal.get(Calendar.MONTH) + 1;

		myCal = new MyCalendar(this, date, curYear, curMonth);

		sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");

		lblToday = new JLabel(sdf.format(date));
		// 현재 시간 -> "yyyy년 MM월 dd일 E요일" 형식으로 변환해서 lblToday 텍스트로 설정.
		lblToday.setFont(new Font("MapoGoldenPier", Font.BOLD, 14));
		

		sdf = new SimpleDateFormat("yyyy.MM");
		lblSelect = new JLabel(sdf.format(date));
		// 현재 시간 -> "yyyy.MM" 형식으로 변환해서 lblSelect 텍스트로 설정.
		lblSelect.setFont(new Font("MapoGoldenPier", Font.BOLD, 24));

		btnLeft = new JButton("<");
		btnLeft.setBorder(new LineBorder(Color.pink, 2));
		btnLeft.setFont(new Font("MapoGoldenPier", Font.BOLD, 20));
		btnLeft.setMargin(new Insets(0, 0, 0, 0));
		btnLeft.setBackground(Color.PINK);

		btnRight = new JButton(">");
		btnRight.setBorder(new LineBorder(Color.pink, 2));
		btnRight.setFont(new Font("MapoGoldenPier", Font.BOLD, 20));
		btnRight.setMargin(new Insets(0, 0, 0, 0));
		btnRight.setBackground(Color.PINK);

		btnCheck = new JButton("조회");
		btnCheck.setPreferredSize(BTN_SIZE);
		btnCheck.setBorder(new LineBorder(Color.pink, 2));
		btnCheck.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		btnCheck.setBackground(Color.pink);
		btnSearch = new JButton("검색");
		btnSearch.setPreferredSize(BTN_SIZE);
		btnSearch.setBorder(new LineBorder(Color.pink, 2));
		btnSearch.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		btnSearch.setToolTipText("파일 제목이나 태그로 검색하세요");
		btnSearch.setBackground(Color.pink);
		btnToday = new JButton("Today");
		btnToday.setPreferredSize(BTN_SIZE);
		btnToday.setBorder(new LineBorder(Color.pink, 2));
		btnToday.setFont(new Font("MapoGoldenPier", Font.BOLD, 14));
		btnToday.setBackground(Color.pink);

		tfInput = new JTextField(20);

		// years 초기화. 현재년도부터 위 아래로 30년을 나타낸다.
		int idx = 0;
		for (int i = curYear - 30; i <= curYear + 30; i++) {
			years[idx] = String.valueOf(i);
			idx++;
		}

		cbYear = new JComboBox<String>(years);
		cbYear.setBorder(new LineBorder(Color.pink, 2));
		cbYear.setSelectedItem(String.valueOf(curYear));
		cbYear.setBackground(Color.pink);
		cbMonth = new JComboBox<String>(months);
		cbMonth.setBorder(new LineBorder(Color.pink, 2));
		cbMonth.setSelectedItem(String.valueOf(curMonth));
		cbMonth.setBackground(Color.pink);

	}

	private void setDisplay() {
		JPanel pnlNorth = new JPanel(new BorderLayout());
	
		// pnlNorth : 캘린더 윗부분 전체

		JPanel pnlSelect = new JPanel();
		pnlSelect.setBackground(new Color(255, 234, 234));
		

		// 왼쪽버튼 + yyyy.MM + 오른쪽버튼
		pnlSelect.add(btnLeft);
		pnlSelect.add(lblSelect);
		pnlSelect.add(btnRight);

		JPanel pnlCombo = new JPanel();
		pnlCombo.setBackground(new Color(255, 234, 234));
		
		// cbYear + 년 + cbMonth + 월 + 조회버튼
		pnlCombo.add(cbYear);
		pnlCombo.add(new JLabel("년"));
		pnlCombo.add(cbMonth);
		pnlCombo.add(new JLabel("월"));
		pnlCombo.add(btnCheck);

		JPanel pnlToday = new JPanel();
		pnlToday.setBackground(new Color(255, 234, 234));
		
		pnlToday.setBorder(new EmptyBorder(10, 0, 30, 230));

		pnlToday.add(lblToday);
		pnlToday.add(btnToday);

		pnlNorth.add(pnlToday, BorderLayout.NORTH);
		pnlNorth.add(pnlSelect, BorderLayout.CENTER);
		pnlNorth.add(pnlCombo, BorderLayout.SOUTH);

		pnlCal = myCal.getCalPanel();
		

		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(new Color(255, 234, 234));
		
		JLabel lblImage = new JLabel();
		lblImage.setIcon(new ImageIcon("search.png"));
		pnlSouth.add(lblImage);
		pnlSouth.add(tfInput);
		pnlSouth.add(btnSearch);

		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCal, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);

	}

	private void addListeners() {
		ActionListener aListener = (ae) -> {
			Object o = ae.getSource();

			if (o == btnLeft) {
				// 왼쪽 버튼 눌렀을 경우 할 일 정의
				// 1.이전달로 레이블 세팅.
				// 2.이전달 달력 세팅.
				if (curMonth > 1) {
					curMonth--;
				} else {
					curMonth = 12;
					curYear--;
				}

				setSelectedCalendar(curYear, curMonth);

			} else if (o == btnRight) {
				// 오른쪽 버튼 눌렀을 경우 할 일 정의
				// 1.다음달로 레이블 세팅.
				// 2.다음달 달력 세팅.
				if (curMonth < 12) {
					curMonth++;
				} else {
					curMonth = 1;
					curYear++;
				}

				setSelectedCalendar(curYear, curMonth);
			} else if (o == btnCheck) {
				// 조회 버튼 눌렀을 경우 할 일 정의

				if (cbYear.getSelectedItem() == null || cbMonth.getSelectedItem() == null) {
					// 비어있는 콤보박스가 있다면
					PleaseSelectDate();
				} else {
					// 콤보박스가 다 선택되어져 있다면
					int selectYear = Integer.parseInt((String) cbYear.getSelectedItem());
					int selectMonth = Integer.parseInt((String) cbMonth.getSelectedItem());

					if (!(curYear == selectYear && curMonth == selectMonth)) {
						// 현재 보여지는 년,월과 다를 때에만 달력을 새로 받아오고 콤보박스에 보여지는 값을 초기화시킨다.
						curYear = Integer.parseInt((String) cbYear.getSelectedItem());
						curMonth = Integer.parseInt((String) cbMonth.getSelectedItem());

						setSelectedCalendar(curYear, curMonth);

						cbYear.setSelectedItem(null);
						cbMonth.setSelectedItem(null);
					}
				}

			} else if (o == btnSearch) {
				// 검색버튼 눌렀을 경우의 할 일 정의.
				String searchWord = tfInput.getText();

				new SearchResult(this, searchWord);

			} else if (o == btnToday) {
				// today 버튼 눌렀을 경우의 할 일 정의.
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				curYear = cal.get(Calendar.YEAR);
				curMonth = cal.get(Calendar.MONTH) + 1;

				String lblDate = lblSelect.getText();
				int lblYear = Integer.parseInt(lblDate.substring(0, 4));
				int lblMonth = Integer.parseInt(lblDate.substring(5, 7));
				if (!(curYear == lblYear && curMonth == lblMonth)) {
					setSelectedCalendar(curYear, curMonth);
				}
			}
		};

		btnLeft.addActionListener(aListener);
		btnRight.addActionListener(aListener);
		btnCheck.addActionListener(aListener);
		btnSearch.addActionListener(aListener);
		btnToday.addActionListener(aListener);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				fileStore();
				System.exit(0);
			}
		});

	}

	private void PleaseSelectDate() {
		JOptionPane.showMessageDialog(this, "조회할 날짜를 빠짐없이 선택해주세요");
	}

	// year년 month로 레이블텍스트를 설정하고 달력을 세팅하는 메서드
	private void setSelectedCalendar(int year, int month) {
		Container c = getContentPane();
		c.remove(pnlCal);

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		sdf = new SimpleDateFormat("yyyy.MM");
		lblSelect.setText(sdf.format(cal.getTime()));

		myCal = new MyCalendar(this, date, year, month);
		pnlCal = myCal.getCalPanel();

		add(pnlCal, BorderLayout.CENTER);
	}

	private void showFrame() {
		setTitle("나만의 스터디메모");
		setSize(500, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new StudyMemo();
	}
}
