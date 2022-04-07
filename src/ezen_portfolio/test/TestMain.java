package ezen_portfolio.test;
/**
 * 학생,과목,점수 등을 각각 입력하고, 리포트 클래스를 생성하여 학점과 등급을 출력하는 실행 클래스
 * @author kimilguk
 *
 */

import ezen_portfolio.config.Define;
import ezen_portfolio.domain.Score;
import ezen_portfolio.domain.Student;
import ezen_portfolio.domain.Subject;
import ezen_portfolio.school.School;
import ezen_portfolio.school.report.GenerateReport;

public class TestMain {
	//멤버변수 선언
	School ezenAcademy = School.getInstance();//ezen 아카데미 학교객체 생성
	Subject korean;//국어과목 생성
	Subject math; //수학과목 생성
	GenerateReport generateReport = new GenerateReport();//레포트객체생성
	public static void main(String[] args) {
		TestMain test = new TestMain();
		test.createSubject(); //과목데이터 입력
		test.createStudent();//학생데이터 입력
		String report = test.generateReport.getReport();
		System.out.println(report);
	}
	private void createStudent() {
		//학번, 이름, 필수과목 등록
		Student student1 = new Student(2201, "강감찬", korean);
		Student student2 = new Student(2202, "김유신", math);
		Student student3 = new Student(2203, "이순신", korean);
		Student student4 = new Student(2204, "홍길동", math);
		//ezenAcademy에 학생추가
		ezenAcademy.addStudent(student1);
		ezenAcademy.addStudent(student2);
		ezenAcademy.addStudent(student3);
		ezenAcademy.addStudent(student4);
		//국어과목을 수강하는 학생등록
		korean.register(student1);
		korean.register(student2);
		korean.register(student3);
		korean.register(student4);
		//수학과목을 수강하는 학생등록
		math.register(student1);
		math.register(student2);
		math.register(student3);
		math.register(student4);
		//점수등록
		addScore(student1, korean, 95);
		addScore(student1, math, 56);
		addScore(student2, korean, 95);
		addScore(student2, math, 95);
		addScore(student3, korean, 89);
		addScore(student3, math, 95);
		addScore(student4, korean, 85);
		addScore(student4, math, 56);
	}
	
	private void addScore(Student student, Subject subject, int i) {
		// 과목별 점수를 추가
		Score score = new Score(student.getStudentId(), subject, i);
		student.addSubjectScore(score);
	}
	private void createSubject() {
		//과목등록 후 과목리스트에 추가
		korean = new Subject("국어", Define.KOREA);
		math = new Subject("수학", Define.MATH);
		ezenAcademy.addSubject(korean);
		ezenAcademy.addSubject(math);
	}

}
