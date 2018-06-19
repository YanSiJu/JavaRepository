<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>EL隐含对象 param、paramValues</h2>
<fmt:requestEncoding value="UTF-8" />
 <c:out value="${pageContext.request.queryString }"/>
 
<br>姓名： <c:out value="${param.username}" /></br>
<br>密码： <c:out value="${param.password}" /></br>
<br>性别： <c:out value="${param.sex}" /></br>
<br>年龄： <c:out value="${param.old}" /></br>
<br>兴趣： <c:out value="${param.habit}" /></br>
<br>兴趣： 

<c:forEach var="parameter"  items="${paramValues.habit}" >
<c:out value="${parameter}"/>
</c:forEach>

 <c:forEach var='parameter' items='${paramValues}'>
         <ul>
             <li>
             <c:out value='${parameter.key}'/></b>:</li>
            <c:forEach var='value' items='${parameter.value}'>
               <c:out value='${value}'/>
           </c:forEach>
         </ul>
      </c:forEach>

</body>
</html>