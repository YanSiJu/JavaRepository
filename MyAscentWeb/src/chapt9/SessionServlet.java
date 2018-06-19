package chapt9;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
public class SessionServlet extends HttpServlet {
  private static final String CONTENT_TYPE = "text/html; charset=GBK";
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 response.setContentType(CONTENT_TYPE);
    PrintWriter out = response.getWriter();
 out.println("<html><head><title>��ǰ���ﳵ�е���Ʒ</title></head>");
    out.println("<body>");
 request.setCharacterEncoding("GBK");
String[] items = request.getParameterValues("item");    
 out.println("��ǰ������Ĺ��ﳵ����������Ʒ:");
   if (items == null) {
     out.println("û����Ʒ��");
}
    else {
      out.println("<UL>");
      for (int i = 0; i < items.length; i++) {              
        out.println("<LI>");
        out.println(items[i]);
      }
      out.println("</UL>");
    }
out.println("<form action=SessionServlet method=post>");      
 if (items != null) {
      for (int i = 0; i < items.length; i++) {
 //       System.out.println(
           out.println("<input type=\"hidden\" name=item value=\"" +
items[i] +"\">");    
      }
    }
    System.out.println("�������ģ�����һ����Ʒ��");
    int i = new Random().nextInt(100);
    out.println("<input type=\"hidden\" name =\"item\" value=\"��Ʒ:");
    out.println(String.valueOf(i));
    out.println("\"/>");
 out.println("<br>��Ը��");
    out.println("<input type=\"submit\" value=\"�����Ʒ\" />"); 
 out.println("</form>");
    out.println("</body>");
    out.println("</html>");
    out.close();
  }
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws
    ServletException, IOException {
    doGet(request, response);
  }
}
