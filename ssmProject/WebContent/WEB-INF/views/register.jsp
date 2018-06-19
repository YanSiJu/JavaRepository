<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>

	<h3>注册页面</h3>
	<br>
	<form:form action="register" commandName="user">
	
		<table>
			<tr>
				<td>姓名</td>
				<td><form:input path="userName" /></td>
				<td><font  color="red"><form:errors path="userName"/></font></td>
			</tr>

			<tr>
				<td>密码:</td>
				<td><form:input path="password" /></td>
				<td><font  color="red"><form:errors path="password"/></font></td>
			</tr>

			<tr>
				<td>电子邮件:</td>
				<td><form:input path="email" /></td>
				<td><font  color="red"><form:errors path="email"/></font></td>
			</tr>

			<tr>
				<td>薪水:</td>
				<td><form:input path="salary" /></td>
				<td><font  color="red"><form:errors path="salary"/></font></td>
			</tr>


			<tr>
				<td>生日:</td>
				<td><form:input path="birth" /></td>
				<td><font  color="red">生日的格式为:yyyy-MM-dd,且必须为过去的日期</font></td>
			</tr>


		</table>

		<input type="submit" value="Submit" />
	</form:form>

	<!-- <form action="register">

		姓名:<input type="text" name="userName" /> <br> <br> 密码:<input
			type="password" name="password" /> <br> <br> 电子邮件:<input
			type="text" name="email" /> <br> <br> 薪水:<input
			type="text" name="salary" /> <br> <br> 电话号码:<input
			type="text" name="mobile" /> 生日:<input type="text" name="birth" />
		<br> <br> <br> <br> <input type="submit"
			value="submit" />

	</form> -->

</body>
</html>