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
//   session.setAttribute("count", str);用来记录此人的序号
    application.setAttribute("count",str);//记录访问总数
    }
  %>
<P>已经有<%=(String)application.getAttribute("count")%>
<%--您是第<%=(String)session.getAttribute("count")--%>个人访问本站。
</BODY>
</HTML>
