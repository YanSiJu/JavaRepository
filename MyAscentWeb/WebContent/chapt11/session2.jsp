<%@ page contentType="text/html;charset=GB2312" %>
<HTML>
<BODY>
  <%! int number=0;   
   synchronized void countPeople()
    { 
         number++;
     }
  %>
  <%
   if(session.isNew())
    {
     countPeople();
     String str=String.valueOf(number);
//   session.setAttribute("count", str);������¼���˵����
    application.setAttribute("count",str);//��¼��������
    }
  %>
<P>�Ѿ���<%=(String)application.getAttribute("count")%>
<%--���ǵ�<%=(String)session.getAttribute("count")--%>���˷��ʱ�վ��
</BODY>
</HTML>
