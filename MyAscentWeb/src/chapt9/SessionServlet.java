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
 out.println("<html><head><title>当前购物车中的商品</title></head>");
    out.println("<body>");
 request.setCharacterEncoding("GBK");
String[] items = request.getParameterValues("item");    
 out.println("当前，在你的购物车中有下列商品:");
   if (items == null) {
     out.println("没有商品！");
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
    System.out.println("随机数，模拟添加一个商品！");
    int i = new Random().nextInt(100);
    out.println("<input type=\"hidden\" name =\"item\" value=\"商品:");
    out.println(String.valueOf(i));
    out.println("\"/>");
 out.println("<br>你愿意");
    out.println("<input type=\"submit\" value=\"添加商品\" />"); 
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
