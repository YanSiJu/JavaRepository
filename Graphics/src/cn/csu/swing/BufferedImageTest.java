package cn.csu.swing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

public class BufferedImageTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// TODO Auto-generated method stub

		int width = 100;

		int height = 100;

		// 1.创建一个不带透明色的BufferedImage对象

		BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// 2.创建一个带透明色的BufferedImage对象

		bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		// 3.创建一个与屏幕相适应的BufferedImage对象

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

		GraphicsDevice gs = ge.getDefaultScreenDevice();

		GraphicsConfiguration gc = gs.getDefaultConfiguration();

		// Create an image that does not support transparency

		bimage = gc.createCompatibleImage(width, height, Transparency.OPAQUE);

		// Create an image that supports transparent pixels

		bimage = gc.createCompatibleImage(width, height, Transparency.BITMASK);

		// Create an image that supports arbitrary levels of transparency

		bimage = gc.createCompatibleImage(width, height,

				Transparency.TRANSLUCENT);

	}

	// 4.当然我们也可以在图形上下文来创建一个BufferedImage对象

	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		int width = 100;

		int height = 100;

		// Create an image that does not support transparency

		@SuppressWarnings("unused")
		BufferedImage bimage = g2d.getDeviceConfiguration()

				.createCompatibleImage(width, height, Transparency.OPAQUE);

		// Create an image that supports transparent pixels

		bimage = g2d.getDeviceConfiguration().createCompatibleImage(width,

				height, Transparency.BITMASK);

		// Create an image that supports arbitrary levels of transparency

		bimage = g2d.getDeviceConfiguration().createCompatibleImage(width,

				height, Transparency.TRANSLUCENT);

	}

	// 2. 使用BufferedImage的图像剪裁：

	// public static void main(String[] args) {
	//
	// try {
	//
	// //从特定文件载入
	//
	// BufferedImage bi = ImageIO.read(new File("c:\\test.jpg"));
	//
	// bi.getSubimage(0, 0, 10, 10);
	//
	// } catch (IOException e) {
	//
	// e.printStackTrace();
	//
	// }

}
