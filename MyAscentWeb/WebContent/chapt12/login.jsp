<%@ page contentType="text/html; charset=GBK" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <!-- ����base��ǩ�󣬿��Ա���jsp���ڸ�Ŀ¼��ʱ���޷������ύ��servlet������ -->
    <base href="<%=basePath%>">
<title>
login
</title>
</head>
<body bgcolor="#ffffff">
<h1>
��ӭ����������꣡
</h1>

<% String value = (String)request.getAttribute("error");
   if(value!=null){
   	out.println("������ʾ��Ϣ"+value);
     }
  
%>
<form action="NewLogin" method="post" >
<br><br>
  �û��� <input type="text" name="usename" ><br>
 ���� <input type="password"name="password"><br>
<input type="submit" name="Submit1" value="��¼">
<input type="submit" name="Submit2" value="ע��">
</form>
</body>
</html>
