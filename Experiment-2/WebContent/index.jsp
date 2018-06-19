<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ascentWeb</title>
</head>
<body>

	<c:if test="${empty userInfo }">
		您好，您好没有<a href="${pageContext.request.contextPath }/login.jsp">登录</a>
		<br>
		<a href="${pageContext.request.contextPath }/register.jsp">注册</a>
	</c:if>

	<c:if test="${not empty userInfo }">
		您好，这是您第${visitCount }次访问本网站
		<br>
		<a href="${pageContext.request.contextPath }/userInfo.jsp">查看个人信息</a>
		<br>
		<a href="${pageContext.request.contextPath}/Logout">注销</a>
	</c:if>

</body>
</html>