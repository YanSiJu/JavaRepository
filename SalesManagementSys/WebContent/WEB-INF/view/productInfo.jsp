<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品信息</title>
</head>
<body>

	<p style="text-align: center;">
		<a href="${pageContext.request.contextPath}/product/addProduct"
			target="_blank"> <img
			src="${pageContext.request.contextPath}/img/add.png" width="40"
			height="40" alt="添加产品" />
		</a>
	<form action="${pageContext.request.contextPath}/product/queryProduct" style="text-align: center;">
		产品名称: <input type="text" name="productName" /> 产品编号: <input
			type="text" name="id" /> <input type="submit" value="查询" />
		&emsp;&emsp;
	</form>



	<table border="1" align="center">
		<thead>
			<tr>
				<th>产&emsp;品&emsp;号</th>
				<th>产&emsp;品&emsp;名&emsp;称</th>
				<th>产&emsp;品&emsp;价&emsp;格</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.id}</td>
					<td><c:out value="${product.productName}" /></td>
					<td><c:out value="${product.price}" /></td>
					<td><a
						href="${pageContext.request.contextPath}/product/modifyProduct?id=<c:out value="${product.id}"/>"
						target="_blank">修改</a></td>
					<td><a
						href="${pageContext.request.contextPath}/product/deleteProduct?id=<c:out value="${product.id}"/>">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>