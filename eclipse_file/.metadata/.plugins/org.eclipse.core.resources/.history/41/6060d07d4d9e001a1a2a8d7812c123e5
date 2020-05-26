import java.awt.BorderLayout;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class LottoSelect extends JDialog {
	private LottoStart owner;
	private int count;						// 로또 구매 장수
	
	private LottoPaper[] lottopapers;

	private JButton btnBuy;
	private JButton btnCancel;

	public LottoSelect(LottoStart owner, int count) {
		super(owner, "로또 용지", false);
		this.owner = owner;
		this.count = count;
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	//로또 구매 장수를 반환한다.
	public int getCount() {
		return count;
	}
	
	//구매한 LottoPaper들을 담은 배열을 반환한다.
	public LottoPaper[] getLottoPapers() {
		return lottopapers;
	}
	
	private void init() {
		lottopapers = new LottoPaper[count];
		
		for(int idx=0; idx<lottopapers.length; idx++) {
			lottopapers[idx] = new LottoPaper(idx+1);
		}
		
		btnBuy = new JButton("구매");
		btnCancel = new JButton("취소");	
	}
	
	private void setDisplay() {
		JPanel pnlMain = new JPanel();
		
		for(int idx=0; idx<lottopapers.length; idx++) {
			pnlMain.add(lottopapers[idx].getPnlRound());
		}
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnBuy);
		pnlSouth.add(btnCancel);
		
		add(pnlMain, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	
	private void addListeners() {
		//구매 버튼 눌렀을 때의 이벤트를 정의
		btnBuy.addActionListener((ae) -> {
			int ok = 0;
			for(int idx=0; idx<lottopapers.length; idx++) {
				TreeSet<Integer> myBalls = lottopapers[idx].getBalls();
				//한 회차의 선택한 공 6개를 myBalls에 담는다.
				
				if(myBalls.size() == 6) {
					//공기 6개 담겨있을 때만 ok변수 값을 증가
					ok++;
				}
			}
			if(ok == lottopapers.length) {
				//모든 회차의 공이 6개 선택됐을 경우에만 LottoResult 창을 띄운다.
				new LottoResult(this);
			} else {
				JOptionPane.showMessageDialog(
						LottoSelect.this, 
						"6개 체크를 완료해주세요"
				);
			}
		});
			
		//취소 버튼 눌렀을 때의 이벤트를 정의
		btnCancel.addActionListener((ae) -> {
			dispose();
			owner.setVisible(true);
		});
	}
	private void showFrame() {
		pack();
		setResizable(false);
		setLocationRelativeTo(owner);
		owner.setVisible(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
