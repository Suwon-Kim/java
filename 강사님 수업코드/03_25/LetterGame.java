import java.util.*;

public class LetterGame {
	public static void main(String[] args) {
		int answer = 59;
		int guess;
		int tries = 0;
		Scanner scan = new Scanner(System.in);
		// 반복구조
		do {
			System.out.print("정답을추측하여보시오:");
			guess = scan.nextInt();
			tries++;

			if (guess > answer) {
				System.out.println("제시한정수가높습니다.");
			}
			if (guess < answer) {
				System.out.println("제시한정수가낮습니다.");
			}
		} while (guess != answer);

		System.out.printf("축하합니다.시도횟수=%d\n", tries);
	}
}
