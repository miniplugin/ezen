## Excercise
#1.  
ANSWER  

```
void init(double[] values){
	for(int i = 0; i < values.length; i++){
		values[i] = 0;
}
```

#2.  
ANSWER  

```
 자바에서는 모든 것이 call-by-value 방식으로 전달된다. 
 따라서 위의 프로그램에서는 참조 변수 x의 값이 참조 변수 y로 복사된다. 
 참조 변수 y의 값을 변경하여도 변수 x의 값은 변경되지 않는다. 
```

#3.  
ANSWER  

```
 i = 3
```

#4.  
ANSWER  

```
 30,40
```

#5.  
ANSWER  
 배열이 복사되지 않는다. 다음과 같이 하여야 한다. 

```
int[] a = {1, 2, 3, 4, 5};
int[] b = new int[5];
for(int i = 0; i < a.length; i++)
	b[i] = a[i]; 
```

#6.  
ANSWER

```  
 s_instance가 null일 때만 객체를 생성하고 이미 객체가 생성되어 있으면 단순히 객체의 참조값을 반환한다. 
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