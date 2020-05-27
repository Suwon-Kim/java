package kr.ac.green;

import java.awt.BorderLayout;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ComponentEx2 extends JFrame {
	public ComponentEx2() {
		
		JTextField tFName = new JTextField(20);
		tFName.setText("HI ~");
//		tFName.setEditable(false); //�巡�״� �� �������� ����
		tFName.setEnabled(false);	// �巡�׵� �ȵ� ��Ȱ��ȭ ����
		JLabel lblName = new JLabel("�̸�");
		
		JPanel pnlName = new JPanel();
		pnlName.add(lblName);
		pnlName.add(tFName);
		
		JTextArea taInput = new JTextArea(6,30);
		taInput.setText("Hello Java");
		taInput.append("\nFUCK");
		
		// �ڵ��ٹٲ�
		taInput.setLineWrap(true);
		
		// �� �ٲ� �ܾ� ������ �ٹٲ� �ڵ��ٹٲ��� ���� �Ǿ����
		taInput.setWrapStyleWord(true);
		
		JScrollPane scroll = new JScrollPane(taInput);
		//scroll.setHorizontalScrollBarPolicy(
			//JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS // : �׻� ���� ��ũ�ѹ� ǥ��
			//JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED (DEFAULT����) : �ʿ��Ҷ���
			//JScrollPane.HORIZONTAL_SCROLLBAR_NEVER : ������
		
		scroll.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
		);
		
		JPasswordField pwPass = new JPasswordField();
		pwPass.setText("myPassword");
		pwPass.setEchoChar('x');
		char[] password = pwPass.getPassword();
		System.out.println(Arrays.toString(password));
		System.out.println(String.valueOf(password));
		
		add(pnlName, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		add(pwPass, BorderLayout.SOUTH);
		
		
		setTitle("ComponentEx2");
		pack();
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new ComponentEx2();
	}
}