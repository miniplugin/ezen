package ppt.ppt06;
public class ShapeTest1 {
	public static void main(String arg[]) {
		RectangleTest s = new RectangleTest();
		if( s instanceof RectangleTest ) {
			System.out.println("실제 객체는 Rectangle이군요!");
		}
//		if( s instanceof Circle ) {
//			System.out.println("실제 객체는 Circle이군요!");
//		}
	}
}