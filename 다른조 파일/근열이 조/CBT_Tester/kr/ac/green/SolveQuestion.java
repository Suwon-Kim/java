

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

//문제 푸는 창
class SolveQuestion extends JDialog {
	public static String subName;
	private JRadioButton[] rbAnswer;
	private JPanel pnlMain;
	private CardLayout card;
	private String[] str;
	private JButton btnBack;
	private JButton btnNext;
	private JButton btnCancel;
	private int code;
	private Vector<Problem> vec;	//문제 담겨있는 vec
	private SolveQuestionPanel[] pnl;	//Panel 받아와서 사용
	
	public SolveQuestion(Vector<Problem> vec, String subName) {
		this.subName = subName;
		this.vec = vec;
		init();
		addListeners();
		setDisplay();
		showFrame();
	}
	
	public Vector<Problem> getVec() {
		return vec;
	}
	
	private void init() {	
		
		str = new String[vec.size()];
		pnl = new SolveQuestionPanel[vec.size()];
		for(int i=0; i<str.length; i++) {
			str[i] = ""+ i;
		}
		
		card = new CardLayout();
		pnlMain = new JPanel(card);
		pnlMain.setBorder(new EmptyBorder(0,20,0,20));
		for(code =0; code<str.length; code++) {
			pnl[code] = new SolveQuestionPanel(vec.get(code));
			pnlMain.add(pnl[code], str[code]);
		}

		Font font = new Font("궁서",Font.BOLD,15);
		
		btnBack = new JButton("이전");
		btnBack.setUI(new ButtonStyle());	
		btnBack.setFont(font);
		btnNext = new JButton("다음");
		btnNext.setUI(new ButtonStyle());
		btnNext.setFont(font);
		btnCancel = new JButton("채점");
		btnCancel.setUI(new ButtonStyle());
		btnCancel.setFont(font);
	
	}
	
	protected Vector<Problem> myChoiceVec() {
		
		Vector<Problem> vec = new Vector<>();
		for(int idx = 0; idx < this.vec.size(); idx++) {
			vec.add(pnl[idx].myChoiceNumber());
		}
		
		return vec;
	}
	
	private void addListeners() {
		
		ActionListener listener = new ActionListener() {
			int count = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				Object cmd = e.getSource();
				if( cmd == btnBack) {
					
					//첫번쨰 card를 보고 있다면 JOptionPane 메세지 띄워줌
					if(count == 0){
						JOptionPane.showMessageDialog(null, "첫 페이지 입니다.","에러",JOptionPane.YES_OPTION);
					}else{
						count--;
						card.previous(pnlMain);
					}
					//마지막 card를 보고 있다면 
				}else if(cmd == btnNext) {
					if(count == vec.size() - 1){
						JOptionPane.showMessageDialog(null, "마지막 페이지 입니다.","에러",JOptionPane.YES_OPTION);
					}else{
						count++;
						card.next(pnlMain);
					}
				
				}else {
					JOptionPane.showMessageDialog(null,
							"채점 하시겠습니까?\n풀지 않은 문제는 오답처리 됩니다.",
							"경고",
							JOptionPane.YES_NO_CANCEL_OPTION);
					dispose();
					new TestResult(SolveQuestion.this);
				}
			}
		};
		
		btnBack.addActionListener(listener);
		btnNext.addActionListener(listener);
		btnCancel.addActionListener(listener);
	}
	
	private void setDisplay() {
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBorder(new EmptyBorder(20, 20, 20, 20));
		pnlSouth.setBackground(new Color(255,210,77));
		pnlSouth.add(btnBack);
		pnlSouth.add(btnNext);
		pnlSouth.add(btnCancel);
		
		JScrollPane scroll = new JScrollPane(pnlMain, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.getVerticalScrollBar().setUnitIncrement(12);
		
		add(scroll, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);

	}
	
	private void showFrame(){
		setTitle("문제 풀기");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

}