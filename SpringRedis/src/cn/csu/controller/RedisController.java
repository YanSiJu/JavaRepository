package cn.csu.controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("redis")
public class RedisController {
	// inject the actual template
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	// inject the template as ListOperations
	// can also inject as Value, Set, ZSet, and HashOperations
	@Resource(name = "redisTemplate")
	private ListOperations<String, String> listOps;

	@Resource(name = "redisTemplate")
	private HashOperations<String, String, String> hashOps;

	@RequestMapping("add")
	public void addLink(@RequestParam(value = "key", required = false, defaultValue = "name") String key,
			@RequestParam(value = "value", required = false, defaultValue = "Obama") String value) {
		System.out.println("\n\n\n-----------addd-----------\n\n\n");
		System.out.println("redisTemplate:" + redisTemplate.getClientList());

		listOps.leftPush(key, value);
		listOps.leftPush(key, "Assad Bashar");
		listOps.leftPush(key, "Donald.J.Trump");
		listOps.leftPush(key, "Saddam");
		for (String name : listOps.range(key, 0, 3)) {
			System.out.println(name);
		}

		Map<String, String> map = new HashMap<String, String>(5);
		map.put("age", "72");
		map.put("name", "Donald John Trump");
		map.put("office", "White House");
		map.put("profession", "President");
		hashOps.putAll("person", map);

		System.out.println("\n\n\n\n" + hashOps.get("person", "name"));
		System.out.println(hashOps.get("person", "profession"));
		System.out.println(hashOps.get("person", "office"));
		System.out.println(hashOps.get("person", "age"));

		// listOps.leftPush(key, value);
		// or use template directly
		// redisTemplate.boundListOps(key).leftPush(value);
	}
}
