<%@ page contentType="text/html;charset=GB2312" %>
<HTML>
<HEAD>
<TITLE>application������ʹ��</TITLE>
</HEAD>
<BODY>
<CENTER>
<FONT SIZE = 5 COLOR = blue>application������ʹ��</FONT>
</CENTER>
<HR>
<P></P>
<%
Object obj = null;
String strNum = (String)application.getAttribute("Num");
int Num = 0;
//����Ƿ�Num�����Ƿ��ȡ��
if(strNum != null) 
Num = Integer.parseInt(strNum) + 1; //��ȡ�õ�ֵ����1
application.setAttribute("Num", String.valueOf(Num)); //��ʼNum����ֵ
%>
application�����е�<Font color = blue>Num</Font>����ֵΪ
<Font color = red><%= Num %></Font><BR>
</BODY>
</HTML>
