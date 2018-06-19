<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/login.css" />
<title>用户登录</title>
</head>
<body>
	<div id="div_1">

		<form action="${pageContext.request.contextPath}/Login" method="post">
			<table>
				<tr>
					<td>用户名:<input type="text" name="name"
						style="width: 188px; border: solid grey; margin-left: 5px; margin-right: 30px;" />
					</td>
				</tr>

				<tr>

					<td>密&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password"
						name="password"
						style="width: 188px; border: solid grey; margin-top: 30px; margin-left: 5px; margin-right: 30px;" />
					</td>
				</tr>

				<tr>
					<td><br /> <input type="submit" value="登&emsp;录" id="submit" /></td>
				</tr>

			</table>
		</form>
	</div>
</body>

</html>