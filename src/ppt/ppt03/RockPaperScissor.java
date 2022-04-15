package ppt.ppt03;

import java.util.Scanner;

/**
 *                       컴퓨터			
 *                  가위(0)  	 바위(1)    보(2)
 *	사용자 	가위(0)           0 1(컴)    0 2(사)
            바위(1)   1 0(사)            1 2(컴)
             보(2)   2 0(컴)  2 1(사)         
   비교조건(3가지)
    1. 비겼습니다.
    2. 컴퓨터가 이겼습니다.
    3. 사용자가 이겼습니다.
   실행예) 사용자가 이길 경우(아래)
   0 2 -> (computer+1)%3 == user
   1 0 -> (computer+1)%3 == user
   2 1 -> (computer+1)%3 == user
 * @author 402_S
 *
 */
public class ScissorRockPaper {
	//클래스변수(전역,멤버)
	final static String SCISSOR = "가위(0)";//상수변수를 만들 때 final static 한 쌍으로 사용.
	final static String ROCK = "바위(1)";
	final static String PAPER = "보(2)";

	public static void main(String[] args) {
		//입력 인터페이스 객체생성
		Scanner input = new Scanner(System.in);
		System.out.print(SCISSOR + " " + ROCK + " " + PAPER + " 중 한가지 숫자로 입력하세요.");
		int user = input.nextInt();//사용자 값 숫자로 저장
		//컴퓨터가 내는 숫자
		int computer = (int) (Math.random() * 3);
		//조건문 시작
		if(user == computer) {//비겼을 경우 구현내용
			System.out.println("컴퓨터는 " + result(computer) + " 사용자는 " + result(user) + " 로 비겼습니다.");
		} else if((computer+1)%3 == user) { //컴퓨터가 이겼을 경우 구현내용
			System.out.println("컴퓨터는 " + result(computer) + " 사용자는 " + result(user) + " 로 사용자가 이겼습니다.");
		} else {//사용자가 이겼을 경우 구현내용
			System.out.println("컴퓨터는 " + result(computer) + " 사용자는 " + result(user) + " 로 컴퓨터가 이겼습니다.");
		}
		
		input.close();//프로그램의 메모리 최적화 시키는 코드
	}

	private static String result(int computer) {
		// 개발자가 숫자를 문자로 변경해서 리턴하는 메서드를 구현한다.
		String result = "";
		switch (computer) {
		case 0:
			result = SCISSOR;
			break;
		case 1:
			result = ROCK;
			break;
		case 2:
			result = PAPER;
			break;
		default:
			result = "아무것도 선택하지 않았습니다.";
			break;
		}
		
		return result;
	}

}
