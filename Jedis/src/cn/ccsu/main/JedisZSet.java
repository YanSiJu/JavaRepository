package cn.ccsu.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class JedisZSet {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		String key = "MyLinux";
		Map<String, Double> scoreMembers = new HashMap<String, Double>();
		scoreMembers.put("ubuntu", 0d);
		scoreMembers.put("Red Hat", 0d);
		scoreMembers.put("OpenSUSE", 1d);
		scoreMembers.put("archLinux", 2d);
		scoreMembers.put("Fedora", 3d);
		scoreMembers.put("centOS", 0d);

		System.out.println(jedis.ping());
//		jedis.flushDB();
		jedis.zadd(key, 4d, "unix");
		jedis.zadd(key, scoreMembers);
		System.out.println("len: " + jedis.zcard(key));

		System.out.println("\n-----------zrangeByScore------------");
		for (String lnx : jedis.zrangeByScore(key, 0d, 4d)) {
			System.out.print(lnx + "  ");
		}

		System.out.println("\n-----------zrange------------");
		for (String lnx : jedis.zrange(key, 1, 4)) {
			System.out.print(lnx + "  ");
		}

		jedis.close();
	}

	@Test
	public void testSortSet() {
		Jedis jedis = new Jedis("localhost");
		// �������
		System.out.println(jedis.flushDB());
		String key = "mysortset";

		Map<String, Double> scoreMembers = new HashMap<String, Double>();
		scoreMembers.put("aaa", 1001.0);
		scoreMembers.put("bbb", 1002.0);
		scoreMembers.put("ccc", 1003.0);

		// �������
		jedis.zadd(key, 1004.0, "ddd");
		jedis.zadd(key, scoreMembers);

		// ��ȡһ������ļ����еĳ�Ա����
		System.out.println(jedis.zcard(key));

		// ���صĳ�Ա��ָ����Χ�ڵ����򼯺ϣ���0��ʾ���򼯵�һ����Ա����1��ʾ���򼯵ڶ�����Ա���Դ����ơ�
		// �����±꣬��-1��ʾ���һ����Ա��-2��ʾ�����ڶ�����Ա
		Set<String> coll = jedis.zrange(key, 0, -1);
		System.out.println(coll);

		// ���صĳ�Ա��ָ����Χ�ڵ����򼯺�
		coll = jedis.zrevrange(key, 0, -1);
		System.out.println(coll);

		// Ԫ���±�
		System.out.println(jedis.zscore(key, "bbb"));

		// ɾ��Ԫ��
		System.out.println(jedis.zrem(key, "aaa"));
		System.out.println(jedis.zrange(key, 0, -1));

		// ����ֵ��Χ�ڵĳ�Ա��
		System.out.println(jedis.zcount(key, 1002.0, 1003.0));

		jedis.close();
	}

}
