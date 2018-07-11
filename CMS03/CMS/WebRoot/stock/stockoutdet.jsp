<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<input type="text" id="search"/>
 <a><img src="<%=path %>/image/search.png" />查询</a>
 <a><img  src="<%=path %>/image/add.png"/>添加</a>
</div>
<table class="table-integral main">
  <thead>
   <tr>
     <td style="width:150px">出库详细编号</td>
     <td style="width:200px">出库编号</td>
     <td style="width:200px">商品名称</td>
     <td style="width:200px">出库数量</td>
     <td style="width:400px">操作</td>
   </tr>
   </thead>
   <tbody>
   <c:forEach items="${pageBean.list}" var="stockoutdet">
   <tr>
     <td>${stockoutdet.stockoutdet_id}</td>
     <td>${stockoutdet.stockout_id}</td>
     <td>${stockoutdet.pro_name}</td>
     <td>${stockoutdet.stockoutdet_count}</td>
     <td><a href=""><img src="<%=path %>/image/remove.png" />删除</a>
		<a href=""><img src="<%=path %>/image/pencil.png" />修改</a>
     </td>
   </tr>
   </c:forEach>
   </tbody>
</table>
<div class="main">
  <div id="wrap" class="page_btn clear">
    <span class="page_box">
            <a id="prev" class="prev" href="<%=path %>/StockoutDet?page=${pageBean.page-1}&pageSize=5">上一页</a>
            <a id="next" class="next" href="<%=path %>/StockoutDet?page=${pageBean.page+1}&pageSize=5">下一页</a>
            
         共${pageBean.count}条记录
         当前第${pageBean.page}页
    </span>
  </div>
</div>
<script>
  var count=${pageBean.count};
  var page=${pageBean.page};
  var n=count/5;
  if(page==1){
   document.getElementById("prev").href="#";
  }
  
  if(page>=n){
  document.getElementById("next").href="#";
  }
</script>
</body>
</html>
