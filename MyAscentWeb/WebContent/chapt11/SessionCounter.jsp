<%@ page contentType="text/html; charset=GBK" %>
<html>
<head>
<title>
CH7 - SessionCounter
</title>
</head>
<body bgcolor="#ffffff">
<h2>范围为Session的JavaBean示例程序</h2>

<jsp:useBean id="myBean" scope="session" class="sample.CounterBean" />
Hello...感谢您第<jsp:getProperty name="myBean" property="count" />次光临！
</body>
</html>

