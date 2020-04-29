class PolyEx2 {
	public static void parentToChild(Parent p) {

		if(p instanceof Parent) {
			System.out.println("됌?");
		}
		// Parent -> Child
		// instanceof : 형변환 에러를 방지한다.
		if(p instanceof Child) {
			Child c = (Child)p;
		} else {
			System.out.println("즐~");
		}
	}
	public static void main(String[] args) {
		//parentToChild(new Child());
		parentToChild(new Parent());
	}
}
