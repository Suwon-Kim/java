
import java.util.Random; //���� ����Ʈ
import java.util.Scanner; //�Է� ����Ʈ

class Game {

	static int strike = 0; // ��Ʈ����ũ - ����
	static int ball = 0; // �� - ����

	public static void main(String[] args) {

		int[] com = new int[3];
		int[] user = new int[3];

		Random r = new Random();

		// �ߺ������� ���� ��ǻ�� ��ȣ ����
		// nextInt(10) --> 0 ~ 9 ������ ���� ����

		// ��ǻ���� 1�� ���ڰ� 0�̸� �������� ����
		while (com[0] == 0) {
			com[0] = r.nextInt(10);
		}
		// ��ǻ���� 1�� ���ڿ� 2�� ���ڰ� ���ų�
		// 2�� ���ڰ� 0�̶�� ������ ����
		while (com[0] == com[1] || com[1] == 0) {
			com[1] = r.nextInt(10);
		}
		// ��ǻ���� 2�� ���ڿ� 3�� ���ڰ� ���ų�
		// 3�� ���ڰ� 0�̶�� ������ ����
		while (com[1] == com[2] || com[2] == 0) {
			com[2] = r.nextInt(10);
		}

		// ������ ������ �Է��ϴ� ���� s

		Scanner s = new Scanner(System.in);

		int playcount = 1;

		// ��Ʈ����ũ�� 3�� ���;� ����
		while (strike < 3) {
			
			// 3�� �ݺ��Ͽ� ������ �Է� �޴´�.
			for (int i = 0; i < user.length; i++) {
				System.out.print((i + 1) + "��° ��: ");
				user[i] = s.nextInt();
				
				// �Է¹޴� ���ڰ� 10 �̻��̰ų� 0�̸� �ٽ� �Է��� �޴´�.
				while (user[i] >= 10 || user[i] <= 0) {
					System.out.println("1~9 ������ ���ڸ� �Է��ϼ���.");
					System.out.print((i + 1) + "��° ��: ");
					user[i] = s.nextInt();
				}
			}

			// �Է¹��� �� ���ϱ�
			// Ball or Strike

			if (com[0] == user[0]) {
				strike++;
			} else if (com[0] == user[1]) {
				ball++;
			} else if (com[0] == user[2]) {
				ball++;
			}

			if (com[1] == user[1]) {
				strike++;
			} else if (com[1] == user[0]) {
				ball++;
			} else if (com[1] == user[2]) {
				ball++;
			}

			if (com[2] == user[2]) {
				strike++;
			} else if (com[2] == user[1]) {
				ball++;
			} else if (com[2] == user[0]) {
				ball++;
			}

			if (strike == 0 && ball == 0) {
				System.out.println("\n�ƿ�!\n");
			} else if (strike == 3) {
				System.out.println("\n��Ʈ����ũ!\n" + "�õ� Ƚ����: \n" + playcount);
				System.exit(0);
			} else {
				System.out.println("\n" + strike + "��Ʈ����ũ" + "\t" + ball + "��\n");
				strike = 0;
				ball = 0;
			}
			playcount++;
		}
	}
}
