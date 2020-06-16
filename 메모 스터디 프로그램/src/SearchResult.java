import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class SearchResult extends JDialog{
	public static final Dimension BTN_SIZE = new Dimension(50, 30);
	public static final Dimension LBL_SIZE = new Dimension(180, 30);
	
	
	private StudyMemo owner;
	private String searchWord;
	
	private JButton btnSearch;
	private JButton btnClose;
	
	private JLabel lblImage;
	private JTextField tfSearch;
	
	private JLabel[] lblDates;
	private JLabel[] lblTitles;
	
	private Vector<FileInfo> vecFile;
	private Vector<String> vecDate = new Vector<String>();
	private Vector<String> vecTitle = new Vector<String>();
	
	public SearchResult(StudyMemo owner, String searchWord) {
		super(owner, searchWord + " 검색 결과" , false);
		this.owner = owner;
		this.searchWord = searchWord;
		
		init();
		setDisplay();
		addListeners();
		showDlg();
	}
//	public SearchResult(StudyMemo owner, String searchWord, boolean update) {
//		super(owner, searchWord + " 검색 결과" , false);
//		this.owner = owner;
//		this.searchWord = searchWord;
//		
//		init();
//		setDisplay();
//		addListeners();
//		showDlg();
//	}
	private void init() {
		lblImage = new JLabel();
		lblImage.setIcon(new ImageIcon("search.png"));
		
		tfSearch = new JTextField(20);
		tfSearch.setText(searchWord);
		
		btnSearch = new JButton("검색");
		btnSearch.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		btnSearch.setBackground(Color.pink);
		btnSearch.setBorder(new LineBorder(Color.pink));
		btnSearch.setPreferredSize(BTN_SIZE);
		btnSearch.setToolTipText("파일 제목이나 태그로 검색하세요");
		
		
		btnClose = new JButton("닫기");
		btnClose.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
		btnClose.setBackground(Color.pink);
		btnClose.setBorder(new LineBorder(Color.pink));
		btnClose.setPreferredSize(BTN_SIZE);
	}
	private void setDisplay() {
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBorder(new EmptyBorder(0, 0, 50, 0));
		pnlNorth.setBackground(new Color(255, 234, 234));
		
		JPanel pnlSearch = new JPanel();
		pnlSearch.setBackground(new Color(255, 234, 234));
		
		pnlSearch.add(lblImage);
		pnlSearch.add(tfSearch);
		pnlSearch.add(btnSearch);
		
		pnlNorth.add(pnlSearch);
		
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.setBackground(new Color(255, 234, 234));
		pnlCenter.add(getFileListPanel());
		
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBorder(new EmptyBorder(50, 0, 0, 0));
		pnlSouth.setBackground(new Color(255, 234, 234));
		
		pnlSouth.add(btnClose);
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	private JPanel getFileListPanel() {
		JPanel pnlFileList = new JPanel();
		pnlFileList.setBackground(new Color(255, 234, 234));
		
		boolean exist = false;
		
		vecFile = owner.getVecFile();
		//제목과 태그로 검색을 한다.
		
		
		if(vecFile != null) {
			for(FileInfo file : vecFile) {
				String targetDate = file.getDate();
				String targetTitle = file.getTitle();
				HashSet<String> targetTagSet = file.getTagSet();
				
				if(searchWord.equals(targetTitle)) {
					//검색어와 파일제목이 일치한다.
					vecDate.add(targetDate);
					vecTitle.add(targetTitle);
					exist = true;
				} else if(targetTagSet.contains(searchWord)) {
					vecDate.add(targetDate);
					vecTitle.add(targetTitle);
					exist = true;
				}
			}
			
			if(!exist) {
				JLabel lblInfo = new JLabel("검색 결과가 존재하지 않습니다.", JLabel.CENTER);
				lblInfo.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
				lblInfo.setOpaque(true);
				lblInfo.setBackground(Color.pink);
				lblInfo.setForeground(Color.black);
				
				pnlFileList.add(lblInfo);
			} else {
				makeLabels();
				
				pnlFileList.setLayout(new GridLayout(0, 2));
				
				JLabel lblDate = new JLabel("작성일", JLabel.CENTER);
				lblDate.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
				lblDate.setPreferredSize(LBL_SIZE);
				lblDate.setOpaque(true);
				lblDate.setBackground(Color.pink);
				lblDate.setForeground(Color.black);
				
				JLabel lblTitle = new JLabel("파일제목", JLabel.CENTER);
				lblTitle.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
				lblTitle.setPreferredSize(LBL_SIZE);
				lblTitle.setOpaque(true);
				lblTitle.setBackground(Color.pink);
				lblTitle.setForeground(Color.black);
				
				pnlFileList.add(lblDate);
				pnlFileList.add(lblTitle);
				
				for(int idx=0; idx<lblDates.length; idx++) {
					pnlFileList.add(lblDates[idx]);
					pnlFileList.add(lblTitles[idx]);
				}
			}
		} else {
			JLabel lblInfo = new JLabel("검색 결과가 존재하지 않습니다.", JLabel.CENTER);
			lblInfo.setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
			lblInfo.setOpaque(true);
			lblInfo.setBackground(Color.pink);
			lblInfo.setForeground(Color.black);
			
			pnlFileList.add(lblInfo);
		}
		return pnlFileList;
	}
	private void makeLabels() {
		lblDates = new JLabel[vecDate.size()];
		lblTitles = new JLabel[vecTitle.size()];
		
		int idx = 0;
		Iterator<String> itDate = vecDate.iterator();
		while(itDate.hasNext()) {
			lblDates[idx] = new JLabel(itDate.next(), JLabel.CENTER);
			lblDates[idx].setOpaque(true);
			lblDates[idx].setBackground(Color.WHITE);
			lblDates[idx].setForeground(Color.BLACK);
			lblDates[idx].setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
			idx++;
		}
		
		idx = 0;
		Iterator<String> itTitle = vecTitle.iterator();
		while(itTitle.hasNext()) {
			lblTitles[idx] = new JLabel(itTitle.next(), JLabel.CENTER);
			lblTitles[idx].setOpaque(true);
			lblTitles[idx].setBackground(Color.WHITE);
			lblTitles[idx].setForeground(Color.BLACK);
			lblTitles[idx].setFont(new Font("MapoGoldenPier", Font.BOLD, 15));
			idx++;
		}
	}
	private void addListeners() {
		ActionListener aListener = (ae) -> {
			Object o = ae.getSource();
			
			if(o == btnSearch) {
				searchWord = tfSearch.getText();
				dispose();
				new SearchResult(owner, searchWord);
			} else if(o == btnClose) {
				dispose();
			}
		};
		
		btnSearch.addActionListener(aListener);
		btnClose.addActionListener(aListener);
		
		if(lblTitles != null) {
			for(int idx=0; idx<lblTitles.length; idx++) {
				final int index = idx;
				
				lblTitles[idx].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent me) {
						String date = lblDates[index].getText();
						String title = lblTitles[index].getText();
						
						new MyMemo(date, title, owner, owner.getCalendar());
					}
				});
			}
		}
	}
	private void showDlg() {
		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
