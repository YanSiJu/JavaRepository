<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="sample.CounterBean" %>
<html>
<head>
<title>
CH7 - PageCounter
</title>
</head>
<body bgcolor="#ffffff">
<h2>��ΧΪRequest��JavaBeanʾ������</h2>
<jsp:useBean id="myBean" scope="request" class="sample.CounterBean" />
<p>���Ѿ�����<font color="red">
<jsp:getProperty name="myBean" property="count" />
</font>��</p>
<p>��ӭ�ٴη���</p>



<%--ͨ��getAttribute���� count=--%>
<%
CounterBean bean=(CounterBean)request.getAttribute("myBean");
out.println(bean.getCount());
%>

<jsp:include page="Hello.jsp" flush="true"></jsp:include>

</body>
</html>
