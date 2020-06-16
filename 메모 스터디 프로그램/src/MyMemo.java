import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

public class MyMemo extends JDialog{
	public static final Dimension BTN_SIZE = new Dimension(50, 30);
	public static final Dimension LBL_SIZE = new Dimension(70, 22);
	
	private JLabel lblDate;			//"�ۼ��� : " ���̺�
	private JLabel lblSelectDay;	//yyyy.MM.dd(���� �ۼ���)
	private JLabel lblTitle;		//"���� : " ���̺�
	private JLabel lblTag;			//"�±� : " ���̺� 
	private JLabel lblPw;			//"pw : " ���̺�
	
	private JButton btnReset;		//'+'��ư
	private JButton btnSave;		//'����'��ư
	private JButton btnRemove;		//'����'��ư
	private JButton btnCancel;		//'���'��ư
	
	private JTextField tfTitle;		//���� �ؽ�Ʈ�ʵ�
	private JTextField tfTag;		//�±� �ؽ�Ʈ�ʵ�
	private JPasswordField pfPw;	//pw �н������ʵ�
	
	private JTextArea taContent;	//���� 
	
	private StudyMemo owner;
	private Calendar date;			//�޸� �ۼ���
	private MyCalendar myCal;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	
	private JLabel[] lblTitles;		//�������� ���̺� ����Ʈ
	
	
	/*
	 * 	date : �޸� �ۼ���
	 *  owner : StudyMemo(JFrame)Ŭ������ ��ü �ּ�
	 * */
	public MyMemo(Calendar date, StudyMemo owner, MyCalendar myCal) {
		
		super(owner, "�޸� â", false);
		this.owner = owner;		//StudyMemo Ŭ���� ���� vecFile ������ �����ϱ� ����.
		this.date = date;			//�޸� �ۼ��� ��¥�� ��´�.
		this.myCal = myCal;
		
		init();
		setDisplay();
		addListeners();
		showDlg();
	}
	
	public MyMemo(String date, String title, StudyMemo owner, MyCalendar myCal) {
		this.owner = owner;
		this.myCal = myCal;
		
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(5, 7));
		int day = Integer.parseInt(date.substring(8, 10));

		this.date = Calendar.getInstance();
		this.date.set(Calendar.YEAR, year);
		this.date.set(Calendar.MONTH, month - 1);
		this.date.set(Calendar.DATE, day);
		
		init();
		setDisplay();
		addListeners();
		showDlg();
		
		Vector<FileInfo> vecFile = owner.getVecFile();
		
