import javax.swing.JOptionPane;
//쓰레드를 분리 해놓으면 다른일을 하면서 다른일을 할 수 있다.
public class UsingThread {
	public static void main(String[] args) {
		ThreadEx th1 = new ThreadEx();
		th1.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요 ");
		
		System.out.println("입력하신 값은 " + input + "입니다.");
		//자바 프로그램은 프로그램이 끝나는 조건은 
		//콜스택이 비워지면 끝나게 되는데 콜스택은 여러개가 있음 
		//쓰레드 마다  콜스택이 각각 존재한다
		//모든 콜 스택이 다 비워졌을 때 프로그램이 종료된다 . 
		//main쓰레드는  끝났더라도  th1 쓰레드는 아직 종료되지 않았기 때문에 
		//th1 쓰레드가 끝나야 콜스택이 전부 비워짐 -- > real 종료
		//스윙상에는 쓰레드가 하나 더 존재한다.
		//응답성이 나아진다. 어떤걸 기다리는동안 사용자는 또 다른 무언가를 할 수 있다.
		
	}
}
