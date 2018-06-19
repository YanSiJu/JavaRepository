<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收集用户信息</title>
</head>
<body>
		<form action="${pageContext.request.contextPath}/DisplayServlet"  method="post">
		<table>
			<tr>
				<td>邮&emsp;&emsp;箱:&emsp;&emsp;</td>
				<!-- placeholder="需要通过邮件激活账户" -->
				<td><input id="email" type="text" name="email" /></td>
			</tr>
			<tr>
				<td>&emsp;</td>
				<td>&emsp;</td>
			</tr>
			<tr>
				<!-- placeholder="激活账户需要手机短信验证" -->
				<td>手机号码:</td>
				<td><input type="text" id="tel" name="tel" /></td>
			</tr>
			
			<tr>
				<td>&emsp;用户名:</td>
				<!-- placeholder="登录用户名，不少于4个字符" -->
				<td><input type="text" id="name" name="name" /></td>
			</tr>
			<tr>
				<td>&emsp;</td>
				<td>&emsp;</td>
			</tr>
			<tr>
				<td>密&emsp;&emsp;码:</td>
				<!-- placeholder="至少8位,必须包含数字、字母、特殊字符" -->
				<td><input type="password" id="password" name="password" /></td>
			</tr>
			<tr>
				<td>&emsp;</td>
				<td>&emsp;</td>
			</tr>
			<tr>
				<td>&emsp;</td>
				<td><input type="submit" class="regist" value="注&emsp;&emsp;册" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>