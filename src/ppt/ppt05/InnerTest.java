package ppt.ppt05;
class Outer {
	private int num;


	class Inner {
		public void print() {
			System.out.println("여기는 내부 클래스입니다.");
			System.out.println("num="+num);
		}
	}

	void display() {
		Inner obj = new Inner();
		obj.print();
	}
}

public class InnerTest {

	public static void main(String args[]) {
		Outer obj = new Outer();
		obj.display();
	}
}