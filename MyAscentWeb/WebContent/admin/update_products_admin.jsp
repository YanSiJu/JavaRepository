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

		<script language="javascript">
function updateProducts() {
	if (form.productId.value == "") {
		alert("��Ų���Ϊ�� ��");
		form.productId.focus();
		return false;
	}
	if (form.productname.value == "") {
		alert("��Ʒ���Ʋ���Ϊ�� ��");
		form.productname.focus();
		return false;
	}
	if (form.catalogno.value == "") {
		alert("catalogno ����Ϊ�� ��");
		form.catalogno.focus();
		return;
	}
	if (form.cas.value == "") {
		alert("CAS ����Ϊ�� ��");
		form.cas.focus();
		return false;
	}
	if (form.mdlnumber.value == "") {
		alert("MDLNumber ����Ϊ�� ��");
		form.mdlnumber.focus();
		return false;
	}
	if (form.newproduct.value == "") {
		alert("�²�Ʒ����ѡ�� ��");
		form.newproduct.focus();
		return false;
	}
	if (form.formula.value == "") {
		alert("formula �������� ��");
		form.formula.focus();
		return false;
	}
	if (form.mw.value == "") {
		alert("MW �������� ��");
		form.mw.focus();
		return false;
	}
	if (form.category.value == "") {
		alert("category �������룡");
		form.category.focus();
		return false;
	}
	if (form.price1.value == "") {
		alert("������۸�1 ��");
		form.price1.focus();
		return false;
	}
	if (form.stock.value == "") {
		alert("������ stock ��");
		form.stock.focus();
		return false;
	}
	if (form.price2.value == "") {
		alert("������ �۸�2 ��");
		form.price2.focus();
		return false;
	}
	if (form.realstock.value == "") {
		alert("������ realstock ��");
		form.realstock.focus();
		return false;
	}
	return true;
}
</script>
	</head>

	<body>
		<form name="form" method="post" action="./product?a=update"
			enctype="multipart/form-data">
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
												�ҵ�λ��&gt;&gt;�����������&gt;��Ʒ�޸�
												<br />
											</div>
											<DIV class=padding>
												<DIV id=middlebody>
													<%
														Usr p = (Usr) session.getAttribute("productuser");
														if ((p != null && p.getSuperuser().equals("3"))||p != null && p.getSuperuser().equals("2")) {
															Product product = (Product) request.getAttribute("pid_product");
															String newproduct = product.getIsnewproduct();
													%>
													<table width="100%">
														<tbody>
															<tr>
																<td height="10">
																	<div class="table_t">
																		|&nbsp;&nbsp;��ӭ,<%=p.getUsername()%>&nbsp;&nbsp;|&nbsp;&nbsp;
																		<a href="./login?a=out" class="table_t">ע��</a>&nbsp;&nbsp;|&nbsp;&nbsp;
																		<a href="javascript:history.back()"><<< ����</a>
																	</div>
																</td>
															</tr>
														</tbody>
													</table>
													<table class="mars" cellspacing="1" cellpadding="0"
														width="100%" border="0">
														<tbody>
															<tr>
																<td height="10" colspan="4">
																	<input name="pid" type="hidden" value="<%=product.getId()%>">
																</td>
															</tr>

															<tr>
																<td width="122" height="15" class="table_c">
																	<div align="right">
																		���:
																	</div>
																</td>
																<td width="122">
																	<input name="productnumber" type="text"
																		value="<%=product.getProductnumber()%>"/>
																</td>
																<td width="85" class="table_c">
																	<div align="right">
																		����:
																	</div>
																</td>
																<td width="163" height="15">
																	<input name="productname" type="text"
																		value="<%=product.getProductname()%>" />
																</td>
															</tr>
															<tr>
																<td width="122" height="15" class="table_c">
																	<div align="right">
																		CatalogNo:
																	</div>
																</td>
																<td width="122">
																	<input name="categoryno" type="text"
																		value="<%=product.getCategoryno()%>" />
																</td>
																<td width="85" class="table_c">
																	<div align="right">
																		CAS:
																	</div>
																</td>
																<td width="163" height="15">
																	<input name="cas" type="text"
																		value="<%=product.getCas()%>" />
																</td>
															</tr>

															<tr>
																<td width="122" height="15" class="table_c">
																	<div align="right">
																		MDL Number:
																	</div>
																</td>
																<td width="122">
																	<input name="mdlnumber" type="text"
																		value="<%=product.getMdlint()%>" />
																</td>
																<td width="85" class="table_c">
																	<div align="right">
																		�²�Ʒ:
																	</div>
																</td>

																<%
																	if ("0".equals(newproduct)) {
																%>
																<td height="15" class="table_c">
																	��:
																	<input type="radio" name="newproduct" value="1" />
																	��:
																	<input type="radio" name="newproduct" value="0" checked />
																</td>
																<%
																	}else {
																%>
																<td height="15" class="table_c">
																	��:
																	<input type="radio" name="newproduct" value="1" checked />
																	��:
																	<input type="radio" name="newproduct" value="0" />
																</td>
																<%
																	}
																%>
															</tr>
															<tr>
																<td width="122" height="15" class="table_c">
																	<div align="right">
																		Formula:
																	</div>
																</td>
																<td width="122">
																	<input name="formula" type="text"
																		value="<%=product.getFormula()%>" />
																</td>
																<td width="85" class="table_c">
																	<div align="right">
																		����:
																	</div>
																</td>
																<td width="163" height="15">
																	<input name="weight" type="text"
																		value="<%=product.getWeight()%>" />
																</td>
															</tr>
															<tr>
																<td width="122" height="15" class="table_c">
																	<div align="right">
																		����:
																	</div>
																</td>
																<td width="122">
																	<input name="category"
																		value="<%=product.getCategory()%>" type="text" />
																</td>
																<td width="85" class="table_c">
																	<div align="right">
																		��ע:
																	</div>
																</td>
																<td width="163" height="15">
																	<%
																		if (product.getNote() == null) {
																	%>
																	<input name="note" type="text" value="" />
																	<%
																		} else {
																	%>
																	<input name="note" id="" type="text"
																		value="<%=product.getNote()%>" />
																	<%
																		}
																	%>
																</td>
															</tr>
															<tr>
																<td width="122" height="15" class="table_c">
																	<div align="right">
																		��Ǯ1:
																	</div>
																</td>
																<td width="122">
																	<input name="price1" type="text"
																		value="<%=product.getPrice1()%>" />
																</td>
																<td width="85" class="table_c">
																	<div align="right">
																		Stock:
																	</div>
																</td>
																<td width="163" height="35">
																	<input name="stock" type="text"
																		value="<%=product.getStock()%>" />
																</td>
															</tr>
															<tr>
																<td width="122" height="15" class="table_c">
																	<div align="right">
																		�۸�2:
																	</div>
																</td>
																<td width="122">
																	<input name="price2" type="text"
																		value="<%=product.getPrice2()%>" />
																</td>
																<td width="85" class="table_c">
																	<div align="right">
																		Real Stock:
																	</div>
																</td>
																<td width="163" height="15">
																	<input name="realstock" type="text"
																		value="<%=product.getRealstock()%>" />
																</td>
															</tr>

															<tr>
																<td width="85" class="table_c">
																	<div align="right">
																		ͼƬ:
																	</div>
																</td>
																<td width="163" height="15">
																	<input type="file" name="upload" />
																	<div class="img">
																		<img src="./upload/<%=product.getImagepath()%>" width="100" height="50" />
																	</div>
																</td>
															</tr>
															<tr>
																<td height="15" colspan="4">
																	<div align="center">
																		<div class="loading_ll">
																			<input type="image" src="./images/update1.jpg" onclick="return updateProducts();" border="0" alt="�޸�" />
																		</div>
																	</div>
																</td>
															</tr>

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