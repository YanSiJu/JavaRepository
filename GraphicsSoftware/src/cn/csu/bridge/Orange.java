package cn.csu.bridge;

import java.awt.Color;
import java.awt.Graphics2D;

public class Orange implements IColor {

	@Override
	public void setGraphicsColor(Graphics2D g) {
		g.setColor(Color.ORANGE);
	}

}
