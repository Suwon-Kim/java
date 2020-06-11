import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Test extends JDialog {
	public static final Dimension LBL_SIZE = new Dimension(50,22);
	public static final File DIR = new File("studyMemo");
	public static final String EXT = ".txt";
	private Calendar cal;
	
	private Properties prop = new Properties();
	
	private JPanel pnlCenter = new JPanel(new BorderLayout());
	private JPanel pnlFileList = new JPanel(new GridLayout(0, 1));
	
	private String selectDay;
	
	private MyCalendar owner;
	
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
	private JTextField tfTag;
	private JPasswordField pfPw;
	
	private JTextArea taContent;
	
	private File currentFile;
	
	public Test(Calendar cal, MyCalendar owner) {
		this.cal = cal;
		this.owner = owner;
		init();
		setDisplay();
		addListeners();
		showDlg();
	}
	public Test() {
		init();
		setDisplay();
		addListeners();
		showDlg();
	}
	private void init() {
		lblReportDate = new JLabel("작성일 : ", JLabel.LEFT);
		lblReportDate.setPreferredSize(LBL_SIZE);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		
		selectDay = sdf.format(cal.getTime());
		
		lblToday = new JLabel(selectDay);
		
		lblTitle = new JLabel("제   목 : ", JLabel.LEFT);
		lblTitle.setPreferredSize(LBL_SIZE);
		lblTag = new JLabel("태     그 ", JLabel.LEFT);
		lblTag.setPreferredSize(LBL_SIZE);
		lblPw = new JLabel("    PW    : ", JLabel.LEFT);
		lblPw.setPreferredSize(LBL_SIZE);
		
		tfTitle = new JTextField(15);
		tfTag = new JTextField(20);
		pfPw = new JPasswordField(10);
		
		taContent = new JTextArea(10, 15);
		
		btnSave = new JButton("저장");
		btnRemove = new JButton("삭제");
		btnCancel = new JButton("취소");
		btnPlus = new JButton("+");
	}
	private void setDisplay() {
		JPanel pnlNorth = new JPanel();
		
		JPanel pnlLbl = new JPanel(new GridLayout(4, 1));
		pnlLbl.add(lblReportDate);
		pnlLbl.add(lblTitle);
		pnlLbl.add(lblTag);
		pnlLbl.add(lblPw);
		
		JPanel pnlTf = new JPanel(new GridLayout(4, 1));
		pnlTf.add(lblToday);
		pnlTf.add(tfTitle);
		pnlTf.add(tfTag);
		pnlTf.add(pfPw);
		
		pnlNorth.add(pnlLbl);
		pnlNorth.add(pnlTf);
		
		JScrollPane scroll = new JScrollPane(taContent);
		scroll.setPreferredSize(new Dimension(500, 300));
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		//String selectDay = "yyyy.mm.dd";
		fileListLoad(selectDay);
		
	}
	private void fileListLoad(String selectDay) {
		//File dir = new File(studyMemo, "2020.06.08");
		File dir = new File(DIR, selectDay);
		
		int count = 0;
		
		if(dir.listFiles() != null) {
			for(File file : dir.listFiles()) {
				if(!file.isDirectory()) {
					count++;
				}
			}
			lblFileList = new JLabel[count];
		}
	}
	private void addListeners() {
		
	}
	private void showDlg() {
		setTitle("메모창");
		pack();
		//setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Test();
	}
}
