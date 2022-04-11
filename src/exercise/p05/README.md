- 자료출처: Power Java Compact(출판사:인피니트 북스, 저자:천인국)

## Exercise
#1.만약 어떤 values라는 double형 배열이 init() 메서드의 매개 변수로 넘어왔다고 하자.
배열의 각 원소를 0으로 초기화하는 문장을 작성하라.
ANSWER  

```
void init(double[] values){
	for(int i = 0; i < values.length; i++){
		values[i] = 0;
}
```

#2.다음 프로그램의 실행 결과는 무엇일까? 이유를 설명하라.
ANSWER  

```
public class Test {
	public static void main(String[] args) {
		String x = null;
		giveMeAString(x);
		System.out.println(x);
	}
	static void giveMeAString(String y) {
		y = "This is a String";
	}
}
-답변
 자바에서는 모든 것이 call-by-value 방식으로 전달된다. 그래서 출력은 null.
 따라서 위의 프로그램에서는 참조 변수 x의 값이 참조 변수 y로 복사된다. 
 참조 변수 y의 값을 변경하여도 변수 x의 값은 변경되지 않는다. 
```

#3.다음 프로그램의 출력은?
ANSWER  

```
public class Test {
	public static void main(String[] args) {
		class MyClass {
			public int i = 3;
		}
		MyClass obj = new MyClass();
		System.out.println("i = " + obj.i);
	}
}
-답변
 i = 3
```

#4.다음 프로그램의 출력은?
ANSWER  

```
class Point {
	int x;
	int y;
}
public class Test {
	public static void main(String[] args) {
		Test obj = new Test();
		obj.sub();
	}
	void sub() {
		Point p = new Point();//Point는 x,y 좌표변수를 갖는 내장 클래스이다.
		p.x = 10;
		p.y = 10;
		set(p);
		System.out.println(p.x + "," + p.y);
	}
	void set(Point p) {
		p.x = 30;
		p.y = 40;
	}
}
-답변
 30,40
```

#5.다음 코드는 배열 a를 배열 b로 복사하려는 의도로 작성되었다. 실제 배열이 복사되는가?
만약 올바르지 않다면 올바르게 복사되도록 코드를 수정하라.
ANSWER  

```
int[] a = {1, 2, 3, 4, 5};
int[] b = new int[5];
b = a; //배열 a를 배열 b로 복사
```
 배열이 복사되지 않는다. 다음과 같이 하여야 한다. 

```
int[] a = {1, 2, 3, 4, 5};
int[] b = new int[5];
for(int i = 0; i < a.length; i++)
	b[i] = a[i]; 
```

#6.객체 중에는 전체 시스템을 통틀어 딱 하나만 존재하여야 하는 것들이 있다.
다음의 프로그램을 분석하여서 왜 객체가 하나만 생성되는지를 설명하라. 단, 이러한 객체를 생성할 때는 new를 사용하지 않고
정적 메서드 getInstance()를 호출하여야 한다. 이것은 싱글톤 디자인 패턴(singleton design pattern)으로 불린다.
ANSWER

```  
static class Single {
	private static Single s_instance;
	private static Single getInstance() {
		if(s_instance == null) {
			s_instance = new Single();
		}
		return s_instance;
	}
}
public class SingleTest {
	public static void main(String[] args) {
		Single obj1 = Single.getInstance();
		Single obj2 = Single.getInstance();
	}
}
 s_instance가 null일 때만 객체를 생성하고 이미 객체가 생성되어 있으면 단순히 객체의 참조값을 반환한다. 
 확인 코드: if(obj1 == obj2) { System.out.println("같은 객체 입니다."); }
```

## Program Exercise
#1.  
ANSWER  

```
class MyMetric {
	private static double distance;
	public static double kiloToMile(double d){
		distance = d / 1.6093;
		return distance;
	}
	public static void miletoKilo(double d){
		distance = d * 1.6093;
	}
}
public  class MyMetricTest{
	public static void main(String args[]){
		double d = MyMetric.kiloToMile(1);
		System.out.println("1km를 마일로 바꾸면 "+d);
	}
}
```

