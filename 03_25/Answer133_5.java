import java.util.Scanner;
class Answer133_5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("x : ");
		double x = scan.nextDouble();
		double result;
		if(x <= 0) {
			result = (x * x * x) - (9 * x) + 2;
		} else {
			result = (7 * x) + 2;
		}
		System.out.println(result);
	}
}
