## Excercise
#1.  
ANSWER

```  
 (1) package library;
 (2) library.Rectangle d = new library.Rectangle();
 (3) import library.*; 
```

#2.  
ANSWER  

```
(1) Random random = new Random();
System.out.println(random.nextInt(100));
(2) StringTokenizer st = new StringTokenizer("082-2-777-5566", "-");
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}
(3)  Calendar d = Calendar.getInstance();
             System.out.println(d);
(4)  Test obj = new Test();
   System.out.println("The class of " + obj +
                            " is " + obj.getClass().getName());
(5) 
for(int i = 0; i<= 90; i +=5) {
      System.out.println(Math.sin(Math.toRadians((double)i)));
}
```

#3.  
ANSWER  
 자바에서 문자열을 == 연산자로 비교하면 안 된다. s1.equals(s2)을 사용한다. 

```
if( s1.equals(s2) )
	System.out.println("2개의 문자열은 같습니다.“);
else 
	System.out.println("2개의 문자열은 다릅니다.“);
```

#4.  
ANSWER  

```
Integer obj = new Integer(100);
int i = obj.intValue();
```
 
#5.  
ANSWER  

```
 어떤 라이브러리는 객체만을 받기 때문이다. int와 같은 기본 자료형을 받을 수 없다.
```

#6.  
ANSWER  

```
 ● int[] list; list[0] = 0; -> 컴파일 오류, 배열은 초기화되지 않았고 컴파일되지 않는다. 
 ● 자바 가상 기계가 클래스를 찾을 수 없는 경우 -> error
 ● 파일을 읽던 프로그램이 파일의 끝에 도달한 경우 -> 예외가 아니다. 
 스트림을 읽을 때는 언젠가는 스트림의 끝에 도달하리라는 것을 예상할 수 있다. 예외는 예상치 못한 경우에 사용한다. 
 ● 파일의 끝에 도달했는데도 파일을 읽으려고 시도 -> 체크 예외(checked exception)
```

#7.  
ANSWER  

```
(1) java.lang.ArrayIndexOutOfBoundsException
(2) 
try {
	int i = array[10];
} catch (ArrayIndexOutOfBoundsException e) {
	e.printStackTrace();
}
(3) 
public static void sub() throws ArrayIndexOutOfBoundsException {
	int[] array = new int[10];
	int i = array[10];
}
```

#8.  
ANSWER  

```
 이 예외 처리기는 거의 모든 종류의 예외를 잡는다. 따라서 어떤 종류의 예외인지를 알기가 힘들다. 
```

#9.  
ANSWER

```  
 첫 번째 예외 처리기는 Exception 타입의 예외를 잡는다. 따라서 모든 종류의 예외는 잡는다. 따라서 두 번째 예외 처리기는 실행되지 못한다. 
```

#10.  
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