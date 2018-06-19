package chapt12;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
  private static final String CONTENT_TYPE = "text/html; charset=GBK";
  private   ServletContext sc=null;
  //Initialize 
  public void init() throws ServletException {
    super.init();
    sc=this.getServletContext();
  }

  //Process the HTTP Get request
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
     
    //处理从login.jsp中提交给此Servlet的情况
    String reg = request.getParameter("Submit2");
	  if(reg !=null){// 如果用户在login.jsp中点击了注册按钮
	    response.sendRedirect("chapt12/register.jsp");
	    return;
	  }
	  
	  //处理从register.jsp中提交给此Servlet的情况
	  String register = request.getParameter("register");//register="true"
	  if(register!=null){
	    doRegister(request, response);
	    return;
	  }
	
	  doLogin(request, response);
 
  }
  
  public void  doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String varname = request.getParameter("usename");
	  String varpassword = request.getParameter("password");

	  
	  boolean succ=false;
	  Customer cu=new Customer();
	  try {
	    succ = cu.login(varname,varpassword);
	  }
	  catch (SQLException ex) {
	    ex.getErrorCode();
	  }
	  String username=varname;
	  if(succ){
	       HttpSession mysession = request.getSession(false);

	       mysession.setAttribute("username",username);
	       //书上代码 要改到此位置，否则在目的地不能马上使用session中的属性值
	       this.doBrowse(request, response);
	  }
	  else{
	       this.doError(request, response);
	  }
	  return;
	
}

  //Process the HTTP Post request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    doGet(request, response);
  }
  
  private void doBrowse(HttpServletRequest request, HttpServletResponse response) throws
     ServletException, IOException{
     RequestDispatcher rd=sc.getRequestDispatcher("/chapt12/success.jsp");
     rd.forward(request,response);
  }

  private void doRegister(HttpServletRequest request, HttpServletResponse response) throws
     ServletException, IOException{
     Customer cust = new Customer();
     cust.setUser(request.getParameter("username"));
     cust.setPassword(request.getParameter("password"));
     cust.setName(request.getParameter("name"));
     cust.setTitle(request.getParameter("title"));
     cust.setEmail(request.getParameter("email"));
     try {
      cust.saveInfo();
     }
     catch (Exception ex) {
      ex.printStackTrace();
     }
     RequestDispatcher rd=sc.getRequestDispatcher("/chapt12/login.jsp");
     rd.forward(request,response);
  }

  private void doBrowseErr(HttpServletRequest request, HttpServletResponse response) throws
           ServletException, IOException{
         RequestDispatcher rd=sc.getRequestDispatcher("/chapt12/login.jsp");
         rd.forward(request,response);
  }
 
  private void doError(HttpServletRequest request, HttpServletResponse response) throws
           ServletException, IOException{
          request.setAttribute("error","name or password error!");
          this.doBrowseErr(request, response);
  }
  //Clean up resources
  public void destroy() {
  }
}
