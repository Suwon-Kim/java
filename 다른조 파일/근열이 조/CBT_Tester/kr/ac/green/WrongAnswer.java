
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

//	오답 보는 창
class WrongAnswer extends JDialog {
	private JTabbedPane tp;
	private JButton btnBack;
	private JButton btnNext;
	private JButton btnCancel;
	private WrongNotePanel[] wap;
	private Vector<Problem> vec;

	public WrongAnswer(Vector<Problem> vec) {
		this.vec = vec;
		init();
		createTap();
		setDisplay();
		addListeners();
		showFrame();
		
		
	}
	private void createTap() {
		tp = new JTabbedPane();
		setTab();
	}
	private void setTab() {

		tp.setTabPlacement(JTabbedPane.LEFT);
		wap = new WrongNotePanel[vec.size()];

		for (int idx = 0; idx < vec.size(); idx++) {
			wap[idx] = new WrongNotePanel(vec.get(idx), idx, vec.get(idx).getResult());
			tp.addTab(String.valueOf(idx + 1), wap[idx]);
			tp.setUI(new MyMainTabbedPaneUI());
		}
		
		

	}
	private void init() {
		btnBack = new JButton("이전");
		btnNext = new JButton("다음");
		btnCancel = new JButton("닫기");
	}

	private JPanel setPanelCenter() {
		JPanel pnlCenter = new JPanel();
		pnlCenter.setBackground(new Color(0x42984d));
		pnlCenter.add(tp);

		return pnlCenter;
	}

	private JPanel setPanelSouth() {
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnBack);
		pnlSouth.add(btnNext);
		pnlSouth.add(btnCancel);
		pnlSouth.setBackground(new Color(0xf0c022));
		return pnlSouth;
	}

	private void setDisplay() {
		JPanel pnlCenter = setPanelCenter();
		JPanel pnlSouth = setPanelSouth();
		
		
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}

	private void addListeners() {
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if (o == btnBack) {
					if (!(tp.getSelectedIndex() == 0)) {
						tp.setSelectedIndex(tp.getSelectedIndex() - 1);
					} else {
						JOptionPane.showMessageDialog(null, "첫번째 페이지 입니다", "에러", JOptionPane.YES_OPTION);
					}
				} else if (o == btnNext) {
					if (!(tp.getSelectedIndex() == vec.size() - 1)) {
						tp.setSelectedIndex(tp.getSelectedIndex() + 1);
					} else {
						JOptionPane.showMessageDialog(null, "마지막 페이지 입니다", "에러", JOptionPane.YES_OPTION);
					}
				} else {
					dispose();
				}

			}
		};
		btnBack.addActionListener(listener);
		btnNext.addActionListener(listener);
		btnCancel.addActionListener(listener);
	}

	private void showFrame() {
		setTitle("WrongAnswer");
		pack();
//		setSize(750, 750);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}