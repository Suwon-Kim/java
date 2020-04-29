import java.util.Scanner;
class Answer109_3 {
	// refactoring...!!!!
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("컵의 사이즈 : ");
		int cupSize = scan.nextInt();		
		String result = "medium";
		if(cupSize < 100) {
			result = "small";
		} else if(cupSize >= 200) {
			result = "large";
		} 
		System.out.println(result);

	}
}
