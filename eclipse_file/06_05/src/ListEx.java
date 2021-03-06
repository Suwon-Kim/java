
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
/*
 * MVC
 * Model : 데이터 -> ListModel
 * View : 어떻게 보여지는가? -> ListCellRenderer
 * Controller : 기능 -> JList
 */
public class ListEx extends JFrame implements ActionListener {
	
	private JList<Human> list;
	private DefaultListModel<Human> model;
	private JTextField tfName;
	private JTextField tfAge;
	private JRadioButton rbtnMale;
	private JRadioButton rbtnFemale;
	private JButton btnAdd;
	public ListEx() {
		model = new DefaultListModel<Human>();
		list = new JList<Human>(model);
		list.setVisibleRowCount(5);
		
		tfName = new JTextField(15);
		tfAge = new JTextField(5);
		rbtnMale = new JRadioButton("Male");
		rbtnFemale = new JRadioButton("Female", true);
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnMale);
		group.add(rbtnFemale);
		btnAdd = new JButton("Add");
		
		//list.setPrototypeCellValue(new Human("aaaaaaaaaaa", 100, Human.FEMALE));
		// JScrollPane에 감싸져있을때만 동작
		list.setCellRenderer(new MyListRenderer());
		
		
		JPanel pnlSouth = new JPanel(new GridLayout(0, 1));
		pnlSouth.add(tfName);
		pnlSouth.add(tfAge);
		JPanel pnlGender = new JPanel();
		pnlGender.add(rbtnMale);
		pnlGender.add(rbtnFemale);
		pnlSouth.add(pnlGender);
		pnlSouth.add(btnAdd);
		
		
		add(new JScrollPane(list), BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
		
		btnAdd.addActionListener(this);
		
		setTitle("JListEx");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = tfName.getText();
		int age = Integer.parseInt(tfAge.getText());
		boolean gender = Human.MALE;
		if(rbtnFemale.isSelected()) {
			gender = Human.FEMALE;			
		}
		
		Human h = new Human(name, age, gender);
		
		model.addElement(h);
	}
	
	private class MyListRenderer extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(
				JList<?> list,
				Object value, 
				int index,
				boolean isSelected,
				boolean cellHasFocus
		) {
			JPanel pnl = new JPanel();
			Human h = (Human)value;
			JLabel lblGender = new JLabel(
					new ImageIcon("Female-icon.png")
			);
			if(h.isGender() == Human.MALE) {
				lblGender.setIcon(new ImageIcon("male-icon.png"));
			}
			
			JLabel lblInfo = new JLabel();
			lblInfo.setText(h.getName() + "(" + h.getAge() + ")");
			
			pnl.add(lblGender);
			pnl.add(lblInfo);
			
			if(cellHasFocus) {
				pnl.setBackground(Color.YELLOW);
				pnl.setBorder(new LineBorder(Color.GRAY, 1));
			}
			return pnl;
		}	
	}
	public static void main(String[] args) {
		new ListEx();
	}
}






