## Excercise
#1.   
ANSWER  

```
CPU의 시간을 잘게 나누어서 스레드에게 각 슬라이스를 할당한다. 
```

#2.   
ANSWER  

```
(1) Thread클래스를 상속받아 서브 클래스를 만들고 run()메소드를 오버라이드하는 방법이다. 
Thread클래스를 확장하는 방법은 자바에서는 단일 상속만이 가능하므로 다른 클래스를 이미 상속한 클래스는 스레드로 만들 수 없다.
(2) Runnable인터페이스는 스레드로 실행이 가능한 객체들이 만족하여야하는 인터페이스이다. 
Runnable객체는 Thread가 아닌 다른 클래스를 상속 받을 수 있다.
```

#3.   
ANSWER  

```
① run();  
```

#4.   
ANSWER  

```
② start()
```

#5.   
ANSWER  

```
② synchronized 
```

#6.   
ANSWER  

```
wait()는 공유 자원을 차지할 때, notify()는 공유 자원을 해제할 때 사용한다. 
```

#7.   
ANSWER  

```
Test run = new Test(); 
Thread t = new Thread(run); 
t.start();
```

#8.   
ANSWER  

```
③new Thread(new Test()).start();
```

#9.   
ANSWER  

```
0..1..2..
```

## Program Exercise
#1.   
ANSWER

```
class MyRunnable implements Runnable {
	String myName;
	public MyRunnable(String name) {		myName = name;	}
	public void run() {
		for (int i = 10; i >= 0; i--)
			System.out.print(myName + i + " ");
	}
}
public class TestThread {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable("A"));
		Thread t2 = new Thread(new MyRunnable("B"));
		Thread t3 = new Thread(new MyRunnable("C"));
		t1.start();
		t2.start();
		t3.start();
	}
}
```

#2.   
ANSWER

```
public class SumThread extends Thread {
    private int lo, hi;
    private int[] arr;
    private int ans = 0;
    
    public SumThread(int[] arr, int lo, int hi) {
        this.lo = lo;
        this.hi = hi;
        this.arr = arr;
    }
    
    @Override
    public void run() {
        for (int i = lo; i < hi; i++) {
            ans += arr[i];
        }
    }
    
    public static int sum(int[] arr) throws InterruptedException {
        int len = arr.length;
        int ans = 0;
        
        SumThread[] ts = new SumThread[4];
        for (int i = 0; i < 4; i++) {
            ts[i] = new SumThread(arr, (i * len) / 4, ((i + 1) * len / 4));
            ts[i].start();
        }
        
        for (int i = 0; i < 4; i++) {
            ts[i].join();
            ans += ts[i].ans;
        }
        return ans;
    }
    
    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int sum = sum(arr);
        System.out.println("합계: " + sum);
    }
}
```

#3.   
ANSWER

```
public class MaxThread extends Thread {
    private int lo, hi;
    private int[] arr;
    private int ans = 0;
    
    public MaxThread(int[] arr, int lo, int hi) {
        this.lo = lo;
        this.hi = hi;
        this.arr = arr;
    }
    
    @Override
    public void run() {
		ans = arr[lo];
        for (int i = lo; i < hi; i++) {
            if( ans < arr[i] ) 
				ans = arr[i];
        }
    }
    
    public static int max(int[] arr) throws InterruptedException {
        int len = arr.length;
        int ans = 0;
        
        MaxThread[] ts = new MaxThread[4];
        for (int i = 0; i < 4; i++) {
            ts[i] = new MaxThread(arr, (i * len) / 4, ((i + 1) * len / 4));
            ts[i].start();
        }
        ans = -1;
        for (int i = 0; i < 4; i++) {
            ts[i].join();
            if( ans < ts[i].ans )
			ans = ts[i].ans;
        }
        return ans;
    }
    
    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int m = max(arr);
        System.out.println("최대값: " + m);
    }
}
```

#4.   
ANSWER

```
public class SeatReservation
{
    public static void main(String[] args)
    {
        Reservation reserve = new Reservation(); // LINE A
        Person thread1 = new Person(reserve, 5); // LINE B
        thread1.start();
        Person thread2 = new Person(reserve, 4);
        thread2.start();
        Person thread3 = new Person(reserve, 2);
        thread3.start();
    }
}

class Reservation
{

    static int availableSeats = 10;

    synchronized void reserveSeat(int requestedSeats) // LINE D
    {
        System.out.println(Thread.currentThread().getName() + " 가 들어왔음.");
        System.out.println("가능한 좌석수 : " + availableSeats + " 요청좌석수 : " + requestedSeats);
        if (availableSeats >= requestedSeats)
        {
            System.out.println("좌석이 가능합니다. 예약하세요.");
            try
            {
                Thread.sleep(100);     // LINE E
            }
            catch (InterruptedException e)
            {
                System.out.println("Thread interrupted");
            }
            System.out.println(requestedSeats + " 좌석이 예약되었음.");
            availableSeats = availableSeats - requestedSeats;
        }
        else
        {
            System.out.println("좌석 예약이 불가능합니다.");
        }
        System.out.println(Thread.currentThread().getName() + " 가 나갑니다.");
        System.out.println("----------------------------------------------");
    }
}

class Person extends Thread
{

    Reservation reserve;
    int requestedSeats;

    public Person(Reservation reserve, int requestedSeats)
    {
        this.reserve = reserve;
        this.requestedSeats = requestedSeats;
    }

    @Override
    public void run() // LINE C
    {
        reserve.reserveSeat(requestedSeats);
    }
}
```

