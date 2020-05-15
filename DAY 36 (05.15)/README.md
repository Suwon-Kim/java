/*
 *  메뉴는 배치의 대상이 아님. 기본 위치가 약속되어 있음.
 *  - 메뉴의 구성요소
 *  1. JMenuBar : JMenu를 포함할 수 있는 Component
 *     2 .JMenu : 기능 (자식을 보여준다)
 *  3. JMenuItem (JRadioButtonMenuItem, JCheckBoxMenuItem) : 기능이 존재

```java
package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

/*
 * 메뉴는 배치의 대상이 아님. 기본 위치가 약속되어 있음.
 * 
 * - 메뉴의 구성요소
 * 1. JMenuBar : JMenu를 포함할 수 있는 Component
 * 2. JMenu : 기능(자식을 보여준다)
 * 3. JMenuItem(JRadioButtonMenuItem, JCheckBoxMenuItem) : 기능이 존재
 */
public class MenuEx extends JFrame {
	
	private JMenuBar mBar;
	private JMenu mFile;
	private JMenuItem miOpen;
	private JMenuItem miSave;
	private JMenuItem miExit;
	
	private JMenu mOption;
	private JRadioButtonMenuItem rbmiOptionA;
	private JRadioButtonMenuItem rbmiOptionB;
	
	
	private JLabel lblMain;
	private JButton btnExit;
	
	public MenuEx() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
//		try {
//			String lookNFeelName = UIManager.getSystemLookAndFeelClassName();
//			UIManager.setLookAndFeel(lookNFeelName);
//		} catch (Exception e) {	} 
		
		 
		lblMain = new JLabel("Start", JLabel.CENTER);
		lblMain.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		
		btnExit = new JButton("Exit");
		btnExit.setToolTipText("alt + x");
		// alt 누르고 눌러야함 
		btnExit.setMnemonic('X');
		
		mBar = new JMenuBar();
		mFile = new JMenu("File");
		miOpen = new JMenuItem("Open", 'O');
		miOpen.setIcon(new ImageIcon("open.png"));
		miSave = new JMenuItem("Save");
		miSave.setMnemonic('S');
		// alt + ctrl + s
		KeyStroke keys = KeyStroke.getKeyStroke(
			KeyEvent.VK_S, 
			InputEvent.ALT_DOWN_MASK
			|
			InputEvent.CTRL_DOWN_MASK
		);
		miSave.setAccelerator(keys);
		
		miSave.setIcon(new ImageIcon("save.png"));
		miExit = new JMenuItem("Exit");	
		miExit.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK)
		);
		
		mOption = new JMenu("Option");
		rbmiOptionA = new JRadioButtonMenuItem("option A", true);
		rbmiOptionB = new JRadioButtonMenuItem("option B");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbmiOptionA);
		group.add(rbmiOptionB);
	}

	private void setDisplay() {
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnExit);
		
		add(lblMain, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
		
		// 메뉴조립
		mOption.add(rbmiOptionA);
		mOption.add(rbmiOptionB);
		
		mFile.add(miOpen);
		mFile.add(miSave);
		mFile.addSeparator();
		mFile.add(mOption);
		mFile.addSeparator();
		mFile.add(miExit);
		
		mBar.add(mFile);
		
		
		JMenu mEtc = new JMenu("ETC");
		JMenuItem miInfo = mEtc.add("about swing");
		JMenuItem miHelp = mEtc.add("help");
		
		mBar.add(mEtc);
		
		// 배치대상이 아님..
		setJMenuBar(mBar);
	}

	private void addListeners() {
		ActionListener listener = (e) -> {
			String cmd = e.getActionCommand();
			if(cmd.equalsIgnoreCase("Exit")) {
				closeWindow();
			} else {
				lblMain.setText(cmd);
			}
		};
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				closeWindow();
			}
		});
		
		miOpen.addActionListener(listener);
		miSave.addActionListener(listener);
		miExit.addActionListener(listener);
		btnExit.addActionListener(listener);
		
	}
	private void closeWindow() {
		JOptionPane.showMessageDialog(
			this, 
			"GoodBye~", 
			"Exit", 
			JOptionPane.INFORMATION_MESSAGE
		);
		System.exit(0);
	}
	private void showFrame() {
		setTitle("Menu Ex");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MenuEx();
	}
}

```

```java
package kr.ac.green;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

public class MenuEx1 extends JFrame{
	private JMenuBar mBar;
	private JMenu mFile;
	private JMenuItem miFemale_singer;
	private JMenuItem miMale_singer;
	private JMenuItem miExit;
	
	private JPanel pnlSouth;
	private JLabel lblPic;
	private JMenu fmOption;
	private JRadioButtonMenuItem rbmiOptionFMA; //여가수 1
	private JRadioButtonMenuItem rbmiOptionFMB; //여가수 2
	
	private JMenu mOption;
	private JRadioButtonMenuItem rbmiOptionMA;	// 남가수 1
	private JRadioButtonMenuItem rbmiOptionMB;	// 남가수 2
	
	public MenuEx1() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
		pnlSouth = new JPanel();
		lblPic = new JLabel();
		mBar = new JMenuBar();
		mFile = new JMenu("File");
		miFemale_singer = new JMenuItem("여자가수");
		miMale_singer = new JMenuItem("남자가수");
		miExit = new JMenuItem("종료");
		
		fmOption = new JMenu("여자가수");
		rbmiOptionFMA = new JRadioButtonMenuItem("아이유", true);
		rbmiOptionFMB = new JRadioButtonMenuItem("에일리");
		
		ButtonGroup group1 = new ButtonGroup();
		group1.add(rbmiOptionFMA);
		group1.add(rbmiOptionFMB);
		
		mOption = new JMenu("남자가수");
		rbmiOptionMA = new JRadioButtonMenuItem("서장훈",true);
		rbmiOptionMB = new JRadioButtonMenuItem("이수근");
		
		ButtonGroup group2 = new ButtonGroup();
		group2.add(rbmiOptionMA);
		group2.add(rbmiOptionMB);
		
	}
	private void setDisplay() {
		
		fmOption.add(rbmiOptionFMA);
		fmOption.add(rbmiOptionFMB);
		
		mOption.add(rbmiOptionMA);
		mOption.add(rbmiOptionMB);
		
		mFile.add(fmOption);
		mFile.add(mOption);
		mFile.add(miExit);
		
		mBar.add(mFile);
		
		setJMenuBar(mBar);
		pnlSouth.add(lblPic);
		add(pnlSouth);
		
	}
	private void addListeners() {
		ActionListener action_listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if (cmd.equals("아이유")){
					lblPic.setIcon(new ImageIcon("1.jpg"));
				} else if (cmd.equals("에일리")) {
					lblPic.setIcon(new ImageIcon("2.jpg"));
				} else if (cmd.equals("서장훈")) {
					lblPic.setIcon(new ImageIcon("3.jpg"));
				} else {
					lblPic.setIcon(new ImageIcon("4.jpg"));
				}
					
			}
		
		};
		rbmiOptionFMA.addActionListener(action_listener);
		rbmiOptionFMB.addActionListener(action_listener);
		rbmiOptionMA.addActionListener(action_listener);
		rbmiOptionMB.addActionListener(action_listener);
		
	}
	
	private void showFrame() {
		setTitle("창");
		setLocationRelativeTo(null);
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MenuEx1();
	}
}

```

