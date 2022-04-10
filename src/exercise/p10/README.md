## Excercise
#1.  
ANSWER  

```
(1) tf.getText()
(2) tf.setText("");
(3) ActionEvent가 발생한다. 
(4) ItemEvent
(5) ActionEvent가 발생한다. 
```

#2.  
ANSWER  

```
(1) JButton button= newJButton();
(2) JTextField aTextField = new JTextField("초기텍스트", 20);
(3) JTextComponent t = new JTextArea(20, 10);
(4) JTextArea textArea = new JTextArea(20, 30); 
		new JScrollPane().add(textArea);
(5) panel.setBorder( BorderFactory.createTitledBorder("크기"));
```

#3.   
ANSWER  

```
 new 
```

#4.   
ANSWER  

```
public class MyFrame extends JFrame {
	...	
	radio.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
  	  	System.out.println("Small 크기가 선택되었습니다.");
		}
	});
}
```

## Program Exercise
#1.  
ANSWER  

```
import java.awt.*;
import javax.swing.*;

public class ImageLabelTest extends JFrame {
    private JPanel panel;
    private JLabel label1, label2, label3;
 
    public ImageLabelTest() {
        setTitle("레이블 테스트");
        setSize(600,200);
 
        panel = new JPanel();
        label1 = new JLabel("");
        label2 = new JLabel("");
        label3 = new JLabel("");
                
        ImageIcon icon1 = new ImageIcon("d://dog.png");
        ImageIcon icon2 = new ImageIcon("d://cat.png");
        ImageIcon icon3 = new ImageIcon("d://bird.png");
        label1.setIcon(icon1);
        label2.setIcon(icon2);
        label3.setIcon(icon3);

        panel.setLayout(new GridLayout(0,3, 2, 2));
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        add(panel);
        setVisible(true);
    }
 
    public static void main(String[] args) {
    	ImageLabelTest t=new ImageLabelTest();
    }

} 
```

#2.   
ANSWER

```
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class translatorApp extends JFrame implements ActionListener {
 
	public static final int width = 600;
	public static final int height = 200;
	public static final int no_of_lines = 50;
	public static final int chars_per_line = 20;
 
	private JTextArea lan1;
	private JTextArea lan2;
 
	public static void main(String[] args){
 
		translatorApp gui = new translatorApp();
		gui.setVisible(true);
 
	}
 
	public translatorApp(){
 
		super("English Translator");
		setSize(width, height);
		//setLayout(new GridLayout(2,1));
 
 
 
		JPanel biggerPanel = new JPanel();
		biggerPanel.setLayout(new FlowLayout());
		biggerPanel.setBackground(Color.LIGHT_GRAY);
 
 
 
 
		lan1 = new JTextArea("Student",no_of_lines,chars_per_line);
		lan1.setEditable(true);
		lan1.setLineWrap(true);
		biggerPanel.add(lan1);
 
 
 
 
		lan2 = new JTextArea("학생",no_of_lines,chars_per_line);
		lan2.setEditable(true);
		lan2.setLineWrap(true);
		biggerPanel.add(lan2);
 
 
		add(biggerPanel, BorderLayout.CENTER);
 
 
 
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout());
		buttonsPanel.setBackground(Color.LIGHT_GRAY);
 
 
		JButton translate = new JButton("번역");
		translate.addActionListener(this);
		buttonsPanel.add(translate);
 
 
		JButton clear = new JButton("취소");
		clear.addActionListener(this);
		buttonsPanel.add(clear);
 
		add(buttonsPanel, BorderLayout.SOUTH);
	}
 
	public void actionPerformed(ActionEvent e){
 
		String buttonText = e.getActionCommand();
 
		if(buttonText.equals("번역"))
			lan2.setText(lan2.getText());
		else if(buttonText.equals("취소"))
			{
			lan1.setText("");
			lan2.setText("");
			}
			else
			lan2.setText("error occured");
	}
}
```

#3.   
ANSWER

```
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class RadioButtonDemo extends JPanel
                             implements ActionListener {
    static String birdString = "bird";
    static String catString = "cat";
    static String dogString = "dog";
    static String rabbitString = "rabbit";
    static String pigString = "pig";
 
    JLabel picture;
 
    public RadioButtonDemo() {
        super(new BorderLayout());
 
        JRadioButton birdButton = new JRadioButton(birdString);
        birdButton.setMnemonic(KeyEvent.VK_B);
        birdButton.setActionCommand(birdString);
        birdButton.setSelected(true);
 
        JRadioButton catButton = new JRadioButton(catString);
        catButton.setMnemonic(KeyEvent.VK_C);
        catButton.setActionCommand(catString);
 
        JRadioButton dogButton = new JRadioButton(dogString);
        dogButton.setMnemonic(KeyEvent.VK_D);
        dogButton.setActionCommand(dogString);
 
        JRadioButton rabbitButton = new JRadioButton(rabbitString);
        rabbitButton.setMnemonic(KeyEvent.VK_R);
        rabbitButton.setActionCommand(rabbitString);
 
        JRadioButton pigButton = new JRadioButton(pigString);
        pigButton.setMnemonic(KeyEvent.VK_P);
        pigButton.setActionCommand(pigString);
 
        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);
 
        birdButton.addActionListener(this);
        catButton.addActionListener(this);
        dogButton.addActionListener(this);
        rabbitButton.addActionListener(this);
        pigButton.addActionListener(this);
 
        picture = new JLabel(createImageIcon("d://"
                                             + birdString
                                             + ".png"));
        picture.setPreferredSize(new Dimension(177, 122));

        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);
 
        add(radioPanel, BorderLayout.LINE_START);
        add(picture, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }
 
    public void actionPerformed(ActionEvent e) {
        picture.setIcon(createImageIcon("d://"
                                        + e.getActionCommand()
                                        + ".png"));
    }
 
    protected static ImageIcon createImageIcon(String path) {
            return new ImageIcon(path);
    }
 
    public static void main(String[] args) {
        JFrame frame = new JFrame("RadioButtonDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        JComponent newContentPane = new RadioButtonDemo();
        newContentPane.setOpaque(true); 
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
}
```

