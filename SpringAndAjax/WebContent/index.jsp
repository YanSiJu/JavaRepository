<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index page</title>
</head>
<body>
	<a href="hello">hello</a>
	<br>
	<a href="dispatcher">Ajax</a>
	<br>
	<a href="loginDispatcher">login</a>
	<br>
	<a href="${pageContext.request.contextPath }/registerValidate.jsp">register</a>

</body>
</html>