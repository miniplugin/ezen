- 자료출처: Power Java Compact(출판사:인피니트 북스, 저자:천인국)

## Exercise
#1.자바에서 입력과 출력을 담당하는 패키지는?
ANSWER  

```
(1)java.input (2)java.io (3)java.output (4)java.file
-답변: ② java.io
```

#2.문자 입력을 담당하는 가장 기본적인 추상 클래스 이름은 무엇인가?
ANSWER  

```
(1)InputStream (2)OutputStream (3)Reader (4)Writer
-답변: ③ InputStream
```

#3.FileWriter 생성자에 잘못된 파일 이름이 전달되면 어떻게 되는가?
ANSWER 

``` 
(1)그대로 계속된다. (2)사용자 디스크기 손상된다. (3)생성자가 null 값을 반환한다. (4)IOException이 발생한다.
-답변: ④ IOException이 발생한다.
```

#4.다음과 같은 파일을 읽을 때 가장 적합한 스트림 클래스는 무엇일까?
ANSWER  

``` 
(1) 이미지 파일: FileInputStream
(2) 메모장 파일(텍스트파일): FileReader
(3) mp3 파일: FileInputStream
(4) HTML 파일: FileReader
```

#5.다음 문장은 올바르게 컴파일되는가?

```
File file = new File("test.txt");
FileReader in = new FileReader(file);
```
ANSWER  
 예외를 처리해주어야 한다. 

```
File file = new File("test.txt");
try {
	FileReader in = new FileReader( file );
} catch (FileNotFoundException e) {
	e.printStackTrace();
}
```

#6.텍스트 파일을 읽으려고 한다. 느린전송속도에 따른 처리속도의 저하를 막기 위하여 버퍼를 사용하려고 한다.
어떤 스트림 클래스를 어떻게 연결하여야 하는가?
ANSWER  

```
 BufferedReader in = new BufferedReader(new FileReader(new File("sample-file.txt")));
```

#7.다음은 텍스트 파일을 읽는 문장이다. 만약 디스크에 파일이 없다면 에러가 발생한다.
예외는 try-catch 구조를 사용하여 처리할 수 있다. 아래의 문장 예외가 처리되도록 코드를 추가해보자.

```
FileReader fr = new FileReader("./src/test.txt");
```
ANSWER  

```
try {
	FileReader fr = new FileReader("./src/test.txt");
} catch (FileNotFoundException e) {
	e.printStackTrace();
}
```

#8.자동차를 나타내는 Car 클래스가 정의되어 있다고 가정하자.
ANSWER  

```
(1) 참조(매개) 변수 myCar가 가리키는 Car 객체를 직렬화하여서 파일 Car.obj에 데이터를 저장하는 문장을 작성하시오.
-답변: FileInputStream in = new FileInputStream("Car.obj") ;
   ObjectOutputStream o = new ObjectOutputStream(in);
   o.wirteObject(myCar);
(2) 파일 Car.obj에 저장된 객체를 역직렬화하여서 복원하는 문장을 작성하시오.
-답변: FileInputStream in = new FileInputStream("Car.obj");
  ObjectInputStream o = new ObjectInputStream(in);
  Car myCar = (Car)o.readObject();
```

## Program Exercise
#1.   
ANSWER

```
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test
{ 
      
	public static void main(String[] args) throws IOException {
		File file1 = new File("d://input.txt");
		File file2 = new File("d://output.txt"); 
		char CharCounter = 0;       
		BufferedReader in = (new BufferedReader(new FileReader(file1)));
		PrintWriter out = (new PrintWriter(new FileWriter(file2)));
		int ch;
		while ((ch = in.read()) != -1)
		{
		   if (Character.isLowerCase(ch))  {
		        ch=Character.toUpperCase(ch);// convert assign variable
		   }
		out.write(ch);
		}
		in.close();
		out.close();
	}
}
```

#2.   
ANSWER

```
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			FileReader fr = new FileReader("input.txt");
			BufferedReader br = new BufferedReader(fr);
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				int value = Integer.parseInt(line);
				list.add(value);
			}
			fr.close();
			Collections.sort(list);
			FileWriter fr1 = new FileWriter("output.txt");
			PrintWriter br1 = new PrintWriter(fr1);
			for (int k = 0; k < list.size(); k++) {
				br1.println(list.get(k));
			}
			br1.flush();
			fr1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
```

