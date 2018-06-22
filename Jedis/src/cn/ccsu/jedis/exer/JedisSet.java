package cn.ccsu.jedis.exer;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanResult;

public class JedisSet {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		String key = "LinuxSet";

		jedis.sadd(key, "ubuntu", "debian", "openSUSE", "centos", "Fedora", "Red Hat");
		System.out.println("size:" + jedis.scard(key));

		Set<String> members = jedis.smembers(key);
		System.out.println("members:" + members);

		ScanResult<String> scanResult = jedis.sscan("LinuxSet", "0");
		for (String result : scanResult.getResult()) {
			System.out.println(result);
		}
		System.out.println(jedis.sismember(key, "ubuntu"));
		System.out.println(jedis.sismember(key, "Unix"));

		jedis.del(key);
		jedis.close();
	}
}
