<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/register.css" />
<title>用户注册</title>
</head>
<body>
	<div id="div_1">
		<a href="#" class="link">&emsp;登录</a> <a href="#" class="link">注册</a>
		<ul>

			<li><a href="">关于我们</a></li>
			<li><a href="">积分商城</a></li>
			<li><a href="">合作伙伴</a></li>
			<li><a href="">我的账户</a></li>
			<li><a href="">机票兑换</a></li>
			<li><a href="">首页</a></li>
		</ul>
	</div>
	<form action="${pageContext.request.contextPath}/RegisterServlet"  method="post">
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
				<td>公司地址:&emsp;&emsp;</td>
				<!-- placeholder="需要通过邮件激活账户" -->
				<td><input id="companyAddress" type="text"
					name="companyAddress" /></td>
			</tr>
			<tr>
				<td>公司名称 :&emsp;&emsp;</td>
				<!-- placeholder="需要通过邮件激活账户" -->
				<td><input id="companyName" type="text" name="companyName" /></td>
			</tr>
			<tr>
				<td>&emsp;</td>
				<td>&emsp;</td>
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
				<td>确认密码:</td>
				<!-- placeholder="请输入确认密码 " -->
				<td><input type="password" id="prepassword" name="prepassword" /></td>
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
			<tr>
				<td>&emsp;</td>
				<td>&emsp;</td>
			</tr>
			<tr>
				<td>&emsp;</td>
				<td>* “注册” 按钮，即表示您同意并愿意遵守 <a
					href="https://passport.cnblogs.com/agreement.html">用户协议</a>。
				</td>
			</tr>
		</table>
	</form>

</body>
</html>