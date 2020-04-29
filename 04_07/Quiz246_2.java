class Box {
	private int length;
	private int width;
	private int height;

	public int getVolume() {
		return length * width * height;
	}

	public int getLength() {
		return length;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
class ColorBox extends Box {
	private String color;

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public String toString() {
		String info = "width : " + getWidth() + "\n";
		info += "height : " + getHeight() + "\n";
		info += "length : " + getLength() + "\n";
		info += "volume : " + getVolume() + "\n";
		info += "color : " + color;
		return info;
	}
}
class Quiz246_2 {
	public static void main(String[] args) {
		ColorBox box = new ColorBox();
		box.setWidth(10);
		box.setHeight(5);
		box.setLength(8);
		box.setColor("red");
		System.out.println(box);
	}
}
