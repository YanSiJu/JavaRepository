<%@ page language="java" import="com.ascent.bean.*,java.util.*" pageEncoding="GB2312" contentType="text/html;charset=gb2312" errorPage="./error.jsp"%>
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
		<div id="container">
			<div id="header">
			</div>
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
					<li></li>
				</ul>
			</div>

			<div id="content2">
				<table width="100%" height="41" border="0" align="center"
					cellpadding="0" cellspacing="0">
					<tr>
						<td width="15" height="18" align="left" valign="top">
							<div align="left"></div>
						</td>
						<td width="385" align="left" valign="bottom" class="12">
							&nbsp;
						</td>
					</tr>
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
											�ҵ�λ��&gt;&gt;�����������&gt;����&gt;�����鿴
											<br />
											<br />
										</div>

										<table cellspacing="0" cellpadding="0" width="100%" border="0">
											<tbody>
												<tr>
													<%
														String orderid = (String) request.getAttribute("orderid");
														Usr p = (Usr) session.getAttribute("productuser");
														if ((p != null && p.getSuperuser().equals("3"))||p != null && p.getSuperuser().equals("2")) { //����Ա
													%>
													<td width="33%">
														<div align="left">
															|&nbsp;&nbsp;��ӭ,<%=p.getUsername()%>&nbsp;&nbsp;|
															<a href="./login?a=out" class="table_t">ע��</a>|
															<a href="javascript:history.back()"><<< ����</a>
														</div>
													</td>
													<td>
														<div align="center">
															<a href="./product?a=all"><img src="./images/productslist.jpg" width="75" height="17" border="0" />
															</a>
														</div>
													</td>
													<td>
														<div align="center">
															<a href="./order?a=all">��������</a>
														</div>
													</td>
													<td height="50">
														<div align="center">
															&nbsp;
														</div>
													</td>
													<%
														} else if (p != null && p.getSuperuser().equals("1")) { //ע���û�
													%>
													<td width="33%">
														<div align="left">
															|&nbsp;&nbsp;��ӭ,<%=p.getUsername()%>&nbsp;&nbsp;|
															<a href="./login?a=out" class="table_t">ע��</a>|
															<a href="javascript:history.back()"><<< ����</a>
														</div>
													</td>
													<td>
														<div align="center">
															&nbsp;
														</div>
													</td>
													<td>
														<div align="center">
															<a href="./product/Product_Search.jsp">��Ʒ��ѯ</a>
														</div>
													</td>
													<td>
														<div align="center">
															<a href="./order?a=all">��������</a>
														</div>
													</td>
													<td height="50">
														<div align="center">
															<a href="./shopcart?a=find">�鿴���ﳵ</a>
														</div>
													</td>
													<%
														}
													%>
												</tr>
											</tbody>
										</table>

										<table width="100%" border="1" cellspacing="0" cellpadding="0"
											class="mars">
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
												<%
													if (p != null && p.getSuperuser().equals("3")) {//����Ա
												%>
												<td>
													<div align="center">
														ɾ��
													</div>
												</td>
												<%
													}
												%>
											</tr>
											<%
												List<Product> list = (List<Product>) request.getAttribute("orderitemlist");
												for(Product pu : list){
													int pid = pu.getId();
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
													if (pu.getImagepath() == null || pu.getImagepath().equals("")) {
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
												<%
													if (p != null && p.getSuperuser().equals("3")) { //����Ա
												%>
												<td>
													<div align="center">
														<a href="./order?a=delitem&pid=<%=pid%>&oid=<%=orderid%>">ɾ��</a>
													</div>
												</td>
												<%
													}
												%>
											</tr>
											<%
												}
											%>
										</table>
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
	</body>
</html>
