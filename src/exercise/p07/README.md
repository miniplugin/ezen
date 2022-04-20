- 자료출처: Power Java Compact(출판사:인피니트 북스, 저자:천인국)

## Exercise
#1.다음의 Rectangle 클래스를 보고 질문에 답하시오.

```
public class Rectangle {
	int w, h;
}
```
ANSWER

```  
 (1) 위의 Rectangle 클래스를 library 패키지에 속하게 하려고 한다. 코드 최상단에 어떤 문장을 추가해야 하는가?
 -답변: package library;
 (2) 위의 Rectangle 클래스를 다른 패키지의 클래스에서 import 문장 없이 사용하고자 한다. 어떻게 하여야 하는가?
 -답변: library.Rectangle d = new library.Rectangle();
 (3) 다른 패키지의 클래스에서 import 문장을 사용하여 library 패키지를 포함시켜 보자.
 -답변: import library.*; 
```

#2.여러가지 유틸리티 라이브러리를 사용하여 보자. 빈칸에 해당되는 문장을 완성시켜 보자.

```
public class Test {
	public static void main(String[] args) {
		___________________________;
	}
}
```
ANSWER  

```
(1) 0 부터 100 사이의 난수를 하나 생성하여 보자.
-답변:
Random random = new Random();
System.out.println(random.nextInt(100));
(2) 국제 전화 번호 "080-2-777-5566"에서 국가 번호, 도시 식별 번호, 가입자 번호를 추출하여 보자. StringTokenizer를 사용한다.
-답변:
StringTokenizer st = new StringTokenizer("082-2-777-5566", "-");
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}
(3) 오늘 날짜를 화면에 출력하여 보자.
-답변: Calendar d = Calendar.getInstance();
             System.out.println(d);
(4) Test 클래스의 객체를 생성하고 이 객체를 통하여 객체를 생성한 클래스의 이름을 출력하여 보자.
-답변: 
   Test obj = new Test();
   System.out.println("The class of " + obj +
                            " is " + obj.getClass().getName());
(5) 0도 부터 90도 까지 5도씩 증가하면서 싸인값을 출력하는 루프를 작성하고 테스트하라.
for(int i=0; i<=90; i+=5) {
      System.out.println(Math.sin(Math.toRadians((double)i)));
}
```

#3.2개의 문자열이 동일한지를 비교하기 위하여 아래와 같은 문장을 작성하여 실행하였다.
하지만 결과는 문자열이 같지 않다고 나온다. 무엇 때문이고 어떻게 수정하여야 하는가?

```
String s1 = new String("Why");
String s2 = new String("Why");
if(s1 == s2)
	System.out.println("2개의 문자열은 같습니다.");
else
	System.out.println("2개의 문자열은 다릅니다.");
```
ANSWER  
 자바에서 문자열을 == 연산자로 비교하면 안 된다. s1.equals(s2)을 사용한다. 

```
if( s1.equals(s2) )
	System.out.println("2개의 문자열은 같습니다.“);
else 
	System.out.println("2개의 문자열은 다릅니다.“);
```

#4.다음 코드에서 자동박싱과 자동언박싱을 지적하라. 원래는 어떻게 적어주어야 하는가?

```
Integer obj = 100; //이렇게 사용해도 전혀 운제 없다. 자동박싱
int i = obj; //이렇게 사용해도 전혀 문제 없다. 자동언박싱
```
ANSWER  

```
Integer obj = new Integer(100);//Interger 참조형 객체로 생성(박싱)
int i = obj.intValue(); //int 기초(기본)형 변수로 언박싱
```
 
#5.Integer와 같은 랩퍼 클래스는 왜 필요한가?
ANSWER  

```
 어떤 라이브러리는 객체만을 받기 때문이다. int와 같은 기본 자료형을 받을 수 없다.
 실제는 null 을 허용하기 때문에 null 오류를 방지하려고 사용한다.
```

#6.오류와 발생되는 예외를 올바르게 짝지으시오.
ANSWER  

```
 ● int[] list; list[0] = 0; -> 컴파일 오류, 배열은 초기화되지 않았고 컴파일되지 않는다. 
 ● 자바 가상 기계가 클래스를 찾을 수 없는 경우 -> error
 ● 파일을 읽던 프로그램이 파일의 끝에 도달한 경우 -> 예외가 아니다. 
 스트림을 읽을 때는 언젠가는 스트림의 끝에 도달하리라는 것을 예상할 수 있다. 예외는 예상치 못한 경우에 사용한다. 
 ● 파일의 끝에 도달했는데도 파일을 읽으려고 시도 -> 체크 예외(checked exception)
```

