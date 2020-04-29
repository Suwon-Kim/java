/*
	equals(o:Object) : boolean

	==
*/
class Ball {
	private int num;

	public Ball(int num) {
		setNum(num);
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	// 번호가 같으면 같은 공이라 본다.
	@Override
	// b1.equals(b2)
	public boolean equals(Object other) {
		// Ball 과 Ball의 비교
		if(other == null || !(other instanceof Ball)) {
			return false;		// 메서드 종료
		}			
		// other가 null이 아님, other는 Ball객체가 맞다.
		Ball ball = (Ball)other;
		return num == ball.getNum();
	}
}
class UseBall {
	public static void main(String[] args) {
		Ball b1 = new Ball(3);
		Ball b2 = new Ball(4);
		Ball b3 = new Ball(3);

		System.out.println(b1.equals(b2));
		System.out.println(b1.equals(b3));
		b1.equals(new UseBall());
		b1.equals(null);
	}
}
