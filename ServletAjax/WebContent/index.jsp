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
<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function Check() {
		var data = {
			"name" : "Loki",
			"age" : 25
		};
		$.ajax({
			url : "./Check",
			type : 'POST',
			data : JSON.stringify(data),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			success : function(response) {
				console.log(response.message)
				console.log(response.age)
			},
			error : function(msg) {
				console.log(msg)
			}

		});
	}
</script>
<title>首页</title>
</head>
<body>
<body>
	<input type="submit" onclick="Check()" value="submit" />
</body>
</body>

</html>