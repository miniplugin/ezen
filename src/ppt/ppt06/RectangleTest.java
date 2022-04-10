package ppt.ppt06;
class Shape2 {
	protected int x, y;
	void print() {
		System.out.println("x좌표: " + x + " y좌표: " + y);
	}
}

public class RectangleTest extends Shape2 {
	int width, height;
	double calcArea() {
		return width * height;
	}
	void draw() {
		System.out.println("(" + x + "," + y + ") 위치에 " + "가로: " + width
				+ " 세로: " + height);
	}
}