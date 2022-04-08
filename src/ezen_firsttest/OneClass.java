package ezen_firsttest;


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
