<%@ page language="java" import="java.util.*,com.ascent.bean.*"
	contentType="text/html;charset=gb2312" errorPage="./error.jsp"%>
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
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<link rel="stylesheet" href="./css/andreas08(blue).css"
			type="text/css" media="screen,projection" />

		<script language="javascript">
function addshop(str) {
	var pid = str;
	send_request('./shopcart?a=add&pid=' + pid);
}

var http_request = false;
function send_request(url) { //��ʼ����ָ������������������ĺ���
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
											<a href="./product/register.jsp"
												class="table_t">ע��</a>&nbsp;&nbsp;|&nbsp;&nbsp;
											<a href="javascript:history.go(-1)"><<< ����</a>
										</div>
									</td>
									<td width="15%">
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
											<a
												href="./product/Product_Search.jsp">��Ʒ��ѯ</a>
										</div>
									</td>
									<td width="20%">
										<div align="center">
											<a href="./shopcart?a=find">�鿴���ﳵ</a>
										</div>
									</td>


									<%
										} else { //ע���û�
									%>
									<td width="30%">
										<div align="left">
											|&nbsp;&nbsp;��ӭ,<%=p.getUsername()%>&nbsp;&nbsp;|&nbsp;&nbsp;
											<a href="./login?a=out" class="table_t">ע��</a>&nbsp;&nbsp;|&nbsp;&nbsp;
											<a href="javascript:history.go(-1)"><<< ����</a>
										</div>
									</td>
									<td width="15%">
										<div align="center">
											&nbsp;
										</div>
									</td>
									<td width="15%">
										<div align="center">
											<a
												href="./product/Product_Search.jsp">��Ʒ��ѯ</a>
										</div>
									</td>
									<td width="15%">
										<div align="center">
											<a href="./order?a=all">�鿴����</a>
										</div>
									</td>
									<td width="20%">
										<div align="center">
											<a href="./shopcart?a=find">�鿴���ﳵ</a>
										</div>
									</td>
									<%
										}
									%>
								</tr>
							</table>
							<br />

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
											����
										</div>
									</td>
								</tr>
								<%
									List<Product> list = (ArrayList) request.getAttribute("productlist");
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
									<td width="12%">
										<div align="center">
											<img
												src="<%=request.getContextPath() + "/upload/" + pu.getImagepath()%>"
												width="60" height="30" hspace="0" border="0" />
										</div>
									</td>
									<td width="13%">
										<div align="center">
											
											<button onclick="addshop(<%=id%>)">����</button>
										</div>
									</td>
								</tr>
								<%
									}
								%>
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
	</body>
</html>
