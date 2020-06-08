import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Test2 extends JDialog {
	public static final Dimension LBL_SIZE = new Dimension(50,22);
	public static final File DIR = new File("studyMemo");
	public static final String EXT = ".txt";
	private Calendar cal;
	
	//Properties -- > 설정 파일 (key와 value를 가지고 있다)
	private Properties prop = new Properties();
	
	private JPanel pnlCenter = new JPanel(new BorderLayout());
	
	private int curYear;
	private int curMonth;
	private String selectDay;
	
	private JLabel lblReportDate;
	private JLabel lblTitle;
	private JLabel lblTag;
	private JLabel lblPw;
	private JLabel lblToday;
	private JLabel[] lblFileList;
	
	private JButton btnSave;
	private JButton btnRemove;
	private JButton btnCancel;
	private JButton btnPlus;
	
	private JTextField tfTitle;
	private JTextField tfTage;
	private JPasswordField pfPw;
	
	private JTextArea taContent;
	
	public Test2(Calendar cal) {
		this.cal = cal;
		
		init();
		setDisplay();
		addListeners();
		showDlg();
	}
	private void init() {
		lblReportDate = new JLabel("작성일 : ", JLabel.LEFT);
		lblReportDate.setPreferredSize(LBL_SIZE);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		
		selectDay = sdf.format(cal.getTime());
		
		lblToday = new JLabel(selectDay);
		
		
	}
	private void setDisplay() {
		
	}
	private void addListeners() {
		
	}
	private void showDlg() {
		
	}
	public static void main(String[] args) {
		System.out.println();
	}
}
