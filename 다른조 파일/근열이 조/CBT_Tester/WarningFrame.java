import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WarningFrame extends JDialog{
	public WarningFrame(String str){
		set(str);
	}
	private void set(String str){
		JPanel pnlMain = new JPanel();
		pnlMain.setBackground(Color.WHITE);
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(Color.WHITE);
		JLabel lblMessa =  new JLabel(str);
		
		lblMessa.setFont(new Font("Maplestory",Font.BOLD,30));
		JLabel lblImage = new JLabel(new ImageIcon("conWarnnig.gif"));	
		
		pnlMain.add(lblMessa);
		pnlSouth.add(lblImage);
		
		add(pnlMain, BorderLayout.NORTH);
		add(pnlSouth, BorderLayout.CENTER);
		
		setTitle("°æ°í");
		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