#4.   
ANSWER

```
import java.awt.*;
import java.awt.event.*;
 
import javax.swing.*;
 
public class NumberGameextends JFrame {
       private int randomNum;
       private JTextField inputField;
       private JLabel guideLabel;
       private JButton retryButton;
       private JButton exitButton;
 
       public NumberGame(){
             //부모 클래스 생성자 명시적 호출
              super("숫자게임");
 
              //top 패널에 들어갈 컴포넌트 구성
              JLabel infoLabel = new JLabel("숫자를 추측하시오 : ");
              inputField = new JTextField(10);
              inputField.addActionListener(new TextFieldActionListener());
 
              //top 패널 구성
              JPanel topPanel = new JPanel();
              topPanel.add(infoLabel);
              topPanel.add(inputField);
 
              //middle 패널에 들어갈 레이블 구성
              guideLabel = new JLabel("숫자를 입력하시오.");
              guideLabel.setBackground(Color.WHITE);
              guideLabel.setOpaque(true);//레이블을 불투명하게
 
              //middle 패널 구성
              JPanel middlePanel = new JPanel();
              middlePanel.add(guideLabel);
 
              //low 패널에 들어갈 버튼 구성
              retryButton = new JButton("새 게임");
              exitButton = new JButton("종료");
              retryButton.addActionListener(new ButtonActionListener());
              exitButton.addActionListener(new ButtonActionListener());
 
              //low 패널 구성
              JPanel lowPanel = new JPanel();
              lowPanel.add(retryButton);
              lowPanel.add(exitButton);
 
              //메인 패널 구성
              JPanel mainPanel = new JPanel();
              mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
              mainPanel.add(topPanel);
              mainPanel.add(middlePanel);
              mainPanel.add(lowPanel);
              add(mainPanel);
 
              //랜덤 넘버와 프레임 설정
              setRandomNum();
              setDefaultCloseOperation(EXIT_ON_CLOSE);
              pack();
              setVisible(true);
       }
       //TextField에 들어갈 액션 리스너
       private class TextFieldActionListener implements ActionListener{
             @Override
             public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    try{
                           if(Integer.parseInt(inputField.getText()) < randomNum){
                                 guideLabel.setText("너무 낮습니다!");
                                 guideLabel.setBackground(Color.RED);
                           }
                           else if(Integer.parseInt(inputField.getText()) > randomNum){
                                 guideLabel.setText("너무 높습니다!");
                                 guideLabel.setBackground(Color.RED);
                           }
                           else{
                                 guideLabel.setText("정답입니다!");
                                 guideLabel.setBackground(Color.WHITE);
                           }
                    }
                    catch(NumberFormatException ne){
                           guideLabel.setText("잘못된 입력입니다!");
                           guideLabel.setBackground(Color.RED);
                    }
                    inputField.selectAll();
             }
       }
       //Button에 들어갈 액션 리스너
       private class ButtonActionListener implements ActionListener{
             @Override
             public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    if(e.getSource() == retryButton){
                           setRandomNum();
                           guideLabel.setText("숫자를 입력하시오.");
                           inputField.setText("");
                    }
                    else if(e.getSource() == exitButton){
                           System.exit(0);
                    }
             }
       }
       //접근자
       public int getRandomNum() {return randomNum;}
       //설정자
       public void setRandomNum() {randomNum = (int)(Math.random()*100)+1;}
       public static void main(String[] args){
             new NumberGame();
       }
}
```

#5.   
ANSWER

```
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckBoxDemo extends JPanel implements ItemListener {
	JCheckBox[] buttons = new JCheckBox[4];
	String[] fruits = { "엔진오일 교환", "자동변속기오일교환", "에어콘필터교환", "타이어 교환"};
	int[] prices = { 45000, 80000, 30000, 100000 };
	int money=0;
	JLabel label;
	
	public CheckBoxDemo() {
		super();
		// 체크 박스 생성
		for (int i = 0; i < 4; i++) {
			buttons[i] = new JCheckBox(fruits[i]);
			buttons[i].addItemListener(this);
		}
		for (int i = 0; i < 4; i++)
			add(buttons[i]);
		label = new JLabel("현재까지의 가격은"+money+"입니다.");
		label.setFont(new Font("Serif", 	// 레이블에 폰트를 설정한다. 
				Font.BOLD | Font.ITALIC, 30)); 
		add(label);
	}

	/** 체크 박스의 아이템 이벤트를 처리한다. */
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getItemSelectable();
		for (int i = 0; i < 4; i++) {
			if (source == buttons[i]) {
				if (e.getStateChange() == ItemEvent.DESELECTED)
					money -= prices[i];
				else
					money += prices[i];
				label.setText("현재까지의 가격은"+money+"입니다.");
			}
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("CheckBoxDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent newContentPane = new CheckBoxDemo();
		newContentPane.setOpaque(true); 
		frame.setContentPane(newContentPane);
		frame.setSize(500, 200);
		frame.setVisible(true);
	}
}
```