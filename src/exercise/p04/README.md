- 자료출처: Power Java Compact(출판사:인피니트 북스, 저자:천인국)

## Exercise
#1.다음과 같은 클래스가 정의되어 있다고 가정하자. 
이 클래스의 객체를 생성하고 필드를 10과 1.2345로 초기화하며 각 필드의 값을 출력하는 코드를 작성하라.
ANSWER  

```
class NumberBox {
	public int iValue;
	public float fValue;
}
public class NumberBoxTest {
	public static void main(String[] args) {
		NumberBox b = new NumberBox();
		b.iValue=10;
		b.fValue=(float)1.2345;
		System.out.println(b.iValue);
		System.out.println(b.fValue);
	}
}
```

#2.날짜(date)를 클래스명을 MyDate로 작성한다고 가정하자. 
Data 안에 저장되는 변수 이름과 날짜를 조작하는 메서드 이름을 생각하여 보자.
ANSWER  

```
 변수 int year, month, day;
 메소드 이름 void MyDate(int year, int month, int day), String toString()
```

#3.다음 프로그램에서 잘못된 부분은 무엇인가? 올바르게 수정하시오.
ANSWER  
 객체가 생성되지 않았다. new를 이용하여서 객체를 생성해준다.
 
```
class Rectangle {
	int width, height;
	int area() { return width*height; }
}
public class Test {
    public static void main(String[] args) {
        Rectangle myRect;
        myRect = new Rectangle();//객체를 생성 한후 객체에 접근할 수 있다.
        myRect.width = 10;
        myRect.height = 20;
        System.out.println("면적은 " + myRect.area());
    }
}
```

#4.2개의 정수의 합을 구하는 sum()과 3개의 정수의 합을 구하는 sum()을 메서드 오버로딩을 이용하여 정의하라.
ANSWER  

```
class Calculation{
  void sum(int a, int b){System.out.println(a+b);}
  void sum(int a, int b, int c){System.out.println(a+b+c);}

  public static void main(String[] args){
  Calculation obj=new Calculation();
  obj.sum(10,20,30);
  obj.sum(10,20);
  }
}
```

## Program Exercise
#1.  
ANSWER  

```
class Student  {
	String name;
	int rollno;
	int age;
}
public class StudentTest {
    public static void main(String[] args) {
        Student std;
        std = new Student();
        std.name = "Kim";
        std.rollno = 20180001;
        std.age = 20;
        std.name = "Kim";
        System.out.println("학생의 이름: "+std.name);
        System.out.println("학생의 학번: "+std.rollno);
        System.out.println("학생의 나이: "+std.age);
    }
}
```

#2.  
ANSWER  

```
class Dog{
   String breed;
   int age;
   String color;

   public Dog(String breed, int age, String color) {
	super();
	this.breed = breed;
	this.age = age;
	this.color = color;
}

void barking(){
       System.out.println("barking()");
   }
   
   void hungry(){
       System.out.println("hungry()");
   }
   
   @Override
public String toString() {
	return "("+breed+","+age+","+color+")";
}

void sleeping(){
       System.out.println("sleeping()");
   }
}

public class DogTest {
    public static void main(String[] args) {
        Dog obj = new Dog("york", 1, "orange");
        System.out.println(obj);
        obj.barking();
        obj.hungry();
        obj.sleeping();
    }
}
```

#3.  
ANSWER  

```
class Date {
	int year;
	int month;
	int day;

	void print1() {
		System.out.println(year + "." + month + "." + day);
	}
}

public class DateTest {
	public static void main(String[] args) {
		Date d;
		d = new Date();
		d.year = 2012;
		d.month = 9;
		d.day = 5;
		d.print1();
	}
} 
```

#4.  
ANSWER  

```
class ComplexNumber {
	int real;
	int imag;

	void print() {
		System.out.println(real + "+"+ imag+"i");
	}
}

public class ComplexNumberTest {
	public static void main(String[] args) {
		ComplexNumber c;
		c = new ComplexNumber();
		c.real = 10;
		c.imag = 20;
		c.print();
	}
}
```

#5.  
ANSWER  

```
class Account {
	int balance;

	public Account() {
		this.balance = 0;
		System.out.println("새로운 계좌가 만들어졌습니다.");
	}
	public void deposit(int amount) {
		balance += amount;
		System.out.println(amount+"원 저축");
	}
	public void widthdraw(int amount) {
		balance -= amount;
		System.out.println(amount+"원 인출");
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}

public class AccountTest {
	public static void main(String[] args) {
		Account cust1 = new Account();
		cust1.deposit(50000);
		Account cust2 = new Account();
		cust2.deposit(100000);
		System.out.println("고객 #1 계좌 잔고="+cust1.getBalance());
		System.out.println("고객 #2 계좌 잔고="+cust2.getBalance());
	}
}
```