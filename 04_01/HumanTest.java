/*
	철수는 영희를 좋아한다.(이쁘니까 좋아한다)
	영희는 철수를 좋아하지 않는다.(못생겨서 좋아하지 않는다)

	faceLv : int
	faceLv >= 5 : 이쁘다, 잘생겼다
	faceLv < 5 : 못생겼다 

	Human
	====================
	- name : String
	- faceLv : int
	====================
	+ getName() : String
	+ getFaceLv() : int
	+ setName(newName:String) : void
	+ setFaceLv(newFaceLv:int) : void
	+ like(someone:Human) : boolean

*/
class Human {
	private String name;
	private int faceLv;

	public String getName() {
		return name;
	}
	public int getFaceLv() {
		return faceLv;
	}
	public void setName(String newName) {
		name = newName;
	}
	public void setFaceLv(int newFaceLv) {
		faceLv = newFaceLv;
	}
	// h2.like(h1)
	public boolean like(Human someone) {
		boolean like = true;
		if(someone.getFaceLv() < 5) {
			like = false;
		}		
		System.out.println(
			name + (like ? " like " : " hate ") + someone.getName() 	
		);
		return like;
	}
	// h2.doULikeMe(h1)
	public boolean doULikeMe(Human h) {
		return h.like(this);
	}
	public void tuning() {
		int random = (int)(Math.random() * 9) + -2;
		faceLv += random;
		System.out.println("외모변화 수치 : " + random);
	}
}
class HumanTest {
	public static void main(String[] args) {
		Human h1 = new Human();
		h1.setName("철수");
		h1.setFaceLv(3);

		Human h2 = new Human();
		h2.setName("영희");
		h2.setFaceLv(8);

		//System.out.println(h1.like(h2));
		//System.out.println(h2.like(h1));

		h1.tuning();
		System.out.println(h2.like(h1));
		System.out.println(h2.doULikeMe(h1));
	}
}
