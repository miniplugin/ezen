package ezen_portfolio.domain;
/**
 * 생성자에서 학생의 점수 데이터를 임시 저장하는 클래스.
 * @author kimilguk
 *
 */
public class Score {
	private int studentId; //학번
	private Subject subject; //과목
	private int point; //점수
	//자동방식으로 생성자 메서드 생성=클래스에 초기값을 바인딩 할 수 있다.
	public Score(int studentId, Subject subject, int point) {
		this.studentId = studentId;
		this.subject = subject;
		this.point = point;
	}
	//자동방식으로 Getter,Setter 메서드 생성
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
}
