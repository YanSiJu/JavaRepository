<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<script type="text/javascript" src="scripts/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#b01").click(function() {
			var text = $("#myDiv").text()
			var data = {
				"data" : text
			};
			alert(text);
			$.ajax({
				url : 'Ajax.json',
				type : 'POST',
				data : JSON.stringify(data),
				contentType : 'application/json; charset=utf-8',
				dataType : 'json',
				success : function(response) {
					//请求成功
					console.log(response.data)
					console.log(response.time)
				},

				error : function(msg) {
					console.log("error")
					console.log(msg)
				}
			});
		});
	});
</script>
<title>Ajax</title>
</head>
<body>
	<div id="myDiv">
		<p>Let AJAX change this text</p>
	</div>
	<button id="b01" type="button">Change Content</button>

	<!-- <form name="loginForm" action="http://www.google.com.hk" method="get">
		<input type="text" id="username"
			style="width: 100px; height: 30px; font-size: 20px; font-weight: bold;">
		<input type="text" id="age"
			style="width: 100px; height: 30px; font-size: 20px; font-weight: bold;">
		<input type="submit" value="Submit" id="submit" />
	</form> -->

</body>
</html>