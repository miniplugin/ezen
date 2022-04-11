- 자료출처: Power Java Compact(출판사:인피니트 북스, 저자:천인국)

## Exercise
#1.다음 질문에 간단히 답하라.
ANSWER  

```
(1) 색상을 나타내는 클래스는? -답변: Color
(2) 폰트를 나타내는 클래스는? -답변: Font
(3) 화면에 그림을 그릴 때 재정의해야 하는 메서드로서 그림을 그리는 문장들이 들어가는 메서드는?
-답변: paintComponent()
(4) 자바에서 그림이 그려지는 캔버스의 역할을 하는 클래스는? -답변: Panel
```

#2.아래 문장의 참, 거짓을 판단하고 거짓이면 올바르게 수정하라.
ANSWER  

```
(1) 자바 좌표 체계에서 y값은 아래에서 위쪽으로 증가한다.
-답변: 거짓 - 위에서 아래쪽으로 증가한다.
(2) 자바에서 색상은 Red, Green, Blue 색상의 양을 0에서 512사이의 정수로 표현한다.
-답변: 거짓 - 0부터 255까지
(3) drawOval(x,y,100,200)의 처음 두 개의 인수는 타원의 중심을 나타낸다.
-답변: 거짓 - 감싸는 사각형의 좌측 상단의 좌표이다.
```

#3.다음은 화면에 그림을 그리는 기본 구조이다. (0,0)을 왼쪽 상단으로 하고 
크기가 100x100인 사각형을 그리고자 한다. 빈칸에 올바른 문장을 넣으시오.

```
public class MyFrame {
	public MyFrame() {
		//...
		setContentPane(new MyPanel());//그래픽 패널창 추가
	}
}
class MyPanel extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		___________________________________;
	}
}
```
ANSWER  

```
 g.drawRect(0, 0, 100, 100);
```

#4.그림을 다시 그려야 할 때, 자바에서는 paintComponent()를 직접 호출하면 안 된다.어떻게 해야 하는가?
ANSWER  

```
 repaint()를 호출한다. 
```


## Program Exercise
#1.  
ANSWER

```
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

class House extends JPanel {
	public House()
	{
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.BLACK);
		g2.draw(new Rectangle2D.Float(50,50,200,140));
		g2.draw(new Rectangle2D.Float(150,80,50,100));
		g2.draw(new Rectangle2D.Float(75,75,20,20));
		g2.draw(new Line2D.Float(150, 20, 50, 50));
		g2.draw(new Line2D.Float(150, 20, 250, 50));
	}
}
class MyFrame extends JFrame{
	public MyFrame()
	{
		setSize(600,250);
		setTitle("MyFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		House H=new House();
		H.setBounds(0, 0, 300, 300);
		add(H);
		setVisible(true);
	}
}
public class Test {
	public static void main(String[] arge)
	{
		MyFrame F=new MyFrame();
	}
}
```

#2.   
ANSWER

```
import java.awt.*;
import javax.swing.*;

class BusinessCard extends JPanel {
	public BusinessCard()
	{
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawString("홍길동", 150, 40);
		g.drawString("프로젝트 매니저", 150, 60);
		g.drawString("자바주식회사", 150, 80);
		g.setColor(Color.red);
		g.fillOval(20, 20, 80, 80);
	}
}
class MyFrame extends JFrame{
	public MyFrame()
	{
		setSize(600,180);
		setTitle("MyFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new BusinessCard());
		setVisible(true);
	}
}
public class Test {
	public static void main(String[] arge)
	{
		MyFrame F=new MyFrame();
	}
}
```

#3.   
ANSWER

```
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BasicPaint {

	public static void main(String[] args) {
		JFrame f = new JFrame("그래픽 기초 프로그램");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new MyPanel());

		f.setSize(600, 200);
		f.setVisible(true);
	}
}

class MyPanel extends JPanel {

	private int squareX = 50;
	private int squareY = 50;
	private int squareW = 60;
	private int squareH = 60;

	public MyPanel() {

		setBorder(BorderFactory.createLineBorder(Color.black));

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				moveSquare(e.getX(), e.getY());
			}
		});

		addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {

				moveSquare(e.getX(), e.getY());
			}
		});

	}

	private void moveSquare(int x, int y) {
		int OFFSET = 1;
		if ((squareX != x) || (squareY != y)) {
			repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
			squareX = x;
			squareY = y;
			repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("마우스를 클릭하면 사각형이 그려집니다.!", 10, 20);
		g.setColor(Color.RED);
		g.fillRect(squareX, squareY, squareW, squareH);
		g.setColor(Color.BLACK);
		g.drawRect(squareX, squareY, squareW, squareH);
	}
}
```

