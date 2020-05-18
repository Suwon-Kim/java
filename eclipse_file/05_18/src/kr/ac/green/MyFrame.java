package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/*
 * 새창 띄우기 - JDialog, JFrame
 */
public class MyFrame extends JFrame {
	
	private Vector<String> wordsList;
	private JTextArea taList; 
	public MyFrame() {
		wordsList = new Vector<String>();
		/*
		 * BorderLayout에만 사용가능.
		 * North, East, West, South 영역이 비어 있어야함.
		 */
		JToolBar tBar = new JToolBar();
		tBar.setFloatable(false);
		
		JLabel lblInput = new JLabel("입력");
		JTextField tfInput = new JTextField(10);
		tfInput.setEditable(false);
		JButton btnInput = new JButton("입력");
		JButton btnList = new JButton("목록");		
		
		JPanel pnlInput = new JPanel();
		pnlInput.add(lblInput);
		pnlInput.add(tfInput);
		pnlInput.add(btnInput);
		pnlInput.add(btnList);
		
		tBar.add(new JButton("Open"));
		tBar.add(new JButton("Save"));
		tBar.addSeparator();
		tBar.add(new JButton("Exit"));
		tBar.add(Box.createHorizontalGlue());
		tBar.add(new JButton("Help"));
		
		taList = new JTextArea(5, 25);
		taList.setEditable(false);
		JScrollPane scroll = new JScrollPane(taList);
		scroll.setBorder(new TitledBorder(
			new LineBorder(Color.GRAY, 1),
			"List"
		));
		
		JPanel pnlCenter = new JPanel(new BorderLayout());		
		pnlCenter.add(pnlInput, BorderLayout.CENTER);
		pnlCenter.add(scroll, BorderLayout.SOUTH);
		
		add(tBar, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		
		btnInput.addActionListener((e)->new MyDialog(MyFrame.this));
		btnList.addActionListener((e) -> {
			taList.setText("");
			for(String word : wordsList) {
				taList.append(word + "\n");
			}
		});
		
		
		setTitle("새창열기");
		setSize(400, 300);
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	/*
	 * wordsList 에 존재여부 확인
	 */
	public boolean exists(String words) {
		return wordsList.contains(words);
	}
	
	public void add(String words) {
		wordsList.add(words);
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
