# 자바 프로그래밍 과정 by 김일국 강사

### 문제해결 시나리오형 문제

2.1 교사가 제시한 1개 자바 파일을 아래 보기처럼 출력되게 수정한다.
- 수정할 소스 파일위치: https://github.com/miniplugin/ezen/blob/main/README/OneClass.java
- 아래처럼 출력 되도록 프로그램 작성. (단, 이름은 본인 이름이 나오도록 변경하시오.)

```
------------
홍길동
45세
000-0000-0000
------------
성춘향
100세
111-1111-1111
------------
각시탈
3세
222-2222-2222
```

2.2. 위 1개의 파일을 3개의 클래스파일로 분리한다.(아래)
- MainControler(main함수), MemberVO(String name,int age,String phoneNum필드), MemberService(printMembers매서드)
- 클래스설계: 여러명의 회원 정보(MemberVO)를 전달받고(MainControler), 출력(MemberService)하는 메소드 선언하기.

2.3. 작업 시 발생한 오류메시지 1가지 이상과 해결사항을 기록하고 정상실행결과를 이미지로 캡쳐 해서 붙여 넣는다.
