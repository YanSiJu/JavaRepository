package cn.csu.test;


import java.io.InputStream;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Properties properties = new Properties();
		InputStream inStream = Main.class.getClassLoader()
				.getResourceAsStream("dbcp.properties");
		properties.load(inStream);
		
		DataSource dataSource = 
				BasicDataSourceFactory.createDataSource(properties);
		
		System.out.println(dataSource.getConnection()); 
	}
	
}
