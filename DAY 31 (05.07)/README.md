```java
/*
	JFrame
*/
import javax.swing.*;
class MyFrame1 extends JFrame  {
	public MyFrame1() {
		setTitle("MyFrame1");
		setSize(400, 300);
		setLocation(200, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame1();	
	}
}

```

```java
/*
	JFrame
*/
import java.util.*;
import javax.swing.*;
class MyFrame1 extends JFrame  {
	public MyFrame1() {
		setTitle("MyFrame1");
		setSize(400, 300);
		setLocation(0, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		Random r = new Random();
		for(int x = 0; x <= 500; x++) {
			// 0부터 499까지 랜덤으로 뽑는다.
			setLocation(r.nextInt(500), r.nextInt(500));
			try {
				Thread.sleep(r.nextInt(1000));
			} catch (Exception e) {
			
			}
		}
	}
	public static void main(String[] args) {
		new MyFrame1();	
	}
}

```

```java
/*
	배치(layout) : 크기 + 위치

	1. Component : UI구성요소 
		-> base container에 부착되야 가시성을 가질 수 있다.
	2. Container : Component를 포함 할 수 있는 Component
		- base container : JFrame, JDialog ...
		- container : JPanel, JScrollPane...
		- 자체모양을 구성하기 위해 상속받은 Container
	3. layout manager : 배치관리자 
		--> Container를 포함한 Component의 크기와 위치를 조정하는 관리자  
		- BorderLayout
		- FlowLayout
		- GridLayout
		- ... 
*/
import javax.swing.*;
class MyFrame2 extends JFrame {

	public MyFrame2() {

		JButton btn = new JButton("Click");
		// 부착
		add(btn);
		add(new JButton("other"));

		setTitle("MyFrame2");
		setLocation(100, 0);
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args)	{
		new MyFrame2();
	}
}

```

```java
/*
	java.awt
	- BorderLayout
		1. 5개의 영역으로 분활해서 배치(North, Center, East, West, South)
		2. 각 영역에는 1개의 Component만 표시된다.
		3. 영역별로 사이즈 변화에 따라 영향을 다르게 받는다.
			a. 횡 (가로) : North, Center, South
			b. 종 (세로) : East, Center, West
	- FlowLayout
		1. 영역으로 분할하지 않는다.
		2. Component는 구성물을 표현 할 수 있는 최적의 크기(PreferredSize)
		로 결정이 난다.
		3. 왼쪽 - > 오른쪽, 위 -> 아래
		4. 정렬방식 결정 (LEFT, RIGHT, CENTER)
		5. Container의 크기변화에 구성요소는 영향을 받지 않는다.
	- GridLayout
		1. 줄, 칸으로 영역을 분활한다.
		2. 각영역의 크기는 모두 동일
		3. 영역별로 1개 Component만 부착가능하다.
		4. 부착된 요소는 해당영역을 가득 채우는 크기로 변경된다.
		5. Container의 크기 변화에 모든 요소가 영향을 받는다.
		
	JFrame의 기본 layout-maner : BorderLayout
*/
import java.awt.*;
import javax.swing.*;
class LayoutEx1 extends JFrame {
	public static final int BORDER = 0;
	public static final int FLOW = 1;
	public static final int GRID = 2;
	public static final int NONE = 3;
	public LayoutEx1(int layout) {
		String title = "BorderLayoutEx";
		switch(layout) {
			case FLOW :
				flowLayout();
				title = "FloyLayoutEx";
				break;
			case GRID :
				gridLayout();
				title = "GridLayoutEx";
				break;
			case NONE :
				noLayout();
				title = "no layout";
			default : 
				borderLayout();
		}

		setTitle(title);
		// Component 
		setSize(400, 400);
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void noLayout() {
		// 레이아웃 매니저 제거
		setLayout(null);

		JButton btn1 = new JButton("first");
		btn1.setSize(100, 100);
		btn1.setLocation(0, 0);

		JButton btn2 = new JButton("second");
		btn2.setSize(200,200);
		btn2.setLocation(100, 100);

		add(btn1);
		add(btn2);
	}
	private void borderLayout() {
		JButton btnNorth = new JButton("North");
		// 부착되는 순간 layout - manager에 의해 크기와 위치정보가 변한다.
		// setSize, setLocation -- > 의미가 없다.
		//btnNorth.setSize(100,100);
		//btnNorth.setLocation(200,200);
		JButton btnCenter = new JButton("Center");
		JButton btnWest = new JButton("West");
		JButton btnEast = new JButton("East");
		JButton btnSouth = new JButton("South");

		add(btnNorth, BorderLayout.NORTH);
		add(btnCenter, BorderLayout.CENTER);
		add(btnWest, BorderLayout.WEST);
		add(btnEast, BorderLayout.EAST);
		add(btnSouth, BorderLayout.SOUTH);
	}
	private void flowLayout() {
		//기본레이아웃매니저 : BorderLayout
		//레이아웃 매니저 변경
		FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
		//BorderLayout - > FlowLayout
		setLayout(flowLayout);

		for(int i = 0; i < 20; i++) {
			//숫자가 안들어가짐 valueOf로 변환
			JButton btn = new JButton(String.valueOf(i + 1));
			add(btn);
		}
	}
	private void gridLayout() {
		// 격자 (줄, 칸)
		// 격자 (줄, 칸, 가로간격, 세로간격)
		setLayout(new GridLayout(4, 5, 10, 5));

		for(int i = 0; i < 20; i++) {
			add(new JButton(String.valueOf(i + 1)));
		}
	}
	public static void main(String[] args) {
		new LayoutEx1(NONE);
	}
}

```

