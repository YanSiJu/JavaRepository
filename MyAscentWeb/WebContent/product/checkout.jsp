<%@ page language="java" import="java.util.*,com.ascent.bean.*,com.ascent.util.*" contentType="text/html;charset=gb2312" errorPage="./error.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
			<title>AscentWeb��������</title>
			<link rel="stylesheet" href="./css/andreas08(blue).css"
				type="text/css" media="screen,projection" />
			<script language="javascript">
</script>


		<script language="javascript">
function updateQuantity(obj, str) {
	var pid = str;
	var quantity = obj.value;
	//alert(pid);
	//alert(quantity);
	//return false;
	send_request("./shopcart?a=updateNum&pid=" + pid + "&quantity=" + quantity);
}

var http_request = false;
function send_request(url) { //��ʼ����ָ������������������ĺ���
	//alert("url\t"+url);
	http_request = false;
	//��ʼ��ʼ��XMLHttpRequest����
	if (window.XMLHttpRequest) { //Mozilla �����
		http_request = new XMLHttpRequest();
		if (http_request.overrideMimeType) {//����MiME���
			http_request.overrideMimeType('text/xml');
		}
	} else if (window.ActiveXObject) { // IE�����
		try {
			http_request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				http_request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}
	if (!http_request) { // �쳣����������ʵ��ʧ��
		window.alert("���ܴ���XMLHttpRequest����ʵ��.");
		return false;
	}
	http_request.onreadystatechange = processRequest;
	// ȷ����������ķ�ʽ��URL�Լ��Ƿ�ͬ��ִ���¶δ���
	http_request.open("POST", url, true);
	http_request.send(null);
}
// ��������Ϣ�ĺ���
function processRequest() {
	if (http_request.readyState == 4) { // �ж϶���״̬
		if (http_request.status == 200) { // ��Ϣ�Ѿ��ɹ����أ���ʼ������Ϣ
			var divhtml = http_request.responseText;
			alert(divhtml);
		}
	}

}
</script>

		<script language="javascript">
function check() {
	if (form.username.value == "") {
		alert("�û�������Ϊ�գ�");
		form.username.focus();
		return false;
	}
	if (form.tel.value != "") {
		var mobilereg = /^(((13[0-9]{1})+\d{8}))|(((15[0-9]{1})+\d{8}))$/;
		var telreg = /^(((0[0-9]{2})+(\-)+\d{8}))|(((0[0-9]{3})+(\-)+\d{8}))|(((0[0-9]{3})+(\-)+\d{7}))$/;
		var bl1 = mobilereg.test(form.tel.value);
		var bl2 = telreg.test(form.tel.value);
		if (bl1 || bl2) {
			return true;
		} else {
			alert("��������ȷ�ֻ���0xx-xxxxxxxx��ʽ�绰");
			form.tel.focus();
			return false;
		}
	}

	if (form.email.value == "") {
		alert("�������ʼ� ��");
		form.email.focus();
		return false;
	}

	var regm = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;//��֤Mail��������ʽ,^[a-zA-Z0-9_-]:��ͷ����Ϊ��ĸ,�»���,����,
	if (form.email.value != "" && !form.email.value.match(regm)) {
		alert("�ʼ���ʽ���ԣ������������룡");
		form.email.focus();
		return false;
	} else
		return true;
}
</script>
	</head>

	<body>
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

							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<%
										Usr p = (Usr) session.getAttribute("productuser");
										if (p == null) { //δע���û�
									%>
									<td width="30%">
										<div align="left">
											|&nbsp;&nbsp;��ӭ,�ο�&nbsp;&nbsp;|&nbsp;&nbsp;
											<a href="./product/register.jsp" class="table_t">ע��</a>&nbsp;&nbsp;|&nbsp;&nbsp;
											<a href="javascript:history.go(-1)"><<< ����</a>
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
											<a href="./product/checkout.jsp">��������</a>
										</div>
									</td>

									<%
										} else { //��ע���û�
									%>
									<td width="30%">
										<div align="left">
											|&nbsp;&nbsp;��ӭ,<%=p.getUsername()%>&nbsp;&nbsp;|&nbsp;&nbsp;
											<a href="./login?a=out" class="table_t">ע��</a>&nbsp;&nbsp;|&nbsp;&nbsp;
											<a href="javascript:history.go(-1)"><<< ����</a>
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
										}
									%>
								</tr>
							</table>
							<br>
							<br>
							<%
								Collection<CartItem> list = (Collection<CartItem>) session.getAttribute("shopcartlist");
								if (list == null || list.size() < 1) {
							%>

							<center>
								<h3>
									�������桰�������ѡ����Ʒ����������
								</h3>
							</center>
							<%
								} else {
							%>
							<!-- ��Ʒ�б� -->
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
											ɾ��
										</div>
									</td>
								</tr>

								<%
									for(CartItem item : list){
											Product pu = item.getProduct();
											int id = pu.getId();
											String num = item.getQuantity() + "";
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
										<div align="center"><%=pu.getRealstock()%></div>
									</td>
									<%
										if (num == null || num.equals("")) {
									%>
									<td width="13%">
										<div align="center">
											<input name="number" value="5g"
												onchange="updateQuantity(this,<%=id%>)" />
										</div>
									</td>
									<%
										} else {
									%>
									<td width="13%">
										<div align="center">
											<input name="number" value="<%=num%>"
												onchange="updateQuantity(this,<%=id%>)" />
										</div>
									</td>
									<%
										}
									%>
									<td width="13%">
										<div align="center">
											<a href="./shopcart?a=move&pid=<%=id%>">ɾ��</a>
										</div>
									</td>
								</tr>
								<%
									}
								%>


							</table>


							<form name="form" method="post" action="./order?a=checkout">
								<%
									if (p != null) { //��½�û�
								%>
								<input type="hidden" name="uid" value="<%=p.getId()%>">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr bgcolor="cccccc" height="20">
										<td>
											&nbsp;&nbsp;
											<font size="2">�û���Ϣ��</font>
										</td>
									</tr>
									<tr>
										<td>
											<div align="center">
												<table width="40%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td>
															<div align="right">
																�û����ƣ�
															</div>
														</td>
														<td>
															<input name="username" type="text" id="username" value="<%=p.getUsername()%>" readonly="true">
														</td>
													</tr>
													<tr>
														<td>
															<div align="right">
																���õ绰��
															</div>
														</td>
														<%
															if (p.getTel() == null || "".equals(p.getTel().trim())) {
														%>
														<td>
															<input name="tel" type="text" id="tel" value="">
														</td>
														<%
															} else {
														%>
														<td>
															<input name="tel" type="text" id="tel" value="<%=p.getTel()%>">
														</td>
														<%
															}
														%>
													</tr>
													<tr>
														<td>
															<div align="right">
																�������䣺
															</div>
														</td>
														<td>
															<input name="email" type="text" id="email" value="<%=p.getEmail()%>">
														</td>
													</tr>
													<tr>
														<td>
															<div align="right">
																��˾���ƣ�
															</div>
														</td>

														<%
															if (p.getCompanyname() == null || "".equals(p.getCompanyname())) {
														%>
														<td>
															<input name="companyname" type="text" id="companyname" value="">
														</td>
														<%
															} else {
														%>
														<td>
															<input name="companyname" type="text" id="companyname" value="<%=p.getCompanyname()%>">
														</td>
														<%
															}
														%>
													</tr>
													<tr>
														<td>
															<div align="right">
																��˾��ַ��
															</div>
														</td>

														<%
															if (p.getCompanyaddress() == null || "".equals(p.getCompanyaddress())) {
														%>
														<td>
															<input name="companyaddress" type="text" id="companyaddress" value="">
														</td>
														<%
															} else {
														%>
														<td>
															<input name="companyaddress" type="text" id="companyaddress" value="<%=p.getCompanyaddress()%>">
														</td>
														<%
															}
														%>
													</tr>
													<tr>
														<td colspan="2">
															<div align="center">
																<input type="submit" name="Submit" value="�ύ">
																&nbsp;&nbsp;&nbsp;&nbsp;
																<input name="reset" type="submit" id="reset" value="ȡ��">
															</div>
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>
								</table>

								<%
									} else {//δ��½�û�
								%>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr bgcolor="cccccc" height="20">
										<td>
											&nbsp;&nbsp;
											<font size="3">�û���Ϣ��</font><font color="red">(ע���û����Ե�½����������/δע���û�����ע���½��ֱ����д��Ϣ)</font>
										</td>
									</tr>
									<tr>
										<td>
											<div align="center">
												<table width="40%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td>
															<div align="right">
																�û����ƣ�
															</div>
														</td>
														<td>
															<input name="username" type="text" id="username" value="">
														</td>
													</tr>
													<tr>
														<td>
															<div align="right">
																���õ绰��
															</div>
														</td>
														<td>
															<input name="tel" type="text" id="tel" value="">
														</td>
													</tr>
													<tr>
														<td>
															<div align="right">
																�������䣺
															</div>
														</td>
														<td>
															<input name="email" type="text" id="email" value="">
														</td>
													</tr>
													<tr>
														<td>
															<div align="right">
																��˾���ƣ�
															</div>
														</td>
														<td>
															<input name="companyname" type="text" id="companyname"
																value="">
														</td>
													</tr>
													<tr>
														<td>
															<div align="right">
																��˾��ַ��
															</div>
														</td>
														<td>
															<input name="companyaddress" type="text"
																id="companyaddress" value="">
														</td>
													</tr>
													<tr>
														<td colspan="2">
															<div align="center">
																<input type="submit" name="Submit" value="�ύ"
																	onclick="return check();">
																&nbsp;&nbsp;&nbsp;&nbsp;
																<input name="reset" type="reset" id="reset" value="ȡ��">
															</div>
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>
								</table>

								<%
									}
									}
								%>
							</form>
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

