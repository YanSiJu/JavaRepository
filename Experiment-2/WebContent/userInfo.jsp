<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
table {
	border-collapse: collapse;
}
</style>

<title>个人信息</title>

</head>
<body>

	<table>
		<tr>
			<td>id</td>
			<td>${userInfo.id }</td>
		</tr>
		<tr>
			<td>name</td>
			<td>${userInfo.name }</td>
		</tr>
		<tr>
			<td>companyName</td>
			<td>${userInfo.companyName }</td>
		</tr>
		<tr>
			<td>companyAddress</td>
			<td>${userInfo.companyAddress }</td>
		</tr>
		<tr>
			<td>tel</td>
			<td>${userInfo.tel }</td>
		</tr>
		<tr>
			<td>email</td>
			<td>${userInfo.email }</td>
		</tr>
	</table>
</body>
</html>