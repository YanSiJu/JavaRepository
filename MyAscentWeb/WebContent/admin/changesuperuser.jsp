<%@ page language="java" import="com.ascent.bean.*" pageEncoding="GB2312" errorPage="./error.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>AscentWeb��������</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<link rel="stylesheet" href="./css/andreas08(blue).css"
			type="text/css" media="screen,projection" />
	</head>
	<body>
		<form name="form" action="./user?a=updatesuper" method="post">
			<div id="container">
				<div id="header"></div>
				<div id="navigation">
					<ul>
						<li class="selected"></li>
						<li>
							<a href="./index.jsp">��ҳ</a>
						</li>
						<li>
							<a href="./product/itservice.jsp">IT����</a>
						</li>
						<li>
							<a href="./product/products.jsp">��������ϵͳ</a>
						</li>
						<li>
							<a href="./product/employee.jsp">Ա����Ƹ</a>
						</li>
						<li>
							<a href="./product/ContactUs.jsp">��������</a>
						</li>
					</ul>
				</div>
				<div id="content2">
					<table width="100%" height="41" border="0" align="center"
						cellpadding="0" cellspacing="0">
						<tr>
							<td height="4" colspan="2" align="left" valign="bottom"></td>
						</tr>
						<tr>
							<td height="15" align="left" valign="top">
								&nbsp;
							</td>
							<td height="15" align="left" valign="top" class="12">

								<table width="100%" height="20" border="0" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="20">
											<div class="right_proaducts">
												�ҵ�λ��&gt;&gt;�����������&gt;&gt;�û��޸�
											</div>
										</td>
									</tr>
								</table>
								<br />
								<table width="680" border="0" cellpadding="0" cellspacing="0">
									<tbody>
										<tr>
											<td bgcolor="#467AA7" colspan="2" height="5"></td>
										</tr>
										<tr>
											<td colspan="2" height="7"></td>
										</tr>
										<tr>
											<td width="110" height="20" bgcolor="#bbddff" class="table_c">
												�޸�Ȩ��
											</td>
											<td width="439" bgcolor="#ffffff">
												&nbsp;&nbsp;&nbsp;&nbsp;
												<a href="javascript:history.back()">&lt;&lt;&lt; ����</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											</td>
										</tr>
									</tbody>
								</table>
								<div class="table_wz">

									<table width="680" height="260" border="0" cellpadding="0"
										cellspacing="0">
										<tbody>
											<tr>
												<td colspan="2" height="5">
													<%
														String uidd = request.getParameter("uid");
														String superuser = request.getParameter("superuser");
													%>
												
													<%
														Usr p = (Usr) session.getAttribute("productuser");
														if ((p != null && p.getSuperuser().equals("3"))||(p != null && p.getSuperuser().equals("2"))) {
													%>

													<%
															if ("1".equals(superuser)) {
													%>
																<INPUT type="radio" name="superuser" value="1" checked="true">
													<%
															} else {
													%>
																<INPUT type="radio" name="superuser" value="1">
													<%
															}
													%>&nbsp;&nbsp;��ͨע���û�
													<br />
													<%
															if ("2".equals(superuser)) {
													%>
																<INPUT type="radio" name="superuser" value="2" checked="true">
													<%
															} else {
													%>
																<INPUT type="radio" name="superuser" value="2">
													<%
															}
													%>&nbsp;&nbsp;����Ա
													<br>
													<input type="hidden" name="uid" value="<%=uidd%>" />

													<P>
														&nbsp;
													</P>
													<P>
														&nbsp;&nbsp; &nbsp;
														<INPUT type="submit" name="submit" value="�޸�">
														&nbsp;
													</P>
													<P>
														&nbsp;
													</P>
													<P>
														&nbsp;
													</P>


													<%
														} else //�������if��else
														{
													%>
													<br>
													<br>
													<br>
													<br>
													<br>
													<br />
													<center>
														<h3>
															�Բ�����û��Ȩ�޲鿴������
														</h3>
													</center>

													<%
														}
													%>

												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</td>

						</tr>
					</table>
					<br />
					<div class="table_wz"></div>

				</div>
				<div id="footer">
					<p>
						<a href="http://www.ascenttech.com.cn/" target="_blank">��Ȩ����:������˼������Ƽ����޹�˾
							&copy;2004-2008|��ICP��05005681</a>
					</p>
				</div>
			</div>
		</form>
	</body>
</html>
