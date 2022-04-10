package ppt.ppt06;
class Shape6 {
	protected int x, y;
}
interface Drawable3{  
  void draw();  
} 
class Circle5 extends Shape6 implements Drawable3 {
	int radius;
	public void draw() {
		System.out.println("Circle Draw");
	}
}
public class TestInterface2 {  
	public static void main(String args[]){  
		Drawable3 obj = new Circle5();
		obj.draw();  
	}
}