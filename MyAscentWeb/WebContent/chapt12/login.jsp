<%@ page contentType="text/html; charset=GBK" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <!-- 加上base标签后，可以避免jsp不在根目录下时，无法正常提交给servlet的问题 -->
    <base href="<%=basePath%>">
<title>
login
</title>
</head>
<body bgcolor="#ffffff">
<h1>
欢迎来到网上书店！
</h1>

<% String value = (String)request.getAttribute("error");
   if(value!=null){
   	out.println("错误提示信息"+value);
     }
  
%>
<form action="NewLogin" method="post" >
<br><br>
  用户名 <input type="text" name="usename" ><br>
 密码 <input type="password"name="password"><br>
<input type="submit" name="Submit1" value="登录">
<input type="submit" name="Submit2" value="注册">
</form>
</body>
</html>
