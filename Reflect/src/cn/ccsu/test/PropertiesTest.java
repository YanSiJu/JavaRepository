package cn.ccsu.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.Test;

public class PropertiesTest {

	public PropertiesTest() {

	}

	@Test
	public void propertiesTest() {
		ClassLoader loader = this.getClass().getClassLoader();
		InputStream in = loader.getResourceAsStream("db.properties");

		Properties pros = new Properties();
		try {
			pros.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("driver:" + pros.getProperty("jdbc.driver"));
		System.out.println("username:" + pros.getProperty("jdbc.username"));
		System.out.println("password:" + pros.getProperty("jdbc.password"));
		System.out.println("url:" + pros.getProperty("jdbc.url"));

	}

}
