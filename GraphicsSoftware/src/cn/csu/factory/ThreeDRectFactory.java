package cn.csu.factory;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import cn.csu.Listenerner.DrawListenerner;

public class ThreeDRectFactory extends ShapeFactory {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ThreeDRectFactory [getX()=" + getX() + ", getY()=" + getY() + ", getW()=" + getW() + ", getH()="
				+ getH() + "]";
	}

	public ThreeDRectFactory(int x1, int y1, int x2, int y2, String color, BasicStroke s) {
		super(x1, y1, x2, y2, color, s);

	}

	public ThreeDRectFactory(DrawListenerner listenerner) {
		super(listenerner);
	}

	@Override
	public void draw(Graphics2D g) {
		// 画笔大小
		g.setStroke(g.getStroke());
		// 设置画笔颜色
		color.setGraphicsColor(g);
		g.fill3DRect(getX(), getY(), getW() - getX(), getH() - getY(), true);
	}

}
