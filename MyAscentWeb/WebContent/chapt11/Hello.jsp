<%@ page contentType="text/html; charset=GBK" %>
<jsp:useBean id="myBean" scope="request"  type="sample.CounterBean" />
Hello...感谢您第<jsp:getProperty name="myBean" property="count" />次光临！
