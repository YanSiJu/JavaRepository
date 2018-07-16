package com.alibaba.controller;

import java.util.HashMap;
import java.util.List;
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

import com.alibaba.entity.Post;
import com.alibaba.entity.User;
import com.alibaba.service.PostService;

/**
 * @author Bill
 * @title: PostController.java
 * @Package: com.alibaba.controller
 * @Description: TODO
 * @date:2018年7月12日 下午3:33:01
 * @version:V1.0
 */
@Controller
@RequestMapping("post")
public class PostController {

	/**
	 * 
	 */
	@Autowired
	private PostService service;

	/**
	 * 
	 * 方法名：post</br>
	 * 详述：处理用户发的帖子</br>
	 * 开发人员：Bill </br>
	 * 创建时间：2018年7月12日 </br>
	 * 
	 * @param data
	 * @param request
	 * @return @throws
	 * 
	 */
	@RequestMapping("post")
	@ResponseBody
	public Map<String, String> post(@RequestBody String data, HttpServletRequest request) {
		Map<String, String> map = new HashMap<>(1);
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

	@RequestMapping("displayPosts")
	@ResponseBody
	public Map<String, String> displayPosts() {
		Map<String, String> map = new HashMap<>(1);
		List<Post> posts = service.queryAndOrderPosts();
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("posts", posts);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		map.put("posts", jsonObject.toString());
		return map;
	}

	@RequestMapping("praise")
	@ResponseBody
	public Map<String, String> praise(@RequestBody String data, HttpServletRequest request) {
		Map<String, String> map = new HashMap<>(1);
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(data);
			int postId = (int) jsonObject.get("postId");
			User user = (User) request.getSession().getAttribute("user");
			if (user != null) {
				if (service.praise(postId, user.getUserId())) {
					map.put("msg", "1");
				} else {
					map.put("msg", "0");
				}
			} else {
				map.put("msg", "0");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping("commentPosts")
	@ResponseBody
	public Map<String, String> commentPosts(@RequestBody String data, HttpServletRequest request) {
		Map<String, String> map = new HashMap<>(1);
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(data);
			String comment = (String) jsonObject.get("comment");
			int postId = (int) jsonObject.get("postId");
			User user = (User) request.getSession().getAttribute("user");
			if (user != null) {
				service.commentPost(comment, user.getUserId(), postId);
				map.put("msg", "1");
			} else {
				map.put("msg", "0");
			}
		} catch (JSONException e) {
			map.put("msg", "0");
			e.printStackTrace();
		}
		return map;
	}
}
