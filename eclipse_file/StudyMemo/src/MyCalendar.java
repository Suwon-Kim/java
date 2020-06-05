import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MyCalendar extends JFrame{
	public static final Dimension LBL_SIZE = new Dimension(70, 50);
	
	private int year;					//년
	private int month;					//월
	
	private JLabel[] lblWeek;			//요일 레이블 배열(SUN, MON, ..., SAT)
	private JLabel[] lblDay;			//일 레이블 배열(1,2,3,....,31)
	
	private String[] weeks = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	private int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};		//윤년x의 매달 최대일수
	private int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};	//윤년의 매달 최대일수
	

	public MyCalendar(int year, int month) {
		setYear(year);
		setMonth(month);
		init();
		setDisplay();
		addListeners();
		showFrame();
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
			lblWeek[idx].setBackground(Color.BLACK);
			lblWeek[idx].setForeground(Color.WHITE);
			lblWeek[idx].setFont(new Font(Font.DIALOG, Font.BOLD, 20));
			lblWeek[idx].setBorder(new LineBorder(Color.WHITE, 2));
		}
		
		//일 레이블 초기화
		lblDay = new JLabel[getMaxDayOfMonth(year, month)];
		for(int idx=0; idx<lblDay.length; idx++) {
			lblDay[idx] = new JLabel(String.valueOf(idx+1), JLabel.CENTER);
			lblDay[idx].setPreferredSize(LBL_SIZE);
			lblDay[idx].setOpaque(true);
			lblDay[idx].setBackground(Color.WHITE);
			lblDay[idx].setForeground(Color.BLACK);
			lblDay[idx].setFont(new Font(Font.DIALOG, Font.BOLD, 15));
			//lblDay[idx].setBorder(new LineBorder(Color.GRAY, 2));
		}
	}
	private void setDisplay() {
		JPanel pnlCal = new JPanel(new GridLayout(0, 7));
		
		//요일 레이블 붙이기
		for(int idx=0; idx<lblWeek.length; idx++) {
			pnlCal.add(lblWeek[idx]);
		}
		
		int weekday = getWeekDay(year, month);
		
		//공백 레이블 붙이기
		for(int idx=0; idx<weekday; idx++) {
			JLabel lblSpace = new JLabel();
			lblSpace.setPreferredSize(LBL_SIZE);
			lblSpace.setOpaque(true);
			lblSpace.setBackground(Color.WHITE);
			pnlCal.add(lblSpace);
		}
		
		//일 레이블 붙이기
		for(int idx=0; idx<lblDay.length; idx++) {
			pnlCal.add(lblDay[idx]);
		}
		
		add(pnlCal, BorderLayout.CENTER);
		
	}
	private void addListeners() {
		
	}
	private void showFrame() {
		setTitle("dd");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
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
	public static void main(String[] args) {
		new MyCalendar(2020, 8);
	}
}
