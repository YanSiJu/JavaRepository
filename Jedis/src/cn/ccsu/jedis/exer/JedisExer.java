package cn.ccsu.jedis.exer;

import static org.junit.Assert.*;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class JedisExer {

	@Test
	public void testJedis() {
		fail("Not yet implemented");
	}

	@Test
	public void testJedisString() {
		// fail("Not yet implemented");
		Jedis jedis = new Jedis("localhost");
		System.out.println(jedis);
		System.out.println(jedis.ping());
		jedis.close();
	}

	@Test
	public void testSetStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetString() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelString() {
		fail("Not yet implemented");
	}

	@Test
	public void testTypeString() {
		fail("Not yet implemented");
	}

	@Test
	public void testKeysString() {
		fail("Not yet implemented");
	}

}
