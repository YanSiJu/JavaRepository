<%@ page language="java" import="java.util.*,com.ascent.bean.*,com.ascent.util.*" contentType="text/html;charset=gb2312" isErrorPage="true"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<html>
	<head>
		<title>AscentWeb电子商务</title>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<link href="./css/index.css" rel="stylesheet" type="text/css" />
	</head>

	<body>

		<div class="head">
			<div id="login_1">

			</div>
			<div id="login_2"></div>
			<div id="login_3"></div>
			<div class="img">
				<img src="./images/web_4.jpg" width="277" height="80" />
			</div>
			<div class="img">
				<img src="./images/web_5.jpg" width="273" height="80" />
			</div>
			<div class="img">
				<img src="./images/web_6.jpg" width="250" height="80" />
			</div>
			<div id="bannerbj">
			
			</div>
			<div id="bannerbj2">
				<div class="banner_wenzi">|&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="./index.jsp">首 页</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="./product/itservice.jsp">IT服务</a>&nbsp;&nbsp;&nbsp;&nbsp;| &nbsp;&nbsp;&nbsp;&nbsp;
					<a href="./product/products.jsp">电子商务系统</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="./product/employee.jsp">员工招聘</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="./product/ContactUs.jsp">关于我们</a>
				</div>
			</div>
			<div id="bannerbj1"></div>
		</div>
		<div class="padding">
			<div id="middlebody">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<%
							Usr p = (Usr) session.getAttribute("productuser");
							if ((p != null && p.getSuperuser().equals("3"))||p != null && p.getSuperuser().equals("2")) { //管理员
						%>
						<td height="20">
							<div class="table_t">
								|&nbsp;&nbsp;欢迎,<%=p.getUsername()%> &nbsp;&nbsp;|&nbsp;&nbsp;
								<a href="./login?a=out" class="table_t">注销</a>&nbsp;&nbsp;|
							</div>
						</td>
						<td>
						<div>
						<a href="./user?a=all"><img src="./images/userlist.jpg" border="0" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="./product?a=all"><img src="./images/productslist.jpg" border="0" /> </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="./admin/mailmanager.jsp"><img src="./images/mailmanager.jpg" border="0" /> </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    </div>
						</td>
						<%
							} else if (p != null && p.getSuperuser().equals("1")) { //刚注册用户
						%>
						<td width="30%">
							<div align="left">
								|&nbsp;&nbsp;欢迎,<%=p.getUsername()%>&nbsp;&nbsp;|&nbsp;&nbsp;
								<a href="./login?a=out" class="table_t">注销</a>&nbsp;&nbsp;|
							</div>
						</td>
						<td width="20%">
							<div align="center">
								&nbsp;
							</div>
						</td>
						<td width="15%">
							<div align="center">
								<a href="./order?a=all">查看订单</a>
							</div>
						</td>
						<td width="15%">
							<div align="center">
								<a href="./product?a=all">继续购物</a>
							</div>
						</td>
						<td width="15%">
							<div align="center">
								<a href="./shopcart?a=checkout">结算中心</a>
							</div>
						</td>
						<%
							} else if (p == null) { //未注册用户
						%>
						<td width="30%">
							<div align="left">
								|&nbsp;&nbsp;欢迎,游客&nbsp;&nbsp;|&nbsp;&nbsp;
								<a href="./product/register.jsp" class="table_t">注册</a>&nbsp;&nbsp;|
							</div>
						</td>
						<td width="20%">
							<div align="center">
								&nbsp;
							</div>
						</td>
						<td width="15%">
							<div align="center">
								&nbsp;
							</div>
						</td>
						<td width="15%">
							<div align="center">
								<a href="./product?a=all">继续购物</a>
							</div>
						</td>
						<td width="15%">
							<div align="center">
								<a href="./shopcart?a=checkout">结算中心</a>
							</div>
						</td>
						<%
							}
						%>
					</tr>
				</table>
				<br>
				<br>

				<center>
					<h3>
						出错了，选择其他操作！
					</h3>
				</center>
			</div>
			<div>
				<img src="./images/banquan.jpg"
					width="800" height="35" border="0" />
			</div>
		</div>	
	</body>
</html>
