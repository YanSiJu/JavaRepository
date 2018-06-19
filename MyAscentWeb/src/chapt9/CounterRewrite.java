package chapt9;
import javax.servlet.*;
import javax.servlet.http.*;
public class CounterRewrite extends HttpServlet
    {
    static final String COUNTER_KEY = "CounterRewrite.count";
public void doGet(HttpServletRequest req,
    HttpServletResponse resp)
    throws ServletException, java.io.IOException
    {
     resp.setContentType("text/html");
     java.io.PrintWriter out = resp.getWriter();
HttpSession session = req.getSession(true);
     int count = 1;
     Integer i = (Integer) session.getValue(COUNTER_KEY);
if (i != null) {
     count = i.intValue() + 1;
     }
    session.putValue(COUNTER_KEY, new Integer(count));
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Session Counter " +"with URL rewriting</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("Your session ID is <b>" +session.getId());
    out.println("</b> and you have hit this page <b>" +count +
"</b> time(s) during this browser session");
    String url = req.getRequestURI();//+ ";" + SESSION_KEY +session.getId();
    out.println("<form method=POST action=\"" +resp.encodeURL(url) + "\">");
    out.println("<input type=submit " +"value=\"Hit page again\">");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
    out.flush();
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, java.io.IOException
   {
    doGet(req, resp);
    }
  }
