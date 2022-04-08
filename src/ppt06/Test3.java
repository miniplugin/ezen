package ppt06;
class Shape5 {
       public Shape5() {
             System.out.println("Shape 생성자()");

       }
};
class Rectangle5 extends Shape5 {
       public Rectangle5() {
             
		System.out.println("Rectangle 생성자()");
       }
}; 

public class Test3 {
	public static void main(String[] args) {
		Rectangle5 r = new Rectangle5();
	}
};