- 자료출처: Power Java Compact(출판사:인피니트 북스, 저자:천인국)

## Exercise
#1.자바 언어의 특징을 정리해 보자.
ANSWER  

```
 자바는 객체 지향을 완벽하게 지원한다. 자바는 다양한 플랫폼에서 실행이 가능하다. 자바는 가상 기계 개념을 사용한다. 
```

#2.자바의 가상 기계(virtual machine)과 바이트 코드(byte code)에 대하여 설명하라.
ANSWER  

```
 자바는 완전한 기계어로 번역하지 않고 중간 단계까지만 번역을 한다. 
 이 중간 단계의 파일을 바이트 코드(byte code)라고 한다. 
 바이트 코드는 실제로는 가상 기계(virtual machine)의 기계어이다. 
 바이트 코드를 가상 기계 위에서 실행시키면 프로그램이 실행된다. 
```

#3.자바가 한번 작성하면 CPU나 운영체제에 상관없이 어디에서나 실행 가능한 이유는 무엇인가?
ANSWER  

```
 동일한 바이트 코드를 여러 컴퓨터에 설치된 가상 기계가 실행할 수 있기 때문이다. 
```

#4.자바 애플리케이션과 자바 애플릿은 어떻게 다른가?
ANSWER  

```
  자바 애플리케이션은 독자적으로 실행이 가능하다. 자바 애플릿은 웹브라우저 안에서만 실행이 가능하다. 
```

#5.웹서버에서 동작하는 서버 모듈로서 자바로 작성된 것을 무엇이라고 하는가?
ANSWER  

```
  자바 서블릿
```

#6.자바에는 여러 가지 버전이 있다. ME, SE EE 버전은 어디에 사용되는가?
ANSWER  

```
  ME – 휴대폰과 같은 엠베디드 장치에 사용
  SE – 표준적인 자바 버전
  EE – 기업 서버에 사용
```

#7.자바로 작성할 수 있는 애플리케이션에는 어떤 것들이 있는가?
ANSWER  

```
  PC용 데스크탑 애플리케이션, 모바일용 안드로이드 앱, 웹용 서버 애플리케이션
```

#8.JDK와 JRE는 어떻게 다른가?
ANSWER  

```
  JDK – 자바 응용 프로그램을 개발하기 위한 환경, 개발자는 이것을 설치하여야 한다. 
  JRE – 자바 응용 프로그램을 실행하기 위한 환경
```

#9.자바 프로그램을 컴파일하고 실행시키는 과정을 개념적으로 설명하라.
ANSWER  

```
  Myprogram.java(소스코드) -> 컴파일(javac.exe) -> Myprogram.class(바이트코드) -> 실행(JVM)
```

#10.다음 프로그램은 어떤 이름으로 저장될까? 컴파일된 파일이름은 무엇일까? 실행 결과는 어떻게 되는가?
ANSWER  

```
public class Test {
	public static void main(String[] args) {
		System.out.println("This is a Test");
	}
}
-답변
  Test.java, 컴파일된 파일이름은 Test.class, 실행결과는 콘솔로 “This is a Test"가 출력된다. 
```
 
#11.소스 파일의 이름이 MyProgram.java라고 하자. 컴파일하고 실행하는 명령어들을 차례대로 적어보라.
ANSWER  

```
 다음과 같은 명령어를 사용한다. 
c:\>javac   MyProgram.java
c:\>java    MyProgram (.class 생략)
```

## Program Exercise
#1.  

```
public class Hello {
       public static void main(String args[]) {
             System.out.println("학번은 0000001입니다.");// ①
             System.out.println("이름은 홍길동입니다.");
             System.out.println("2012.9.10");
       }
}
```
#2.

```  
public class Hello {
       public static void main(String args[]) {
             System.out.println("이름: 홍길동");// ①
             System.out.println("주소: 서울시 종로구");
             System.out.println("전화번호: 010-123-4567");
             System.out.println("학과: 컴퓨터 공학과");
       }
}
```
#3.

```  
public class Hello {
       public static void main(String args[]) {
           System.out.println("   *   ");
           System.out.println("  ***  ");
           System.out.println(" ***** ");
           System.out.println("*******");
           System.out.println(" ***** ");
           System.out.println("  ***  ");
           System.out.println("   *   ");
       }
}
```