import java.util.*;

public class LetterGame {
	public static void main(String[] args) {
		int answer = 59;
		int guess;
		int tries = 0;
		Scanner scan = new Scanner(System.in);
		// �ݺ�����
		do {
			System.out.print("�����������Ͽ����ÿ�:");
			guess = scan.nextInt();
			tries++;

			if (guess > answer) {
				System.out.println("�����������������ϴ�.");
			}
			if (guess < answer) {
				System.out.println("�����������������ϴ�.");
			}
		} while (guess != answer);

		System.out.printf("�����մϴ�.�õ�Ƚ��=%d\n", tries);
	}
}
