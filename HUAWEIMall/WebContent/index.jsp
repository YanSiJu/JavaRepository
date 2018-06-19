<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="index.css" type="text/css"/>
<title>华为手机购物商城首页</title>
</head>
<body>
<div class="content">
	<table>
	<tr><td class="top_left">
	
	<c:choose>
	<c:when test="${empty param.userName }">您好，请<a href="login.jsp" style="text-decoration: none;">登录</a></c:when>
	<c:otherwise>欢迎您，${param.userName }</c:otherwise>
	</c:choose>
	
	</td>
	<td class="top_right">
	
		<a href="goods.jsp"><img class="shoppingCar" src="D:\WorkSpace\ShoppingMall\WebContent\WEB-INF\picture\购物车.jpg" ></a>
	
	</td>
	</tr>
	
	
	
	<tr><td>
	<a href="goods.jsp"><img id="HUAWEI" src="D:\WorkSpace\ShoppingMall\WebContent\WEB-INF\picture\华为荣耀10\华为荣耀10海鸥灰正面.png" ></a>
	
	</td>
	
	<td>
	
	</td></tr>
	 
	
	</table>
	
	
	<script type="text/javascript">
	function getSrc(){
		var url = document.getElementById("HUAWEI").src;
		return url;
		}
	</script>
	
	<c:set scope="session" value="${url}" var="goodsSrc"></c:set>
	</div>
	
	${sessionScope.goodsSrc}
	
</body>
</html>