#4.   
ANSWER

```
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class MyPanel extends JPanel implements ActionListener {
	JButton button;
	Color color = new Color(0, 0, 0);

	public MyPanel() {
		setLayout(new BorderLayout());
		button = new JButton("색상 변경");
		button.addActionListener(this);
		add(button, BorderLayout.SOUTH);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
		g.fillRect(10, 10, 580, 190);
	}

	public void actionPerformed(ActionEvent e) {
		color = new Color((int) (Math.random() * 255.0),
			(int) (Math.random() * 255.0), (int) (Math.random() * 255.0));
		repaint();
	}
}

public class ColorTest extends JFrame {
	public ColorTest() {
		setSize(600, 200);
		setTitle("Color Test");
		setVisible(true);
		JPanel panel = new MyPanel();
		add(panel);
	}

	public static void main(String[] args) {
		ColorTest s = new ColorTest();
	}

}
```

#5.   
ANSWER

```
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class MyPanel extends JPanel {

	Font f1, f2, f3, f4, f5;

	public MyPanel() {
		f1 = new Font("Serif", Font.PLAIN, 20);
		f2 = new Font("San Serif", Font.BOLD, 20);
		f3 = new Font("Monospaced", Font.ITALIC, 20);
		f4 = new Font("Dialog", Font.BOLD | Font.ITALIC, 20);
		f5 = new Font("DialogInput", Font.BOLD, 20);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(f1);
		g.drawString("Serif 20 points PLAIN", 10, 50);
		g.setFont(f2);
		g.drawString("SanSerif 20 points BOLD", 10, 70);
		g.setFont(f3);
		g.drawString("Monospaced 20 points ITALIC", 10, 90);
		g.setFont(f4);
		g.drawString("Dialog 20 points BOLD + ITALIC", 10, 110);
		g.setFont(f5);
		g.drawString("DialogInput 20 points BOLD", 10, 130);
	}
}

public class FontTest extends JFrame {
	public FontTest() {
		setSize(500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Font Test");
		JPanel panel = new MyPanel();
		add(panel);
		setVisible(true);
	}

	public static void main(String[] args) {
		FontTest s = new FontTest();
	}
}
```

#6.   
ANSWER

```
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

class DoubleDice extends JPanel implements MouseListener {
	int die1 = 4;
	int die2 = 3;

	public DoubleDice() {
		super();
		addMouseListener(this);
		setBackground(new Color(200, 200, 255));
	}

	public void paintComponent(Graphics g) {
		drawDie(g, die1, 100, 50);
		drawDie(g, die2, 200, 50);
	}

	void drawDie(Graphics g, int val, int x, int y) {
		g.setColor(Color.white);
		g.fillRect(x, y, 35, 35);
		g.setColor(Color.black);
		g.drawRect(x, y, 34, 34);
		if (val > 1)
			g.fillOval(x + 3, y + 3, 9, 9);
		if (val > 3)
			g.fillOval(x + 23, y + 3, 9, 9);
		if (val == 6)
			g.fillOval(x + 3, y + 13, 9, 9);
		if (val % 2 == 1)
			g.fillOval(x + 13, y + 13, 9, 9);
		if (val == 6)
			g.fillOval(x + 23, y + 13, 9, 9);
		if (val > 3)
			g.fillOval(x + 3, y + 23, 9, 9);
		if (val > 1)
			g.fillOval(x + 23, y + 23, 9, 9);
	}

	void roll() {
		die1 = (int) (Math.random() * 6) + 1;
		die2 = (int) (Math.random() * 6) + 1;
		repaint();
	}

	public void mousePressed(MouseEvent evt) {
		roll();
	}

	public void mouseReleased(MouseEvent evt) {
	}

	public void mouseClicked(MouseEvent evt) {
	}

	public void mouseEntered(MouseEvent evt) {
	}

	public void mouseExited(MouseEvent evt) {
	}
}

public class MyFrame extends JFrame {
	public MyFrame() {
		setSize(600, 200);
		setTitle("MyFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new DoubleDice());
		setVisible(true);
	}

	public static void main(String[] arge) {
		MyFrame F = new MyFrame();
	}
}
```

#7.   
ANSWER

