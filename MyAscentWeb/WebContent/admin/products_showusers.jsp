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
		<link rel="stylesheet" href="./css/andreas08(blue).css" type="text/css" media="screen,projection" />
	</head>

	<body>
		<form name="form" method="post" action="">
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
				<%
					Usr p = (Usr) session.getAttribute("productuser");
					if (p != null && p.getSuperuser().equals("3")) {
				%>
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
											<div class="table_t">
												|&nbsp;&nbsp;��ӭ,
												<%=p.getUsername()%>
												&nbsp;&nbsp;|&nbsp;&nbsp;
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
									</tr>
								</table>
								<br />
								
								<table width="100%" border="0" cellspacing="1" cellpadding="0"
									class="mars">
									<tr bgcolor="#fba661" height="25">
										<td width="10%" bgcolor="#fba661">
											<div align="center">
												�û���
											</div>
										</td>
										<td width="13%" bgcolor="#fba661">
											<div align="center">
												Email
											</div>
										</td>
										<td width="12%" bgcolor="#fba661">
											<div align="center">
												�绰
											</div>
										</td>
										<td width="13%" bgcolor="#fba661">
											<div align="center">
												��˾����
											</div>
										</td>
										<td width="13%" bgcolor="#fba661">
											<div align="center">
												��ɫ
											</div>
										</td>
										<td width="9%" bgcolor="#fba661">
											<div align="center">
												�޸�
											</div>
										</td>
										<td width="10%" bgcolor="#fba661">
											<div align="center">
												��ɫ�޸�
											</div>
										</td>
										<td width="10%" bgcolor="#fba661">
											<div align="center">
												״̬
											</div>
										</td>
									</tr>
									<%
											
											List<Usr> list = (List<Usr>) request.getAttribute("allproductlist");
											for(Usr pu : list){
												String state = pu.getSuperuser();
												String del = pu.getDelsoft();
									%>
												<tr bgcolor="#f3f3f3" height="25">
													<td width="10%">
														<div align="center">
															<%=pu.getUsername()%>
														</div>
													</td>
													<td width="13%">
														<div align="center">
															<%=pu.getEmail()%>
														</div>
													</td>
													<td width="12%">
														<div align="center">
															<%=pu.getTel()%>
														</div>
													</td>
													<td width="13%">
														<div align="center">
															<%=pu.getCompanyname()%>
														</div>
													</td>
													<%
														if (state.equals("3")) {
													%>
															<td width="13%">
																<div align="center">
																	�߼�����Ա
																</div>
															</td>
													<%
														} else if(state.equals("2")){
													%>	
															<td width="13%">
																<div align="center">
																	����Ա
																</div>
															</td>
													<%
														} else if(state.equals("1")){
													%>			
															<td width="13%">
																<div align="center">
																	��ͨ�û�
																</div>
															</td>
													<%
														}
													%>
													<td width="9%">
														<div align="center">
															<a href="user?a=finduser&uid=<%=pu.getId()%>"><img src="./images/update1.gif"
																	width="20" height="20" border="0" alt="�޸�" />
															</a>
														</div>
													</td>
													<%
														if (state.equals("3")) {
													%>
															<td width="10%">
																<div align="center">
																	�޲���
																</div>
															</td>
															<td>
																<div align="center">
																	�޲���
																</div>
															</td>
													<%
														} else{
															if (del.trim().equals("1")) {
													%>
															<td width="10%">
																<div align="center">
																	<a href="./admin/changesuperuser.jsp?uid=<%=pu.getId()%>&superuser=<%=state%>"><img src="./images/Changeuser.gif" width="20" height="20" border="0" alt="��ɫ�޸�" />
																	</a>
																</div>
															</td>
														
															<td>
																<div align="center">
																	<a href="user?a=delsuser&uid=<%=pu.getId()%>&value=0" onclick="return confirm_oper();"><img src="./images/sz_tu02.gif" border="0" alt="�ָ�" />
																	</a>
																</div>
															</td>
													<%
															} else if(del.trim().equals("0")) {
													%>
															<td width="10%">
																<div align="center">
																	<a href="./admin/changesuperuser.jsp?uid=<%=pu.getId()%>&superuser=<%=state%>"><img src="./images/Changeuser.gif" width="20" height="20" border="0" alt="��ɫ�޸�" />
																	</a>
																</div>
															</td>
															<td>
																<div align="center">
																	<a href="user?a=delsuser&uid=<%=pu.getId()%>&value=1" onclick="return confirm_oper();"><img src="./images/sz_tu01.gif" border="0" alt="ɾ��" />
																	</a>
																</div>
															</td>
													<%
														 	}
														 }
													%>
												</tr>
									<%
										}
									%>
								</table>
								<table width="100%" height="100" border="0" cellpadding="0"
									cellspacing="0">
									<tr>
										<td valign="top" class="12">
											&nbsp;
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
					
				<%
					}else if(p != null && "2".equals(p.getSuperuser())){
				%>
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
											<div class="table_t">
												|&nbsp;&nbsp;��ӭ,
												<%=p.getUsername()%>
												&nbsp;&nbsp;|&nbsp;&nbsp;
												<a href="./login?a=out" class="table_t">ע��</a>&nbsp;&nbsp;|
											</div>
										</td>
										<td>
										<div>
										<a href="./user?a=all"><img src="./images/userlist.jpg" border="0" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="./product?a=all"><img src="./images/productslist.jpg" border="0" /> </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="./product/mailmanager.jsp"><img src="./images/mailmanager.jpg" border="0" /> </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									    </div>
										</td>
									</tr>
								</table>
								<br />
								
								<table width="100%" border="0" cellspacing="1" cellpadding="0"
									class="mars">
									<tr bgcolor="#fba661" height="25">
										<td width="10%" bgcolor="#fba661">
											<div align="center">
												�û���
											</div>
										</td>
										<td width="13%" bgcolor="#fba661">
											<div align="center">
												Email
											</div>
										</td>
										<td width="12%" bgcolor="#fba661">
											<div align="center">
												�绰
											</div>
										</td>
										<td width="13%" bgcolor="#fba661">
											<div align="center">
												��˾����
											</div>
										</td>
										<td width="13%" bgcolor="#fba661">
											<div align="center">
												��ɫ
											</div>
										</td>
										<td width="9%" bgcolor="#fba661">
											<div align="center">
												�޸�
											</div>
										</td>
										<td width="10%" bgcolor="#fba661">
											<div align="center">
												״̬
											</div>
										</td>
									</tr>
									<%
											
											List<Usr> list = (List<Usr>) request.getAttribute("allproductlist");
											for(Usr pu : list){
												String state = pu.getSuperuser();
												String del = pu.getDelsoft();
									%>
												<tr bgcolor="#f3f3f3" height="25">
													<td width="10%">
														<div align="center">
															<%=pu.getUsername()%>
														</div>
													</td>
													<td width="13%">
														<div align="center">
															<%=pu.getEmail()%>
														</div>
													</td>
													<td width="12%">
														<div align="center">
															<%=pu.getTel()%>
														</div>
													</td>
													<td width="13%">
														<div align="center">
															<%=pu.getCompanyname()%>
														</div>
													</td>
													<%
														if (state.equals("3")) {
													%>
															<td width="13%">
																<div align="center">
																	�߼�����Ա
																</div>
															</td>
													<%
														} else if(state.equals("2")){
													%>	
															<td width="13%">
																<div align="center">
																	����Ա
																</div>
															</td>
													<%
														} else if(state.equals("1")){
													%>			
															<td width="13%">
																<div align="center">
																	��ͨ�û�
																</div>
															</td>
													<%
													}
													%>
													<%if(!state.equals("3")){ %>
														<td width="9%">
															<div align="center">
																<a href="user?a=finduser&uid=<%=pu.getId()%>"><img src="./images/update1.gif"
																		width="20" height="20" border="0" alt="�޸�" />
																</a>
															</div>
														</td>
													<%}else{ %>
														<td width="9%">
															<div align="center">
																�޲���
															</div>
														</td>
													<% }%>
													<%
														if (!state.equals("3")&&del.trim().equals("1")) {
													%>
															<td>
																<div align="center">
																	<a href="user?a=delsuser&uid=<%=pu.getId()%>&value=0" onclick="return confirm_oper();"><img src="./images/sz_tu02.gif" border="0" alt="�ָ�" />
																	</a>
																</div>
															</td>
													<%
														} else if(!state.equals("3")&&del.trim().equals("0")) {
													%>
															<td>
																<div align="center">
																	<a href="user?a=delsuser&uid=<%=pu.getId()%>&value=1" onclick="return confirm_oper();"><img src="./images/sz_tu01.gif" border="0" alt="ɾ��" />
																	</a>
																</div>
															</td>
													<%
														}else{
													%>
														<td width="9%">
															<div align="center">
																�޲���
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
								<table width="100%" height="100" border="0" cellpadding="0"
									cellspacing="0">
									<tr>
										<td valign="top" class="12">
											&nbsp;
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
				
				<%
					} else {//�������if��else 
				%>
						<center>
							<h3>
								�Բ�����û��Ȩ�޲鿴������
							</h3>
						</center>
				<%
					}
				%>
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
