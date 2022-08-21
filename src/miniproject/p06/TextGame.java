package miniproject.p06;

import java.util.Scanner;

//Ctrl+Shift+O 를 하면 외부 라이브러리를 자동 임포트 할 수 있다.
abstract class Sprite { //스피릿은 게임에서 스테이지에 등장하는 총알, 비행기, 자동차등의 개릭터를 말한다.
	int x=3, y=3;
	abstract void move(char c);
}
class Mine extends Sprite {
	@Override
	void move(char c){ 
		if( c == 'l' ) --x;
		else if( c == 'r' ) ++x;
		else if( c == 'u' ) --y;
		else if( c == 'd' ) ++y;
	}
}
class Gold extends Sprite {
	public Gold() {
		x = 3;
		y = 6;
	}
	@Override
	void move(char c){ 	}
}
class Monster extends Sprite {
	public Monster() {
		x = y = 7;
	}
	@Override
	void move(char c){ 
		x += (Math.random()-0.5)>0? 1: -1;
		y += (Math.random()-0.5)>0? 1: -1;
	}
}
public class TextGame {

    public static void main(String[] args) {
    	char[][] map = { //2차원 [좌]표 배열
    			{ '#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#' }, 
    			{ '#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#' }, 
    			{ '#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#' }, 
    			{ '#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#' }, 
    			{ '#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#' }, 
    			{ '#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#' }, 
    			{ '#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#' }, 
    			{ '#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#' }, 
    			{ '#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#' }, 
    			{ '#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#' }, 
    	};
        Scanner sc = new Scanner(System.in);
        Mine mine;
        Monster monster;
        Gold gold;
        mine = new Mine();
        monster = new Monster();
        gold = new Gold();
        while (true) {
            for(int y=0;y<map.length;y++) {//중첩 for문으로 [좌]표형태의 데이터를 출력한다.
                for(int x=0;x<map[y].length;x++) {
                	if( y == monster.y && x == monster.x )	
                    	System.out.print('M');
                	else if( y == mine.y && x == mine.x )	
                    	System.out.print('@');
                	else if( y == gold.y && x == gold.x )	
                    	System.out.print('G');
                	else
                		System.out.print(map[y][x]);
                }
            	System.out.println();
            }
        	System.out.print("왼쪽(l), 위쪽(u), 아래쪽(d), 오른쪽(r): ");
        	char c = sc.next().charAt(0);    
            mine.move(c);
            monster.move(c);
        }
    }
}
