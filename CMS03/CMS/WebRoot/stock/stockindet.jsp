<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</head>

<body><br />
<div class="main">
<input type="text" />
 <a href="#"><img src="<%=path %>/image/search.png" />查询</a>
 <a href="#"><img  src="<%=path %>/image/add.png"/>添加</a>
</div>
<table class="table-integral main">
  <thead>
   <tr>
     <td>入库详细编号</td>
     <td>入库编号</td>
     <td>入库商品</td>
     <td>入库数量</td>
     <td style="width:200px">操作</td>
   </tr>
   </thead>
   
   <tbody>
   <c:forEach items="${list}" var="stockindet">
   <tr>
     <td>${stockindet.stockindet_id}</td>
     <td>${stockindet.stockin_id}</td>
     <td>${stockindet.pro_name}</td>
     <td>${stockindet.stockindet_count}</td>
     <td><a><img src="image/remove.png" />删除</a>
		<a><img src="image/pencil.png" />修改</a>
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