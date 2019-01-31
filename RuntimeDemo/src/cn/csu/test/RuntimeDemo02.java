package cn.csu.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class RuntimeDemo02 {

	public static void main(String args[]) {
		Runtime run = Runtime.getRuntime(); // ȡ��Runtime���ʵ��������
		Process p = null;
		try {
			p = run.exec("cmd"); // ���ñ������򣬴˷�����Ҫ�쳣����
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace(); // ��ӡ�쳣��Ϣ
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		System.out.println("\n\n\n"+sb.toString());

	}

}
