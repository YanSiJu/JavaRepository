<%@ page contentType="text/html;charset=GB2312" %>
<HTML>
<HEAD>
<TITLE>application变量的使用</TITLE>
</HEAD>
<BODY>
<CENTER>
<FONT SIZE = 5 COLOR = blue>application变量的使用</FONT>
</CENTER>
<HR>
<P></P>
<%
Object obj = null;
String strNum = (String)application.getAttribute("Num");
int Num = 0;
//检查是否Num变量是否可取得
if(strNum != null) 
Num = Integer.parseInt(strNum) + 1; //将取得的值增加1
application.setAttribute("Num", String.valueOf(Num)); //起始Num变量值
%>
application对象中的<Font color = blue>Num</Font>变量值为
<Font color = red><%= Num %></Font><BR>
</BODY>
</HTML>
