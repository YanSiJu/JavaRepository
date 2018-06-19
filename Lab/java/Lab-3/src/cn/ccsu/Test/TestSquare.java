package cn.ccsu.Test;

import java.util.Scanner;
import cn.ccsu.basic.Square;

public class TestSquare {

	public static void main(String... args) {

		System.out.println("请输入正方形的边长:");
		Scanner in = new Scanner(System.in);
		Square s = new Square(in.nextDouble());

		s.printWay();
		System.out.println("\n");
		s.printWay('$');
		
		in.close();

	}
}
