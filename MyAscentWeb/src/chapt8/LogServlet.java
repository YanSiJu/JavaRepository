package chapt8;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
public class LogServlet extends HttpServlet {
        private PrintWriter pw;
        public void init(ServletConfig conf) throws
                ServletException {
                super.init(conf);
                log("LogServlet.initialize: enter");
                String logFileName = getInitParameter("logFileName");
                System.out.println(logFileName);
                try {
                    pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(logFileName,true)),true);
                }catch(Exception e) { throw new ServletException(e); }
                log("LogServlet:initialize:end ");
        }
        public void service(HttpServletRequest req,
                HttpServletResponse res) throws IOException {
                String data = "Hello World from Lixin!";
                data = data + "haha";
                this.writeToFile(data);
       }
        private synchronized void writeToFile(String data) {
               pw.println(data);
        }
        public void destroy() {
                try {
                        pw.close();
                } catch (Exception e) {
                        e.getMessage();
                }
        }
}
