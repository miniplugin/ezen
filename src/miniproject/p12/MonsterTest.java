package miniproject.p12;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
//Ctrl+Shift+O 를 하면 외부 라이브러리를 자동 임포트 할 수 있다.
public class MonsterTest extends JPanel {
	ArrayList<Monster> monsters = new ArrayList<Monster>();

	public MonsterTest() {
		for (int i = 0; i < 20; i++)
			monsters.add(new Monster((int) (Math.random() * 600), (int) (Math.random() * 400), 100));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Monster m : monsters)
			m.draw(g);
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(600, 400);
		f.setTitle("Monster Catch Game");
		f.add(new MonsterTest());
		f.setVisible(true);
	}
}

class Monster {
	int x, y, hp;
	Image img;

	Monster(int x, int y, int hp) {
		this.x = x;
		this.y = y;
		this.hp = hp;
		ImageIcon icon = new ImageIcon("./src/miniproject/p12/alien.png");
		img = icon.getImage();
	}

	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}
}