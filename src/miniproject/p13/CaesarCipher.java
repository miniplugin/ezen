package miniproject.p13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Ctrl+Shift+O 를 하면 외부 라이브러리를 자동 임포트 할 수 있다.
public class CaesarCipher {
	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("./src/miniproject/p13/input.txt");
		BufferedReader br = new BufferedReader(fr);
		String plaintext = br.readLine();

		System.out.println(CaesarCipher.encode(plaintext, 3));
		System.out.println(CaesarCipher.decode(
				CaesarCipher.encode(plaintext, 3), 3));
		fr.close();
	}

	// 아래 코드는 http://rosettacode.org/wiki/Caesar_cipher에서 가져왔습니다. 
	public static String decode(String enc, int offset) {
		return encode(enc, 26 - offset);
	}

	public static String encode(String enc, int offset) {
		offset = offset % 26 + 26;
		System.out.println((byte)'A');//일반문자를 아스키문자로 변환
		System.out.println('A' + ('A' - 'A' + offset) % 26);
		System.out.println((char)('A' + ('A' - 'A' + offset) % 26));
		StringBuilder encoded = new StringBuilder();
		for (char i : enc.toCharArray()) {
			if (Character.isLetter(i)) {
				if (Character.isUpperCase(i)) {
					encoded.append((char) ('A' + (i - 'A' + offset) % 26));
				} else {
					encoded.append((char) ('a' + (i - 'a' + offset) % 26));
				}
			} else {
				encoded.append(i);
			}
		}
		return encoded.toString();
	}
}
