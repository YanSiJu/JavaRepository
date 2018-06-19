package cn.ccsu.draw.factory;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public abstract class GraphicsFactory {

	protected JFrame frame;
	protected Graphics g;

	public GraphicsFactory() {
		frame = new JFrame();
	}

	public GraphicsFactory(JFrame frame, Graphics g) {
		this.g = g;
		this.frame = frame;
	}

	public abstract void draw(Color c);
}
