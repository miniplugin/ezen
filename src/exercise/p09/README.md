## Excercise
#1.  
ANSWER  

```
(1) 거짓 – 액션 이벤트
(2) 거짓 - 마우스가 움직였을 때 발생하는 이벤트는 MouseMotionEvent이다
(3) 거짓 - 어댑터 클래스를 사용하면 원하는 메소드만을 구현하는 것이 가능해짐
```

#2.  
ANSWER  

```
JButton b = new JButton("test");
b.addActionListener(new MyListener());
```

#3.  
ANSWER  

```
 keyPressed() -> keyTyped() -> KeyReleased()
```

#4.  
ANSWER  

```
class MyFrame extends JFrame {
	JButton button;
	public MyFrame() {
		button = new JButton("버튼을 누르시오");
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				System.out.println("마침내 버튼이 눌려졌습니다.");
			}
		});
	}
}
```

#5.  
ANSWER  

```
class MyFrame extends JFrame {
	JButton button;
	public MyFrame() {
		button = new JButton("버튼을 누르시오");
		button.addActionListener(e->System.out.println("마침내 버튼이 눌려졌습니다."));
	}
}
```

#6.  
ANSWER  

```
	this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				img_x = e.getX();
				img_y = e.getY();
				repaint();
			}
	});
```

## Program Exercise
#1.  
ANSWER  

```
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*; 

class MyListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		button.setText("마침내 버튼이 눌려졌습니다.");
	}
}
class MyFrame extends JFrame {
	private JButton button;
	public MyFrame() {
		this.setSize(400, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("이벤트 예제");
		this.setLayout(new FlowLayout());
		button = new JButton("버튼을 누르시오");
		button.addActionListener(new MyListener());
		this.add(button);
		this.setVisible(true);
	}
}
public class ActionEventTest {
	public static void main(String[] args) {
		MyFrame t = new MyFrame();
	}
}
```

#2.  
ANSWER  

```
import javax.swing.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*; 

class MyFrame extends JFrame {
       private JButton button1;
       private JButton button2;
       private JPanel panel;
       MyListener listener = new MyListener();
 
       public MyFrame() {
             this.setSize(400, 150);
             this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             this.setTitle("이벤트 예제");
             panel = new JPanel();
             button1 = new JButton("노란색");
             button1.addActionListener(listener);
             panel.add(button1);
             button2 = new JButton("핑크색");
             button2.addActionListener(listener);
             panel.add(button2);
             this.add(panel);
             this.setVisible(true);
       }
        private class MyListener implements ActionListener {
             public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == button1) {
                           panel.setBackground(Color.YELLOW);
                    } else if (e.getSource() == button2) {
                           panel.setBackground(Color.PINK);
                    }
             }
        }
}
public class MyFrameTest2 {
       public static void main(String[] args) {
             MyFrame t = new MyFrame();
       }
}
```

#3.  
ANSWER  

```
import java.awt.event.*;
import javax.swing.*;

class Myframe extends JFrame
{
	JButton button;
	JTextField t1;
	JTextField t2;
	public Myframe()
	{
		setSize(500,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Mile->Km");
				
		JPanel panel1=new JPanel();
		JLabel label=new JLabel("마일을 입력하시오");
		t1=new JTextField(10); 
		t2=new JTextField(10);
		button=new JButton("변환");
		button.addActionListener(new MyListener());
		t1.setText("1");
		
		t2.setEditable(false);
		panel1.add(label);
		panel1.add(t1);
		panel1.add(new JLabel("->"));
		panel1.add(t2);
		panel1.add(button);
		this.add(panel1);

		setVisible(true);
	}
	private class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==button)
			{
				int t=Integer.parseInt(t1.getText());
				double k=t*1.609344;
				t2.setText(k+" km");
			}
		}
	}
}
public class Pro1 {
	public static void main(String[] arge)
	{
		Myframe f=new Myframe();
	}
}
```

#4.  
ANSWER  

```
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyPanel extends JPanel
{
	int x=200, y=10;
	public void move(int dx) {
		this.x += dx;
		repaint();
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.yellow);
		g.setColor(Color.red);
		g.fillOval(x, y, 60, 60);
	}
}
class Myframe extends JFrame
{
	MyPanel panel;
	JPanel panel1;
	JButton b1, b2;
	public Myframe()
	{
		setSize(400,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("원움직이기");
				
		panel=new MyPanel();
		panel1=new JPanel();
		b1=new JButton("왼쪽으로 이동");
		b2=new JButton("오른쪽으로 이동");
		panel1.add(b1);
		panel1.add(b2);
		add(panel, BorderLayout.CENTER);
		add(panel1, BorderLayout.SOUTH);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
	{
		panel.move(-10);
	}});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
	{
		panel.move(10);
	}});
		setVisible(true);
	}
}
public class MyFrameTest {
	public static void main(String[] arge)
	{
		Myframe f=new Myframe();
	}
}
```

