import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardLayoutEx extends JFrame implements ItemListener {
	private static char code = 'A';
	private JPanel pnlMain;
	private CardLayout card;
	
	//�� ī���� �̸�
	// ȭ���� �̸� ����� ���´� 
	// �̹� ������� ������ ȭ���� ��ȯ�ϴ� ������� ����
	private String[] scenes = {"first", "second", "third"};
	private JComboBox<String> cbScenes;
	
	public CardLayoutEx() {
		card = new CardLayout();
		pnlMain = new JPanel(card);
		for(int i = 0; i < scenes.length; i++) {
			// �г��� ���� 
			pnlMain.add(getPanel(), scenes[i]);
		}
		cbScenes = new JComboBox<String>(scenes);
		cbScenes.addItemListener(this);
		
		add(pnlMain, BorderLayout.CENTER);
		add(cbScenes, BorderLayout.SOUTH);
		
		setTitle("CardLayout EX");
		setSize(300 ,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	private static JPanel getPanel() {
		JPanel pnl = new JPanel(new BorderLayout());

		JLabel lbl = new JLabel(String.valueOf(code), JLabel.CENTER);
		lbl.setFont(new Font(Font.SERIF, Font.BOLD, 60));
		pnl.add(lbl, BorderLayout.CENTER);
		code++;
		return pnl;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// Object �������� �´�.
		
		String name = cbScenes.getSelectedItem().toString();
		card.show(pnlMain, name);
	}
	public static void main(String[] args) {
		new CardLayoutEx();
	}
}
