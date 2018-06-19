package cn.csu.list;

import org.junit.Test;

import cn.csu.entity.User;

public class HashCodeTest {

	public HashCodeTest() {

	}

	@Test
	public void testHashCode() {
		User user = new User();
		User u = new User();
		System.out.println(user + "  " + user.hashCode());
		System.out.println(u + "  " + u.hashCode());
	}

}
