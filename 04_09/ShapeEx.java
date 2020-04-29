/*
	삼각형, 사각형, 원 정의
	면적을 구한다. -> getArea() : int
	toString() 추가
*/
abstract class Shape {
	public abstract int getArea();
	@Override
	public String toString() {
		return "area : " + this.getArea();
	}
}
class Circle extends Shape {
	private int radius;

	public Circle(int radius) {
		setRadius(radius);
	}

	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public int getArea() {
		return (int)(radius * radius * 3.14);
	}

	@Override
	public String toString() {
		String info = "<< Circle >>\n";
		info += "radius : " + radius + "\n";
		info += super.toString();
		return info;
	}
}
abstract class BaseShape extends Shape {
	private int width;
	private int height;

	public BaseShape(int width, int height) {
		setWidth(width);
		setHeight(height);
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		String info = "width : " + width + "\n";
		info += "height : " + height + "\n";
		info += super.toString();
		return info;
	}
}
class Triangle extends BaseShape {
	public Triangle(int width, int height) {
		super(width, height);
	}
	@Override
	public int getArea() {
		return getWidth() * getHeight() / 2;
	}
	@Override
	public String toString() {
		String info = "<< Triangle >>\n";
		info += super.toString();		
		return info;
	}
}
class Rectangle extends BaseShape {
	public Rectangle(int width, int height) {
		super(width, height);
	}
	@Override
	public int getArea() {
		return getWidth() * getHeight();
	}
	@Override
	public String toString() {
		String info = "<< Rectangle >>\n";
		info += super.toString();		
		return info;
	}
}
class ShapeEx {
	public static void main(String[] args) {
		Circle c = new Circle(10);
		System.out.println(c);
		System.out.println(new Triangle(10, 5));
		System.out.println(new Rectangle(10, 5));
	}
}
