package cn.csu.factory;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import cn.csu.Listenerner.DrawListenerner;

public class LineFactory extends ShapeFactory {

	public LineFactory(int x1, int y1, int x2, int y2, String color, BasicStroke stroke) {
		super(x1, y1, x2, y2, color, stroke);
	}

	public LineFactory(DrawListenerner listenerner) {
		super(listenerner);
		this.setStroke(new BasicStroke(1));
	}

	/**
	 * 绘制图形的方法
	 * 
	 * @param g画笔对象
	 */
	@Override
	public void draw(Graphics2D g) {
		// 设置画笔的粗细
		g.setStroke(getStroke());
		// 设置画笔颜色
		color.setGraphicsColor(g);
		// 绘制直线
		g.drawLine(getX(), getY(), getW(), getH());
	}

}
