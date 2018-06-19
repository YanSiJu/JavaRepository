package cn.csu.factory;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.Optional;

import cn.csu.Listenerner.DrawListenerner;
import cn.csu.bridge.IColor;

public abstract class ShapeFactory {

	private int x;
	private int y;
	private int w;
	private int h;
	private String colorstr;
	private BasicStroke stroke;
	protected IColor color;

	/**
	 * @return the color
	 */
	protected IColor getColor() {
		return color;
	}

	private void setG() {
		Optional<String> op = Optional.ofNullable(colorstr);
		try {
			Class<?> clazz = Class.forName("cn.csu.bridge." + op.orElse("Black"));
			color = (IColor) clazz.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public ShapeFactory(DrawListenerner listenerner) {
		this.x = listenerner.getX1();
		this.y = listenerner.getY1();
		this.w = listenerner.getX2();
		this.h = listenerner.getY2();
		this.colorstr = listenerner.getColorStr();
		setG();
	}

	public ShapeFactory(int x1, int y1, int x2, int y2, String colorStr, BasicStroke stroke) {
		this.x = x1;
		this.y = y1;
		this.w = x2;
		this.h = y2;
		this.stroke = stroke;
		this.colorstr = colorStr;
		setG();
	}

	/**
	 * 绘制图形的方法
	 * 
	 * @param g画笔对象
	 */
	public abstract void draw(Graphics2D g);

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	protected BasicStroke getStroke() {
		return stroke;
	}

	protected void setStroke(BasicStroke stroke) {
		this.stroke = stroke;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @param w the w to set
	 */
	public void setW(int w) {
		this.w = w;
	}

	/**
	 * @param h the h to set
	 */
	public void setH(int h) {
		this.h = h;
	}

}
