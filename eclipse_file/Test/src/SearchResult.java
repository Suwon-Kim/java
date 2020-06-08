import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class SearchResult extends JDialog {
	private JLabel lblSearchImg;
	private JTextField lblSearchContent;
	
	private JButton btnSearch;
	
	private JLabel lblFileTitle;
	private JLabel lblFileDate;
	private JLabel lblFileSize;
	
	private JLabel[] lblFile = new JLabel[15];
	
	private JButton btnClose;
	
	public SearchResult() {
		init();
		setDisplay();
		showDialog();
		addListeners();
	}
	public void init() {

		lblSearchImg = new JLabel(new ImageIcon("search.png"), JLabel.LEFT);
		lblSearchContent = new JTextField(20);
		btnSearch = new JButton("검색");
		
		lblFileTitle = new JLabel("파일제목", JLabel.LEFT);
		lblFileTitle.setBorder(new EmptyBorder(0,32,0,0));
		lblFileDate = new JLabel("작성일", JLabel.CENTER);
		lblFileDate.setBorder(new EmptyBorder(0,0,0,15));
		lblFileSize = new JLabel("크기", JLabel.RIGHT);
		lblFileSize.setBorder(new EmptyBorder(0,0,0,48));
				
		btnClose = new JButton("닫기");
	}
	public void setDisplay() {
		JPanel pnlMain = new JPanel(new BorderLayout());
		pnlMain.setBorder(new EmptyBorder(20,20,20,20));
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBorder(new EmptyBorder(0,0,20,0));
		pnlNorth.add(lblSearchImg);
		pnlNorth.add(lblSearchContent);
		pnlNorth.add(btnSearch);
		
		JPanel pnlFileTitle = new JPanel(new BorderLayout());
		pnlFileTitle.setPreferredSize(new Dimension(360,30));
		pnlFileTitle.add(lblFileTitle, BorderLayout.WEST);
		pnlFileTitle.add(lblFileDate, BorderLayout.CENTER);
		pnlFileTitle.add(lblFileSize, BorderLayout.EAST);
		pnlFileTitle.setBorder(new LineBorder(Color.BLUE, 1));
		
		JPanel pnlFile = new JPanel(new GridLayout(0,3));
		pnlFile.setBorder(new LineBorder(Color.BLUE));
		
		for(int idx = 0; idx < 15; idx++) {
			lblFile[idx] = new JLabel("StringBuffer", JLabel.CENTER);
			pnlFile.add(lblFile[idx]);
			
		}
		
		JPanel pnlCenter = new JPanel(new BorderLayout());
		pnlCenter.add(pnlFileTitle, BorderLayout.NORTH);
		pnlCenter.add(pnlFile, BorderLayout.CENTER);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnClose);
		
		pnlMain.add(pnlNorth, BorderLayout.NORTH);
		pnlMain.add(pnlCenter, BorderLayout.CENTER);
		pnlMain.add(pnlSouth, BorderLayout.SOUTH);
		
		add(pnlMain);
		
	}
	public void showDialog() {
		setTitle(" " + "검색 결과");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public void addListeners() {
		ActionListener aListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(btnClose == ae.getSource()) {
					dispose();
				}
			}
		};
		WindowListener wListener = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		};
		addWindowListener(wListener);
		btnClose.addActionListener(aListener);
	}
}
