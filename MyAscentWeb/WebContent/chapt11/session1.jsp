<%@ page contentType="text/html;charset=GB2312" %>
<HTML>
<BODY bgcolor=cyan><FONT Size=5>
<%String s=session.getId();%>
<P>����session�����ID�ǣ�
<BR>
<%=s%>
<%="sessionʧЧʱ���ǣ�"+ session.getMaxInactiveInterval() +"��" %>
</BODY>
</HTML>
