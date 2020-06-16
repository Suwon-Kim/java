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

	private int curYear; // ���� ��
	private int curMonth; // ���� ��

	private JLabel lblToday; // ���� ��¥�� ��Ÿ���� ���̺�
	private JLabel lblSelect; // ����ڰ� ���� ��� ���̺�

	private JPanel pnlCal;

	private JComboBox<String> cbYear; // �� �޺��ڽ�
	private JComboBox<String> cbMonth; // �� �޺��ڽ�

	private JButton btnCheck; // ��ȸ ��ư
	private JButton btnSearch; // �˻� ��ư
	private JButton btnLeft; // ��¥ ���� ���� ��ư
	private JButton btnRight; // ��¥ ���� ������ ��ư
	private JButton btnToday; // today ��ư

	private JTextField tfInput; // �˻� �ؽ�Ʈ�ʵ�

	private String[] years = new String[61]; // �� �޺��ڽ��� ��Ÿ�� ���� ����Ʈ
	private String[] months = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	// �� �޺��ڽ��� ��Ÿ�� ���� ����Ʈ

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
	//vecFile�� FileInfo ��ü�� �߰��ϴ� �޼���
	public void addFile(FileInfo file) {
		if(vecFile == null) {
			vecFile = new Vector<FileInfo>();
		}
		vecFile.add(file);
	}
	
	//vecFile���� FileInfo ��ü�� �����ϴ� �޼���
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
	//���Ͽ��� ������ �о�鿩 vecFile�� �����Ѵ�.
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
			JOptionPane.showMessageDialog(this, "���� �б� �� ���� �߻�!");
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
	//���� ���� vecFile�� ���Ͽ� ����
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
			JOptionPane.showMessageDialog(this, "���� ���� �� ���� �߻�!");
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

		sdf = new SimpleDateFormat("yyyy�� MM�� dd�� E����");

		lblToday = new JLabel(sdf.format(date));
		// ���� �ð� -> "yyyy�� MM�� dd�� E����" �������� ��ȯ�ؼ� lblToday �ؽ�Ʈ�� ����.
		lblToday.setFont(new Font("MapoGoldenPier", Font.BOLD, 14));
		

		sdf = new SimpleDateFormat("yyyy.MM");
		lblSelect = new JLabel(sdf.format(date));
		// ���� �ð� -> "yyyy.MM" �������� ��ȯ�ؼ� lblSelect �ؽ�Ʈ�� ����.
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

		btnCheck = new JButton("��ȸ");
		btnCheck.setPreferredSize(BTN_SIZE);
		btnCheck.setBorder(new LineBorder(Color.pink, 2));
		btnCheck.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		btnCheck.setBackground(Color.pink);
		btnSearch = new JButton("�˻�");
		btnSearch.setPreferredSize(BTN_SIZE);
		btnSearch.setBorder(new LineBorder(Color.pink, 2));
		btnSearch.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		btnSearch.setToolTipText("���� �����̳� �±׷� �˻��ϼ���");
		btnSearch.setBackground(Color.pink);
		btnToday = new JButton("Today");
		btnToday.setPreferredSize(BTN_SIZE);
		btnToday.setBorder(new LineBorder(Color.pink, 2));
		btnToday.setFont(new Font("MapoGoldenPier", Font.BOLD, 14));
		btnToday.setBackground(Color.pink);

		tfInput = new JTextField(20);

		// years �ʱ�ȭ. ����⵵���� �� �Ʒ��� 30���� ��Ÿ����.
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
	
		// pnlNorth : Ķ���� ���κ� ��ü

		JPanel pnlSelect = new JPanel();
		pnlSelect.setBackground(new Color(255, 234, 234));
		

		// ���ʹ�ư + yyyy.MM + �����ʹ�ư
		pnlSelect.add(btnLeft);
		pnlSelect.add(lblSelect);
		pnlSelect.add(btnRight);

		JPanel pnlCombo = new JPanel();
		pnlCombo.setBackground(new Color(255, 234, 234));
		
		// cbYear + �� + cbMonth + �� + ��ȸ��ư
		pnlCombo.add(cbYear);
		pnlCombo.add(new JLabel("��"));
		pnlCombo.add(cbMonth);
		pnlCombo.add(new JLabel("��"));
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
				// ���� ��ư ������ ��� �� �� ����
				// 1.�����޷� ���̺� ����.
				// 2.������ �޷� ����.
				if (curMonth > 1) {
					curMonth--;
				} else {
					curMonth = 12;
					curYear--;
				}

				setSelectedCalendar(curYear, curMonth);

			} else if (o == btnRight) {
				// ������ ��ư ������ ��� �� �� ����
				// 1.�����޷� ���̺� ����.
				// 2.������ �޷� ����.
				if (curMonth < 12) {
					curMonth++;
				} else {
					curMonth = 1;
					curYear++;
				}

				setSelectedCalendar(curYear, curMonth);
			} else if (o == btnCheck) {
				// ��ȸ ��ư ������ ��� �� �� ����

				if (cbYear.getSelectedItem() == null || cbMonth.getSelectedItem() == null) {
					// ����ִ� �޺��ڽ��� �ִٸ�
					PleaseSelectDate();
				} else {
					// �޺��ڽ��� �� ���õǾ��� �ִٸ�
					int selectYear = Integer.parseInt((String) cbYear.getSelectedItem());
					int selectMonth = Integer.parseInt((String) cbMonth.getSelectedItem());

					if (!(curYear == selectYear && curMonth == selectMonth)) {
						// ���� �������� ��,���� �ٸ� ������ �޷��� ���� �޾ƿ��� �޺��ڽ��� �������� ���� �ʱ�ȭ��Ų��.
						curYear = Integer.parseInt((String) cbYear.getSelectedItem());
						curMonth = Integer.parseInt((String) cbMonth.getSelectedItem());

						setSelectedCalendar(curYear, curMonth);

						cbYear.setSelectedItem(null);
						cbMonth.setSelectedItem(null);
					}
				}

			} else if (o == btnSearch) {
				// �˻���ư ������ ����� �� �� ����.
				String searchWord = tfInput.getText();

				new SearchResult(this, searchWord);

			} else if (o == btnToday) {
				// today ��ư ������ ����� �� �� ����.
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
		JOptionPane.showMessageDialog(this, "��ȸ�� ��¥�� �������� �������ּ���");
	}

	// year�� month�� ���̺��ؽ�Ʈ�� �����ϰ� �޷��� �����ϴ� �޼���
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
		setTitle("������ ���͵�޸�");
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
