package cn.csu.factory;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import cn.csu.Listenerner.DrawListenerner;

/**
 * 定义ShapeRoundRect类，该类是用来绘制圆角矩形的类
 */

public class RoundRectFactory extends ShapeFactory {

	private int arcH, arcW;

	public RoundRectFactory(DrawListenerner listenerner, int arcH, int arcW) {
		super(Math.min(listenerner.getX1(), listenerner.getX2()), Math.min(listenerner.getY1(), listenerner.getY2()),
				Math.abs(listenerner.getX1() - listenerner.getX2()),
				Math.abs(listenerner.getY1() - listenerner.getY2()), listenerner.getColorStr(), new BasicStroke());
		this.arcH = arcH;
		this.arcW = arcW;
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
		// 绘制矩形
		g.drawRoundRect(getX(), getY(), getW(), getH(), arcW, arcH);
	}

}
