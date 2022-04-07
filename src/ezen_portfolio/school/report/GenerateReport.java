package ezen_portfolio.school.report;
/**
 * 결과를 출력할 서식을 만드는 클래스
 * @author kimilguk
 *
 */

import java.util.ArrayList;

import ezen_portfolio.config.Define;
import ezen_portfolio.domain.Score;
import ezen_portfolio.domain.Student;
import ezen_portfolio.domain.Subject;
import ezen_portfolio.grade.BasicEvaluation;
import ezen_portfolio.grade.GradeEvaludation;
import ezen_portfolio.grade.MajorEvaluation;
import ezen_portfolio.school.School;

public class GenerateReport {
	School school = School.getInstance();//학교 데이터가 들어있는 객체생성
	public static final String TITLE = " 과목 등급\t\t\n"; //타이틀 앞에 과목명이 붙을 예정
	public static final String LINE = "--------------------------------------\n";
	public static final String HEADER = " 이름 |  학번  |   전공   |필수과목| 점수 |등급\n";
	
	private StringBuffer buffer = new StringBuffer(); //문자열 임시 저장용 객체
	
	public String getReport() {
		ArrayList<Subject> subjectList = school.getSubjectList(); //과목리스트 객체 생성
		for(Subject subject:subjectList) {
			makeHader(subject); //레포트 상단 내용 버퍼에 저장
			makeBody(subject); //과목별 score의 과목아이디를 기준으로 등급결과 출력
			makeFooter(); //레포트 하단 내용 버퍼에 저장
		}
		return buffer.toString();
	}

	private void makeFooter() {
		buffer.append("\n");		
	}

	private void makeBody(Subject subject) {
		ArrayList<Student> studentList = subject.getStudentList();//반목문에서 해당과목을 수강한 학생리스트
		for(Student student:studentList) {
			buffer.append(student.getStudentName()); //학생이름
			buffer.append(" | "); 
			buffer.append(student.getStudentId()); //학번
			buffer.append(" | ");
			switch(student.getMajorSubject().getSubjectId()) {//전공출력
				case Define.KOREA: 
					buffer.append("국어국문학과");
					break;
				case Define.MATH:
					buffer.append("컴퓨터공학과");
					break;
				default: buffer.append("전공미지정");
			}
			buffer.append(" | ");
			buffer.append(student.getMajorSubject().getSubjectName()); //학생의 필수과목명 출력
			buffer.append(" | ");
			getScoreAndGrade(student ,subject.getSubjectId());//학생별 수강과목 학점과 등급계산
			buffer.append("\n");
		}
	}

	
	private void getScoreAndGrade(Student student, int subjectId) {
		//평가 구현 객체 생성, 2개 라서 객체 배열로 생성
		GradeEvaludation[] gradeEvaludations = {new BasicEvaluation(), new MajorEvaluation()};
		ArrayList<Score> scoreList = student.getScoreList();//student 에서 선택된 학생의 점수리스트
		int majorId = student.getMajorSubject().getSubjectId();//student 에서 학생의 필수과목 Id
		//위 점수리스트의 1과목Id와 타이틀과목의 subjectId 비교해서 타이클Id의 과목만 출력 1차 조건으로 = 1과목 점수만 출력
		for(Score score:scoreList) {
			if(subjectId == score.getSubject().getSubjectId()) {//1과목 점수만 출력
				String grade; //등급저장용 변수
				if(majorId == score.getSubject().getSubjectId()) {//현재점수가 필수과목 점수라면
					grade = gradeEvaludations[Define.SAB_TYPE].getGrade(score.getPoint());
				}else {
					grade = gradeEvaludations[Define.AB_TYPE].getGrade(score.getPoint());
				}
				buffer.append(score.getPoint());//점수출력
				buffer.append(" | ");
				buffer.append(grade);
			}
		}
		
	}

	private void makeHader(Subject subject) {
		buffer.append("\t      " + subject.getSubjectName()); //과목이름
		buffer.append(GenerateReport.TITLE);
		buffer.append(GenerateReport.LINE);
		buffer.append(GenerateReport.HEADER);
	}
}