```java
/*
	JPanel - Container - FlowLayout
	JPanel -- > 여러 개의 레이아웃을 사용하기 위해서
*/


import java.awt.*;
import javax.swing.*;

class LayoutEx2 extends JFrame  {
	
	public LayoutEx2() {
		setLayout(new GridLayout(1, 2));

		JPanel pnlLeft = new JPanel();
		for(int i = 0; i < 20; i++) {
			pnlLeft.add(new JButton(String.valueOf(i + 1)));
		}

		JPanel pnlRight = new JPanel(new BorderLayout());
		// == pnlRight.setLayout(new BorderLayout());
		pnlRight.add(new JButton("North"), BorderLayout.NORTH);
		pnlRight.add(new JButton("Center"), BorderLayout.CENTER);
		pnlRight.add(new JButton("South"), BorderLayout.SOUTH);

		add(pnlLeft);
		add(pnlRight);

		setTitle("JPanel Ex");
		setLocation(100,0);
		setSize(600, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
		
	public static void main(String[] args) {
		new LayoutEx2();	
	}
}

```

```java
import java.awt.*;
import javax.swing.*;

class Counter extends JFrame {
	private JLabel lblNum;
	private JButton btnPlus;

	public Counter() {
		init();
		setDisplay();
		showFrame();
	}
	// Component 초기화
	private void init() {
		// 글자나 그림을 나타내기 위해 사용 (레이블)
		//lblNum = new JLabel("0",JLabel.CENTER); 
		//lblNum.setText("0");
		lblNum = new JLabel();
		lblNum.setText("한");
		// 횡정렬
		lblNum.setHorizontalAlignment(JLabel.CENTER);

		// 폰트 : 글꼴(name) , 스타일, 크기
		Font font = new Font(
			Font.SERIF, Font.BOLD, 40
			//"함초롱바탕"
		);
		lblNum.setFont(font);

		//생성됨
		btnPlus = new JButton();
		btnPlus.setText("Plus");
		btnPlus.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
		
	}
	// 배치
	private void setDisplay() {
		add(lblNum, BorderLayout.CENTER);
		add(btnPlus, BorderLayout.SOUTH);
	}
	// 프레임 설정
	private void showFrame() {
		setTitle("Counter");
		setSize(300, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Counter();
	}
}
```

```java
import java.awt.*;
import javax.swing.*;
class Counter extends JFrame {
	private JLabel lblNum;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnDefault;

	public Counter() {
		init();
		setDisplay();
		showFrame();
	}
	// Component 초기화
	private void init() {
		// 글자, 그림을 나타내기 위해 사용
		// lblNum = new JLabel("0", JLabel.CENTER);
		lblNum = new JLabel();
		lblNum.setText("0");
		// 횡정렬
		lblNum.setHorizontalAlignment(JLabel.CENTER);
		
		// 폰트 : 글꼴, 스타일, 크기
		Font font = new Font(
			Font.SERIF, Font.BOLD, 80	
		);
		lblNum.setFont(font);
		// 불투명 설정
		lblNum.setOpaque(true); //오펙
		//RGB
		Color color = new Color(0xFFD8D8);
		//color = new Color(0, 0, 0);
		//color = new Color(255, 255, 255);
		// 배경색
		lblNum.setBackground(color);
		// 전경색 (글자색)
		lblNum.setForeground(color.RED);

		btnPlus = new JButton();
		btnPlus.setText("Plus");
		btnMinus = new JButton("Minus");
		btnDefault = new JButton("Default");
	}
	// 배치
	private	void setDisplay() {
		JPanel pnlSouth = new JPanel(new GridLayout(1, 2));
		pnlSouth.add(btnPlus);
		pnlSouth.add(btnMinus);
		
		add(btnDefault, BorderLayout.NORTH);
		add(lblNum, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
	}	
	// 프레임 설정
	private void showFrame() {
		setTitle("Counter");
		setSize(300, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args)	{
		new Counter();
	}
}

```

```java
import java.awt.*;
import javax.swing.*;
class LabelEx extends JFrame  {
	public LabelEx() {
		ImageIcon icon = new ImageIcon("iu.jpg");
		JLabel lbl = new JLabel(icon);

		add(lbl);

		setTitle("아이유 짱");
		//setSize(300, 300);
		pack(); // 알맞은 사이즈로 포장해줌
		setLocation(100, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new LabelEx();
	}
}

```

