package ppt.ppt06;
class Shape3 {
	protected int x, y;
	public void draw() {
		System.out.println("Shape Draw");
	}
}

class Rectangle extends Shape3 {
	private int width, height;
	public void draw() {
		System.out.println("Rectangle Draw");
	}
}

class Triangle extends Shape3 {
	private int base, height;
	public void draw() {
		System.out.println("Triangle Draw");
	}
}

class Circle3 extends Shape {
	private int radius;
	public void draw() {
		System.out.println("Circle Draw");
	}
}
public class ShapeTest {
	public static void main(String arg[]) {
		Shape s1;
		Rectangle s2;

		s1 = new Shape();		//  ① 당연하다.  
		s2 = new Rectangle();	//  ② Shape 참조 변수로 Rectangle 객체를  가리킬 수 있을까?
	}
}