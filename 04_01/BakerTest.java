/*
	제빵사(Baker)는 주문을 받아 피자(Pizza)를 만든다.

	Baker
	======================
	======================
	+ order() : Pizza

	
	Pizza
	======================
	- topping : String
	======================
	+ toString() : String

*/
import java.util.Scanner;
class Pizza {
	private String topping;
	public String getTopping() {
		return topping;
	}
	public void setTopping(String newTopping) {
		topping = newTopping;
	}
	public String toString() {
		return "이거슨 " + topping + " 피자입니다.";
	}
}
// Baker use-a Pizza
class Baker {
	public Pizza order(String topping) {
		Pizza food = new Pizza();
		food.setTopping(topping);
		return food;
	}
	public Pizza order() {
		Scanner scan = new Scanner(System.in);
		String menu = "1. 불고기피자\n";
		menu += "2. 페퍼로니피자\n";
		menu += "3. 포테이토피자\n";
		menu += "- 피자를 선택하시오";
		menu += "(1~3, 그외 입력은 불고기로 처리합니다.) : ";		
		System.out.print(menu);

		int choice = scan.nextInt();
		String topping;
		switch(choice) {			
			default:
			case 1:
				topping = "불고기";
				break;
			case 2:
				topping = "페퍼로니";
				break;
			case 3:
				topping = "포테이토";
		}	
		Pizza myPizza = order(topping);
		return myPizza;
		// return order(topping);
	}
}
class BakerTest {
	public static void main(String[] args) {
		Baker b = new Baker();
		
		Pizza p = b.order();
		System.out.println(p);

		System.out.println(b.order("고구마"));
	}
}
