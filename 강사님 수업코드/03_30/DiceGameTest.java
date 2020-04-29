import java.util.*;
class DiceGame{
	private int diceFace;
	private int userGuess;

	private int getUserInput(){
		System.out.println("예상값을 입력하시오:");
		Scanner s = new Scanner(System.in);
		return s.nextInt();
	}
	private int rollDice() {
		return (int)(Math.random()*6)+1;
	}
	private boolean checkUserGuess() {
		if (diceFace == userGuess) { 
			System.out.println("맞았습니다");
			return false;
		}else{
			System.out.println("틀렸습니다");
			return true;
		}
	}
	public void startPlaying(){
		// 난수 발생
		diceFace = rollDice();
		do {
			// 사용자 입력 처리
			userGuess = getUserInput() ;
		} while(checkUserGuess());
	}
}

class DiceGameTest{
	public static void main(String[] args) {
		 DiceGame game = new DiceGame();
		 game.startPlaying();

	}
}
