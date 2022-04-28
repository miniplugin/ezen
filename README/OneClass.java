/**
 * 아래 코드에서 채점 기준은 본인이 해석한 내용을 코드에 주석으로 정리한 내용이 주요 채점 기준이다.
 * 제출양식은 워드파일이고, 학원에서 제공한다.
 * 제출은 반드시 5월4일 수업시간에 제출해야만 인정된다.
 * @author kimilguk *
 */
//메인 실행 클래스 - main 메서드 작성(아래) 학생: 클래스를 3개로 만드시오.
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

		MemberVO[] members = new MemberVO[3];//배열객체(스칼라값)
		members[0] = m1;
		members[1] = m2;
		members[2] = m3;
		
		//학생:위 배열객체를 ArrayList 배열객체(벡터값)로 변경하시오.
    
		MemberService t = new MemberService();
		t.printMembers(members);
		//학생:위 printMembers 메서드를 오버로드기능으로 추가하시오.
	}
	
}

// 자료형 데이터 클래스(아래)
class MemberVO {

	private String name;
	private int age;
	private String phoneNum;
	
  	//학생: Getter, Setter 메서드 생성(아래)
}

//서비스 클래스 - 출력용 메서드 작성(아래)
class MemberService {

	public void printMembers(MemberVO[] members) {
		for (MemberVO m : members) {
			System.out.println("------------");
			//학생: 출력 메서드 사용(아래)
		}
	}
  
}
