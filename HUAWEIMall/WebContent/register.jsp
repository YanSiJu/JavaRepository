<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" href="register.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="register.js"></script>
<title>注册界面</title>

</head>
<body>
<div class="register">
	<br>
	<h4>已有账号，直接<a href="login.jsp">登录</a></h4>
	<br>
	<h1>华为手机购物商城</h1><br><br>
	
	<form action="RegisterServlet" method="post" name="registerForm">
	<table width="100%" border="0">
	<tr>
	<td class="td"></td>
	<td class="td2">
	手&nbsp;&nbsp;机&nbsp;&nbsp;号:<input type="text" name="tel" class="tel"/><i>请输入11位手机号，由数字0-9组成</i><br><br>
	</td></tr>
	
	
	<tr>
	<td class="td"></td>
	<td class="td2">
	用&nbsp;&nbsp;户&nbsp;&nbsp;名:<input type="text" name="userName" class="userName"/><i>请输入用户名，由字母下划线数字组成，首字符为字母</i><br><br>
	</td><tr>
	
	<tr>
	<td class="td"></td>
	<td class="td2">
	密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="password" class="password"/><i>请输入6-20位密码，必须同时包含数字和字母</i><br><br>
	</td><tr>
	
	
	<tr>
	<td class="td"></td>
	<td class="td2">
	收货地址:<input type="text" name="address" class="address"/><i>请输入具体的收货地址</i><br><br>
	</td><tr>
	
	<tr>
	<td class="td"></td>
	<td class="td2">
	姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:<input type="text" name="name" class="name"/><i>请输入真实姓名</i><br><br>
	</td><tr>
	
	<tr>
	<td class="td"></td>
	<td class="td3">
	<input type="submit" value="注册" class="button"/>
	</td><tr>
	</table>
	</form>
	</div>
	
</body>
</html>