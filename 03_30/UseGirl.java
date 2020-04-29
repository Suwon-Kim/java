class Girl {
	public int x, y = 5;

	public int x;
	public int y = 5;


	private String tel = "010-1234-1004";
	private boolean feelSoGood = false;
	public String getTel() {
		if(feelSoGood) {
			return tel;
		} else {
			return "112";
		}
	}
}
class UseGirl {
	public static void main(String[] args) {
		Girl g = new Girl();
		System.out.println(g.getTel());
	}
}
