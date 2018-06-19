package cn.ccsu.basic;

import cn.ccsu.IServices.IPrintable;

public class Rectangle implements IPrintable {

	private Double length;
	private Double width;

	public Rectangle() {

	}

	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + "]";
	}

	public Rectangle(double length, double width) {

		this.length = length;
		this.width = width;

	}

	// 返回矩形的周长
	public double calculatePerimeter() {

		return (this.length + this.width) * 2;
	}

	// 返回矩形的面积
	public double calculateArea() {

		return this.length * this.width;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	@Override
	public void printWay() {
		// TODO Auto-generated method stub

		System.out.println("长：" + this.length + "	宽:" + this.width);
		System.out.println("周长：" + this.calculatePerimeter() + "	面积："
				+ this.calculateArea());

	}

	@Override
	public void printWay(char icon) {
		// TODO Auto-generated method stub

		for (int i = 0; i < this.width; i++)
			for (int j = 0; j < this.length; j++) {

				System.out.print(icon);
				if (j == this.length - 1) {

					System.out.println();
				}

			}
	}

}
