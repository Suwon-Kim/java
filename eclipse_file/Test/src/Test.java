import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Test extends JPanel {
	public static final Dimension LBL_SIZE = new Dimension(70,50);
	
	private int year;	//년
	private int month;	//월
	
	private JLabel[] lblWeek;	//요일 레이블 배열 (SUN, MON, ... SAT)
	private JLabel[] lblDay;	//일 레이블 배열 (1,2,3,....31)
	
	private String[] weeks = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
	private int[] MAX_DAYS = {31,28,31,30,31,30,31,31,30,31,30,31};
	private int[] LEAP_MAX_DAYS = {31,29,31,30,31,30,31,31,30,31,30,31};
	
	public Test(int year, int month) {
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
	public void init() {
		//요일 레이블 초기화
		lblWeek = new JLabel[weeks.length];	
		for(int idx = 0; idx < lblWeek.length; idx++) {
			lblWeek[idx] = new JLabel(weeks[idx], JLabel.CENTER);
			lblWeek[idx].setPreferredSize(LBL_SIZE);
			lblWeek[idx].setOpaque(true);
			lblWeek[idx].setForeground(Color.WHITE);
			lblWeek[idx].setFont(new Font(Font.DIALOG, Font.BOLD, 20));
			lblWeek[idx].setBorder(new LineBorder(Color.WHITE, 2));
			if(weeks[idx].equals("SUN")) {
				lblWeek[idx].setBackground(new Color(241,95,95));
			} else if (weeks[idx].equals("SAT")) {
				lblWeek[idx].setBackground(new Color(36,120,255));
			} else {
				lblWeek[idx].setBackground(new Color(76,76,76));
			}
			
		}
		//캘린더 객체 생성할 때 Canlendar.getInstance();
		Calendar cal = Calendar.getInstance();
		
		//year 2020
		//month 06
		lblDay = new JLabel[getMaxDayOfMonth(year, month)];
		//lblDay = new JLabel[30];
		for(int idx = 0; idx <lblDay.length; idx++) {
			lblDay[idx] = new JLabel(String.valueOf(idx + 1), JLabel.CENTER);
			lblDay[idx].setPreferredSize(LBL_SIZE);
			lblDay[idx].setOpaque(true);
			lblDay[idx].setBackground(Color.WHITE);
//			lblDay[idx].setForeground(Color.BLACK);
			lblDay[idx].setFont(new Font(Font.DIALOG, Font.BOLD, 15));
			
			int date = idx + 1;
			cal.set(Calendar.YEAR, year);	//2020년
			cal.set(Calendar.MONTH,  month-1);	//06월
			cal.set(Calendar.DATE, date);	//01일
			
			//요일을 수로 표현 
			//(1: 일, 2: 월, 3: 화, 4: 수, 5: 목, 6: 금, 7 : 토
			if(cal.get(Calendar.DAY_OF_WEEK) == 1) {
				lblDay[idx].setForeground(new Color(241, 95, 95));
			} else if (cal.get(Calendar.DAY_OF_WEEK) == 7) {
				lblDay[idx].setForeground(new Color(36, 120, 255));
			} else {
				lblDay[idx].setForeground(Color.BLACK);
			}
		}
	}
	public void addListeners() {
		MouseListener mListener = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				JLabel lbl = (JLabel)me.getSource();
				lbl.setBorder(new LineBorder(new Color(255,193,158), 2));
			}
			@Override
			public void mouseClicked(MouseEvent me) {
				JLabel lbl = (JLabel)me.getSource();
				int day = Integer.parseInt(lbl.getText());
				
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR, year);
				cal.set(Calendar.MONTH, month-1);
				cal.set(Calendar.DATE, day);
				
				new Test2(cal);
			}
		};
	}
	public JPanel getCalPanel() {
		JPanel pnlCal = new JPanel(new BorderLayout());
		pnlCal.setBorder(new EmptyBorder(50, 20, 50, 20));
		
		JPanel pnlWeek = new JPanel(new GridLayout(1, 7));
		
		for(int idx = 0; idx < lblWeek.length; idx++) {
			pnlWeek.add(lblWeek[idx]);
		}
		
		JPanel pnlDay = new JPanel(new GridLayout(0, 7));
		
		int weekday = getWeekDay(year, month);
		//year년 month월이 무슨 요일부터 시작하는지를 받아온다.
		//ex)월요일부터 시작이면 1을 return 
		
		for(int idx = 0 ; idx < weekday; idx++) {
			JLabel lblSpace = new JLabel();
			lblSpace.setPreferredSize(LBL_SIZE);
			lblSpace.setOpaque(true);
			lblSpace.setBackground(Color.WHITE);
			pnlDay.add(lblSpace);
		}
		//lblDay.length == > 30 
		for(int idx = 0; idx < lblDay.length; idx++) {
			pnlDay.add(lblDay[idx]);
		}
		
		Calendar cal = Calendar.getInstance();
		
		//lastDay = 30
		int lastDay = getMaxDayOfMonth(year, month);
		
		cal.set(year,  month-1, lastDay);
		//2020, 6, 30
		
		//DAY_OF_WEEK = 3
		int lastWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		
		for(int idx = 0; idx < 7 - lastWeek; idx++) {
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
	private int getWeekDay(int year, int month) {
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, year);	//2020년
		date.set(Calendar.MONTH, month-1);	//06월
		date.set(Calendar.DATE, 1);	//01일
		
		// DAY_OF_WEEK = 2     1일이 월요일이면 공백하나, 1일이 화요일이면 공백 둘  -- > 
		// int weekday = 1;
		int weekday = date.get(Calendar.DAY_OF_WEEK) - 1;	//앞의 공백 개수를 출력하기 위해서
		
		return weekday;
	}
	public boolean isLeapYear(int year) {
		if(year % 4 == 0 && (year % 100 != 100 || year % 400 == 0)) {
			return true;	//윤년 O
		} else 
			return false;	//윤년 X
	}
	//2020년 5월 
	//year = 2020, month = 5
	public int getMaxDayOfMonth(int year, int month) {
		if(isLeapYear(year)) {
			return LEAP_MAX_DAYS[month-1];	//윤년의 최대 일수 뽑아옴
		} else {
			return MAX_DAYS[month-1];		// 윤년이 아닌날의 최대 일수를 뽑아옴
		}
	}
	
}
