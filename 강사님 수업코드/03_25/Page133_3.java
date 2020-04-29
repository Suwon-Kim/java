import java.util.Scanner;
class Page133_3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("키 : ");
		int height = scan.nextInt();
		System.out.print("몸무게 : ");
		int weight = scan.nextInt();

		int standardWeight = (int)((height - 100) * 0.9);
		
		int gap = 5;
		
		String result = "표준체중";
		if(weight < (standardWeight - gap)) {
			result = "저체중";
		} else if(weight > (standardWeight + gap)) {
			result = "과체중";
		} 
		System.out.println(result);
	}
}