#5.  
ANSWER  

```
import java.awt.event.*;
import javax.swing.*;

class Myframe extends JFrame
{
	JButton button;
	JTextField t1;
	JTextField t2;
	JTextField t3;
	public Myframe()
	{
		setSize(400,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("이자 계산기");
		
		JPanel panel1=new JPanel();

		JLabel label1=new JLabel("원금을 입력하시오");
		JLabel label2=new JLabel("이율을 입력하시오");
		t1=new JTextField(5); 
		t2=new JTextField(5);
		t3=new JTextField(15);
		button=new JButton("변환");
		button.addActionListener(new MyListener());
		
		t3.setEditable(false);
		panel1.add(label1);
		panel1.add(t1);
		panel1.add(label2);
		panel1.add(t2);
		panel1.add(button);
		panel1.add(t3);
		this.add(panel1);

		setVisible(true);
	}
	private class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==button)
			{
				int t=Integer.parseInt(t1.getText());
				float a=Float.parseFloat(t2.getText());
				int k=(int)(t*(a/100));
				t3.setText("이자는 연 "+k+"만원 입니다.");
			}
		}
	}
}
public class Pro2 {
	public static void main(String[] arge)
	{
		Myframe f=new Myframe();
	}
}
```

#6.  
ANSWER  

```
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

class MyButton extends JButton
{
	static int count=0;
	int index;
	public MyButton(String s)
	{
		super(s);
		index = count++;
	}
}

public class Puzzle extends JFrame implements ActionListener {
	MyButton[] buttons;
	MyButton reset;

	public Puzzle() {
		super("puzzle");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 3, 2, 2));
		buttons= new MyButton[9];
		for(int i=0; i<8; i++)
			buttons[i] =  new MyButton(""+(i+1));
		buttons[8] = new MyButton(" ");
		for(int i=0; i<9; i++)
			panel.add(buttons[i]);
		for(int i=0; i<9; i++)
			buttons[i].addActionListener(this);
		add(panel, BorderLayout.CENTER);

		reset = new MyButton("reset");
		//reset.setBackground(Color.red);  
		//reset.setForeground(Color.yellow);  

		add(reset, BorderLayout.SOUTH);
		// reset.addActionListener(this);
	
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		MyButton b = (MyButton) e.getSource();
		if( b.getText().equals(" ")==true) return;
		if( b.index == 0 ){
			if( buttons[1].getText().equals(" ") )
			{ buttons[1].setText(b.getText()); b.setText(" "); } 
			if( buttons[3].getText().equals(" ") )
			{ buttons[3].setText(b.getText()); b.setText(" "); } 
		}
		if( b.index == 1 ){
			if( buttons[0].getText().equals(" ") )
			{ buttons[0].setText(b.getText()); b.setText(" "); } 
			if( buttons[2].getText().equals(" ") )
			{ buttons[2].setText(b.getText()); b.setText(" "); } 
			if( buttons[4].getText().equals(" ") )
			{ buttons[4].setText(b.getText()); b.setText(" "); } 
		}
		if( b.index == 2 ){
			if( buttons[1].getText().equals(" ") )
			{ buttons[1].setText(b.getText()); b.setText(" "); } 
			if( buttons[5].getText().equals(" ") )
			{ buttons[5].setText(b.getText()); b.setText(" "); } 
		}
		if( b.index == 3 ){
			if( buttons[0].getText().equals(" ") )
			{ buttons[0].setText(b.getText()); b.setText(" "); } 
			if( buttons[4].getText().equals(" ") )
			{ buttons[4].setText(b.getText()); b.setText(" "); } 
			if( buttons[6].getText().equals(" ") )
			{ buttons[6].setText(b.getText()); b.setText(" "); } 
		}
		if( b.index == 4 ){
			if( buttons[1].getText().equals(" ") )
			{ buttons[1].setText(b.getText()); b.setText(" "); } 
			if( buttons[3].getText().equals(" ") )
			{ buttons[3].setText(b.getText()); b.setText(" "); } 
			if( buttons[5].getText().equals(" ") )
			{ buttons[5].setText(b.getText()); b.setText(" "); } 
			if( buttons[7].getText().equals(" ") )
			{ buttons[7].setText(b.getText()); b.setText(" "); } 
		}
		if( b.index == 5 ){
			if( buttons[2].getText().equals(" ") )
			{ buttons[2].setText(b.getText()); b.setText(" "); } 
			if( buttons[4].getText().equals(" ") )
			{ buttons[4].setText(b.getText()); b.setText(" "); } 
			if( buttons[8].getText().equals(" ") )
			{ buttons[8].setText(b.getText()); b.setText(" "); } 
		}
		if( b.index == 6 ){
			if( buttons[3].getText().equals(" ") )
			{ buttons[3].setText(b.getText()); b.setText(" "); } 
			if( buttons[7].getText().equals(" ") )
			{ buttons[7].setText(b.getText()); b.setText(" "); } 
		}
		if( b.index == 7 ){
			if( buttons[4].getText().equals(" ") )
			{ buttons[4].setText(b.getText()); b.setText(" "); } 
			if( buttons[6].getText().equals(" ") )
			{ buttons[6].setText(b.getText()); b.setText(" "); } 
			if( buttons[8].getText().equals(" ") )
			{ buttons[8].setText(b.getText()); b.setText(" "); } 
		}
		if( b.index == 8 ){
			if( buttons[5].getText().equals(" ") )
			{ buttons[5].setText(b.getText()); b.setText(" "); } 
			if( buttons[7].getText().equals(" ") )
			{ buttons[7].setText(b.getText()); b.setText(" "); } 
		}
	}

	public static void main(String[] args) {
		new Puzzle();
	}

}
```

