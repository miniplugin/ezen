package ppt07;
class Circle2 {
	int radius; 
	public Circle2(int radius) {
		this.radius = radius;
	}
	public boolean equals(Circle2 c1) {
		if( radius == c1.radius ) return true;
		else return false;
	}
	
}
public class CircleTest1 {
	public static void main(String[] args) {
		Circle2 obj1 = new Circle2(10);
		Circle2 obj2 = new Circle2(10);
		if( obj1.equals(obj2) ) System.out.println("2개의 원은 같습니다.");
		else System.out.println("2개의 원은 같지 않습니다.");
	}
}