import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LottoStart extends JFrame{
	private JButton btnBuy;
	private JButton btnCancel;

	private JLabel lblInfo1;
	private JLabel lblInfo2;
	
	private JComboBox cbCount;
	
	public LottoStart() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
		btnBuy = new JButton("����");
		btnCancel = new JButton("���");
		
		lblInfo1 = new JLabel("�� ���� �����Ͻðڽ��ϱ�?", JLabel.CENTER);
		lblInfo1.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		
		lblInfo2 = new JLabel("(�ִ� 5�� ���Ű���)", JLabel.CENTER);
		lblInfo2.setFont(new Font(Font.SERIF, Font.BOLD, 20));

		String[] count = { "1", "2", "3", "4", "5" };
		cbCount = new JComboBox(count);
	}
	
	private void setDisplay() {
		JPanel pnlNorth = new JPanel();
		JLabel lblLottoImage = new JLabel();
		
		lblLottoImage.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().
				getImage("lotto.jpg").
				getScaledInstance(500, 300, Image.SCALE_SMOOTH)
			)
		);
		
		pnlNorth.add(lblLottoImage);
		
		JPanel pnlCenter = new JPanel(new BorderLayout());
		pnlCenter.setBorder(new EmptyBorder(100, 100, 100, 100));
		
		JPanel pnlCombo = new JPanel();
		pnlCombo.add(cbCount);
		pnlCombo.setBorder(new EmptyBorder(20, 0, 0, 0));
		
		pnlCenter.add(lblInfo1, BorderLayout.NORTH);
		pnlCenter.add(lblInfo2, BorderLayout.CENTER);
		pnlCenter.add(pnlCombo, BorderLayout.SOUTH);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnBuy);
		pnlSouth.add(btnCancel);
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	
	private void addListeners() {
		btnBuy.addActionListener((ae) -> {
			int select = Integer.parseInt((String)cbCount.getSelectedItem());
			//�޺��ڽ����� ���õ� ��(���� ���) -> String -> int
			new LottoSelect(this, select);
		});
		
		btnCancel.addActionListener((ae) -> {
			windowClose();
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				windowClose();
			}
		});
	}
	
	private void showFrame() {
		setTitle("�ζ� ���� â");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
	
	//������ â ���� �޼���
	private void windowClose() {
		int result = JOptionPane.showConfirmDialog(
				LottoStart.this, 
				"�����Ͻðڽ��ϱ�?", 
				"���� â", 
				JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.QUESTION_MESSAGE
		);
		if(result == JOptionPane.OK_OPTION) {
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new LottoStart();
	}
}
