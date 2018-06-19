<%@ page contentType="text/html; charset=gb2312" language="java" 
    import="java.sql.*" errorPage="" %>
<jsp:useBean id="calculator" scope="request" class="sample.SimpleCalculator">
<jsp:setProperty name="calculator" property="*"/>
</jsp:useBean>
<html>
<head><title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body> 
Result:<%
try{
     calculator.calculate();
     out.println(calculator.getFirst()+calculator.getOperator()+calculator.getSecond()+"="
     +calculator.getResult());
}catch(Exception e){
out.println(e.getMessage());
}
%>
<form action="calculate.jsp" method=get>
<table width="75%" border="1" bordercolor="#003300">
    <tr> <td>first param:</td>
    <td><input type=text name="first"></td>  </tr>
    <tr><td>operator:</td>
    <td><select name="operator">
	         <option value="+">+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>
	    </select>
	</td> </tr>
  <tr> <td>second param:</td>
    <td><input type=text name="second"></td>  </tr>
  <tr>    <td colspan="2" bgcolor="#CCCCCC"><input type=submit value=计算></td>
  </tr>
</table>
</form>
</body>
</html>
