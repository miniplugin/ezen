package miniproject.p03;

public class CardGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] list1 = { "Clubs", "Diamonds", "Hearts", "Spades" };
		String [] list2 = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		
		int matrix[][] = new int[4][13];// 객체 생성시 초기 값은 matrix[0][0] - matrix[3][12] 까지 모두 0으로 초기화 된다.

		for(int i=0;i<5;i++) {
			int k = (int) (Math.random() * 4);
			int m = (int) (Math.random() * 13);

			if( matrix[k][m] == 1 ) continue; //같은 카드와 번호가 나오는 것을 방지한다.
			matrix[k][m] = 1;//한 번 출력된 데이터는 1로 체크값을 준다.
			System.out.println(list1[k] +"의 "+ list2[m]);
		}
	}
}
