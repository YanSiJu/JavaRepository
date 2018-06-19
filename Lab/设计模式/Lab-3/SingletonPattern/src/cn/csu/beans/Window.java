package cn.csu.beans;

import java.io.Serializable;

public class Window implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Window window = new Window();

	private Window() {

	}

	public static Window getWindow() {

		return window;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Window [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
