import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test extends JFrame {
	private JLabel howManyBuy;
	private JLabel maxBuy;
	
	private JComboBox cbCount;
	String[] count = {"1","2","3","4","5"};
	
	private JButton btnBuy;
	private JButton btnCancel;
	
	public Test() {
		init();
		setDisplay();
		showFrame();
		addListeners();
	}
	public void init() {
		howManyBuy = new JLabel("��� ���� �Ͻðڽ��ϱ�?");
		maxBuy = new JLabel("(�ִ� 5��)");
		cbCount = new JComboBox(count);
		btnBuy = new JButton("����");
		btnCancel = new JButton("���");
	}
	public void setDisplay() {
		JPanel pnlCenter = new JPanel(new BorderLayout());
		
		JPanel pnlCombo = new JPanel();
		pnlCombo.add(cbCount);
		
		pnlCenter.add(howManyBuy);
		pnlCenter.add(maxBuy);
		
		
		
				
	}
	public void addListeners() {
		
	}
	public void showFrame() {
		setTitle("�ζ� â");
		setLocationRelativeTo(null);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Test();
	}
}
