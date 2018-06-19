package cn.csu.beans;

import java.io.Serializable;

public class Singleton implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static class InstanceHolder {
		private static Singleton instance = new Singleton();
	}

	private Singleton() {

	}

	public static Singleton getInstance() {
		return InstanceHolder.instance;
	}
}
