package ezen_portfolio.domain;
/**
 * 생성자에서 학정의 필수과목 데이터를 임시 저장하는 클래스
 * @author kimilguk
 *
 */

import java.util.ArrayList;

public class Student {
	private int studentId; //학번
	private String studentName; //학생이름
	private Subject majorSubject; //과목 데이터클래스에서 필수과목
	//실행=호출가능한 객체생성
	private ArrayList<Score> scoreList = new ArrayList<Score>(); //학생이 수강한 과목의 점수 리스트
	
	//학생의 점수데이터 클래스에 학생의 점수가 1개씩 등록된다.(아래)
	public void addSubjectScore(Score score) {
		scoreList.add(score);
	}
	//자동방식으로 생성자 메서드 생성=클래스에 초기값을 바인딩 할 수 있다.
	public Student(int studentId, String studentName, Subject majorSubject) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.majorSubject = majorSubject;
	}
	//자동방식으로 Getter,Setter 메서드 생성
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Subject getMajorSubject() {
		return majorSubject;
	}
	public void setMajorSubject(Subject majorSubject) {
		this.majorSubject = majorSubject;
	}
	public ArrayList<Score> getScoreList() {
		return scoreList;
	}
	public void setScoreList(ArrayList<Score> scoreList) {
		this.scoreList = scoreList;
	}
		
}
