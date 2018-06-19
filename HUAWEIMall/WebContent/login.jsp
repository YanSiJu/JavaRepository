<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="login.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
</head>
<body>

<div class="login">
	<br>
	<h4>没有账号，立即<a href="register.jsp">注册</a></h4>
	<br>
	<h1>华为手机购物商城</h1><br><br>
	
	<form action="LoginServlet" method="post">
	<table width="100%" border="0">

	<tr>
	<td class="td"></td>
	<td class="td2">
	用&nbsp;&nbsp;户&nbsp;&nbsp;名:<input type="text" name="userName" class="userName"/><br><br>
	</td><tr>
	
	<tr>
	<td class="td"></td>
	<td class="td2">
	密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="password" class="password"/><br><br>
	</td><tr>
	
	
	<tr>
	<td class="td"></td>
	<td class="td3">
	<input type="submit" value="登录" class="button"/>
	</td><tr>
	</table>
	</form>
	</div>
	
</body>
</html>