<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*,javax.sql.*,com.ascent.bean.Usr,com.ascent.util.DataAccessJDBC,com.ascent.dao.LoginDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="user" class="com.ascent.bean.Usr" scope="session"/>
<jsp:setProperty property="*" name="user"/>

<%
	Connection conn = DataAccessJDBC.getConnection();
	
	String sql="insert into usr(username,password,fullname,title) values(?,?,?,?)";
	PreparedStatement pst = conn.prepareStatement(sql);
	pst.setString(1,user.getUsername());
	pst.setString(2,user.getPassword());
	pst.setString(3,user.getFullname());
	pst.setString(4,user.getTitle());
	int isRegister = pst.executeUpdate();

	if(isRegister == 1)
		out.println("用户名："+ user.getUsername()+"注册成功！");
	else
		out.println("用户注册失败，请重新注册！");
			
%>
</body>
</html>