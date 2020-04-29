class Stock {
	String no;		// 제품번호
	int amount;		// 제품수량
	/*
		재고수량 증가
		count : 증가시킬 수량
	*/
	void increase(int count) {
		if(count > 0) {
			amount += count;
			printAmount();
		} else {
			System.out.println("증가수량은 0 또는 음수일 수 없습니다.");
		}
	}
	/*
		재고수량 감소
		count : 감소시킬 수량
	*/
	void decrease(int count) {
		if(count<=amount) {
			// amount = amount - count;
			amount -= count;
			printAmount();
		} else {
			System.out.println("재고수량이 부족합니다.");
		}		
	}
	// 현재수량을 출력
	void printAmount() {
		System.out.println(no + "번 재고수량 : " + amount);
	}
}
class Page157_6 {
	public static void main(String[] args) {
		Stock s = new Stock();
		// 제품번호 설정		
		s.no = "p00001";
		// 재고수량 설정
		s.amount = 100;

		s.increase(-30);
		
		s.decrease(150);
	}
}
