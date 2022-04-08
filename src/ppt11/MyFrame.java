package ppt11;
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

	class MyPanel extends JPanel {
		protected void paintComponent(Graphics g) {		// (1)
			super.paintComponent(g);	
			g.drawOval(60, 50, 60, 60);					// (2)
			g.drawRect(120, 50, 60, 60);				// (3)
			g.setColor(Color.BLUE);
			g.fillOval(180, 50, 60, 60);
			g.fillRect(240, 50, 60, 60);
		}
	}

	public MyFrame() {
		setTitle("Basic Painting");
		setSize(600, 200);
		add(new MyPanel());
		setVisible(true);
	}

	public static void main(String[] args) {
		MyFrame f = new MyFrame();
	}
}