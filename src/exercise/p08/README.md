- 자료출처: Power Java Compact(출판사:인피니트 북스, 저자:천인국)

## Exercise
#1.다음 코드는 화면에 프레임을 표시하는 프로그램이다. 빈칸을 채워보자

```
import javax.swing.*;
public class MyFrame extends JFrame {
	public MyFrame() {
		setSize(300, 150);
		setTitle("MyFrame");
		setVisible(true);
	}
	public static void main(String[] args) {
		_____________________________//MyFrame 객체를 생성한다.
	}
}
```
ANSWER  

```
 MyFrame f = new MyFrame();
```

#2.1번 코드를 상속을 이용하지 않는 버전으로 변경해 보라. JFrame 객체를 직접 생성한다.
상속을 이용한 버전과 상속을 이용하지 않는 버전의 장단점은 무엇일까?
ANSWER  

```
   public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(300, 150);
		f.setTitle("MyFrame");
		f.setVisible(true);
   }
   /**
  상속은 상위 클래스가 기능의 버그와 기능의 추가/변경 등으로 변화가 생겼을 때 상위 클래스를 상속받은 하위 클래스가 정상 동작할지를 예측하기 힘들다.
  하위 클래스는 상위 클래스의 부분집합이기 때문에 상위 클래스가 변경이 일어나면 하위 클래스도 따라서 변형되기 때문이다.
  상속 구조가 복잡해지면 영향도를 예측하기가 어려운 단점이 있다.
  또 상속은 상위 클래스에서 하위 클래스로 내려갈 수록 기능 개방성이 커진다. 
  즉, 하위 클래스는 반드시 상위 클래스의 공개된 기능들을 제공해야 하므로 하위 클래스에서 추가된 기능과 더해져 기능이 많아지고 복잡해지게 됩니다.
  (public 한정자의 메소드 개수가 계속 늘어납니다.) 또 어떨 때는 상위 클래스에서는 의미있는 기능이 하위 클래스에서는 더이상 무의미한 경우가 있다. 
  이런 경우 불필요한 기능이 하위 클래스에 들어나게 되고 클래스를 사용하는 사용자 입장에는 동작하지 않는 메소드를 일일히 확인해야 하므로 어려움을 주는 요인이 된다.
  그래서, 웹 프로그램에서는 상속 보다는 인터페이스로 상속을 구현하는 경우가 많다.
*/
```

#3.MyFrame의 배치 관리자를 3x4 GridLayout으로 설정해 보자.
어떤 코드를 추가해야 하는가?
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