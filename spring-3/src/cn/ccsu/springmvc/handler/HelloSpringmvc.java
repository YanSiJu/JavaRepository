package cn.ccsu.springmvc.handler;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.ccsu.springmvc.entities.Person;

@RequestMapping("/springmvc")
@Controller
public class HelloSpringmvc {

	private static final String SUCCESS = "success";
	
	public HelloSpringmvc() {
		
		System.out.println("HelloSpringmvc  constructor!!");
	}

	@RequestMapping("/HelloSpring")
	public String Hello(HttpServletRequest  request) {

		System.out.println("Hello,spring mvc"+"\nrequest:"+request);
		System.out.println("name:"+request.getParameter("username")+"  age:"+request.getParameter("age"));
		return "success";

	}
	
	@RequestMapping("/TestPOJO")
	public void testPOJO(Person p,HttpServletRequest request,HttpServletResponse response,Writer out) throws IOException {
		System.out.println(p+"\nrequest:"+request+"\nresponse:"+response);
		out.write("Hello,cortana!!");
//		return SUCCESS;
	}
	
	

	@RequestMapping("/TestRequestParam")
	public String testRequestParam(@RequestParam("username") String name,
			@RequestParam(value = "age",required=false,defaultValue="0") Integer age) {
		System.out.println("TestRequestParam  name:" + name + "  age:" + age);
		return SUCCESS;
	}

	
	
	@RequestMapping(value = "/TestRestDelete/{id}", method = RequestMethod.DELETE)
	public String testRestDelete(@PathVariable("id") Integer id) {

		System.out.println("testRestDelete  id:" + id);
		return "success";
	}

	@RequestMapping(value = "/TestRest/{id}", method = RequestMethod.POST)
	public String testRestPost(@PathVariable("id") Integer id) {

		System.out.println("testRestPost  id:" + id);
		return "success";
	}

	@RequestMapping(value = "/TestRestPut/{id}", method = RequestMethod.PUT)
	public String testRestPut(@PathVariable("id") Integer id) {

		System.out.println("testRestPut  id:" + id);
		return "success";
	}

}
