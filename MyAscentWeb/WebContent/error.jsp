<%@ page language="java" import="java.util.*,com.ascent.bean.*,com.ascent.util.*" contentType="text/html;charset=gb2312" isErrorPage="true"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<html>
	<head>
		<title>AscentWeb��������</title>
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
					<a href="./index.jsp">�� ҳ</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="./product/itservice.jsp">IT����</a>&nbsp;&nbsp;&nbsp;&nbsp;| &nbsp;&nbsp;&nbsp;&nbsp;
					<a href="./product/products.jsp">��������ϵͳ</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="./product/employee.jsp">Ա����Ƹ</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="./product/ContactUs.jsp">��������</a>
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
							if ((p != null && p.getSuperuser().equals("3"))||p != null && p.getSuperuser().equals("2")) { //����Ա
						%>
						<td height="20">
							<div class="table_t">
								|&nbsp;&nbsp;��ӭ,<%=p.getUsername()%> &nbsp;&nbsp;|&nbsp;&nbsp;
								<a href="./login?a=out" class="table_t">ע��</a>&nbsp;&nbsp;|
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
							} else if (p != null && p.getSuperuser().equals("1")) { //��ע���û�
						%>
						<td width="30%">
							<div align="left">
								|&nbsp;&nbsp;��ӭ,<%=p.getUsername()%>&nbsp;&nbsp;|&nbsp;&nbsp;
								<a href="./login?a=out" class="table_t">ע��</a>&nbsp;&nbsp;|
							</div>
						</td>
						<td width="20%">
							<div align="center">
								&nbsp;
							</div>
						</td>
						<td width="15%">
							<div align="center">
								<a href="./order?a=all">�鿴����</a>
							</div>
						</td>
						<td width="15%">
							<div align="center">
								<a href="./product?a=all">��������</a>
							</div>
						</td>
						<td width="15%">
							<div align="center">
								<a href="./shopcart?a=checkout">��������</a>
							</div>
						</td>
						<%
							} else if (p == null) { //δע���û�
						%>
						<td width="30%">
							<div align="left">
								|&nbsp;&nbsp;��ӭ,�ο�&nbsp;&nbsp;|&nbsp;&nbsp;
								<a href="./product/register.jsp" class="table_t">ע��</a>&nbsp;&nbsp;|
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
								<a href="./product?a=all">��������</a>
							</div>
						</td>
						<td width="15%">
							<div align="center">
								<a href="./shopcart?a=checkout">��������</a>
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
						�����ˣ�ѡ������������
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
