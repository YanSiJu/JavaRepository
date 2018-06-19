package chapt8;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import javax.sql.*;
import java.sql.*;

import javax.naming.*;

public class DBServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		try {
			/*
			 * Context initCtx = new InitialContext(); Context envCtx =
			 * (Context) initCtx.lookup("java:comp/env"); DataSource ds =
			 * (DataSource)envCtx.lookup("jdbc/ascentweb"); Connection con =
			 * ds.getConnection();
			 */

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ascentweb", "root", "123456");

			PrintWriter out = res.getWriter();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM usr";
			ResultSet rs = stmt.executeQuery(query);
			dispResultSet(rs, out);
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void dispResultSet(ResultSet rs, PrintWriter out)
			throws SQLException {
		out.println("<html><head><title>Students</title><head><body>");
		while (rs.next()) {
			out.println("<p>");
			out.println("id: " + rs.getString(1));
			out.println("name: " + rs.getString(2));
			out.println("</p>");
		}
		out.println("</body></html>");
	}
}
