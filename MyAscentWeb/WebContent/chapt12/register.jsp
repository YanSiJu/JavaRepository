<%@ page contentType="text/html; charset=GBK" %><%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <!-- ����base��ǩ�󣬿��Ա���jsp���ڸ�Ŀ¼��ʱ���޷������ύ��servlet������ -->
    <base href="<%=basePath%>">
<title>
ע��
</title>
<link href="css/mycss.css" rel="stylesheet" type="text/css" />
<SCRIPT>
function checkform() {
  if (document.myform.username.value == "") {
     alert("You need to specify an user name");
     return(false);
  } else 
  if (document.myform.password.value == "") {
     alert("You need to specify a password");
     return(false);
  }else {
     return(true);
  }
}
</SCRIPT>
</head>
<body leftmargin=0 topmargin="0"  bottommargin="0" marginwidth="0" marginheight="0">
<div class="top"></div>
<div class="main1"></div>
<div class="main2"><center>
<h1>&nbsp;</h1>
<span class="bodyh1">��ע��:</span><br>
 <form name="myform" action="NewLogin" method="post" onSubmit="return checkform()">
  <input type="hidden" name="register" value="true"/>
  <span class="bodytxt">�� �� ��:</span> 
  <input type="text" name="username" />
  <br>
  <span class="bodytxt">��&nbsp;&nbsp;&nbsp; ��:</span>
  <input name="password" type="password" size="21" />
  <br>
  <span class="bodytxt">��&nbsp;&nbsp;&nbsp; ��:</span> 
  <input type="text" name="name" />
  <br>
  <span class="bodytxt">��&nbsp;&nbsp;&nbsp; ��:</span> 
  <input type="text" name="title" />
  <br>
  <span class="bodytxt">�ʼ���ַ:</span> 
  <input type="text" name="email" />
  <br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
  <input type="submit" name="Submit" value="�ύ">
  &nbsp;&nbsp; 
  <input type="reset" value="����"></center>
 </form> 
<div class="txt">��Ȩ���У���˼�ɿƼ���C��2005-2008</div>
</div>
<div class="main3"></div>
</body>
</html>
