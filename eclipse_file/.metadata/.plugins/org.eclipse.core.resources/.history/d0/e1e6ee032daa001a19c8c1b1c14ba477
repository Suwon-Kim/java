import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class MyCalendar extends JPanel{
	public static final Dimension LBL_SIZE = new Dimension(70, 50);
	
	private Date today;
	private int year;					//년
	private int month;					//월
	
	private JLabel[] lblWeek;			//요일 레이블 배열(SUN, MON, ..., SAT)
	private JLabel[] lblDay;			//일 레이블 배열(1,2,3,....,31)
	
	private String[] weeks = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	private int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};		//윤년x의 매달 최대일수
	private int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};	//윤년의 매달 최대일수

	private JLabel lblTmp;
	
	//생성자 : 입력한 년, 월의 달력 객체를 만든다.
	public MyCalendar(Date today, int year, int month) {
		this.today = today;
		setYear(year);
		setMonth(month);
		init();
		addListeners();
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	private void init() {
		//요일 레이블 초기화
		lblWeek = new JLabel[weeks.length];
		for(int idx=0; idx<lblWeek.length; idx++) {
			lblWeek[idx] = new JLabel(weeks[idx], JLabel.CENTER);
			lblWeek[idx].setPreferredSize(LBL_SIZE);
			lblWeek[idx].setOpaque(true);
			lblWeek[idx].setForeground(Color.WHITE);
			lblWeek[idx].setFont(new Font(Font.DIALOG, Font.BOLD, 20));
			lblWeek[idx].setBorder(new LineBorder(Color.WHITE, 2));
			if(weeks[idx].equals("SUN")) {
				//일요일 레이블이면 배경색을 빨간색으로 지정
				lblWeek[idx].setBackground(new Color(241, 95, 95));
			} else if(weeks[idx].equals("SAT")) {
				//토요일 레이블이면 배경색을 파란색으로 지정
				lblWeek[idx].setBackground(new Color(36, 120, 255));
			} else {
				//나머지 요일 레이블은 배경색을 검정색으로 지정
				lblWeek[idx].setBackground(new Color(76, 76, 76));
			}
		}
		
		Calendar cal = Calendar.getInstance();
		
		//일 레이블 초기화
		lblDay = new JLabel[getMaxDayOfMonth(year, month)];
		for(int idx=0; idx<lblDay.length; idx++) {
			lblDay[idx] = new JLabel(String.valueOf(idx+1), JLabel.CENTER);
			lblDay[idx].setPreferredSize(LBL_SIZE);
			lblDay[idx].setOpaque(true);
			lblDay[idx].setBackground(Color.WHITE);
			lblDay[idx].setForeground(Color.BLACK);
			lblDay[idx].setFont(new Font(Font.DIALOG, Font.BOLD, 15));
			
			int date = idx+1;
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH, month-1);
			cal.set(Calendar.DATE, date);
			
			if(cal.get(Calendar.DAY_OF_WEEK) == 1) {
				//일요일의 일 레이블은 글자색을 빨강으로 지정
				lblDay[idx].setForeground(new Color(241, 95, 95));
			} else if(cal.get(Calendar.DAY_OF_WEEK) == 7) {
				//토요일의 일 레이블은 글자색을 파랑으로 지정
				lblDay[idx].setForeground(new Color(36, 120, 255));
			} else {
				//나머지 요일의 일 레이블은 글자색을 검정으로 지정
				lblDay[idx].setForeground(Color.BLACK);
			}
			
			Calendar calToday = Calendar.getInstance();
			calToday.setTime(today);
			int todayYear = calToday.get(Calendar.YEAR);
			int todayMonth = calToday.get(Calendar.MONTH) + 1;
			int todayDate = calToday.get(Calendar.DATE);
			
			if(todayYear == year &&
					todayMonth == month &&
						todayDate == idx+1) {
				lblDay[idx].setBackground(new Color(255, 255, 210));
			}
		}
		fileListLoad();
	}
	public void fileListLoad() {
		//sutdyMemo 폴더를 다 읽어서 해당일의 파일폴더가 존재하고 그 안에 파일이 하나라도 있으면
		//레이블 앞에 *를 표시한다.
		File dir = new File("studyMemo");
		
		File[] fileList = dir.listFiles();
		
		if (dir.exists()) {
			// studyMemo 폴더가 존재하면
			for (File file : fileList) {
				if (file.isDirectory()) {
					// 디렉토리면
					String dirYear = file.getName().substring(0, 4);
					String dirMonth = file.getName().substring(5, 7);
					String dirDate = file.getName().substring(8);
					
					if(Integer.parseInt(dirYear) == year 
							&& Integer.parseInt(dirMonth) == month ) {
						int idx = Integer.parseInt(dirDate) - 1;
						if(file.listFiles().length != 0) {
							// 디렉토리 안에 파일이 하나라도 존재하면 레이블 앞에 파일 이미지 표시
							lblDay[idx].setIcon(new ImageIcon("file.png"));
						} else {
							lblDay[idx].setIcon(null);
						}
					}
				}
			}

		}
	}
		

	public JPanel getCalPanel() {
		JPanel pnlCal = new JPanel(new BorderLayout());
		pnlCal.setBorder(new EmptyBorder(50, 20, 50, 20));
		
		JPanel pnlWeek = new JPanel(new GridLayout(1, 7));
		
		
		//요일 레이블 붙이기
		for(int idx=0; idx<lblWeek.length; idx++) {
			pnlWeek.add(lblWeek[idx]);
		}
		
		JPanel pnlDay = new JPanel(new GridLayout(0, 7));
		
		int weekday = getWeekDay(year, month);
		//year년 month월이 몇 요일부터 시작하는 지를 받아온다.
		//ex)월요일부터 시작이면 1을 return.

		
		//공백 레이블 붙이기
		for(int idx=0; idx<weekday; idx++) {
			JLabel lblSpace = new JLabel();
			lblSpace.setPreferredSize(LBL_SIZE);
			lblSpace.setOpaque(true);
			lblSpace.setBackground(Color.WHITE);
			pnlDay.add(lblSpace);
		}
		
		//일 레이블 붙이기
		for(int idx=0; idx<lblDay.length; idx++) {
			pnlDay.add(lblDay[idx]);
		}
		
		
		Calendar cal = Calendar.getInstance();
		
		int lastDay = getMaxDayOfMonth(year, month);
		
		cal.set(year, month-1, lastDay);	
		//year년 month월의 마지막날로 cal 날짜를 설정
		int lastWeek = cal.get(Calendar.DAY_OF_WEEK);
		//그 달 마지막 날의 요일을 구해온다.
		
		
		
		//나머지 공백 레이블 붙이기
		for(int idx=0; idx<7-lastWeek; idx++) {
			JLabel lblSpace = new JLabel();
			lblSpace.setPreferredSize(LBL_SIZE);
			lblSpace.setOpaque(true);
			lblSpace.setBackground(Color.WHITE);
			pnlDay.add(lblSpace);
		}
		
		pnlCal.add(pnlWeek, BorderLayout.NORTH);
		pnlCal.add(pnlDay, BorderLayout.CENTER);
		
		return pnlCal;
	}
	private void addListeners() {
		MouseListener mListener = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				JLabel lbl = (JLabel)me.getSource();
				lbl.setBorder(new LineBorder(new Color(255, 193, 158), 2));
			}
			@Override
			public void mouseExited(MouseEvent me) {
				JLabel lbl = (JLabel)me.getSource();
				lbl.setBorder(null);
			}
			@Override
			public void mouseClicked(MouseEvent me) {
				JLabel lbl = (JLabel)me.getSource();
				
				int day = Integer.parseInt(lbl.getText());
				
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR, year);
				cal.set(Calendar.MONTH, month-1);
				cal.set(Calendar.DATE, day);
				//new MyMemo(year, month, day);
				new MyMemo(cal, MyCalendar.this);
			}
		};
		
		for(int idx=0; idx<lblDay.length; idx++) {
			lblDay[idx].addMouseListener(mListener);
		}
	}
	public boolean isLeapYear(int year) {
		if(year % 4 == 0 && (year % 100 != 100 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}
	public int getMaxDayOfMonth(int year, int month) {
		if(isLeapYear(year)) {
			return LEAP_MAX_DAYS[month-1];
		} else {
			return MAX_DAYS[month-1];
		}
	}
	private int getWeekDay(int year, int month) {
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, year);
		date.set(Calendar.MONTH, month-1);
		date.set(Calendar.DATE, 1);
		int weekday = date.get(Calendar.DAY_OF_WEEK) - 1;
		
		return weekday;
	}
}
