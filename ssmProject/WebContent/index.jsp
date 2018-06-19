<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>

<script src="jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(function() {

		$("#btn1").click(function() {
			$.get("AjaxTest", function(data, status) {
				//$("#test").html(data + status);
				alert("数据：" + data + "\n状态：" + status);
			});
		});
	});
</script>

</head>
<body>


	contextPath:
	<c:out value="${pageContext.request.contextPath}/img"></c:out>

	<a href="https://www.google.com.hk/" target="_blank"> <img
		src="${pageContext.request.contextPath}/img/add.png" width="40" height="40" />
	</a>
	<form action="DateTest" method="POST" enctype="multipart/form-data">
		日期: <input type="text" name="date" /> <br> <br> <input
			type="submit" value="Submit" />
	</form>

	<button id="btn1" type="button">获得外部的内容</button>

	<p align="center">
		<a href="registerForm">注册</a>
	</p>
	<br>
	<p align="center">
		<a href="Testssm">add User</a>
	</p>
	<br>
	<p align="center">
		<a href="Exception?m=12&n=2">Exception</a>
	</p>

	<form action="FileUpload" method="POST" enctype="multipart/form-data">
		xml: <input type="file" name="file" /> <br> <br> <input
			type="submit" value="Submit" />
	</form>
	<br>
	<br>

	<form action="Testssm">
		name:<input type="text" name="userName" /> <input type="submit"
			value="submit" />
	</form>
	<br>







</body>
</html>