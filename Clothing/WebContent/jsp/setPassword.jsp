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
<title>Insert title here</title>
</head>
<style>
#table {
	margin-top: 10%;
	margin-left: 35%;
	width:600px;
}

#submit {
	width: 120px;
	height: 40px;
	border: 0;
	background-color: #00CCFF;
	color: white;
	margin-left: 27%;
}

.td1{

	width:300px;
}

.message{

	color:red;
}
</style>
<body>
	<form action="SetPasswordServlet" method="post">
		<table id="table">

			<tr>
				<td class="td1">旧&nbsp;&thinsp;密&nbsp;&thinsp;码:<input type="password"
					name="password1" value="${sessionScope.password1}" /><br>
				<br>
				</td>
				<td class="message">${sessionScope.message1}</td>
			</tr>
			<tr>
				<td class="td1">新&nbsp;&thinsp;密&nbsp;&thinsp;码:<input type="password"
					name="password2"  value="${sessionScope.password2}"/><br>
				<br>
				</td>
				<td class="message">${sessionScope.message2}</td>
			</tr>
			<tr>
				<td class="td1">确认密码:<input type="password" name="password3"  value="${sessionScope.password3}"/><br>
				<br>
				</td>
				<td class="message">${sessionScope.message3}</td>
			</tr>
			<tr>
				<td><input type="submit" id="submit" value="提交" /></td>
			</tr>

		</table>
	</form>
</body>
</html>