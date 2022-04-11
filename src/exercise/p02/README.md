- 자료출처: Power Java Compact(출판사:인피니트 북스, 저자:천인국)

## Exercise
#1.자바 언어에서 지원되는 8가지의 기초(기본) 자료형은 무엇인가?
ANSWER  

```
 byte, short, int, long, float, double, boolean, char
```

#2.문자열은 어떤 클래스를 이용하여 처리할 수 있는가?
ANSWER  

```
 String (참조형)클래스 
```

#3.주민등록번호를 프로그램에서 저장하려면 자바의 어떤 자료형을 선택하는 것이 좋을까?
ANSWER  

```
 주민등록번호는 숫자보다는 문자열(String 클래스)로 저장하는 것이 바람직하다. 
 하지만 숫자로 저장해야 한다면 XXXXXX-YYYYYY와 같이 적어도 12자리이기 때문에 long을 사용하여야 할 것이다. 
 그리고 사용자가 입력할 때 중간의 –은 입력하지 않도록 하여야 할 것이다. 
```

#4.다음 중에서 올바른 주석이 아닌 것은?
ANSWER  

```
(a)/**주석*/ (b)/*주석*/ (c)/*주석 (d)//주석
-답변
 (c)
```

#5.다음 코드에서 변수와 상수를 구별하시오.
ANSWER  

```
int k=10;		// k는 변수, 10은 리터럴 상수
long m=200L;		// m은 변수, 200L은 리터럴 상수
double f=1.2345;	// f은 변수, 1.2345는 리터럴 상수
final int SIZE=100;	// SIZE는 기호 상수
```

#6.다음과 같은 코드에서 질문에 답하라.
ANSWER

```
int v  = 10;
int k = v++%5;
-답변
(1) 코드가 살행된 후에 v와 k의 값은 무엇인가?
 v는 11, k은 0이 된다. 
(2) 만약 두 번째 문장이 int k = ++v%5;이었다면 v와 k의 값은 어떻게 되는가?
 v는 11, k은 1이 된다. 
```

#7.다음 문장들을 실행했을 경우의 출력결과를 적으시오.
ANSWER  

```
System.out.println("100"+"200");
System.out.println(100+200);
System.out.println("100"+200);
-답변
 100200
 300
 100200
```

#8.다음 프로그램의 출력은?
ANSWER  

```
public class Test {
	public static void main(String[] args) {
		int i1 = 10;
		int i2 = 20;
		String s1 = "9";
		System.out.println(i1 + i2 + s1);
	}
}
-답변
 309
```

#9.다음 문장이 실행될때 변수 i의 값은? 참고로 Math.random()메서드는 0에서 1사이의 실수를 표시한다.
ANSWER  

```
int i = (int) Math.random();
-답변
 i의 값은 0이 된다. 
```

#10.boolean 변수의 값을 true에서 false로 반전시키려면 어떤 연산자를 사용하여야 하는가?
ANSWER 

``` 
 ! 연산자
```

#11.2개의 값을 비교하려고 한다. = 연산자를 사용하여야 하는가? 아니면 == 연산자를 사용하여야 하는가?
ANSWER 

``` 
 == 연산자
```

#12.다음 프로그램의 출력은?
ANSWER  

```
public class Test {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "def";
		String s3 = s2;
		s2 = "ghi";
		System.out.println(s1 + s2 + s3);
	}
}
-답변
 abcghidef
```

#13.다음 프로그램의 출력은?
ANSWER  

```
public class Test {
	public static void main(String[] args) {
		int x = 100;
		double y = 123.4;
		boolean b = (x = y);
		System.out.println(b);
	}
}
-답변
 컴파일 오류가 발생한다. x==y로 변경하여야 한다. 
```

#14.다음의 프로그램에서 6의 값이 두 번 출력되는 이유를 설명하라.
ANSWER  

