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
#insert {
	margin-top: 5%;
	margin-left: 35%;
}

#delete {
	margin-top: 15%;
	margin-left: 40%;
}

#input {
	width: 150px;
	height: 30px;
}

#insert_submit {
	height: 30px;
	border: 0;
	background-color: blue;
	color: white;
	width: 100px;
	margin-left: 15%;
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
</style>
<body>

	<%-- 增加 --%>
	<c:if test="${param.operate eq 'insert'}">
		<div id="insert">

			<br>
			<form action="ProductServlet?operate=insert" method="post">
				服装名称:<input type="text" name="proName" class="pro" /><br>
				<br> 尺寸编号:<input type="text" name="sizeId" class="pro" /><br>
				<br> 颜色编号:<input type="text" name="colorId" class="pro" /><br>
				<br> 材质编号:<input type="text" name="outmaId" class="pro" /><br>
				<br> 现&emsp;&emsp;价:<input type="text" name="proFacPrice"
					class="pro" /><br>
				<br> 原&emsp;&emsp;价:<input type="text" name="proRetPrice"
					class="pro" /><br>
				<br> <input type="submit" name="insert_submit"
					id="insert_submit" value="提交" />
				<p>&emsp;&emsp;&emsp;&emsp;&emsp;${sessionScope.insertSuccess}</p>
			</form>
		</div>
	</c:if>



	<%-- 删除 --%>
	<c:if test="${param.operate eq 'delete'}">
		<div id="delete">

			<br>
			<form action="ProductServlet?operate=delete" method="post">
				<input type="text" name="proId" id="input" /><input type="submit"
					name="delete_submit" id="delete_submit" value="删除" />
				<p>${sessionScope.deleteError}</p>
			</form>
		</div>
	</c:if>

	<%-- 修改 --%>
	<c:if test="${param.operate eq 'update'}">
		<div id="update">

			<form action="UserServlet?operate=update" method="post">
			
				服装名称:<input type="text" name="proName" value="${sessionScope.product.proName}"/><br><br>
				尺&emsp;&emsp;码:<input type="text" name="sizeId" value="${sessionScope.product.sizeId}" /> <br><br>
				颜&emsp;&emsp;色:<input type="text" name="colorId" value="${sessionScope.product.colorId}"/><br><br>
				材&emsp;&emsp;质:<input type="text" name="outmaId" value="${sessionScope.product.outmaId}" /><br><br>
				现&emsp;&emsp;价:<input type="text" name="proFacPrice" value="${sessionScope.product.proFacPrice}" /><br><br>
				原&emsp;&emsp;价:<input type="text" name="proRetPrice" value="${sessionScope.product.proRetPrice}" /><br><br>
				&emsp;&emsp;&emsp;&emsp;&emsp;<input type="submit" value="保存" id="update_submit" />
				<p>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;${sessionScope.updateMessage}</p>
				
			</form>

		</div>
	</c:if>


	<%-- 查询 --%>
	<c:if test="${param.operate eq 'select'}">
		<div id="select">
			<form action="ProductServlet?operate=select" method="post">
				<input type="text" name="proId" id="input" /><input type="submit"
					name="select_submit" id="select_submit" value="查询" />
				<p>${sessionScope.selectError}</p>
				<br>
				<br>
				<table id="select_table">
					<tr>
						<th>proId</th>
						<th>proName</th>
						<th>sizeId</th>
						<th>colorId</th>
						<th>outmaId</th>
						<th>proFacPrice</th>
						<th>proRetPrice</th>
					</tr>
					<c:forEach items="${sessionScope.proList}" var="product">

						<tr>
							<td>${product.proId}</td>
							<td>${product.proName}</td>
							<td>${product.sizeId}</td>
							<td>${product.colorId}</td>
							<td>${product.outmaId}</td>
							<td>${product.proFacPrice}</td>
							<td>${product.proRetPrice}</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</c:if>
</body>
</html>