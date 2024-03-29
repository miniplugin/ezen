﻿package ppt.ppt14;
import javax.swing.*;

import java.awt.*;
public class CountDownTest extends JFrame {

	private JLabel label;

	public class MyRunnable implements Runnable {

		@Override
		public void run() {
			for (int i = 10; i >= 0; i--) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				label.setText(i + "");
			}
		}

	}
	public CountDownTest() {
		setTitle("카운트다운");
		setSize(400, 150);
		label = new JLabel("Start");
		label.setFont(new Font("Serif", Font.BOLD, 100));
		add(label);
		setVisible(true);
		Thread thread = new Thread(new MyRunnable());
		thread.start();
	}

	public static void main(String[] args) {
		CountDownTest t = new CountDownTest();
	}
}