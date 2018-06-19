package cn.csu.test;

import org.junit.Test;

import cn.csu.beans.Window;

import cn.csu.beans.TaskManager;

public class SingletonTest {

	@Test
	public void test(){
		
		TaskManager task = TaskManager.getTaskManager();
		Window w = Window.getWindow();
		
		System.out.println("window:"+(w == Window.getWindow()));
		System.out.println("TaskManager"+(task == TaskManager.getTaskManager()));
		
		
		/*System.out.println("task:"+task);
		System.out.println("window:"+w);*/
		
	}
}

