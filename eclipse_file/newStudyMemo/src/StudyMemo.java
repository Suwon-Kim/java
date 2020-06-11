import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class StudyMemo extends JFrame{
	public static final Dimension BTN_SIZE = new Dimension(50, 30);
	
	private Date date = new Date();
	
	private int curYear;		//현재 년
	private int curMonth;		//현재 월
	
	private JLabel lblToday;	//오늘 날짜를 나타내는 레이블
	private JLabel lblSelect;	//사용자가 택한 년월 레이블
	
	private JPanel pnlCal;
	
	private JComboBox<String> cbYear;	//년 콤보박스
	private JComboBox<String> cbMonth;	//월 콤보박스
	
	private JButton btnCheck;	//조회 버튼
	private JButton btnSearch;	//검색 버튼
	private JButton btnLeft;	//날짜 조절 왼쪽 버튼
	private JButton btnRight;	//날짜 조절 오른쪽 버튼
	private JButton btnToday;	//today 버튼
	
	private JTextField tfInput;	//검색 텍스트필드
	
	private String[] years = new String[61];		//년 콤보박스에 나타낼 원소 리스트
	private String[] months = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};	
	//월 콤보박스에 나타낼 원소 리스트
	
	private SimpleDateFormat sdf;
	
	private MyCalendar myCal;
	
	public StudyMemo() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	public int getCurrentYear() {
		return curYear;
	}
	public int getCurrentMonth() {
		return curMonth;
	}
	private void init() {
		//Date date = new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		curYear = cal.get(Calendar.YEAR);
		curMonth = cal.get(Calendar.MONTH) + 1;
		
		myCal = new MyCalendar(date, curYear, curMonth);
		
		sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		
		lblToday = new JLabel(sdf.format(date));
		//현재 시간 -> "yyyy년 MM월 dd일 E요일" 형식으로 변환해서 lblToday 텍스트로 설정.
		lblToday.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		
		sdf = new SimpleDateFormat("yyyy.MM");
		lblSelect = new JLabel(sdf.format(date));
		//현재 시간 -> "yyyy.MM" 형식으로 변환해서 lblSelect 텍스트로 설정.
		lblSelect.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
		
		btnLeft = new JButton("◀"); 
		btnLeft.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		btnLeft.setMargin(new Insets(0, 0, 0, 0));
		
		btnRight = new JButton("▶");
		btnRight.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		btnRight.setMargin(new Insets(0, 0, 0, 0));
		
		btnCheck = new JButton("조회");
		btnSearch = new JButton("검색");
		btnSearch.setToolTipText("파일 제목이나 태그로 검색하세요");
		btnToday = new JButton("Today");
		
		
		tfInput = new JTextField(20);
		
		
		
		
		//years 초기화. 현재년도부터 위 아래로 30년을 나타낸다.
		int idx = 0;
		for(int i=curYear-30; i<=curYear+30; i++) {
			years[idx] = String.valueOf(i);
			idx++;
		}
		
		cbYear = new JComboBox<String>(years);
		cbYear.setSelectedItem(String.valueOf(curYear));
		cbMonth = new JComboBox<String>(months);
		cbMonth.setSelectedItem(String.valueOf(curMonth));
		
	}
	private void setDisplay() {
		JPanel pnlNorth = new JPanel(new BorderLayout());
		//pnlNorth : 캘린더 윗부분 전체
		
		JPanel pnlSelect = new JPanel();
		//왼쪽버튼 + yyyy.MM + 오른쪽버튼
		pnlSelect.add(btnLeft);
		pnlSelect.add(lblSelect);
		pnlSelect.add(btnRight);
		
		JPanel pnlCombo = new JPanel();
		//cbYear + 년 + cbMonth + 월 + 조회버튼
		pnlCombo.add(cbYear);
		pnlCombo.add(new JLabel("년"));
		pnlCombo.add(cbMonth);
		pnlCombo.add(new JLabel("월"));
		pnlCombo.add(btnCheck);
		
		JPanel pnlToday = new JPanel();
		pnlToday.setBorder(new EmptyBorder(10, 0, 30, 240));
		JLabel lblSpace = new JLabel();
		
		pnlToday.add(lblToday);
		pnlToday.add(btnToday);
		
		pnlNorth.add(pnlToday, BorderLayout.NORTH);
		pnlNorth.add(pnlSelect, BorderLayout.CENTER);
		pnlNorth.add(pnlCombo, BorderLayout.SOUTH);
		
		
		pnlCal = myCal.getCalPanel();
		
		JPanel pnlSouth = new JPanel();
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
			
			if(o == btnLeft) {
				//왼쪽 버튼 눌렀을 경우 할 일 정의
				//1.이전달로 레이블 세팅.
				//2.이전달 달력 세팅.
				if(curMonth > 1) {
					curMonth--;
				} else {
					curMonth = 12;
					curYear--;
				}
				
				setSelectedCalendar(curYear, curMonth);
			
			} else if(o == btnRight) {
				//오른쪽 버튼 눌렀을 경우 할 일 정의
				//1.다음달로 레이블 세팅.
				//2.다음달 달력 세팅.
				if(curMonth < 12) {
					curMonth++;
				} else {
					curMonth = 1;
					curYear++;
				}
				
				setSelectedCalendar(curYear, curMonth);
			} else if(o == btnCheck) {
				//조회 버튼 눌렀을 경우 할 일 정의
				
				if(cbYear.getSelectedItem()==null || cbMonth.getSelectedItem()==null) {
					//비어있는 콤보박스가 있다면
					PleaseSelectDate();
				} else {
					//콤보박스가 다 선택되어져 있다면
					int selectYear = Integer.parseInt((String)cbYear.getSelectedItem());
					int selectMonth = Integer.parseInt((String)cbMonth.getSelectedItem());
					
					if (!(curYear == selectYear && curMonth == selectMonth)) {
						// 현재 보여지는 년,월과 다를 때에만 달력을 새로 받아오고 콤보박스에 보여지는 값을 초기화시킨다.
						curYear = Integer.parseInt((String) cbYear.getSelectedItem());
						curMonth = Integer.parseInt((String) cbMonth.getSelectedItem());

						setSelectedCalendar(curYear, curMonth);

						cbYear.setSelectedItem(null);
						cbMonth.setSelectedItem(null);
					}
				}
				
			} else if(o == btnSearch) {
				//검색버튼 눌렀을 경우의 할 일 정의.
				String searchWord = tfInput.getText();
				//new Search_Result(searchText);
				new SearchResult(this, searchWord);
			} else if(o == btnToday) {
				//today 버튼 눌렀을 경우의 할 일 정의.
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				curYear = cal.get(Calendar.YEAR);
				curMonth = cal.get(Calendar.MONTH) + 1;
				
				setSelectedCalendar(curYear, curMonth);
			}
		};
		
		
		btnLeft.addActionListener(aListener);
		btnRight.addActionListener(aListener);
		btnCheck.addActionListener(aListener);
		btnSearch.addActionListener(aListener);
		btnToday.addActionListener(aListener);
		
	}
	private void PleaseSelectDate() {
		JOptionPane.showMessageDialog(this, "조회할 날짜를 빠짐없이 선택해주세요");
	}
	//year년 month로 레이블텍스트를 설정하고 달력을 세팅하는 메서드
	private void setSelectedCalendar(int year, int month) {
		Container c = getContentPane();
		c.remove(pnlCal);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		sdf = new SimpleDateFormat("yyyy.MM");
		lblSelect.setText(sdf.format(cal.getTime()));
		
		myCal = new MyCalendar(date, year, month);
		pnlCal = myCal.getCalPanel();
		
		
		add(pnlCal, BorderLayout.CENTER);
	}
	private void showFrame() {
		setTitle("나만의 스터디메모");
		setSize(500, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new StudyMemo();
	}
}
