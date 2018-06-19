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
	 * ����ͼ�εķ���
	 * 
	 * @param g���ʶ���
	 */
	@Override
	public void draw(Graphics2D g) {
		// ���û��ʵĴ�ϸ
		g.setStroke(getStroke());
		// ���û�����ɫ
		color.setGraphicsColor(g);
		// ����ֱ��
		g.drawLine(getX(), getY(), getW(), getH());
	}

}
