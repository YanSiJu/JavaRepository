<%@ page contentType="text/html; charset=GBK" %><%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <!-- 加上base标签后，可以避免jsp不在根目录下时，无法正常提交给servlet的问题 -->
    <base href="<%=basePath%>">
<title>
注册
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
<span class="bodyh1">请注册:</span><br>
 <form name="myform" action="NewLogin" method="post" onSubmit="return checkform()">
  <input type="hidden" name="register" value="true"/>
  <span class="bodytxt">用 户 名:</span> 
  <input type="text" name="username" />
  <br>
  <span class="bodytxt">密&nbsp;&nbsp;&nbsp; 码:</span>
  <input name="password" type="password" size="21" />
  <br>
  <span class="bodytxt">姓&nbsp;&nbsp;&nbsp; 名:</span> 
  <input type="text" name="name" />
  <br>
  <span class="bodytxt">称&nbsp;&nbsp;&nbsp; 呼:</span> 
  <input type="text" name="title" />
  <br>
  <span class="bodytxt">邮件地址:</span> 
  <input type="text" name="email" />
  <br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
  <input type="submit" name="Submit" value="提交">
  &nbsp;&nbsp; 
  <input type="reset" value="重置"></center>
 </form> 
<div class="txt">版权所有：亚思晟科技（C）2005-2008</div>
</div>
<div class="main3"></div>
</body>
</html>