#7.다음 프로그램을 컴파일하여 보자.

```
public class Test {
	public static void main(String[] args) {
		sub();
	}
	public static void sub() {
		int[] array = new int[10];
		int i = array[10];
	}
}
```
ANSWER  

```
(1) 위의 프로그램은 컴파일 시에 오류가 발생한다. 어떤 오류가 발생하는가?
-답변: java.lang.ArrayIndexOutOfBoundsException
(2) try/catch 블록을 사용하여서 예외를 처리하여 보자
-답변:
try {
	int i = array[10];
} catch (ArrayIndexOutOfBoundsException e) {
	e.printStackTrace();
}
(3) throws 선언을 이용하여 예외를 처리하여 보라.
public static void sub() throws ArrayIndexOutOfBoundsException {
	int[] array = new int[10];
	int i = array[10];
}
```

#8.다음과 같은 예외 처리기로 잡을 수 있는 예외는 어떤 종류인가?
그리고 이런 종류의 예외 처리가 바람직하지 않는 이유는?

```
catch(Exception e) {
	...
}
```
ANSWER  

```
 이 예외 처리기는 거의 모든 종류의 예외를 잡는다. 따라서 어떤 종류의 예외인지를 알기가 힘들다. 
```

#9.다음 코드에서 잘못된 부분을 지적하시오.

```
try {
	...
} catch(Exception e) {
	...
} catch(ArithmeticException a) {
	...
}
```
ANSWER

```  
 첫 번째 예외 처리기는 Exception 타입의 예외를 잡는다. 따라서 모든 종류의 예외를 잡는다. 따라서 두 번째 예외 처리기는 실행되지 못한다. 
```

#10.다음 프로그램의 출력을 쓰시오.

```
try {
	int n = Integer.parseInt("abc");
	System.out.println("try");
} catch(NumberFormatException e) {
	System.out.println("숫자형식오류");
} finally {
	System.out.println("finally");
}
```
ANSWER  

```
숫자형식오류
finally
```


## Program Exercise
#1.  
ANSWER  

```
import java.util.Random;
public class Die {
	private int value;
	private int num;
	Random r = new Random();
	public Die(){
		value = 1;
	}
	public int roll(){
		num = (r.nextInt(5)+1);
		return num;
	}
	public void setValue(int v){
		value = v;
	}
	public String toString(){
		return ("현재 주사위 상태 : " + roll());
	}
	public static void main(String[] args){
		Die d = new Die();		
		System.out.println(d.toString());
	}
}
```


#2.   
ANSWER  

```
import java.util.*;
public class Game {
	public static void main(String[] args){
		Random r = new Random();
		Scanner s = new Scanner(System.in);
		int num1, num2;
		System.out.print("하나를 선택하시요 : 가위(0), 바위(1), 보(2) : ");
		num1 = s.nextInt();
		num2 = r.nextInt(3);
		if(num2 == 0)
			System.out.println("컴퓨터는 가위를 냈습니다.");
		else if(num2 == 1)
			System.out.println("컴퓨터는 바위를 냈습니다.");
		else
			System.out.println("컴퓨터는 보를 냈습니다.");
		
		if(num1==0){
			if(num2 == 1)
				System.out.println("컴퓨터가 이겼습니다");
			else if(num2 == 2)
				System.out.println("당신이 이겼습니다.");
			else
				System.out.println("비겼습니다.");
		}
		else if(num1 == 1){
			if(num2 == 0)
				System.out.println("당신이 이겼습니다.");
			else if(num2 == 2)
				System.out.println("컴퓨터가 이겼습니다.");
			else
				System.out.println("비겼습니다.");
		}
		else{
			if(num2 == 0)
				System.out.println("컴퓨터가 이겼습니다");
			else if(num2 == 1)
				System.out.println("당신이 이겼습니다.");
			else
				System.out.println("비겼습니다.");
		}
	}
	
}
```

#3.  
ANSWER  

```
import java.util.*;
import java.util.Arrays;
public class StrSort {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int count = 0, i = 0;		
		String[] ars = new String[100];
		
		System.out.print("문자열을 입력하시요 : ");
		String str = s.nextLine();
		StringTokenizer st = new StringTokenizer(str);
		while(st.hasMoreTokens()){
			ars[i] = st.nextToken();
			System.out.print(ars[i]+ ",");
			count++;
			i++;
		}
		System.out.println("\n모두 " + count + "개의 단어가 있습니다.");
	}
}
```