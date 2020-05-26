import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

class LottoResult extends JDialog{
	public static final int BONUS = 6;									//보너스볼의 인덱스값
	public static final String BALL_IMG_PATH = "ball_img/ball_";		//공 이미지 경로
	public static final String MEDAL_IMG_PATH = "medal_img/medal";		//메달 이미지 경로
	public static final String EXT = ".png";							//확장자
	
	private Integer[] winBall;				//당첨공 7개
	private LottoSelect owner;
	private LottoPaper[] lottopapers;
	
	private JButton btnOk;
	private JButton btnMyLucky;

	public LottoResult(LottoSelect owner) {
		super(owner, "당첨 결과", true);
		this.owner = owner;
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
		winBall = makeWinBall();
		
		lottopapers = owner.getLottoPapers();
		
		btnOk= new JButton("확인");
		btnMyLucky = new JButton("나의 운 확인");
	}
	
	private void setDisplay() {
		//pnlNorth : 당첨결과, 당첨볼 이미지를 담는 패널
		JPanel pnlNorth = new JPanel(new BorderLayout());
		
		JLabel lblResult = new JLabel("당첨결과", JLabel.CENTER);
		JPanel pnlPhoto = new JPanel();
	
		//0~5번까지의 winBall을 정렬시킨 후에 이미지를 생성한다
		Arrays.sort(winBall, 0, 6);
		
		for(int idx=0; idx<winBall.length; idx++) {
			int ballNum = (int)winBall[idx];
			if(idx == winBall.length - 1) {
				//보너스볼 이미지를 만들기 전에 plus 이미지를 먼저 생성한다.
				
				JLabel lblPlus = new JLabel();
				lblPlus.setIcon(getConvertedImageSize("plus.png", 40, 40));
				//해당 경로의  40x40 이미지를 lblPlus에 설정한다.
				
				pnlPhoto.add(lblPlus);
			}
			pnlPhoto.add(getImageBall(ballNum, 40, 40));
			//해당 ballNum의 이미지를 40x40 사이즈로 생성한다.
		}
		
		pnlNorth.add(lblResult, BorderLayout.NORTH);
		pnlNorth.add(pnlPhoto, BorderLayout.SOUTH);
		
		
		//pnlCenter : pnlResult(한 회차의 정보와 당첨 결과를 담는 패널)를 여러개 담는 패널
		JPanel pnlCenter = new JPanel(new GridLayout(0, 1));
		for(int idx=0; idx<lottopapers.length; idx++) {
			pnlCenter.add(getRoundResult(idx));
		}
		pnlCenter.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnOk);
		pnlSouth.add(btnMyLucky);
		
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	
	private void addListeners() {
		//구매 버튼 눌렀을 때의 이벤트를 정의
		btnOk.addActionListener((ae) -> {
			dispose();
			owner.setVisible(true);
		});
		
		//나의 운 확인 버튼을 눌렀을 때의 이벤트를 정의
		btnMyLucky.addActionListener((ae) -> {
			showLucky();
		});
	}
	
	//내가 산 로또들로 1등 또는 2등에 당첨될 확률을 나타내는 창을 띄운다.
	private void showLucky() {
		int lucky = 0;		//당첨 확률
		int correct = 0;	//일치 개수
		boolean isStart = true;
		String rank = "";
		
		do {
			lucky++;
			winBall = makeWinBall();	//winBall : Integer[] 7개난수. 정렬안됨.
			
			//Integer bonusBall = winBall[BONUS];
			Integer bonusBall = getBonusBall();
			
			TreeSet<Integer> sixBall = new TreeSet<Integer>();
			for(int idx=0; idx<winBall.length - 1; idx++) {
				sixBall.add(winBall[idx]);
			}
			
			for(int idx=0; idx<lottopapers.length; idx++) {
				correct = 0;	
				TreeSet<Integer> myBalls = lottopapers[idx].getBalls();	//내가 선택한 번호
				
				for(Integer ball : sixBall) {
					if(myBalls.contains(ball)) {
						correct++;
					}
				}
				if(correct == 6) {
					rank = "1등";
					isStart = false;
				} else if((correct == 5) && (myBalls.contains(bonusBall))) {
					rank = "2등";
					isStart = false;
				}
			}
		} while(isStart);
		
		JOptionPane.showMessageDialog(
				LottoResult.this, 
				rank + "  " + lucky + " 번만에 당첨!", 
				"나의 운을 확인하세요", 
				JOptionPane.OK_OPTION
		);
	}

