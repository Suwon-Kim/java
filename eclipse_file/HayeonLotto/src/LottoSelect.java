import java.awt.BorderLayout;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class LottoSelect extends JDialog {
	private LottoStart owner;
	private int count;						// �ζ� ���� ���
	
	private LottoPaper[] lottopapers;

	private JButton btnBuy;
	private JButton btnCancel;

	public LottoSelect(LottoStart owner, int count) {
		super(owner, "�ζ� ����", false);
		this.owner = owner;
		this.count = count;
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	//�ζ� ���� ����� ��ȯ�Ѵ�.
	public int getCount() {
		return count;
	}
	
	//������ LottoPaper���� ���� �迭�� ��ȯ�Ѵ�.
	public LottoPaper[] getLottoPapers() {
		return lottopapers;
	}
	
	private void init() {
		lottopapers = new LottoPaper[count];
		
		for(int idx=0; idx<lottopapers.length; idx++) {
			lottopapers[idx] = new LottoPaper(idx+1);
		}
		
		btnBuy = new JButton("����");
		btnCancel = new JButton("���");	
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
		//���� ��ư ������ ���� �̺�Ʈ�� ����
		btnBuy.addActionListener((ae) -> {
			int ok = 0;
			for(int idx=0; idx<lottopapers.length; idx++) {
				TreeSet<Integer> myBalls = lottopapers[idx].getBalls();
				//�� ȸ���� ������ �� 6���� myBalls�� ��´�.
				
				if(myBalls.size() == 6) {
					//���� 6�� ������� ���� ok���� ���� ����
					ok++;
				}
			}
			if(ok == lottopapers.length) {
				//��� ȸ���� ���� 6�� ���õ��� ��쿡�� LottoResult â�� ����.
				new LottoResult(this);
			} else {
				JOptionPane.showMessageDialog(
						LottoSelect.this, 
						"6�� üũ�� �Ϸ����ּ���"
				);
			}
		});
			
		//��� ��ư ������ ���� �̺�Ʈ�� ����
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
