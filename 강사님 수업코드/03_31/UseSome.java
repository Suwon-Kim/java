class Some {
	public String toString() {
		return "this is a Some";
	}
}
class UseSome {
	public static void main(String[] args) {
		Some s = new Some();
		System.out.println(s);
		System.out.println(new Some());
	}
}
