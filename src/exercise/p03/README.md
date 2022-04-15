- 자료출처: Power Java Compact(출판사:인피니트 북스, 저자:천인국)

## Exercise
#1.다음의 작업을 수행하는 문장을 작성하라.
ANSWER  

```
(1) 20 이상이고 60 미만이면 count를 1씩 증가한다.
if( count >= 20 && count < 60 )
	count++;
(2) x와 y 중에서 큰 값을 max에 저장하고 작은 값을 min에 저장한다.
if( x > y ){
	max = x;
	min = y;
}
else {
	max = y;
	min = x;
}
(3) x가 1부터 20 사이에 있으면 x의 값을 y에 대입한다.
if( x >=1 && x <= 20 )
	y = x;
```

#2.다음 프로그램의 출력은 무엇인가?
ANSWER  

```
for(int i=0;i<3;i++) {
	switch(i) {
		case 0: break;
		case 1: System.out.print("one ");
		case 2: System.out.print("two ");
		case 3: System.out.print("three ");
	}
}
 System.out.println("done");
-답변
 one two three two three done
```

#3.다음 코드를 실행하였을 경우, 생성되는 출력을 쓰시오. 들여쓰기를 올바르게 수정하시오.
ANSWER  

```
int age = 66;
if(age > 20)
	if(age < 65)
		System.out.println("1번 그룹");
else
	System.out.println("2번 그룹");
-답변
 2번 그룹
```

#4.다음 코드를 실행햐였을 경우, 어떤 일이 발생하는가?
ANSWER  

```
for(int i=0;i<10;i++) {
	System.out.print(i + " ");
}
System.out.println(i);
-답변
 컴파일 오류가 발생한다. 변수 i는 for 루프구문 외부에서 사용할 수 없다. 
```

#5.다음 문장의 오류를 찾아서 수정하라. 오류가 없을 수도 있고, 2개 이상의 오류가 있을 수도 있다.
 문법적인 오류뿐만 아니라 논리적인 오류도 지적하라.
ANSWER  

``` 
(1) if( age > 0 age < 18 )
	System.out.println("청소년");
-답변
 구문오류: if( age > 0 && age < 18 )
	
(2) if( x = 0 )
	System.out.println("x는 0이다.");
-답변
 구문오류: int x = 0;
	  if( x == 0 )
```

#6.다음의 프로그램에서 생성되는 출력결과는 무엇인가?
ANSWER  

```
int i = 0;
while(i<10) {
	System.out.println("i="+i);
	i += 3;
}
-답변
 i=0
 i=3
 i=6
 i=9
```

#7.다음의 수학식을 계산하는 코드를 작성하라.
ANSWER  

```
시그마 기호를 사용한 i가 1부터 30까지 반복되면서, i의 제곱+1 계산을 sum 변수에 누적해서 더하는 프로그램.
-답변
int sum=0, i;
for(i = 1; i <= 30; i++)
	sum += i*i+1;
```

#8.다음 중에서 올바른 배열 선언을 모두 선택하시오.
ANSWER  

```
(1) int[] myScores;
(2) char[] myChars;
(3) int[6] myScores;
(4) Dog myDogs[];
(5) Dog myDogs[7];
-답변
 ①,②,④
```

#9.다음과 같은 배열을 생성하는 문장을 작성하시오.
ANSWER  

```
 (1) 30개의 요소를 가지는 int형 배열 studentNumbers
 -답변
 int [] studentNumbers = new int[30];
 (2) 요소로 1.2, 3.3, 6.7 을 가지는 double형 배열 values
 -답변
 double [] values = { 1.2, 3.3, 6.7 };
```

#10.int[] employees = new int[5];와 같은 배열 선언이 있다고 하자.
ANSWER  

```
 (1) 유효한 인덱스의 범위는?
 -답변: 0에서 4
 (2) 만약 employees[5]와 같이 요소에 접근하였다면 어떤 일이 발생하는가?
 -답변: ArrayIndex 예외가 발생한다. 
```

#11.double형 배열 values의 각 요소를 0으로 초기화하는 문장을 작성하라
ANSWER  

``` 
double[] values = new double[100];
for(int i=0;i<100;i++)
	values[i] = 0.0;
```

## Program Exercise
#1.  
ANSWER  

```
public class Test {
	public static void main(String args[]) {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 || i % 4 == 0)
				sum += i;
		}
		System.out.println("3 또는 4의 배수의 합=" + sum);
	}
}
```

#2.  
ANSWER  

```
import java.util.Scanner;

public class Test {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		int number = scan.nextInt();

	      switch(number) {
	         case 1: System.out.println("ONE"); break;
	         case 2: System.out.println("TWO"); break;
	         case 3: System.out.println("THREE"); break;
	         case 4: System.out.println("FOUR"); break;
	         case 5: System.out.println("FIVE"); break;
	         case 6: System.out.println("SIX"); break;
	         case 7: System.out.println("SEVEN"); break;
	         case 8: System.out.println("EIGHT"); break;
	         case 9: System.out.println("NINE"); break;
	         default: System.out.println("OTHER"); 
	      }

	}
}
```

