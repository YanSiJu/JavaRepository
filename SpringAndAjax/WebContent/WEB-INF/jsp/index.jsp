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
<title>jQuery i18n</title>
<script type="text/javascript">
    $().ready(
            function() {
                $("#sub").click(
                        function() {
                            var name = $("#username").val();
                            var age = 18;
                            var user = {"username":name,"age":age};
                            $.ajax({
                                        url : 'hello.json',
                                        type : 'POST',
                                        data : JSON.stringify(user), // Request body 
                                        contentType : 'application/json; charset=utf-8',
                                        dataType : 'json',
                                        success : function(response) {
                                            //请求成功
                                            alert("你好" + response.username + "[" + response.age + "]，当前时间是：" + response.time + "，欢迎访问：http://www.zifangsky.cn");
                                             
                                        },
                                        error : function(msg) {
                                            alert(msg);
                                        }
                                    });
                        });
            });
</script>
</head>
<body>
    <input type="text" id="username"
        style="width: 100px; height: 30px; font-size: 20px; font-weight: bold;">
    <input type="button" id="sub" value="Go"
        style="height: 40px; height: 30px;">
    <br>
</body>
</html>