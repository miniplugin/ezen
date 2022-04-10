## Excercise
#1.  
ANSWER  

```
 MyFrame f = new MyFrame();
```

#2.  
ANSWER  

```
   public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(300, 150);
		f.setTitle("MyFrame");
		f.setVisible(true);
   }
```

#3.  
ANSWER  

```
 setLayout(new GridLayout(3, 4));
```

## Program Exercise
#1.  
ANSWER  

```
import java.awt.*;
import javax.swing.*;
public class MyFrame extends JFrame{
	public MyFrame(){
		setSize(400,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("My Frame");
		JPanel panel = new JPanel();
		JLabel label = new JLabel("자바는 재미있나요?");
		JButton button1 = new JButton("Yes");
		JButton button2 = new JButton("No");
		panel.add(label);
		panel.add(button1);
		panel.add(button2);
		add(panel);
		setVisible(true);
	}
	public static void main(String[] args){
		MyFrame f = new MyFrame();
	}
}
```

#2.  
ANSWER  

```
import java.awt.*;
import javax.swing.*;
 
public class MyFrame extends JFrame {
   private Label lblCount;  
   private TextField tfCount;  
   private Button btnCount;  
 
   public MyFrame () {
      setLayout(new FlowLayout());
      lblCount = new Label("카운터값");
      add(lblCount);                    
 
      tfCount = new TextField("0", 10); 
      tfCount.setEditable(false);      
      add(tfCount);                     
 
      btnCount = new Button("증가"); 
      add(btnCount);                    
 
      setTitle("My Frame"); 
      setSize(400, 150);     
      setVisible(true); 
   }
   public static void main(String[] args) {
	      MyFrame f = new MyFrame();
	   }

	}
```

#3.  
ANSWER

```
import java.awt.*;
import javax.swing.*;
public class MyFrame extends JFrame{
	public MyFrame(){
		setSize(400,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("My Frame");
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JLabel label1 = new JLabel("자바 호텔에 오신 것을 환영합니다.");
		JLabel label2 = new JLabel("숙박일수를 입력하세요.");
		JButton button1 = new JButton("1일");
		JButton button2 = new JButton("2일");
		JButton button3 = new JButton("3일");
		JButton button4 = new JButton("4일");
		JButton button5 = new JButton("5일");
		panel1.add(label1);
		panel1.add(label2);
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		panel2.add(button5);
		panel3.add(panel1);
		panel3.add(panel2);
		add(panel3);
		setVisible(true);
	}
	public static void main(String[] args){
		MyFrame f = new MyFrame();
	}
}
```

#4.  
ANSWER

```
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
	JPanel p = new JPanel();
	JLabel[] labels = new JLabel[30];

	public MyFrame() {
		p.setLayout(null);
		for (int i = 0; i < 30; i++) {
			labels[i] = new JLabel("" + i);
			int x = (int) (400 * Math.random());
			int y = (int) (150 * Math.random());
			labels[i].setForeground(Color.MAGENTA);
			labels[i].setLocation(x, y);
			labels[i].setSize(20, 20);
			p.add(labels[i]);
		}
		setSize(400, 150);
		setTitle("My Frame");
		add(p);
		setVisible(true); // 프레임을 화면에 표시한다.
	}
	public static void main(String args[]) {
		MyFrame f = new MyFrame();
	}
}
```

#5.  
ANSWER

```
import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {

	private JPanel panel;
	private JTextField tField;
	private JButton[] buttons;

	public MyFrame() {
		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 5));
		buttons = new JButton[20];
		for (int index = 0; index < buttons.length; index++) {
				buttons[index] = new JButton(""+index);
				int R = (int)(Math.random()*256);
				int G = (int)(Math.random()*256);
				int B= (int)(Math.random()*256);
				Color color = new Color(R, G, B); 
				buttons[index].setBackground(color);
				panel.add(buttons[index]);
		}
		add(panel, BorderLayout.CENTER);
		setSize(400, 150);
		setTitle("My Frame");
		setVisible(true);
	}

	public static void main(String args[]) {
		MyFrame f = new MyFrame();
	}
}
```

#6.  
ANSWER

```
import java.awt.*;
import javax.swing.*;

public class TelephonePanel extends JPanel
{
    public static void main (String[] args)
    {
	 	JFrame frame = new JFrame(); 
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		
		JPanel p = new JPanel(); 
		p.setLayout (new BorderLayout());
		
		
		JTextField title = new JTextField ("");
		p.add (title, BorderLayout.NORTH);
		
		JButton clear = new JButton ("clear");
		p.add (clear, BorderLayout.EAST);
		
		
		JPanel keys = new JPanel();

			keys.setLayout (new GridLayout (5,3));
			
			keys.add (new JButton ("1"));
			keys.add (new JButton ("2"));
			keys.add (new JButton ("3"));
			keys.add (new JButton ("4"));
			keys.add (new JButton ("5"));
			keys.add (new JButton ("6"));
			keys.add (new JButton ("7"));
			keys.add (new JButton ("8"));
			keys.add (new JButton ("9"));
			keys.add (new JButton ("*"));
			keys.add (new JButton ("0"));
			keys.add (new JButton ("#"));
			keys.add (new JButton ("send"));
			keys.add (new JButton (""));
			keys.add (new JButton ("end"));
				

	p.add (keys, BorderLayout.CENTER);
	
	
	
			frame.add(p);
			frame.setSize(400, 150);
			frame.setVisible(true);
    
		}
}
```