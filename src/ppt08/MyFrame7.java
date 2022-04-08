package ppt08;
import java.awt.*;
import javax.swing.*;

public class MyFrame7 extends JFrame {
	public MyFrame7() {
		setTitle("My Piano");
		setSize(610, 300);
		setLayout(null);		// (1) 

		for(int i=0;i<10;i++) {
			JButton button = new JButton("C"+i);
			button.setLocation(i*60, 100);
			button.setSize(50, 150);
			add(button);
		}
		setVisible(true);
	}
	public static void main(String argv[]) {
		MyFrame f = new MyFrame();
	}
}