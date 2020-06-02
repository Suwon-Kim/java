package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class Translate extends JFrame {
	private JMenuBar mBar;
	
	private JMenu mFile;
	private Properties prop;
	
	private JMenuItem miNew;
	private JMenuItem miOpen;
	
	private JMenuItem korean;
	private JMenuItem english;
	
	private JLabel lblInfo;
	
	private JPopupMenu pMenu;
	
	public Translate () {
		init();
		addListeners();
		showFrame();
	}
	public void init() {
		mBar = new JMenuBar();
		
		mFile = new JMenu("파일");
		
		miNew = new JMenuItem("뉴");
		miOpen = new JMenuItem("오픈");
		
		lblInfo = new JLabel("레이블",JLabel.CENTER);
		
		pMenu = new JPopupMenu();
		
		korean = new JMenuItem("한국어");
		english = new JMenuItem("영어");
		
		pMenu.add(korean);
		pMenu.add(english);
		
		mFile.add(miNew);
		mFile.add(miOpen);
		
		mBar.add(mFile);
	
		setJMenuBar(mBar);
		add(lblInfo, BorderLayout.CENTER);
		
	}
	public void load(String name) {
			
			prop = new Properties();
			
			FileReader fr = null;
			
			try {
				fr = new FileReader(name);
				prop.load(fr);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					fr.close();
				} catch (Exception e) {
					
				}
			}
	}
	public void setText() {
		mFile.setText(prop.getProperty("mFile"));
		miNew.setText(prop.getProperty("miNew"));
		miOpen.setText(prop.getProperty("miOpen"));
		lblInfo.setText(prop.getProperty("lblInfo"));
	}
	public void addListeners() {
		MouseListener listener = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				showPopup(me);
			}
			@Override
			public void mouseReleased(MouseEvent me) {
				showPopup(me);
			}
		};
		
		lblInfo.addMouseListener(listener);
		
		ActionListener AListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(ae.getSource() == korean) {
					load("korean.properties");
					setText();
				} else {
					load("english.properties");
					setText();
				}
			}
		};
		korean.addActionListener(AListener);
		english.addActionListener(AListener);
	}
	
	private void showPopup(MouseEvent me) {
		if(me.isPopupTrigger()) {
			pMenu.show(lblInfo, me.getX(), me.getY());
		}
	}
	public void showFrame() {
		setTitle("International System Demo");
		setSize(500,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Translate();
		
	}
	
}
