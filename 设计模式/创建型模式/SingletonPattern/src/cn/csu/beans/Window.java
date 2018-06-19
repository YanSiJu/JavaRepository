package cn.csu.beans;

public class Window {

	private volatile static Window window = new Window();

	private Window() {

	}

	public static Window getWindow() {

		return window;
	}

}
