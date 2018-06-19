<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>录入销售记录信息</title>
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
		<h3 align="center">修改销售记录</h3>
		<form
			action="${pageContext.request.contextPath}/SalesRecord/modifySalesRecord"  method="post">
			<p align="center">
				流水号:<input type="text" name="recordId" value="${recd.recordId }"  readonly="readonly" />
			</p>
			<p align="center">
				销售时间:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="dateTime"  value="${dateTime }"  readonly="readonly"/>
			</p>
			<p align="center">
				销售员编号: <input type="text" name="salesmanId"  value="${recd.salesmanId }" readonly="readonly"/>
			</p>
			<p align="center">
				产品号:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="text" name="productId" value="${recd.productId }"  readonly="readonly"/>
			</p>
			<p align="center">
				销售数量:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"   value="${recd.number }" name="number" />
			</p>
			<p align="center">
				销售金额:<input type="text" name="saleroom" value="${recd.saleroom }"   readonly="readonly"/>
			</p>
			<p align="center">
				<input type="submit" value="修改记录" />
			</p>
		</form>
	</div>
</body>

</html>