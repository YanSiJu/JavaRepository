package cn.csu.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.junit.Test;
import cn.csu.beans.DrawPanel;

public class DrawPanelTest {

	@Test
	public void testGetPanel() {

	}

	public static void main(String[] args) {

		Runnable run = new Runnable() {
			@Override
			synchronized public void run() {
				System.out.println(Thread.currentThread().getName() + ":" + DrawPanel.getPanel().hashCode() + "\n");
				System.out.println(Thread.currentThread().getName() + "--->end\n");
			}
		};

		new Thread(run).start();
		new Thread(run).start();

	}

}

class CallableTest {
	public static void main(String[] args) {

		DrawPanel panel_1 = null;
		DrawPanel panel_2 = null;

		Callable<DrawPanel> call = new Callable<DrawPanel>() {

			@Override
			public DrawPanel call() throws Exception {
				System.out.println(Thread.currentThread().getName());
				return DrawPanel.getPanel();
			}
		};
		FutureTask<DrawPanel> task = new FutureTask<>(call);
		FutureTask<DrawPanel> t = new FutureTask<>(call);

		new Thread(task).start();
		try {
			panel_1 = task.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		new Thread(t).start();
		try {
			panel_2 = t.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println(panel_1 == panel_2);
	}
}
