<%@ page contentType="text/html;charset=GB2312" %>
<HTML>
<BODY bgcolor=green> 
<P>获取文本框提交的信息：
  <%String textContent=request.getParameter("user");
  %>
<BR>
  <%=textContent%> 
<P> 获取按钮的取值：
  <%String buttonName=request.getParameter("submit");
  %>
<BR>
  <%=buttonName%> 

</BODY>
</HTML>
