package summerCamp6;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class ShapeFillRect extends Shape {
	public ShapeFillRect(int x1, int y1, int x2, int y2, Color color, BasicStroke s) {
		super(x1, y1, x2, y2, color, s);
	}

	/**
	 * 绘制图形的方法
	 * 
	 * @param g画笔对象
	 */
	@Override
	public void draw(Graphics2D g) {
		g.setStroke(getStroke());// 设置画笔的粗细
		g.setColor(getColor());// 设置画笔的颜色
		g.fillRect(getX1(), getY1(), getX2(), getY2());// 绘制矩形
	}

}
