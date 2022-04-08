package ppt08;
import javax.swing.*;
import java.awt.FlowLayout;

public class MyFrame1 extends JFrame {
       public MyFrame1() {
             setSize(300, 200);
             setTitle("MyFrame");

             setLayout(new FlowLayout());		// (1)
             JButton button = new JButton("버튼");	// (2)
             add(button);				// (3)
             setVisible(true);
       }
       public static void main(String[] args) {
             MyFrame f = new MyFrame();
       }
}