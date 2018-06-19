package cn.csu.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class Check
 */
@WebServlet("/Check")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Check() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 读取请求内容
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		// 将json字符串转换为json对象
		try {
			JSONObject json = new JSONObject(sb.toString());
			System.out.println("jsonobj--->" + json);
			sendJson(response);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public void sendJson(HttpServletResponse response) throws JSONException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Writer out = response.getWriter();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message", "用户登录成功！");
		jsonObject.put("age", 58);
		out.write(jsonObject.toString());
		out.flush();
	}
}
