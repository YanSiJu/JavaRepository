<%@ page contentType="text/html; charset=GBK" %>
<html>
<head>
<title>
CH7 - PageCounter
</title>
</head>
<body bgcolor="#ffffff">
<h2>��ΧΪPage��JavaBeanʾ������</h2>
<jsp:useBean id="myBean" scope="page" class="sample.CounterBean" />
<p>���Ѿ�����<font color="red">
<jsp:getProperty name="myBean" property="count" />
</font>��</p>
<p>��ӭ�ٴη���</p>
</body>
</html>
