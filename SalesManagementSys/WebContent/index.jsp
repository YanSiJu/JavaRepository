<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style>
#header {
	background-color: #FFF;
	color: white;
	text-align: center;
	padding: 5px;
	height: 60px;
}

#nav {
	line-height: 30px;
	background-color: #FFF;
	height: 310px;
	width: 25%;
	float: left;
	padding: 5px;
}

#section {
	width: 50%;
	float: left;
	padding: 10px;
	border: #009;
}
</style>
</head>

<body>


	<!-- 这是头部信息 -->
	<div id="header"></div>
	<!-- 这是左部信息 -->
	<div id="nav">
		<!-- 这是中部信息 -->
	</div>
	
	
	<!-- <a href="admin/login">进入功能选择</a> -->
	
	<div id="section" style="border: 1px solid #999">
		<h2 align="center">管理员登录</h2>
		<form action="${pageContext.request.contextPath}/admin/login">
			<p style="text-align: center;">
				帐号: <input type="text" name="account" />
			</p>
			<p style="text-align: center;">
				密码: <input type="password" name="password" />
			</p>
			<!-- <!-- <p style="text-align: center;">
				角色: <input type="radio" name="identify" value="generalAdmin"
					checked="checked" />普通管理员 <input type="radio" name="identify"
					value="superAdmin" />超级管理员
			</p> -->  

			<p align="center">
				<input type="submit" value="登录" />
			</p>
		</form>
		<br />
		<p align="center">
			<button onclick="xiugaimima()">修改密码</button>
		</p>
		<script>
			function xiugaimima() {
				alert("联系电话: 18711194462");
			}
		</script>
	</div>


</body>
</html>