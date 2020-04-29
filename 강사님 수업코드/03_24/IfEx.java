/*
	(cond) ? A : B;

	(남자)소개팅을 갔다;
	if( 예쁘냐? ) {
		// true
		맛있는거 사준다;
	} else {
		// false
		전화한다;
	}
	집에온다;

	cond
		true : A -> C
		false : B -> C

		(여자)소개팅 간다.
		if(인상이 좋냐?) {			
			VIPS간다;
		} else if(잘생겼냐?) {
			김밥천국간다;
		} else if(말이잘통하냐?) {
			이야기한다;
		} else if(인성이 좋으냐?) {
			카페간다;	
		} else {
			전화한다;
		}
*/
class IfEx {
	public static void main(String[] args) {
		int n = 3;

		System.out.println((n == 2) ? "A" : (n >= 3)? "B" : "C");
		(n == 2) ? "A" : "B";

		/*
		int num = 4;
		if(num < 4) {
			if(num < 2) {
				System.out.println("B");
			} else {
				System.out.println("C");		
			}
		}
		*/
		
	}
}
