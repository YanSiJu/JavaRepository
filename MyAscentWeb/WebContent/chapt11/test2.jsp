<%@ page contentType="text/html;charset=GB2312" %>
<MHML>
<BODY>  
<P>获取文本框提交的信息：
  <%String textContent=request.getParameter("user");
   byte b[]=textContent.getBytes("GB2312");
   textContent=new String(b);
  %>
<BR>
  <%=textContent%> 
<P> 获取按钮的名字：
  <%String buttonName=request.getParameter("submit");
   byte c[]=buttonName.getBytes("GB2312");
   buttonName=new String(c);
  %>
<BR>
  <%=buttonName%> 
</BODY>
</HTML>
