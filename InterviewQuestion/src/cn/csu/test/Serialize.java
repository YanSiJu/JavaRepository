package cn.csu.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import cn.csu.bean.Person;

public class Serialize {

	@Test
	public void readObject() {
		ObjectInputStream oi = null;
		try {
			oi = new ObjectInputStream(new FileInputStream("crab_file"));
			Person crab_back = (Person) oi.readObject();
			System.out.println("Hi, My name is " + crab_back.getName() + "  " + crab_back.getAddress());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (oi != null) {
				try {
					oi.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

	@Test
	public void writeObject() {
		// 把对象序列化到文件
		Person crab = new Person();
		crab.setName("Mr.Crab");
		ObjectOutputStream oo = null;
		try {
			oo = new ObjectOutputStream(new FileOutputStream("crab_file"));
			oo.writeObject(crab);
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (oo != null) {
				try {
					oo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
