<%@ page contentType="text/html; charset=GBK" %>
<html>
<head>
<title>
CH7 - PageCounter
</title>
</head>
<body bgcolor="#ffffff">
<h2>范围为Page的JavaBean示例程序</h2>
<jsp:useBean id="myBean" scope="page" class="sample.CounterBean" />
<p>您已经访问<font color="red">
<jsp:getProperty name="myBean" property="count" />
</font>次</p>
<p>欢迎再次访问</p>
</body>
</html>
