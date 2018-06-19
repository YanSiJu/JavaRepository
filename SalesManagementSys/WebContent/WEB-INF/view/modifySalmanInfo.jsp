<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改销售员信息</title>

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
		<h3 align="center">销售员信息录入</h3>
		<form action="${pageContext.request.contextPath}/Salesman/modifySalesman"  method="post">
			<p align="center">
				销售员编号:<input type="text" name="id" value="${ salman.id}"  readonly="readonly" />
			</p>
			<p align="center">
				姓 名:&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; <input type="text" name="name"
					value="${salman.name }" />
			</p>
			<p align="center">
				出生日期:<input type="text" name="birth" value="${birth }" />
			</p>
			<p align="center">
				<label>性&nbsp;别:</label> <input type="radio" name="sex" value="男"
					checked="checked" />男 &nbsp; <input type="radio" name="sex"
					value="女" />女
			</p>
			<p align="center">
				<input type="submit" value="提交" />
			</p>
		</form>

	</div>

</body>
</html>