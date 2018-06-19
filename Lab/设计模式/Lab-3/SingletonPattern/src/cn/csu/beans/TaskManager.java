package cn.csu.beans;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class TaskManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 用volatile修饰防止指令重排
	private volatile static TaskManager singleton = null;

	// 构造器私有，防止外界用new创建对象
	private TaskManager() {

	}

	private Object readResolve() throws ObjectStreamException {
		// instead of the object we're on,
		// return the class variable INSTANCE
		System.out.println("readResolve() method!!");
		return singleton;
	}

	public static TaskManager getTaskManager() {

		if (singleton == null) { // 双重检测机制
			synchronized (TaskManager.class) { // 用类锁

				if (singleton == null) { // 双重检测机制
					singleton = new TaskManager();
				}
			}

		}
		return singleton;
	}

}
