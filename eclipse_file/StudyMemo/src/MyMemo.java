import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
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
import java.util.Properties;

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


public class MyMemo extends JDialog{
	public static final Dimension LBL_SIZE = new Dimension(50, 22);
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
	
	public MyMemo(Calendar cal, MyCalendar owner) {
		this.cal = cal;
		this.owner = owner;
		
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
		
		lblTitle = new JLabel("제    목 : ", JLabel.LEFT);
		lblTitle.setPreferredSize(LBL_SIZE);
		lblTag = new JLabel("태    그 : ", JLabel.LEFT);
		lblTag.setPreferredSize(LBL_SIZE);
		lblPw = new JLabel("   PW   : ", JLabel.LEFT);
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
		
		fileListLoad(selectDay);
		if(lblFileList != null) {
			for(JLabel lbl : lblFileList) {
				JPanel pnlLine = new JPanel();
				
				JLabel lblImage = new JLabel();
				lblImage.setIcon(new ImageIcon("file.png"));
				
				pnlLine.add(lblImage);
				pnlLine.add(lbl);
				
				pnlFileList.add(pnlLine);
			}

			pnlCenter.add(pnlFileList, BorderLayout.NORTH);
		}
		pnlCenter.add(scroll, BorderLayout.CENTER);
		
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnSave);
		pnlSouth.add(btnRemove);
		pnlSouth.add(btnCancel);
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	private void getImageFileList() {
		pnlFileList.removeAll();
		
		fileListLoad(selectDay);
		if(lblFileList != null) {
			for(JLabel lbl : lblFileList) {
				JPanel pnlLine = new JPanel();
				
				JLabel lblImage = new JLabel();
				lblImage.setIcon(new ImageIcon("file.png"));
				
				pnlLine.add(lblImage);
				pnlLine.add(lbl);
				
				pnlFileList.add(pnlLine);
			}
			pnlCenter.add(pnlFileList, BorderLayout.NORTH);
		}
	}
	private void addListeners() {
		ActionListener aListener = (ae) -> {
			Object o = ae.getSource();
			if(o == btnSave) {
				String dir = lblToday.getText();
				String fileName = tfTitle.getText();
				save(dir, fileName);
				owner.fileListLoad();
			} else if(o == btnRemove) {
				remove();
				owner.fileListLoad();
			} else if(o == btnCancel) {
				dispose();
			} else if(o == btnPlus) {
				
			}
		};
		
		MouseListener mListener = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				JLabel lbl = (JLabel)me.getSource();
				String fileName = lbl.getText();
				fileLoad(fileName);
			}
		};
		
		btnSave.addActionListener(aListener);
		btnRemove.addActionListener(aListener);
		btnCancel.addActionListener(aListener);
		btnPlus.addActionListener(aListener);
		
		if(lblFileList != null) {
			for(int idx=0; idx<lblFileList.length; idx++) {
				lblFileList[idx].addMouseListener(mListener);
			}
		}
	}
	private void save(String dir, String fileName) {
		FileWriter fw = null;
		
		try {
			File dateDir = new File(DIR, dir);
			//studyMemo/작성일     디렉토리 생성
			if(!dateDir.exists()) {
				dateDir.mkdirs();
				//dateDir 경로가 존재하지 않으면 상위 경로까지 모두 생성
			}
			
			fw = new FileWriter(dateDir + "\\" +  fileName + ".properties");
		
			prop.setProperty("reportDate", lblToday.getText());
			prop.setProperty("title", tfTitle.getText());
			prop.setProperty("tag", tfTag.getText());
			prop.setProperty("pw", String.valueOf(pfPw.getPassword()));
			prop.setProperty("content", taContent.getText());
			prop.store(fw, tfTitle.getText());
			
			JOptionPane.showMessageDialog(this, "저장 성공!");
			
			dispose();
			new MyMemo(cal, owner);
	
		}catch(IOException e) {
			JOptionPane.showMessageDialog(this, "파일 쓰기 중 에러 발생!");
		}finally { 
			try {
				fw.close();
			}catch(Exception e) {}
		}
	}
	private void fileLoad(String fileName) {
		FileReader fr = null;
		File dateDir = new File(DIR, selectDay);
		
		try {
			fr = new FileReader(dateDir + "\\" + fileName);
			prop.load(fr);
			
			tfTitle.setText(prop.getProperty("title"));
			tfTag.setText(prop.getProperty("tag"));
			taContent.setText(prop.getProperty("content"));
			
			currentFile = new File(dateDir + "\\" + fileName);
		
		}catch(IOException e) {
			JOptionPane.showMessageDialog(this, "파일 읽기 중 에러 발생!");
		}finally {
			try {
				fr.close();
			}catch(Exception e) {
				
			}
		}
	}
	private void fileListLoad(String selectDay) {
		File dir = new File(DIR, selectDay);
		
		int count = 0;
		
		if(dir.listFiles() != null) {
			for(File file : dir.listFiles()) {
				if(!file.isDirectory()) {
					count++;
				}
			}
			lblFileList = new JLabel[count];
			
			int idx = 0;
			for(File file : dir.listFiles()) {
				if(!file.isDirectory()) {
					lblFileList[idx] = new JLabel(file.getName());
					idx++;
				}
			}
		}
	}
	private void remove() {
		String userPw = String.valueOf(pfPw.getPassword());
		if(userPw.equals(prop.getProperty("pw"))) {
			prop = null;
			
			currentFile.delete();
			
			dispose();
			new MyMemo(cal, owner);
		}
	}
	private void showDlg() {
		setTitle("메모창");
		pack();
		//setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
