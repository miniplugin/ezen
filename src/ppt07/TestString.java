package ppt07;
public class TestString {
	public static void main(String[] args) {
		String s1 = new String("Kim");
		String s2 = new String("Kim");
		if( s1.equals(s2) == true )
			System.out.println("동일한 문자열입니다.");
		else 
			System.out.println("동일한 문자열이 아닙니다.");
	}
}