#7.  
ANSWER  
  +와 – 연산만 구현하였다. 

```
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Container;

public class SimpleCalc implements ActionListener{
 
    JFrame guiFrame;
    JPanel buttonPanel;
    JTextField numberCalc;
    int calcOperation = 0;
    int currentCalc;
    
    public static void main(String[] args) {
                 new SimpleCalc();         
    }
    
    public SimpleCalc()
    {
        guiFrame = new JFrame();
        
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Java Calculator");
        guiFrame.setSize(400,150);
      
        guiFrame.setLocationRelativeTo(null);
        
        numberCalc = new JTextField();
        numberCalc.setHorizontalAlignment(JTextField.RIGHT);
        numberCalc.setEditable(false);
        
        guiFrame.add(numberCalc, BorderLayout.NORTH);
        
        buttonPanel = new JPanel();
               
        buttonPanel.setLayout(new GridLayout(0,4, 2, 2));   
        guiFrame.add(buttonPanel, BorderLayout.CENTER);
        
        for (int i=1;i<10;i++)
        {
            addButton(buttonPanel, String.valueOf(i));
        }

        JButton addButton = new JButton("+");
        addButton.setActionCommand("+");
        
        OperatorAction subAction = new OperatorAction(1);
        addButton.addActionListener(subAction);
        
        JButton subButton = new JButton("-");
        subButton.setActionCommand("-");
        
        OperatorAction addAction = new OperatorAction(2);
        subButton.addActionListener(addAction);
        
        JButton equalsButton = new JButton("=");
        equalsButton.setActionCommand("=");
        equalsButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if (!numberCalc.getText().isEmpty())
                {
                    int number = Integer.parseInt(numberCalc.getText()); 
                    if (calcOperation == 1)
                    {
                        int calculate = currentCalc  + number;
                        numberCalc.setText(Integer.toString(calculate));
                    }
                    else if (calcOperation == 2)
                    {
                        int calculate = currentCalc  - number;
                        numberCalc.setText(Integer.toString(calculate));
                    }
                }
            }
        });
        
        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(new JButton("*"));
        buttonPanel.add(new JButton("/"));
        buttonPanel.add(new JButton("C"));
        buttonPanel.add(equalsButton);
        guiFrame.setVisible(true);  
    }
    
    private void addButton(Container parent, String name)
    {
        JButton but = new JButton(name);
        but.setActionCommand(name);
        but.addActionListener(this);
        parent.add(but);
    }
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
        String action = event.getActionCommand();
        numberCalc.setText(action);       
    }
    
    private class OperatorAction implements ActionListener
    {
        private int operator;
        
        public OperatorAction(int operation)
        {
            operator = operation;
        }
        
        public void actionPerformed(ActionEvent event)
        {
            currentCalc = Integer.parseInt(numberCalc.getText()); 
            calcOperation = operator;
        }
    }
}
```