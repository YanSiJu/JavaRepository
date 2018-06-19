<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售管理系统</title>
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

a {
	text-decoration: none
}

#footer {
	background-color: #FFF;
	color: white;
	clear: both;
	text-align: center;
	padding: 5px;
}

/* #juzhong {
	display: block;
	margin-left: auto;
	margin-right: auto;
} */
</style>

</head>
<body>
	<div id="header"></div>
	<!-- 这是左部信息 -->
	<div id="nav">
		<!-- 这是中部信息 -->
	</div>
	<div id="section" style="border: 1px solid #999">
	
		<b>产品管理</b>
		<ul>
			<li><a  href="${pageContext.request.contextPath}/product/addProduct"   target="_blank">增加产品</a></li>
			<li><a  href="${pageContext.request.contextPath}/product/queryAllProducts"  target="_blank">查询产品</a></li>
		</ul>

		<b>销售员管理</b>
		<ul>
			<li><a  href="${pageContext.request.contextPath}/Salesman/addSalesman"   target="_blank">增加销售员</a></li>
			<li><a href="${pageContext.request.contextPath}/Salesman/queryAllSalesman"  target="_blank">查询销售员</a></li>
		</ul>

		<b>销售记录管理</b>
		<ul>
			<li><a  href="${pageContext.request.contextPath}/SalesRecord/addSalesRecord"   target="_blank">增加销售记录</a></li>
			<li><a  href="${pageContext.request.contextPath}/SalesRecord/queryAllRecords"   target="_blank">查询销售记录</a></li>
		</ul>
		
		
		<b>销售记录统计</b>
		<ul>
			<li><a href="${pageContext.request.contextPath}/SalRecd/queryProductSalRoom"  target="_blank">统计产品的月销售额</a></li>
			<li><a href="${pageContext.request.contextPath}/SalRecd/querySalmanSalRoom"  target="_blank">统计销售员的月销售额</a></li>
		</ul>
		
		
	</div>

</body>
</html>