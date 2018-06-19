<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="sample.UserManagerDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
<%
	String username = request.getParameter("username");
	out.println(username);
	session.setAttribute("username", username);
%>
--%>

<jsp:useBean id="myUser" class="com.ascent.bean.Usr">
<jsp:setProperty name="myUser" property="username"  />
<jsp:setProperty name="myUser" property="password" />
</jsp:useBean>

<!-- <%= "username:" + myUser.getUsername() %> -->
username: <jsp:getProperty property="username" name="myUser"/>
<%= "password:" + myUser.getPassword() %>

<%
	UserManagerDao dao = new UserManagerDao();	
	if(dao.register(myUser)) 
		out.println("success register");
	else
		out.println("register failure");

%>

</body>
</html>