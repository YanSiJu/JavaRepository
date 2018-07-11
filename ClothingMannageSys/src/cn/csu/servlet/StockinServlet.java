package cn.csu.servlet;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cn.csu.entity.User;
import cn.csu.dao.StockinDao;

/**
 * Servlet implementation class StockinServlet
 */
@WebServlet("/StockinServlet")
public class StockinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StockinDao dao = new StockinDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StockinServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		// 从session中获取用户，继而获取其id
		int userId = ((User) session.getAttribute("user")).getId();
		int proId = Integer.valueOf(request.getParameter("proId"));
		String remark = "...";
		int wareId = Integer.valueOf(request.getParameter("wareId"));
		int count = Integer.valueOf(request.getParameter("count"));
		LocalDate date = LocalDate.now();
		dao.stockin(userId, wareId, date, remark, proId, count);
	}

}
