- 오늘의 주제 (GUI)

  - 1.  JAVA - AWT, Swing, FX

    2.  Swing(~1.7), FX(1,8 ~)

    3.  java.awt.* -> 개선점들 보완 - > javax.swing.*

    4.  AWT (장점 : 쉽다.) (단점 : UI구성요소의 부족함, OS종속성)

    5.  Swing(장점 : UI구성요소의 다양함, OS에 독립적) (단점 : 어렵다.)

    6.  학습 목적 : 

       a. 객체지향의 개념 재정립

       b. API Document 사용법 향상

       c. MVC구조 맛보기

       d. Android와 비슷한 구현방법

       e. GUI프로그램의 특징 이해 - > Web 개념이 비슷하다

       f. 실제 프로글램 개발이 가능  

```java
/*
	UI 구성요소 : Component
	창 : JFrame, JDialog ... (Swing)
			Frame, Dialog ... (AWT)

	// http://www.iconarchive.com/ (이미지 무료)
*/
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Image;
import javax.swing.JFrame;

class JFrameEx1 {
	public static void main(String[] args) {
		JFrame f = new JFrame("이것도 창입니다.");
		

		//추상클래스라서 객체를 바로 만들 수 없다.
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("image.png");
		f.setIconImage(img);
		
		//f.setTitle("이것은 창입니다.");

		f.setSize(new Dimension(600,300));
		//f.setSize(400, 300);
		Dimension size = f.getSize();
		//얘도 width, height가 public이다.
		System.out.println(size.width + ", " + size.height);
		// 단위 : 픽셀(해상도에 따라 영향을 받는다)
		// (X,Y) -- > 맨 왼쪽위 (0,0)
		Point p = new Point(400, 200);
		f. setLocation(p);
	
		//f.setLocation(200, 300); 
		//Point location = f.getLocation(); // 2개 이상 리턴이 안되서 point를 사용
		//Point 안의 x,y가 public 함으로 바로 값을 가져왔음
		//System.out.println(location.x + ", " + location.y);

		// 종료 버튼 동작 정의
		/*	
			종료버튼 정의 flag
			1. EXIT_ON_CLOSE : JVM 종료 (전체프로그램 종료)
			2. DISPOSE_ON_CLOSE : 해당창만 종료 (자원해제)
			3. HIDE_ON_CLOSE : 해당창의 가시성을 제거 (default)
			4. DO_NOTHING_ON_CLOSE : 아무것도 하지않는다.

		*/
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 가시성 부여
		// 끝에 보여주는것이 Best
		f.setVisible(true);
	}
}

```

```java
/*
	아래조건을 만족하는 창을 만드시오.
	1. 창의 타이틀은 "자바좋아" 로 한다.
	2. 창의 크기는 400, 300으로 결정한다.
	3. 창의 위치는 200, 200으로 결정한다.
	4. 창 종료시 현재창만 종료한다.
	5. 창에 아이콘을 설정한다.	
*/
import java.awt.*;
import javax.swing.*;
class JFrameEx2 {
	public static void main(String[] args)	{
		JFrame f = new JFrame("자바좋아");
		f.setIconImage(
			Toolkit.getDefaultToolkit().getImage("icon.png")	
		);
		// x, y, width, height
		//Rectangle r = new Rectangle(200,200,400,300);
		//위치와 크기를 가지는 사각형
		Rectangle r = new Rectangle(
				new Point(200,200),
				new Dimension(400,300)
			);
		f.setBounds(r);
		//f.setSize(400, 300);
		//f.setLocation(200, 200);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(true);
	}
}

```

```java
import java.awt.*;
import javax.swing.*;

class JFrameEx3 {
	public static void main(String[] args) {
		Toolkit kit = Toolkit.getDefaultToolkit();

		Dimension screen = kit.getScreenSize();
		System.out.println(screen.width);
		System.out.println(screen.height);

	}
}

```

```java
import java.awt.*;
import javax.swing.*;
class MyUtils {
	// frame을 화면 정중앙에 위치시키는 메서드를 완성하라.
	public static void goCenter(JFrame frame)	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();

		Dimension frameSize = frame.getSize();

		int x = (screenSize.width - frameSize.width) / 2;
		int y = (screenSize.height - frameSize.height) / 2;

		frame.setLocation(x, y);
	}
}

/*
	(400, 300) 크기를 가지는 창을 화면 중앙에 위치시키시오.
*/
class Test {
	public static void main(String[] args)	{
		JFrame f = new JFrame("정중앙");
		f.setSize(400, 300);
		//크기 지정후 이동
		MyUtils.goCenter(f);
		// 전체화면 -> 크기를 설정하고 적용
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}

```

```java
import java.awt.*;
import javax.swing.*;

class JFrameEx4 {
	public static void main(String[] args) {
		JFrame f = new JFrame("메롱");
		f.setSize(300,300);
		// 중앙에 온다... 야매
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
```

