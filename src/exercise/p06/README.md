- 자료출처: Power Java Compact(출판사:인피니트 북스, 저자:천인국)

## Exercise
#1.다음과 같은 클래스 정의에 대하여 답하라.

```
class Student {
	private int number;
	protected String name;
}
public class GraduateStudent extends Student {
	public String lab;
}
```
ANSWER  

```
(1) 위의 코드에서 부모 클래스는 (     )이고, 자식 클래스는 (             ) 이다.
-답변: Student, GraduateStudent
(2) 위의 클래스 관계를 나타내는 UML 도형을 그려라. (클래스 다이어그램으로 대체)
-답변
Student
-number: int
+name : String

GraduateStudent
+lab : String
(3) 각 필드에 대한 접근자와 설정자를 작성하라.(Getter,Setter로 자동생성)
-답변
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
(4) 생성자를 추가하여 보라. 자식 클래스의 생성자에서 부모 클래스의 생성자를 명시적으로 호출하게 하라.(자동완성 사용)
-답변
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
(5) GraduateStudent s = new GraduateStudent(0, "name", "lab");와 같이 객체를 생성하였다고 하자.
다음 중 필드를 잘못 접근한 것은?
(1) s.number = 10;
(2) s.lab = "Image Processing Lab";
(3) s.name = "홍길동";
-답변
① private 멤버는 접근할 수 없다. 이렇게 Setter 메서드로 접근한다. s.setNumber(10);
```

#2.다음 코드의 실행 결과는?
ANSWER  

```
class A {
	public A() { System.out.println("클래스 A 생성자"); }
}
class B extends A{
	public B() { System.out.println("클래스 B 생성자"); }
}
class C extends B {
	public C() { System.out.println("클래스 C 생성자"); }
}
public class Test {
	public static void main(String[] args) {
		C c = new C();
	}
}
-답변
클래스 A 생성자
클래스 B 생성자
클래스 C 생성자
```

#3.다음 코드에 대하여 질문에 답하라
ANSWER  

```
class A {
	private int x;
	protected int y;
	int z;
	public int w;
}
class B extends A{
	public int u;
}

(1) 위의 코드에서 B obj = new B(); 문장을 이용하여 객체 obj를 생성하였다고 하자.
obj를 통하여 사용할 수 있는 필드는 어떤 것들인가?
-답변: y, z, w, u
(2) 다음 중 잘못된 문자은 무엇인가? 그 이유는?
 1) A obj = new B();
 2) B obj = new A();
-댭변: ②, 자식 객체가 부모 객체보다 크기 때문에 B 참조 변수로 A 객체를 가리킬 수는 없다. 
```

#4.다음 코드에는 잘못된 부분이 있다. 올바르게 수정하라.
ANSWER  

```
class A {
	public A(char c) {  }
}
class B extends A{
	public B(char c) {  }
}
-답변
 기본 생성자가 정의되어 있지 않아서 컴파일 오류가 발생한다. public A() {} 추가
```

#5.다음 코드에 대하여 질문에 답하라.

```
class A {
	public void print() { System.out.println("A"); }
}
class B extends A{
	public void print() { System.out.println("B"); }
}
```
ANSWER  

```
(1) 다음과 같은 코드를 실행한 결과는?
B obj = new B();
obj.print();
-답변: B
(2) 다음과 같은 코드를 실행한 결과는?
A obj = new B();
obj.print();
-답변: B
(3) B의 print() 안에서 A의 print()도 호출하려면 어떻게 하면 되는가?
class B extends A {
	public void print() { 
		super.print();
		System.out.println("B");     
	}
}
```

#6.다음 코드에서 잘못된 부분은 어디일까?
ANSWER  

```
abstract class A {
	public void print() { 
		public abstract void print();
		public void display();
	}
}
class B extends A{
}
-답변
 추상 클래스 안의 메서드를 상속한 클래스 B에서 구현하지 않았다. 
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