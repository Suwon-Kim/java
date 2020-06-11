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
	
	private JLabel lblManual;	//���� ���̺�
	private JLabel lblDate;		//�ۼ��� ���̺�
	private JLabel lblTitle;	//���� ���̺�
	private JLabel lblTag;		//�±� ���̺�
	private JLabel lblPw;		//PW ���̺�
	private JLabel lblToday;	//�ۼ���(yyyy.MM.dd) ���̺�
	
	private JLabel[] lblFileList;	//���ϸ�ϸ���Ʈ���̺�
	
	private JTextField tfTitle;		//���� �ؽ�Ʈ�ʵ�
	private JTextField tfTag;		//�±� �ؽ�Ʈ�ʵ�
	private JPasswordField pfPw;	//pw �н������ʵ�
	
	private JButton btnReset;		//reset(+���) ��ư
	private JButton btnSave;		//���� ��ư
	private JButton btnRemove;		//���� ��ư
	private JButton btnCancel;		//��� ��ư
	
	private JTextArea taContent;	//����
	
	private Properties prop = new Properties();
	private TreeSet<String> fileListSet = new TreeSet<String>();
	//�ۼ��� Ű���� �����ϴ� �������� �������� StringTokenizer�� ����� ", " �����ڷ� ���� ��Ƴ��� ����.
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	
	private File file = new File("allFileInfo.properties");
	private String tmpFile;
	
	private TreeSet<String> files = new TreeSet<String>();
	
	//MyCalendar���� �ۼ���(cal)�� �޾ƿ´�.
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
		lblManual = new JLabel("������ Ŭ���ϸ� ������ �ҷ��� �� �ֽ��ϴ�~");
		//lblManual.setPreferredSize(LBL_SIZE);
		lblDate = new JLabel("�ۼ��� : ", JLabel.LEFT);
		lblDate.setPreferredSize(LBL_SIZE);
		lblTitle = new JLabel("��    �� : ", JLabel.LEFT);
		lblTitle.setPreferredSize(LBL_SIZE);
		lblTag = new JLabel("��    �� : ", JLabel.LEFT);
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
		btnReset.setToolTipText("�� �޸� �����մϴ�.");
		btnSave = new JButton("����");
		btnRemove = new JButton("����");
		btnCancel = new JButton("���");
		
		
		// ���ϸ�ϸ���Ʈ�� �����ϸ� -> pnlCenter�� BorderLayout.NORTH�� ���δ�.
		
		String date = lblToday.getText();

		readFileList(file, date);
		// "allFileInfo.properties" ���Ͽ��� date��� Ű ���� value�� �б�����.
		
		lblFileList = new JLabel[fileListSet.size()];
		//�ۼ��� Ű���� �����ϴ� �������� ������ŭ ���̺� ����.
		
		Iterator<String> it = fileListSet.iterator();
		
		int idx = 0;
		while(it.hasNext()) {
			lblFileList[idx] = new JLabel(it.next());
			//fileListSet���� ���� �ϳ� �о�� ���̺� �ؽ�Ʈ�� �����ϸ� ����.
			idx++;
		}
	}
	private void setDisplay() {
		JPanel pnlMain = new JPanel(new BorderLayout());
		pnlMain.setBorder(new EmptyBorder(20,20,20,20));
		
		JPanel pnlNorth = new JPanel();
		JPanel pnlLbl = new JPanel(new GridLayout(0, 1));
		//pnlLbl : �ۼ���, ����, �±�, pw ���̺���� �ٴ´�.
		pnlLbl.add(lblDate);
		pnlLbl.add(lblTitle);
		pnlLbl.add(lblTag);
		pnlLbl.add(lblPw);

		
		JPanel pnlTf = new JPanel(new GridLayout(0, 1));
		//pnlTf : �ۼ���(yyyy.MM.dd)���̺�, �����ؽ�Ʈ�ʵ�, �±��ؽ�Ʈ�ʵ�, pw�н������ʵ尡 �ٴ´�.
		pnlTf.add(lblToday);
		pnlTf.add(tfTitle);
		pnlTf.add(tfTag);
		pnlTf.add(pfPw);
		
		JPanel pnlBtn = new JPanel();
		//pnlBtn : +��� ��ư�� �ٴ´�.
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
		//pnlCenter : ���ϸ�ϸ���Ʈ, taContent�� �ٴ´�.
		
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
	 * 	�ۼ��Ͽ� �ۼ��� ���� ���� ����Ʈ�� �޾ƿ��� �޼���.
	 *  ex) date(2020.06.05)�� �ۼ��� ���� ������� �޾ƿ´�.
	 * 	file : ���� ����
	 * 	date : Ű ��
	 * 
	 * */
	private void readFileList(File file, String date) {
		FileReader fr = null;
		
		if(file.exists()) {
			//file(allFileInfo.properties)�� ������ ���� �����Ѵ�.
			try {
				fr = new FileReader(file);
				prop.load(fr);
				
				String key = date;
				//�ۼ���(yyyy.MM.dd)�� Ű ���� �ȴ�.
				
				String value = prop.getProperty(key);
				
				try {
					StringTokenizer st = new StringTokenizer(value, "/");
					
					while(st.hasMoreTokens()) {
						fileListSet.add(st.nextToken());
					}
				}catch(NullPointerException e) {
					
				}
				
			}catch(IOException e) {
				JOptionPane.showMessageDialog(this, "���� �б� �� ���� �߻�!");
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
	 * 	������ ���̺��� ������ �о�´�.
	 * 	file : �о� �� ����(allFileInfo.properties)
	 * 	fileName : ��������
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
			JOptionPane.showMessageDialog(this, "���� �б� �� ���� �߻�!");
		}finally {
			try {
				fr.close();
			}catch(Exception e) {}
		}
	}
	
	/*
	 * 	������ ���̺��� ������ �����Ѵ�. pw�� ��ġ�� ���� ������ �����ϴ�.
	 * 	file : �������
	 * */
	private void remove(File file) {
		FileReader fr = null;
		
		String date = lblToday.getText();
		String fileName = tfTitle.getText();	//���� �� ��������
		String filePw = null;	//���� �� ������ pw
		String userPw = String.valueOf(pfPw.getPassword());	//����ڰ� �Է��� pw
		
		try {
			fr = new FileReader(file);
			prop.load(fr);
			
			filePw = prop.getProperty(date + "/" + fileName + "/pw");
			
			if(userPw.length() == 0) {
				//����ڰ� pw�� �Է����� �ʾҴٸ�
				JOptionPane.showMessageDialog(this, "PW�� �Է����ּ���");
			} else {
				if(filePw.equals(userPw)) {
					//����pw�� ����ڰ� �Է��� pw�� ��ġ�ؾ߸� �ش� ���������� �����Ѵ�.
					//fileName(��������)�� �����ؾ� �ϴ� ��Ȳ.
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
					
					JOptionPane.showMessageDialog(this, "���� ����!");
					files.remove(fileName);
					
					dispose();
					new MyMemo2(cal, owner, files);
					
				} else {
					//����pw�� ����ڰ� �Է��� pw�� �ٸ���.
					JOptionPane.showMessageDialog(this, "pw�� ��ġ���� �ʽ��ϴ�. ���� ����!");
				}
			}
		}catch(IOException e) {
			
		}finally {
			try {
				fr.close();
			}catch(Exception e) {}
		}
	}
	
	//���� �޸��忡 ���� �ִ� �ؽ�Ʈ�� ��� reset ��Ų��.
	private void reset() {
		tfTitle.setText("");
		tfTag.setText("");
		pfPw.setText("");
		taContent.setText("");
	}
	
	
	/*
	 * 	�Ÿ��忡 �ִ� ������ ���Ͽ� �����ϴ� �޼���
	 * 	file : ������ ����
	 * */
	private void save(File file) {
		String date = lblToday.getText();		//�ۼ���
		String title = tfTitle.getText();		//����ڰ� �Է��� ����
		String tag = tfTag.getText();			//����ڰ� �Է��� �±�
		String pw = String.valueOf(pfPw.getPassword());	//����ڰ� �Է��� pw
		String content = taContent.getText();
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(file);
			
			if(prop.getProperty(date) == null) {
				//�ش� �ۼ��� ������ �������� ������
				tmpFile = title;
			} else {
				//�ش� �ۼ��� ������ �����ϸ� date�� Ű���� �̾ƿ� ���������� �̾���δ�.
				tmpFile = prop.getProperty(date) + "/" + title;
			}
			prop.setProperty(date, tmpFile);
			prop.setProperty(date+"/"+title+"/date", date);
			prop.setProperty(date+"/"+title+"/title", title);
			prop.setProperty(date+"/"+title+"/tag", tag);
			prop.setProperty(date+"/"+title+"/pw", pw);
			prop.setProperty(date+"/"+title+"/content", content);
			
			prop.store(fw, "All File Information");
			
			JOptionPane.showMessageDialog(this, "���� ����");
			files.add(title);
			
			dispose();
			new MyMemo2(cal, owner, files);
			
		}catch(IOException e) {
			JOptionPane.showMessageDialog(this, "���� ���� �� ���� �߻�!");
		}finally {
			try {
				fw.close();
			}catch(Exception e) {
				
			}
		}
	}
	private void showDlg() {
		setTitle("�޸� â");
		pack();
		setLocation(1300, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
