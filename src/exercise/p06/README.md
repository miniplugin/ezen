## Excercise
#1.  
ANSWER  

```
(1) Student, GraduateStudent
(2) 
Student
-number: int
+name : String

GraduateStudent
+lab : String
(3) 
class Student {
       public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private int number;
      public String name;
}
 
public class GraduateStudent extends Student {
       public String getLab() {
		return lab;
	}

	public void setLab(String lab) {
		this.lab = lab;
	}

	public String lab;
}
(4)
class Student {
	public Student(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}
	...
	private int number;
	public String name;
}

public class GraduateStudent extends Student {
	public GraduateStudent(int number, String name, String lab) {
		super(number, name);
		this.lab = lab;
	}

	...
	public String lab;
}
(5) ① private 멤버는 접근할 수 없다. 
```

#2.  
ANSWER  

```
클래스 A 생성자
클래스 B 생성자
클래스 C 생성자
```

#3.  
ANSWER  

```
(1) y, z, w, u
(2) ②, 자식 객체가 부모 객체보다 크기 때문에 B 참조 변수로 A 객체를 가리킬 수는 없다. 
```

#4.  
ANSWER  

```
 기본 생성자가 정의되어 있지 않아서 컴파일 오류가 발생한다. 
```

#5.  
ANSWER  

```
(1) B
(2) B
(3) 
class B extends A {
	public void print() { 
		super.print();
		System.out.println("B");     }
}
```

#6.  
ANSWER  

```
 추상 클래스 안의 메소드를 클래스 B에서 구현하지 않았다. 
```

## Program Exercise
#1.  
ANSWER  

```
class Circle  {
	protected int radius;
	public Circle(int r) { radius = r; }
}

public class Pizza extends Circle {
	String topping;
	public Pizza(String topping, int r) {
		super(r);
		this.topping = topping;
	}
	public void print()
	{
		System.out.println("피자의 종류: "+topping+", 피자의 크기: "+radius);
	}
	public static void main(String args[]) {
		Pizza obj = new Pizza("Pepperoni", 20);
		obj.print();
	}
}
```

#2.  
ANSWER  

```
class Animal{
    void walk(){
        System.out.println("걷을 수 있음");
    }
}
class Bird extends Animal {
    void fly() {
        System.out.println("날을 수 있음");
    }
    void sing() {
        System.out.println("노래 부를 수 있음");
    }
}

public class Test {
   public static void main(String[] args){
      Bird bird = new Bird();
      bird.walk();
      bird.fly();
      bird.sing();
   }
}
```

#3.  
ANSWER  

```
interface Animal {
    void walk() ;
    void fly() ;
    void sing() ;
}
class Bird implements Animal {
    public void fly() {
        System.out.println("날을 수 있음");
    }
    public void sing() {
        System.out.println("노래 부를 수 있음");
    }
	public void walk() {
        System.out.println("걷을 수 있음");
	}
}

public class Test {
   public static void main(String[] args){
      Bird bird = new Bird();
      bird.walk();
      bird.fly();
      bird.sing();
   }
}
```

#4.  
ANSWER  

```
class Sports{
    String getName(){
        return "아직 결정되지 않음";
    }
    int getPlayers(){
        return 0;
    }
}

class Soccer extends Sports{
    String getName(){
        return "축구";
    }
    int getPlayers(){
        return 11;
    }
}

public class Test {
   public static void main(String[] args){
      Soccer obj = new Soccer();
      System.out.println("경기이름: "+obj.getName());
      System.out.println("경기자수: "+obj.getPlayers());
   }
}
```

#5.  
ANSWER  

```
class Rectangle {
	int width, height;
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
}
class ColorRectangle extends Rectangle
{
   String color ;

   public ColorRectangle( int initWidth, int initHeight,String initColor ) 
   {
       super( initWidth, initHeight ) ;
       color = initColor ;
   }
}

public class Test {
   public static void main(String[] args){
      ColorRectangle obj = new ColorRectangle(100, 100, "blue");
      System.out.println("가로: "+obj.width);
      System.out.println("세로: "+obj.height);
      System.out.println("색상: "+obj.color);
   }
}
```