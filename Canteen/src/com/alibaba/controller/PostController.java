package com.alibaba.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.entity.User;
import com.alibaba.service.PostService;

@Controller
@RequestMapping("post")
public class PostController {

	@Autowired
	private PostService service;

	@RequestMapping("post")
	@ResponseBody
	public Map<String, String> post(@RequestBody String data, HttpServletRequest request) {
		Map<String, String> map = new HashMap<>();
		try {
			JSONObject jsonObj = new JSONObject(data);
			int userId = 0;
			String title = jsonObj.getString("title");
			String content = jsonObj.getString("content");
			HttpSession session = request.getSession();
			User u = (User) session.getAttribute("user");
			if (u != null) {
				userId = u.getUserId();
				service.post(title, content, userId);
			}
			map.put("msg", "1");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return map;
	}

}
