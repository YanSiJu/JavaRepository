<%@ page contentType="text/html;charset=GB2312" %>
<HTML>
<BODY bgcolor=green> 
<P>��ȡ�ı����ύ����Ϣ��
  <%String textContent=request.getParameter("user");
  %>
<BR>
  <%=textContent%> 
<P> ��ȡ��ť��ȡֵ��
  <%String buttonName=request.getParameter("submit");
  %>
<BR>
  <%=buttonName%> 

</BODY>
</HTML>
