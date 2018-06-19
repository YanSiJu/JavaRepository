<%@ page contentType="text/html;charset=GB2312" %>
<HTML>
<BODY bgcolor=cyan><Font size=1 >
<P>我正在学习response对象的
<BR>setContentType方法
<P>将当前页面保存为word文档吗？
 <FORM action="" method="get" name=form>
   <INPUT TYPE="submit" value="yes" name="submit">
  </FORM>
<% String str=request.getParameter("submit");
   if(str==null) 
     {
str="";
     }
   if(str.equals("yes"))
     {
response.setContentType("application/msword;charset=GB2312");
     }
%> 
</FONT>
</BODY>
</HTML>

