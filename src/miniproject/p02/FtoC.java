package miniproject.p02;

import java.util.Scanner;
//Ctrl+Shift+O 를 하면 외부 라이브러리를 자동 임포트 할 수 있다.
public class FtoC {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("화씨온도를 입력하시오: ");
		double f = sc.nextDouble();
		double c_temp;
		c_temp = 5.0/9.0 *(f-32.0);
		System.out.println("섭씨온도는 "+c_temp);
	}
}
