<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改产品信息</title>

<style>
#header {
	background-color: #FFF;
	color: white;
	text-align: center;
	padding: 5px;
	height: 60px;
}

#nav {
	line-height: 30px;
	background-color: #FFF;
	height: 310px;
	width: 35%;
	float: left;
	padding: 5px;
}

#section {
	width: 30%;
	float: left;
	padding: 10px;
	border: #009;
}

#footer {
	background-color: #FFF;
	color: white;
	clear: both;
	text-align: center;
	padding: 5px;
}
</style>

</head>
<body>

	<div id="header"></div>
	<!-- 这是左部信息 -->
	<div id="nav">
		<!-- 这是中部信息 -->
	</div>
	<div id="section" style="border: 1px solid #999">
		<h3 align="center">修改产品信息</h3>
		<form action="${pageContext.request.contextPath}/product/modifyProduct"   method="post">
			<!--<p align="center">产 品 ID&nbsp; <input type="number" name="productId" /></p>-->
			<p align="center">
				产品号: <input type="text" name="id" value="${product.id }"
					readonly="readonly" />
			</p>
			<p align="center">
				产品名称: <input type="text" name="productName"
					value="${product.productName }" />
			</p>
			<p align="center">
				产品价格: <input type="text" name="price" value="${product.price }" />
			</p>
			<p align="center">
				<input type="submit" value="提交" />
			</p>
		</form>
	</div>
</body>
</html>