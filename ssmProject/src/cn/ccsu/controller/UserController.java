package cn.ccsu.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import cn.ccsu.bean.User;
import cn.ccsu.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	public UserController() {
		System.out.println("UserController controller:" + this.getClass().getName());
	}

	@RequestMapping("/DateTest")
	public String DateTest(HttpServletRequest request,@RequestParam("date")String date) {
		System.out.println("\ndate:"+date+"\n");
		return null;
	}

	@RequestMapping("/AjaxTest")
	public void testAjax(HttpServletResponse response) throws IOException {
		System.out.println("Hello,Ajax");
		response.getWriter().write("Ajax Info");
	}

	@RequestMapping("/registerForm")
	public String form(Map<String, Object> map) {
		map.put("user", new User());
		return "register";
	}

	@RequestMapping("/register")
	public String register(Map<String, Object> map, @Valid User user, BindingResult result) {
		System.out.println("\nvalidation user:" + user + "\n");
		if (result.getErrorCount() > 0) {
			System.out.println("出错了!");

			// result.rejectValue("birth",null, "生日的格式为:yyyy-MM-dd");
			result.rejectValue("birth", null, "生日的格式为:yyyy-MM-dd");

			for (FieldError error : result.getFieldErrors()) {

				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}

			// 若验证出错, 则转向定制的页面
			map.put("error", result);
			return "register";
		} else {
			return "login";
		}

	}

	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView exceptionHandler(Exception e) {
		System.out.println("\n错误信息:");
		e.printStackTrace();
		ModelAndView mv = new ModelAndView();
		mv.addObject("ex", e);
		return mv;
	}

	@RequestMapping("/Exception")
	public String testException(@RequestParam("m") Integer m, @RequestParam("n") Integer n) {
		System.out.println("result:" + m / n);
		return "login";
	}

	@RequestMapping("/FileUpload")
	public String testFileUpload(HttpServletRequest request, Model model, @RequestParam("file") MultipartFile file)
			throws IOException {
		System.out.println("name:" + file.getOriginalFilename());
		System.out.println("inputStream:" + file.getInputStream());
		System.out.println("path:" + request.getServletContext().getRealPath("/File/"));
		model.addAttribute("fileName", file.getOriginalFilename());

		// 如果文件不为空，写入上传路径
		if (!file.isEmpty()) {
			// 上传文件路径
			String path = request.getServletContext().getRealPath("/File/");
			// 上传文件名
			String filename = file.getOriginalFilename();
			File filepath = new File(path, filename);
			// 判断路径是否存在，如果不存在就创建一个
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			// 将上传文件保存到一个目标文件当中
			file.transferTo(new File(path + File.separator + filename));
			return "success";
		} else {
			return "error";
		}

	}

	@RequestMapping(value = "/download")
	public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("filename") String filename,
			Model model) throws Exception {
		// 下载文件路径
		String path = request.getServletContext().getRealPath("/File/");
		File file = new File(path + File.separator + filename);
		HttpHeaders headers = new HttpHeaders();
		// 下载显示的文件名，解决中文名称乱码问题
		String downloadFielName = new String(filename.getBytes("UTF-8"), "iso-8859-1");
		// 通知浏览器以attachment（下载方式）打开图片
		headers.setContentDispositionFormData("attachment", downloadFielName);
		// application/octet-stream ： 二进制流数据（最常见的文件下载）。
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}

	@RequestMapping("/SessionTest")
	public String login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("userName:" + session.getAttribute("name"));
		return "login";
	}

	@RequestMapping("/Testssm")
	public String login(Map<String, Object> map, HttpServletRequest request) {
		User user = userService.validateUser();
		map.put("user", user);

		HttpSession session = request.getSession();
		System.out.println("userName:" + request.getParameter("userName"));
		session.setAttribute("name", request.getParameter("userName"));

		return "login";
	}

}
