<%@ page language="java" import="java.util.*,com.ascent.bean.*" pageEncoding="GB2312" errorPage="./error.jsp"%>
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
		<link rel="stylesheet" href="./css/andreas08(blue).css" type="text/css" media="screen,projection" />

	</head>
	<body>
		<form name="form" method="post" action="">
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
												�ҵ�λ��&gt;&gt;�����������&gt;��Ʒ�б�
											</div>
											<br />
											<%
												Usr p = (Usr) session.getAttribute("productuser");
												if ((p != null && p.getSuperuser().equals("3"))||p != null && p.getSuperuser().equals("2")) {
											%>
											<table width="100%">
												<tbody>
													<tr>
														<td height="20" width="30%">
															<div class="table_t">
																|&nbsp;&nbsp;��ӭ,<%=p.getUsername()%>&nbsp;&nbsp;|&nbsp;&nbsp;
																<a href="./login?a=out" class="table_t">ע��</a>&nbsp;&nbsp;|
															</div>
														</td>
														<td width="70%">
															<div>
																<a href="./user?a=all"><img src="./images/userlist.jpg" border="0" />
																</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																<a href="./product?a=all"><img src="./images/productslist.jpg" border="0" />
																</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																<a href="./order?a=all"><img src="./images/ShowOrders.jpg" border="0" />
																</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																<a href="./admin/add_products_admin.jsp"><img src="./images/addProduct.jpg" border="0" />
																</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															</div>
														</td>
													</tr>
													<!-- ��Ʒ�б� -->
												</tbody>
											</table>
											<table class="mars" cellspacing="1" cellpadding="0"
												width="100%" border="0">
												<tbody>
													<tr bgcolor="#fba661" height="30">
														<td>
															<div align="center">
																���
															</div>
														</td>
														<td>
															<div align="center">
																����
															</div>
														</td>
														<td>
															<div align="center">
																catalogno
															</div>
														</td>
														<td>
															<div align="center">
																MDLNumber
															</div>
														</td>
														<td>
															<div align="center">
																�۸�
															</div>
														</td>
														<td>
															<div align="center">
																���
															</div>
														</td>
														<td>
															<div align="center">
																ͼƬ
															</div>
														</td>
														<td>
															<div align="center">
																�޸�
															</div>
														</td>
														<td>
															<div align="center">
																ɾ��
															</div>
														</td>
													</tr>
													<%
														List<Product> list = (List<Product>) request.getAttribute("productlist");
															for (Product pu : list) {
																int id = pu.getId();
													%>
													<tr bgcolor="#f3f3f3" height="25">
														<td width="10%">
															<div align="center"><%=pu.getProductnumber()%></div>
														</td>
														<td width="13%">
															<div align="center"><%=pu.getProductname()%></div>
														</td>
														<td width="12%">
															<div align="center"><%=pu.getCategoryno()%></div>
														</td>
														<td width="13%">
															<div align="center"><%=pu.getMdlint()%></div>
														</td>
														<td width="10%">
															<div align="center"><%=pu.getPrice1()%></div>
														</td>
														<td width="13%">
															<div align="center"><%=pu.getStock()%></div>
														</td>
														<%
															if (pu.getImagepath() == null
																			|| pu.getImagepath().equals("")) {
														%>
														<td width="12%">
															<div align="center">
																<img
																	src="<%=request.getContextPath() + "/upload/23007.gif"%>"
																	width="60" height="30" hspace="0" border="0" />
															</div>
														</td>
														<%
															} else {
														%>
														<td width="12%">
															<div align="center">
																<img
																	src="<%=request.getContextPath() + "/upload/" + pu.getImagepath()%>"
																	width="60" height="30" hspace="0" border="0" />
															</div>
														</td>
														<%
															}
														%>
														<td>
															<div align="center">
																<a
																	href="./product?a=updateProduct&pid=<%=id%>"><img
																		src="./images/update1.gif"
																		width="20" height="20" border="0" alt="�޸�" />
																</a>
															</div>
														</td>
														<td>
															<div align="center">
																<a
																	href="./product?a=del&pid=<%=id%>"
																	onclick="return confirm_oper();"><img
																		src="./images/sz_tu02.gif"
																		border="0" alt="ɾ��" />
																</a>
															</div>
														</td>
													</tr>
													<%
														}
													%>
												</tbody>
											</table>
											<%
												} else { //�������if��else
											%>
											<br />
											<br />
											<br />
											<br />
											<br />
											<br />
											<center>
												<h3>
													�Բ�����û��Ȩ�޲鿴������
												</h3>
											</center>
											<br />
											<br />
											<br />
											<br />
											<br />
											<br />
											<br />
											<br />
											<br />
											<br />
											<br />
											<br />
											<%
												}
											%>


										</td>
									</tr>
								</table>
								<br />
								<div class="table_wz"></div>
							</td>
						</tr>
					</table>
				</div>
				<div id="footer">
					<p>
						<a href="http://www.ascenttech.com.cn/" target="_blank">��Ȩ���У�������˼������Ƽ����޹�˾
							&copy;2004-2008|��ICP��05005681</a>
					</p>
				</div>

			</div>
		</form>
	</body>
</html>