

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MyLoad extends JDialog {
	// 파일 이름을 나타내는 ArrayList 입니다
	private List<String> list;
	private JPanel pnlGrid;
	// 파일에 따라 동적으로 변환
	private MyloadPanel[] pnlLoadPanel;
	// 날짜를 알기 위해서 문제와 그에 맞는 날짜가 필요해서
	// 2가지의 값을 가질수 있는 Map을 사용
	private Map<File, Vector<Problem>> map;

	// 파일 수정 날짜의 JLabel 값 (2020-06-12)
	private String[] timeText;
	// 파일 수정 날짜를 말함
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(a hh:mm)");
	private JButton[] btnDelete;
	
	public MyLoad(Map<File, Vector<Problem>> map) {
		this.map = map;
		init();
		today();
		setDisplay();
		addListeners();
		showFrame();

	}

	private void today() {
		Set<File> keys = map.keySet();
		list = new ArrayList<String>();
		for (File f : keys) {
			list.add(f.getName());
		}

		for (int idx = 0; idx < timeText.length; idx++) {
			File f = new File("wrongfile\\" + list.get(idx));
			long time = f.lastModified();
			Date today = new Date();
			today.setTime(time);
			timeText[idx] = sdf.format(today);
		}
	}

	private void init() {
		btnDelete = new JButton[map.size()];
		for (int i = 0; i < map.size(); i++) {
			btnDelete[i] = new JButton(new ImageIcon("Cancel.png"));
			btnDelete[i].setContentAreaFilled(false);
			btnDelete[i].setBorderPainted(false);
			btnDelete[i].setMargin(new Insets(0, -5, 0, -5));
		}

		pnlLoadPanel = new MyloadPanel[map.size()];
		timeText = new String[map.size()];
	}

	private void setDisplay() {
		JPanel pnlLblNorth = new JPanel();
		JScrollPane scroll = new JScrollPane();
		JPanel pnlMain = new JPanel(new BorderLayout());

		pnlGrid = new JPanel(new GridLayout(0, 1));
	
		for (int idx = 0; idx < timeText.length; idx++) {
			File f = new File("wrongfile\\" + list.get(idx));
			int num = list.get(idx).lastIndexOf(".");
			pnlLoadPanel[idx] = new MyloadPanel(list.get(idx).substring(0, num), timeText[idx], map.get(f));
			pnlLoadPanel[idx].add(btnDelete[idx]);
			pnlLoadPanel[idx].setBackground(new Color(0x42984d));
			pnlGrid.add(pnlLoadPanel[idx]);
		}

		JLabel lblRecord = new JLabel("기록보기");
		lblRecord.setFont(new Font("메이플스토리",Font.BOLD,20));
		pnlLblNorth.add(lblRecord);
		
		
		scroll.add(pnlMain);

		pnlLblNorth.setBackground(new Color(0xf0c022));

		pnlMain.add(pnlLblNorth, BorderLayout.NORTH);
		pnlMain.add(pnlGrid, BorderLayout.CENTER);
		add(new JScrollPane(pnlMain), BorderLayout.CENTER);
	}

	private void removeFile(String filename, int pnlNum) {
		int result = JOptionPane.showConfirmDialog(this, "삭제하시겠습니까?","알림",JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION){
		File f = new File(("wrongfile\\" + filename + ".dat"));
		f.delete();
		pnlLoadPanel[pnlNum].setBackground(Color.black);
		JOptionPane.showMessageDialog(this, filename + " 삭제 되었습니다");
		}else{
			pnlLoadPanel[pnlNum].setBackground(new Color(0x42984d));
		}
	}

	private void addListeners() {
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < map.size(); i++) {	
					if (btnDelete[i] == e.getSource()) {					
						int num = list.get(i).lastIndexOf(".");
						String str = list.get(i).substring(0, num);
						removeFile(str,i);				
															
					}			
				}
			
			}
			
		};

		for (int i = 0; i < map.size(); i++) {
			btnDelete[i].addActionListener(listener);
		}
	}

	private void showFrame() {
		setTitle("기록보기");
		// 세로로 추가하는건 GridLayout 이라서 사이즈 지정하면
		// 그만큼 공백이 생기게 됩니다
		
		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(520, 430);
		setResizable(false);
		setVisible(true);
	}

}