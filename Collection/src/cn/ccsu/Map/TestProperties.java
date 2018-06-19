package cn.ccsu.Map;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.junit.Test;

public class TestProperties {
	
	
	@Test
	public void test() throws FileNotFoundException, IOException{
		
		
		
		Properties property = new Properties();
		property.load(new FileInputStream(new File("jdbc.Properties")));
		
		System.out.println("user:"+property.getProperty("user"));
		System.out.println("password:"+property.getProperty("password"));
		System.out.println("class:"+property.getProperty("class"));
		
		
		
	}

}
