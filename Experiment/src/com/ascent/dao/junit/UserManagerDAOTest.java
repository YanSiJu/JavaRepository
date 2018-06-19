package com.ascent.dao.junit;

import java.util.List;
import org.junit.Test;
import com.ascent.dao.UserManagerDAO;
import com.ascent.entity.User;

public class UserManagerDAOTest {

	@Test
	public void testQueryAllUser() {
		// fail("Not yet implemented");
		List<User> users = new UserManagerDAO().queryAllUser();
		for (User user : users) {
			System.out.println(user);
		}
	}

}
