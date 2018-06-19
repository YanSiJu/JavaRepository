package cn.ccsu.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		FileInputStream in = null;
		System.out.println("begin!!");
		try {
			in = new FileInputStream("1.txt");
		} catch (FileNotFoundException e) {
			System.out.println("--->≥ˆ“Ï≥£¡À");
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("end!!");
	}

}
