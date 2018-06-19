<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用ajax进行异步验证</title>
<style type="text/css">
body {
	font-size: 12px;
}

table {
	font-size: 12px;
}

table input {
	width: 120px;
}

table em {
	color: #ff0000;
}

#body {
	margin-left: 200px;
	margin-top: 220px;
}
</style>
<script type="text/javascript" src="scripts/jquery-3.2.1.min.js"></script>
<script language="javascript" type="text/javascript">
	$(document).ready(function() {
		$("#username").focus();
	});
	var hadoop = function() {
		// 异步验证用户是否重复
		if ($.trim($("#username").val()) == "") {
			$("#message").html("用户名不能为空");
		/* $("#username").focus();  */
		} else {
			var name = {
				"name" : $("#username").val()
			};
			console.log(name);
			$.ajax({
				url : 'registerValidate',
				type : 'POST',
				data : JSON.stringify(name),
				contentType : 'application/json; charset=utf-8',
				dataType : 'json',
				success : function(response) {
					console.log(response);
					//$("#message").html(response);
				},
				error : function(msg) {
					console.log("ajax error:");
					console.log(msg);
				}
			});
			//$("#username").focus();
		}
	};
</script>
</head>
<body>
	<div id="body">
		<form action="#" method="post">
			<table>
				<tr>
					<td>用户名：</td>
					<td><input type="text" id="username" name="username"
						onblur="hadoop()" /></td>
					<td><em id="message"></em></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td colspan="2"><input type="text" /></td>
				</tr>
			</table>
			<br> <input type="button" id="submit" value="Go"
				style="height: 40px; height: 30px;">
		</form>
	</div>
</body>
</html>