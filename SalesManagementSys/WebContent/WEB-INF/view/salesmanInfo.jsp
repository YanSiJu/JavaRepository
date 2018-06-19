<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售员信息</title>
</head>
<body>



	<p style="text-align: center;">
	<a href="${pageContext.request.contextPath}/Salesman/addSalesman" target="_blank"> <img
			src="${pageContext.request.contextPath}/img/add.png"   alt="添加销售员"  width="40"
			height="40" />
		</a>
		
	<form action="${ pageContext.request.contextPath}/Salesman/querySalesman" style="text-align: center;">
		销售员编号: <input type="text" name="id" />
		 姓名: <input type="text"  name="name" />
		性别 : <input type="text"  name="sex" />
		<input type="submit" value="查询" /> &emsp;&emsp;
	</form>
	
	


	<table border="1" align="center">
		<thead>
			<tr>
				<th>销&emsp;售&emsp;员&emsp;编&emsp;号</th>
				<th>姓&emsp;名</th>
				<th>性&emsp;别</th>
				<th>出&emsp;生&emsp;日&emsp;期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${saleMan}" var="man">
				<tr>
					<td>${man.id}</td>
					<td><c:out value="${man.name}" /></td>
					<td><c:out value="${man.sex}" /></td>
					<td><c:out value="${man.birth}" /></td>
					<td><a href="${pageContext.request.contextPath}/Salesman/modifySalesman?id=<c:out value="${man.id}"/>"   target="_blank">修改</a></td>
					<td><a href="${pageContext.request.contextPath}/Salesman/deleteSalesman?id=<c:out value="${man.id}"/>">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>