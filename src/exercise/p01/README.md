## Excercise
#1.  
ANSWER  

```
 byte, short, int, long, float, double, boolean, char
```

#2.  
ANSWER  

```
 String 클래스 
```

#3.  
ANSWER  

```
 주민등록번호는 숫자보다는 문자열(String 클래스)로 저장하는 것이 바람직하다. 
 하지만 숫자로 저장해야 한다면 XXXXXX-YYYYYY와 같이 적어도 12자리이기 때문에 long을 사용하여야 할 것이다. 
 그리고 사용자가 입력할 때 중간의 –은 입력하지 않도록 하여야 할 것이다. 
```

#4.  
ANSWER  

```
 (c)
```

#5.  
ANSWER  

```
int k=10;		// k는 변수, 10은 리터럴 상수
long m=200L;		// m은 변수, 200L은 리터럴 상수
double f=1.2345;	// f은 변수, 1.2345는 리터럴 상수
final int SIZE=100;	// SIZE는 기호 상수
```

#6.  
ANSWER

```
(1) 
 v는 11, k은 0이 된다. 
(2) 
 v는 11, k은 1이 된다. 
```

#7.  
ANSWER  

```
 실행결과
 100200
 300
 100200
```

#8.  
ANSWER  

```
 309
```

#9.  
ANSWER  

```
 i의 값은 0이 된다. 
```

#10.  
ANSWER 

``` 
 ! 연산자
```

#11.  
ANSWER 

``` 
 == 연산자
```

#12.  
ANSWER  

```
 abcghidef
```

#13.  
ANSWER  

```
 컴파일 오류가 발생한다. x==y로 변경하여야 한다. 
```

#14.  
ANSWER  

```
 System.out.println(++i);에 의하여 i의 값은 6이 된다. 왜냐하면 ++가 수식의 앞에 붙어 있기 때문이다.    
 System.out.println(i++); 도 역시 6을 출력하는데 ++가 뒤에 붙어 있기 때문에 증가가 나중에 이루어진다. 
```

#15.  
ANSWER  

```
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