#3.  
ANSWER  

```
public class Test {
	public static void main(String args[]) {
		for (int i = 1; i <= 6; i++) {
			for (int k = 1; k <= 6; k++) {
				if ((i + k) == 6)
					System.out.println("(" + i + "," + k + ")");
			}
		}
	}
}
```

#4.  
ANSWER  

```
import java.util.*;
public class Weight {
	public static void main(String[] args){
		double weight, stWeight, height;
		Scanner scan = new Scanner(System.in);
		System.out.println("키를 입력하세요");
		height = scan.nextDouble();
		System.out.println("몸무게를 입력하세요");
		weight = scan.nextDouble();
		stWeight = (height-100) * 0.9;
		if(weight < stWeight)
			System.out.println("저체중입니다.");
		else if(weight == stWeight)
			System.out.println("표준입니다.");
		else
			System.out.println("과체중입니다.");
	}
}
```

#5.  
ANSWER  

```
public class Test {
	public static void main(String args[]) {
		for (int i = 0; i <= 10; i++) {
			for (int k = 0; k <= 10; k++) {
				if ((3 * i + 10 * k) == 100)
					System.out.println("(" + i + "," + k + ")");
			}
		}
	}
}
```

#6.  
ANSWER  

```
public class PrimeNumber {
	public static void main(String[] args){
		int count2 = 0;
		System.out.print("2부터 100사이 모든 소수 : ");
		for(int i = 2; i <= 100; i++){
			count2 = 0;
			for(int k = 2; k < i; k++){
				if((i%k) == 0){
					count2++;
					break;
				}
			}
			if(count2 == 0)
				System.out.print(" " + i);
		}
	}
}
```

#7.  
ANSWER  

```
import java.util.*;
public class Test
{
	public static void main(String[] args){
		int a, b, c;

		for(a=1; a<=100; a++)
		{ 
			for(b=1; b<=100; b++)
			{ 
				for(c=1; c<=100; c++)
				{ 
					if( (a*a+b*b)==c*c )
						System.out.printf("%d %d %d\n", a, b, c);
				}
			}
		}
	}
}
```

#8.  
ANSWER  

```
import java.util.*;
public class Cal {
	public static void main(String[] args){
		String a;
		double num1, num2;
		Scanner s = new Scanner(System.in);
		System.out.println("문자를 입력하세요:");
		a = s.nextLine();
		System.out.println("숫자 2개를입력하세요:");
		num1 = s.nextDouble();
		num2 = s.nextDouble();
		if(a.equals("+")){
			System.out.println(num1 + "+" + num2 + " = "+(num1 + num2));
		}
		else if(a.equals("-")){
			System.out.println(num1 + "-" + num2 + " = "+(num1 - num2));
		}
		else if(a.equals("*")){
			System.out.println(num1+ "*" +num2 + " = "+(num1 * num2));
		}
		else{
			if(num2 != 0)
				System.out.println(num1 + "/" + num2 + " = "+(num1 / num2));
			else
				System.out.println("0으로 나눌수 없습니다.");
		}
	}
}
```

#9.  
ANSWER  

```
import java.util.*;
public class Fibo {
	public static void main(String[] args){
		int n;
		int f0 = 0, f1 = 1, f2;
		Scanner s = new Scanner(System.in);
		System.out.println("출력할 항의 개수; ");
		n = s.nextInt();
		System.out.print("0 1");
		for(int i = 3; i <= n; i++){
			f2 = f1 + f0;
			f0 = f1;
			f1 = f2;
			System.out.print(" " +f2);
		}
	}
}
```

#10.  
ANSWER  

```
public class Test {

   public static void main(String[] args) {
      double[] myList = {1.0, 2.0, 3.0, 4.0};

      for (double element: myList) {
         System.out.print(element);
      }
		double sum=0.0;
      for (double element: myList) {
         sum += element;
      }
		println(“합은” + sum);
		double max=myList[0];
      for (double element: myList) {
			if( element > max )
		         max = element;
      }
		println(“최대값은 ” + max);
   }
}
```

#11.  
ANSWER  

```
public class Test {
   public static void main(String[] args){
      String[] greeting = new String[3];
      greeting[0] = "Hello";
      greeting[1] = "Java";
      greeting[2] = "World";
      for (int i = 0; i < greeting.length; i++){
         System.out.println(greeting[i]);
      }
   }
}
```

#12.  
ANSWER  

```
import java.util.Scanner;
public class ScoreTest {
	static int[] num = new int[5];
	static int sum =0;
	static double avg;
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		for(int i=0; i<5; i++){
			System.out.println("성적을 입력하세요: ");
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
		System.out.println("합계 : "+sum);
	}
}
```