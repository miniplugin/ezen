package miniproject.p03;

import java.util.Scanner;
//Ctrl+Shift+O 를 하면 외부 라이브러리를 자동 임포트 할 수 있다.
public class GuessGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int answer = (int) (Math.random()*100);
		int guess, cnt=0;
		do {
			System.out.print("정답을 추측하여 보시오: ");
			guess = sc.nextInt();
			if(guess>answer) {
				System.out.print("LOW\n");
				cnt++;
			}
			if(guess<answer){
				System.out.print("HIGH\n");
				cnt++;
			}
		}while(guess !=answer);
		System.out.printf("축하합니다. 시도횟수=%d", cnt);
	}

}