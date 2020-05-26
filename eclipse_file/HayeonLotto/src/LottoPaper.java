import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.TreeSet;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

class LottoPaper extends JPanel {
	public static final Dimension LBLNUM_SIZE = new Dimension(20, 20);
	public static final Dimension PNLROUND_SIZE = new Dimension(200, 400);
	
	private TreeSet<Integer> balls;
	
	private int round;				//회차
	private JLabel[] lblNums;		//45개의 숫자 레이블
	
	private JPanel pnlRound;		//한 회차의 모든 정보를 담는 패널

	private JRadioButton rbtnAuto;	//자동 버튼
	private JRadioButton rbtnHand;	//수동 버튼
	private String type;			//자동 수동 여부
	
	
	public LottoPaper(int round) {
		this.round = round;
		init();
		setDisplay();
		addListeners();
	}
	
	// 자동,수동 여부를 반환한다.
	public String getType() {
		return type;
	}
	
	// 선택한 번호 6개를 반환한다.
	public TreeSet<Integer> getBalls() {
		return balls;
	}
	
	// 한 회차의 정보를 담은 pnlRound를 반환한다.
	public JPanel getPnlRound() {
		return pnlRound;
	}

	private void init() {
		balls = new TreeSet<Integer>();
		
		lblNums = new JLabel[45];
		
		pnlRound = new JPanel(new BorderLayout());
		pnlRound.setPreferredSize(PNLROUND_SIZE);
			
		rbtnAuto = new JRadioButton("자동");
		rbtnHand = new JRadioButton("수동", true);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnAuto);
		group.add(rbtnHand);
		
		type = "수동";
	}
	
	private void setDisplay() {
		JPanel pnlNorth = new JPanel();
		
		JLabel lblRound = new JLabel(round + "회차", JLabel.CENTER);
		pnlNorth.add(lblRound);
		
		JPanel pnlCenter = new JPanel();
		
		JPanel[] pnlLine = new JPanel[7];
		for(int idx=0; idx<pnlLine.length; idx++) {
			pnlLine[idx] = new JPanel();
		}
		
		int line = 0;
		for(int idx=0; idx<lblNums.length; idx++) {
			lblNums[idx] = new JLabel(String.valueOf(idx+1), JLabel.CENTER);
			lblNums[idx].setBorder(new LineBorder(Color.RED, 1));
			lblNums[idx].setPreferredSize(LBLNUM_SIZE);
			
			if( (idx+1) % 7 == 0) {
				pnlLine[line].add(lblNums[idx]);
				line++;
			} else {
				pnlLine[line].add(lblNums[idx]);
			}
		}
		pnlLine[6].setBorder(new EmptyBorder(0,0,0,100));
		
		for(int idx=0; idx<pnlLine.length; idx++) {
			pnlCenter.add(pnlLine[idx]);
		}
		
		JPanel pnlSouth = new JPanel();
		
		pnlSouth.add(rbtnAuto);
		pnlSouth.add(rbtnHand);
		
		pnlRound.add(pnlNorth, BorderLayout.NORTH);
		pnlRound.add(pnlCenter, BorderLayout.CENTER);
		pnlRound.add(pnlSouth, BorderLayout.SOUTH);
	}
	
	//랜덤한 6개의 공을 생성해 반환한다.
	private TreeSet<Integer> makeRandomBall() {
		balls.clear();
		while(balls.size() < 6) {
			int random = (int)(Math.random() * 45 + 1);
			balls.add(random);
		}
		return balls;
	}
	
	//내가 택한 공 6개에 해당하는 레이블을 검정색으로 칠한다.
	private void paintLabel(TreeSet<Integer> balls) {
		for(Integer ball : balls) {
			int selectBall = (int)ball;
			
			lblNums[selectBall-1].setOpaque(true);
			lblNums[selectBall-1].setBackground(Color.BLACK);
			lblNums[selectBall-1].setFont(new Font(Font.DIALOG, Font.BOLD, 15));
			lblNums[selectBall-1].setForeground(Color.WHITE);
			
		}
	}
	
	//45개의 레이블의 상태를 초기화한다.
	private void resetLabel() {
		balls.clear();
		for(int idx=0; idx<lblNums.length; idx++) {
			lblNums[idx].setBackground(null);
			lblNums[idx].setFont(new Font(Font.DIALOG, Font.BOLD, 12));
			lblNums[idx].setForeground(null);
		}
	}
	
	private void addListeners() {
		ItemListener iListener = (ie) -> {
			JRadioButton src = (JRadioButton)ie.getSource();
			type = src.getActionCommand();
			if(ie.getStateChange() == ItemEvent.SELECTED) {
				if(src == rbtnAuto) {
					// 자동버튼 눌렀을 때의 할 일 정의
					
					balls = makeRandomBall();
					paintLabel(balls);
				}
			} else {
				resetLabel();
			}
		}; 

		MouseListener mListener = new MouseAdapter() {
			int clicked = 0;		//검정으로 색칠된 레이블의 개수

			//색칠된 레이블 개수를 반환
			private int getClicked() {
				int clicked = 0;
				for(int idx=0; idx<lblNums.length; idx++) {
					//레이블의 배경색이 검정일 때만 선택된 것으로 간주한다.
					if(lblNums[idx].getBackground().equals(Color.BLACK)) {
						balls.add(idx+1);
						clicked++;
					}
				}
				return clicked;
			}
			
			@Override
			public void mousePressed(MouseEvent me) {
				JLabel src = (JLabel)me.getSource();
				
				clicked = getClicked();
				if(clicked < 6) {
					//src의 인덱스 값을 받아오는 방법????
					src.setOpaque(true);
					src.setBackground(Color.BLACK);
					src.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
					src.setForeground(Color.WHITE);
					//paintLabel(balls);
				} else {
					youCannotChooseOver6();
				}
				clicked = getClicked();
			}
		};
		
		rbtnAuto.addItemListener(iListener);
		rbtnHand.addItemListener(iListener);
		
		for(int idx=0; idx<45; idx++) {
			lblNums[idx].addMouseListener(mListener);
		}
	}
	
	//6개 초과 클릭 시 발생하는 경고 창.
	private void youCannotChooseOver6() {
		JOptionPane.showConfirmDialog(
				this, 
				"6개이상 선택하실 수 없습니다.", 
				"선택 초과", 
				JOptionPane.DEFAULT_OPTION, 
				JOptionPane.WARNING_MESSAGE
		);
	
	}
}
