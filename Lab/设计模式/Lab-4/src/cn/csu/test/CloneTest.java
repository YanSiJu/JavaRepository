package cn.csu.test;

import java.io.IOException;

import cn.csu.bean.WeeklyLog;

public class CloneTest {

	public static void main(String[] args) {

		// public WeeklyLog(String content, String name, String date)
		WeeklyLog w = new WeeklyLog("需求分析", "Mikeal", "第六周");
		WeeklyLog log = (WeeklyLog) w.clone();

		System.out.println("===浅克隆===");
		log.setDate("第七周");
		System.out.println("w:"+w+"  \nlog:"+log);
		System.out.println("w == log:" + (w == log));
		System.out.println("w.disPlayArray() == log.disPlayArray():"
				+ (w.disPlayArray() == log.disPlayArray()));

		try {
			log = (WeeklyLog) w.deepClone();
			System.out.println("\n\n===深克隆===");
			log.setDate("第七周");
			System.out.println("w:"+w+"  \nlog:"+log);
			System.out.println("w == log:" + (w == log));
			System.out.println("w.disPlayArray() == log.disPlayArray():"
					+ (w.disPlayArray() == log.disPlayArray()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
