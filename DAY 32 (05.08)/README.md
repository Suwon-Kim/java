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

