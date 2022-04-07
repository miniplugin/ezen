package ezen_portfolio.domain;
/**
 * 생성자에서 과목의 평가조건 데이터를 임시 저장하는 클래스 국어,수학이 들어간다.
 * @author kimilguk
 *
 */

import java.util.ArrayList;

import ezen_portfolio.config.Define;

public class Subject {
	private String subjectName; //과목이름
	private int subjectId; //과목 고유 번호
	private int gradeType; //학점 평가 정책 2가지 경우(일반과목, 필수과목)
	//객체생성(아래)
	private ArrayList<Student> studentList = new ArrayList<Student>(); //이 과목을 수강한 학생 리스트 
	//과목데이터 클래스에 수강한 학생 1명이 추가된다.(아래)
	public void register(Student student) {
		studentList.add(student);
	}
	//자동방식으로 생성자 메서드 생성=클래스에 초기값을 바인딩 할 수 있다.
	public Subject(String subjectName, int subjectId) {
		this.subjectName = subjectName;
		this.subjectId = subjectId;
		//this.gradeType = Define.AB_TYPE; //학점 평가 정책초기값은 AB방식을 사용한다.
	}
	//자동방식으로 Getter,Setter 메서드 생성
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public int getGradeType() {
		return gradeType;
	}
	public void setGradeType(int gradeType) {
		this.gradeType = gradeType;
	}
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
		
}
