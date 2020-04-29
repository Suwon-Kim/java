class BankAccount {
	private String owner;
	private int balance;

	public void deposit(int amount) {
		balance += amount;
	}
	public boolean withdraw(int amount) {
		if(amount <= balance) {
			balance -= amount;
			return true;
		} else {
			System.out.println("잔고가 부족합니다.");
			return false;
		}
	}
	public int getBalance() {
		return balance;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String newOwner) {
		owner = newOwner;
	}
	/*
		transaction : 부분성공이 존재하지 않는 연속적인 일의 집합
		do : A -> B -> C -> D
		rollback : 부분실패로 인해 기능 수행 전 상태로 복귀하는 현상
		commit : 전체 업무가 성공해서 실제로 반영

		송금 : 출금(보내는쪽) -> 입금(받는쪽)

	*/
	public void transfer(int amount, BankAccount otherAccount) {
		System.out.println(
			owner + "님 계좌에서 " + otherAccount.getOwner() + 
			"님 계좌로 " + amount + "원 송금합니다."
		);
		// 입금자
		if( withdraw(amount) ) {
			// 받는자
			otherAccount.deposit(amount);
			System.out.println("송금 완료");
		}
	}
	public String toString() {
		return owner + "님의 잔고 : " + balance + "원";
	}
}


class Page195_6 {
	public static void main(String[] args) {
		BankAccount myAccount = new BankAccount();
		myAccount.deposit(10000);
		myAccount.setOwner("아이유");

		BankAccount yourAccount = new BankAccount();
		yourAccount.deposit(3000);
		yourAccount.setOwner("에일리");

		// 아이유가 에일리에게 2000원 송금
		myAccount.transfer(2000, yourAccount);

		System.out.println(myAccount);
		System.out.println(yourAccount);
	}
}
