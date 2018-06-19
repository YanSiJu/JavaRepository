<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="sample.CounterBean" %>
<html>
<head>
<title>
CH7 - PageCounter
</title>
</head>
<body bgcolor="#ffffff">
<h2>范围为Request的JavaBean示例程序</h2>
<jsp:useBean id="myBean" scope="request" class="sample.CounterBean" />
<p>您已经访问<font color="red">
<jsp:getProperty name="myBean" property="count" />
</font>次</p>
<p>欢迎再次访问</p>



<%--通过getAttribute访问 count=--%>
<%
CounterBean bean=(CounterBean)request.getAttribute("myBean");
out.println(bean.getCount());
%>

<jsp:include page="Hello.jsp" flush="true"></jsp:include>

</body>
</html>
