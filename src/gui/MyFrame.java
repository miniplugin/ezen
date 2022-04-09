package gui;

import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {

	public MyFrame() throws HeadlessException {
		setSize(300, 200);
		setTitle("마이 프레임");
		setVisible(true);
		//기본배치는 BorderLayout() 이다
		setLayout(new FlowLayout());//순서대로 컴포넌트를 배치하는 레이아웃 지정
		JButton button = new JButton("버튼");//버튼객체 생성
		add(button);//버튼객체를 레이아웃에 배치
		setVisible(true);//화면에 표시
	}

	public static void main(String[] args) {
		MyFrame frame = new MyFrame(); //객체생성
	}

}
