package cn.csu.servlet;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cn.csu.dao.StockoutDao;
import cn.csu.entity.User;

/**
 * Servlet implementation class StockOutServlet
 */
@WebServlet("/StockOutServlet")
public class StockOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StockoutDao dao = new StockoutDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StockOutServlet() {
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
		// ��session�л�ȡ�û����̶���ȡ��id
		int userId = ((User) session.getAttribute("user")).getId();
		// ��ȡ��Ʒid
		int proId = Integer.valueOf(request.getParameter("proId"));
		// ��ȡ��Ʒ����
		int count = Integer.valueOf(request.getParameter("count"));
		LocalDate date = LocalDate.now();
		dao.stockout(userId, date, proId, count);
	}

}
