package cn.ccsu.draw.factory;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RecFactory extends GraphicsFactory {

	public RecFactory() {
		super();
	}

	public RecFactory(JFrame frame, Graphics g) {
		super(frame,g);
	}

	@Override
	public void draw(Color c) {

		JPanel panel = new JPanel() { // 初始化一个新画布
			private static final long serialVersionUID = 1L; // 不用管，可加可不加

			@Override
			public void paint(Graphics g) { // 重写 pait 方法
				super.paint(g); // 这个要加上，但不加也能正常显示
				g.setColor(Color.PINK); // 设置画笔颜色
				g.fillRect(80, 60, 40, 60); // 填充一个矩形

			}
		};
		frame.setContentPane(panel);
		System.out.println("frame:" + frame);
	}

}
