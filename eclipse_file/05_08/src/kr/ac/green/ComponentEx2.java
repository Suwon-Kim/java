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
//		tFName.setEditable(false); //드래그는 됨 편집가능 여부
		tFName.setEnabled(false);	// 드래그도 안됨 비활성화 상태
		JLabel lblName = new JLabel("이름");
		
		JPanel pnlName = new JPanel();
		pnlName.add(lblName);
		pnlName.add(tFName);
		
		JTextArea taInput = new JTextArea(6,30);
		taInput.setText("Hello Java");
		taInput.append("\nFUCK");
		
		// 자동줄바꿈
		taInput.setLineWrap(true);
		
		// 줄 바꿈 단어 단위로 줄바꿈 자동줄바꿈이 전제 되어야함
		taInput.setWrapStyleWord(true);
		
		JScrollPane scroll = new JScrollPane(taInput);
		//scroll.setHorizontalScrollBarPolicy(
			//JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS // : 항상 가로 스크롤바 표시
			//JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED (DEFAULT값임) : 필요할때만
			//JScrollPane.HORIZONTAL_SCROLLBAR_NEVER : 사용안함
		
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
