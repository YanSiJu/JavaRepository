package cn.csu.factory;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import javax.swing.JFrame;

import cn.csu.Listenerner.DrawListenerner;

public class EraserFactory extends ShapeFactory {

	
	public EraserFactory(DrawListenerner listenerner) {
		super(listenerner);
	}

	@Override
	public void draw(Graphics2D g) {
		g.setStroke(new BasicStroke(20));// ÏðÆ¤´óÐ¡
		JFrame frame = new JFrame();
		g.setColor(frame.getBackground());
		g.drawLine(getX(), getY(), getW(), getH());
	}

}
