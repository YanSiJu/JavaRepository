<HTML>
<%@ page contentType="text/html;charset=GB2312" %>
<BODY bgcolor=cyan>
<% int n=0;
  String s1=request.getParameter("Dynasty");
  String s2=request.getParameter("author");

   if(s1==null)
    {s1="";}
   if(s2==null)
    {s2="";}
   if(s1.equals("b"))
    { n++;}
   if(s2.equals("a"))
    { n++;}
%>
<P>µÃ·Ö£º<%=n%>·Ö

</BODY>
</HTML>
