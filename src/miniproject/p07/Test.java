package miniproject.p07;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

//Ctrl+Shift+O 를 하면 외부 라이브러리를 자동 임포트 할 수 있다.
public class Test {
	static String solution;

	static boolean check(String s, StringBuffer a, char ch) {
		int i;

		for (i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ch)
				a.setCharAt(i, ch);
		}
		for (i = 0; i < s.length(); i++)
			if (s.charAt(i) != a.charAt(i))
				return false;
		return true;
	}

	public static void main(String[] args) throws IOException {
		char ch;
		Scanner sc = new Scanner(System.in);
		String[] words = { "java", "count", "school", "book", "student", "programmer" };
		int index = (new Random()).nextInt(words.length);
		solution = words[index];
		StringBuffer answer = new StringBuffer(solution.length());
		for (int i = 0; i < solution.length(); i++)
			answer.append(' ');
		for (int i = 0; i < solution.length(); i++) {
			if (solution.charAt(i) != ' ')
				answer.setCharAt(i, '_');
		}

		while (true) {
			// System.out.println("현재의 상태: " + solution);
			System.out.println("현재의 상태: " + answer);
			System.out.printf("글자를 추측하시오: ");
			String c = sc.next();
			if (check(solution, answer, c.charAt(0)) == true)
				break;
		}
		System.out.println("현재의 상태: " + answer);
	}
}