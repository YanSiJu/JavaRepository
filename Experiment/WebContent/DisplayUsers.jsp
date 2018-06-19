<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
<style type="text/css">
table {
	border-collapse: collapse;
}
</style>
</head>
<body>



	<table border="1">
		<tr>
			<td>编&emsp;&emsp;号</td>
			<td>姓&emsp;&emsp;名</td>
			<td>公司名称</td>
			<td>公司地址</td>
			<td>电话号码</td>
			<td>电子邮件</td>
		</tr>
		<c:forEach var="user" items="${users}">
			<%--用EL表达式调用list对象的属性循环输出对象的各个属性值--%>
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.companyName}</td>
				<td>${user.companyAddress}</td>
				<td>${user.tel}</td>
				<td>${user.email}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>