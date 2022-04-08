﻿package ppt08;
import java.awt.*;
import javax.swing.*;

public class TempConverter extends JFrame {
	public TempConverter() {
		JPanel panel = new JPanel();		// (1)
		add(panel);

		JLabel label1 = new JLabel("화씨 온도");		// (2)
		JLabel label2 = new JLabel("섭씨 온도");
		JTextField field1 = new JTextField(15);
		JTextField field2 = new JTextField(15);
		JButton button = new JButton("변환");

		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(button);

		setSize(300, 150);						// (3) 
		setTitle("온도변환기");
		setVisible(true);
	}

	public static void main(String argv[]) {
		TempConverter f = new TempConverter();
	}
}