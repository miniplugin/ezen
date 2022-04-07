package ezen_portfolio.grade;
/**
 * 학점으로 등급을 구하는 인터페이스 -> 일반과목, 필수과목으로 구현한다(자동방식으로).
 * @author kimilguk
 *
 */
public interface GradeEvaludation {
	public String getGrade(int point);
}
