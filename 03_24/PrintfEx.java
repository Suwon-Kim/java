import java.util.*;
class PrintfEx {
	public static void main(String[] args) {
		// "010-2361-4414"
		Scanner scan = new Scanner(System.in);

		System.out.print("전화번호 앞자리입력 : ");
		int head = scan.nextInt();
		System.out.print("전화번호 뒷자리입력 : ");
		int body = scan.nextInt();
		
		System.out.printf("010-%d-%d\n", head, body);
		//System.out.println("010-" + head + "-" + body);


	}
}
