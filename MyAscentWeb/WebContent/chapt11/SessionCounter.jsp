<%@ page contentType="text/html; charset=GBK" %>
<html>
<head>
<title>
CH7 - SessionCounter
</title>
</head>
<body bgcolor="#ffffff">
<h2>��ΧΪSession��JavaBeanʾ������</h2>

<jsp:useBean id="myBean" scope="session" class="sample.CounterBean" />
Hello...��л����<jsp:getProperty name="myBean" property="count" />�ι��٣�
</body>
</html>

