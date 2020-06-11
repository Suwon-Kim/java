import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class SearchResult extends JDialog{
	public static final Dimension LBL_SIZE = new Dimension(180, 30);
	
	private File file = new File("allFileInfo.properties");
	
	private String searchWord;
	private StudyMemo owner;
	
	private JLabel lblImage;
	private JLabel lblTitle;
	private JLabel lblDate;
	
	private JTextField tfSearch;
	
	private JButton btnSearch;
	private JButton btnClose;
	
	private JPanel pnlList;
	
	private JLabel[] lblFiles;
	private JLabel[] lblDates;
	
	public SearchResult(StudyMemo owner, String searchWord) {
		super(owner, "검색 결과 창", true);
		this.owner = owner;
		this.searchWord = searchWord;
		init();
		setDisplay();
		addListeners();
		showDlg();
	}
	private void init() {
		lblImage = new JLabel(new ImageIcon("search.png"));
		lblTitle = new JLabel("파일제목", JLabel.CENTER);
		lblTitle.setPreferredSize(LBL_SIZE);
		lblTitle.setBorder(new LineBorder(new Color(178, 204, 255), 2));
		lblDate = new JLabel("작성일", JLabel.CENTER);
		lblDate.setPreferredSize(LBL_SIZE);
		lblDate.setBorder(new LineBorder(new Color(178, 204, 255), 2));
		
		
		tfSearch = new JTextField(20);
		tfSearch.setText(searchWord);
		btnSearch = new JButton("검색");
		btnSearch.setToolTipText("파일제목이나 해시태그로 검색해주세요");
		btnClose = new JButton("닫기");
		
		
	}
	private void setDisplay() {
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBorder(new EmptyBorder(20, 20, 50, 20));
		JPanel pnlSearch = new JPanel();
		pnlSearch.add(lblImage);
		pnlSearch.add(tfSearch);
		pnlSearch.add(btnSearch);
		pnlNorth.add(pnlSearch);
		
		JPanel pnlCenter = new JPanel();
		pnlList = new JPanel(new GridLayout(0, 2));
		
		pnlList.add(lblTitle);
		pnlList.add(lblDate);
		pnlCenter.add(pnlList);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnClose);
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	private void addListeners() {
		
	}
	private void showDlg() {
		setTitle(searchWord + " 검색 결과");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
