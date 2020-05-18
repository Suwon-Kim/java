import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
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

public class Test extends JFrame{
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
	
	public Test() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
		lblMain = new JLabel("Start", JLabel.CENTER);
		lblMain.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		
		btnExit = new JButton("Exit");
		btnExit.setToolTipText("alt + x");
		btnExit.setMnemonic('S');
		
		mBar = new JMenuBar();
		mFile = new JMenu("File");
		miOpen = new JMenuItem("open",'O');
		miOpen.setIcon(new ImageIcon("open.png"));
		miSave = new JMenuItem("Save");
		miSave.setMnemonic('S');
		
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
		rbmiOptionA = new JRadioButtonMenuItem("Option A", true);
		rbmiOptionB = new JRadioButtonMenuItem("Option B");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbmiOptionA);
		group.add(rbmiOptionB);
		
	}
	private void setDisplay() {
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnExit);
		
		add(lblMain, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
		
		mOption.add(rbmiOptionA);
		mOption.add(rbmiOptionB);
		mFile.add(miOpen);
		mFile.add(miSave);
		mFile.addSeparator();
		mFile.add(mOption);
		mFile.addSeparator();
		mFile.add(miExit);
		
		mBar.add(mFile);
		
		setJMenuBar(mBar);
	}
	private void addListeners() {
		ActionListener listener = new ActionListener() {
			@Override
			// 키보드를 사용하여 동작 시켰을때
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				// 대소문자 구분을 무시한다.
				if(cmd.equalsIgnoreCase("Exit")) {
					closeWindow();
				} else {
					lblMain.setText(cmd);
				}
			}
		};
		this.addWindowListener(new WindowAdapter() {
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
		setTitle("Menu Test");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Test();
	}
}
