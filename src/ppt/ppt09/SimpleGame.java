package ppt.ppt09;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleGame extends JFrame {
	//클래스변수
	int n1, n2, n3;
	JButton jButton1, jButton2, jButton3;
	
	public SimpleGame() throws HeadlessException {
		// 디자인 객체 생성
		setSize(300, 150);
		setTitle("슬롯머신");
		//setLayout(null);
		JPanel jPanel = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				g.setColor(Color.blue);
				g.fillOval(0, 0, 100, 100);//사각형의 상단외쪽의 좌표 0,0 이고, 사각형의 내접하는 원을 그린다. 
			}
			
		};
		//패널에 키보드 이벤트 추가
		jPanel.requestFocus();
		jPanel.setFocusable(true);
		jPanel.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("여기까지");
				// 개발자 코드 추가
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					n1 = (int) (Math.random()*10);
					jButton1.setText(""+n1);
					jButton2.setText(""+(int)(Math.random()*10));
					jButton3.setText(""+(int)(Math.random()*10));
					Graphics graphics = getGraphics();//1번만 객체를 만드는 클래스 = 싱글톤 형식으로 만든 클래스를 객체로 만드는 방법
					graphics.setColor(Color.orange);
					graphics.fillOval(0, 0, 100, 100);//왜 안될까? -> getGraphics() 이벤트 내부에서는 사용가능
				}
			}
			
		});
//		jPanel.addKeyListener(new KeyListener() {//KeyAdapter() 바꾸기 예외처리.
//			
//			@Override
//			public void keyPressed(KeyEvent e) {
//				System.out.println("여기까지");
//				// 개발자 코드 추가
//				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
//					n1 = (int) (Math.random()*10);
//					jButton1.setText(""+n1);
//					jButton2.setText(""+(int)(Math.random()*10));
//					jButton3.setText(""+(int)(Math.random()*10));
//				}
//			}
//
//			@Override
//			public void keyTyped(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		//--------------------------
		jButton1 = new JButton("" + n1);
		jButton2 = new JButton("" + n2);
		jButton3 = new JButton("" + n3);
		//Graphics graphics = getGraphics();//1번만 객체를 만드는 클래스 = 싱글톤 형식으로 만든 클래스를 객체로 만드는 방법
		//graphics.setColor(Color.orange);
		//graphics.fillOval(0, 0, 10, 10);//왜 안될까? -> 프레임이 생성되기 전에(객체가 만들어지기 전에) 그리기 때문에
		//--------------------------
		jPanel.add(jButton1);
		jPanel.add(jButton2);
		jPanel.add(jButton3);
		//-------------------------
		add(jPanel);
		setVisible(true);
	}



	public static void main(String[] args) {
		SimpleGame simpleGame = new SimpleGame();
		System.out.println("여기까지1");
	}

}