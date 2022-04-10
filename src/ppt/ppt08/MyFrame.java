package ppt.ppt08;
import javax.swing.*;					// (1)
public class MyFrame extends JFrame { 	// (2)
       public MyFrame() {					// (3)
             setSize(300, 200);
             setTitle("MyFrame");
             setVisible(true);
       }
       public static void main(String[] args) {
             MyFrame f = new MyFrame();	// (4)
       }
}