```
public class Test {
	public static void main(String[] args) {
		int i = 3;
		i++;
		System.out.println(i);//4
		++i;
		System.out.println(i);//5
		System.out.println(++i);//6
		System.out.println(i++);//6
		System.out.println(i);//7
	}
}
-답변
 System.out.println(++i);에 의하여 i의 값은 6이 된다. 왜냐하면 ++가 수식의 앞에 붙어 있기 때문이다.    
 System.out.println(i++); 도 역시 6을 출력하는데 ++가 뒤에 붙어 있기 때문에 증가가 나중에 이루어진다. 
```

#15.각 문장을 실행한 후, 변수의 값을 표에 기록하시오. 사용자는 2와 3을 차례대로 입력한다고 가정한다.
ANSWER  

```
import java.util.Scanner;
public class Test {
	public static void main(String[] args) {
		int x = 0;
		System.out.println(x);//0
		Scanner s = new Scanner(System.in);
		x = s.nextInt();//2
		x = s.nextInt();//3
		boolean a = true, b = false, c = true;
		a = (b || c) && (a || false);//true
	}
}
-답변
 x = { 0, 2, 3, 3, 3 }
 a = { true, false true }
```

## Program Exercise
#1.  
ANSWER  

```
import java.util.Scanner;
public class Box {
	public static void main(String args[]) {
		int oranges=0;
        	Scanner input = new Scanner(System.in);
	    	System.out.print("오렌지의 개수를 입력하시오: "); // 입력 안내 출력
    		oranges = input.nextInt(); 
        	System.out.println(oranges/10 + "박스가 필요하고 " + 
			oranges%10 + "개가 남습니다. ");
	}
}
```

#2.  
ANSWER  

```
import java.util.Scanner;
public class Mile2Km {
	public static void main(String args[]) {
		double mile; 
	        double km; 
        	Scanner input = new Scanner(System.in);
	    	System.out.print("마일을 입력하시오: "); // 입력 안내 출력
    		mile = input.nextDouble(); 
	    	km = 1.609 * mile;
        	System.out.println(mile + "마일은 " + km + "킬로미터입니다.");
	}
}
```

#3.  
ANSWER  

``` 
import java.util.Scanner;

public class Calculator {
	public static void main(String args[]) {
		int money; 
        int price; 
        int added_tax; 
        int change; 
        Scanner input = new Scanner(System.in);
    	System.out.print("받은 돈: "); // 입력 안내 출력
    	money = input.nextInt(); 
    	System.out.print("상품 가격: "); // 입력 안내 출력
    	price = input.nextInt(); 
    	added_tax = (int) (price*0.1);
    	change = money - price;
        System.out.println("부가세: " + added_tax);
        System.out.println("잔돈: " + change);
	}
}
```

#4.  
ANSWER  

```
import java.util.Scanner;

public class Sphere {
	public static void main(String args[]) {
		double radius; 
        double volume; 
        Scanner input = new Scanner(System.in);
 
   	System.out.print("구의 반지름: "); // 입력 안내 출력
    	radius = input.nextDouble(); 
    	volume = (4.0/3.0)*radius*radius*radius;
        System.out.println("구의 부피: " + volume);
	}
}
```

#5. 
ANSWER  
 
```
import java.util.Scanner;

public class BinaryConverter {
	public static void main(String args[]) {
		int base10Num;
		String result = "";

		Scanner input = new Scanner(System.in);
		System.out.print("정수: "); // 입력 안내 출력
		int value = base10Num = input.nextInt();

		result = (base10Num % 2) + result;
		base10Num /= 2;
		result = (base10Num % 2) + result;
		base10Num /= 2;
		result = (base10Num % 2) + result;
		base10Num /= 2;
		result = (base10Num % 2) + result;
		base10Num /= 2;
		result = (base10Num % 2) + result;
		base10Num /= 2;
		result = (base10Num % 2) + result;
		base10Num /= 2;

		result = base10Num + result;
		System.out.println(value + ": " + result);
		System.out.println(value + ": " + Integer.toBinaryString(value));

	}
}
```