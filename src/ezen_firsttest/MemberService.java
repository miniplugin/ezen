package ezen_firsttest;
/**
 * 서비스 클래스 - 출력용 메서드 기능의 클래스
 * @author kimilguk
 *
 */
public class MemberService {

	public void printMembers(MemberVO[] members) {
		for (MemberVO m : members) {
			System.out.println("------------");
			System.out.println(m.getName());
			System.out.println(m.getAge() + "세");
			System.out.println(m.getPhoneNum());
		}
	}
  
}