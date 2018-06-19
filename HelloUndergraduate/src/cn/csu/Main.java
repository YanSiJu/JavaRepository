package cn.csu;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

		Random r = new Random();

		System.out.println(r.nextInt(500) % (500 - 20 + 1) + 20);
	}

}
