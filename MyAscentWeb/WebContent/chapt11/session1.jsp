<%@ page contentType="text/html;charset=GB2312" %>
<HTML>
<BODY bgcolor=cyan><FONT Size=5>
<%String s=session.getId();%>
<P>您的session对象的ID是：
<BR>
<%=s%>
<%="session失效时间是："+ session.getMaxInactiveInterval() +"秒" %>
</BODY>
</HTML>
