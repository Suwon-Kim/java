import java.util.Scanner;
class Page133_3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Ű : ");
		int height = scan.nextInt();
		System.out.print("������ : ");
		int weight = scan.nextInt();

		int standardWeight = (int)((height - 100) * 0.9);
		
		int gap = 5;
		
		String result = "ǥ��ü��";
		if(weight < (standardWeight - gap)) {
			result = "��ü��";
		} else if(weight > (standardWeight + gap)) {
			result = "��ü��";
		} 
		System.out.println(result);
	}
}
