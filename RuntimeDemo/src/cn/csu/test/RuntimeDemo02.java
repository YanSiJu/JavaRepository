package cn.csu.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class RuntimeDemo02 {

	public static void main(String args[]) {
		Runtime run = Runtime.getRuntime(); // 取得Runtime类的实例化对象
		Process p = null;
		try {
			p = run.exec("cmd"); // 调用本机程序，此方法需要异常处理
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace(); // 打印异常信息
			// System.out.println(e) ;
		}
		if (p != null) {
			p.destroy();
		}

	}

	@Test
	public void execCommand() {
		String command = "ipconfig -all";
		String s = "IPv4";
		String line = null;
		StringBuilder sb = new StringBuilder();
		Runtime runtime = Runtime.getRuntime();
		try {
			Process process = runtime.exec(command);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line + "\n");
				if (line.contains(s)) {
					System.out.println(line);
				}
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println("\n\n\n"+sb.toString());

	}

}
