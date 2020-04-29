class Some {
	private static int num = 2;
	public static int count = 10;

	public static int getNum() {
		return num;
	}
}
class UseSome {
	public static void main(String[] args) {		
		Some s1 = new Some();
		s1.count += 2;
		Some s2 = new Some();
		s2.count += 4;

		System.out.println(s1.count);
		System.out.println(s2.count);
	}
}
