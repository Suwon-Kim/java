/*
	powerjava 172p 1번
	사각형을 나타내는 클래스 Rectangle을 만들어보자. 
	사각형은 가로(w)와 세로(h)를 가지며, 사각형의 넓이를 반환하는 area(), 
	사각형의 둘레를 반환하는 perimeter()등의 메소드를 가진다. 
	rectangle 클래스를 작성하고 객체를 생성하여 테스트하라. 
*/

class RecTangle{
	int w;
	int h;

	int area(){
		return w * h;
	}

}

class UseRecTangle {
	public static void main(String[] args) {
		RecTangle rt = new RecTangle();
		rt.w = 5;
		rt.h = 3;
		rt.area();
	}
}
