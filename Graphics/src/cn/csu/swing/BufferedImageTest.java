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

		// 1.����һ������͸��ɫ��BufferedImage����

		BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// 2.����һ����͸��ɫ��BufferedImage����

		bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		// 3.����һ������Ļ����Ӧ��BufferedImage����

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

	// 4.��Ȼ����Ҳ������ͼ��������������һ��BufferedImage����

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

	// 2. ʹ��BufferedImage��ͼ����ã�

	// public static void main(String[] args) {
	//
	// try {
	//
	// //���ض��ļ�����
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
