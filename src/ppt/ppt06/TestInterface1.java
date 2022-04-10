package ppt.ppt06;
interface Drawable2{  
  void draw();  
} 
class Circle4 implements Drawable2 {
	int radius;
	public void draw() {
		System.out.println("Circle Draw");
	}
}
public class TestInterface1 {  
	public static void main(String args[]){  
		Drawable2 obj = new Circle4();
		obj.draw();  
	}
}  