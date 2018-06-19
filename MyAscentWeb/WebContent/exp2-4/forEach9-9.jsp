<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forEach Tag</title>
</head>
<body>
<table border="1" width="90%">
	<tr>
		<th>Value</th><th>Square</th>
	</tr>
	<c:forEach var="x" begin="0" end="10" step="1">
		<tr>
			<td><c:out value="${x}"/></td>
			<td><c:out value="${x*x}"/></td>			
		</tr>
	</c:forEach>
</table>
</body>
</html>