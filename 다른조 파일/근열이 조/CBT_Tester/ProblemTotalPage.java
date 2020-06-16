
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

class ProblemTotalPage extends JDialog {

	private JMenuBar menu; // �޴���

	private JMenu menuFileModify; // �޴� ���� ����
	private JMenu menuPictureModify; // �޴� ���� ����
	private JMenuItem miFileModify; // ���� ����
	private JMenuItem miFileDelete; // ���� ����

	private JMenuItem miPictureModify; // ���� ����
	private JMenuItem miPictureDelete; // ���� ����
	private JMenuItem miPictureadd;

	private JFileChooser chooser;
	private JPanel pnlSouth;
	private JPanel pnlSouthWest;
	private JPanel pnlSouthCenter;
	private JPanel pnlSouthEast;
	private JPanel pnlWest;
	private JTabbedPane tp;
	private JLabel btnBack; // ����
	private JLabel btnNext; // ����
	private JLabel btnCancel; // �ݱ�
	private WrongAnswerPanel[] wap;
	private Vector<Problem> vec;
	private Create owner;
	public static int TabNum;

	public ProblemTotalPage(Create owner, Vector<Problem> vec) {
		super(owner, "Create", true);
		this.owner = owner;
		this.vec = vec;
		init();
		createTap();
		setDisplay();
		addListeners();
		showFrame();
		
	}

	private JTabbedPane createTap() {
		tp = new JTabbedPane();
		tp.setUI(new MyMainTabbedPaneUI());
		setTab();
		return tp;
	}

	private void init() {

		menu = new JMenuBar();
		menuFileModify = new JMenu("����");
		miFileModify = new JMenuItem("���� ����");
		miFileDelete = new JMenuItem("���� ����");
		menuFileModify.add(miFileModify);
		menuFileModify.add(miFileDelete);

		menuPictureModify = new JMenu("����");

		miPictureadd = new JMenuItem("���� �߰�");
		miPictureModify = new JMenuItem("���� ����");
		miPictureDelete = new JMenuItem("���� ����");
		menuPictureModify.add(miPictureadd);
		menuPictureModify.add(miPictureModify);
		menuPictureModify.add(miPictureDelete);

		menu.add(menuFileModify);
		menu.add(menuPictureModify);

		chooser = new JFileChooser();

		pnlWest = new JPanel(new GridLayout(1, 0));
		pnlSouth = new JPanel();

		btnBack = new JLabel(new ImageIcon("before.png"));
		btnBack.setPreferredSize(new Dimension(120,32));
		btnNext = new JLabel(new ImageIcon("next.png"));
		btnCancel = new JLabel(new ImageIcon("Cancel2.png"));
		pnlSouthWest = new JPanel();
		pnlSouthCenter = new JPanel();
		pnlSouthCenter.setBorder(new EmptyBorder(0, 20, 0, 30));
		pnlSouthEast = new JPanel();
		pnlSouthEast.setBorder(new EmptyBorder(0, 0, 0, -5));

	}

	private void setDisplay() {

		pnlSouthCenter.add(btnBack);
		pnlSouthCenter.add(btnNext);
		pnlSouthCenter.setBackground(new Color(0xf0c022));
		pnlSouthEast.add(btnCancel);
		pnlSouthEast.setBackground(new Color(0xf0c022));

		pnlSouth.add(pnlSouthCenter);
		pnlSouth.add(pnlSouthEast);
		pnlSouth.setBorder(new LineBorder(new Color(0xf0c022)));
		pnlSouth.setBackground(new Color(0xf0c022));		
		
		// add(pnlNorth, BorderLayout.NORTH);
		// add(pnlCenter, BorderLayout.CENTER);
		add(pnlWest, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
		setJMenuBar(menu);

	}

	private void saveCheck(String checkstr) {
		boolean flag = true;
		for (int i = 0; i < wap.length; i++) {
			String str = wap[i].getLblPro().getText();
			if (str.contains("*")) {
				flag = false;
			}
		}
		if (!flag) {
			int result = JOptionPane.showConfirmDialog(null, checkstr, "�˸�", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				int num = tp.getSelectedIndex();
				vec.set(num, wap[num].returnProblem());
				owner.writeProblem();
				dispose();
				owner.setVisible(true);
			} else {
				dispose();
				owner.setVisible(true);
			}
		} else {
			dispose();
			owner.setVisible(true);
		}

	}

	private void chooser() {
		int idx = tp.getSelectedIndex();
		int num = chooser.showOpenDialog(this);
		if (num == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			wap[idx].setNewImageReset(file);
			Problem pro = vec.get(idx);
			pro.setImageDir(file.getAbsolutePath());
		}
	}

	private void setTab() {

		tp.setTabPlacement(JTabbedPane.LEFT);
		wap = new WrongAnswerPanel[vec.size()];

		for (int idx = 0; idx < vec.size(); idx++) {
			TabNum = idx + 1;

			wap[idx] = new WrongAnswerPanel(vec.get(idx));
			tp.addTab(String.valueOf(idx + 1), wap[idx]);

		}
		
		pnlWest.setBackground(new Color(0x42984d));
		pnlWest.add(tp);

	}

	private void addListeners() {

		miPictureModify.addActionListener((ae) -> {
			chooser();
		});
		miPictureadd.addActionListener((ae) -> {
			chooser();
		});
		miPictureDelete.addActionListener((ae) -> {
			int idx = tp.getSelectedIndex();
			wap[idx].setNewImageReset();
			Problem pro = vec.get(idx);
			pro.setImageDir("");

		});

		MouseListener liste = new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
	
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Object o = e.getSource();
				if (o == btnBack) {
					if (!(tp.getSelectedIndex() == 0)) {
						tp.setSelectedIndex(tp.getSelectedIndex() - 1);
					} else {
						JOptionPane.showMessageDialog(null, "ù���� �����Դϴ�.", "����", JOptionPane.YES_OPTION);
					}
				} else if (o == btnNext) {
					try {
						if (!(tp.getSelectedIndex() == 19)) {
							tp.setSelectedIndex(tp.getSelectedIndex() + 1);
						}
					} catch (IndexOutOfBoundsException ea) {
						JOptionPane.showMessageDialog(null, "������ �����Դϴ�.", "����", JOptionPane.YES_OPTION);
					}

				} else {
					saveCheck("������ �ȵǾ����ϴ� �����Ͻðڽ��ϱ�?");

				}
				
			}
		};
		

		
	
		btnBack.addMouseListener(liste);
		btnNext.addMouseListener(liste);
		btnCancel.addMouseListener(liste);

		miFileModify.addActionListener((ae) -> {
			int result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?", "�˸�", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				int num = tp.getSelectedIndex();
				vec.set(num, wap[num].returnProblem());
				owner.writeProblem();
			}
		});

		miFileDelete.addActionListener((ae) -> {
			JOptionPane.showMessageDialog(this, "�����Ǿ����ϴ�");
			owner.setLblProblemNum(TabNum);
			int num = tp.getSelectedIndex();
			vec.remove(num);
			tp.removeAll();
			owner.writeProblem();
			setTab();

		});
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				saveCheck("������ �ȵǾ����ϴ� �����Ͻðڽ��ϱ�?");

			}
		});
	}

	private void showFrame() {
		setTitle("���� ����");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}