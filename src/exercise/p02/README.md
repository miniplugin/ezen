## Excercise
#1. 
ANSWER  

```
 자바는 객체 지향을 완벽하게 지원한다. 자바는 다양한 플랫폼에서 실행이 가능하다. 자바는 가상 기계 개념을 사용한다. 
```

#2. 
ANSWER  

```
 자바는 완전한 기계어로 번역하지 않고 중간 단계까지만 번역을 한다. 
 이 중간 단계의 파일을 바이트 코드(byte code)라고 한다. 
 바이트 코드는 실제로는 가상 기계(virtual machine)의 기계어이다. 
 바이트 코드를 가상 기계 위에서 실행시키면 프로그램이 실행된다. 
```

#3. 
ANSWER  

```
 동일한 바이트 코드를 여러 컴퓨터에 설치된 가상 기계가 실행할 수 있기 때문이다. 
```

#4. 
ANSWER  

```
  자바 애플리케이션은 독자적으로 실행이 가능하다. 자바 애플릿은 웹브라우저 안에서만 실행이 가능하다. 
```

#5. 
ANSWER  

```
  자바 서블릿
```

#6. 
ANSWER  

```
  ME – 휴대폰과 같은 엠베디드 장치에 사용
  SE – 표준적인 자바 버전
  EE – 기업 서버에 사용
```

#7. 
ANSWER  

```
  데스크탑 애플리케이션, 안드로이드 앱, 서버 애플리케이션
```

#8. 
ANSWER  

```
  JDK – 자바 응용 프로그램을 개발하기 위한 환경, 개발자는 이것을 설치하여야 한다. 
  JRE – 자바 응용 프로그램을 실행하기 위한 환경
```

#9.  
ANSWER  

```
  Myprogram.java(소스코드) -> 컴파일(javac) -> Myprogram.class(바이트코드) -> 실행(JVM)
```

#10.  
ANSWER  

```
  Test.java, 컴파일된 파일이름은 Test.class, 실행결과는 콘솔로 “This is a Test"가 출력된다. 
```
 
#11. 
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