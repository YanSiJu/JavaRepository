<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
#delete {
	margin-top: 15%;
	margin-left: 40%;
}

#input {
	width: 150px;
	height: 30px;
}

#delete_submit, #select_submit {
	height: 36px;
	border: 0;
	background-color: blue;
	color: white;
}

p {
	color: red;
}

#select {
	margin-top: 5%;
	margin-left: 10%;
}

#select_table {
	border-right: #cccc99 1px solid;
	border-top: #cccc99 1px solid;
	border-left: #cccc99 1px solid;
	border-bottom: #cccc99 1px solid;
	color: blue;
	text-align: center;
	width: 800px;
}
#update{

	margin-left:35%;
	margin-top:10%;
	
}

#update_submit{

	height: 30px;
	width:100px;
	border: 0;
	background-color: blue;
	color: white;
	
}

</style>
<body>
	<%-- 删除 --%>
	<c:if test="${param.operate eq 'delete'}">
		<div id="delete">

			<br>
			<form action="UserServlet?operate=delete" method="post">
				<input type="text" name="userId" id="input" /><input type="submit"
					name="delete_submit" id="delete_submit" value="删除" />
				<p>${sessionScope.deleteError}</p>
			</form>
		</div>
	</c:if>

	<%-- 修改 --%>
	<c:if test="${param.operate eq 'update'}">
		<div id="update">

			<form action="UserServlet?operate=update" method="post">
			
				用&nbsp;&thinsp;户&nbsp;&thinsp;名:<input type="text" name="userName" value="${sessionScope.user.userName}"/><br><br>
				姓&emsp;&emsp;名:<input type="text" name="realName" value="${sessionScope.user.realName}" /> <br><br>
				性&emsp;&emsp;别:&emsp;<input type="radio" name="userSex" value="男" checked="checked"/>男&emsp;<input
					type="radio" name="userSex" value="女"/>女&emsp;&emsp;<br><br>
				电&emsp;&emsp;话:<input type="text" name="userMobil" value="${sessionScope.user.userMobil}" /><br><br>

				&emsp;&emsp;&emsp;&emsp;&emsp;<input type="submit" value="保存" id="update_submit" />
				<p>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;${sessionScope.updateMessage}</p>
				
			</form>

		</div>
	</c:if>


	<%-- 查询 --%>
	<c:if test="${param.operate eq 'select'}">
		<div id="select">
			<form action="UserServlet?operate=select" method="post">
				<input type="text" name="userId" id="input" /><input type="submit"
					name="select_submit" id="select_submit" value="查询" />
				<p>${sessionScope.selectError}</p>
				<br>
				<br>
				<table id="select_table">
					<tr>
						<th>userId</th>
						<th>userName</th>
						<th>userPass</th>
						<th>realName</th>
						<th>userSex</th>
						<th>userMobil</th>
					</tr>
					<c:forEach items="${sessionScope.userList}" var="user">

						<tr>
							<td>${user.userId}</td>
							<td>${user.userName}</td>
							<td>${user.userPass}</td>
							<td>${user.realName}</td>
							<td>${user.userSex}</td>
							<td>${user.userMobil}</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</c:if>

</body>
</html>