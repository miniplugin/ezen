//메인 실행 클래스 - main 메서드 작성(아래)
public class OneClass {

	public static void main(String[] args) {
  
		MemberVO m1 = new MemberVO();
		m1.setName("홍길동");
		m1.setAge(45);
		m1.setPhoneNum("000-0000-0000");

		MemberVO m2 = new MemberVO();
		m2.setName("성춘향");
		m2.setAge(100);
		m2.setPhoneNum("111-1111-1111");
    
		MemberVO m3 = new MemberVO();
		m3.setName("각시탈");
		m3.setAge(3);
		m3.setPhoneNum("222-2222-2222");

		MemberVO[] members = new MemberVO[3];
		members[0] = m1;
		members[1] = m2;
		members[2] = m3;
    
		MemberService t = new MemberService();
		t.printMembers(members);
	}
	
}

// 자료형 데이터 클래스(아래)
class MemberVO {

	private String name;
	private int age;
	private String phoneNum;
  
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
}

//서비스 클래스 - 출력용 메서드 작성(아래)
class MemberService {

	public void printMembers(MemberVO[] members) {
		for (MemberVO m : members) {
			System.out.println("------------");
			System.out.println(m.getName());
			System.out.println(m.getAge() + "세");
			System.out.println(m.getPhoneNum());
		}
	}
  
}