#3.   
ANSWER

```
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("d://input.txt");
			BufferedReader br = new BufferedReader(fr);
			FileWriter fr1 = new FileWriter("d://output.txt");
			PrintWriter br1 = new PrintWriter(fr1);
			int counter = 0;
			while (true) {
				counter++;
				String line = br.readLine();
				if (line == null)
					break;
				br1.println(""+counter+":"+line);
				System.out.println(""+counter+":"+line);
			}
			fr.close();
			br1.flush();
			fr1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
```

#4.   
ANSWER

```
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		boolean equal=true;
			FileInputStream fr1 = new FileInputStream("d://input1.txt");
			FileInputStream fr2 = new FileInputStream("d://input2.txt");
			while (true) {
				try {
					byte c1 = (byte) fr1.read();
					byte c2 = (byte) fr2.read();
					if( c1 ==-1 || c2==-1 )
							break;
					if( c1 != c2 ){
						equal = false;
						break;
					}
				} catch (IOException e) {
					break;
				}
			}
			if( equal==true)
				System.out.println("2개의 파일이 일치합니다.");
			else 
				System.out.println("2개의 파일이 일치하지 않습니다.");
			try {
				fr1.close();
				fr2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
```

#5.   
ANSWER

```
// 소스를 입력하고 Ctrl+Shift+O를 눌러서 필요한 파일을 포함한다. 
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
		BufferedReader in = null;
		String[] words = new String[100];
		int count = 0;

		in = new BufferedReader(new FileReader("sample.txt"));
		for (int i = 0; i < 100; i++) {
			String s = in.readLine();
			if (s == null)
				break;
			words[i] = s;
			count++;
		}
		int index = (new Random()).nextInt(count);
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
```

#6.   
ANSWER

```
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Test
{ 
   private static byte key=(byte) 0x88; 
   public static void encrypt(String inFile, String outFile) throws FileNotFoundException, IOException 
   { 
      try (InputStream in = new FileInputStream(inFile);
				OutputStream out = new FileOutputStream(outFile)) {
      { 
         boolean done = false; 
         while (!done)          { 
            int next =in.read();
            if (next == -1) done = true; 
            else { 
               byte b = (byte) next; 
               byte c = (byte)(b ^ key);
               out.write(c); 
            } 
         } 
      }
      }
   }
   
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.print("원본 파일 이름을 입력하시오: ");

		String inputFileName = scan.next();
		System.out.print("암호 파일 이름을 입력하시오: ");
		String outputFileName = scan.next();
		encrypt(inputFileName, outputFileName);
	}
}
```

#7.   
ANSWER

```
import java.io.*;
import java.util.*;
public class UserInform {
	public static void main(String[] args)throws IOException{
		int num2;
		String search;
		String  num, name, tel, email;
		Scanner scan = null;
		PrintWriter in = new PrintWriter(new FileWriter("user.txt"));
		Scanner s = new Scanner(System.in);
		while(true){
			System.out.println("사용자 번호를  입력하세요 ");
			num = s.next();
			System.out.println("사용자 이름을  입력하세요 ");
			name = s.next();
			System.out.println("사용자 전화번호를  입력하세요 ");
			tel = s.next();
			System.out.println("사용자 이메일을  입력하세요 ");
			email= s.next();
			System.out.println("입력이 끝났으면 1 계속입력하시려면 0");
			num2 = s.nextInt();
			in.print(num + "," + name + "," + tel + "," + email+"");
			in.flush();
			if(num2 == 1)
				break;
		}
		System.out.println("검색하실 사용자 번호를 입력하세요");
		num2 = s.nextInt();
		search = num2+"";
		scan = new Scanner(new BufferedReader(new FileReader("user.txt")));
		scan.useDelimiter(",");
		while(scan.hasNext()){
			num = scan.next();
			name = scan.next();
			tel = scan.next();
			email = scan.next();
			if(num.equals(search))
				System.out.println("사용자 번호 "+num2+"의 전화번호는"+tel +"입니다.");
		}
		if(in!= null)
			in.close();
		if(scan !=null)
			scan.close();		
	}
}
```