package basic_gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {// implements ActionListener {
	JCheckBox check;
	public MyFrame() throws HeadlessException {
		setContentPane(new MyPanel());//그래픽 패널창 추가
		//repaint();
		setSize(300, 200);
		setLocation(200, 300);
		setTitle("마이 프레임");
		setVisible(true);
		//기본배치는 BorderLayout() 이다
		setLayout(new FlowLayout());//순서대로 컴포넌트를 배치하는 레이아웃 지정
		getContentPane().setBackground(Color.yellow);
		JButton button1 = new JButton("확인");//버튼객체 생성
		JButton button2 = new JButton("종료");//버튼객체 생성
		add(button1);//버튼객체를 레이아웃에 배치
		add(button2);//버튼객체를 레이아웃에 배치
		
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("마침내 button1 눌려졌습니다.");
			}
		});
//		
//		button2.addActionListener(new ActionListener() {
//		  @Override 
//		  public void actionPerformed(ActionEvent e) { 
//			  System.exit(0); 
//		  } 
//		});
//		 
		button2.addActionListener(e->System.exit(0));
		check = new JCheckBox("CheckBox",false);
		add(check);
		check.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				System.out.println("체크상태: " + check.isSelected());
			}
		});
		addMouseListener(new MouseListener() {//마우스리스너 익명클래스는 모든 메서드가 구현되야한다.
			@Override
			public void mousePressed(MouseEvent e) {
				int img_x = e.getX();
				int img_y = e.getY();
				repaint();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}			
		});
		setVisible(true);//화면에 표시
	}

	public static void main(String[] args) {
		MyFrame frame = new MyFrame(); //객체생성
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("체크상태: " + check.isSelected());
//	}
	
	// JPanel을 상속받는 새 패널 구현
	class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			//g.setColor(Color.BLUE); // 파란색 선택
			g.drawRect(0, 0, 100, 100);
		}
	}
}
