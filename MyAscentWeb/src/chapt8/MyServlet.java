package chapt8;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		

		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		PrintWriter  out = response.getWriter();
		String url = null;
		if(username!=null && username.equals("admin")){
			//a.html
			url = "a.html";
		}
		else
		{
			//error.jsp
			url = "error.jsp";			
		}
		
		RequestDispatcher  rd = request.getRequestDispatcher(url);//url 要跳转的目的地
//			rd.forward(request, response);
		rd.include(request, response);
		
		out.println("Hello!");

		/*
		response.setContentType("text/html");//
		
		String username = request.getParameter("username");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<p style='color:red;font-size:20;'> welcome," + username + "</p>");
		out.println("</body></html>");
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