		if(vecFile != null) {
			for(FileInfo info : vecFile) {
				String targetDate = info.getDate();
				String targetTitle = info.getTitle();
				String targetTag = info.getTag();
				String targetContent = info.getContent();
				
				if(date.equals(targetDate) && title.equals(targetTitle)) {
					tfTitle.setText(targetTitle);
					tfTag.setText(targetTag);
					taContent.setText(targetContent);
				}
			}
		}
	}
	
	private void init() {
		lblDate = new JLabel("�ۼ��� : ", JLabel.CENTER);
		lblDate.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		lblDate.setPreferredSize(LBL_SIZE);
		
		lblTitle = new JLabel("��  �� : ", JLabel.CENTER);
		lblTitle.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		lblTitle.setPreferredSize(LBL_SIZE);
		
		lblTag = new JLabel("��  �� : ", JLabel.CENTER);
		lblTag.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		lblTag.setPreferredSize(LBL_SIZE);
		
		lblPw = new JLabel(" PW : ", JLabel.CENTER);
		lblPw.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		lblPw.setPreferredSize(LBL_SIZE);
		
		lblSelectDay = new JLabel(sdf.format(date.getTime()));
		lblSelectDay.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		lblSelectDay.setPreferredSize(LBL_SIZE);
		
		btnReset = new JButton("+");
		btnReset.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		btnReset.setBackground(Color.pink);
		btnReset.setBorder(new LineBorder(Color.pink));
		btnReset.setPreferredSize(BTN_SIZE);
		btnReset.setToolTipText("������ �ʱ�ȭ�ϰ� �� �޸� �ۼ��մϴ�.");
		
		btnSave = new JButton("����");
		btnSave.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		btnSave.setBackground(Color.pink);
		btnSave.setBorder(new LineBorder(Color.pink));
		btnSave.setPreferredSize(BTN_SIZE);
		
		btnRemove = new JButton("����");
		btnRemove.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		btnRemove.setBackground(Color.pink);
		btnRemove.setBorder(new LineBorder(Color.pink));
		btnRemove.setPreferredSize(BTN_SIZE);
		
		btnCancel = new JButton("���");
		btnCancel.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		btnCancel.setBackground(Color.pink);
		btnCancel.setBorder(new LineBorder(Color.pink));
		btnCancel.setPreferredSize(BTN_SIZE);
		
		tfTitle = new JTextField(15);
		tfTag = new JTextField(20);
		tfTag.setToolTipText("�±׸� ���� �� ���� �� ','�� ������� �ۼ����ּ���");
		pfPw = new JPasswordField(10);
		
		taContent = new JTextArea(20, 20);
		taContent.setText("�±׸� ���� �� ����� ���� ','�� �����ϸ� ������� �̾����.");
		taContent.setLineWrap(true);
		
		initLabelArray();
		//lblDates, lblTitles �迭 �ʱ�ȭ
	}
	private void setDisplay() {
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(new Color(255, 234, 234));
		
		JPanel pnlLabel = new JPanel(new GridLayout(0, 1));
		pnlLabel.setBackground(new Color(255, 234, 234));
		//"�ۼ���", "����", "�±�", "pw" ���̺��� �ٴ´�.
		pnlLabel.add(lblDate);
		pnlLabel.add(lblTitle);
		pnlLabel.add(lblTag);
		pnlLabel.add(lblPw);
		
		JPanel pnlTextField = new JPanel(new GridLayout(0, 1));
		pnlTextField.setBackground(new Color(255, 234, 234));
		//�޸��ۼ���, �����ؽ�Ʈ�ʵ�, �±��ؽ�Ʈ�ʵ�, pw�н������ʵ尡 �ٴ´�.
		pnlTextField.add(lblSelectDay);
		pnlTextField.add(tfTitle);
		pnlTextField.add(tfTag);
		pnlTextField.add(pfPw);
		
		JPanel pnlButton = new JPanel();
		pnlButton.setBackground(new Color(255, 234, 234));
		pnlButton.add(btnReset);
		
		pnlNorth.add(pnlLabel);
		pnlNorth.add(pnlTextField);
		pnlNorth.add(pnlButton);
		
		
		JPanel pnlCenter = new JPanel(new BorderLayout());
		pnlCenter.setBackground(new Color(255, 234, 234));
		
		JScrollPane scroll = new JScrollPane(taContent);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		pnlCenter.add(getPnlFileList(), BorderLayout.NORTH);
		pnlCenter.add(scroll, BorderLayout.CENTER);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(new Color(255, 234, 234));
		pnlSouth.add(btnSave);
		pnlSouth.add(btnRemove);
		pnlSouth.add(btnCancel);
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	
	
	private JPanel getPnlFileList() {
		JPanel pnlFileList = new JPanel(new GridLayout(0, 1));
		//�޸� �ۼ��Ͽ� �����ϴ� ��� ���ϵ��� ������ ���δ�.
		pnlFileList.setBackground(new Color(255, 234, 234));
		 
		

		//�������� ���̺���� ���δ�
		if(lblTitles != null) {
			for(int idx=0; idx<lblTitles.length; idx++) {
				JPanel pnlTitle = new JPanel();
				pnlTitle.setBackground(new Color(255, 234, 234));
				
				JLabel lblImage = new JLabel();
				lblImage.setIcon(new ImageIcon("file.png"));
				pnlTitle.add(lblImage);
				pnlTitle.add(lblTitles[idx]);
				pnlFileList.add(pnlTitle);
			}
		}
		
		
		return pnlFileList;
		
	}
	
	//JLabel �迭 lblDates, lblTitles�� �ʱ�ȭ�ϴ� �޼���.
	private void initLabelArray() {
		int count = 0;
		
		Vector<FileInfo> vecFile = owner.getVecFile();
		
		Vector<String> vecTitle = new Vector<String>();
		
		String memoDate = lblSelectDay.getText();
		
		if(vecFile != null) {
			for(FileInfo info : vecFile) {
				String targetDate = info.getDate();
				if(targetDate.equals(memoDate)) {
					//�ۼ����� ���� ������ vecFile �ȿ� �����ϸ� count�� ����.
					count++;
					
					//vecDate.add(info.getDate());
					//�ۼ����� vecDate�� �߰�
					vecTitle.add(info.getTitle());
					//���������� vecTitle�� �߰�
				}
			}
		}
		
		if(count != 0) {
			//�ۼ����� ���� ������ �ϳ��� ������ ���� ���̺� �迭 �ʱ�ȭ.
			lblTitles = new JLabel[count];
		}
		
		int idx = 0;
		
		idx = 0;
		Iterator<String> itTitle = vecTitle.iterator();
		while(itTitle.hasNext()) {
			String title = itTitle.next();
			lblTitles[idx] = new JLabel(title, JLabel.LEFT);
			lblTitles[idx].setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
			lblTitles[idx].setOpaque(true);
			lblTitles[idx].setBackground(new Color(255, 234, 234));
			lblTitles[idx].setForeground(Color.black);
			idx++;
		}
		
	}
	private void addListeners() {
		ActionListener aListener = (ae) -> {
			Object o = ae.getSource();
			if(o == btnSave) {
				//���� ��ư ������ �� �� �� ����
				save();
			} else if(o == btnRemove) {
				//���� ��ư ������ �� �� �� ����
				remove();
			} else if(o == btnCancel) {
				//��� ��ư ������ �� �� �� ����
				dispose();
			} else if(o == btnReset) {
				//+ ��ư ������ �� �� �� ����
				reset();
			}
		};
		
		MouseListener mListener = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				JLabel lbl = (JLabel)me.getSource();
				
				String date = lblSelectDay.getText();
				String title = lbl.getText();
				
				setMemo(date, title);
			}
		};
		
		btnSave.addActionListener(aListener);
		btnRemove.addActionListener(aListener);
		btnReset.addActionListener(aListener);
		btnCancel.addActionListener(aListener);
		
		if(lblTitles != null) {
			for(int idx=0; idx<lblTitles.length; idx++) {
				lblTitles[idx].addMouseListener(mListener);
			}
		}
	}
	private void setMemo(String date, String title) {
		Vector<FileInfo> vecFile = owner.getVecFile();
		
		for(FileInfo file : vecFile) {
			String targetDate = file.getDate();
			String targetTitle = file.getTitle();
			
			if(date.equals(targetDate) && title.equals(targetTitle)) {
				tfTitle.setText(file.getTitle());
				tfTag.setText(file.getTag());
				taContent.setText(file.getContent());
			}
		}
	}
	//StudyMemo Ŭ������ vecFile ����Ʈ�� ���� �߰�
	private void save() {
		//���� ��, vecFile�� �ش� �ۼ����� �ش� ���� ������ �����ϸ� �� ������ �±�, pw, ���븸 ����
		//���� ��, ������ �����ϸ� �ƿ� vecFile�� ���ο� FileInfo ��ü�� �߰�.
		boolean saveSuccess = false;
		
		String date = lblSelectDay.getText();
		String title = tfTitle.getText();
		String tag = tfTag.getText();
		String pw = String.valueOf(pfPw.getPassword());
		String content = taContent.getText();
		
		if(title.length() == 0) {
			JOptionPane.showMessageDialog(this, "������ �Է����ּ���");
		} else if(tag.length() == 0) {
			JOptionPane.showMessageDialog(this, "�±׸� �Է����ּ���");
		} else if(pw.length() == 0) {
			JOptionPane.showMessageDialog(this, "pw �Է����ּ���");
		} else {
			Vector<FileInfo> vecFile = owner.getVecFile();
			
			if (vecFile == null) {
				owner.addFile(new FileInfo(date, title, tag, pw, content));
				JOptionPane.showMessageDialog(this, "���� ����!");
				
				dispose();
				new MyMemo(this.date, owner, myCal);
				myCal.hasFile();
			} else {
				for (FileInfo file : vecFile) {
					String targetDate = file.getDate();
					String targetTitle = file.getTitle();

					if(date.equals(targetDate) && title.equals(targetTitle)) {
						// �ۼ��ϰ� ������ ���� ������ �����ϸ� �����
						file.setTag(tag);
						file.setPw(pw);
						file.setContent(content);

						JOptionPane.showMessageDialog(this, "����� ����!");
						dispose();
						new MyMemo(this.date, owner, myCal);
						myCal.hasFile();
						saveSuccess = true;
					}
				}
				if(!saveSuccess) {
					owner.addFile(new FileInfo(date, title, tag, pw, content));
					JOptionPane.showMessageDialog(this, "���� ����!");
					
					dispose();
					new MyMemo(this.date, owner, myCal);
					myCal.hasFile();
				}
			}
		}
	}
	private void remove() {
		//���� ��, vecFile�� FileInfo ��ü�� ��� ����(����, �±�, pw, ����)�� 
		//����ڰ� �Է��� ����(����, �±�, pw, ����)�� ���� ��ġ�ؾ߸� ���� ����
		String date = lblSelectDay.getText();
		String title = tfTitle.getText();
		String tag = tfTag.getText();
		String pw = String.valueOf(pfPw.getPassword());
		String content = taContent.getText();

		if (title.length() == 0) {
			JOptionPane.showMessageDialog(this, "������ �Է����ּ���");
		} else if (tag.length() == 0) {
			JOptionPane.showMessageDialog(this, "�±׸� �Է����ּ���");
		} else {
			boolean exist = false;
			Vector<FileInfo> vecFile = owner.getVecFile();

			if (vecFile != null) {
				for (FileInfo info : vecFile) {
					String targetDate = info.getDate();
					String targetTitle = info.getTitle();
					String targetTag = info.getTag();
					String targetContent = info.getContent();

					if (date.equals(targetDate) && title.equals(targetTitle) && tag.equals(targetTag)
							&& content.equals(targetContent)) {
						// �ۼ���, ����, �±�, ������ ���ƾ߸� ������ ��ȸ�� �ش�.
						exist = true;
					}
				}
			}
			if(exist) {
				String rePw = JOptionPane.showInputDialog(this, "������ ������ pw�� �ٽ� �� �� �Է����ּ���");

				FileInfo myInfo = new FileInfo(date, title, tag, rePw, content);

				if (vecFile != null) {
					if (vecFile.contains(myInfo)) {
						// vecFile�� ��� ������ ��ġ�ϴ� ������ ������ ���
						owner.removeFile(myInfo);
						JOptionPane.showMessageDialog(this, "���� ����");
						
						dispose();
						new MyMemo(this.date, owner, myCal);
						myCal.hasFile();
					} else {
						JOptionPane.showMessageDialog(this, "���� ����. pw�� ��ġ���� �ʽ��ϴ�");
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "�ش� ������ �������� �ʽ��ϴ�.");
			}
		}

	}
	//�޸� â�� ��� ���� �ʱ�ȭ
	private void reset() {
		tfTitle.setText("");
		tfTag.setText("");
		pfPw.setText("");
		taContent.setText("�±׸� ���� �� ����� ���� ','�� �����ϸ� ������� �̾����.");
	}
	private void showDlg() {
		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
}
