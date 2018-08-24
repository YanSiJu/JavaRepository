package cn.csu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.csu.entity.User;

@Controller
@RequestMapping("RedisTemplate")
public class RedisTemplateController {

	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;

	@SuppressWarnings("unchecked")
	@RequestMapping("findAll")
	public void findAll() {
		// -----------------String�������ݲ��� start--------------------
		ValueOperations<String, String> stringOperations = redisTemplate.opsForValue();
		// String�������ݴ洢�������ù���ʱ�䣬�����Ա���
		stringOperations.set("string1", "fiala");
		// String�������ݴ洢�����ù���ʱ��Ϊ80�룬����TimeUnit����ʱ�䵥λ
		stringOperations.set("string2", "fiala", 80, TimeUnit.SECONDS);
		// �ж�keyֵ�Ƿ���ڣ������򲻴洢����������洢
		stringOperations.setIfAbsent("string1", "my fiala");
		stringOperations.setIfAbsent("string3", "my fiala");
		String value1 = stringOperations.get("string1");
		String value2 = stringOperations.get("string3");
		System.out.println(value1);
		System.out.println(value2);
		// -----------------String�������ݲ��� end--------------------

		// -----------------����ֵ�������ݲ��� start--------------------
		User demo = new User();
		demo.setId("1");
		demo.setName("fiala");
		List<User> demos = new ArrayList<User>();
		ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
		// ����valueΪ�������ͣ��Ҳ����ù���ʱ�䣬Ĭ������
		valueOperations.set("value1", demo);
		// ����valueΪ�������ͣ����ù���ʱ��Ϊ80�룬ʱ�䵥λ��TimeUnit����
		valueOperations.set("value2", demos, 80, TimeUnit.SECONDS);
		User demo1 = (User) valueOperations.get("value1");
		System.out.println(demo1.toString());
		// -----------------����ֵ�������ݲ��� end--------------------

		// -----------------List�������Ͳ��� start------------------
		ListOperations<String, Object> listOperations = redisTemplate.opsForList();
		for (int i = 0; i < 5; i++) {
			User userDemo = new User();
			userDemo.setId("\"" + i + "\"");
			userDemo.setName("fiala" + i);
			listOperations.leftPush("list1", userDemo);
			listOperations.rightPush("list2", userDemo);
		}
		// �ɸ���������
		User demo2 = (User) listOperations.leftPop("list1");
		User demo3 = (User) listOperations.rightPop("list2");
		System.out.println(demo2.toString());
		System.out.println(demo3.toString());
		// -----------------List�������Ͳ��� end------------------

		// -----------------set�������Ͳ��� start------------------
		SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
		for (int i = 0; i < 5; i++) {
			User setDemo = new User();
			setDemo.setId("\"" + i + "\"");
			setDemo.setName("fiala" + i);
			setOperations.add("set1", setDemo);
		}
		User demo4 = (User) setOperations.pop("set1");
		System.out.println(demo4.toString());
		// -----------------set�������Ͳ��� end------------------

		// -----------------zset�������Ͳ��� start------------------
		ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();
		zSetOperations.add("zset", "fiala", 0);
		zSetOperations.add("zset", "my fiala", 1);
		System.out.println(zSetOperations.rangeByScore("zset", 0, 1));
		// -----------------zset�������Ͳ��� end------------------

		// -----------------hash�������Ͳ��� start------------------
		HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
		Map<String, String> map = new HashMap<String, String>();
		map.put("map1", "fiala1");
		map.put("map2", "fiala2");
		hashOperations.putAll("hash", map);
		System.out.println(hashOperations.entries("hash"));
		// -----------------hash�������Ͳ��� end------------------
	}
}
