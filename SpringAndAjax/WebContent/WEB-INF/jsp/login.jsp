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
<script type="text/javascript" src="scripts/validator.min.js"></script>
<script type="text/javascript" src="scripts/authorizeCheck.js"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#submit").click(function(event) {
			var age = $("#age").val();
			var name = $("#userName").val();
			var user = {
				"username" : name,
				"age" : age
			};
			/* var user = {"username":name,"age":age}; */
			console.log(user)
			$.ajax({
				url : 'login',
				type : 'POST',
				data : JSON.stringify(user),
				contentType : 'application/json; charset=utf-8',
				dataType : 'json',
				success : function(response) {
					var msg = response.msg;
					if (msg == "loginSuccess!!!") {
						console.log("login success");
						console.log(msg);
						var submitBtn = $("#submit");
						submitBtn.onclick = function(event) {
							return true;
						};
					} else if (msg == "error") {
						console.log("login failed");
						var submitBtn = $("#submit");
						submitBtn.onclick = function(event) {
							return false;
						};
					}
				},
				error : function(msg) {
					console.log("ajax error:");
					console.log(msg);
				}
			});
		});

	});
</script>
<title>Login</title>
</head>
<body>

	<form action="https://www.google.com.hk/" method="get">
		<input type="text" id="userName"> <br> <input type="text"
			id="age"> <br> <input type="button" id="submit"
			value="Go" style="height: 40px; height: 30px;">
	</form>
</body>
</html>