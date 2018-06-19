package cn.ccsu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.ccsu.bean.User;
import cn.ccsu.mybatis.dao.UserMapper;

public class MybatisHelloWorld {

	@Test
	public void test() throws IOException {
		// 2、获取sqlSession实例，能直接执行已经映射的sql语句
		// sql的唯一标识：statement Unique identifier matching the statement to use.
		// 执行sql要用的参数：parameter A parameter object to pass to the statement.
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			User user = openSession.selectOne("com.atguigu.mybatis.dao.UserMapper.getUserById", 13);
			System.out.println(user);
		} finally {
			openSession.close();
		}

	}

	@Test
	public void test01() throws IOException {
		// 1、获取sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		// 2、获取sqlSession对象
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			// 3、获取接口的实现类对象
			// 会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
			UserMapper mapper = openSession.getMapper(UserMapper.class);
			User user = mapper.getUserById(12);
			System.out.println(mapper.getClass().getName());
			System.out.println(user);
		} finally {
			openSession.close();
		}

	}

	@Test
	public void testInsert() throws IOException {
		// 1、获取sqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		// 2、获取sqlSession对象
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			// 3、获取接口的实现类对象
			// 会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
			UserMapper mapper = openSession.getMapper(UserMapper.class);
			// public User(Integer userId, String userName, String password, String mobile,
			// String email)
			mapper.addUser(new User(1, "王强", "9891", "9819831982", "9812@163.com"));
			mapper.updateUserById(new User(12, "王_宝强", "9891", "9819831982", "9812@163.com"));

			/*
			 * System.out.println(mapper.getClass().getName()); System.out.println(user);
			 */
		} finally {
			openSession.close();
		}

	}

	public MybatisHelloWorld() {

	}

	@Test
	public void testSelect() throws IOException {
		SqlSessionFactory sqlSessionFactory = this.getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();

		try {
			UserMapper mapper = openSession.getMapper(UserMapper.class);
			User user = mapper.selectUser("Linus", "8771339123");
			System.out.println("mapper:" + mapper.getClass().getName());
			System.out.println("user:" + user);
		} finally {
			openSession.close();
		}
	}

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

}
