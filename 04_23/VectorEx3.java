import java.util.*;
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
	@Override
	public String toString() {
		return "Ball(" + num + ")";
	}
	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Ball)) {
			return false;
		}
		Ball b = (Ball)o;
		return num == b.getNum();
	}
}
class VectorEx3 {
	public static void main(String[] args)	{
		Vector<Ball> vec = new Vector<Ball>();
		
		vec.add(new Ball(1));
		vec.add(new Ball(5));
		vec.add(new Ball(4));
		vec.add(new Ball(7));
		vec.add(new Ball(3));
		vec.add(new Ball(2));
		
		// remove
		vec.remove(new Ball(4));

		System.out.println(vec);
	}
}
