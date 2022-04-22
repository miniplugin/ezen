package ppt.ppt11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GrayScaleImage extends JFrame {

	BufferedImage image;
	int width;
	int height;

	public GrayScaleImage() {
		try {
			File input = new File("./src/miniproject/p14/image/alien.png");

			image = ImageIO.read(input);
			width = image.getWidth();
			height = image.getHeight();
			//Coordinate out of bounds 좌표크기를 벗어난다는 예외가 발생하면 width, height 위치를 바꾼다.
			//이유는 정사각형일 때만 모든 좌표의 색상을 회색으로 변경할 수 있다.
			for (int r = 0; r < width; r++) {
				for (int c = 0; c < height; c++) {
					Color color = new Color(image.getRGB(r, c));
					int red = (int) (color.getRed());
					int green = (int) (color.getGreen());
					int blue = (int) (color.getBlue());
					int avg = (red + green + blue) / 3;
					Color newColor = new Color(avg, avg, avg);

					image.setRGB(r, c, newColor.getRGB());
				}
			}

			File ouptut = new File("./src/miniproject/p14/image/output.png");
			ImageIO.write(image, "png", ouptut);
			add(new MyPanel());
			pack();
			setVisible(true);

		} catch (Exception e) {
			System.out.println("이미지 읽기 실패!" + e.getMessage());
		}

	}

	class MyPanel extends JPanel {

		public void paintComponent(Graphics g) {
			g.drawImage(image, 0, 0, null);
		}

		public Dimension getPreferredSize() {
			if (image == null) {
				return new Dimension(100, 100);
			} else {
				return new Dimension(image.getWidth(null),
						image.getHeight(null));
			}
		}
	}

	static public void main(String args[]) throws Exception {
		GrayScaleImage obj = new GrayScaleImage();
	}
}