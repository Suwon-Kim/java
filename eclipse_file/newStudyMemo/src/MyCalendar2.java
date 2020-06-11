import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyCalendar2 extends JFrame {
	public static final Dimension LBL_SIZE = new Dimension(70,50);
	
	private Date today;
	private int year;
	private int month;
	
	private JLabel[] lblWeek = new JLabel[7];
	private JLabel[] lblDay;
	
	private String[] weeks = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
	//MAX_DAYS[0] = 1��, MAX_DAYS[1] = 2��, MAX_DAYS[2] = 3��
	private int[] MAX_DAYS = {31,28,31,30,31,30,31,31,30,31,30,31};	//���� X
	private int[] LEAP_MAX_DAYS = {31,29,31,30,31,30,31,31,30,31,30,31};//����
	
	public MyCalendar2(Date today, int year, int month) {
		this.today = today;
		this.year = year;
		this.month = month;
		init();
		setDisplay();
		showFrame();
	}
	private boolean isLeapYear(int year) {
		if(year % 4 == 0 && (year % 100 != 100 || year % 400 == 0)) {
			return true;	//�����̸� true
		} else {
			return false;	//������ �ƴϸ� false;
		}
	}
	
	private int getMaxOfDay(int year, int month) {
		if(isLeapYear(year)) {
			return LEAP_MAX_DAYS[month-1];
			//return 30
		} else {
			return MAX_DAYS[month-1];
		}
	}
	private void init() {
		JPanel pnlWeek = new JPanel();
		for(int i = 0; i < weeks.length; i++) {
			lblWeek[i] = new JLabel(weeks[i]);
			pnlWeek.add(lblWeek[i]);
		}
		
		//lblDay = new JLabel[30];
		//i = 0; i < 30; i++
		JPanel pnlDay = new JPanel();
		lblDay = new JLabel[getMaxOfDay(year,month)];
		for(int i = 0; i < lblDay.length; i++) {
			lblDay[i] = new JLabel(String.valueOf(i + 1), JLabel.CENTER);
			pnlDay.add(lblDay[i]);
		}
		JPanel pnlMain = new JPanel(new GridLayout(2,1));
		pnlMain.add(pnlWeek);
		pnlMain.add(pnlDay);

		add(pnlMain, BorderLayout.CENTER);
	}
	private void setDisplay() {
		
	}
	private void showFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyCalendar2(new Date(),2020,5);
	}
	
}