import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InputEx extends JFrame implements ActionListener {
	private JTextField tfInput;
	private JTextArea taOutput;
	private JButton btn1Send;
	
	public InputEx() {
		tfInput = new JTextField(20);
		btnSend = new JButton("Send");
		btnSend.setPreferredSize(new Dimension(40,20));
		btnSend.setMargin(new Insets(1,1,1,1));
		taOutput = new JTextArea(10, 40);
		taOutput.setEditable(false);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(tfInput);
		pnlSouth.add(btnSend);
		
		add(new JScrollPane(taOutput), BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
		
		btnSend.addActionListener(this);
		tfInput.addActionListener(this);
		
		
		
		setTitle("Fake Chat");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		System.out.println(tfInput.getSize());
		System.out.println(btnSend.getSize());
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		taOutput.append(tfInput.getText() + "\n");
		tfInput.requestFocus();
		tfInput.selectAll();
	}
	public static void main(String[] args) {
		new InputEx();
	}
}