#2.  
ANSWER  

```
import java.util.Scanner;

class Theater {
	int[] seats;
	int size;
	public Theater(int size)
	{
		this.size=size;
		seats = new int[size]; 
	}
	public void print()
	{
		System.out.println("----------------------------");
		for(int i=0; i<size; i++)
			System.out.print(i+" ");
		System.out.println("\n----------------------------");
		for(int i=0; i<size; i++)
			System.out.print(seats[i]+" ");
		System.out.println("\n----------------------------");
	}
	public void reserve()
	{
		System.out.println("몇번째 좌석을 예약하시겠습니까?");
		Scanner scan = new Scanner(System.in);
		int s = scan.nextInt();
		if( seats[s] == 0 ){
			seats[s] = 1;
			System.out.println("예약되었습니다.");
		}
	}
}

public class TheaterTest {
	public static void main(String args[]) {
		Theater t = new Theater(10);
		t.print();
		t.reserve();
		t.print();
	}
}
```

#3.  
ANSWER  

```
import java.util.Scanner;
public class TheaterTest {
	static int[] num = new int[5];
	static int sum =0;
	static double avg;
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		for(int i=0; i<5; i++){
			System.out.print("성적을 입력하세요: ");
			num[i] = s.nextInt();
		}
		getTotal();
		getAverage();
	}

	private static void getAverage() {
		avg = sum / 5.0;
		System.out.println("평균 : "+avg);
	}

	private static void getTotal() {
		for(int i =0; i < 5; i++)
			sum += num[i];
		System.out.println("\n합계 : "+sum);
	}
}
```

#4.  
ANSWER  

```
class Plane{
	private int num, p_num;
	private String model;
	private static int planes;
	public void setNum(int n){
		num = n;
	}
	public void setPnum(int pn){
		p_num = pn;
	}
	public void setModel(String m){
		model = m;
	}
	public int getNum(){
		return num;
	}
	public int getPnum(){
		return p_num;
	}
	public String getModel(){
		return model;
	}
	public static void setPlanes(int p){
		planes = p;
	}
	public static int getPlanes(){
		return planes;
	}
	public Plane(){	}
	public Plane(int n, String m, int pn){
		num = n;
		p_num = pn;
		model = m;
	}
	public Plane(int n, String m){
		num = n;
		model = m;
	}
	public String toString(){
		return "식별번호 :" + getNum() + " 모델 : " + getModel() + " 승객수 : " + getPnum();
	}
}
public class PlaneTest {
	public static void main(String[] args){
		Plane plane1 = new Plane(1, "aa", 200);
		Plane plane2 = new Plane(2, "bb", 300);
		Plane plane3 = new Plane();
		plane1.setPlanes(0);
		plane1.getPlanes();
		plane3.setNum(3);
		plane3.setModel("cc");
		plane3.setPnum(150);
		System.out.println(plane1);
		System.out.println(plane2);
		System.out.println(plane3);
	}
}
```

#5.  
ANSWER  

```
class BankAccount{
	int accountNumber;
	String owner;
	int balance;
	
	void deposit(int amount){
		balance += amount;
	}
	void withdraw(int amount){
		balance -= amount;
	}
	public String toString(){
		return "현재 잔액은 " + balance + "입니다.";
	}
	public int transfer(int amount, BankAccount otherAccount){
		System.out.println("transfer(" +amount+")");
		otherAccount.deposit(amount);
		balance-=amount;
		return (balance-amount);
	}
}
public class BankAccountTest {	
	public static void main(String[] args){
		BankAccount myAccount1 = new BankAccount();
		BankAccount myAccount2 = new BankAccount();
		myAccount1.deposit(10000);
		System.out.println("myAccount1 : " +myAccount1);
		System.out.println("myAccount2 : " + myAccount2);
		int b = myAccount1.transfer(1000, myAccount2);
		System.out.println("myAccount1 : " + myAccount1);
		System.out.println("myAccount2 : " + myAccount2);
		
	}
}
```