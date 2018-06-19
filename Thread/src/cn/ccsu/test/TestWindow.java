package cn.ccsu.test;

import java.util.Scanner;

import cn.ccsu.thread.Window;

public class TestWindow {

	public static void main(String[] args) {

		Window window = new Window();
		Scanner in = new Scanner(System.in);
		
		System.out.println("请输入票数:");
		window.setTicket(in.nextInt());
		in.close();

		Thread firstWindow = new Thread(window);
		Thread secondWindow = new Thread(window);
		Thread thirdWindow = new Thread(window);

		firstWindow.setName("===>窗口1");
		secondWindow.setName("窗口2");
		thirdWindow.setName("窗口3");

		firstWindow.start();
		secondWindow.start();
//		thirdWindow.start();

	}

}
