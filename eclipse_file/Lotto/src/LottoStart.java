import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class LottoStart extends JFrame {
	private JLabel mainImg;
	private JLabel HowManyBuy;
	private JLabel MaxBuy;
	
	private JButton btnButton;
	private JButton btnCancel;
	
	//private JPanel pnlNorth;
	
	public LottoStart() {
		init();
		setDisplay();
		addListeners();
		showFrame();
		
	}
	public void init() {
		
		mainImg = new JLabel();
		Image img = Toolkit.getDefaultToolkit().getImage("lotto.jpg");
		Image newSizeImg = img.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		mainImg.setIcon(new ImageIcon(newSizeImg));
		
		
		HowManyBuy = new JLabel("������ �����Ͻðڽ��ϱ�?",JLabel.CENTER);
		MaxBuy = new JLabel("(�ִ� 5�� ���Ű���)", JLabel.CENTER);
		
		btnButton = new JButton("����");
		btnCancel = new JButton("���");
		
	}
	public void setDisplay() {
	
		String[] count = {"1","2","3","4","5"};
		JComboBox combo = new JComboBox(count);
	
		JPanel pnlCombo = new JPanel();
		pnlCombo.add(combo);

		JPanel pnlNorth = new JPanel();
		JPanel pnlCenter = new JPanel(new BorderLayout());
		JPanel pnlSouth = new JPanel();
		
		pnlNorth.add(mainImg);
		
		pnlCenter.add(HowManyBuy, BorderLayout.NORTH);
		pnlCenter.add(MaxBuy, BorderLayout.CENTER);
		pnlCenter.add(pnlCombo,BorderLayout.SOUTH);
		
		pnlCombo = new JPanel();
		
		pnlSouth.add(btnButton);
		pnlSouth.add(btnCancel);
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth,BorderLayout.SOUTH);
		
	}
	public void addListeners() {
		
	}
	
	public void showFrame() {
		setTitle("�ζ� ���� â");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	 
	public static void main(String[] args) {
		new LottoStart();
	}
}