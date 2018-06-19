<%@ page contentType="text/html;charset=GB2312" %>
<html>
<head><title>÷ÿ∂®œÚ≤‚ ‘</title></head>
<body>
<%
String address = request.getParameter("where");
if(address!=null){
if(address.equals("AscentTech")) 
  response.sendRedirect("http://www.ascenttech.com.cn");
 else if(address.equals("Microsoft")) 
   response.sendRedirect("http://www.microsoft.com");
  else if(address.equals("Sun")) 
   response.sendRedirect("http://www.sun.com");
}
%>
<b>Please select:</b><br>
<form action="" method="GET">
<select name="where">
  <option value="AscentTech" selected>go to Ascent Tech
  <option value="Sun" > go to Sun
  <option value="Microsoft" > go to Microsoft
</select>
<input type="submit" value="go">
</form>
</body>
</html>
