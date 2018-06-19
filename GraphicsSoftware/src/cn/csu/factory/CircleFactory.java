package cn.csu.factory;

import java.awt.Graphics2D;

import cn.csu.Listenerner.DrawListenerner;

public class CircleFactory extends ShapeFactory {

	public CircleFactory(DrawListenerner listenerner) {
		super(listenerner);
	}

	@Override
	public void draw(Graphics2D g) {
		// 画笔大小
		g.setStroke(g.getStroke());
		// 设置画笔颜色
		color.setGraphicsColor(g);
		// 绘制圆的方法
		g.fillOval(getX(), getY(), getW() - getX(), getH() - getY());
	}

}
