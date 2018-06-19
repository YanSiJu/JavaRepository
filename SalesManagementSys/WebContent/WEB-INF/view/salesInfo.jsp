<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售记录</title>
</head>
<body>

	<p style="text-align: center;">
		<a href="${pageContext.request.contextPath}/SalesRecord/addSalesRecord" target="_blank"> <img
			src="${pageContext.request.contextPath}/img/add.png"   alt="添加销售记录" width="40"
			height="40" />
		</a>
	<form action="${pageContext.request.contextPath}/SalesRecord/querySalesRecord" style="text-align: center;">
		销售员编号: <input type="text" name="salesmanId" /> 产品编号: <input
			type="text" name="productId" /> <input type="submit" value="查询" />
		&emsp;&emsp;
	</form>



	<table border="1" align="center">
		<thead>
			<tr>
				<th>流&emsp;水&emsp;号</th>
				<th>产&emsp;品&emsp;号</th>
				<th>销&emsp;售&emsp;员&emsp;编&emsp;号</th>
				<th>数&emsp;量</th>
				<th>销&emsp;售&emsp;额</th>
				<th>时&emsp;间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${recds}" var="recd">
				<tr>
					<td>${recd.recordId}</td>
					<td><c:out value="${recd.productId}" /></td>
					<td><c:out value="${recd.salesmanId}" /></td>
					<td><c:out value="${recd.number}" /></td>
					<td><c:out value="${recd.saleroom}" /></td>
					<td><c:out value="${recd.dateTime}" /></td>
					<td><a
						href="${pageContext.request.contextPath}/SalesRecord/modifySalesRecord?recordId=<c:out value="${recd.recordId}"/>"   target="_blank">修改</a></td>
					<td><a
						href="${pageContext.request.contextPath}/SalesRecord/deleteSalesRecord?recordId=<c:out value="${recd.recordId}"/>">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>