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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/login.css" type="text/css" />
<script src="js/login.js"></script>
<title>登录界面</title>

</head>
<body>
	<h4>
		没有账号，请<a href="jsp/register.jsp" style="text-decoration: none;">注册</a>
	</h4>

	<p>服装库存管理系统</p>
	<br>
	<br>
	<div class="register" style="color: #0000FF;">
		<div id="container">
			<div id="list" style="left: -520px;">
				<img src="slideImg/8.jpg" alt="8" class="picture" /> <img
					src="slideImg/1.jpg" alt="1" class="picture" /> <img
					src="slideImg/2.jpg" alt="2" class="picture" /> <img
					src="slideImg/3.png" alt="3" class="picture" /> <img
					src="slideImg/4.jpg" alt="4" class="picture" /> <img
					src="slideImg/5.jpg" alt="5" class="picture" /> <img
					src="slideImg/6.jpg" alt="6" class="picture" /> <img
					src="slideImg/7.jpg" alt="7" class="picture" /> <img
					src="slideImg/8.jpg" alt="8" class="picture" /> <img
					src="slideImg/1.jpg" alt="1" class="picture" />
			</div>
			<div id="buttons">
				<span  class="on"> </span> <span ></span> <span
					></span> <span ></span> <span ></span> <span
					></span> <span ></span> <span ></span>
			</div>
			<a href="javascript:;" class="arrow" id="prev">&lt;</a> <a
				href="javascript:;" class="arrow" id="next">&gt;</a>
		</div>
		&emsp;<br>
		<br>
		<br>
		<div>
			<form action="LoginServlet" method="post">
				<table class="table">
					<tr>
						<td style="width:280px;">用户名:<input type="text" name="user_name" value="${sessionScope.userName }" /><br>
						<br>
						<br>
						</td>
						<td class="userNameMessage" style="color:red;width:300px;">${sessionScope.userNameMessage}<br><br>
						<br></td>
					</tr>
					<tr>
						<td style="width:280px;">密&emsp;码:<input type="password" name="user_pass" /><br>
						<br>
						<br>
						</td>
						<td class="passwordMessage" style="color:red;width:300px;">${sessionScope.passwordMessage}<br>
						<br><br></td>
					</tr>
					<tr>
						<td colspan="2">
						&emsp;&emsp;&emsp;&emsp;
					<input type="submit" value="登录" class="submit" />
					</td>
					</tr>
					
	
				</table>
	</form>
	</div>
	</div>
</body>
</html>