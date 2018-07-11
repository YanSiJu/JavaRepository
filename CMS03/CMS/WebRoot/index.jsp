<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
out.print("path:"+path+"  "+"basePath:"+basePath);//输出到网页
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台模板管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="<%=path %>/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/menu.js"></script>
</head>
<body>
<div id="header">
	<div class="logo">服装库存管理系统</div>
	<div class="navigation">
		<ul>
		 	<li>欢迎您！</li>
			<li><a href="">admin</a></li>
			<li><a href="">修改密码</a></li>
			<li><a href="">设置</a></li>
			<li><a href="">退出</a></li>
		</ul>
	</div>
</div>
<div id="content">
	<div class="left_menu">
				<ul id="nav_dot">
      <li>
          <h4 class="M1"><span></span>系统管理</h4>
          <div class="list-item none">
            <a href='<%=path %>/ColorServlet?type=query' target="main">颜色管理</a>
            <a href='#'>尺寸管理</a>
            <a href='#'>面料管理</a>
            <a href='<%=path %>/ProductServlet?page=1&pageSize=5' target="main">服装管理</a>
            <a href='#'>客户管理</a>
            <a href='#'>用户管理</a>
          </div>
        </li>
        <li>
          <h4 class="M2"><span></span>库存管理</h4>
          <div class="list-item none">
            <a href='<%=path %>/StockinServlet?page=1&pageSize=5' target="main">入库管理</a>
            <a href='<%=path %>/StockoutServlet?page=1&pageSize=5' target="main">出库管理</a>          
           </div>
        </li>
        <li>
          <h4 class="M3"><span></span>基础教学</h4>
          <div class="list-item none">
            <a href=''>基础教学1</a>
            <a href=''>基础教学2</a>
            <a href=''>基础教学3</a>
          </div>
        </li>
				<li>
          <h4 class="M4"><span></span>评论管理</h4>
          <div class="list-item none">
            <a href=''>评论管理1</a>
            <a href=''>评论管理2</a>
            <a href=''>评论管理3</a>
          </div>
        </li>
				<li>
          <h4 class="M5"><span></span>调研问卷</h4>
          <div class="list-item none">
            <a href=''>调研问卷1</a>
            <a href=''>调研问卷2</a>
            <a href=''>调研问卷3</a>
          </div>
        </li>
				<li>
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
</script>
</body>
</html>

