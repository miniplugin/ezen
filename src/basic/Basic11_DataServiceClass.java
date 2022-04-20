package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes.Name;

/**
 * 데이터자료형 클래스와 서비스클래스에 대해서 학습(메소드의 다형성)
 * @author kimilguk
 * Basic11_DataServiceClass.java
 */
class MemberVO {//VO는 ValueObject 의 약자로 데이터값만 모아놓은 의미로 개발자가 사용한다.
	//멤버변수 만들기(아래)
	private String name;
	private int age;
	private String phoneNum;
	//멤버변수는 보안때문에 private만들었으나, get,set메서드는 public으로 생성됩니다.
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
	
	@Override
	public String toString() {
		return "디버그용 MemberVO [name=" + name + ", age=" + age + ", phoneNum=" + phoneNum + "]";
	}
	
}

class MemberService {//이 서비스 클래스에서는 회원출력에 관련된 메서드를 모아 놓습니다.(아래)
	public void printMember(MemberVO[] members) {//members는 레코드가 여러개=여러줄
		//서비스 구현메서드 내용(아래) 향상된 for반복문 사용
		int cnt=0;
		for(MemberVO member:members) {//members여러 레코드중 1개의 레코드를 member오브젝트객체로 대입
			cnt = cnt + 1;
			System.out.println(cnt + "번째 레코드는 " + member.toString());
		}
	}
	public void printMember(List<MemberVO> members) {//members는 레코드가 여러개=여러줄
		//서비스 구현메서드 내용(아래) 향상된 for반복문 사용
		int cnt=0;
		for(MemberVO member:members) {//members여러 레코드중 1개의 레코드를 member오브젝트객체로 대입
			cnt = cnt + 1;
			System.out.println(cnt + "번째 레코드는 " + member.toString());
		}
	}
}

public class Basic11_DataServiceClass {

	public static void main(String[] args) {
		// 실행 메서드
	MemberVO memberVO = new MemberVO();//자바 오브젝트 생성하는 방법
	memberVO.setName("홍길동");
	memberVO.setAge(45);
	memberVO.setPhoneNum("000-0000-0000");
	MemberVO memberVO2 = new MemberVO();
	memberVO2.setName("성춘향");
	memberVO2.setAge(18);
	memberVO2.setPhoneNum("111-1111-1111");
	MemberVO memberVO3 = new MemberVO();
	memberVO3.setName("각시탈");
	memberVO3.setAge(28);
	memberVO3.setPhoneNum("222-2222-2222");

	//위 각각 3개의 레코드를 1군데 담을 배열 클래스오브젝트를 하나 생성(아래)
	MemberVO[] memberArray = new MemberVO[3];
	memberArray[0] = memberVO;
	memberArray[1] = memberVO2;
	memberArray[2] = memberVO3;
	System.out.println(memberArray);
	//위 처럼 배열 내에 배열로 처리 할 수도 있으나, 주로 아래 처럼 리스트 클래스를 사용한다.
	List<MemberVO> memberList = new ArrayList<MemberVO>();
	memberList.add(memberVO);
	memberList.add(memberVO2);
	memberList.add(memberVO3);
	//memberList.sort(Collections.reverseOrder());
	memberList.sort(new Comparator<MemberVO>() {

		@Override
		public int compare(MemberVO o1, MemberVO o2) {
			String name1 = o1.getName();
			String name2 = o2.getName();
			return name1.compareTo(name2);//여기를 name1,2를 변경하면 오름차순 -> 내림차순으로 변경됨
		}
	});
	System.out.println(memberList);//기본 내림차순 -> 위 변경 후 오름차순
	//키:값 형태의 데이터베이스 자료와 호환되는 방식
	Map<String,Object> memberMap1 = new HashMap<String,Object>();
	Map<String,Object> memberMap2 = new HashMap<String,Object>();
	Map<String,Object> memberMap3 = new HashMap<String,Object>();
	memberMap1.put("name", "홍길동");
	memberMap1.put("age", 45);
	memberMap1.put("phoneNum", "000-0000-0000");
	memberMap2.put("name", "성춘향");
	memberMap2.put("age", 18);
	memberMap2.put("phoneNum", "111-1111-1111");
	memberMap3.put("name", "각시탈");
	memberMap3.put("age", 28);
	memberMap3.put("phoneNum", "222-2222-2222");
	//List <HashMap<String,Object>> memberMapList = new ArrayList<HashMap<String,Object>>();
	List<Map> memberListMap = new ArrayList<Map>();
	memberListMap.add(memberMap1);
	memberListMap.add(memberMap2);
	memberListMap.add(memberMap3);
	//memberListMap.sort(Collections.reverseOrder());
	memberListMap.sort((Comparator<? super Map>) new Comparator<Map<String, Object>>() {

		@Override
		public int compare(Map<String, Object> o1, Map<String, Object> o2) {
			String name1 = (String) o1.get("name");
			String name2 = (String) o2.get("name");
			return name1.compareTo(name2);//여기를 name1,2를 변경하면 오름차순 -> 내림차순으로 변경됨
		}
		
	});
	System.out.println(memberListMap);//기본 내림차순 -> 위 변경 후 오름차순
	
	MemberService memberService = new MemberService();//자바 오브젝트객체 생성하는 방법\
	//아래처럼 메소드명이 동일하고 로드된 파라미터가 틀린 경우를 메소드 오버로드라고 한다.(메소드의 다형성)
	memberService.printMember(memberArray);//서비스클래스의 메서드호출
	memberService.printMember(memberList);//서비스클래스의 메서드호출
	}

}
