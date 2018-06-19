<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table border="1">
		<% for(int i=0;i<5;i++) {%>
		<tr><td><%=i %></td><td><%=i*i %></td>
		<%} %>
		</table>
		
		<table border="1">
		<c:forEach var="i" begin="0" end="4">
		<tr>
		<td><c:out value="${i}"/></td>
		<td><c:out value="${i*i}"/></td>
		</tr>
		</c:forEach>
</table>
		
</body>
</html>