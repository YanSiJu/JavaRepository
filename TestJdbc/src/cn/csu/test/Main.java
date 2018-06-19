package cn.csu.test;

import java.sql.Connection;

public class Main {
	public static void main(String[] args) throws Exception {

		/*
		 * Properties properties = new Properties(); InputStream inStream =
		 * Main.class.getClassLoader().getResourceAsStream("dbcp.properties");
		 * properties.load(inStream);
		 * 
		 * DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
		 * 
		 * System.out.println(dataSource.getConnection().getClass().getName());
		 */

		Dao dao = new Dao();
		Connection conn = dao.getConnection();
		System.out.println(conn);

		String sql = "select * from user where id = ?";
		System.out.println(dao.getRecord(User.class, conn, sql, 21));
		

		/*
		 * sql = "INSERT INTO user VALUES (?,?)"; dao.update(conn, sql, 75, "ÌÚÑ¶");
		 */
	}

}
