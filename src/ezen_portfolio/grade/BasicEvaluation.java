package ezen_portfolio.grade;
/**
 * 일반과목일때 점수로 등급을 평가하는 구현클래스
 * @author kimilguk
 *
 */
public class BasicEvaluation implements GradeEvaludation {

	@Override
	public String getGrade(int point) {
		String grade;
		if(point <= 100 && point >= 90) {grade = "A";}
		else if(point >= 80) {grade = "B";}
		else if(point >= 70) {grade = "C";}
		else if(point >= 55) {grade = "D";}
		else {grade = "F";}
		return grade;
	}

}
