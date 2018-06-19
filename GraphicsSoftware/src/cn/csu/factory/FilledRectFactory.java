package cn.csu.factory;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import cn.csu.Listenerner.DrawListenerner;

public class FilledRectFactory extends ShapeFactory {

	public FilledRectFactory(DrawListenerner listenerner) {
		super(Math.min(listenerner.getX1(), listenerner.getX2()), Math.min(listenerner.getY1(), listenerner.getY2()),
				Math.abs(listenerner.getX1() - listenerner.getX2()),
				Math.abs(listenerner.getY1() - listenerner.getY2()), listenerner.getColorStr(), new BasicStroke(1));
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
		g.fillRect(getX(), getY(), getW(), getH());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FilledRectFactory [getX()=" + getX() + ", getY()=" + getY() + ", getW()=" + getW() + ", getH()="
				+ getH() + "]";
	}

}