	private void showFrame() {
		pack();
		setLocationRelativeTo(null);
		owner.setVisible(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	//당첨 공 생성 메서드
	private Integer[] makeWinBall() {
		HashSet<Integer> balls = new HashSet<Integer>();
		
		while(balls.size() < 7) {
			int random = (int)(Math.random() * 45 + 1);
			balls.add(random);
		}
		
		return balls.toArray(new Integer[balls.size()]);
	}
	
	//보너스볼 번호를 반환한다.
	private int getBonusBall() {
		//정렬이 안된 당첨볼 7개 중 마지막 볼이 보너스볼이 된다.
		return (int)winBall[BONUS];
	}
	
	
	/*
	 * 		ballNum번의 width x height 볼 이미지를 생성해 반환한다.
	 * 		ballNum : 생성할 이미지의 공 번호
	 * 		width : 이미지 가로 사이즈
	 * 		height : 이미지 세로 사이즈
	 */
	private JLabel getImageBall(int ballNum, int width, int height) {
		JLabel ballImage = new JLabel();
		
		String imagePath = BALL_IMG_PATH + ballNum + EXT;
	
		ballImage.setIcon(getConvertedImageSize(imagePath, width, height));

		return ballImage;
	}
	
	//전달받은 등수(rank)의 메달 이미지를 생성해 반환한다.
	private JLabel getImageRank(int rank) {
		JLabel rankImage = new JLabel();
		
		String imagePath = MEDAL_IMG_PATH + rank + EXT;
		
		rankImage.setIcon(getConvertedImageSize(imagePath, 50, 50));
		//메달 이미지는 50x50 로 설정한다.
		rankImage.setHorizontalAlignment(JLabel.CENTER);
		
		return rankImage;
	}
	
	//내가 원하는 사이즈로 이미지 크기를 변환해 ImageIcon을 반환한다.
	private ImageIcon getConvertedImageSize(String imagePath, int width, int height) {
		return new ImageIcon(
				Toolkit.getDefaultToolkit().
				getImage(imagePath).
				getScaledInstance(width, height, Image.SCALE_SMOOTH)
		);
	}
	
	/*
	 * 		해당 회차의 등수를 반환한다.
	 * 		count : 일치하는 번호의 개수
	 * 		round : 회차 정보
	 * */
	private int getRank(int count, int round) {
		int rank = 6;
		if(count == 6) {
			rank = 1;
		} else if(count == 5) {
			//2,3등을 판별한다
			TreeSet<Integer> MyBalls = lottopapers[round].getBalls();		//내가 선택한 번호
			
			if(MyBalls.contains(getBonusBall())) {
				//보너스 볼을 맞추면 2등이다
				rank = 2;
			} else {
				rank = 3;
			}
		} else if(count == 4) {
			rank = 4;
		} else if(count == 3) {
			rank = 5;
		}
		return rank;
	}
	
	//한 회차의 로또 정보와 당첨 결과를 담는 패널을 반환한다.
	private JPanel getRoundResult(int round) {
		
		//pnlRound : 해당 회차의 로또 정보와 당첨 결과를 담는 패널
		JPanel pnlRound = new JPanel(new GridLayout(0, 3));
		pnlRound.setBorder(new LineBorder(Color.PINK, 1));
		
		String type = lottopapers[round].getType();						//자동 수동 여부
		
		TreeSet<Integer> myBalls = lottopapers[round].getBalls();		//회차 당 내가 선택한 번호
		
		
		//pnlMyBall : 내가 선택한 공 6개의 이미지를 담는 패널
		JPanel pnlMyBall = new JPanel();
		for(Integer ball : myBalls) {
			int ballNum = (int)ball;
			pnlMyBall.add(getImageBall(ballNum, 30, 30));
			//내가 선택한 공들을 30x30 사이즈로 만들어 pnlMyBall에 붙인다.
		}
		
		
		//pnlSameBall : 일치하는 공들의 이미지를 담는 패널
		JPanel pnlSameBall = new JPanel(new GridLayout(0, 7));
		
		int count = 0;
		
		//당첨볼의 6개까지만 비교(보너스볼은 비교를 안함)
		for(int idx=0; idx<winBall.length - 1; idx++) {
			int ball = (int)winBall[idx];
			if(myBalls.contains(ball)) {
				//내가 선택한 번호들 중에 당첨볼이 있다면 pnlSameBall에 붙이고, 일치개수를 증가시킨다.
				int ballNum = ball;
				pnlSameBall.add(getImageBall(ballNum, 30, 30));
				//일치 공 이미지는 30x30으로 설정한다.
				count++;
			}
		}
		
		int rank = getRank(count, round);
		if(rank == 2) {
			//2등일 때만 pnlSameBall에 bonusBall 이미지를 넣는다.
			pnlSameBall.add(getImageBall(getBonusBall(), 30, 30));
		}
		
		JLabel lblRound = new JLabel((round+1) + "회차(" + type + ")", JLabel.CENTER);
		lblRound.setFont(new Font(Font.SERIF, Font.BOLD, 15));
		
		JLabel lblMyBall = new JLabel("내가 산 번호", JLabel.LEFT);
		lblMyBall.setFont(new Font(Font.SERIF, Font.BOLD, 12));
		JLabel lblSameBall = new JLabel("일치 번호", JLabel.LEFT);
		lblSameBall.setFont(new Font(Font.SERIF, Font.BOLD, 12));
		JLabel lblRank = new JLabel("등수", JLabel.CENTER);
		lblRank.setFont(new Font(Font.SERIF, Font.BOLD, 12));
		JLabel lblMedal = getImageRank(rank);
		
		
		JPanel pnlNum = new JPanel(new GridLayout(4, 1));
		pnlNum.add(lblMyBall);
		pnlNum.add(pnlMyBall);
		pnlNum.add(lblSameBall);
		pnlNum.add(pnlSameBall);
		
		
		JPanel pnlRank = new JPanel(new BorderLayout());
		pnlRank.setBorder(new EmptyBorder(10, 0, 0, 0));
		pnlRank.add(lblRank, BorderLayout.NORTH);
		pnlRank.add(lblMedal, BorderLayout.CENTER);
		
		
		pnlRound.add(lblRound);
		pnlRound.add(pnlNum);
		pnlRound.add(pnlRank);
		
		return pnlRound;
	}
}
