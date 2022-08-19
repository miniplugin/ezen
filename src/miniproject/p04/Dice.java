package miniproject.p04;

public class Dice {

	private int value;
	/* 생성자 메서드가 없어도 컴파일 시 자동 생성 되고, new 키워드로 객체 생성 시 value 값이 0으로 초기화 된다.
	public Dice() {
		value = 0;
	}
	*/
	public void roll() { //주사위 굴리기 메서드 구현코드
		value = (int) (Math.random() * 6) + 1;//랜덤 함수가 0부터 시작하기 때문에 +1 처리
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	public static void main(String[] args) {

		Dice dice1, dice2;
		int rollCount;

		dice1 = new Dice();
		dice2 = new Dice();
		rollCount = 0;

		do {
			dice1.roll();
			dice2.roll();
			System.out.println("주사위1= " + dice1.getValue() + " 주사위2= " + dice2.getValue());
			rollCount++;
		} while ((dice1.getValue() + dice2.getValue()) != 2);

		System.out.println("(1, 1)이 나오는데 걸린 횟수= " + rollCount);

	}

} 
