package chapt9;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * <p>This is a simple servlet that displays all of the
 * cookies present in the request
 */
public class CookiesTest extends HttpServlet
{
   /**
   * <p>Performs the HTTP GET operation
   *
   * @param req The request from the client
   * @param resp The response from the servlet
   */
   public void doGet(HttpServletRequest req,
    HttpServletResponse resp)
    throws ServletException, java.io.IOException
   {
     // Set the content type of the response
     resp.setContentType("text/html");
// Get the PrintWriter to write the response
     java.io.PrintWriter out = resp.getWriter();
// Get an array containing all of the cookies
     Cookie cookies[] = req.getCookies();
// Write the page header
     out.println("<html>");
     out.println("<head>");
     out.println("<title>Servlet Cookie Information</title>");
     out.println("</head>");
     out.println("<body>");
     if ((cookies == null) || (cookies.length == 0)) {
      out.println("No cookies found");
     }
     else {
      out.println("<center><h1>Cookies found in the request</h1>");
      // Display a table with all of the info
      out.println("<table border>");
      out.println("<tr><th>Name</th><th>Value</th>" +
       "<th>Comment</th><th>Max Age</th></tr>");
for (int i = 0; i < cookies.length; i++) {
        Cookie c = cookies[i];
        out.println("<tr><td>" + c.getName() + "</td><td>" +
        c.getValue() + "</td><td>" +
        c.getComment() + "</td><td>" +
        c.getMaxAge() + "</td></tr>");
      }
     out.println("</table></center>");
    }
     // Wrap up
     out.println("</body>");
     out.println("</html>");
     out.flush();
   }
}
