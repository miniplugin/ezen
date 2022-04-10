package ppt.ppt06;
class Shape4 {
	
       public Shape4() {	
             System.out.println("Shape 생성자() ");
       }
};
 
class Rectangle4 extends Shape4 {
       public Rectangle4(){		
		 super();		// 명시적인 호출
             System.out.println("Rectangle 생성자()");
       }
};

public class Test1 {
	public static void main(String[] args) {
		Rectangle4 r = new Rectangle4();
	}
};