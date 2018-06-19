<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售员月销售额统计</title>
</head>
<body>

	<%-- <p style="text-align: center;">
		<a
			href="${pageContext.request.contextPath}/SalesRecord/addSalesRecord"
			target="_blank"> <img
			src="${pageContext.request.contextPath}/img/add.png" alt="添加销售记录"
			width="40" height="40" />
		</a>
	<form action="" style="text-align: center;">
		销售员编号: <input type="text" name="salesmanId" /> 产品编号: <input
			type="text" name="productId" /> <input type="submit" value="查询" />
		&emsp;&emsp;
	</form> --%>



	<table border="1" align="center">
		<thead>
			<tr>
				<th>销&emsp;售&emsp;员&emsp;编&emsp;号</th>
				<th>姓&emsp;名</th>
				<th>月&emsp;份</th>
				<th>销&emsp;售&emsp;额</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${salmanMonthlyRecds}" var="recd">
				<tr>
					<td>${recd.id}</td>
					<td><c:out value="${recd.name}" /></td>
					<td><c:out value="${recd.month}" /></td>
					<td><c:out value="${recd.monthlySaleroom}" /></td>
					<%-- <td><a
						href="${pageContext.request.contextPath}/SalesRecord/modifyProduct?recordId=<c:out value="${recd.recordId}"/>"
						target="_blank">修改</a></td>
					<td><a
						href="${pageContext.request.contextPath}/SalesRecord/deleteSalesRecord?recordId=<c:out value="${recd.recordId}"/>">删除</a></td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>