#5.   
ANSWER

```
import java.awt.*;
import javax.swing.*;       
import java.util.*;

public class Clock extends JFrame implements Runnable
{
  Thread runner; 
  Font clockFont;
  
     public Clock()
     {
       setSize( 350, 100);
       setVisible(true);
       setResizable(false);                            
   
       clockFont = new Font("Serif", Font.BOLD, 40);   
       
       Container contentArea = getContentPane();
       ClockPanel timeDisplay = new ClockPanel();
  
       contentArea.add(timeDisplay);                    
       setContentPane(contentArea);
       start();                                         
     
     }
     
     
     class ClockPanel extends JPanel
     {
      public void paintComponent(Graphics painter )
        {
          painter.setFont(clockFont);                  
          painter.setColor(Color.black);
          painter.drawString( timeNow(), 60, 40);
        }
     }

     public String timeNow()
     {
       Calendar now = Calendar.getInstance();
       int hrs = now.get(Calendar.HOUR_OF_DAY);
       int min = now.get(Calendar.MINUTE);
       int sec = now.get(Calendar.SECOND);
       
       String time = hrs+":"+min+":"+sec;
       
       return time;
     }

     
     public void start()
     {
       if(runner == null) runner = new Thread(this);
       runner.start();
     }


     public void run()
     {
       while (runner == Thread.currentThread() )
       {
        repaint();
                                                        
           try
             {
               Thread.sleep(1000);
             }
              catch(InterruptedException e)
                  {
                    System.out.println("Thread failed");
                  }
                  
       }
     }
     
      public static void main(String [] args)
     {
       Clock eg = new Clock();
     }
}
```

#6.   
ANSWER

```
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


import java.awt.EventQueue;
import javax.swing.JFrame;

public class ThreadAnimationExample extends JFrame {

    public ThreadAnimationExample() {

        initUI();
    }
    
    private void initUI() {
        
        add(new Board());

        setResizable(false);
        pack();
        
        setTitle("Star");    
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }

    public static void main(String[] args) {
                JFrame ex = new ThreadAnimationExample();
                ex.setVisible(true);                
    }
}
class Board extends JPanel        implements Runnable {

    private final int B_WIDTH = 600;
    private final int B_HEIGHT = 350;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;
    private final int DELAY = 25;

    private Image star;
    private Thread animator;
    private int x, y;

    public Board() {

        initBoard();
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("alien.png");
        star = ii.getImage();
    }

    private void initBoard() {

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setDoubleBuffered(true);

        loadImage();

        x = INITIAL_X;
        y = INITIAL_Y;
    }

    @Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawStar(g);
    }

    private void drawStar(Graphics g) {
        g.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync();
    }

    private void cycle() {

        x += 1;
        y += 1;

        if (y > B_HEIGHT) {

            y = INITIAL_Y;
            x = INITIAL_X;
        }
    }

    @Override
    public void run() {
        long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();

        while (true) {

            cycle();
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }

            beforeTime = System.currentTimeMillis();
        }
    }
}
```

#7.  
ANSWER  

```
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class SwingWithThread extends JComponent {
	private Image[] frameList;

	private long msPerFrame;

	private volatile int currFrame;

	private Thread internalThread;

	private volatile boolean noStopRequested;

	public SwingWithThread(int width, int height, long msPerCycle,
			int framesPerSec, Color fgColor) {

		setPreferredSize(new Dimension(width, height));

		int framesPerCycle = (int) ((framesPerSec * msPerCycle) / 1000);
		msPerFrame = 1000L / framesPerSec;

		frameList = buildImages(width, height, fgColor, framesPerCycle);
		currFrame = 0;

		noStopRequested = true;
		Runnable r = new Runnable() {
			public void run() {
				try {
					runWork();
				} catch (Exception x) {
					// in case ANY exception slips through
					x.printStackTrace();
				}
			}
		};

		internalThread = new Thread(r);
		internalThread.start();
	}

	private Image[] buildImages(int width, int height, Color color, int count) {

		BufferedImage[] im = new BufferedImage[count];

		for (int i = 0; i < count; i++) {
			im[i] = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_ARGB);

			double xShape = ((double) (i * width)) / (double) count;
			;
			double yShape = ((double) (i * height)) / (double) count;

			double wShape = 2.0 * (width - xShape);
			double hShape = 2.0 * (height - yShape);
			Rectangle2D shape = new Rectangle2D.Double(xShape, yShape, wShape,
					hShape);

			Graphics2D g2 = im[i].createGraphics();
			g2.setColor(color);
			g2.fill(shape);
			g2.dispose();
		}

		return im;
	}

	private void runWork() {
		while (noStopRequested) {
			currFrame = (currFrame + 1) % frameList.length;
			repaint();

			try {
				Thread.sleep(msPerFrame);
			} catch (InterruptedException x) {
				Thread.currentThread().interrupt();
			}
		}
	}

	public void stopRequest() {
		noStopRequested = false;
		internalThread.interrupt();
	}

	public boolean isAlive() {
		return internalThread.isAlive();
	}

	public void paint(Graphics g) {
		g.drawImage(frameList[currFrame], 0, 0, this);
	}

	public static void main(String[] args) {
		SwingWithThread redSquish = new SwingWithThread(250, 200, 2500L, 10,
				Color.red);
		JFrame f = new JFrame();
		f.setLayout(new FlowLayout());
		f.add(redSquish);

		f.setSize(450, 250);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
```