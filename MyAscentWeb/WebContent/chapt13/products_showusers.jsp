<%@ page language="java" import="com.ascent.bean.*,java.util.*"
	pageEncoding="GB2312" contentType="text/html;charset=gb2312"
	errorPage="./error.jsp"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>AscentWeb��������</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
</head>

<body>
	<table border="1">
		<tr>
			<td>���</td>
			<td>�û���</td>
			<td>��˾����</td>
			<td>��˾��ַ</td>
		</tr>
		<c:forEach var="user" items="${requestScope.allproductlist }">
			<tr>
				<td><c:out value="${user.id}" /></td>
				<td><c:out value="${user.username}" /></td>
				<td><c:out value="${user.companyname}" /></td>
				<td><c:out value="${user.companyaddress}" /></td>
			</tr>
		</c:forEach>
	</table>
	<div id="footer">
		<p>
			<a href="http://www.ascenttech.com.cn/" target="_blank">��Ȩ���У�������˼������Ƽ����޹�˾
				&copy;2004-2008|��ICP��05005681</a>
		</p>
	</div>

</body>
</html>
