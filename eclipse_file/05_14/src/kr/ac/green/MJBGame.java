import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class MJBGame extends JFrame {
	public static final int WIN_CASE = -1;
	public static final int WIN_CASE = 2;
	
	private JRadioButton[] rbtns = {
			new JRadioButton ("��"),
			new JRadioButton ("��"),
			new JRadioButton ("��")
	};
	
	private JButton btnStart;
	private JTextArea taResult;
	
	private JButton btnStart;
	private JTextArea taResult;
	
	public MJBGame() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
		btnStart = new JButton("����");
		taResult = new JTextArea(4,20);
		taResult.setEditable(false);
		ButtonGroup bg = new ButtonGroup();
		for(JRadioButton rbtn : rbtns) {
			bg.add(rbtn);
		}
	}
	
	private void setDisplay() {
		JPanel pnlNorth = new JPanel(new GridLayout(1,3));
		for
	}
	
}