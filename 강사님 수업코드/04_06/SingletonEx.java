class Some {
	// 1. 생성자를 private 하게 만든다.
	private Some() {
	}
	// 2. 자신타입(Some) static 객체를 생성한다.
	private static final Some instance = new Some();

	// 3. instance에 대한 getter를 만든다.
	public static Some getInstance() {
		return instance;
	}
}
class SingletonEx {
	public static void main(String[] args) {
		Some obj = Some.getInstance();
	}
}
