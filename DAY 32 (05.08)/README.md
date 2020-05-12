	### private : 클래스 내부에서만 접근가능
	
	### 생략 : private + 동일한 패키지일때 접근가능
	
	### protected : 생략 + 상속받은 클래스일때 접근가능
	
	### public : 전부

---

```java
package kr.ac.green;

import java.util.Scanner;

/*
 * ctrl + d : 줄삭제
 * ctrl + shift + o : 자동임포트
 * alt + shift + s -> c : 기본생성자
 * alt + shift + s -> o : 파라미터 처리 생성자
 * alt + shift + s -> r : getter / setter 생성
 * alt + shift + s -> s : toString 생성
 * ctrl + shift + f : 자동줄맞춤
 * alt + shift + t -> n : rename
 * ctrl + f6 : 에디트창 선택
 */
public class Some {
	public String str2 = "zzz";
	String str = "abc";
	private int num;
	private String title;
	private boolean ok;
	private Scanner scan;

	public Some() {
		super();
	}

	public Some(int num, String title, boolean ok) {
		super();
		this.num = num;
		this.title = title;
		this.ok = ok;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	@Override
	public String toString() {
		return "Some [num=" + num + ", title=" + title + ", ok=" + ok + "]";
	}

}

```

```java
package kr.ac.green;
/*
 * ctrl + s : save + compile
 * ctrl + f11 : run
 * alt + shift + x -> j : run
 * ctrl + m : 창 최대화, 복원
 * ctrl + / : 주석처리, 해제
 */
public class HelloJava {
	public static void main(String[] args) {
		System.out.println("Hello Java");
		System.out.println("됌?");
		
	}
}

```

```java
package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComponentEx1 extends JFrame {
	private JLabel lbl;
	
	public ComponentEx1() {
		
		lbl = new JLabel(new ImageIcon("iu.jpg"));
		lbl.setText("아이유짱!");
		
		lbl.setHorizontalTextPosition(JLabel.CENTER);
		lbl.setVerticalTextPosition(JLabel.TOP);
		
		lbl.setToolTipText("이거슨 아이유님 입니다.");
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(Color.WHITE);
		JButton btnGood = new JButton(new ImageIcon("icon2.png"));
		
		btnGood.setRolloverIcon(new ImageIcon("icon1.png"));
		
		btnGood.setPressedIcon(new ImageIcon("icon3.png"));
		
		btnGood.setText("좋아요");
		btnGood.setHorizontalTextPosition(JButton.CENTER);
		btnGood.setVerticalTextPosition(JButton.BOTTOM);
		pnlSouth.add(btnGood);
		
		
		add(lbl, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
		
		
		setTitle("ComponentEx1");
		pack();
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ComponentEx1();
	}
}

```

```java
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

```

```java
package kr.ac.green;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
// 선택
public class ComponentEx3 extends JFrame {
	
	public ComponentEx3(){
		
		setLayout(new GridLayout(0, 1));
		
		JPanel pnlHobby = new JPanel(new GridLayout(0, 1));		
		String[] hobbys = {
			"낮잠", "서핑", "게임", "공부", "독서"	
		};
		/*
		 * JCheckBox : 다중선택
		 */
		JCheckBox[] chHobby = new JCheckBox[hobbys.length];
		for(int i=0; i<chHobby.length; i++) {
			chHobby[i] = new JCheckBox(hobbys[i]);
			chHobby[i].setBackground(new Color(0xDDDDDD));
			pnlHobby.add(chHobby[i]);
		}
		
		chHobby[0].setSelected(true);
		
		JPanel pnlGrade = new JPanel(new GridLayout(0, 1));
		
		
		String[] names = {"A", "B", "C", "D"};
		JRadioButton[] rbtns = new JRadioButton[names.length];
		
		// 논리적인 그룹핑
		ButtonGroup group = new ButtonGroup();
		
		for(int i=0; i<names.length; i++) {
			rbtns[i] = new JRadioButton(names[i]);
			rbtns[i].setBackground(Color.WHITE);
			pnlGrade.add(rbtns[i]);
			group.add(rbtns[i]);
		}
		
		rbtns[0].setSelected(true);
		
		
		String[] menu = {"짜장면", "짬뽕", "탕수육", "칠리새우"};
		JComboBox<String> cbMenu = new JComboBox<String>(menu);
		//제네릭이 쓰였단것은 String 말고도 다른것도 올 수 있다는 뜻임!!!
		JPanel pnlMenu = new JPanel();
		pnlMenu.add(cbMenu);
		
		cbMenu.setSelectedIndex(2);
		
		System.out.println(cbMenu.getSelectedItem());
		add(pnlHobby);
		add(pnlGrade);
		add(pnlMenu);
		
		
		
		setTitle("ComponentEx3");
		pack();
		setLocation(100, 0);
		setSize(500,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		for(JCheckBox temp : chHobby) {
			System.out.println(temp.getText() + " : " + temp.isSelected());
		}
	}
	public static void main(String[] args) {
		new ComponentEx3();
	}
}

```

```java
package kr.ac.green;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
	private JLabel label;
	
	public MyFrame() {
		JLabel label = new JLabel(
			"자바 피자에 오신것을 환영합니다. 피자를 고르세요",
			JLabel.CENTER	
		);
		JButton btnCombo = new JButton("콤보피자");
		JButton btnPotato = new JButton("포테이토 피자");
		JButton btnBul = new JButton("불고기 피자");
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(btnCombo);
		pnlSouth.add(btnPotato);
		pnlSouth.add(btnBul);
		
		add(label, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
		

		setTitle("MyFrame");
		pack();
		setLocation(100,0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}

```

```java
package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame2 extends JFrame {
	
	private JLabel lblInfo;
	private JTextField tfInput;
	private JButton btnCalc;
	private JTextField tfOutput;
	
	public MyFrame2() {
		init();
		setDisplay();
		showFrame();
	}
	
	private void init() {
		lblInfo = new JLabel("거리를 마일단위로 입력하시오");
		tfInput = new JTextField(10);
		
		btnCalc = new JButton("변환");
		
		tfOutput = new JTextField(25);
		tfOutput.setEditable(false);
		tfOutput.setBackground(Color.WHITE);
	}
	
	private void setDisplay() {
		JPanel pnlNorth = new JPanel();
		pnlNorth.add(lblInfo);
		pnlNorth.add(tfInput);		
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.add(btnCalc);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(tfOutput);
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	
	private void showFrame() {
		setTitle("마일을 킬로미터로 변환");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame2();
	}
}

```

