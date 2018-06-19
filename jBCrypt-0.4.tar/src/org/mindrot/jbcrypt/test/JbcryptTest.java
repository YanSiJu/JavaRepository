package org.mindrot.jbcrypt.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

public class JbcryptTest {

	@Test
	public void testHashpw() {
		fail("Not yet implemented");

		String password = "yansiju123456";
		String salt = BCrypt.gensalt();
		String hash = BCrypt.hashpw(password, salt);

		System.out.println("明文:" + password);
		System.out.println("salt:" + salt);
		System.out.println("密文:" + hash);
	}

	@Test
	public void testGensalt() {
		fail("Not yet implemented");
		for (int i = 0; i < 20; i++) {
			String salt = BCrypt.gensalt();
			System.out.println(salt + "  " + salt.length());
		}

	}

	@Test
	public void testCheckpw() {
		// fail("Not yet implemented");
		String password = "yansiju12346";
		String salt = BCrypt.gensalt();
		String hash = BCrypt.hashpw(password, salt);

		System.out.println("明文:" + password);
		System.out.println("salt:" + salt);
		System.out.println("密文:" + hash);
		System.out.println(BCrypt.checkpw("yansiju123456", hash));
	}

}
