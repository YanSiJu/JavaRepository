package cn.csu.beans;

public class TaskManager {

	private volatile static TaskManager singleton = null;

	private TaskManager() {

	}

	public static TaskManager getTaskManager() {

		if (singleton == null) {
			synchronized (TaskManager.class) {	//用类锁

				if (singleton == null) {
					singleton = new TaskManager();
				}
			}

		}
		return singleton;
	}

}
