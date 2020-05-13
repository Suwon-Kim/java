package kr.ac.green;

public class Human {
	
	private ISpeakable sp;
	
	
	public Human(ISpeakable sp) {
		this.sp = sp;
	}
	
	public void performSpeak() {
		sp.speak();
	}
	
	public static void main(String[] args) {
		
		Human h = new Human(new ISpeakable() {
			@Override
			public void speak() {
				System.out.println("hello");
			}
		});
		h.performSpeak();
		
		Human h2 = new Human(() -> System.out.println("bye~"));
		h2.performSpeak();
	}
}






