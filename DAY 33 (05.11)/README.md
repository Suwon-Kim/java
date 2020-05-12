```java
package kr.ac.green.first;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/*
 * Button을 누르는 행위 : ActionEvent -> ActionListener
 * 
 */
public class Counter extends JFrame implements ActionListener {
	
	private JLabel lblNum;
	private JButton btnPlus;
	
	public Counter() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
		lblNum = new JLabel("0", JLabel.CENTER);
		lblNum.setFont(new Font(Font.DIALOG, Font.BOLD, 60));
		
		btnPlus = new JButton("Plus");
	}

	private void setDisplay() {
		add(lblNum, BorderLayout.CENTER);
		add(btnPlus, BorderLayout.SOUTH);
	}

	/*
	 * EventSource, EventListener 연결
	 */
	private void addListeners() {
		btnPlus.addActionListener(this);
	}

	private void showFrame() {
		setTitle("Counter");
		setSize(300, 400);
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// ActionEvent 발생 시 할일 정의
		// 1. JLabel의 text(숫자)를 가져온다.(String)
		String strNum = lblNum.getText();
		// 2. String -> int
		int num = Integer.parseInt(strNum);
		// 3. num증가
		num++;
		// 4. int -> String
		strNum = String.valueOf(num);
		// 5. JLabel에 넣기		
		lblNum.setText(strNum);
	}
	
	public static void main(String[] args) {
		new Counter();
	}
}









```

```java
package kr.ac.green.second;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Counter extends JFrame {
	
	private JLabel lblNum;
	private JButton btnPlus;
	
	public Counter() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
		lblNum = new JLabel("0", JLabel.CENTER);
		lblNum.setFont(new Font(Font.DIALOG, Font.BOLD, 60));
		
		btnPlus = new JButton("Plus");
	}

	private void setDisplay() {
		add(lblNum, BorderLayout.CENTER);
		add(btnPlus, BorderLayout.SOUTH);
	}

	private void addListeners() {
		MyActionListener listener = new MyActionListener(this);
		btnPlus.addActionListener(listener);
	}

	private void showFrame() {
		setTitle("Counter");
		setSize(300, 400);
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public JLabel getLblNum() {
		return lblNum;
	}

	public static void main(String[] args) {
		new Counter();
	}
}









```

```java
package kr.ac.green.second;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class MyActionListener implements ActionListener {
	
	private Counter ui;
	
	public MyActionListener(Counter ui) {
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JLabel lblNum = ui.getLblNum();
		String strNum = lblNum.getText();
		int num = Integer.parseInt(strNum);
		num++;
		strNum = String.valueOf(num);
		lblNum.setText(strNum);
	}
}








```

```java
package kr.ac.green.third;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Counter extends JFrame {
	
	private JLabel lblNum;
	private JButton btnPlus;
	
	public Counter() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
		lblNum = new JLabel("0", JLabel.CENTER);
		lblNum.setFont(new Font(Font.DIALOG, Font.BOLD, 60));
		
		btnPlus = new JButton("Plus");
	}

	private void setDisplay() {
		add(lblNum, BorderLayout.CENTER);
		add(btnPlus, BorderLayout.SOUTH);
	}

	private void addListeners() {
		btnPlus.addActionListener(new MyActionListener2(this));
	}

	private void showFrame() {
		setTitle("Counter");
		setSize(300, 400);
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void plusNum() {
		String strNum = lblNum.getText();
		int num = Integer.parseInt(strNum);
		num++;
		strNum = String.valueOf(num);
		lblNum.setText(strNum);
	}
	
	public static void main(String[] args) {
		new Counter();
	}
}









```

```java
package kr.ac.green.third;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener2 implements ActionListener {
	private Counter ui;
	
	public MyActionListener2(Counter ui) {
		this.ui = ui;
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		ui.plusNum();
	}
}

```

```java
package kr.ac.green.fourth;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Counter extends JFrame implements IPressable {
	
	private JLabel lblNum;
	private JButton btnPlus;
	
	public Counter() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
		lblNum = new JLabel("0", JLabel.CENTER);
		lblNum.setFont(new Font(Font.DIALOG, Font.BOLD, 60));
		
		btnPlus = new JButton("Plus");
	}

	private void setDisplay() {
		add(lblNum, BorderLayout.CENTER);
		add(btnPlus, BorderLayout.SOUTH);
	}

	private void addListeners() {
		btnPlus.addActionListener(new MyActionListener3(this));
	}

	private void showFrame() {
		setTitle("Counter");
		setSize(300, 400);
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void buttonPressed() {
		String strNum = lblNum.getText();
		int num = Integer.parseInt(strNum);
		num++;
		strNum = String.valueOf(num);
		lblNum.setText(strNum);
	}

	public static void main(String[] args) {
		new Counter();
	}
}









```

```java
package kr.ac.green.fourth;

public interface IPressable {
	void buttonPressed();
}

```

```java
package kr.ac.green.fourth;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener3 implements ActionListener {
	private IPressable ui;
	
	public MyActionListener3(IPressable ui) {
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ui.buttonPressed();
	}	
}

```

