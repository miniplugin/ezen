package basic;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

/**
 * 클래스와 객체의 관계 및 상속에 대해서 학습(객체의 다형성)
 * @author kimilguk
 * Basic02_ClassMethod.java
 */
//오브젝트생성과 new키워드사용 연습(아래)
class Circle {//클래스 생성 주의, 클래스명 시작문자는 반드시 대문자만 사용한다
	private int r;//멤버변수 반지름 이클래스에서 전연변수
	public Circle(int a) {//메서드중 클래스명과 같은 이름의 메서드를 생성자 라고 한다.
		r = a;//생성자매서드 a인자=매개변수=파라미터 값은 new키워드로 오브젝트 만들어질때 실행
	}
	public double getKimilguk() {
		return r*r*3.14;//원의 넓이를 반환
	}
}

class Dog extends Animal {

	@Override
	public void speak(String name) {
		// TODO Auto-generated method stub
		//super.speak(name);
		System.out.println(name + "는 멍멍");
	}
}
class Cat extends Animal {

	@Override
	public void speak(String name) {
		// TODO Auto-generated method stub
		//super.speak(name);
		System.out.println(name + "는 야용");
	}
	
}
abstract class Animal {
	private String name;
	public abstract void speak(String name);// {
		
	//}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

public class Basic02_ClassMethod {

	public static void main(String[] args) {
		Dog dog = new Dog();//런타임(동적으로)시 힙(Heap)메모리 영역에 생성 / 상수(static) 메모리영역과 비교 
		Cat cat = new Cat();
		//dog.name = "흰둥이";
		//dog.speak(dog.name);
		dog.setName("개");
		dog.speak(dog.getName());
		cat.setName("고양이");
		cat.speak(cat.getName());
		/*
		 * circle은 우리가 지정한 클래스 이름인거고, 
		 * Circle c는 클래스 이름 + c(객체이름-메모리에등록된이름) =  new 클래스네임(반지름값 5) 
		 */
		Circle c = new Circle(5);//인스턴스(오브젝트 클래스)변수 c 생성 new 키워드 생성자circle(반지름값5)
		//위에서 new 키워드는 프로그램 실행공간을 메모리에 새로 할당한다는 이야기 입니다.
		Circle c2 = new Circle(10);
		//Circle클래스를 c 이름으로 prefix해서 사용하는 겁니다.
		//자바프로그램의 특징은 OOP프로그래밍의 대표적인 사례, Object=위 에서 new키워드로 생성한 c 오브젝트,
		//자바에서 OOP 를 사용방식을 설명하는 예, 스프링에서는 new키워드대신 @Autowired를 주로 사용.
		double print_result = c.getKimilguk();
		System.out.println("첫번째 원의 넓이는 " + print_result + " 입니다.");
		double print_result2 = new Circle(10)
				.getKimilguk();//체인방식으로 객체의 메서드를 실행하는 방식(스프링부트에서 주로 사용하는 방식)
		System.out.println("두번째 원의 넓이는 " + print_result2 + " 입니다.");
		//추상클래스란 무엇인지 와 클래스상속 및 메서드 오버라이드사용(아래)
		GraphicObject graphicObject = new Triangle();
		graphicObject.draw();//클래스형 변수명을 지정할때, 카멜표기(낙타등)를 적용.
		System.out.println(Calendar.YEAR+"."+Calendar.MONTH+"."+Calendar.DATE);
		Calendar today = Calendar.getInstance();
        int year = today.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH)+1;//0부터 시작 11까지
        int day = today.get(Calendar.DATE);
        int hour12 = today.get(Calendar.HOUR);
        int hour24 = today.get(Calendar.HOUR_OF_DAY);
        int minute = today.get(Calendar.MINUTE);
        int second = today.get(Calendar.SECOND);
        System.out.println(year+"."+month+"."+day);
        System.out.println(hour12+"."+minute+"."+second);
        //고전적인 Date 클래스와 Calendar 클래스를 사용하지 않고, 아래 최신클래스 사용 
        //자바8부터는 LocalDate + LocalTime = LocalDateTime 사용
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("현재시간 기본형태: "+dateTime);
        String timeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS").format(dateTime);//실제 DB에 저장될 때는 아래값으로 저장된다.
        System.out.println("변환: "+timeFormat);
        //1970년 1월 1일 1부터 현재 까지의 밀리초단위 시간사용(아래)
        Long miliSecond = System.currentTimeMillis();
        System.out.println("타임스템프 기본형태: "+miliSecond);
        Timestamp timestamp = new Timestamp(miliSecond);//현재시간을 이쁘게 변환
        System.out.println("변환: "+timestamp);
        //int[][] intArray = {{10, 20},{30, 40}};
        //기본형 데이터:크기가 고정됨(아래) = 그래픽용어 스칼라데이터
        int[][] intArray = new int[2][2];
        intArray[0][0] = 10;
        intArray[0][1] = 20;
        intArray[1][0] = 30;
        intArray[1][1] = 40;
        System.out.println(Arrays.toString(intArray[0])+"\n"+Arrays.toString(intArray[1]));
        //객체배열 데이터:크기가 유동적(아래) = 그래픽용어 벡터데이터
        ArrayList<Integer[]> aList = new ArrayList<Integer[]>();
        Integer[] integer1 = {10,20};
        Integer[] integer2 = {30,40};
        //... 계속 배열 데이터를 입력할 수 있다. 
        aList.add(integer1);
        aList.add(integer2);
        System.out.println(Arrays.toString(aList.get(0))+"\n"+Arrays.toString(aList.get(1)));
        //제네릭 타입을 사용하는 이유(아래)
        ArrayList addData = new ArrayList();
        addData.add(1);
        addData.add(2);
        System.out.println((int)addData.get(0)+(int)addData.get(1));
	}
}
//추상클래스에 대한 연습(아래)
//추상클래스 또는 인터페이스(스프링에서 주로사용)를 사용하는 목적은 두꺼운책에서 목차를 만드는 것과 똑같은 역할.
abstract class GraphicObject {
	int x, y;//그래픽오브젝트 클래스 멤버번수 선언
	abstract void draw();//명세표만 있고 구현내용이 없는(인터페이스) 추상메서드 선언
	//다른 해석하면, 책에서 목차만 있고, 내용이 없는 구조. 내용은 별도의 클래스에 있음.
}

class Triangle extends GraphicObject {
	//메서드 오버라이드(메서드이름이 같은 것을 상속관계에서 실행)=부모 메서드 재정의, 대표적인 다형성을 구현한 것. 
	@Override//메서드 재정의
	void draw() {
		System.out.println("  *");
		System.out.println(" * * ");
		System.out.println("*****");
	}
}