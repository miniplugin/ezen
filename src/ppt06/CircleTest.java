package ppt06;
class Shape {
	int x, y;
}

class Circle2 extends Shape {
	int radius;

	public Circle2(int radius) {
		this.radius = radius;
		x = 0;
		y = 0;
	}

	double calcArea() {
		return 3.14 * radius * radius;
	}
}

public class CircleTest {
	public static void main(String args[]) {
		Circle2 obj = new Circle2(10);
		System.out.println("원의 중심: (" + obj.x + "," + obj.y + ")");
		System.out.println("원의 면적: " + obj.calcArea());
	}
}