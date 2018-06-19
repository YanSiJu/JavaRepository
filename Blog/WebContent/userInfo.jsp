<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<script type="text/javascript" src="jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="validator.min.js"></script>
<script type="text/javascript" src="js/authorizeCheck.js"></script>
</head>
<body>
	<form name="example_form" action="register">
		<table>
			<tr>
				<td>&emsp;用户名:</td>
				<td><input type="text" id="name"  disabled="disabled" 
					name="name" /></td>
			</tr>
			<tr>
				<td>&emsp;</td>
				<td>&emsp;</td>
			</tr>
			<tr>
				<td>&emsp;昵称:</td>
				<td><input type="text" id="nickName" 
					name="nickName" /></td>
			</tr>
			<tr>
				<td>&emsp;</td>
				<td>&emsp;</td>
			</tr>
			<tr>
				<td>邮&emsp;&emsp;箱:&emsp;&emsp;</td>
				<td><input id="email" type="text"
					name="email" /></td>
			</tr>
			<tr>
				<td>手机号码:</td>
				<td><input id="tel" type="text" 
					name="tel" /></td>
			</tr>
			<tr>
				<td>&emsp;</td>
				<td>&emsp;</td>
			</tr>
			<tr>
				<td>密&emsp;&emsp;码:</td>
				<td><input type="password" id="password"
					 name="password" /></td>
			</tr>
			<tr>
				<td>&emsp;</td>
				<td>&emsp;</td>
			</tr>
			
			<tr>
				<td>&emsp;</td>
				<td>&emsp;</td>
			</tr>
			<tr>
				<td>
					<div class="error_msg" id="error_msg">错误提示的地方</div>
				</td>
				<td>&emsp;</td>
			</tr>
			<tr>
				<td>&emsp;</td>
				<td><input type="submit" class="regist" value="保存"
					onclick="check()" /></td>
			</tr>
		</table>

	</form>

	<script type="text/javascript" src="js/validate.js"></script>

</body>
</html>