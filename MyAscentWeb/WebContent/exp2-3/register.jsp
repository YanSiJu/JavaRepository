<%@ page language="java" contentType="text/html;charset=gb2312"
	errorPage="./error.jsp"%>
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
<title>ע��ҳ��</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link rel="stylesheet" href="./css/andreas08(blue).css" type="text/css"
	media="screen,projection" />


</head>
<body>
	<form name="form" method="post" action="exp2-3/registerHandler.jsp" />

	<table width="70%" class="mars" cellspacing="1" cellpadding="0"
		width="100%" border="0">
		<tbody>
			<tr>

				<td class="item" width="41%">
					<div align="right">�û���:</div>
				</td>
				<td width="7%"></td>
				<td width="52%"><input type="text" name="username"
					id="username"> &nbsp;&nbsp; <font color="red">*</font>

					<div id="usernameCheckDiv" class="warning"></div></td>
			</tr>

			<tr>

				<td class="item">
					<div align="right">����:</div>
				</td>
				<td width="7%"></td>
				<td><input type="password" name="password" id="password">
					&nbsp;&nbsp; <font color="red">*</font></td>
			</tr>

			<tr>

				<td class="item">
					<div align="right">����ȷ��:</div>
				</td>
				<td width="7%"></td>
				<td><input type="password" name="password2" id="password2">
					&nbsp;&nbsp; <font color="red">*</font></td>
			</tr>

			<tr>

				<td class="item">
					<div align="right">��˾����:</div>
				</td>
				<td width="7%"></td>
				<td><input type="text" name="companyname" id="companyname" />
				</td>
			</tr>
			<tr>

				<td class="item">
					<div align="right">��˾��ַ:</div>
				</td>
				<td width="7%"></td>
				<td><input type="text" name="companyaddress"
					id="companyaddress" /></td>
			</tr>
			<tr>

				<td class="item">
					<div align="right">����:</div>
				</td>
				<td width="7%"></td>
				<td><input type="text" name="country" id="country" /></td>
			</tr>
			<tr>

				<td class="item">
					<div align="right">����:</div>
				</td>
				<td width="7%"></td>
				<td><input type="text" name="city" id="city" /></td>
			</tr>
			<tr>

				<td class="item">
					<div align="right">����:</div>
				</td>
				<td width="7%"></td>
				<td><input type="text" name="job" id="job" /></td>
			</tr>
			<tr>

				<td class="item">
					<div align="right">�绰:</div>
				</td>
				<td width="7%"></td>
				<td><input type="text" name="tel" id="tel" /></td>
			</tr>
			<tr>

				<td class="item">
					<div align="right">Zip:</div>
				</td>
				<td width="7%"></td>
				<td><input type="text" name="zip" id="zip" /></td>
			</tr>
			<tr>

				<td class="item">
					<div align="right">Email:</div>
				</td>
				<td width="7%"></td>
				<td><input type="text" name="email" id="email">
					&nbsp;&nbsp; <font color="red">*</font></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit" value="ע��"
					onClick="return check();" /> <input type="Reset" value="ȡ��" /></td>
			</tr>
	</table>

	</form>
</body>
</html>
