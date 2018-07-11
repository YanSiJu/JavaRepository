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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
<link rel="stylesheet" href="css/register.css" type="text/css" />
<script type="text/javascript" src="js/register.js"></script>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>			
<title>注册界面</title>
<style>
body {
	height: 600px;
	background: -webkit-linear-gradient(white, #7FFFD4);
	background: -o-linear-gradient(white, #7FFFD4);
	background: -moz-linear-gradient(white, #7FFFD4);
	background: linear-gradient(white, #7FFFD4); /* 标准的语法（必须放在最后） */
}

p {
	text-overflow: clip;
	color: #0000FF;
	font-size: xx-large;
	margin-left: 39%;
}

h4 {
	color: #0000FF;
	margin-left: 87%;
}


.register{
	margin-left:40%;
	width:100%;
	height:100%;
	color:#0000FF;
	
}

#submit{
	width:120px;
	height:35px;
	border:0;
	color:white;
	background-color: #0099FF;
}

#userName_message #password_message #repassword_message #name_message #mobil_message{

	color:red;
}
</style>
</head>
<body>
	<h4>
		已有账号，请<a href="jsp/login.jsp" style="text-decoration: none;">登录</a>
	</h4>
	<br>
	<br>
	<p>服装库存管理系统</p>
	<div class="register">

		<form action="RegisterServlet" method="post" onsubmit="return checkForm()">
			<table>
				<tr>
					<td>用&nbsp;户&nbsp;名:<input type="text" name="user_name" id="userName" />
					<br><br>
					</td>
					<td id="userName_error" style="color:red;"></td>
				</tr>
				<tr>
					<td>密&emsp;&nbsp;&ensp;码:<input type="password"
						name="user_pass" id="password"  />
					<br><br>
					</td>
					<td id="password_error" style="color:red;"></td>
				</tr>
				<tr>
					<td>确认密码:<input type="password" name="user_repass" id="repassword"  />
					<br><br>
					</td>
					<td id="repassword_error" style="color:red;"></td>
				</tr>
				<tr>
					<td>姓&emsp;&emsp;名:<input type="text" name="real_name" id="name"  />
					<br><br>
					</td>
					<td id="name_error" style="color:red;"></td>
				</tr>
				<tr>
					<td>性&emsp;&emsp;别:&emsp;<input type="radio" name="user_sex" value="男" checked="checked" />男&emsp;<input
						type="radio" name="user_sex" value="女"/>女&emsp;&emsp;
					<br><br>
					</td>
					<td id="sex_error" style="color:red;"></td>
				</tr>
				<tr>
					<td>电&emsp;&emsp;话:<input type="text" name="user_mobil" id="mobil"  />
					<br><br>
					</td>
					<td id="mobil_error" style="color:red;"></td>
				</tr>
				<tr>
					<td colspan="2">
				&emsp;&emsp;&emsp;&emsp;
				<input type="submit" value="注册" id="submit" />
			</td>
				
				</tr>
				
	
			</table>
	</form>
	
	</div>
</body>
</html>