```
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

class Car {
    int x, y;
    public Car(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void drawCar(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, 100, 30);
        g.setColor(Color.RED); 
        g.fillOval(x + 15, y + 20, 30, 30); 
        g.fillOval(x + 60, y + 20, 30, 30); 
        g.fillRect(x + 15, y - 20, 60, 20); 
    }

    public void move() {
        if (x >= 600) {
            x = 0;
        } else {
            x += Math.random()*10;
        }
    }
}

public class CarGame extends JPanel{
    private static final int D_W = 600;
    private static final int D_H = 200;

    ArrayList<Car> list;
    public CarGame() {
    	list = new ArrayList<>();
    	list.add(new Car(100, 10));
    	list.add(new Car(100, 80));
    	list.add(new Car(100, 130));

        Timer timer = new Timer(50, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                for (Car car : list) {
                    car.move();
                }
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : list) {
            car.drawCar(g);
        }
    }

    public static void main(String[] args) {
                JFrame frame = new JFrame();
                frame.add(new CarGame());
                frame.setSize(600, 200);
                frame.setVisible(true);
    }
}
```

#8.   
ANSWER

```
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;
class MyPanel extends JPanel implements ActionListener {

	private final int WIDTH = 500;
	private final int HEIGHT = 300;
	private final int START_X = 0;
	private final int START_Y = 250;
	private BufferedImage image;
	private Timer timer;
	private int x, y;

	public MyPanel() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setDoubleBuffered(true);

		File input = new File("ship.jpg");
		try {
			image = ImageIO.read(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		x = START_X;
		y = START_Y;

		timer = new Timer(20, this);
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x, y, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		x += 1;
		y -= 1;
		if (x > WIDTH) {
			x = START_X;
			y = START_Y;
		}
		repaint();
	}
}
```

#9.  
ANSWER

```
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
public class MyPanel extends JPanel implements ActionListener {
	JTextField a, b, c;
	double A, B, C;

	public MyPanel() {
		a = new JTextField("1.0", 10);
		b = new JTextField("-5.0", 10);
		c = new JTextField("6.0", 10);
		add(a);
		add(b);
		add(c);
		JButton button = new JButton("DRAW");
		add(button);
		button.addActionListener(this);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawLine(0, 100, 400, 100);
		g2.drawLine(200, 0, 200, 200);
		g2.setPaint(Color.red);
		for (int i = -20; i < 20; i++) {
			int x = i;
			int y = (int) (A * x * x - B * x + C);
			g2.fillOval(200 + x - 2, 100 - (y - 2), 4, 4);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		A = Double.parseDouble(a.getText());
		B = Double.parseDouble(b.getText());
		C = Double.parseDouble(c.getText());
		repaint();
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new MyPanel());
		f.setSize(600, 200);
		f.setVisible(true);
	}
}
```

#10.   
ANSWER

```
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

class MyPanel extends JPanel 
	{
	 public MyPanel()
		 {
		 super();
		 setBackground( Color.yellow );
		 setSize( 400, 400 );
	 }
	
	 public void paintComponent( Graphics g )
		 {
		 super.paintComponent(g);
		 int xPoints[] = { 55, 67, 109, 73, 83, 55, 27, 37, 1, 43 };
		 int yPoints[] = { 0, 36, 36, 54, 96, 72, 96, 54, 36, 36 };
		
		 Graphics2D g2d = ( Graphics2D ) g;
		
		 GeneralPath star = new GeneralPath();
		
		 star.moveTo( xPoints[ 0 ], yPoints[ 0 ] );
		
		 for ( int k = 1; k < xPoints.length; k++ )
			 star.lineTo( xPoints[ k ], yPoints[ k ] );
		
		 star.closePath();
		
		 g2d.translate( 100, 10 );
		
		 for ( int j = 1; j <= 5; j++ ) 
			 {
			 g2d.rotate( Math.PI / 30.0 );
			 g2d.setColor(new Color( ( int ) ( Math.random() * 256 ),( int ) ( Math.random() * 256 ), 
			 ( int ) ( Math.random() * 256 ) ) );
			 g2d.fill( star ); // draw a filled star
		 }
	 }
	
}
public class MyFrame extends JFrame{
	public MyFrame()
	{
		setSize(600,200);
		setTitle("MyFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MyPanel());
		setVisible(true);
	}
	public static void main(String[] arge)
	{
		MyFrame F=new MyFrame();
	}
}
```