<%@ page contentType="text/html;charset=GB2312" %>
<MHML>
<BODY>  
<P>��ȡ�ı����ύ����Ϣ��
  <%String textContent=request.getParameter("user");
   byte b[]=textContent.getBytes("GB2312");
   textContent=new String(b);
  %>
<BR>
  <%=textContent%> 
<P> ��ȡ��ť�����֣�
  <%String buttonName=request.getParameter("submit");
   byte c[]=buttonName.getBytes("GB2312");
   buttonName=new String(c);
  %>
<BR>
  <%=buttonName%> 
</BODY>
</HTML>
