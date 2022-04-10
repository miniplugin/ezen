package ppt.ppt11;
import javax.swing.*;
import java.awt.*;

public class DrawImageFrame extends JFrame {

	Image img;

	public DrawImageFrame() {
		ImageIcon icon = new ImageIcon("./src/ppt/ppt14/car.png");
		img = icon.getImage();				// 이미지 아이콘 객체에서 이미지를 추출한다. 
		setSize(500, 200);
		add(new MyPanel());
		setVisible(true);
	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this);	// 이미지를 화면의 원점에 그린다. 
		}
	}

	public static void main(String[] args) {
		DrawImageFrame f = new DrawImageFrame();
	}
}