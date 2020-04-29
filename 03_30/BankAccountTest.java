class BankAccount {
	int balance;
	// 입금
	void deposit(int amount) {
		balance += amount;
	}
	// 출금
	void withdraw(int amount) {
		if(amount <= balance) {
			balance -= amount;
		}
	}
	int getBalance() {
		return balance;
	}
	void addInterest() {
		balance += (int)(balance * 0.075);
	}
}
public class BankAccountTest {
	public static void main(String[] args) {
		BankAccount b = new BankAccount();
		b.deposit(100);
		b.withdraw(60);
		b.addInterest();
		System.out.println(b.getBalance());
	}
}
