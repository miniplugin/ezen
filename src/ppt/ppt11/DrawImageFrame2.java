package ppt.ppt11;
import javax.swing.*;
import java.awt.*;

public class DrawImageFrame2 extends JFrame {

	Image img;
	int pos_x=100, pos_y=0;


	public DrawImageFrame2() {
		ImageIcon icon = new ImageIcon("./src/ppt/ppt14/car.png");
		img = icon.getImage();
		setSize(500, 200);
		add(new MyPanel(), BorderLayout.CENTER);
		setVisible(true);
		JPanel panel = new JPanel();
		JButton b1 = new JButton("왼쪽으로 이동");
		JButton b2 = new JButton("오른쪽으로 이동");

		b1.addActionListener(e->{ pos_x -= 10; repaint(); });
		b2.addActionListener(e->{ pos_x += 10; repaint(); });
		panel.add(b1); 
		panel.add(b2);
		add(panel, BorderLayout.SOUTH);

	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, pos_x, pos_y, this);
		}

	}
	public static void main(String[] args) {
		DrawImageFrame2 f = new DrawImageFrame2();
	}
}