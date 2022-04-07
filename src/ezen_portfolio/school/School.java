package ezen_portfolio.school;
/**
 * 과목리스트로와 학생리스트로 구성된 1번만 생성되면 되는 싱글톤 학교 빈 데이터 클래스 
 * @author kimilguk
 *
 */

import java.util.ArrayList;

import ezen_portfolio.domain.Student;
import ezen_portfolio.domain.Subject;

public class School {
	private static School instance = new School();//싱글톤에서는 클래스내에 new 객체생성으로 프로그램 실행시 바로 호출 없이 바로 객체가된다.
	private static String SCHOOL_NAME = "Ezen 아카데미";
	private ArrayList<Subject> subjectList = new ArrayList<>();//과목리스트 객체생성
	private ArrayList<Student> studentList = new ArrayList<>();//학생리스트 객체생성
	//학교 초기데이터 클래스에 학생 1명이 추가된다.(아래)
	public void addStudent(Student student) {
		studentList.add(student);
	}
	//학교 초기데이터 클래스에 과목 1개가 추가된다.(아래)
	public void addSubject(Subject subject) {
		subjectList.add(subject);
	}
	//학교 초기데이터에 과목리스트를 저장한다.
	public void setSubjectList(ArrayList<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	//자동방식으로 생성자 메서드 생성=클래스에 초기값을 바인딩 할 수 있다.
	public School() {
	}	
	//자동방식으로 Getter 메서드 생성(싱글톤 클래스는 1번 등록 후 외부에서 가져다 사용하는 역할이기 때문에)
	public static School getInstance() {
		if(instance == null) {instance = new School();}//이 코드 때문에 항상 1개만 호출된다.
		return instance;
	}
	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	
}
