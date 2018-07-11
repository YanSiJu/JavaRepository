<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>服装库存管理系统首页</title>
<link type="text/css" rel="stylesheet" href="css/homePage.css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/homePage.js"></script>
</head>
<body>
<div id="header">
	<div class="logo">服装库存管理系统</div>
	<div class="navigation">
		<ul>
			<li>
			
			<c:choose>
			<c:when  test="${sessionScope.userName == null}">您好，请<a href="jsp/login.jsp" style="text-decoration: none;" target="_blank">登录</a></c:when>
			<c:otherwise>欢迎您，${sessionScope.userName}</c:otherwise>
			</c:choose>
			</li>
			<li><a href="jsp/setPassword.jsp" target="main">修改密码</a></li>
			<li><a href="jsp/login.jsp">退出</a></li>
		</ul>
	</div>
</div>
<div id="content">
	<div class="left_menu">
				<ul id="nav_dot">
      <li>
          <h4 class="M1"><span></span>用户管理</h4>
          <div class="list-item none">
            <a href="jsp/register.jsp" target="_blank">新增用户信息</a>
            <a href="jsp/user.jsp?operate=delete" target="main">删除用户信息</a>
            <a href="jsp/user.jsp?operate=update" target="main">修改用户信息</a>
            <a href="jsp/user.jsp?operate=select" target="main">查询用户信息</a>
          </div>
        </li>
        <li>
          <h4 class="M2"><span></span>服装管理</h4>
          <div class="list-item none">
            <a href="jsp/product.jsp?operate=insert" target="main">新增服装信息</a>
            <a href="jsp/product.jsp?operate=delete" target="main">删除服装信息</a>
            <a href="jsp/product.jsp?operate=update" target="main">修改服装信息</a>
            <a href="jsp/product.jsp?operate=select" target="main">查询服装信息</a>
           </div>
        </li>
        <li>
          <h4 class="M3"><span></span>入库管理</h4>
          <div class="list-item none">
            <a href='#' target="main">新增入库单</a>
            <a href='#' target="main">删除入库单</a>
            <a href='#' target="main">修改入库单</a>
            <a href='#' target="main">查询入库单</a>
          </div>
        </li>
				<li>
          <h4 class="M4"><span></span>入库明细管理</h4>
          <div class="list-item none">
            <a href='#' target="main">新增入库明细</a>
            <a href='#' target="main">删除入库明细</a>
            <a href='#' target="main">修改入库明细</a>
            <a href='#' target="main">查询入库明细</a>
          </div>
        </li>
				<li>
          <h4 class="M5"><span></span>出库管理</h4>
          <div class="list-item none">
            <a href='#' target="main">新增出库单</a>
            <a href='#' target="main">删除出库单</a>
            <a href='#' target="main">修改出库单</a>
            <a href='#' target="main">查询出库单</a>
          </div>
        </li>
				<li>
          <h4 class="M6"><span></span>出库明细管理</h4>
          <div class="list-item none">
            <a href='#' target="main">新增出库明细</a>
            <a href='#' target="main">删除出库明细</a>
            <a href='#' target="main">修改出库明细</a>
            <a href='#' target="main">查询出库明细</a>
          </div>
        </li>
  </ul>
		</div>
		<div class="m-right">
			<div class="right-nav">
					<ul>
							<li><img src="images/home.png" style="vertical-align:top;"></li>
								<li style="margin-left:25px;">您当前的位置：</li>
								<li id="right-nav1"></li>
								<li id="right-nav2"></li>
					</ul>
			</div>
			<div class="main">
				<iframe name="main" style=" width:100%; height:95%; border:none">
				
				
                </iframe>
			</div>
		</div>
</div>
<div id="footer"><p>版权所有，仿冒必究</p></div>
<script>navList(12);</script>
<script>
   $("#nav_dot a").click(function(){
	   var $a=$(this).clone();
	   var str=$(this).parent().prev().text();
	   $("#right-nav1").html(str+" < ");
	   $("#right-nav2").empty();
	   $("#right-nav2").append($a);
	   });
	   
	   $(".navigation a").click(function(){
	   var $a=$(this).clone();
	   var str=$(this).parent().prev().text();
	   $("#right-nav1").html("首页 <");
	   $("#right-nav2").empty();
	   $("#right-nav2").append($a);
	   });
</script>
</body>
</html>