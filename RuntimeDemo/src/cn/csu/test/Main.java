package cn.csu.test;

import java.io.IOException;
import org.junit.Test;

public class Main {

	public Main() {

	}

	public static void Parameter(String... command) {
		System.out.println(command);
	}

	@Test
	public void testRuntime() {
		Parameter("opsnSUSE", "Free BSD");
		try {
			System.out.println(Runtime.getRuntime().exec("cmd"));
			System.out.println(Runtime.getRuntime().availableProcessors());
			System.out.println(Runtime.getRuntime());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static class RuntimeDemo01 {

		public static void main(String args[]) {
			Runtime run = Runtime.getRuntime(); // ͨ��Runtime��ľ�̬��������ʵ��������
			System.out.println("JVM����ڴ�����" + run.maxMemory()); // �۲������ڴ棬���ݻ����Ĳ�ͬ������Ҳ��������ͬ
			System.out.println("JVM�����ڴ�����" + run.freeMemory()); // ȡ�ó������еĿ����ڴ�
			String str = "Hello " + "World" + "!!!" + "\t" + "Welcome " + "To " + "MLDN" + "~";
			System.out.println(str);
			for (int x = 0; x < 1000; x++) {
				str += x; // ѭ���޸����ݣ�������������
			}
			System.out.println("����String֮���,JVM�����ڴ�����" + run.freeMemory());
			run.gc(); // ���������ռ����ͷſռ�
			System.out.println("��������֮���,JVM�����ڴ�����" + run.freeMemory());
		}
	};

}
