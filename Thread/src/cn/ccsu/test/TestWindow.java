package cn.ccsu.test;

import java.util.Scanner;

import cn.ccsu.thread.Window;

public class TestWindow {

	public static void main(String[] args) {

		Window window = new Window();
		Scanner in = new Scanner(System.in);
		
		System.out.println("������Ʊ��:");
		window.setTicket(in.nextInt());
		in.close();

		Thread firstWindow = new Thread(window);
		Thread secondWindow = new Thread(window);
		Thread thirdWindow = new Thread(window);

		firstWindow.setName("===>����1");
		secondWindow.setName("����2");
		thirdWindow.setName("����3");

		firstWindow.start();
		secondWindow.start();
//		thirdWindow.start();

	}

}
