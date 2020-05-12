package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.AbstractBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class BorderTest extends JFrame {
	
	private Font font = new Font(Font.DIALOG, Font.BOLD, 25);
	
	public BorderTest() {
		JPanel pnlMain = new JPanel(new GridLayout(0, 1, 10, 10));
		JScrollPane scroll = new JScrollPane(pnlMain);
		
		// insets : 위, 왼, 아래, 오
		Insets insets = new Insets(20, 20, 20, 20);
		pnlMain.setBorder(new EmptyBorder(insets));
		
		AbstractBorder border = new LineBorder(Color.BLACK, 2);
		pnlMain.add(getLabel("LineBorder", border));
		
		border = new TitledBorder("this is a title");
		pnlMain.add(getLabel("TitleBorder", border));
		
		LineBorder lBorder = new LineBorder(Color.GRAY, 1);
		border = new TitledBorder(lBorder, "TitleBorder + LineBorder");
		pnlMain.add(getLabel("TitledBorder", border));
		
		TitledBorder tBorder = new TitledBorder("right");
		//횡 위치 설정
		tBorder.setTitleJustification(TitledBorder.RIGHT);
		border = tBorder;
		pnlMain.add(getLabel("TitledBorder", border));
		
		tBorder = new TitledBorder("CENTER-BOTTOM");
		//타이블 종위치 설정
		tBorder.setTitleJustification(TitledBorder.CENTER);
		tBorder.setTitlePosition(TitledBorder.BOTTOM);
		pnlMain.add(getLabel("TitledBorder", tBorder));
		
		tBorder= new TitledBorder("ABOVE-BOTTOM");
		tBorder.setTitlePosition(TitledBorder.ABOVE_BOTTOM);
		pnlMain.add(getLabel("TitledBorder", tBorder));
		
		tBorder= new TitledBorder("ABOVE-BOTTOM");
		tBorder.setTitlePosition(TitledBorder.ABOVE_TOP);
		pnlMain.add(getLabel("TitledBorder", tBorder));
		
		tBorder = new TitledBorder("BELOW-TOP");
		tBorder.setTitlePosition(TitledBorder.BELOW_TOP);
		pnlMain.add(getLabel("TitledBorder", tBorder));
		

		tBorder = new TitledBorder("BELOW-BOTTOM");
		tBorder.setTitlePosition(TitledBorder.BELOW_BOTTOM);
		pnlMain.add(getLabel("TitledBorder", tBorder));
		
		tBorder = new TitledBorder("TEXT");
		
		//타이블 폰트설정
		tBorder.setTitleFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 15));
		pnlMain.add(getLabel("TitledBorder", tBorder));
		
		tBorder.setTitleColor(Color.RED);
		pnlMain.add(getLabel("TitledBorder", tBorder));
		
		TitledBorder innerBorder = new TitledBorder(
			new LineBorder(Color.BLUE, 1),
			"inner-border"
			
		);
		innerBorder.setTitlePosition(TitledBorder.BOTTOM);
		
		tBorder = new TitledBorder (
			innerBorder,
			"TOP"
		);
		pnlMain.add(getLabel("TitledBorder", tBorder));
		
		//테두리가 솟아오른 것
		border = new EtchedBorder(EtchedBorder.RAISED);
		pnlMain.add(getLabel("EtchedBorder-RAISED", border));
		
		border = new BevelBorder(BevelBorder.LOWERED);
		pnlMain.add(getLabel("BevelBorder-RASIED", border));
		
		border = new BevelBorder(BevelBorder.RAISED);
		pnlMain.add(getLabel("BevelBorder-RASIED", border));
		
		//테두리가 깎인것
		border = new EtchedBorder(EtchedBorder.LOWERED);
		pnlMain.add(getLabel("EtchedBorder-LOWERED", border));
		
		add(scroll, BorderLayout.CENTER);
		
		//세로 스크롤바를 가져온다
		JScrollBar bar = scroll.getVerticalScrollBar();
		// 스크롤바의 움직이는 단위를 설정한다.
		bar.setUnitIncrement(3);
		
		
		
		
		
		setTitle("Border Test");
		setSize(400, 300);
		//pack();
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	//AbstractBorder << border의 부모객체
	private JLabel getLabel(String text, AbstractBorder border) {
		JLabel lbl = new JLabel(text);
		lbl.setFont(font);
		lbl.setBorder(border);
		return lbl;
	}
	public static void main(String[] args) {
		new BorderTest();
	}
}
