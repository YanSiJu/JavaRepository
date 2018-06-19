package cn.csu.controller;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import cn.csu.entity.User;

@Controller
public class TestController {

	/**
	 * ת��ҳ��
	 */
	@RequestMapping(value = "/hello")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("index");
		return view;
	}

	/**
	 * ת��loginҳ��
	 */
	@RequestMapping(value = "/loginDispatcher")
	public ModelAndView login() {
		ModelAndView view = new ModelAndView("login");
		System.out.println("-----------------loginDispatcher-----------------");
		return view;
	}

	/**
	 * ת��ҳ��
	 */

	@ResponseBody
	@RequestMapping(value = "/login")
	public Map<String, String> login(@RequestBody User user) {
		System.out.println("-----------------login begin-----------------");
		System.out.println(user);
		Map<String, String> result = new HashMap<String, String>();
		result.put("msg", "loginSuccess!!!");
		System.out.println("-----------------login end-----------------");
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/registerValidate")
	public Map<String, String> registerValidate(@RequestBody String name) {
		System.out.println("-----------------registerValidate begin-----------------");
		System.out.println(name);
		System.out.println("-----------------registerValidate end-----------------");
		Map<String, String> result = new HashMap<>();
		result.put("msg", "error");
		return result;
	}

	
	@RequestMapping(value = "/dispatcher")
	public ModelAndView view() {
		ModelAndView view = new ModelAndView("Ajax");
		return view;
	}


	@RequestMapping(value = "/hello.json")
	@ResponseBody
	public Map<String, String> hello(@RequestBody User user) {
		System.out.println(user);
		
		Map<String, String> result = new HashMap<String, String>();

		Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

 
		result.put("username", user.getUsername());

		result.put("age", String.valueOf(user.getAge()));

		result.put("time", format.format(new Date()));
		System.out.println("-----------------Hello-----------------");
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/Ajax")
	public Map<String, String> ajax(@RequestBody String data) {
		System.out.println("-----------------ajax begin-----------------");
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(data);
			System.out.println(jsonObject + "------>" + jsonObject.get("data").toString().trim());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("data", "AJAX is not a programming language.\r\n");
		result.put("time", LocalDateTime.now().toString());
		System.out.println("-----------------ajax end-----------------");
		return result;
	}
}