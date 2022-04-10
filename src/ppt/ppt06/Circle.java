package ppt.ppt06;
interface Printable {
	void print();

}

interface Drawable {
	void draw();
}

public class Circle implements Printable, Drawable {
	public void print() {
		System.out.println("프린터로 원을 출력합니다.");
	}

	public void draw() {
		System.out.println("화면에 원을 그립니다.");
	}

	public static void main(String args[]) {
		Circle obj = new Circle();
		obj.print();
		obj.draw();
	}
}