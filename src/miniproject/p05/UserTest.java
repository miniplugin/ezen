package miniproject.p05;

import java.util.Scanner;

//Ctrl+Shift+O 를 하면 외부 라이브러리를 자동 임포트 할 수 있다.
class User {
	String userId, password; //Hip힙 메모리 영역의 변수는 객체를 생성 후 객체의 도트연산자로 접근이 불가능하다. 보안 때문에 보통 사용하지 않는다.
	static int count; //스태틱 메모리 영역의 변수는 객체생성 없이 클래스의 도트연산자로 직접 접근이 가능하다. 보안 때문에 보통 사용하지 않는다.

	public User(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
}

public class UserTest {
	public static void main(String args[]) {
		User[] list = new User[100];
		Scanner scanner = new Scanner(System.in);
		//Loop:
		while (true) {
			System.out.println("====================================");
			System.out.println("1. Sign Up");
			System.out.println("2. Login");
			System.out.println("3. Print All Users");
			System.out.println("4. Exit");
			System.out.println("====================================");
			System.out.print("번호를 입력하시오: ");
			int menu = scanner.nextInt();
			switch (menu) {
			case 1:
				System.out.print("Id: ");
				String id = scanner.next();
				System.out.print("Password: ");
				String password = scanner.next();
				list[User.count] = new User(id, password);
				User.count++;
				break;
			case 3:
				for (int i=0;i<User.count; i++)
						System.out.println("{ " + list[i].userId + ", " + list[i].password + " }");
				break;
			case 4:
				System.exit(0);//또는 break Loop; 처럼 반복문 상단에 라벨 이름으로 종료 할 수 잇다.
				break;
			}
		}
	}
}
