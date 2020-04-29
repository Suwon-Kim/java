/*	
	long제외 정수, char, String(1.7~)
	
	int choice = 1;
	switch( choice ) {
		case 1:
			System.out.println("A");
			break;
		case 2:
			System.out.println("B");
		case 3:
			System.out.println("C");
	}

*/
class SwitchEx {
	public static void main(String[] args) {
		int choice = 4;
		switch( choice ) {
			default :
				System.out.println("others");
				break;
			case 1:
				System.out.println("A");
				break;
			case 2:
				System.out.println("B");
				break;
			case 3:
				System.out.println("C");
			
		}
	}
}
