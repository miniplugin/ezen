package miniproject.p05;

import java.util.Scanner;

//Ctrl+Shift+O 를 하면 외부 라이브러리를 자동 임포트 할 수 있다.
class User {
	String userId, password;
	static int count;

	public User(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
}

public class UserTest {
	public static void main(String args[]) {
		User[] list = new User[100];
		Scanner scanner = new Scanner(System.in);
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
			}
		}
	}
}