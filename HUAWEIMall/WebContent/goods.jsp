<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="goods.css" type="text/css"/>
<title>${param.name}</title>
</head>
<body>
	<div class="content">
	
	
	<table>
	<tr>
	
	<td><p><a href="index.jsp" class="index" style="text-decoration: none;">首页</a></td>
	
	<td>
	<div class="right">
	<a href="register.jsp" style="text-decoration: none;">注册</a>
	&nbsp;|&nbsp;
	<a href="login.jsp" style="text-decoration: none;">登录</a>
	</div>
	</td>
	
	</tr>
	
	
	<tr>
	
	<td>
	<img alt="" src="${sessionScope.goodsSrc}">
	</td>
	
	<td>
	
	</td>
	
	</tr>
	</table>
	</div>
	
	
	
</body>
</html>