```java
package kr.ac.green.other.first;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
/*
 * 1 mile == 1.6km
 */
public class Answer2 extends JFrame implements ActionListener {

	private JLabel lblInput;
	private JTextField tfInput;
	
	private JButton btnCalc;
	
	private JTextField tfResult;
	
	public Answer2() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}
	
	private void init() {
		lblInput = new JLabel("거리를 마일단위로 입력하시오");
		tfInput = new JTextField(10);
		btnCalc = new JButton("변환");
		tfResult = new JTextField(25);
		tfResult.setEditable(false);
		tfResult.setBackground(Color.WHITE);
		tfResult.setBorder(new LineBorder(Color.GRAY, 1));
	}

	private void setDisplay() {
		JPanel pnlNorth = new JPanel();
		pnlNorth.add(lblInput);
		pnlNorth.add(tfInput);
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.add(btnCalc);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.add(tfResult);
		
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}
	private void addListeners() {
		btnCalc.addActionListener(this);
	}
	private void showFrame() {
		setTitle("마일을 킬로미터로 변환");
		setSize(380, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String msg = "";
		try {
			// 1. 입력한 값을 가져온다. 그리고 double로 바꾼다.
			double mile = Double.parseDouble(tfInput.getText());
			// 2. 계산
			double km = mile * 1.6;
			// 3. 결과값 표시
			msg = km + "km";
		} catch(NumberFormatException e) {
			msg = "숫자만 입력 가능합니다.";
			
			/*
			 * 사용가능 아이콘 플레그
			 * JOptionPane.ERROR_MESSAGE
			 * JOptionPane.WARNING_MESSAGE
			 * JOptionPane.INFORMATION_MESSAGE
			 * JOptionPane.QUESTION_MESSAGE
			 * JOptionPane.PLAIN_MESSAGE
			 */
			JOptionPane.showMessageDialog(
				this,		// 부모창 
				msg, 		// 메세지
				"장난?", 	// 타이틀 
				JOptionPane.ERROR_MESSAGE	// 아이콘
				
			);
		}
		tfResult.setText(msg);
		
		// 커서옮기기
		tfInput.requestFocus();
		// 전부 드레그
		tfInput.selectAll();
	}

	public static void main(String[] args) {
		new Answer2();
	}
}


```

```java
package kr.ac.green.other.second;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/*
 * 1 mile == 1.6km
 */
public class Answer2 extends JFrame {

	private JLabel lblInput;
	private JTextField tfInput;

	private JButton btnCalc;

	private JTextField tfResult;

	public Answer2() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}

	private void addListeners() {
		btnCalc.addActionListener(new CalcActionListener(this));
	}

	private void init() {
		lblInput = new JLabel("거리를 마일단위로 입력하시오");
		tfInput = new JTextField(10);
		btnCalc = new JButton("변환");
		tfResult = new JTextField(25);
		tfResult.setEditable(false);
		tfResult.setBackground(Color.WHITE);
		tfResult.setBorder(new LineBorder(Color.GRAY, 1));
	}

	private void setDisplay() {
		JPanel pnlNorth = new JPanel();
		pnlNorth.add(lblInput);
		pnlNorth.add(tfInput);

		JPanel pnlCenter = new JPanel();
		pnlCenter.add(btnCalc);

		JPanel pnlSouth = new JPanel();
		pnlSouth.add(tfResult);

		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}

	private void showFrame() {
		setTitle("마일을 킬로미터로 변환");
		setSize(380, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}

	public void buttonPressed() {
		double mile = Double.parseDouble(tfInput.getText());
		double km = mile * 1.6;
		tfResult.setText(km + "km");
		tfInput.requestFocus();
		tfInput.selectAll();
	}

	public static void main(String[] args) {
		new Answer2();
	}
}

```

```java
package kr.ac.green.other.second;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcActionListener implements ActionListener {
	private Answer2 ui;
	
	public CalcActionListener(Answer2 ui) {
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ui.buttonPressed();
	}
	
}

```

```java
package kr.ac.green.other.third;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import kr.ac.green.fourth.IPressable;
import kr.ac.green.fourth.MyActionListener3;

/*
 * 1 mile == 1.6km
 */
public class Answer2 extends JFrame implements IPressable {

	private JLabel lblInput;
	private JTextField tfInput;

	private JButton btnCalc;

	private JTextField tfResult;

	public Answer2() {
		init();
		setDisplay();
		addListeners();
		showFrame();
	}

	private void addListeners() {
		btnCalc.addActionListener( new MyActionListener3(this) );
	}

	private void init() {
		lblInput = new JLabel("거리를 마일단위로 입력하시오");
		tfInput = new JTextField(10);
		btnCalc = new JButton("변환");
		tfResult = new JTextField(25);
		tfResult.setEditable(false);
		tfResult.setBackground(Color.WHITE);
		tfResult.setBorder(new LineBorder(Color.GRAY, 1));
	}

	private void setDisplay() {
		JPanel pnlNorth = new JPanel();
		pnlNorth.add(lblInput);
		pnlNorth.add(tfInput);

		JPanel pnlCenter = new JPanel();
		pnlCenter.add(btnCalc);

		JPanel pnlSouth = new JPanel();
		pnlSouth.add(tfResult);

		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}

	private void showFrame() {
		setTitle("마일을 킬로미터로 변환");
		setSize(380, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}
	
	@Override
	public void buttonPressed() {
		double mile = Double.parseDouble(tfInput.getText());
		double km = mile * 1.6;
		tfResult.setText(km + "km");
		tfInput.requestFocus();
		tfInput.selectAll();
	}

	public static void main(String[] args) {
		new Answer2();
	}
}

```

