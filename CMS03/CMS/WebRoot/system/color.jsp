<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=path %>/css/table.css"  rel="stylesheet"/>
<title>无标题文档</title>
<style>
   a:active{ border:1px solid #000}
</style>
<script>
   function queryByName(){
      var name=document.getElementById("search").value;//获取查询输入框的value值
      var url="<%=path%>/ColorServlet?type=queryByName&name="+name;
      window.location=url;
   
   
   }
</script>
</head>

<body><br />
<div class="main">
<input type="text" id="search"/>
 <a onclick="queryByName()"><img src="<%=path %>/image/search.png" />查询</a>
 <a href="<%=path%>/system/colorAdd.jsp"><img  src="<%=path %>/image/add.png"/>添加</a>
</div>
<table class="table-integral main">
  <thead>
   <tr>
     <td style="width:150px">颜色编号</td>
     <td style="width:200px">颜色名称</td>
     <td style="width:200px">操作</td>
   </tr>
   </thead>
   <tbody>
   <c:forEach items="${list}" var="color">
   <tr>
     <td>${color.color_id}</td>
     <td>${color.color_name}</td>
     <td><a href="<%=path %>/ColorServlet?type=delete&colorId=${color.color_id}"><img src="<%=path %>/image/remove.png" />删除</a>
		<a href="<%=path %>/ColorServlet?type=queryId&colorId=${color.color_id}"><img src="<%=path %>/image/pencil.png" />修改</a>
     </td>
   </tr>
   </c:forEach>
   </tbody>
</table>
<div class="main">
  <div id="wrap" class="page_btn clear">
    <span class="page_box">
            <a class="prev">上一页</a>
            <span class="num">
            <span>1</span>
            <span>2</span>
            <span>3</span>
            <span>4</span>
            </span>
            <a class="next">下一页</a>
         共50条记录
         当前第1页
    </span>
  </div>
</div>
</body>
</html>
