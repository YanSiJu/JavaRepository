package cn.ccsu.jedis.exer;

import java.util.List;
import redis.clients.jedis.Jedis;

public class JedisList {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		jedis.del("Linux");
		jedis.lpush("Linux", "ubuntu", "debian", "openSUSE", "centos", "Fedora", "Red Hat");
		Long len = jedis.llen("Linux");
		System.out.println("size:" + len);
		
		System.out.println("\n\n\n------lrange-------");
		List<String> linux = jedis.lrange("Linux", 0, len - 1);
		for (String lnx : linux) {
			System.out.println(lnx);
		}

		jedis.rpush("Linux", "deepin");
		System.out.println("After rpushing,len:" + jedis.llen("Linux"));

//		System.out.println("\n\n\n------sscan-------");
//		ScanResult<String> result = jedis.sscan("Linux", "0");
//		List<String> resultList = result.getResult();
//		for (String lnx : resultList) {
//			System.out.println(lnx);
//		}
		System.out.println("\nlpop-->" + jedis.lpop("Linux"));

		jedis.close();
	}

}
