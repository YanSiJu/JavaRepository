package cn.ccsu.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/springmvc")
@Controller
public class HelloSpringmvc {

	@SuppressWarnings("unused")
	private static final String SUCCESS = "success";

	@RequestMapping("/HelloSpring")
	public String Hello() {

		System.out.println("Hello,spring mvc");
		return "success";

	}

	@RequestMapping(value = "/TestRest/{id}", method = RequestMethod.DELETE)
	public String testRestDelete(@PathVariable("id") Integer id) {

		System.out.println("testRestDelete  id:" + id);
		return "success";
	}

	@RequestMapping(value = "/TestRest/{id}", method = RequestMethod.POST)
	public String testRestPost(@PathVariable("id") Integer id) {

		System.out.println("testRestPost  id:" + id);
		return "success";
	}

	@RequestMapping(value = "/TestRest/{id}", method = RequestMethod.PUT)
	public String testRestPut(@PathVariable("id") Integer id) {

		System.out.println("testRestPut  id:" + id);
		return "success";
	}

}
