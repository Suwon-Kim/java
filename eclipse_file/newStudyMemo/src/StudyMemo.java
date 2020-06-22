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
	
	private int curYear;		//���� ��
	private int curMonth;		//���� ��
	
	private JLabel lblToday;	//���� ��¥�� ��Ÿ���� ���̺�
	private JLabel lblSelect;	//����ڰ� ���� ��� ���̺�
	
	private JPanel pnlCal;
	
	private JComboBox<String> cbYear;	//�� �޺��ڽ�
	private JComboBox<String> cbMonth;	//�� �޺��ڽ�
	
	private JButton btnCheck;	//��ȸ ��ư
	private JButton btnSearch;	//�˻� ��ư
	private JButton btnLeft;	//��¥ ���� ���� ��ư
	private JButton btnRight;	//��¥ ���� ������ ��ư
	private JButton btnToday;	//today ��ư
	
	private JTextField tfInput;	//�˻� �ؽ�Ʈ�ʵ�
	
	private String[] years = new String[61];		//�� �޺��ڽ��� ��Ÿ�� ���� ����Ʈ
	private String[] months = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};	
	//�� �޺��ڽ��� ��Ÿ�� ���� ����Ʈ
	
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
		
		sdf = new SimpleDateFormat("yyyy�� MM�� dd�� E����");
		
		lblToday = new JLabel(sdf.format(date));
		//���� �ð� -> "yyyy�� MM�� dd�� E����" �������� ��ȯ�ؼ� lblToday �ؽ�Ʈ�� ����.
		lblToday.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		
		sdf = new SimpleDateFormat("yyyy.MM");
		lblSelect = new JLabel(sdf.format(date));
		//���� �ð� -> "yyyy.MM" �������� ��ȯ�ؼ� lblSelect �ؽ�Ʈ�� ����.
		lblSelect.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
		
		btnLeft = new JButton("��"); 
		btnLeft.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		btnLeft.setMargin(new Insets(0, 0, 0, 0));
		
		btnRight = new JButton("��");
		btnRight.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		btnRight.setMargin(new Insets(0, 0, 0, 0));
		
		btnCheck = new JButton("��ȸ");
		btnSearch = new JButton("�˻�");
		btnSearch.setToolTipText("���� �����̳� �±׷� �˻��ϼ���");
		btnToday = new JButton("Today");
		
		
		tfInput = new JTextField(20);
		
		
		
		
		//years �ʱ�ȭ. ����⵵���� �� �Ʒ��� 30���� ��Ÿ����.
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
		//pnlNorth : Ķ���� ���κ� ��ü
		
		JPanel pnlSelect = new JPanel();
		//���ʹ�ư + yyyy.MM + �����ʹ�ư
		pnlSelect.add(btnLeft);
		pnlSelect.add(lblSelect);
		pnlSelect.add(btnRight);
		
		JPanel pnlCombo = new JPanel();
		//cbYear + �� + cbMonth + �� + ��ȸ��ư
		pnlCombo.add(cbYear);
		pnlCombo.add(new JLabel("��"));
		pnlCombo.add(cbMonth);
		pnlCombo.add(new JLabel("��"));
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
				//���� ��ư ������ ��� �� �� ����
				//1.�����޷� ���̺� ����.
				//2.������ �޷� ����.
				if(curMonth > 1) {
					curMonth--;
				} else {
					curMonth = 12;
					curYear--;
				}
				
				setSelectedCalendar(curYear, curMonth);
			
			} else if(o == btnRight) {
				//������ ��ư ������ ��� �� �� ����
				//1.�����޷� ���̺� ����.
				//2.������ �޷� ����.
				if(curMonth < 12) {
					curMonth++;
				} else {
					curMonth = 1;
					curYear++;
				}
				
				setSelectedCalendar(curYear, curMonth);
			} else if(o == btnCheck) {
				//��ȸ ��ư ������ ��� �� �� ����
				
				if(cbYear.getSelectedItem()==null || cbMonth.getSelectedItem()==null) {
					//����ִ� �޺��ڽ��� �ִٸ�
					PleaseSelectDate();
				} else {
					//�޺��ڽ��� �� ���õǾ��� �ִٸ�
					int selectYear = Integer.parseInt((String)cbYear.getSelectedItem());
					int selectMonth = Integer.parseInt((String)cbMonth.getSelectedItem());
					
					if (!(curYear == selectYear && curMonth == selectMonth)) {
						// ���� �������� ��,���� �ٸ� ������ �޷��� ���� �޾ƿ��� �޺��ڽ��� �������� ���� �ʱ�ȭ��Ų��.
						curYear = Integer.parseInt((String) cbYear.getSelectedItem());
						curMonth = Integer.parseInt((String) cbMonth.getSelectedItem());

						setSelectedCalendar(curYear, curMonth);

						cbYear.setSelectedItem(null);
						cbMonth.setSelectedItem(null);
					}
				}
				
			} else if(o == btnSearch) {
				//�˻���ư ������ ����� �� �� ����.
				String searchWord = tfInput.getText();
				//new Search_Result(searchText);
				new SearchResult(this, searchWord);
			} else if(o == btnToday) {
				//today ��ư ������ ����� �� �� ����.
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
		JOptionPane.showMessageDialog(this, "��ȸ�� ��¥�� �������� �������ּ���");
	}
	//year�� month�� ���̺��ؽ�Ʈ�� �����ϰ� �޷��� �����ϴ� �޼���
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
		setTitle("������ ���͵�޸�");
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