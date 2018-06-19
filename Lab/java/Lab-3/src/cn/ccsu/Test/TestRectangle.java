package cn.ccsu.Test;

import java.util.Scanner;

import cn.ccsu.basic.Rectangle;

public class TestRectangle {

	public static void main(String... args) {

		System.out.println("请输入长方形的长、宽：");
		Scanner in = new Scanner(System.in);
		Rectangle r = new Rectangle(in.nextDouble(), in.nextDouble());

		r.printWay();
		System.out.println("\n");
		r.printWay('*');

		in.close();

	}
}
