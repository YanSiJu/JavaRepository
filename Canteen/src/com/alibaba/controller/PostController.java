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


/**
* @author Bill
* @itle: PostController.java
* @Package: com.alibaba.controller
* @Description: TODO
* @date:2018年7月12日 下午2:50:16
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
	 * @param data
	 * @param request
	 * @return
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

}
