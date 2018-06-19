package cn.csu.factory;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import cn.csu.Listenerner.DrawListenerner;

/**
 * ����ShapeRoundRect�࣬��������������Բ�Ǿ��ε���
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
		// ���ƾ���
		g.drawRoundRect(getX(), getY(), getW(), getH(), arcW, arcH);
	}

}
