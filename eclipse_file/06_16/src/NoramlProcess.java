import javax.swing.JOptionPane;

public class NoramlProcess {
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("아무값이나 입력하세요.");
		
		System.out.println("입력하신 값은 " + input + "입니다.");
		//강사님 API 참고 
		//읽을게 생길때까지 멈춰있다. 입력이 들어 올 때 까지 기다리는 작업을 블락킹이라 하고 -> Blocked
		//특정한 시간동안 실행을 할 수 없는 상태 (sleep) -- > TIMED_WAITING
		//일어나라 할때 까지 무한정 대기 실행을 안하는 상태 ( ) -- > WAITING 
		//블라킹  되어 있다가 사용자가 입력하면 또 하나의 일이 진행된다.
		//하나의 일
		
		//Runnable -- > 대기열 (쓰레들이 대기하는장소 ) 가상 머신이 선택하는데 
		// 선택하는 놈은 Run으로 간다. 자원이 끝나면 다시 runnable로 간다. 
		// 운이 좋으면 일을 하고 왔는데 또 다시 뽑혀서 일을 할 수 있다 예측을 할 수 가 없다 
		// 그래서 쓰레드가 어렵다 . 
		//Run 실제로 수행되는 파트 
		//Not Runnable 실행할 수 없는 파트 (입력 기다림, sleep)등 
		//Not Runnable에서 해방이 되면 (ex) -- > 사용자가 입력을 하게 되면 
		// Run으로 가는게 아니고 Runnable로 간다 . 
		//쓰레드가 끝이나면 Dead로 간다. 한번 끝나면 더 이상 쓸 수 없다 다시 쓰레드를 만들어야 함
		//저 그림을 그리고 있어야 한다. 
		//강사님이 보여준 그림이 공부하기 편하다. 
		//Runnable에서 대기하고 있다가 경쟁에서 이긴놈이 Run으로 한명이 가게됨
		
// -------------------------------------------------------------------------//
		//하나의 일 
		
		for(int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) { }
		}
	}
}
